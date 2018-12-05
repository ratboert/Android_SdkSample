package com.autel.sdksample.evo.mission.adapter;

import android.content.Context;

import com.autel.common.mission.evo.EvoWaypointFinishedAction;
import com.autel.common.mission.evo.OrbitEntryPosition;
import com.autel.sdksample.base.adapter.SelectorAdapter;

public class EvoEntryDirectionAdapter extends SelectorAdapter<OrbitEntryPosition> {

    public EvoEntryDirectionAdapter(Context context) {
        super(context);
        elementList.add(OrbitEntryPosition.EAST);
        elementList.add(OrbitEntryPosition.NEAREST);
        elementList.add(OrbitEntryPosition.NORTH);
        elementList.add(OrbitEntryPosition.SOUTH);
        elementList.add(OrbitEntryPosition.WEST);
    }
}
