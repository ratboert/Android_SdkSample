package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.CameraAntiFlicker;

import java.util.ArrayList;
import java.util.List;

public class AntiFlickerAdapter extends BaseAdapter {
    private List<CameraAntiFlicker> cameraAntiFlickers = new ArrayList<>();
    private Context mContext;

    public AntiFlickerAdapter(Context context) {
        mContext = context;
        cameraAntiFlickers.add(CameraAntiFlicker.AUTO);
        cameraAntiFlickers.add(CameraAntiFlicker.ANTI_FLICKER_50HZ);
        cameraAntiFlickers.add(CameraAntiFlicker.ANTI_FLICKER_60HZ);
    }

    @Override
    public int getCount() {
        return null == cameraAntiFlickers ? 0 : cameraAntiFlickers.size();
    }

    @Override
    public Object getItem(int position) {
        return cameraAntiFlickers.get(position);
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

        textView.setText(cameraAntiFlickers.get(position).toString());

        return convertView;
    }
}
