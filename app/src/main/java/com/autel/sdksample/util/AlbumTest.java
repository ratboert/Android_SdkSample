package com.autel.sdksample.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.album.MediaInfo;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.error.AutelError;
import com.autel.sdk.AModuleAlbum;

import java.util.List;

/**
 * Created by A16343 on 2016/12/6.
 */
public class AlbumTest {
    private static final String TAG = "AlbumTest";
    private static List<MediaInfo> mediaItems;

    public static void getAlbumMedia(final Handler handler) {
        AModuleAlbum.album().getMedia(0, 10, new CallbackWithOneParam<List<MediaInfo>>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getMedia  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(List<MediaInfo> data) {
                logOut(handler, "getMedia  data size  " + data.size());
                mediaItems = data;
                for (MediaInfo item : data) {
                    Log.v(TAG, "getMedia  data  " + item.getOriginalMedia() + "    " + item.getFileSize() + "   " + item.getFileTimeString() + "  SmallThumbnail  " + item.getSmallThumbnail());
                }
            }
        });
    }

    public static void deleteAlbumMedia(final Handler handler) {
        if (null != mediaItems) {
            List<MediaInfo> albumMedias = mediaItems.subList(0, 1);
            AModuleAlbum.album().deleteMedia(albumMedias, new CallbackWithOneParam<List<MediaInfo>>() {
                @Override
                public void onFailure(AutelError error) {
                    logOut(handler, "deleteMedia  error  " + error.getDescription());
                }

                @Override
                public void onSuccess(List<MediaInfo> data) {
                    logOut(handler, "deleteMedia  size  " + data.size());
                    for (MediaInfo item : data) {
                        Log.v(TAG, "deleteMedia  data  onFailure " + item.getOriginalMedia() + "    " + item.getFileSize() + "   " + item.getFileTimeString() + "  SmallThumbnail  " + item.getSmallThumbnail());
                    }
                }
            });
        }

    }

    public static void getVideoResolutionFromHttpHeader(final Handler handler) {
        if (null != mediaItems) {
            for (MediaInfo media : mediaItems) {
                if (media.getPath().contains("MOV")) {
                    AModuleAlbum.album().getVideoResolutionFromHttpHeader(media, new CallbackWithOneParam<VideoResolutionAndFps>() {
                        @Override
                        public void onFailure(AutelError error) {
                            logOut(handler, "getVideoResolutionFromHttpHeader  error  " + error.getDescription());
                        }

                        @Override
                        public void onSuccess(VideoResolutionAndFps data) {
                            logOut(handler, "getVideoResolutionFromHttpHeader  data size " + data);
                        }
                    });
                    return;
                }
            }

        }

    }

    public static void getVideoResolutionFromLocalFile(Handler handler) {
        if (null != mediaItems) {
            for (MediaInfo media : mediaItems) {
                if (media.getPath().contains("MP4")) {
                    VideoResolutionAndFps data = AModuleAlbum.album().getVideoResolutionFromLocalFile(media, null);
                    logOut(handler, "getVideoResolutionFromLocalFile  data size " + data);
                    return;
                }
            }
        }
    }

    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }

}
