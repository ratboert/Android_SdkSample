package com.autel.sdksample.view.mission.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.mission.AutelMission;
import com.autel.common.mission.CurrentMissionState;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.WaypointMission;
import com.autel.common.mission.WaypointRealTimeInfo;
import com.autel.sdk.Autel;
import com.autel.sdksample.R;
import com.autel.sdksample.view.mission.MapActivity;

/**
 * Created by A16343 on 2017/4/18.
 */

public class WaypointMissionFragment extends MissionFragment {
    private EditText waypointSpeed;
    private EditText waypointReturnHeight;
    private EditText waypointHeight;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(R.layout.fragment_mission_menu_waypoint);
        Autel.getMissionManager().setRealTimeInfoListener(new CallbackWithTwoParams<CurrentMissionState, RealTimeInfo>() {
            @Override
            public void onSuccess(CurrentMissionState currentMissionState, RealTimeInfo realTimeInfo) {
                if (getActivity() != null)
                    ((MapActivity) getActivity()).updateMissionInfo("Mission state : " + currentMissionState);
            }

            @Override
            public void onFailure(AutelError autelError) {
                if (getActivity() != null)
                    ((MapActivity) getActivity()).updateMissionInfo("Mission state : " + autelError.getDescription());
            }
        });

        ((MapActivity) getActivity()).setWaypointHeightListener(new MapActivity.WaypointHeightListener() {
            @Override
            public int fetchHeight() {
                String valueHeight = waypointHeight.getText().toString();
                return isEmpty(valueHeight) ? 50 : Integer.valueOf(valueHeight);
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
        waypointMission.finishedAction = missionFinishedAction;
        String valueSpeed = waypointSpeed.getText().toString();
        waypointMission.speed = isEmpty(valueSpeed) ? 4 : Integer.valueOf(valueSpeed);
        String valueReturnHeight = waypointReturnHeight.getText().toString();
        waypointMission.finishReturnHeight = isEmpty(valueReturnHeight) ? 20 : Integer.valueOf(valueReturnHeight);

        waypointMission.wplist = ((MapActivity) getActivity()).getWaypointList();
        return waypointMission;
    }

    public void onDestroy() {
        super.onDestroy();
        Autel.getMissionManager().setRealTimeInfoListener(null);
    }

}
