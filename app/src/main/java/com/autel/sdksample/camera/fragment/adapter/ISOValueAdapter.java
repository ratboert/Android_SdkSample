package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.CameraISO;

import java.util.ArrayList;
import java.util.List;

public class ISOValueAdapter extends BaseAdapter {
    private List<CameraISO> cameraISOs = new ArrayList<>();
    private Context mContext;

    public ISOValueAdapter(Context context) {
        mContext = context;
        cameraISOs.add(CameraISO.ISO_100);
        cameraISOs.add(CameraISO.ISO_200);
        cameraISOs.add(CameraISO.ISO_400);
        cameraISOs.add(CameraISO.ISO_800);
        cameraISOs.add(CameraISO.ISO_1600);
        cameraISOs.add(CameraISO.ISO_3200);
        cameraISOs.add(CameraISO.ISO_6400);
        cameraISOs.add(CameraISO.ISO_12800);
        cameraISOs.add(CameraISO.ISO_25600);
    }

    @Override
    public int getCount() {
        return null == cameraISOs ? 0 : cameraISOs.size();
    }

    @Override
    public Object getItem(int position) {
        return cameraISOs.get(position);
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

        textView.setText(cameraISOs.get(position).toString());

        return convertView;
    }
}
