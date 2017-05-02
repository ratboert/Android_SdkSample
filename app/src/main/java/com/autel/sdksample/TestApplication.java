package com.autel.sdksample;

import android.app.Application;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.error.AutelError;
import com.autel.sdk.Autel;
import com.autel.util.log.AutelConfig;

public class TestApplication extends Application {
    private final String TAG = getClass().getSimpleName();
    public void onCreate() {
        super.onCreate();
        AutelConfig.AUTEL_DEBUG_LOG = false;
        String appKey = "<SDK license should be input>";
//        String appKey = "cdb4fcbe62ca8daa51d5af019dc87173";
        Autel.init(this, appKey, new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                Log.v(TAG, "checkAppKeyValidate onSuccess");
            }

            @Override
            public void onFailure(AutelError error) {
                Log.v(TAG, "checkAppKeyValidate " + error.getDescription());
            }
        });
    }
}
