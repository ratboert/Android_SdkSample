package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.PhotoBurstCount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A16343 on 2017/4/28.
 */

public class PhotoBurstAdapter extends BaseAdapter {
    private List<PhotoBurstCount> photoBurstCounts = new ArrayList<>();
    private Context mContext;

    public PhotoBurstAdapter(Context context) {
        mContext = context;
        photoBurstCounts.add(PhotoBurstCount.BURST_3);
        photoBurstCounts.add(PhotoBurstCount.BURST_5);
        photoBurstCounts.add(PhotoBurstCount.BURST_7);
    }

    @Override
    public int getCount() {
        return null == photoBurstCounts ? 0 : photoBurstCounts.size();
    }

    @Override
    public Object getItem(int position) {
        return photoBurstCounts.get(position);
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

        textView.setText(photoBurstCounts.get(position).toString());

        return convertView;
    }
}
