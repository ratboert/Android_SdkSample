package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.media.CameraAntiFlicker;

public class AntiFlickerAdapter extends SelectorAdapter<CameraAntiFlicker> {

    public AntiFlickerAdapter(Context context) {
        super(context);
        elementList.add(CameraAntiFlicker.AUTO);
        elementList.add(CameraAntiFlicker.ANTI_FLICKER_50HZ);
        elementList.add(CameraAntiFlicker.ANTI_FLICKER_60HZ);
    }
}
