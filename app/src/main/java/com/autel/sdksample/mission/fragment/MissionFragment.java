package com.autel.sdksample.mission.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.common.mission.AutelMission;
import com.autel.common.mission.CurrentMissionState;
import com.autel.common.mission.MissionExecuteState;
import com.autel.common.mission.OrbitMission;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.Waypoint;
import com.autel.common.mission.WaypointMission;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdk.product.XStarPremiumAircraft;
import com.autel.sdksample.MissionActivity;
import com.autel.sdksample.R;
import com.autel.sdksample.TestApplication;
import com.autel.sdksample.mission.MapActivity;

import java.util.List;


public abstract class MissionFragment extends Fragment {
    Button missionPrepare;
    Button missionStart;
    Button missionPause;
    Button missionResume;
    Button missionCancel;
    Button missionDownload;
    Button yawRestore;
    Button getCurrentMission;
    Button getMissionExecuteState;
    Spinner finishActionSpinner;
    ProgressBar progressBarDownload;
    ProgressBar progressBarPrepare;

    MissionManager missionManager;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(R.layout.fragment_mission_menu);
        return view;
    }

    protected MissionManager getMissionManager() {
        BaseProduct
                product = ((TestApplication) getActivity().getApplicationContext()).getCurrentProduct();
        if (null != product) {
            switch (product.getType()) {
                case X_STAR:
                    return ((XStarAircraft) product).getMissionManager();
                case PREMIUM:
                    return ((XStarPremiumAircraft) product).getMissionManager();
            }

        }
        return null;
    }

    protected View createView(@LayoutRes int resource) {
        View view = View.inflate(getContext(), resource, null);
        initUi(view);
        return view;
    }

    private void initUi(View view) {
        if (getActivity() != null){
            ((MapActivity) getActivity()).updateMissionInfo("Mission state : ");
            ((MapActivity) getActivity()).updateLogInfo("RealTimeInfo : ");
        }
        missionManager = getMissionManager();

        view.findViewById(R.id.setRealTimeInfoListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    missionManager.setRealTimeInfoListener(new CallbackWithTwoParams<CurrentMissionState, RealTimeInfo>() {
                        @Override
                        public void onSuccess(CurrentMissionState currentMissionState, RealTimeInfo realTimeInfo) {
                            if (getActivity() != null){
                                ((MapActivity) getActivity()).updateMissionInfo("Mission state : " + currentMissionState);
                                ((MapActivity) getActivity()).updateLogInfo("RealTimeInfo : " + realTimeInfo);
                            }
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            if (getActivity() != null)
                                ((MapActivity) getActivity()).updateMissionInfo("Mission state : " + autelError.getDescription());
                        }
                    });
                }
            }
        });

        view.findViewById(R.id.resetRealTimeInfoListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    missionManager.setRealTimeInfoListener(null);
                }
            }
        });

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

                            if (autelMission instanceof WaypointMission) {

                                List<Waypoint> wpList = ((WaypointMission) autelMission).wpList;
                            } else if (autelMission instanceof OrbitMission) {

                            }
                            showDownloadMission(autelMission.toString());
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

        view.findViewById(R.id.yawRestore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    missionManager.yawRestore(new CallbackWithNoParam() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(applicationContext, R.string.mission_yaw_restore_notify, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(AutelError autelError) {
                            Toast.makeText(applicationContext, autelError.getDescription(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        view.findViewById(R.id.getCurrentMission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    AutelMission mission = missionManager.getCurrentMission();
                    ((MapActivity) getActivity()).updateLogInfo(null != mission ? mission.toString() : "null");
                }
            }
        });

        view.findViewById(R.id.getMissionExecuteState).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != missionManager) {
                    MissionExecuteState state = missionManager.getMissionExecuteState();
                    ((MapActivity) getActivity()).updateLogInfo(null != state ? state.toString() : "UNKNOWN");
                }
            }
        });
    }

    private void showDownloadMission(String info) {
        ((MapActivity) getActivity()).updateLogInfo(info);
    }

    protected boolean isEmpty(String value) {
        return null == value || "".equals(value);
    }

    protected abstract AutelMission createAutelMission();

    public void onDestroy() {
        super.onDestroy();
        if (null != missionManager) {
            missionManager.setRealTimeInfoListener(null);
        }
    }
}
