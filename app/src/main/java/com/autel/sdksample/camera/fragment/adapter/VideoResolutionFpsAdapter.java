package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.sdksample.adapter.SelectorAdapter;

import java.util.Arrays;


public class VideoResolutionFpsAdapter extends SelectorAdapter<VideoResolutionAndFps> {

    public VideoResolutionFpsAdapter(Context context) {
        super(context);
    }

    public void setData(CameraProduct product, VideoStandard videoStandard) {
        if (null != product) {
            setRfData(Arrays.asList(product.supportedVideoResolutionAndFps(videoStandard)));
        }
    }
}
