package com.autel.sdksample.mission;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;

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

import java.util.ArrayList;


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
    }

    private void attachTapListener() {
        mAmap.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                onAbsMapClick(latLng.latitude, latLng.longitude);
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
            mOrbitMarker.setPosition(new LatLng(lat, lot));
        } else {
            MarkerOptions markerOption = new MarkerOptions();
            markerOption.position(new LatLng(lat, lot));
            markerOption.draggable(false);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.favor_marker_point);
            markerOption.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
            mOrbitMarker = mAmap.addMarker(markerOption);
        }
    }

    @Override
    protected void resetMap() {
        mOrbitMarker = null;
        mDroneMarker = null;
        mPhoneMarker = null;
        autelLatLng = null;

        mAmap.clear();
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
        return mAmap.addMarker(markerOption);
    }

    private Polyline addWayPointLine(Waypoint start, LatLng end) {
        Polyline a = mAmap.addPolyline((new PolylineOptions()).add(new LatLng(start.getAutelCoord3D().getLatitude(), start.getAutelCoord3D().getLongitude()), end));
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
