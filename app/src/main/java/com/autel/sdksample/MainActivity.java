package com.autel.sdksample;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.autel.common.product.AutelProductType;
import com.autel.sdk.Autel;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdksample.adapter.ProductSelector;


public class MainActivity extends AppCompatActivity {
    private int index;
    ProductSelector productSelector;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productSelector = new ProductSelector(this);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.productSelector);
        viewPager.setAdapter(productSelector);
        Autel.setProductConnectListener(new Autel.ProductConnectListener() {
            @Override
            public void productConnected(boolean typeChanged, BaseProduct product) {
                Log.v("productType", "product " + product.getType());

                ((TestApplication) getApplicationContext()).setCurrentProduct(product);
                if (product instanceof XStarAircraft) {
                    productSelector.productConnected(AutelProductType.X_STAR);
                }
            }

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

    private AutelProductType get(int i) {
        switch (i) {
            case 0:
                return AutelProductType.X_STAR;
            case 1:
                return AutelProductType.CAM_PRO;
            case 2:
                return AutelProductType.HANDHELD;
            case 3:
                return AutelProductType.KESTREL;
            default:
                return AutelProductType.X_STAR;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        CameraConnection.instance().disconnect();
    }
}
