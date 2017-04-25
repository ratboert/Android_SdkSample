package com.autel.sdksample.view.mission;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.mission.AutelCoord3D;
import com.autel.common.mission.Waypoint;
import com.autel.sdk.Autel;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdksample.R;
import com.autel.sdksample.view.mission.fragment.FollowMissionFragment;
import com.autel.sdksample.view.mission.fragment.OrbitMissionFragment;
import com.autel.sdksample.view.mission.fragment.WaypointMissionFragment;
import com.autel.util.log.AutelLog;

import java.util.ArrayList;
import java.util.List;


public abstract class MapActivity extends FragmentActivity {
    public interface LocationChangeListener {
        void locationChanged(Location location);
    }

    public interface WaypointHeightListener {
        int fetchHeight();
    }

    public static final float MapInitZoomSize = 18.0f;
    final String TAG = getClass().getSimpleName();
    LocationManager mLocationManager;
    LocationListener mLocationListener;
    LocationListener netLocationListener;
    MissionManager missionManager;

    Spinner missionTypeSpinner;
    TextView flyModeInfo;
    TextView missionModeInfo;

    MissionType missionType = MissionType.WAYPOINT;

    private LocationChangeListener locationChangeListener;
    private WaypointHeightListener waypointHeightListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_map);
        registerPhoneGPS();
        initUi();
        initAircraftListener();
    }


    private void initUi() {
        missionTypeSpinner = (Spinner) findViewById(R.id.missionTypeSpinner);
        missionTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("spinnertest", "position " + position);
                missionType = MissionType.find(position);
                changePage(missionType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        flyModeInfo = (TextView) findViewById(R.id.flyModeInfo);
        missionModeInfo = (TextView) findViewById(R.id.missionModeInfo);
    }

    public void updateMissionInfo(String info) {
        missionModeInfo.setText(info);
    }


    private void changePage(MissionType type) {
        Class target;
        switch (type) {
            case WAYPOINT:
                target = WaypointMissionFragment.class;
                break;
            case ORBIT:
                target = OrbitMissionFragment.class;
                break;
            case FOLLOW:
                target = FollowMissionFragment.class;

                break;
            default:
                target = WaypointMissionFragment.class;
        }

        resetMap();

        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.mission_item_content, (Fragment) target.newInstance()).commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void setMapContentView(@LayoutRes int layoutResID) {
        ((ViewGroup) findViewById(R.id.layoutParent)).addView(View.inflate(this, layoutResID, null), 0);
    }

    private void initAircraftListener() {
        Autel.getFlyController().setFlyControllerInfoListener(new CallbackWithOneParam<FlyControllerInfo>() {
            @Override
            public void onSuccess(FlyControllerInfo flyControllerInfo) {
                Message msg = handler.obtainMessage();
                msg.obj = flyControllerInfo.getFlyControllerStatus().getFlyMode();
                handler.sendMessage(msg);

                if (null != flyControllerInfo.getGPSInfo()) {
                    AutelCoord3D coord3D = flyControllerInfo.getGPSInfo().getCoord();
                    if (null != coord3D) {
                        updateAircraftLocation(coord3D.getLatitude(), coord3D.getLongitude());
                    }
                }

            }

            @Override
            public void onFailure(AutelError autelError) {
                Log.v("initAircraftListener", " setFlyControllerInfoListener " + autelError.getDescription());
            }
        });
    }

    public String getLowAccuracyProvider() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_LOW);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        return mLocationManager.getBestProvider(criteria, true);
    }

    private void registerPhoneGPS() {
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mLocationListener = new LocationListener() {

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                AutelLog.e("PhoneGPS", "status = " + status);
            }

            @Override
            public void onProviderEnabled(String provider) {
                AutelLog.e("PhoneGPS", "onProviderEnabled  " + provider);
            }

            @Override
            public void onProviderDisabled(String provider) {
                AutelLog.e("PhoneGPS", "onProviderDisabled  " + provider);
            }

            @Override
            public void onLocationChanged(Location location) {
                notifyPhoneLocationChanged(location);
            }
        };

        netLocationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                notifyPhoneLocationChanged(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        try {
            if (mLocationManager != null) {
                if (mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 123);
                    } else {
                        mLocationManager.requestLocationUpdates(getLowAccuracyProvider(), 500, 0, mLocationListener);
                        mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 0, netLocationListener);
                        AutelLog.e("PhoneGPS", "status = " + "isProviderEnabled GPS_PROVIDER");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void notifyPhoneLocationChanged(Location location) {
        phoneLocationChanged(location);
        if (null != locationChangeListener) {
            locationChangeListener.locationChanged(location);
        }
    }


    public void setLocationChangeListener(LocationChangeListener locationChangeListener) {
        this.locationChangeListener = locationChangeListener;
    }

    public void setWaypointHeightListener(WaypointHeightListener waypointHeightListener) {
        this.waypointHeightListener = waypointHeightListener;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 123:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

                mLocationManager.requestLocationUpdates(getLowAccuracyProvider(), 500, 0, mLocationListener);
                mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 0, netLocationListener);
        }
    }

    List<Waypoint> wayPointList = new ArrayList<>();

    public List<Waypoint> getWaypointList() {
        /**
         * 深度复制
         */

        List<Waypoint> wpList = new ArrayList<>();
        Waypoint temp = null;
        for (Waypoint waypoint : wayPointList) {
            temp = waypoint.clone();
            AutelCoord3D coord3D = temp.getAutelCoord3D();
            if (null != coord3D) {
                AutelLatLng latLng = MapRectifyUtil.gcj2wgs(new AutelLatLng(coord3D.getLatitude(), coord3D.getLongitude()));
                temp.getAutelCoord3D().setLatitude(latLng.getLatitude());
                temp.getAutelCoord3D().setLongitude(latLng.getLongitude());
            }
            wpList.add(temp);
        }

        for (Waypoint waypoint : wpList) {
            Log.v("waypoint", "value test " + waypoint.getAutelCoord3D().getAltitude());
        }
        return wpList;
    }

    AutelLatLng autelLatLng = null;

    public AutelLatLng getOrbitPoint() {
        AutelLatLng latLng = MapRectifyUtil.gcj2wgs(autelLatLng);
        return latLng;
    }

    protected void onAbsMapClick(double lat, double lot) {
        switch (missionType) {
            case WAYPOINT:
                addWayPointMarker(lat, lot);
                break;
            case ORBIT:
                updateOrbit(lat, lot);
            default:
        }
    }

    private int getMaxWaypointHeight() {
        return waypointHeightListener == null ? 40 : waypointHeightListener.fetchHeight();
    }

    protected int addWaypoint(AutelLatLng latLng) {
//        AutelLatLng latLng1 = MapRectifyUtil.gcj2wgs(latLng);
        AutelCoord3D cd = new AutelCoord3D(latLng.latitude, latLng.longitude, getMaxWaypointHeight());
        Waypoint wp = new Waypoint(cd);
        wayPointList.add(wp);
        return wayPointList.indexOf(wp);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            flyModeInfo.setText("FlyMode : " + msg.obj);
        }
    };

    protected abstract void phoneLocationChanged(Location location);

    protected abstract void updateAircraftLocation(double lat, double lot);


    protected abstract void addWayPointMarker(double lat, double lot);

    protected abstract void resetMap();

    protected abstract void updateOrbit(double lat, double lot);


}
