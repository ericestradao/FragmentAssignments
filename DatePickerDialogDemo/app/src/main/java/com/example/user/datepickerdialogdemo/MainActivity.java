package com.example.user.datepickerdialogdemo;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int mDay = 15;
    int mMonth = 7; // August, month starts from 0
    int mYear= 2012;

    /** This handles the message send from DatePickerDialogFragment on setting date */
    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message m){
            /** Creating a bundle object to pass currently set date to the fragment */
            Bundle b = m.getData();

            /** Getting the day of month from bundle */
            mDay = b.getInt("set_day");

            /** Getting the month of year from bundle */
            mMonth = b.getInt("set_month");

            /** Getting the year from bundle */
            mYear = b.getInt("set_year");

            /** Displaying a short time message containing date set by Date picker dialog fragment */
            Toast.makeText(getBaseContext(), b.getString("set_date"), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Click Event Handler for button */
        View.OnClickListener listener = new View.OnClickListener() {

            public void onClick(View v) {

                /** Creating a bundle object to pass currently set date to the fragment */
                Bundle b = new Bundle();

                /** Adding currently set day to bundle object */
                b.putInt("set_day", mDay);

                /** Adding currently set month to bundle object */
                b.putInt("set_month", mMonth);

                /** Adding currently set year to bundle object */
                b.putInt("set_year", mYear);

                /** Instantiating DatePickerDialogFragment */
                DatePickerDialogFragment datePicker = new DatePickerDialogFragment(mHandler);

                /** Setting the bundle object on datepicker fragment */
                datePicker.setArguments(b);

                /** Getting fragment manger for this activity */
                FragmentManager fm = getSupportFragmentManager();

                /** Starting a fragment transaction */
                FragmentTransaction ft = fm.beginTransaction();

                /** Adding the fragment object to the fragment transaction */
                ft.add(datePicker, "date_picker");

                /** Opening the DatePicker fragment */
                ft.commit();
            }
        };

        /** Getting an instance of Set Date button */
        Button btnSet = (Button)findViewById(R.id.btnSet);

        /** Setting click event listener for the button */
        btnSet.setOnClickListener((View.OnClickListener) listener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}