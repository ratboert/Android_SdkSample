package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.media.CameraShutterSpeed;

import java.util.ArrayList;
import java.util.List;


public class ShutterSpeedAdapter extends BaseAdapter {
    private List<CameraShutterSpeed> cameraShutterSpeeds = new ArrayList<>();
    private Context mContext;

    public ShutterSpeedAdapter(Context context) {
        mContext = context;
        /*** 15s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_15);
        /*** 13s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_13);
        /*** 10s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_10);
        /*** 9s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_9);
        /*** 8s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_8);
        /*** 6s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_6);
        /*** 5s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_5);
        /*** 4s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_4);
        /*** 3.2s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_3dot2);
        /*** 3s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_3);
        /*** 2.5s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_2dot5);
        /*** 2s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_2);
        /*** 1.6s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1dot6);
        /*** 1.3s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1dot3);
        /*** 1s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1);

        /*** 1/1.25 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_1dot25);
        /*** 1/1.67 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_1dot67);
        /*** 1/2 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_2);
        /*** 1/2.5 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_2dot5);
        /*** 1/3 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_3);
        /*** 1/4 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_4);
        /*** 1/5 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_5);
        /*** 1/6.25 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_6dot25);
        /*** 1/8 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_8);
        /*** 1/10 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_10);
        /*** 1/12.5 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_12dot5);
        /*** 1/15 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_15);
        /*** 1/20 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_20);
        /*** 1/25 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_25);
        /*** 1/30 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_30);
        /*** 1/40 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_40);
        /*** 1/50 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_50);
        /*** 1/60 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_60);
        /*** 1/80 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_80);
        /*** 1/100 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_100);
        /*** 1/120 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_120);
        /*** 1/160 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_160);
        /*** 1/200 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_200);
        /*** 1/240 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_240);
        /*** 1/320 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_320);
        /*** 1/400 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_400);
        /*** 1/500 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_500);
        /*** 1/640 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_640);
        /*** 1/800 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_800);
        /*** 1/1000 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_1000);
        /*** 1/1250 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_1250);
        /*** 1/1600 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_1600);
        /*** 1/2000 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_2000);
        /*** 1/2500 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_2500);
        /*** 1/3200 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_3200);
        /*** 1/4000 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_4000);
        /*** 1/5000 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_5000);
        /*** 1/6000 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_6000);
        /*** 1/8000 s ***/
        cameraShutterSpeeds.add(CameraShutterSpeed.ShutterSpeed_1_8000);
    }


    @Override
    public int getCount() {
        return null == cameraShutterSpeeds ? 0 : cameraShutterSpeeds.size();
    }

    @Override
    public Object getItem(int position) {
        return cameraShutterSpeeds.get(position);
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

        textView.setText(cameraShutterSpeeds.get(position).toString());

        return convertView;
    }
}
