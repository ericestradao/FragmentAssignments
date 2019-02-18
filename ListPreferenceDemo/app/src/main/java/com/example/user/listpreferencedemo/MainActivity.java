package com.example.user.listpreferencedemo;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String android_choice = sp.getString("lp_android_choice", "None selected");
        TextView tv = (TextView) findViewById(R.id.android_version);
        tv.setText(android_choice);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        TextView tv = (TextView) findViewById(R.id.android_version);
        tv.setText(newValue.toString());
        return true;
    }
}
