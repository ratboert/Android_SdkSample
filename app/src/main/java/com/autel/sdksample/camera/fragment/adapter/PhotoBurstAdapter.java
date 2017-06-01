package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.PhotoBurstCount;

import java.util.ArrayList;
import java.util.List;


public class PhotoBurstAdapter extends SelectorAdapter<PhotoBurstCount> {

    public PhotoBurstAdapter(Context context) {
        super(context);
        elementList.add(PhotoBurstCount.BURST_3);
        elementList.add(PhotoBurstCount.BURST_5);
        elementList.add(PhotoBurstCount.BURST_7);
    }
}
