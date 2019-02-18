package com.example.user.timepickerdialogdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    int mHour = 15;
    int mMinute = 15;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message m){
            Bundle b = m.getData();
            mHour = b.getInt("set_hour");
            mMinute = b.getInt("set_minute");
            Toast.makeText(getBaseContext(), b.getString("set_time"), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = new Bundle();
                b.putInt("set_hour", mHour);
                b.putInt("set_minute", mMinute);
                TimePickerDialogFragment timePicker = new TimePickerDialogFragment(mHandler);
                timePicker.setArguments(b);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(timePicker, "time_picker");

                ft.commit();
            }
        };

        Button btnSet = (Button)findViewById(R.id.btnSet);
        btnSet.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
