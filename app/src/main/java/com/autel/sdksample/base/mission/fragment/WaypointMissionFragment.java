package com.autel.sdksample.base.mission.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;

import com.autel.common.mission.AutelMission;
import com.autel.common.mission.WaypointFinishedAction;
import com.autel.common.mission.WaypointMission;
import com.autel.sdksample.R;
import com.autel.sdksample.base.mission.MapActivity;
import com.autel.sdksample.base.mission.adapter.WaypointFinishActionAdapter;


public class WaypointMissionFragment extends MissionFragment {
    private EditText waypointSpeed;
    private EditText waypointReturnHeight;
    private EditText waypointHeight;
    private WaypointFinishActionAdapter finishActionAdapter = null;
    private WaypointFinishedAction finishedAction = WaypointFinishedAction.HOVER;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(R.layout.fragment_mission_menu_waypoint);

        ((MapActivity) getActivity()).setWaypointHeightListener(new MapActivity.WaypointHeightListener() {
            @Override
            public int fetchHeight() {
                String valueHeight = waypointHeight.getText().toString();
                return isEmpty(valueHeight) ? 50 : Integer.valueOf(valueHeight);
            }
        });
        finishActionAdapter = new WaypointFinishActionAdapter(getContext());
        finishActionSpinner.setAdapter(finishActionAdapter);
        finishActionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                finishedAction = (WaypointFinishedAction)parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        waypointSpeed = (EditText) view.findViewById(R.id.waypointSpeed);
        waypointReturnHeight = (EditText) view.findViewById(R.id.waypointReturnHeight);
        waypointHeight = (EditText) view.findViewById(R.id.waypointHeight);

        return view;
    }

    @Override
    protected AutelMission createAutelMission() {
        WaypointMission waypointMission = new WaypointMission();
        waypointMission.finishedAction = finishedAction;
        String valueSpeed = waypointSpeed.getText().toString();
        waypointMission.speed = isEmpty(valueSpeed) ? 4 : Integer.valueOf(valueSpeed);
        String valueReturnHeight = waypointReturnHeight.getText().toString();
        waypointMission.finishReturnHeight = isEmpty(valueReturnHeight) ? 40 : Integer.valueOf(valueReturnHeight);

        waypointMission.wpList = ((MapActivity) getActivity()).getWaypointList();
        return waypointMission;
    }
}
