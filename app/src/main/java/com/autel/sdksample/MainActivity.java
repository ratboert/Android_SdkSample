package com.autel.sdksample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.error.AutelError;
import com.autel.sdk.Autel;
import com.autel.sdksample.view.mission.AMapMissionActivity;
import com.autel.sdksample.view.mission.GMapMissionActivity;


/**
 * Created by A16343 on 2016/11/15.
 */
public class MainActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rcTest(View view) {
        startActivity(new Intent(this, RCActivity.class));

    }

    public void fcTest(View view) {
        startActivity(new Intent(this, FCActivity.class));
    }

    public void cameraTest(View view) {
        startActivity(new Intent(this, CameraActivity.class));
    }

    public void codecTest(View view) {
        startActivity(new Intent(this, CodecActivity.class));
    }

    public void DSPTest(View view) {
        startActivity(new Intent(this, DspActivity.class));
    }

    public void missionTest(View view) {
//        startActivity(new Intent(this, MissionActivity.class));
//        startActivity(new Intent(this, AMapMissionActivity.class));
        startActivity(new Intent(this, MissionActivity.class));
    }

    public void BatteryTest(View view) {
        startActivity(new Intent(this, BatteryActivity.class));
    }

    public void GimbalTest(View view) {
        startActivity(new Intent(this, GimbalActivity.class));
    }

    public void AlbumTest(View view) {
        startActivity(new Intent(this, AlbumActivity.class));
    }

    public void FirmwareTest(View view) {
        startActivity(new Intent(this, FirmwareActivity.class));
    }

    public void CameraParamsTest(View view) {
        startActivity(new Intent(this, CameraParamsActivity.class));
    }
}
