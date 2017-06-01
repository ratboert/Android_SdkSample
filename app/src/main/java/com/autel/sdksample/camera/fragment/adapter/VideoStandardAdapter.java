package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.VideoStandard;

import java.util.ArrayList;
import java.util.List;


public class VideoStandardAdapter extends SelectorAdapter<VideoStandard> {

    public VideoStandardAdapter(Context context) {
        super(context);
        elementList.add(VideoStandard.NTSC);
        elementList.add(VideoStandard.PAL);
    }

}
