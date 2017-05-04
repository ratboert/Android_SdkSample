package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VideoResolutionFpsAdapter extends BaseAdapter {
    private List<VideoResolutionAndFps> videoResolutionAndFpses = new ArrayList<>();
    private Context mContext;

    public VideoResolutionFpsAdapter(Context context) {
        mContext = context;

    }

    public void setData(CameraProduct product, VideoStandard videoStandard) {
        if (null != product) {
            videoResolutionAndFpses.clear();
            videoResolutionAndFpses.addAll(Arrays.asList(product.supportedVideoResolutionAndFps(videoStandard)));
        }
    }

    @Override
    public int getCount() {
        return null == videoResolutionAndFpses ? 0 : videoResolutionAndFpses.size();
    }

    @Override
    public Object getItem(int position) {
        return videoResolutionAndFpses.get(position);
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

        textView.setText(videoResolutionAndFpses.get(position).toString());

        return convertView;
    }
}
