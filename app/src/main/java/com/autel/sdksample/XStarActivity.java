package com.autel.sdksample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.autel.sdksample.album.AlbumActivity;
import com.autel.sdksample.camera.CameraActivity;
import com.autel.sdksample.gimbal.GimbalActivity;

public class XStarActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xstar);
        findViewById(R.id.rcTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XStarActivity.this, RemoteControllerCActivity.class));
            }
        });
        findViewById(R.id.fcTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XStarActivity.this, FlyControllerActivity.class));
            }
        });
        findViewById(R.id.cameraTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XStarActivity.this, CameraActivity.class));
            }
        });
        findViewById(R.id.codecTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XStarActivity.this, CodecActivity.class));
            }
        });
        findViewById(R.id.DSPTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XStarActivity.this, DspActivity.class));
            }
        });
        findViewById(R.id.missionTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XStarActivity.this, MissionActivity.class));
            }
        });
        findViewById(R.id.BatteryTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XStarActivity.this, BatteryActivity.class));
            }
        });
        findViewById(R.id.GimbalTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XStarActivity.this, GimbalActivity.class));
            }
        });
        findViewById(R.id.AlbumTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XStarActivity.this, AlbumActivity.class));
            }
        });
        findViewById(R.id.FirmwareTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XStarActivity.this, FirmwareActivity.class));
            }
        });
    }
}
