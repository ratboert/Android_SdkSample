package com.autel.sdksample.album.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.album.MediaInfo;

import java.util.ArrayList;
import java.util.List;

public class MediaListAdapter extends BaseAdapter {
    private List<MediaInfo> mediaInfos = new ArrayList<>();
    private Context mContext;

    public MediaListAdapter(Context context) {
        mContext = context;
    }

    public void setRfData(List<MediaInfo> mediaInfos) {
        this.mediaInfos = mediaInfos;
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

        textView.setText(mediaInfos.get(position).getOriginalMedia());

        return convertView;
    }
}
