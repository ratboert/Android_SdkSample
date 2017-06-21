package com.autel.sdksample.album.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.album.MediaInfo;
import com.autel.sdksample.R;
import com.autel.sdksample.adapter.SelectorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MediaListAdapter extends SelectorAdapter<MediaInfo> {
    public enum MediaType {
        Video,
        Photo,
        Media
    }

    public static String[] videos = new String[]{"mp4", "mov", "MP4", "MOV", ".video"};
    public static String[] photos = new String[]{"jpg", "JPG", "dng", "DNG", "png", "PNG", ".photo"};

    private MediaType mediaType = MediaType.Media;

    public MediaListAdapter(Context context) {
        super(context);
    }

    public MediaListAdapter(Context context, MediaType mediaType) {
        super(context);
        this.mediaType = mediaType;
    }


    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }


    public void setRfData(List<MediaInfo> data) {
        if (mediaType == MediaType.Media) {
            this.elementList = data;
        } else if (mediaType == MediaType.Video) {
            this.elementList = new ArrayList<>();
            for (MediaInfo item : data) {
                for (String tag : videos) {
                    if (item.getOriginalMedia().endsWith(tag)) {
                        elementList.add(item);
                        break;
                    }
                }
            }
        } else if (mediaType == MediaType.Photo) {
            this.elementList = new ArrayList<>();
            for (MediaInfo item : data) {
                for (String tag : photos) {
                    if (item.getOriginalMedia().endsWith(tag)) {
                        elementList.add(item);
                        break;
                    }
                }
            }
        }

        notifyDataSetInvalidated();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = null;
        if (null == convertView) {
            convertView = View.inflate(mContext, R.layout.spinner_item, null);

        }
        textView = (TextView) convertView.findViewById(R.id.spinner_item_text);

        if (position < elementList.size() && position >= 0) {
            textView.setText(elementList.get(position).getOriginalMedia());
        }

        return convertView;
    }
}
