package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.CameraISO;
import com.autel.sdksample.adapter.SelectorAdapter;

import java.util.Arrays;

public class ISOValueAdapter extends SelectorAdapter<CameraISO> {
    public ISOValueAdapter(Context context,  CameraProduct cameraProduct) {
        super(context);
        elementList.addAll(Arrays.asList(cameraProduct.supportedISO()));
    }
}
