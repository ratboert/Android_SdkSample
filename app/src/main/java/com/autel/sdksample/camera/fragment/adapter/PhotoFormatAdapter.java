package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.base.PhotoFormat;

import java.util.ArrayList;
import java.util.List;


public class PhotoFormatAdapter extends SelectorAdapter<PhotoFormat> {

    public PhotoFormatAdapter(Context context) {
        super(context);
        elementList.add(PhotoFormat.JPEG);
        elementList.add(PhotoFormat.RAW);
        elementList.add(PhotoFormat.RawAndJPEG);
    }

}
