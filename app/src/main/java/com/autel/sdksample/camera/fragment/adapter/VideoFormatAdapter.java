package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.VideoFormat;

import java.util.ArrayList;
import java.util.List;


public class VideoFormatAdapter extends SelectorAdapter<VideoFormat> {

    public VideoFormatAdapter(Context context) {
        super(context);
        elementList.add(VideoFormat.MOV);
        elementList.add(VideoFormat.MP4);
    }
}
