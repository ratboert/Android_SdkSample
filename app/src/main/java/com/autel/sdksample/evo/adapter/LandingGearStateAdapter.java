package com.autel.sdksample.evo.adapter;

import android.content.Context;

import com.autel.common.flycontroller.LandingGearState;
import com.autel.sdksample.base.adapter.SelectorAdapter;

public class LandingGearStateAdapter extends SelectorAdapter<LandingGearState> {

    public LandingGearStateAdapter(Context context) {
        super(context);
        elementList.add(LandingGearState.EXTEND);
        elementList.add(LandingGearState.PACK_UP);
        elementList.add(LandingGearState.UNKNOWN);
    }
}
