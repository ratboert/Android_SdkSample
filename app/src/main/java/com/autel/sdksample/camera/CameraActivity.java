package com.autel.sdksample.camera;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;

import com.autel.common.CallbackWithTwoParams;
import com.autel.common.RequestResultWithOneParam;
import com.autel.common.camera.CameraParameterSupport;
import com.autel.common.camera.CameraProduct;
import com.autel.common.error.AutelError;
import com.autel.sdk.AModuleCamera;
import com.autel.sdk.camera.AutelBaseCamera;
import com.autel.sdksample.R;
import com.autel.sdksample.camera.fragment.CameraFLIRFragment;
import com.autel.sdksample.camera.fragment.CameraNotConnectFragment;
import com.autel.sdksample.camera.fragment.CameraXb004Fragment;


public class CameraActivity extends FragmentActivity {
    TextView cameraType;
    AutelBaseCamera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        cameraType = (TextView) findViewById(R.id.camera_type);
        changePage(CameraNotConnectFragment.class);
        initListener();
    }

    private void initListener() {
        final RequestResultWithOneParam<CameraParameterSupport> requestResult = AModuleCamera.cameraManager().getParameterSupport();
        AModuleCamera.cameraManager().setConnectStateListener(new CallbackWithTwoParams<CameraProduct, AutelBaseCamera>() {
            @Override
            public void onSuccess(CameraProduct data1, AutelBaseCamera data2) {
                Log.v("camera_connect1", "initListener onSuccess connect " + data1);
                camera = data2;

                if (null != requestResult.getError()) {
                    cameraType.setText(requestResult.getError().getDescription());
                } else {
                    cameraType.setText(data1.toString());
                    if (data1 == CameraProduct.FLIR_DUO) {
                        changePage(CameraFLIRFragment.class);
                    } else if (data1 == CameraProduct.R12) {
                        changePage(CameraXb004Fragment.class);
                    } else if (data1 == CameraProduct.UNKNOWN) {
                        cameraType.setText("camera disconnected");
                        changePage(CameraNotConnectFragment.class);
                    }
                }
            }

            @Override
            public void onFailure(AutelError error) {
                Log.v("camera_connect1", "initListener onFailure error " + error.getDescription());
                cameraType.setText("camera connect broken  " + error.getDescription());
            }
        });
    }

    private void changePage(Class page) {
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, (Fragment) page.newInstance()).commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public AutelBaseCamera getCamera() {
        return camera;
    }

}
