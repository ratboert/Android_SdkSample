package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.CameraExposureCompensation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A16343 on 2017/4/28.
 */

public class ExposureValueAdapter extends BaseAdapter {
    private List<CameraExposureCompensation> exposureCompensations = new ArrayList<>();
    private Context mContext;

    public ExposureValueAdapter(Context context) {
        mContext = context;
        exposureCompensations.add(CameraExposureCompensation.POSITIVE_3p0);
        exposureCompensations.add(CameraExposureCompensation.POSITIVE_2p7);
        exposureCompensations.add(CameraExposureCompensation.POSITIVE_2p3);
        exposureCompensations.add(CameraExposureCompensation.POSITIVE_2p0);
        exposureCompensations.add(CameraExposureCompensation.POSITIVE_1p7);
        exposureCompensations.add(CameraExposureCompensation.POSITIVE_1p3);
        exposureCompensations.add(CameraExposureCompensation.POSITIVE_1p0);
        exposureCompensations.add(CameraExposureCompensation.POSITIVE_0p7);
        exposureCompensations.add(CameraExposureCompensation.POSITIVE_0p3);
        exposureCompensations.add(CameraExposureCompensation.POSITIVE_0);
        exposureCompensations.add(CameraExposureCompensation.NEGATIVE_0p3);
        exposureCompensations.add(CameraExposureCompensation.NEGATIVE_0p7);
        exposureCompensations.add(CameraExposureCompensation.NEGATIVE_1p0);
        exposureCompensations.add(CameraExposureCompensation.NEGATIVE_1p3);
        exposureCompensations.add(CameraExposureCompensation.NEGATIVE_1p7);
        exposureCompensations.add(CameraExposureCompensation.NEGATIVE_2p0);
        exposureCompensations.add(CameraExposureCompensation.NEGATIVE_2p3);
        exposureCompensations.add(CameraExposureCompensation.NEGATIVE_2p7);
        exposureCompensations.add(CameraExposureCompensation.NEGATIVE_3p0);
    }

    public void setRfData(List<CameraExposureCompensation> exposureCompensations) {
        this.exposureCompensations = exposureCompensations;
        notifyDataSetInvalidated();
    }

    @Override
    public int getCount() {
        return null == exposureCompensations ? 0 : exposureCompensations.size();
    }

    @Override
    public Object getItem(int position) {
        return exposureCompensations.get(position);
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

        textView.setText(exposureCompensations.get(position).toString());

        return convertView;
    }
}
