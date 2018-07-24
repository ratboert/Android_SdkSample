package com.autel.sdksample.base.mission.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;

import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.AutelMission;
import com.autel.common.mission.xstar.Waypoint;
import com.autel.common.mission.xstar.WaypointFinishedAction;
import com.autel.common.mission.xstar.WaypointMission;
import com.autel.sdksample.R;
import com.autel.sdksample.base.mission.AutelLatLng;
import com.autel.sdksample.base.mission.MapActivity;
import com.autel.sdksample.base.mission.MapOperator;
import com.autel.sdksample.base.mission.MapRectifyUtil;
import com.autel.sdksample.base.mission.adapter.WaypointFinishActionAdapter;
import com.autel.sdksample.base.mission.widget.WaypointSettingDialog;

import java.util.ArrayList;
import java.util.List;


public abstract class WaypointMissionFragment extends MissionFragment {

    @SuppressLint("ValidFragment")
    public WaypointMissionFragment(MapOperator mMapOperator) {
        super(mMapOperator);
    }

    public WaypointMissionFragment() {
    }


    @Override
    public void onMapClick(double lat, double lot) {
        AutelLatLng latLng = MapRectifyUtil.gcj2wgs(new AutelLatLng(lat, lot));
        mMapOperator.addWayPointMarker(lat, lot);
        waypointAdded(latLng);
    }

    @Override
    public void onMarkerClick(int position) {
        Waypoint waypoint = getWaypoint(position);
        if(null == waypoint){
            return;
        }

        WaypointSettingDialog waypointSettingDialog = new WaypointSettingDialog(this.getActivity(), position, waypoint);
        waypointSettingDialog.showDialog();
    }

    protected abstract Waypoint getWaypoint(int index);

    protected abstract void waypointAdded(AutelLatLng latLng);
}
