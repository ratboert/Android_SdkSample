package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.CameraAutoExposureLockState;

import java.util.ArrayList;
import java.util.List;


public class AutoExposureLockStateAdapter extends SelectorAdapter<CameraAutoExposureLockState> {

    public AutoExposureLockStateAdapter(Context context) {
        super(context);
        elementList.add(CameraAutoExposureLockState.LOCK);
        elementList.add(CameraAutoExposureLockState.UNLOCK);
        elementList.add(CameraAutoExposureLockState.DISABLE);
    }
}
