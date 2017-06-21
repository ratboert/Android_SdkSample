package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.media.CameraAutoExposureLockState;
import com.autel.sdksample.adapter.SelectorAdapter;


public class AutoExposureLockStateAdapter extends SelectorAdapter<CameraAutoExposureLockState> {

    public AutoExposureLockStateAdapter(Context context) {
        super(context);
        elementList.add(CameraAutoExposureLockState.LOCK);
        elementList.add(CameraAutoExposureLockState.UNLOCK);
        elementList.add(CameraAutoExposureLockState.DISABLE);
    }
}
