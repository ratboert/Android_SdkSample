package com.autel.sdksample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.autel.common.error.AutelError;
import com.autel.sdk.Autel;
import com.autel.sdk.video.AutelCodecListener;
import com.autel.sdk.widget.AutelCodecView;

public class CodecActivity extends AppCompatActivity {

    private RelativeLayout content_layout;
    private boolean isCodecing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codec);

        content_layout = (RelativeLayout) findViewById(R.id.content_layout);

        isCodecing = false;
    }

    /**
     * Use AutelCodecView to display the video stream from camera simply.
     */
    private void initClick() {
        findViewById(R.id.testAutelCodecView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCodecing = true;

                final AutelCodecView autelCodecView = new AutelCodecView(CodecActivity.this);
                content_layout.setVisibility(View.VISIBLE);
                content_layout.addView(autelCodecView);

                LinearLayout btn_layout = new LinearLayout(CodecActivity.this);
                btn_layout.setOrientation(LinearLayout.VERTICAL);

                Button btn_exp = new Button(CodecActivity.this);
                btn_exp.setText("Exposure");
                btn_exp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        autelCodecView.setOverExposure(!autelCodecView.isOverExposureEnabled(), R.mipmap.expo2560);
                    }
                });

                Button btn_pause = new Button(CodecActivity.this);
                btn_pause.setText("Pause");
                btn_pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        autelCodecView.pause();
                    }
                });

                Button btn_resume = new Button(CodecActivity.this);
                btn_resume.setText("Resume");
                btn_resume.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        autelCodecView.resume();
                    }
                });

                btn_layout.addView(btn_exp);
                btn_layout.addView(btn_pause);
                btn_layout.addView(btn_resume);

                content_layout.addView(btn_layout);
            }
        });

        /**
         * The H264 video stream data for developer to deal with
         */
        findViewById(R.id.testAutelCodec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCodecing = true;

                final TextView logTV = new TextView(CodecActivity.this);
                content_layout.setVisibility(View.VISIBLE);
                content_layout.addView(logTV);

                Autel.getCodec().setCodecListener(new AutelCodecListener() {
                    @Override
                    public void onFrameStream(final boolean valid, byte[] videoBuffer, final int size, final long pts) {
                        logTV.post(new Runnable() {
                            @Override
                            public void run() {
                                logTV.setText("valid == " + valid + "\n" + "size == " + size + "\n" + "pts == " + pts);
                            }
                        });
                    }

                    @Override
                    public void onCanceled() {
                        logTV.post(new Runnable() {
                            @Override
                            public void run() {
                                logTV.setText("onCandeled");
                            }
                        });
                    }

                    @Override
                    public void onFailure(final AutelError error) {
                        logTV.post(new Runnable() {
                            @Override
                            public void run() {
                                logTV.setText(error.getDescription());
                            }
                        });
                    }
                });
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (isCodecing) {
            isCodecing = false;

            content_layout.removeAllViews();
            content_layout.setVisibility(View.GONE);

            Autel.getCodec().cancel();

            return;
        }

        super.onBackPressed();
    }
}
