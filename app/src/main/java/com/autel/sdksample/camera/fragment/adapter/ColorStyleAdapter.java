package com.autel.sdksample.camera.fragment.adapter;

import android.content.Context;

import com.autel.common.camera.media.CameraColorStyle;
import com.autel.sdksample.adapter.SelectorAdapter;

import static com.autel.common.camera.media.CameraColorStyle.Art;
import static com.autel.common.camera.media.CameraColorStyle.Beach;
import static com.autel.common.camera.media.CameraColorStyle.BlackAndWhite;
import static com.autel.common.camera.media.CameraColorStyle.Classic;
import static com.autel.common.camera.media.CameraColorStyle.Dream;
import static com.autel.common.camera.media.CameraColorStyle.Film;
import static com.autel.common.camera.media.CameraColorStyle.Log;
import static com.autel.common.camera.media.CameraColorStyle.None;
import static com.autel.common.camera.media.CameraColorStyle.Nostalgic;
import static com.autel.common.camera.media.CameraColorStyle.Vivid;

public class ColorStyleAdapter extends SelectorAdapter<CameraColorStyle> {

    public ColorStyleAdapter(Context context) {
        super(context);
        mContext = context;
        elementList.add(None);
        elementList.add(Vivid);
        elementList.add(BlackAndWhite);
        elementList.add(Art);
        elementList.add(Film);
        elementList.add(Beach);
        elementList.add(Dream);
        elementList.add(Classic);
        elementList.add(Log);
        elementList.add(Nostalgic);
    }
}
