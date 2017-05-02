package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.PhotoStyleType;

import java.util.ArrayList;
import java.util.List;


public class PhotoStyleAdapter extends BaseAdapter {
    private List<PhotoStyleType> photoStyleTypes = new ArrayList<>();
    private Context mContext;

    public PhotoStyleAdapter(Context context) {
        mContext = context;
        photoStyleTypes.add(PhotoStyleType.Standard);
        photoStyleTypes.add(PhotoStyleType.Soft);
        photoStyleTypes.add(PhotoStyleType.Landscape);
        photoStyleTypes.add(PhotoStyleType.Custom);
    }

    @Override
    public int getCount() {
        return null == photoStyleTypes ? 0 : photoStyleTypes.size();
    }

    @Override
    public Object getItem(int position) {
        return photoStyleTypes.get(position);
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

        textView.setText(photoStyleTypes.get(position).toString());

        return convertView;
    }
}
