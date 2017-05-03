package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.CameraExposureMode;
import com.autel.common.camera.media.CameraISO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExposureModeAdapter extends BaseAdapter {
    private List<CameraExposureMode> cameraExposureModes = new ArrayList<>();
    private Context mContext;
    private CameraProduct cameraProduct;
    public ExposureModeAdapter(Context context, CameraProduct cameraProduct) {
        mContext = context;
        cameraExposureModes.addAll(Arrays.asList(cameraProduct.supportedExposureMode()));
    }

    @Override
    public int getCount() {
        return null == cameraExposureModes ? 0 : cameraExposureModes.size();
    }

    @Override
    public Object getItem(int position) {
        return cameraExposureModes.get(position);
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

        textView.setText(cameraExposureModes.get(position).toString());

        return convertView;
    }
}
