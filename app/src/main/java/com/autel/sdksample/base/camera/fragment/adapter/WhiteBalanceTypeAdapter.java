package com.autel.sdksample.base.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.media.CameraWhiteBalanceType;
import com.autel.sdksample.adapter.SelectorAdapter;

import java.util.List;


public class WhiteBalanceTypeAdapter extends SelectorAdapter<CameraWhiteBalanceType> {

    public WhiteBalanceTypeAdapter(Context context) {
        super(context);
    }

    public WhiteBalanceTypeAdapter(Context context, List<CameraWhiteBalanceType> list) {
        super(context);
        elementList = list;
    }
}
