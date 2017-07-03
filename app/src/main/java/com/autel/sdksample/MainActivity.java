package com.autel.sdksample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.error.AutelError;
import com.autel.common.product.AutelProductType;
import com.autel.sdk.Autel;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdksample.adapter.ProductSelector;


public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private int index;
    private long timeStamp;
    ProductSelector productSelector;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productSelector = new ProductSelector(this);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.productSelector);
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
        Autel.setProductConnectListener(new Autel.ProductConnectListener() {
            /**
             * 当设备连接成功后回调，并进入相应产品的业务中
             * @param typeChanged
             * @param product
             */
            @Override
            public void productConnected(boolean typeChanged, BaseProduct product) {
                Log.v("productType", "product " + product.getType());

                ((TestApplication) getApplicationContext()).setCurrentProduct(product);
                if (product instanceof XStarAircraft) {
                    productSelector.productConnected(AutelProductType.X_STAR);
                }
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Autel.destroy();
    }


    public void onBackPressed() {
        if (System.currentTimeMillis() - timeStamp < 1500) {
            super.onBackPressed();
        }
        timeStamp = System.currentTimeMillis();
    }
}
