package com.autel.sdksample.mission;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.autel.common.mission.Waypoint;
import com.autel.sdksample.R;
import com.autel.sdksample.mission.widget.WaypointSettingDialog;

import java.util.ArrayList;
import java.util.List;


public class AMapMissionActivity extends MapActivity {
    final String TAG = getClass().getSimpleName();
    MapView aMapView;
    private AMap mAmap;
    boolean isFirstChangeToPhone = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMapContentView(R.layout.activity_mission_amap);
        aMapView = (MapView) findViewById(R.id.aMapView);
        aMapView.onCreate(savedInstanceState);
        mAmap = aMapView.getMap();
        attachTapListener();
    }

    public void onResume() {
        super.onResume();
        aMapView.onResume();
    }

    public void onPause() {
        super.onPause();
        aMapView.onPause();
    }


    public void onDestroy() {
        super.onDestroy();
        detachTapListener();
        aMapView.onDestroy();
        resetUI();
    }

    private void resetUI() {
        mMarkerList.clear();
    }

    private void attachTapListener() {
        mAmap.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                onAbsMapClick(latLng.latitude, latLng.longitude);
            }
        });
        mAmap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                showWaypointSettingDialog(mMarkerList.indexOf(marker));
                return true;
            }
        });
    }

    private void showWaypointSettingDialog(int position) {
        final WaypointSettingDialog waypointSettingDialog = new WaypointSettingDialog(this, position, wayPointList.get(position));
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
        mAmap.setOnMapClickListener(null);
    }

    @Override
    protected void phoneLocationChanged(Location location) {
        AutelLatLng all = MapRectifyUtil.wgs2gcj(new AutelLatLng(location.getLatitude(), location.getLongitude()));
        LatLng latLng = new LatLng(all.getLatitude(), all.getLongitude());
        if (mAmap == null || mAmap.getCameraPosition() == null) {
            return;
        }
        if (isFirstChangeToPhone) {
            mAmap.moveCamera(CameraUpdateFactory.changeLatLng(latLng));
            mAmap.moveCamera(com.amap.api.maps.CameraUpdateFactory.zoomTo(MapInitZoomSize));
            isFirstChangeToPhone = false;
        }
        drawPhoneMarker(latLng);
    }

    @Override
    protected void updateAircraftLocation(double lat, double lot) {
        AutelLatLng latLng = MapRectifyUtil.wgs2gcj(new AutelLatLng(lat, lot));
        LatLng lng = new LatLng(latLng.latitude, latLng.longitude);
        drawDroneMarker(lng);
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
            mOrbitMarker.destroy();
        }

        MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(new LatLng(lat, lot));
        markerOption.draggable(false);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.favor_marker_point);
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        mOrbitMarker = mAmap.addMarker(markerOption);

    }

    @Override
    protected void resetMap() {
        if (null != mOrbitMarker) {
            mOrbitMarker.destroy();
        }
        if (null != polyLines) {
            for (Polyline line : polyLines) {
                line.remove();
            }
            polyLines.clear();

        }

        if (null != mMarkerList) {
            for (Marker marker : mMarkerList) {
                marker.destroy();
            }
            mMarkerList.clear();
        }

        wayPointList.clear();
        autelLatLng = null;
    }

    private Marker addMarkerWithLabel(LatLng latlng, int mIndex) {
        MarkerOptions markerOption = new MarkerOptions();
        markerOption.position(latlng);
        markerOption.draggable(false);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.marker_point);
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
//        float anchorWidth = getAnchorWidth(mIndex, bitmap);
//        markerOption.anchor(anchorWidth, 1.0f);
        return mAmap.addMarker(markerOption);
    }

    private List<Polyline> polyLines = new ArrayList<>();

    private Polyline addWayPointLine(Waypoint start, LatLng end) {
        Polyline a = mAmap.addPolyline((new PolylineOptions()).add(new LatLng(start.getAutelCoord3D().getLatitude(), start.getAutelCoord3D().getLongitude()), end));
        a.setColor(Color.GREEN);
        a.setWidth(10);
        polyLines.add(a);
        return a;
    }

    Marker mDroneMarker;

    private void drawDroneMarker(LatLng dronell) {
        synchronized (AMapMissionActivity.class) {
            if (mDroneMarker == null) {
                MarkerOptions markerOption = new MarkerOptions();
                markerOption.position(dronell);
                markerOption.draggable(false);
                markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),
                        R.mipmap.drone_location_icon)));
                markerOption.anchor(0.5f, 0.5f);
                if (null != mAmap) {
                    mDroneMarker = mAmap.addMarker(markerOption);
                }
            } else {
                mDroneMarker.setPosition(dronell);
                mDroneMarker.setToTop();
            }
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
            mPhoneMarker = mAmap.addMarker(markerOption);
        } else {
            mPhoneMarker.setPosition(phonell);
        }
    }
}
