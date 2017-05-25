package com.autel.sdksample.album.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.album.MediaInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocalVideoListAdapter extends BaseAdapter {
    private List<File> mediaInfos = new ArrayList<>();
    private Context mContext;


    public LocalVideoListAdapter(Context context) {
        mContext = context;
    }


    public void setRfData(List<File> data) {
        this.mediaInfos = data;
        notifyDataSetInvalidated();
    }

    @Override
    public int getCount() {
        return null == mediaInfos ? 0 : mediaInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return mediaInfos.get(position);
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

        textView.setText(mediaInfos.get(position).getAbsolutePath());

        return convertView;
    }
}
