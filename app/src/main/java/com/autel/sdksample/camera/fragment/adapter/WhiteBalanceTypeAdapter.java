package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.CameraWhiteBalanceType;
import com.autel.sdksample.adapter.SelectorAdapter;

import java.util.Arrays;


public class WhiteBalanceTypeAdapter extends SelectorAdapter<CameraWhiteBalanceType> {

    public WhiteBalanceTypeAdapter(Context context, CameraProduct cameraProduct) {
        super(context);
        elementList.addAll(Arrays.asList(cameraProduct.supportedWhiteBalanceType()));
    }
}
