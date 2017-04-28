package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.CameraAspectRatio;
import com.autel.common.camera.media.CameraColorStyle;

import java.util.ArrayList;
import java.util.List;

import static com.autel.common.camera.media.CameraColorStyle.Art;
import static com.autel.common.camera.media.CameraColorStyle.Beach;
import static com.autel.common.camera.media.CameraColorStyle.BlackAndWhite;
import static com.autel.common.camera.media.CameraColorStyle.Classic;
import static com.autel.common.camera.media.CameraColorStyle.Dream;
import static com.autel.common.camera.media.CameraColorStyle.Film;
import static com.autel.common.camera.media.CameraColorStyle.Log;
import static com.autel.common.camera.media.CameraColorStyle.None;
import static com.autel.common.camera.media.CameraColorStyle.Nostalgic;
import static com.autel.common.camera.media.CameraColorStyle.Vivid;

/**
 * Created by A16343 on 2017/4/28.
 */

public class AspectRatioAdapter extends BaseAdapter {
    private List<CameraAspectRatio> cameraAspectRatios = new ArrayList<>();
    private Context mContext;

    public AspectRatioAdapter(Context context) {
        mContext = context;
        cameraAspectRatios.add(CameraAspectRatio.Aspect_4_3);
        cameraAspectRatios.add(CameraAspectRatio.Aspect_16_9);
    }

    @Override
    public int getCount() {
        return null == cameraAspectRatios ? 0 : cameraAspectRatios.size();
    }

    @Override
    public Object getItem(int position) {
        return cameraAspectRatios.get(position);
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

        textView.setText(cameraAspectRatios.get(position).toString());

        return convertView;
    }
}
