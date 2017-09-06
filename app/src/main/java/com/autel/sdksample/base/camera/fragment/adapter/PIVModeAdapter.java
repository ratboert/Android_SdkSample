package com.autel.sdksample.base.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.xb012.PIVMode;
import com.autel.sdksample.adapter.SelectorAdapter;


public class PIVModeAdapter extends SelectorAdapter<PIVMode> {

    public PIVModeAdapter(Context context) {
        super(context);
        elementList.add(PIVMode.Manual);
        elementList.add(PIVMode.Auto);
    }
}
