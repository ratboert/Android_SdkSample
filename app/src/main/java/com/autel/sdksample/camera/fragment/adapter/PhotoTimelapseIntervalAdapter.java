package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.PhotoTimelapseInterval;

import java.util.ArrayList;
import java.util.List;


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
