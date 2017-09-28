package com.autel.sdksample.g2.adapter;

import android.content.Context;

import com.autel.common.dsp.g2.BandMode;
import com.autel.sdksample.base.adapter.SelectorAdapter;

public class BandModeAdapter extends SelectorAdapter<BandMode> {

    public BandModeAdapter(Context context) {
        super(context);
        elementList.add(BandMode.MODE_1_4G);
        elementList.add(BandMode.MODE_2_4G);
        elementList.add(BandMode.MODE_2_4G_900M);
        elementList.add(BandMode.MODE_900M);
        elementList.add(BandMode.UNKNOWN);
    }
}
