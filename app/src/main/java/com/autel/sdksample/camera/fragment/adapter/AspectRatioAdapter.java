package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.CameraAspectRatio;
import com.autel.sdksample.adapter.SelectorAdapter;

import java.util.Arrays;

public class AspectRatioAdapter extends SelectorAdapter<CameraAspectRatio> {
    private CameraProduct cameraProduct;

    public AspectRatioAdapter(Context context, CameraProduct cameraProduct) {
        super(context);
        this.cameraProduct = cameraProduct;
        elementList.addAll(Arrays.asList(cameraProduct.supportedAspectRatio()));
    }
}
