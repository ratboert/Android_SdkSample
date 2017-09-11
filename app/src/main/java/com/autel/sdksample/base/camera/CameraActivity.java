package com.autel.sdksample.base.camera;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.error.AutelError;
import com.autel.sdk.camera.AutelBaseCamera;
import com.autel.sdk.camera.AutelCameraManager;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdksample.R;
import com.autel.sdksample.TestApplication;
import com.autel.sdksample.base.camera.fragment.CameraFLIRFragment;
import com.autel.sdksample.base.camera.fragment.CameraNotConnectFragment;
import com.autel.sdksample.base.camera.fragment.CameraR12Fragment;
import com.autel.sdksample.base.camera.fragment.CameraXB012Fragment;
import com.autel.sdksample.base.camera.fragment.CameraXb008Fragment;


public class CameraActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    TextView cameraType;
    TextView cameraLogOutput;
    AutelBaseCamera currentCamera;
    AutelCameraManager autelCameraManager;
    protected Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String text = (String) msg.obj;
            if (null != cameraLogOutput) {
                cameraLogOutput.setText(text);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Camera");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        cameraType = (TextView) findViewById(R.id.camera_type);
        cameraLogOutput = (TextView) findViewById(R.id.camera_log_output);
        BaseProduct product = ((TestApplication) getApplicationContext()).getCurrentProduct();
        if (null != product) {
            autelCameraManager = product.getCameraManager();
        }
        changePage(CameraNotConnectFragment.class);
//        initListener();
    }

    private void initListener() {
        if (null == autelCameraManager) {
            return;
        }
        autelCameraManager.setCameraChangeListener(new CallbackWithTwoParams<CameraProduct, AutelBaseCamera>() {
            @Override
            public void onSuccess(final CameraProduct data1, final AutelBaseCamera data2) {
                Log.v(TAG, "initListener onSuccess connect " + data1);
                if (currentCamera == data2) {
                    return;
                }
                currentCamera = data2;
                cameraType.setText(data1.toString());
                switch (data1) {
                    case FLIR_DUO:
                        changePage(CameraFLIRFragment.class);
                        break;
                    case FLIR_DUO_R:
                        changePage(CameraFLIRFragment.class);
                        break;
                    case R12:
                        changePage(CameraR12Fragment.class);
                        break;
                    case XB008:
                        changePage(CameraXb008Fragment.class);
                        break;
                    case XB012:
                        changePage(CameraXB012Fragment.class);
                        break;
                    default:
                        changePage(CameraNotConnectFragment.class);
                }

            }

            @Override
            public void onFailure(AutelError error) {
                Log.v(TAG, "initListener onFailure error " + error.getDescription());
                cameraType.setText("currentCamera connect broken  " + error.getDescription());
            }
        });
    }

    public void onResume() {
        super.onResume();
        initListener();
    }

    public void onPause() {
        super.onPause();
        if (null == autelCameraManager) {
            return;
        }
        autelCameraManager.setCameraChangeListener(null);
    }

    private void changePage(Class page) {
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, (Fragment) page.newInstance()).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AutelBaseCamera getCurrentCamera() {
        return currentCamera;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void logOut(String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }

}
