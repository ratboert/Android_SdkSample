package com.autel.sdksample.view.mission.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.autel.sdksample.view.mission.MapActivity;

/**
 * Created by A16343 on 2017/4/18.
 */

public class WaypointMissionFragment extends MissionFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
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

        return view;
    }

    @Override
    protected AutelMission createAutelMission() {
        WaypointMission waypointMission = new WaypointMission();
        waypointMission.finishedAction = missionFinishedAction;
        waypointMission.speed = 4;
        waypointMission.finishReturnHeight = 20;
        waypointMission.wplist = ((MapActivity) getActivity()).getWaypointList();
        return waypointMission;
    }

    public void onDestroy() {
        super.onDestroy();
        Autel.getMissionManager().setRealTimeInfoListener(null);
    }
}
