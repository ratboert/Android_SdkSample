package com.autel.sdksample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.AutelCancellable;
import com.autel.common.dsp.DspVersionInfo;
import com.autel.common.dsp.RFData;
import com.autel.common.error.AutelError;
import com.autel.sdk.dsp.AutelDsp;
import com.autel.sdk.product.BaseProduct;

import java.util.List;


public class DspActivity extends BaseActivity {
    private TextView dsp_log;
    private EditText dsp_set_rf_value;
    private EditText ssidName;
    private EditText ssidPwd;
    private Spinner dspRFList;
    private AutelDsp autelDsp;

    private static AutelCancellable getRFList;
    private static AutelCancellable getCurrentRF;
    private static AutelCancellable setCurrentRF;

    private RFListAdapter rfListAdapter;
    private int selectedRFHz = -1;

    @Override
    protected void initOnCreate() {
        setTitle("DSP");
        BaseProduct baseProduct = getCurrentProduct();
        if (baseProduct != null) {
            autelDsp = baseProduct.getDsp();
        }

        setContentView(R.layout.activity_dsp);
        ssidName = (EditText) findViewById(R.id.SSIDName);
        ssidPwd = (EditText) findViewById(R.id.SSIDPwd);

        rfListAdapter = new RFListAdapter(this);
        dspRFList = (Spinner) findViewById(R.id.dspRFList);
        dspRFList.setAdapter(rfListAdapter);
        dspRFList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedRFHz = ((RFData) rfListAdapter.getItem(position)).hz;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        initClick();
    }

    private void initClick() {
        findViewById(R.id.setCurrentRFAStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (-1 == selectedRFHz) {
                    logOut("setCurrentRFData  error  has not select a RF Hz");
                    return;
                }
                setCurrentRF = autelDsp.setCurrentRFData(selectedRFHz, 3, new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setCurrentRFData  error  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setCurrentRFData  onSuccess");
                    }
                });
            }
        });
        findViewById(R.id.setCurrentRFACancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != setCurrentRF) {
                    setCurrentRF.cancel();
                }
            }
        });
        findViewById(R.id.getCurrentRFStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentRF = autelDsp.getCurrentRFData(3, new CallbackWithOneParam<RFData>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getCurrentRFData  error  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(RFData data) {
                        logOut("getCurrentRFData  " + data);
                    }
                });
            }
        });
        findViewById(R.id.getCurrentRFCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != getCurrentRF) {
                    getCurrentRF.cancel();
                }
            }
        });
        findViewById(R.id.getRFListStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRFList = autelDsp.getRFDataList(3, new CallbackWithOneParam<List<RFData>>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getRFDataList  error  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(List<RFData> data) {
                        rfListAdapter.setRfData(data);
                        dspRFList.setAdapter(rfListAdapter);
                        logOut("getRFDataList  data  " + data);
                    }
                });
            }
        });
        findViewById(R.id.getRFListCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != getRFList) {
                    getRFList.cancel();
                }
            }
        });
        findViewById(R.id.updateNewSSIDInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelDsp.updateNewSSIDInfo(ssidName.getText().toString(), ssidPwd.getText().toString(), new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("updateNewSSIDInfo  error  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("updateNewSSIDInfo  onSuccess");
                    }
                });
            }
        });
        findViewById(R.id.getCurrentSSIDInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut("getCurrentSSIDInfo  " + autelDsp.getCurrentSSIDInfo());
            }
        });
        findViewById(R.id.getVersionInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelDsp.getVersionInfo(new CallbackWithOneParam<DspVersionInfo>() {
                    @Override
                    public void onSuccess(DspVersionInfo dspVersionInfo) {
                        logOut("getVersionInfo  onSuccess {" + dspVersionInfo+"}");
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("getVersionInfo onFailure : "+autelError.getDescription());
                    }
                });

            }
        });
    }

    static class RFListAdapter extends BaseAdapter {
        private List<RFData> rfData;
        private Context mContext;

        public RFListAdapter(Context context) {
            mContext = context;
        }

        public void setRfData(List<RFData> rfData) {
            this.rfData = rfData;
            notifyDataSetInvalidated();
        }

        @Override
        public int getCount() {
            return null == rfData ? 0 : rfData.size();
        }

        @Override
        public Object getItem(int position) {
            return rfData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                convertView = View.inflate(mContext, R.layout.spinner_item__rf_hz, null);
            }

            ((TextView) convertView.findViewById(R.id.rfHz)).setText("" + rfData.get(position).hz);

            return convertView;
        }
    }
}
