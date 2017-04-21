package com.autel.sdksample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.autel.sdksample.util.MissionTest;
import com.autel.sdksample.view.mission.AMapMissionActivity;
import com.autel.sdksample.view.mission.GMapMissionActivity;


public class MissionActivity extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);
    }

    public void gMap(View view){
        startActivity(new Intent(this, GMapMissionActivity.class));
    }
    public void aMap(View view){
        startActivity(new Intent(this, AMapMissionActivity.class));
    }
}
