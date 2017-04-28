package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoTimelapseInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A16343 on 2017/4/28.
 */

public class PhotoTimelapseIntervalAdapter extends BaseAdapter {
    private List<PhotoTimelapseInterval> photoTimelapseIntervals = new ArrayList<>();
    private Context mContext;

    public PhotoTimelapseIntervalAdapter(Context context) {
        mContext = context;
        photoTimelapseIntervals.add(PhotoTimelapseInterval.SECOND_5);
        photoTimelapseIntervals.add(PhotoTimelapseInterval.SECOND_7);
        photoTimelapseIntervals.add(PhotoTimelapseInterval.SECOND_10);
        photoTimelapseIntervals.add(PhotoTimelapseInterval.SECOND_20);
        photoTimelapseIntervals.add(PhotoTimelapseInterval.SECOND_30);
    }

    @Override
    public int getCount() {
        return null == photoTimelapseIntervals ? 0 : photoTimelapseIntervals.size();
    }

    @Override
    public Object getItem(int position) {
        return photoTimelapseIntervals.get(position);
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

        textView.setText(photoTimelapseIntervals.get(position).toString());

        return convertView;
    }
}
