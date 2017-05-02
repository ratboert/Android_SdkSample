package com.autel.sdksample.gimbal.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.gimbal.GimbalWorkMode;

import java.util.ArrayList;
import java.util.List;


public class GimbalModeAdapter extends BaseAdapter {
    private List<GimbalWorkMode> gimbalWorkModes = new ArrayList<>();
    private Context mContext;

    public GimbalModeAdapter(Context context) {
        mContext = context;
        gimbalWorkModes.add(GimbalWorkMode.FPV);
        gimbalWorkModes.add(GimbalWorkMode.FREE);
    }

    @Override
    public int getCount() {
        return null == gimbalWorkModes ? 0 : gimbalWorkModes.size();
    }

    @Override
    public Object getItem(int position) {
        return gimbalWorkModes.get(position);
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
        } else {
            textView = (TextView) convertView;
        }

        textView.setText(gimbalWorkModes.get(position).toString());

        return convertView;
    }
}
