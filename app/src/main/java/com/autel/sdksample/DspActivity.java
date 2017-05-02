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
import com.autel.common.dsp.RFData;
import com.autel.common.error.AutelError;
import com.autel.sdk.AModuleDsp;
import com.autel.sdk.dsp.AutelDsp;

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
        autelDsp = AModuleDsp.dsp();

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
    }

    public void setCurrentRFAStart(View v) {
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

    public void setCurrentRFACancel(View v) {
        if (null != setCurrentRF) {
            setCurrentRF.cancel();
        }
    }

    public void getCurrentRFStart(View v) {
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

    public void getCurrentRFCancel(View v) {
        if (null != getCurrentRF) {
            getCurrentRF.cancel();
        }
    }

    public void getRFListStart(View v) {
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

    public void getRFListCancel(View v) {
        if (null != getRFList) {
            getRFList.cancel();
        }
    }

    public void updateNewSSIDInfo(View v) {
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

    public void getCurrentSSIDInfo(View v) {
        logOut("getCurrentSSIDInfo  " + autelDsp.getCurrentSSIDInfo());
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
