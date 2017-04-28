package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.VideoFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A16343 on 2017/4/28.
 */

public class VideoFormatAdapter extends BaseAdapter {
    private List<VideoFormat> videoFormats = new ArrayList<>();
    private Context mContext;

    public VideoFormatAdapter(Context context) {
        mContext = context;
        videoFormats.add(VideoFormat.MOV);
        videoFormats.add(VideoFormat.MP4);
    }

    @Override
    public int getCount() {
        return null == videoFormats ? 0 : videoFormats.size();
    }

    @Override
    public Object getItem(int position) {
        return videoFormats.get(position);
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

        textView.setText(videoFormats.get(position).toString());

        return convertView;
    }
}
