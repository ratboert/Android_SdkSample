package com.autel.sdksample.mission.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.common.mission.AutelMission;
import com.autel.common.mission.CurrentMissionState;
import com.autel.common.mission.OrbitMission;
import com.autel.common.mission.RealTimeInfo;
import com.autel.sdk.Autel;
import com.autel.sdksample.R;
import com.autel.sdksample.mission.AutelLatLng;
import com.autel.sdksample.mission.MapActivity;


public class OrbitMissionFragment extends MissionFragment {
    EditText orbitSpeed;
    EditText orbitReturnHeight;
    EditText orbitCount;
    EditText orbitRadius;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(R.layout.fragment_mission_menu_orbit);
        orbitSpeed = (EditText) view.findViewById(R.id.orbitSpeed);
        orbitReturnHeight = (EditText) view.findViewById(R.id.orbitReturnHeight);
        orbitCount = (EditText) view.findViewById(R.id.orbitCount);
        orbitRadius = (EditText) view.findViewById(R.id.orbitRadius);

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
        AutelLatLng autelLatLng = ((MapActivity) getActivity()).getOrbitPoint();
        if (null == autelLatLng) {
            return null;
        }
        OrbitMission orbitMission = new OrbitMission();
        orbitMission.lat = (float) autelLatLng.latitude;
        orbitMission.lng = (float) autelLatLng.longitude;

        String valueHeight = orbitReturnHeight.getText().toString();
        orbitMission.finishReturnHeight = isEmpty(valueHeight) ? 20 : Integer.valueOf(valueHeight);
        orbitMission.finishedAction = missionFinishedAction;
        String valueSpeed = orbitSpeed.getText().toString();
        orbitMission.speed = isEmpty(valueSpeed) ? 1 : Float.valueOf(valueSpeed);
        String valueRound = orbitCount.getText().toString();
        orbitMission.round = isEmpty(valueRound) ? 3 : Short.valueOf(valueRound);
        String valueRadius = orbitRadius.getText().toString();
        orbitMission.radius = isEmpty(valueRadius) ? 3 : Short.valueOf(valueRadius);
        return orbitMission;
    }

    public void onDestroy() {
        super.onDestroy();
        Autel.getMissionManager().setRealTimeInfoListener(null);
    }
}
