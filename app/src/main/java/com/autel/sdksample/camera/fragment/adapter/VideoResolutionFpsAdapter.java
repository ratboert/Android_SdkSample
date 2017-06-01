package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VideoResolutionFpsAdapter extends SelectorAdapter<VideoResolutionAndFps> {

    public VideoResolutionFpsAdapter(Context context) {
        super(context);

    }

    public void setData(CameraProduct product, VideoStandard videoStandard) {
        if (null != product) {
            elementList.clear();
            elementList.addAll(Arrays.asList(product.supportedVideoResolutionAndFps(videoStandard)));
        }
    }
}
