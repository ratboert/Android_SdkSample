package com.autel.sdksample.base.mission.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;

import com.autel.common.mission.AutelMission;
import com.autel.common.mission.OrbitFinishedAction;
import com.autel.common.mission.OrbitMission;
import com.autel.sdksample.R;
import com.autel.sdksample.base.mission.AutelLatLng;
import com.autel.sdksample.base.mission.MapActivity;
import com.autel.sdksample.base.mission.adapter.OrbitFinishActionAdapter;


public class OrbitMissionFragment extends MissionFragment {
    EditText orbitSpeed;
    EditText orbitReturnHeight;
    EditText orbitCount;
    EditText orbitRadius;
    private OrbitFinishActionAdapter finishActionAdapter = null;
    private OrbitFinishedAction finishedAction = OrbitFinishedAction.HOVER;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(R.layout.fragment_mission_menu_orbit);
        orbitSpeed = (EditText) view.findViewById(R.id.orbitSpeed);
        orbitReturnHeight = (EditText) view.findViewById(R.id.orbitReturnHeight);
        orbitCount = (EditText) view.findViewById(R.id.orbitCount);
        orbitRadius = (EditText) view.findViewById(R.id.orbitRadius);

        finishActionAdapter = new OrbitFinishActionAdapter(getContext());
        finishActionSpinner.setAdapter(finishActionAdapter);
        finishActionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                finishedAction = (OrbitFinishedAction)parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
        orbitMission.finishReturnHeight = isEmpty(valueHeight) ? 40 : Integer.valueOf(valueHeight);
        orbitMission.finishedAction = finishedAction;
        String valueSpeed = orbitSpeed.getText().toString();
        orbitMission.speed = isEmpty(valueSpeed) ? 1 : Float.valueOf(valueSpeed);
        String valueRound = orbitCount.getText().toString();
        orbitMission.round = isEmpty(valueRound) ? 3 : Short.valueOf(valueRound);
        String valueRadius = orbitRadius.getText().toString();
        orbitMission.radius = isEmpty(valueRadius) ? 3 : Short.valueOf(valueRadius);
        return orbitMission;
    }
}
