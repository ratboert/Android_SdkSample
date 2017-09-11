package com.autel.sdksample;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.autel.common.product.AutelProductType;
import com.autel.sdk.Autel;
import com.autel.sdk.ProductConnectListener;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdksample.g2.G2Layout;
import com.autel.sdksample.xstar.XStarLayout;

import java.util.concurrent.atomic.AtomicBoolean;


public class ProductActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private int index;
    private long timeStamp;
    static AtomicBoolean hasInitProductListener = new AtomicBoolean(false);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

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
                setTitle(product.getType().toString());
                setContentView(createView(product.getType()));
                /**
                 * 避免从WiFi切换到USB时，重新弹起MainActivity界面
                 */
                hasInitProductListener.compareAndSet(false, true);

                BaseProduct previous = ((TestApplication) getApplicationContext()).getCurrentProduct();
                ((TestApplication) getApplicationContext()).setCurrentProduct(product);
                /**
                 * 如果产品类型发生变化，退出到该界面下
                 */
                if (null != previous) {
                    if (previous.getType() != product.getType()) {
                        startActivity(new Intent(getApplicationContext(), ProductActivity.class));
                    }
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
                        setTitle("disconnected");
                    }
                });
            }
        });
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 123);
        }
    }

    private View createView(AutelProductType productType) {
        switch (productType) {
            case X_STAR:
                return new XStarLayout(this).getLayout();
            case G2:
                return new G2Layout(this).getLayout();

        }
        return new XStarLayout(this).getLayout();
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
            i.setClass(context, ProductActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
