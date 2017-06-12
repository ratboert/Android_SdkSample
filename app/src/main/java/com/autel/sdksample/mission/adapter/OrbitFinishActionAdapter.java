package com.autel.sdksample.mission.adapter;

import android.content.Context;

import com.autel.common.mission.OrbitFinishedAction;
import com.autel.common.mission.WaypointFinishedAction;
import com.autel.sdksample.adapter.SelectorAdapter;

public class OrbitFinishActionAdapter extends SelectorAdapter<OrbitFinishedAction> {

    public OrbitFinishActionAdapter(Context context) {
        super(context);
        elementList.add(OrbitFinishedAction.HOVER);
        elementList.add(OrbitFinishedAction.RETURN_HOME);
    }
}
