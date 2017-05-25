package com.autel.sdksample.album.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autel.common.album.MediaInfo;

import java.util.ArrayList;
import java.util.List;

public class MediaListAdapter extends BaseAdapter {
    public enum MediaType {
        Video,
        Photo,
        Media
    }

    public static String[] videos = new String[]{"mp4", "mov", "MP4", "MOV", ".video"};
    public static String[] photos = new String[]{"jpg", "JPG", "dng", "DNG", "png", "PNG", ".photo"};
    private List<MediaInfo> mediaInfos = new ArrayList<>();
    private Context mContext;

    private MediaType mediaType = MediaType.Media;

    public MediaListAdapter(Context context) {
        mContext = context;
    }

    public MediaListAdapter(Context context, MediaType mediaType) {
        this.mContext = context;
        this.mediaType = mediaType;
    }


    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }


    public void setRfData(List<MediaInfo> data) {
        if (mediaType == MediaType.Media) {
            this.mediaInfos = data;
        } else if (mediaType == MediaType.Video) {
            this.mediaInfos = new ArrayList<>();
            for (MediaInfo item : data) {
                for (String tag : videos) {
                    if (item.getOriginalMedia().endsWith(tag)) {
                        mediaInfos.add(item);
                        break;
                    }
                }
            }
        } else if (mediaType == MediaType.Photo) {
            this.mediaInfos = new ArrayList<>();
            for (MediaInfo item : data) {
                for (String tag : photos) {
                    if (item.getOriginalMedia().endsWith(tag)) {
                        mediaInfos.add(item);
                        break;
                    }
                }
            }
        }

        notifyDataSetInvalidated();
    }

    @Override
    public int getCount() {
        return null == mediaInfos ? 0 : mediaInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return mediaInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = null;
        if (null == convertView) {
            textView = new TextView(mContext);
            convertView = textView;
        } else {
            textView = (TextView) convertView;
        }

        textView.setText(mediaInfos.get(position).getOriginalMedia());

        return convertView;
    }
}
