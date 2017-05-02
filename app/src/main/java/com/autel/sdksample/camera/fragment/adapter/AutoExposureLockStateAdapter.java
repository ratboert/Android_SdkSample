package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.CameraAutoExposureLockState;

import java.util.ArrayList;
import java.util.List;


public class AutoExposureLockStateAdapter extends BaseAdapter {
    private List<CameraAutoExposureLockState> cameraAutoExposureLockStates = new ArrayList<>();
    private Context mContext;

    public AutoExposureLockStateAdapter(Context context) {
        mContext = context;
        cameraAutoExposureLockStates.add(CameraAutoExposureLockState.LOCK);
        cameraAutoExposureLockStates.add(CameraAutoExposureLockState.UNLOCK);
        cameraAutoExposureLockStates.add(CameraAutoExposureLockState.DISABLE);
    }

    @Override
    public int getCount() {
        return null == cameraAutoExposureLockStates ? 0 : cameraAutoExposureLockStates.size();
    }

    @Override
    public Object getItem(int position) {
        return cameraAutoExposureLockStates.get(position);
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

        textView.setText(cameraAutoExposureLockStates.get(position).toString());

        return convertView;
    }
}
