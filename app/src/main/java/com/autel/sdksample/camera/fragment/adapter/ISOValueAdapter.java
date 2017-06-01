package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.CameraISO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ISOValueAdapter extends SelectorAdapter<CameraISO> {
    public ISOValueAdapter(Context context,  CameraProduct cameraProduct) {
        super(context);
        elementList.addAll(Arrays.asList(cameraProduct.supportedISO()));
    }
}
