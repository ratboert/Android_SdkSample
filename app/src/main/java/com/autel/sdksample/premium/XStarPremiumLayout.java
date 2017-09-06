package com.autel.sdksample.premium;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.autel.sdksample.R;
import com.autel.sdksample.base.BatteryActivity;
import com.autel.sdksample.base.CodecActivity;
import com.autel.sdksample.base.DspActivity;
import com.autel.sdksample.base.FlyControllerActivity;
import com.autel.sdksample.base.album.AlbumActivity;
import com.autel.sdksample.base.camera.CameraActivity;
import com.autel.sdksample.base.gimbal.GimbalActivity;
import com.autel.sdksample.base.mission.MissionActivity;
import com.autel.sdksample.g2.G2RemoteControllerActivity;

/**
 * Created by A16343 on 2017/9/5.
 */

public class XStarPremiumLayout {
    private View mLayout;
    private Context mContext;
    public XStarPremiumLayout(Context context) {
        mContext = context;
        mLayout = View.inflate(mContext, R.layout.activity_xstar, null);
        initUI();
    }

    public View getLayout() {
        return mLayout;
    }

    private void initUI(){
        mLayout.findViewById(R.id.rcTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, XStarPremiumRemoteControllerActivity.class));
            }
        });
        mLayout.findViewById(R.id.fcTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, FlyControllerActivity.class));
            }
        });
        mLayout.findViewById(R.id.cameraTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, CameraActivity.class));
            }
        });
        mLayout.findViewById(R.id.codecTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, CodecActivity.class));
            }
        });
        mLayout.findViewById(R.id.DSPTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DspActivity.class));
            }
        });
        mLayout.findViewById(R.id.missionTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, MissionActivity.class));
            }
        });
        mLayout.findViewById(R.id.BatteryTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, BatteryActivity.class));
            }
        });
        mLayout.findViewById(R.id.GimbalTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, GimbalActivity.class));
            }
        });
        mLayout.findViewById(R.id.AlbumTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, AlbumActivity.class));
            }
        });
    }
}
