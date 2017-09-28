package com.autel.sdksample.g2;

import android.os.Bundle;
import android.view.View;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.g2.G2BatteryInfo;
import com.autel.common.error.AutelError;
import com.autel.sdk.battery.AutelBattery;
import com.autel.sdk.battery.G2Battery;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.G2Aircraft;
import com.autel.sdksample.R;
import com.autel.sdksample.base.BatteryActivity;


public class G2BatteryActivity extends BatteryActivity {
    private G2Battery mG2Battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Battery");
    }

    @Override
    protected AutelBattery initController(BaseProduct product) {
        mG2Battery = ((G2Aircraft) product).getBattery();
        return mG2Battery;
    }

    @Override
    protected int getCustomViewResId() {
        return R.layout.activity_g2_battery;
    }

    @Override
    protected void initUi() {
        super.initUi();
        findViewById(R.id.resetBatteryRealTimeDataListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mG2Battery.setBatteryStateListener(null);
            }
        });
        findViewById(R.id.setBatteryRealTimeDataListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mG2Battery.setBatteryStateListener(new CallbackWithOneParam<G2BatteryInfo>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setBatteryStateListener  error :  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(G2BatteryInfo data) {
                        logOut("setBatteryStateListener  data current battery :  " + data.toString());
                    }
                });
            }
        });
    }
}
