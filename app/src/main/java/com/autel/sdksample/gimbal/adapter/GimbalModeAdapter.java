package com.autel.sdksample.gimbal.adapter;

import android.content.Context;

import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.sdksample.adapter.SelectorAdapter;


public class GimbalModeAdapter extends SelectorAdapter<GimbalWorkMode> {

    public GimbalModeAdapter(Context context) {
        super(context);
        elementList.add(GimbalWorkMode.FPV);
        elementList.add(GimbalWorkMode.STABILIZED);
    }
}
