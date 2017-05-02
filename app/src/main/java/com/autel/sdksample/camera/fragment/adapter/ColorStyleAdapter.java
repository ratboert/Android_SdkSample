package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

public class ColorStyleAdapter extends BaseAdapter {
    private List<CameraColorStyle> cameraColorStyles = new ArrayList<>();
    private Context mContext;

    public ColorStyleAdapter(Context context) {
        mContext = context;
        cameraColorStyles.add(None);
        cameraColorStyles.add(Vivid);
        cameraColorStyles.add(BlackAndWhite);
        cameraColorStyles.add(Art);
        cameraColorStyles.add(Film);
        cameraColorStyles.add(Beach);
        cameraColorStyles.add(Dream);
        cameraColorStyles.add(Classic);
        cameraColorStyles.add(Log);
        cameraColorStyles.add(Nostalgic);
    }

    @Override
    public int getCount() {
        return null == cameraColorStyles ? 0 : cameraColorStyles.size();
    }

    @Override
    public Object getItem(int position) {
        return cameraColorStyles.get(position);
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

        textView.setText(cameraColorStyles.get(position).toString());

        return convertView;
    }
}
