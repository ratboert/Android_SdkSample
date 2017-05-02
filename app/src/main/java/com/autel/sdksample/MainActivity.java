package com.autel.sdksample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.autel.sdksample.album.AlbumActivity;
import com.autel.sdksample.camera.CameraActivity;
import com.autel.sdksample.gimbal.GimbalActivity;

public class MainActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rcTest(View view) {
        startActivity(new Intent(this, RemoteControllerCActivity.class));

    }

    public void fcTest(View view) {
        startActivity(new Intent(this, FlyControllerActivity.class));
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
