package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.PhotoStyleType;

import java.util.ArrayList;
import java.util.List;


public class PhotoStyleAdapter extends SelectorAdapter<PhotoStyleType> {

    public PhotoStyleAdapter(Context context) {
        super(context);
        elementList.add(PhotoStyleType.Standard);
        elementList.add(PhotoStyleType.Soft);
        elementList.add(PhotoStyleType.Landscape);
        elementList.add(PhotoStyleType.Custom);
    }
}
