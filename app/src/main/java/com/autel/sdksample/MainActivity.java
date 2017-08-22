package com.autel.sdksample;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.error.AutelError;
import com.autel.common.product.AutelProductType;
import com.autel.internal.product.XStarPremAircraftImpl;
import com.autel.sdk.Autel;
import com.autel.sdk.ProductConnectListener;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.G2Aircraft;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdksample.adapter.ProductSelector;

import java.util.concurrent.atomic.AtomicBoolean;


public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private int index;
    private long timeStamp;
    ProductSelector productSelector;
    ViewPager viewPager;
    static AtomicBoolean hasInitProductListener = new AtomicBoolean(false);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productSelector = new ProductSelector(this);
        viewPager = (ViewPager) findViewById(R.id.productSelector);
        viewPager.setAdapter(productSelector);

        /**
         * 初始化SDK，通过网络验证APPKey的有效性
         */
        String appKey = "<SDK license should be input>";
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

        /**
         * 监听SDK连接到的设备
         */
        Autel.setProductConnectListener(new ProductConnectListener() {
            /**
             * 当设备连接成功后回调，并进入相应产品的业务中
             * @param product
             */
            @Override
            public void productConnected(BaseProduct product) {
                Log.v("productType", "product " + product.getType());
                /**
                 * 避免从WiFi切换到USB时，重新弹起MainActivity界面
                 */
                hasInitProductListener.compareAndSet(false,true);
                ((TestApplication) getApplicationContext()).setCurrentProduct(product);
                viewPager.setCurrentItem(productSelector.productConnected(product.getType()));
            }

            /**
             * SDK 连接的设备断开时回调
             */
            @Override
            public void productDisconnected() {
                Log.v("productType", "productDisconnected ");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        productSelector.productConnected(AutelProductType.UNKNOWN);
                    }
                });
            }
        });
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 123);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Autel.destroy();
        hasInitProductListener.set(false);
    }


    public void onBackPressed() {
        if (System.currentTimeMillis() - timeStamp < 1500) {
            super.onBackPressed();
        }
        timeStamp = System.currentTimeMillis();
    }

    public static void receiveUsbStartCommand(Context context) {
        if (hasInitProductListener.compareAndSet(false, true)) {
            Intent i = new Intent();
            i.setClass(context, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
