package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.CameraWhiteBalanceType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A16343 on 2017/4/28.
 */

public class WhiteBalanceTypeAdapter extends BaseAdapter {
    private List<CameraWhiteBalanceType> whiteBalanceTypes = new ArrayList<>();
    private Context mContext;

    public WhiteBalanceTypeAdapter(Context context) {
        mContext = context;
        whiteBalanceTypes.add(CameraWhiteBalanceType.FLUOROMETER);
        whiteBalanceTypes.add(CameraWhiteBalanceType.INCANDESCENT);
        whiteBalanceTypes.add(CameraWhiteBalanceType.AUTO);
        whiteBalanceTypes.add(CameraWhiteBalanceType.SUNNY);
        whiteBalanceTypes.add(CameraWhiteBalanceType.CLOUDY);
    }

    @Override
    public int getCount() {
        return null == whiteBalanceTypes ? 0 : whiteBalanceTypes.size();
    }

    @Override
    public Object getItem(int position) {
        return whiteBalanceTypes.get(position);
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

        textView.setText(whiteBalanceTypes.get(position).toString());

        return convertView;
    }
}
