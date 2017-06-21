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
import com.autel.internal.autel.authorization.network.AuthorityState;
import com.autel.sdk.Autel;
import com.autel.sdk.dsp.AutelDsp;
import com.autel.sdk.product.BaseProduct;

import java.util.ArrayList;
import java.util.List;


public class TesterEntry extends BaseActivity {
    private TextView dsp_log;
    private Spinner authorityFilter;
    private AutelDsp autelDsp;

    private static AutelCancellable getRFList;
    private static AutelCancellable getCurrentRF;
    private static AutelCancellable setCurrentRF;

    private AuthorityFilterAdapter authorityFilterAdapter;
    private AuthoritySituation authoritySituation = null;

    @Override
    protected void initOnCreate() {
        setTitle("TesterEntry");

        setContentView(R.layout.activity_test_entry);

        authorityFilterAdapter = new AuthorityFilterAdapter(this);
        authorityFilter = (Spinner) findViewById(R.id.authorityFilter);
        authorityFilter.setAdapter(authorityFilterAdapter);
        authorityFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                authoritySituation = ((AuthoritySituation) authorityFilterAdapter.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        initClick();
    }

    private void initClick() {
        findViewById(R.id.authorityCheckStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != authoritySituation) {
                    Autel.testCheckAuthority(authoritySituation.appId, authoritySituation.appKey, authoritySituation.appVersion, new CallbackWithOneParam<AuthorityState>() {
                        @Override
                        public void onSuccess(AuthorityState state) {
                            logOut("testCheckAuthority onSuccess " + state);
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            logOut("testCheckAuthority onFailure  " + autelError.getDescription());
                        }
                    });
                }
            }
        });
        findViewById(R.id.authorityCheckStartManually).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appId = ((EditText) findViewById(R.id.appIdValue)).getText().toString();
                String appVersion = ((EditText) findViewById(R.id.appVersionValue)).getText().toString();
                String appKey = ((EditText) findViewById(R.id.appKeyValue)).getText().toString();
                if (null != authoritySituation) {
                    Autel.testCheckAuthority(appId, appKey, appVersion, new CallbackWithOneParam<AuthorityState>() {
                        @Override
                        public void onSuccess(AuthorityState state) {
                            logOut("testCheckAuthority onSuccess " + state);
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            logOut("testCheckAuthority onFailure  " + autelError.getDescription());
                        }
                    });
                }
            }
        });
    }

    static class AuthorityFilterAdapter extends BaseAdapter {
        private List<AuthoritySituation> authoritySituations = new ArrayList<>();
        private Context mContext;

        public AuthorityFilterAdapter(Context context) {
            mContext = context;
            authoritySituations.add(AuthoritySituation.Normal);
            authoritySituations.add(AuthoritySituation.Version_Disable);
            authoritySituations.add(AuthoritySituation.Version_Restricted);
            authoritySituations.add(AuthoritySituation.Version_Normal);
        }

        public void setRfData(List<AuthoritySituation> authoritySituations) {
            this.authoritySituations = authoritySituations;
            notifyDataSetInvalidated();
        }

        @Override
        public int getCount() {
            return null == authoritySituations ? 0 : authoritySituations.size();
        }

        @Override
        public Object getItem(int position) {
            return authoritySituations.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = null;
            if (null == convertView) {
                convertView = View.inflate(mContext, R.layout.spinner_item, null);

            }
            textView = (TextView) convertView.findViewById(R.id.spinner_item_text);
            textView.setText(authoritySituations.get(position).toString());
            return convertView;
        }
    }

    public enum AuthoritySituation {
        Normal("com.autel.maxlink", "1.0", "auto authority"),
        Version_Disable("com.autel.sdksample", "0.9", "eeca947d3cc041581eaa1dfff38228d6"),
        Version_Restricted("com.autel.sdksample", "1.0", "eeca947d3cc041581eaa1dfff38228d6"),
        Version_Normal("com.autel.sdksample", "1.1", "eeca947d3cc041581eaa1dfff38228d6");
        String appId;
        String appVersion;
        String appKey;

        AuthoritySituation(String appId, String appVersion, String appKey) {
            this.appId = appId;
            this.appVersion = appVersion;
            this.appKey = appKey;
        }

        public String getAppId() {
            return appId;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public String getAppKey() {
            return appKey;
        }

        @Override
        public String toString() {
            return "appId : " + appId + ", appVersion : " + appVersion;
        }
    }
}
