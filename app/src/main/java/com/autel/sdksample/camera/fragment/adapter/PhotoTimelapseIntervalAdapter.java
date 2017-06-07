package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.sdksample.adapter.SelectorAdapter;


public class PhotoTimelapseIntervalAdapter extends SelectorAdapter<PhotoTimelapseInterval> {

    public PhotoTimelapseIntervalAdapter(Context context) {
        super(context);
        elementList.add(PhotoTimelapseInterval.SECOND_5);
        elementList.add(PhotoTimelapseInterval.SECOND_7);
        elementList.add(PhotoTimelapseInterval.SECOND_10);
        elementList.add(PhotoTimelapseInterval.SECOND_20);
        elementList.add(PhotoTimelapseInterval.SECOND_30);
    }
}
