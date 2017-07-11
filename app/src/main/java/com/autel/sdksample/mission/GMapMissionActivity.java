package com.autel.sdksample.mission;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.autel.common.mission.Waypoint;
import com.autel.sdksample.R;
import com.autel.sdksample.mission.widget.WaypointSettingDialog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;


public class GMapMissionActivity extends MapActivity {
    final String TAG = getClass().getSimpleName();
    MapView gMapView;
    private GoogleMap mGmap;
    boolean isFirstChangeToPhone = true;
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MapsInitializer.initialize(this);
        super.onCreate(savedInstanceState);
        setMapContentView(R.layout.activity_mission_gmap);
        gMapView = (MapView) findViewById(R.id.gMapView);
        gMapView.onCreate(savedInstanceState);
        mGmap = gMapView.getMap();
        attachTapListener();
    }

    public void onResume() {
        super.onResume();
        gMapView.onResume();
    }

    public void onPause() {
        super.onPause();
        gMapView.onPause();
    }


    public void onDestroy() {
        super.onDestroy();
        detachTapListener();
        gMapView.onDestroy();
        resetUI();
    }

    private synchronized void resetUI(){
        mMarkerList.clear();
        mOrbitMarker = null;
        mDroneMarker = null;
        mPhoneMarker = null;
    }

    private void attachTapListener() {
        mGmap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                onAbsMapClick(latLng.latitude, latLng.longitude);
            }
        });
        mGmap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                showWaypointSettingDialog(mMarkerList.indexOf(marker));
                return true;
            }
        });
    }

    private void showWaypointSettingDialog(int position) {
        WaypointSettingDialog waypointSettingDialog = new WaypointSettingDialog(this,position,wayPointList.get(position));
        waypointSettingDialog.showDialog();
        waypointSettingDialog.setOnConfirmClickListener(new WaypointSettingDialog.OnDialogOkClickListener() {
            @Override
            public void onDialogOkClick(double height, int delayTime, int position) {
                wayPointList.get(position).getAutelCoord3D().setAltitude(height);
                wayPointList.get(position).setDelay(delayTime);
            }
        });
    }

    private void detachTapListener() {
        mGmap.setOnMapClickListener(null);
    }

    @Override
    protected void phoneLocationChanged(Location location) {
        AutelLatLng all = MapRectifyUtil.wgs2gcj(new AutelLatLng(location.getLatitude(), location.getLongitude()));
        LatLng latLng = new LatLng(all.getLatitude(), all.getLongitude());
//        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        if (mGmap == null || mGmap.getCameraPosition() == null) {
            return;
        }
        if (isFirstChangeToPhone) {
            CameraPosition cp = new CameraPosition(latLng,
                    MapInitZoomSize,
                    0,
                    0);
            mGmap.moveCamera(CameraUpdateFactory.newCameraPosition(cp));
            isFirstChangeToPhone = false;
        }
        drawPhoneMarker(latLng);
    }

    @Override
    protected void updateAircraftLocation(double lat, double lot) {
        AutelLatLng latLng = MapRectifyUtil.wgs2gcj(new AutelLatLng(lat, lot));
        LatLng lng = new LatLng(latLng.latitude, latLng.longitude);
//        drawDroneMarker(lng);
        Message msg = handler.obtainMessage();
        msg.obj = lng;
        handler.sendMessage(msg);
    }





    protected ArrayList<Marker> mMarkerList = new ArrayList<>();

    @Override
    protected void addWayPointMarker(double lat, double lot) {
        LatLng latlng = new LatLng(lat, lot);
        int size = wayPointList.size();
        if (size > 0) {
            addWayPointLine(wayPointList.get(size - 1), latlng);
        }

        Marker temp = addMarkerWithLabel(latlng, addWaypoint(new AutelLatLng(lat, lot)));
        temp.setDraggable(true);
        mMarkerList.add(temp);
    }


    Marker mOrbitMarker;

    @Override
    protected void updateOrbit(double lat, double lot) {
        autelLatLng = new AutelLatLng(lat, lot);

        if (null != mOrbitMarker) {
            mOrbitMarker.setPosition(new LatLng(lat, lot));
        } else {
            MarkerOptions markerOption = new MarkerOptions();
            markerOption.position(new LatLng(lat, lot));
            markerOption.draggable(false);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.favor_marker_point);
            markerOption.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
            mOrbitMarker = mGmap.addMarker(markerOption);
        }
    }

    @Override
    protected void resetMap() {
        mOrbitMarker = null;
        mDroneMarker = null;
        mPhoneMarker = null;
        autelLatLng = null;

        mGmap.clear();
        wayPointList.clear();
    }

    private Marker addMarkerWithLabel(LatLng latlng, int mIndex) {
        MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(latlng);
        markerOption.draggable(false);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.marker_point);
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
//        float anchorWidth = getAnchorWidth(mIndex, bitmap);
//        markerOption.anchor(anchorWidth, 1.0f);
        return mGmap.addMarker(markerOption);
    }

    private Polyline addWayPointLine(Waypoint start, LatLng end) {
        Polyline a = mGmap.addPolyline((new PolylineOptions()).add(new LatLng(start.getAutelCoord3D().getLatitude(), start.getAutelCoord3D().getLongitude()), end));
        a.setColor(Color.GREEN);
        a.setWidth(10);
        return a;
    }

    Marker mDroneMarker;

    private void drawDroneMarker(LatLng dronell) {
        if (mDroneMarker == null) {
            MarkerOptions markerOption = new MarkerOptions();
            markerOption.position(dronell);
            markerOption.draggable(false);
            markerOption.icon(BitmapDescriptorFactory.fromResource(R.mipmap.drone_location_icon));
            markerOption.anchor(0.5f, 0.5f);
            if (null != mGmap) {
                mDroneMarker = mGmap.addMarker(markerOption);
            }
        } else {
            mDroneMarker.setPosition(dronell);
        }
    }

    Marker mPhoneMarker;

    private void drawPhoneMarker(LatLng phonell) {
        if (mPhoneMarker == null) {
            MarkerOptions markerOption = new MarkerOptions();
            markerOption.position(phonell);
            markerOption.draggable(false);
//            markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),
//                    R.mipmap.drone_location_icon)));
//            markerOption.anchor(0.5f, 0.5f);
            mPhoneMarker = mGmap.addMarker(markerOption);
        } else {
            mPhoneMarker.setPosition(phonell);
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            drawDroneMarker((LatLng) msg.obj);
        }
    };
}
