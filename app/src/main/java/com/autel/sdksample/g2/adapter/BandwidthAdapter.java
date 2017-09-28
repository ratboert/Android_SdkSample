package com.autel.sdksample.g2.adapter;

import android.content.Context;

import com.autel.common.dsp.g2.Bandwidth;
import com.autel.sdksample.base.adapter.SelectorAdapter;

public class BandwidthAdapter extends SelectorAdapter<Bandwidth> {

    public BandwidthAdapter(Context context) {
        super(context);
        elementList.add(Bandwidth.WIDTH_3M);
        elementList.add(Bandwidth.WIDTH_5M);
        elementList.add(Bandwidth.WIDTH_10M);
        elementList.add(Bandwidth.WIDTH_20M);
        elementList.add(Bandwidth.UNKNOWN);
    }
}
