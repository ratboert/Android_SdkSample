package com.autel.sdksample;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.battery.BatteryParameterRangeManager;
import com.autel.common.battery.BatteryRecordState;
import com.autel.common.battery.BatteryStatus;
import com.autel.common.error.AutelError;
import com.autel.sdk.battery.AutelBattery;
import com.autel.sdk.product.BaseProduct;

import java.util.List;


public class BatteryActivity extends BaseActivity {
    private AutelBattery autelBattery;

    private EditText lowBatteryNotifyThreshold;
    private EditText criticalBatteryNotifyThreshold;
    private EditText dischargeDay;

    @Override
    protected void initOnCreate() {
        setContentView(R.layout.activity_battery);
        setTitle("Battery");
        BaseProduct product = getCurrentProduct();
        if (null != product) {
            autelBattery = product.getBattery();
        }
        lowBatteryNotifyThreshold = (EditText) findViewById(R.id.lowBatteryNotifyThreshold);
        criticalBatteryNotifyThreshold = (EditText) findViewById(R.id.criticalBatteryNotifyThreshold);
        dischargeDay = (EditText) findViewById(R.id.dischargeDay);

        final TextView lowBatteryRange = (TextView) findViewById(R.id.lowBatteryRange);
        lowBatteryNotifyThreshold.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (isEmpty(lowBatteryRange.getText().toString())) {
                    autelBattery.getParameterSupportManager(new CallbackWithOneParam<BatteryParameterRangeManager>() {
                        @Override
                        public void onSuccess(BatteryParameterRangeManager batteryParameterRangeManager) {
                            RangePair<Float> support = batteryParameterRangeManager.getLowBattery();
                            lowBatteryRange.setText("low battery range from " + support.getValueFrom() + " to " + support.getValueTo());
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            logOut("getParameterSupportManager  error :  " + autelError.getDescription());
                        }
                    });
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final TextView criticalBatteryRange = (TextView) findViewById(R.id.criticalBatteryRange);
        criticalBatteryNotifyThreshold.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (isEmpty(criticalBatteryRange.getText().toString())) {
                    autelBattery.getParameterSupportManager(new CallbackWithOneParam<BatteryParameterRangeManager>() {
                        @Override
                        public void onSuccess(BatteryParameterRangeManager batteryParameterRangeManager) {
                            RangePair<Float> support = batteryParameterRangeManager.getCriticalBattery();
                            criticalBatteryRange.setText("critical battery range from " + support.getValueFrom() + " to " + support.getValueTo());
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            logOut("getParameterSupportManager  error :  " + autelError.getDescription());
                        }
                    });
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        final TextView dischargeDayRange = (TextView) findViewById(R.id.dischargeDayRange);
        dischargeDay.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (isEmpty(dischargeDayRange.getText().toString())) {
                    autelBattery.getParameterSupportManager(new CallbackWithOneParam<BatteryParameterRangeManager>() {
                        @Override
                        public void onSuccess(BatteryParameterRangeManager batteryParameterRangeManager) {
                            RangePair<Integer> support = batteryParameterRangeManager.getDischargeDay();
                            dischargeDayRange.setText("discharge day range from " + support.getValueFrom() + " to " + support.getValueTo());
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            logOut("getParameterSupportManager  error :  " + autelError.getDescription());
                        }
                    });
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        initClick();
    }

    private void initClick() {
        findViewById(R.id.getLowBatteryNotifyThreshold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getLowBatteryNotifyThreshold(new CallbackWithOneParam<Float>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getLowBatteryNotifyThreshold  error :  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(Float data) {
                        logOut("getLowBatteryNotifyThreshold  data :  " + data);
                    }
                });
            }
        });
        findViewById(R.id.setLowBatteryNotifyThreshold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = lowBatteryNotifyThreshold.getText().toString();
                autelBattery.setLowBatteryNotifyThreshold(isEmpty(value) ? 0.25f : Float.valueOf(value), new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setLowBatteryNotifyThreshold  error :  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setLowBatteryNotifyThreshold   onSuccess ");
                    }
                });
            }
        });
        findViewById(R.id.getCriticalBatteryNotifyThreshold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getCriticalBatteryNotifyThreshold(new CallbackWithOneParam<Float>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getCriticalBatteryNotifyThreshold  error :  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(Float data) {
                        logOut("getCriticalBatteryNotifyThreshold  data :  " + data);
                    }
                });
            }
        });
        findViewById(R.id.setCriticalBatteryNotifyThreshold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = criticalBatteryNotifyThreshold.getText().toString();
                autelBattery.setCriticalBatteryNotifyThreshold(isEmpty(value) ? 0.25f : Float.valueOf(value), new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setCriticalBatteryNotifyThreshold  error :  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setCriticalBatteryNotifyThreshold  onSuccess  ");
                    }
                });
            }
        });
        findViewById(R.id.getDischargeDay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getDischargeDay(new CallbackWithOneParam<Integer>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getDischargeDay  error :  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(Integer data) {
                        logOut("getDischargeDay  data :  " + data);
                    }
                });
            }
        });
        findViewById(R.id.setDischargeDay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = dischargeDay.getText().toString();
                autelBattery.setDischargeDay(isEmpty(value) ? 2 : Integer.valueOf(value), new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {

                        logOut("setDischargeDay  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("setDischargeDay  error :  " + autelError.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.getHistory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getHistory(new CallbackWithOneParam<List<BatteryRecordState>>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getHistory  error :  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(List<BatteryRecordState> data) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i = 0; i < data.size(); i++) {
                            stringBuffer.append(i);
                            stringBuffer.append(" = ");
                            stringBuffer.append(data.get(i));
                            stringBuffer.append(";");
                        }
                        logOut("getHistory  data :  " + stringBuffer.toString());
                    }
                });
            }
        });
        findViewById(R.id.getCells).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getCells(new CallbackWithOneParam<int[]>() {
                    @Override
                    public void onSuccess(int[] data) {
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < data.length; i++) {
                            sb.append("index ");
                            sb.append(i);
                            sb.append(" = ");
                            sb.append(data[i]);
                            sb.append("   ");
                        }
                        logOut("getCells  " + sb.toString());
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getCells  error : " + error.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.getVoltage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getVoltage(new CallbackWithOneParam<Double>() {
                    @Override
                    public void onSuccess(Double data) {
                        logOut("getVoltage  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getVoltage  error : " + error.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.getCapacity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getCapacity(new CallbackWithOneParam<Float>() {
                    @Override
                    public void onSuccess(Float data) {
                        logOut("getCapacity  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getCapacity  error : " + error.getDescription());
                    }
                });
            }
        });

        findViewById(R.id.resetBatteryRealTimeDataListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.setAutelBatteryStatusListener(null);
            }
        });
        findViewById(R.id.setBatteryRealTimeDataListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.setAutelBatteryStatusListener(new CallbackWithOneParam<BatteryStatus>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setAutelBatteryStatusListener  error :  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(BatteryStatus data) {
                        logOut("setAutelBatteryStatusListener  data current battery :  " + data);
                    }
                });
            }
        });
        findViewById(R.id.getDesignCapacity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getDesignCapacity(new CallbackWithOneParam<Integer>() {
                    @Override
                    public void onSuccess(Integer data) {
                        logOut("getDesignCapacity  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getDesignCapacity  error : " + error.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.getVersion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getVersion(new CallbackWithOneParam<String>() {
                    @Override
                    public void onSuccess(String data) {
                        logOut("getVersion  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getVersion  error : " + error.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.getSerialNumber).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getSerialNumber(new CallbackWithOneParam<String>() {
                    @Override
                    public void onSuccess(String data) {
                        logOut("getSerialNumber  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getSerialNumber  error : " + error.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.getRemainingPercent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getVoltage(new CallbackWithOneParam<Double>() {
                    @Override
                    public void onSuccess(Double data) {
                        logOut("getRemainingPercent  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getRemainingPercent  error : " + error.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.getFullChargeCapacity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getFullChargeCapacity(new CallbackWithOneParam<Integer>() {
                    @Override
                    public void onSuccess(Integer data) {
                        logOut("getFullChargeCapacity  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getFullChargeCapacity error : " + error.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.getDischargeCount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getDischargeCount(new CallbackWithOneParam<Float>() {
                    @Override
                    public void onSuccess(Float data) {
                        logOut("getDischargeCount  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getDischargeCount error : " + error.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.getTemperature).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getTemperature(new CallbackWithOneParam<Float>() {
                    @Override
                    public void onSuccess(Float data) {
                        logOut("getTemperature  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getTemperature error : " + error.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.getCurrent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelBattery.getCurrent(new CallbackWithOneParam<Float>() {
                    @Override
                    public void onSuccess(Float data) {
                        logOut("getCurrent  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getCurrent error : " + error.getDescription());
                    }
                });
            }
        });
    }
}
