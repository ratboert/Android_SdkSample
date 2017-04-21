package com.autel.sdksample.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.autel.sdksample.R;

/**
 * Created by A16343 on 2017/2/22.
 */

public class CameraNotConnectFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_camera_not_connect, null);
        return view;
    }
}
