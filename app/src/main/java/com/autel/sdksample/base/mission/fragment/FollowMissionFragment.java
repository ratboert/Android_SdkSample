package com.autel.sdksample.base.mission.fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;

import com.autel.common.mission.AutelMission;
import com.autel.common.mission.FollowFinishedAction;
import com.autel.common.mission.FollowMission;
import com.autel.sdksample.R;
import com.autel.sdksample.base.mission.MapActivity;
import com.autel.sdksample.base.mission.adapter.FollowFinishActionAdapter;


public class FollowMissionFragment extends MissionFragment {
    FollowMission followMission;
    Location mLocation;
    private FollowFinishActionAdapter finishActionAdapter = null;
    private FollowFinishedAction finishedAction = FollowFinishedAction.RETURN_HOME;
    EditText followReturnHeight;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(R.layout.fragment_mission_menu_follow);
        ((MapActivity) getActivity()).setLocationChangeListener(new MapActivity.LocationChangeListener() {
            @Override
            public void locationChanged(Location location) {
                mLocation = location;
                if (null != followMission) {
                    followMission.update(location);
                }
                Log.v("followTest", "location " + location);
            }
        });
        followReturnHeight = (EditText) view.findViewById(R.id.followReturnHeight);
        finishActionAdapter = new FollowFinishActionAdapter(getContext());
        finishActionSpinner.setAdapter(finishActionAdapter);
        finishActionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                finishedAction = (FollowFinishedAction)parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    protected AutelMission createAutelMission() {
        String valueHeight = followReturnHeight.getText().toString();
        followMission = FollowMission.create();
        followMission.location = mLocation;
        followMission.finishedAction = finishedAction;
        followMission.finishReturnHeight = isEmpty(valueHeight) ? 40 : Integer.valueOf(valueHeight);
        return followMission;
    }

    public void onDestroy() {
        super.onDestroy();
        ((MapActivity) getActivity()).setLocationChangeListener(null);
    }
}
