package com.example.user.timepickerdialogdemo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;

@SuppressLint("ValidFragment")
public class TimePickerDialogFragment extends DialogFragment {
    Handler mHandler ;
    int mHour;
    int mMinute;

    public TimePickerDialogFragment(Handler h){
        mHandler = h;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        Bundle b = getArguments();
        mHour = b.getInt("set_hour");
        mMinute = b.getInt("set_minute");

        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                mHour = hourOfDay;
                mMinute = minute;

                Bundle b = new Bundle();
                b.putInt("set_hour", mHour);
                b.putInt("set_minute", mMinute);
                b.putString("set_time", "Set Time : " + Integer.toString(mHour) + " : " + Integer.toString(mMinute));
                Message m = new Message();

                m.setData(b);
                mHandler.sendMessage(m);
            }
        };

        return new TimePickerDialog(getActivity(), listener, mHour, mMinute, false);
    }
}