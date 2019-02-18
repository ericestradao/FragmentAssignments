package com.example.user.datepickerdialogdemo;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Message;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

@SuppressLint("ValidFragment")
public class DatePickerDialogFragment extends DialogFragment {
    Handler mHandler;
    int mDay;
    int mMonth;
    int mYear;

    @SuppressLint("ValidFragment")
    public DatePickerDialogFragment(Handler h){
        mHandler=h;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Bundle b=getArguments();
        mDay=b.getInt("set_day");
        mMonth=b.getInt("set_month");
        mYear=b.getInt("set_year");
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mDay = dayOfMonth;
                mMonth = month;
                mYear = year;

                Bundle b = new Bundle();
                b.putInt("set_day", mDay);
                b.putInt("set_month", mMonth);
                b.putInt("set_year", mYear);
                b.putString("set_date", "Set Date : " + Integer.toString(mDay) + " / " + Integer.toString(mMonth+1) + " / " + Integer.toString(mYear));

                Message m = new Message();
                m.setData(b);
                mHandler.sendMessage(m);
            }
        };
        return new DatePickerDialog(getActivity(),listener,mYear,mMonth,mDay);
    }
}
