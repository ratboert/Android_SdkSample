package com.autel.sdksample.album;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.album.MediaInfo;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.error.AutelError;
import com.autel.sdk.AModuleAlbum;
import com.autel.sdk.album.AutelAlbum;
import com.autel.sdksample.BaseActivity;
import com.autel.sdksample.R;
import com.autel.sdksample.album.adapter.MediaListAdapter;

import java.util.ArrayList;
import java.util.List;


public class AlbumActivity extends BaseActivity {
    private AutelAlbum autelAlbum;
    private List<MediaInfo> mediaItems;
    private MediaInfo deleteMedia;
    private MediaInfo resolutionFromHttpHeader;
    private MediaInfo resolutionFromLocalFile;
    private MediaListAdapter videoResolutionFromHttpHeaderAdapter = new MediaListAdapter(this);
    private MediaListAdapter videoResolutionFromLocalFileAdapter = new MediaListAdapter(this);
    private MediaListAdapter mediaListAdapter = new MediaListAdapter(this);

    Spinner mediaList;
    Spinner videoResolutionFromHttpHeaderList;
    Spinner videoResolutionFromLocalFileList;

    @Override
    protected void initOnCreate() {
        setContentView(R.layout.activity_album);
        mediaList = (Spinner) findViewById(R.id.mediaList);
        mediaList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                deleteMedia = (MediaInfo)parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        videoResolutionFromHttpHeaderList = (Spinner) findViewById(R.id.videoResolutionFromHttpHeaderList);
        videoResolutionFromHttpHeaderList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resolutionFromHttpHeader = (MediaInfo)parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        videoResolutionFromLocalFileList = (Spinner) findViewById(R.id.videoResolutionFromLocalFileList);
        videoResolutionFromLocalFileList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resolutionFromLocalFile = (MediaInfo)parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        autelAlbum = AModuleAlbum.album();
        mediaItems = new ArrayList<>();
    }

    public void getMedia(View view) {
        autelAlbum.getMedia(0, 10, new CallbackWithOneParam<List<MediaInfo>>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getMedia  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(List<MediaInfo> data) {
                logOut("getMedia  data  " + data);
                mediaItems = data;
                for (MediaInfo item : data) {
                    Log.v(TAG, "getMedia  data  " + item.getOriginalMedia() + "    " + item.getFileSize() + "   " + item.getFileTimeString() + "  SmallThumbnail  " + item.getSmallThumbnail());
                }

                mediaListAdapter.setRfData(data);
                mediaList.setAdapter(mediaListAdapter);
                videoResolutionFromHttpHeaderAdapter.setRfData(data);
                videoResolutionFromHttpHeaderList.setAdapter(videoResolutionFromHttpHeaderAdapter);
                videoResolutionFromLocalFileAdapter.setRfData(data);
                videoResolutionFromLocalFileList.setAdapter(videoResolutionFromLocalFileAdapter);
            }
        });
    }

    public void deleteAllMedia(View view) {
        autelAlbum.deleteMedia(mediaItems, new CallbackWithOneParam<List<MediaInfo>>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("deleteMedia  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(List<MediaInfo> data) {
                logOut("deleteMedia  size  " + data.size());
                for (MediaInfo item : data) {
                    Log.v(TAG, "deleteMedia  data  onFailure " + item.getOriginalMedia() + "    " + item.getFileSize() + "   " + item.getFileTimeString() + "  SmallThumbnail  " + item.getSmallThumbnail());
                }
            }
        });
    }
    public void deleteMedia(View view) {
        autelAlbum.deleteMedia(deleteMedia, new CallbackWithOneParam<List<MediaInfo>>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("deleteMedia  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(List<MediaInfo> data) {
                logOut("deleteMedia  size  " + data.size());
                for (MediaInfo item : data) {
                    Log.v(TAG, "deleteMedia  data  onFailure " + item.getOriginalMedia() + "    " + item.getFileSize() + "   " + item.getFileTimeString() + "  SmallThumbnail  " + item.getSmallThumbnail());
                }
            }
        });
    }

    public void getVideoResolutionFromHttpHeader(View view) {
        autelAlbum.getVideoResolutionFromHttpHeader(resolutionFromHttpHeader, new CallbackWithOneParam<VideoResolutionAndFps>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getVideoResolutionFromHttpHeader  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(VideoResolutionAndFps data) {
                logOut("getVideoResolutionFromHttpHeader  data size " + data);
            }
        });
    }

    public void getVideoResolutionFromLocalFile(View view) {
        VideoResolutionAndFps data = autelAlbum.getVideoResolutionFromLocalFile(null);
        if(null != data){
            logOut("getVideoResolutionFromLocalFile  data size " + data);
        }else{
            logOut("getVideoResolutionFromLocalFile  data == null ");
        }

    }
}

