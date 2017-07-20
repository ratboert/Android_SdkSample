package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.CameraISO;
import com.autel.sdksample.adapter.SelectorAdapter;

import java.util.Arrays;
import java.util.List;

public class ISOValueAdapter extends SelectorAdapter<CameraISO> {
    public ISOValueAdapter(Context context) {
        super(context);
    }

    public ISOValueAdapter(Context context,  List<CameraISO> isoList) {
        super(context);
        elementList = isoList;
    }
}
