package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.PhotoAEBCount;

import java.util.ArrayList;
import java.util.List;


public class PhotoAEBCountAdapter extends BaseAdapter {
    private List<PhotoAEBCount> photoAEBCounts = new ArrayList<>();
    private Context mContext;

    public PhotoAEBCountAdapter(Context context) {
        mContext = context;
        photoAEBCounts.add(PhotoAEBCount.CAPTURE_3);
        photoAEBCounts.add(PhotoAEBCount.CAPTURE_5);
    }

    @Override
    public int getCount() {
        return null == photoAEBCounts ? 0 : photoAEBCounts.size();
    }

    @Override
    public Object getItem(int position) {
        return photoAEBCounts.get(position);
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

        textView.setText(photoAEBCounts.get(position).toString());

        return convertView;
    }
}
