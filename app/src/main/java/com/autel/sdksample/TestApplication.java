package com.autel.sdksample;

import android.app.Application;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.error.AutelError;
import com.autel.sdk.Autel;
import com.autel.util.log.AutelConfig;

/**
 * Created by A16343 on 2016/11/7.
 */
public class TestApplication extends Application {
    public void onCreate() {
        super.onCreate();
        AutelConfig.AUTEL_DEBUG_LOG = false;
//        String appKey = "<SDK license should be input>";
        String appKey = "cdb4fcbe62ca8daa51d5af019dc87173";
        Autel.init(this, appKey, new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                Log.v("AuthorTest", "checkAppKeyValidate onSuccess");
            }

            @Override
            public void onFailure(AutelError error) {
                Log.v("AuthorTest", "checkAppKeyValidate " + error.getDescription());
            }
        });
//        NetworkManager.getInstance(this).registerReceiver();
//        ConnectionManager2.getInstance_().disconnect();
//        ConnectionManager2.getInstance_().connect();

    }
}
