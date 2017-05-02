package com.autel.sdksample.gimbal.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalWorkMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A16343 on 2017/4/28.
 */

public class RollAdjustAdapter extends BaseAdapter {
    private List<GimbalRollAngleAdjust> gimbalRollAngleAdjusts = new ArrayList<>();
    private Context mContext;

    public RollAdjustAdapter(Context context) {
        mContext = context;
        gimbalRollAngleAdjusts.add(GimbalRollAngleAdjust.MINUS);
        gimbalRollAngleAdjusts.add(GimbalRollAngleAdjust.PLUS);
        gimbalRollAngleAdjusts.add(GimbalRollAngleAdjust.QUERY);
        gimbalRollAngleAdjusts.add(GimbalRollAngleAdjust.RESET);
    }

    @Override
    public int getCount() {
        return null == gimbalRollAngleAdjusts ? 0 : gimbalRollAngleAdjusts.size();
    }

    @Override
    public Object getItem(int position) {
        return gimbalRollAngleAdjusts.get(position);
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

        textView.setText(gimbalRollAngleAdjusts.get(position).toString());

        return convertView;
    }
}
