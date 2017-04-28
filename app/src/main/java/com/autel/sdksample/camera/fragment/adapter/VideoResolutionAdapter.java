package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.CameraAspectRatio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A16343 on 2017/4/28.
 */

public class VideoResolutionAdapter extends BaseAdapter {
    private List<CameraAspectRatio> cameraAspectRatios = new ArrayList<>();
    private Context mContext;

    public VideoResolutionAdapter(Context context) {
        mContext = context;
        cameraAspectRatios.add(CameraAspectRatio.Aspect_4_3);
        cameraAspectRatios.add(CameraAspectRatio.Aspect_16_9);
    }

    @Override
    public int getCount() {
        return null == cameraAspectRatios ? 0 : cameraAspectRatios.size();
    }

    @Override
    public Object getItem(int position) {
        return cameraAspectRatios.get(position);
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

        textView.setText(cameraAspectRatios.get(position).toString());

        return convertView;
    }
}
