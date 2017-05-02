package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.base.PhotoFormat;

import java.util.ArrayList;
import java.util.List;


public class PhotoFormatAdapter extends BaseAdapter {
    private List<PhotoFormat> photoFormats = new ArrayList<>();
    private Context mContext;

    public PhotoFormatAdapter(Context context) {
        mContext = context;
        photoFormats.add(PhotoFormat.JPEG);
        photoFormats.add(PhotoFormat.RAW);
        photoFormats.add(PhotoFormat.RawAndJPEG);
    }

    @Override
    public int getCount() {
        return null == photoFormats ? 0 : photoFormats.size();
    }

    @Override
    public Object getItem(int position) {
        return photoFormats.get(position);
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

        textView.setText(photoFormats.get(position).toString());

        return convertView;
    }
}
