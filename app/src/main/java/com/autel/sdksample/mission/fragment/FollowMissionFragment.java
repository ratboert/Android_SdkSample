package com.autel.sdksample.mission.fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.common.mission.AutelMission;
import com.autel.common.mission.CurrentMissionState;
import com.autel.common.mission.FollowMission;
import com.autel.common.mission.RealTimeInfo;
import com.autel.sdk.Autel;
import com.autel.sdksample.mission.MapActivity;

/**
 * Created by A16343 on 2017/4/18.
 */

public class FollowMissionFragment extends MissionFragment {
    FollowMission followMission;
    Location mLocation;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ((MapActivity) getActivity()).setLocationChangeListener(new MapActivity.LocationChangeListener() {
            @Override
            public void locationChanged(Location location) {
                mLocation = location;
                if (null != followMission) {
                    followMission.update(location);
                }
                Log.v("followTest", "location "+location);
            }
        });

        Autel.getMissionManager().setRealTimeInfoListener(new CallbackWithTwoParams<CurrentMissionState, RealTimeInfo>() {
            @Override
            public void onSuccess(CurrentMissionState currentMissionState, RealTimeInfo realTimeInfo) {
                if(getActivity()!=null)
                ((MapActivity) getActivity()).updateMissionInfo("Mission state : " + currentMissionState);
            }

            @Override
            public void onFailure(AutelError autelError) {
                if(getActivity()!=null)
                ((MapActivity) getActivity()).updateMissionInfo("Mission state : " + autelError.getDescription());
            }
        });

        return view;
    }

    @Override
    protected AutelMission createAutelMission() {
        followMission = FollowMission.create();
        followMission.location = mLocation;
        followMission.finishedAction = missionFinishedAction;
        followMission.finishReturnHeight = 20;
        return followMission;
    }

    public void onDestroy() {
        super.onDestroy();
        ((MapActivity) getActivity()).setLocationChangeListener(null);
        Autel.getMissionManager().setRealTimeInfoListener(null);
    }
}