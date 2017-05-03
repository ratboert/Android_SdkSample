package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.CameraISO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ISOValueAdapter extends BaseAdapter {
    private List<CameraISO> cameraISOs = new ArrayList<>();
    private Context mContext;
    private CameraProduct cameraProduct;
    public ISOValueAdapter(Context context,  CameraProduct cameraProduct) {
        mContext = context;
        cameraISOs.addAll(Arrays.asList(cameraProduct.supportedISO()));
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
