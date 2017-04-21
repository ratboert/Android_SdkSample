package com.autel.sdksample.view.mission.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.error.AutelError;
import com.autel.common.mission.AutelMission;
import com.autel.common.mission.MissionFinishedAction;
import com.autel.sdk.Autel;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdksample.R;

/**
 */

public abstract class MissionFragment extends Fragment {
    Button missionPrepare;
    Button missionStart;
    Button missionPause;
    Button missionResume;
    Button missionCancel;
    Button missionDownload;
    Spinner finishActionSpinner;
    ProgressBar progressBarDownload;
    ProgressBar progressBarPrepare;

    MissionManager missionManager;
    MissionFinishedAction missionFinishedAction = MissionFinishedAction.HOVER;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(R.layout.fragment_mission_menu);

        return view;
    }

    protected View createView(@LayoutRes int resource){
        View view = View.inflate(getContext(), resource, null);
        initUi(view);
        return view;
    }
    private void initUi(View view){
        missionManager = Autel.getMissionManager();


        final Context applicationContext = getActivity().getApplicationContext();
        progressBarDownload = (ProgressBar) view.findViewById(R.id.progressBarDownload);
        progressBarPrepare = (ProgressBar) view.findViewById(R.id.progressBarPrepare);

        missionPrepare = (Button) view.findViewById(R.id.missionPrepare);
        missionPrepare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    progressBarPrepare.setVisibility(View.VISIBLE);
                    missionManager.prepareMission(createAutelMission(), new CallbackWithOneParamProgress<Boolean>() {
                        @Override
                        public void onProgress(float v) {

                        }

                        @Override
                        public void onSuccess(Boolean aBoolean) {
                            Toast.makeText(applicationContext, R.string.mission_prepare_notify, Toast.LENGTH_SHORT).show();
                            progressBarPrepare.setVisibility(View.GONE);
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            Toast.makeText(applicationContext, autelError.getDescription(), Toast.LENGTH_LONG).show();
                            progressBarPrepare.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });

        missionStart = (Button) view.findViewById(R.id.missionStart);
        missionStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    missionManager.startMission(new CallbackWithNoParam() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(applicationContext, R.string.mission_start_notify, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            Toast.makeText(applicationContext, autelError.getDescription(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        missionPause = (Button) view.findViewById(R.id.missionPause);
        missionPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    missionManager.pauseMission(new CallbackWithNoParam() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(applicationContext, R.string.mission_pause_notify, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            Toast.makeText(applicationContext, autelError.getDescription(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        missionResume = (Button) view.findViewById(R.id.missionResume);
        missionResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    missionManager.resumeMission(new CallbackWithNoParam() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(applicationContext, R.string.mission_resume_notify, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            Toast.makeText(applicationContext, autelError.getDescription(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        missionCancel = (Button) view.findViewById(R.id.missionCancel);
        missionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    missionManager.cancelMission(new CallbackWithNoParam() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(applicationContext, R.string.mission_cancel_notify, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            Toast.makeText(applicationContext, autelError.getDescription(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        missionDownload = (Button) view.findViewById(R.id.missionDownload);
        missionDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    progressBarDownload.setVisibility(View.VISIBLE);
                    missionManager.downloadMission(new CallbackWithOneParamProgress<AutelMission>() {
                        @Override
                        public void onProgress(float v) {

                        }

                        @Override
                        public void onSuccess(AutelMission autelMission) {
                            Toast.makeText(applicationContext, R.string.mission_download_notify, Toast.LENGTH_SHORT).show();
                            progressBarDownload.setVisibility(View.GONE);
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            Toast.makeText(applicationContext, autelError.getDescription(), Toast.LENGTH_LONG).show();
                            progressBarDownload.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });

        finishActionSpinner = (Spinner) view.findViewById(R.id.finishAction);
        finishActionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    missionFinishedAction = MissionFinishedAction.HOVER;
                } else if (position == 1) {
                    missionFinishedAction = MissionFinishedAction.RETURN_HOME;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    protected abstract AutelMission createAutelMission();
}
