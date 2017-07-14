package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.xb012.RealTimeVideoResolution;
import com.autel.sdksample.adapter.SelectorAdapter;


public class RealTimeResolutionAdapter extends SelectorAdapter<RealTimeVideoResolution> {

    public RealTimeResolutionAdapter(Context context) {
        super(context);
        elementList.add(RealTimeVideoResolution.P_1280X720);
        elementList.add(RealTimeVideoResolution.P_1920X1080);
    }
}
