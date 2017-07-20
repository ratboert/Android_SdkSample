package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.CameraExposureMode;
import com.autel.sdksample.adapter.SelectorAdapter;

import java.util.Arrays;
import java.util.List;

public class ExposureModeAdapter extends SelectorAdapter<CameraExposureMode> {
    public ExposureModeAdapter(Context context) {
        super(context);
    }

    public ExposureModeAdapter(Context context, List<CameraExposureMode> modes) {
        super(context);
        elementList = modes;

    }
}
