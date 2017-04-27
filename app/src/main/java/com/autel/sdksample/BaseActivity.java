package com.autel.sdksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by A16343 on 2017/4/26.
 */

public abstract class BaseActivity extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();
    private TextView log_output;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String text = (String) msg.obj;
            if (null != log_output) {
                log_output.setText(text);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initOnCreate();
        log_output = (TextView) findViewById(R.id.log_output);
        requestFocus(log_output);
    }

    protected abstract void initOnCreate();

    protected void logOut(String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }

    private void requestFocus(View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    protected boolean isEmpty(String value) {
        if (null == value || "".equals(value)) {
            return true;
        }
        return false;
    }
}
