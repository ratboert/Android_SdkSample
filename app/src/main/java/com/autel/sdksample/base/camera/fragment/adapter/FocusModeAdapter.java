package com.autel.sdksample.base.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.common.camera.media.ShutterMode;
import com.autel.sdksample.base.adapter.SelectorAdapter;

import java.util.Arrays;
import java.util.List;

public class FocusModeAdapter extends SelectorAdapter<LensFocusMode> {


    public FocusModeAdapter(Context context) {
        super(context);
        elementList.addAll(Arrays.asList(LensFocusMode.values()));
    }
}
