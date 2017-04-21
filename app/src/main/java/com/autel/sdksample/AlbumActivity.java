package com.autel.sdksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.autel.sdksample.util.AlbumTest;


public class AlbumActivity extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();
//    RadioGroup group;
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
    int cType = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        log_output = (TextView) findViewById(R.id.log_output);
//        group = (RadioGroup) findViewById(R.id.type);
//        RadioButton radioGroup = (RadioButton) findViewById(R.id.async);
//        radioGroup.toggle();
//        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (R.id.async == checkedId) {
//                    cType = 1;
//                } else {
//                    cType = 2;
//                }
//
//            }
//        });
    }

    public void getAlbumMedia(View view) {
        AlbumTest.getAlbumMedia(handler);
    }

    public void deleteAlbumMedia(View view) {
        AlbumTest.deleteAlbumMedia(handler);
    }

    public void getVideoResolutionFromHttpHeader(View view) {
        AlbumTest.getVideoResolutionFromHttpHeader(handler);
    }

    public void getVideoResolutionFromLocalFile(View view) {
        AlbumTest.getVideoResolutionFromLocalFile(handler);

    }

    public void testAuthor(View view) {
        //*/
//        AuthorityManager.getInstance()
//                .startCheckKeyValidateState(
//                        this,
//                        "cdb4fcbe62ca8daa51d5af019dc87173",
//                        new CallbackWithOneParam<AuthorityState>() {
//                            @Override
//                            public void onSuccess(AuthorityState data) {
//                                Log.v("AuthorTest", "checkAppKeyValidate " + data);
//                            }
//
//                            @Override
//                            public void onFailure(AutelError error) {
//                                Log.v("AuthorTest", "checkAppKeyValidate " + error.getDescription());
//                            }
//                        });
        /*/


        new Thread(){
            @Override
            public void run() {

                Map<String, Object> requestParams = new HashMap<>();
                requestParams.put("appId", "27c053abc1fc831dc8c204f12e952976");
                requestParams.put("appKey", "cdb4fcbe62ca8daa51d5af019dc87173");
                requestParams.put("appName", "testApp");
                requestParams.put("appVer", "1.2");
                Log.v("testsign", "getSign  "+SignUtil.getSign(requestParams));
                Log.v("testsign", "getSign  "+ Utils.encryptionCode("abcde"));
                Log.v("testsign", "getSign  "+ Utils.decryptionCode(Utils.encryptionCode("abcde")));
            }
        }.start();
        //*/

    }
}

