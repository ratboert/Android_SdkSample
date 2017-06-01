package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.PhotoAEBCount;

import java.util.ArrayList;
import java.util.List;


public class PhotoAEBCountAdapter extends SelectorAdapter<PhotoAEBCount> {

    public PhotoAEBCountAdapter(Context context) {
        super(context);
        elementList.add(PhotoAEBCount.CAPTURE_3);
        elementList.add(PhotoAEBCount.CAPTURE_5);
    }
}
