package com.autel.sdksample.mission.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.DragEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.autel.sdksample.R;

/**
 * Created by A15387 on 2016/6/17.
 */
public class WaypointSettingDialog {


    private final Dialog waypointSettingDialog;
    private final int position;

    public WaypointSettingDialog(Context context,int position){
        this.position = position;
        waypointSettingDialog = new Dialog(context,android.R.style.Theme_Translucent);
        waypointSettingDialog.setContentView(R.layout.dialog_waypoint_setting);
        waypointSettingDialog.findViewById(R.id.dialog_waypoint_setting_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waypointSettingDialog.dismiss();
            }
        });
        ((TextView)waypointSettingDialog.findViewById(R.id.text_waypoint_index)).setText((position + 1) + "");
        ((SeekBar)waypointSettingDialog.findViewById(R.id.seekbar_waypoint_delay_time)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView)waypointSettingDialog.findViewById(R.id.text_waypoint_delay_time)).setText(progress + " s");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void showDialog(){
        if(waypointSettingDialog != null && !waypointSettingDialog.isShowing()){
            waypointSettingDialog.show();
        }
    }

    public void setOnConfirmClickListener(final OnDialogOkClickListener onConfirmClickListener) {
        if(waypointSettingDialog != null && waypointSettingDialog.isShowing()){
            waypointSettingDialog.findViewById(R.id.text_waypoint_ok).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double height = Double.parseDouble(((EditText)waypointSettingDialog.findViewById(R.id.edit_waypoint_height)).getText().toString());
                    int delay = ((SeekBar)waypointSettingDialog.findViewById(R.id.seekbar_waypoint_delay_time)).getProgress();
                    onConfirmClickListener.onDialogOkClick(height,delay,position);
                    waypointSettingDialog.dismiss();
                }
            });
        }
    }

    public interface OnDialogOkClickListener{
        void onDialogOkClick(double height,int delayTime,int position);
    }
}
