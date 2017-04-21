package com.autel.sdksample.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParamProgress;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.common.mission.AutelCoord3D;
import com.autel.common.mission.AutelMission;
import com.autel.common.mission.CurrentMissionState;
import com.autel.common.mission.FollowMission;
import com.autel.common.mission.OrbitMission;
import com.autel.common.mission.OrbitMode;
import com.autel.common.mission.RealTimeInfo;
import com.autel.common.mission.Waypoint;
import com.autel.common.mission.WaypointMission;
import com.autel.sdk.AModuleFlyController;
import com.autel.sdk.AModuleMission;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A16343 on 2016/12/2.
 */
public class MissionTest {
    private static final String TAG = "MissionTest";

    public static void actionTakeOff(final Handler handler) {
        AModuleFlyController.flyController().takeOff(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "takeOff  error " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "takeOff state onSuccess");
            }
        });
    }

    public static void actionGoHome(final Handler handler) {
        AModuleFlyController.flyController().goHome(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "goHome  error " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "goHome state onSuccess");
            }
        });
    }

    public static void actionLand(final Handler handler) {
        AModuleFlyController.flyController().land(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "land  error " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "land state onSuccess");
            }
        });
    }

    public static void actionCancelLand(final Handler handler) {
        AModuleFlyController.flyController().cancelLand(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "cancelLand  error " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "cancelLand state onSuccess");
            }
        });
    }

    public static void actionCancelReturn(final Handler handler) {
        AModuleFlyController.flyController().cancelReturn(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "cancelReturn  error " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "cancelReturn state onSuccess");
            }
        });
    }

    public static void setFlyLocationAsHomePoint(final Handler handler) {
        AModuleFlyController.flyController().setAircraftLocationAsHomePoint(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setAircraftLocationAsHomePoint  error " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setAircraftLocationAsHomePoint state onSuccess");
            }
        });
    }

    public static void setPhoneLocationAsHomePoint(final Handler handler) {
        AModuleFlyController.flyController().setLocationAsHomePoint(35, 78, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setLocationAsHomePoint  error " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setLocationAsHomePoint state onSuccess");
            }
        });
    }

    public static void getCurrentMission(final Handler handler) {
        logOut(handler, "getCurrentMission  error " + AModuleMission.missionManager().getCurrentMission());
    }

    public static void setRealTimeInfoListener(final Handler handler) {
        AModuleMission.missionManager().setRealTimeInfoListener(new CallbackWithTwoParams<CurrentMissionState, RealTimeInfo>() {
            @Override
            public void onSuccess(CurrentMissionState data1, RealTimeInfo data2) {
                logOut(handler, "setRealTimeInfoListener data " + data2);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setRealTimeInfoListener  error " + error.getDescription());
            }
        });
    }

    public static void resetRealTimeInfoListener() {
        AModuleMission.missionManager().setRealTimeInfoListener(null);
    }


    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }

    public static void prepareMission(int type, final Handler handler, Context context) {
        AutelMission mission = null;
        if (1 == type) {
            FollowMission followMission = FollowMission.create();
//            followMission.location = new Location();
            followMission.finishReturnHeight = 30;
            testFollowMission(handler, context);
            mission = followMission;
        } else if (2 == type) {
            OrbitMission orbitMission = new OrbitMission();
            orbitMission.radius = 15f;
            orbitMission.finishReturnHeight = 10;
            orbitMission.speed = 2f;
            orbitMission.round = 5;
            orbitMission.finishReturnHeight = 30;
            mission = orbitMission;
        } else if (3 == type) {
            WaypointMission waypointMission = new WaypointMission();

            List<Waypoint> autelWaypointList = new ArrayList<>();
            autelWaypointList.add(new Waypoint(new AutelCoord3D(22.5960, 113.9975, 30)));

            waypointMission.wplist = autelWaypointList;
            waypointMission.speed = 5;
            waypointMission.finishReturnHeight = 30;
            mission = waypointMission;
        }


        AModuleMission.missionManager().prepareMission(mission, new CallbackWithOneParamProgress<Boolean>() {
            @Override
            public void onProgress(float var) {
                logOut(handler, "prepareMission onProgress " + var);
            }

            @Override
            public void onSuccess(Boolean data) {
                logOut(handler, "prepareMission data " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "prepareMission  error " + error.getDescription());
            }
        });

    }

    private static void testFollowMission(final Handler handler, Context context) {
        LocationListener mLocationListener = new LocationListener() {

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.v("PhoneGPStest", "status = " + status);
            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.e("PhoneGPStest", "onProviderEnabled  " + provider);
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.e("PhoneGPStest", "onProviderDisabled  " + provider);
            }

            @Override
            public void onLocationChanged(Location location) {
                Log.e("PhoneGPStest", "show home");

            }
        };

        LocationManager mLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


            } else {
//                mLocationManager.addGpsStatusListener(mGPSListener);
                mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0, mLocationListener);
            }

        }
    }

    public static void startMission(final Handler handler) {
        AModuleMission.missionManager().startMission(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "startMission onSuccess ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "startMission onFailure " + error.getDescription());
            }
        });
    }

    public static void pauseMission(final Handler handler) {
        AModuleMission.missionManager().pauseMission(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "pauseMission onSuccess ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "pauseMission onFailure " + error.getDescription());
            }
        });
    }

    public static void resumeMission(final Handler handler) {
        AModuleMission.missionManager().resumeMission(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "resumeMission onSuccess ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "resumeMission onFailure " + error.getDescription());
            }
        });
    }

    public static void cancelMission(final Handler handler) {
        AModuleMission.missionManager().cancelMission(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "cancelMission onSuccess ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "cancelMission onFailure " + error.getDescription());
            }
        });
    }

    public static void downloadMission(final Handler handler) {
        AModuleMission.missionManager().downloadMission(new CallbackWithOneParamProgress<AutelMission>() {
            @Override
            public void onProgress(float var) {
                logOut(handler, "downloadMission onProgress " + var);
            }

            @Override
            public void onSuccess(AutelMission data) {
                logOut(handler, "downloadMission data " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "downloadMission  error " + error.getDescription());
            }
        });
    }

    public static void actionYawRecover(final Handler handler) {
        AModuleMission.missionManager().yawRestore(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "yawRestore onSuccess ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "yawRestore  error " + error.getDescription());
            }
        });
    }
}
