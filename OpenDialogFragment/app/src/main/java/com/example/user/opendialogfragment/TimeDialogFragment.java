package com.example.user.opendialogfragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeDialogFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Inflating layout for the dialog */
        View v = inflater.inflate(R.layout.dialog_layout, null);

        /** Getting the arguments passed to this fragment. Here we expects the selected item's position as argument */
        Bundle b = getArguments();

        /** Setting the title for the dialog window */
        getDialog().setTitle("Time @ " + Country.name[b.getInt("position")] );

        /** Getting the reference to the TextView object of the layout */
        TextView tv = (TextView) v.findViewById(R.id.tv_current_time);

        /** Setting the current time to the TextView object of the layout */
        tv.setText(getCurTime(b.getInt("position")));

        /** Returns the View object */
        return v;
    }

    /**
     * @param position .The position of the selected list item
     * @return. Returns the current time corresponding to the selected country
     */
    public String getCurTime(int position){
        String curTime = "";

        /** Creating TimeZone object corresponding to the selected country */
        TimeZone timezone = TimeZone.getTimeZone(Country.tz[position]);

        /** Creating a DateFormat object */
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT);

        /** Setting the TimeZone for the DateFormat object */
        df.setTimeZone(timezone);

        /** Getting the current date */
        Date d = new Date();

        /** Formatting the current date with DateFormat object */
        curTime = df.format(d);

        /** Returns the formatted date corresponds to the selected country */
        return curTime;
    }
}
