package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoStandard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A16343 on 2017/4/28.
 */

public class VideoStandardAdapter extends BaseAdapter {
    private List<VideoStandard> videoStandards = new ArrayList<>();
    private Context mContext;

    public VideoStandardAdapter(Context context) {
        mContext = context;
        videoStandards.add(VideoStandard.NTSC);
        videoStandards.add(VideoStandard.PAL);
    }

    @Override
    public int getCount() {
        return null == videoStandards ? 0 : videoStandards.size();
    }

    @Override
    public Object getItem(int position) {
        return videoStandards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = null;
        if (null == convertView) {
            textView = new TextView(mContext);
            convertView = textView;
        }else{
            textView = (TextView)convertView;
        }

        textView.setText(videoStandards.get(position).toString());

        return convertView;
    }
}
