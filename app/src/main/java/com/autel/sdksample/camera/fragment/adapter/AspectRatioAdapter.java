package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.sdksample.adapter.SelectorAdapter;

import java.util.List;

public class AspectRatioAdapter extends SelectorAdapter<PhotoAspectRatio> {

    public AspectRatioAdapter(Context context) {
        super(context);
    }

    public AspectRatioAdapter(Context context, List<PhotoAspectRatio> list) {
        super(context);
        elementList = list;
    }
}
