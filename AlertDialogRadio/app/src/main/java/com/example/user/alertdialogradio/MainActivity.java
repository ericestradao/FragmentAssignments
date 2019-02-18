package com.example.user.alertdialogradio;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AlertDialogRadio.AlertPositiveListener {
    int position = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                AlertDialogRadio alert = new AlertDialogRadio();
                Bundle b = new Bundle();
                b.putInt("position", position);
                alert.setArguments(b);
                alert.show(fragmentManager, "alert_dialog_radio");

            }
        };
        Button btn = (Button) findViewById(R.id.btn_choose);
        btn.setOnClickListener(listener);


    }

    @Override
    public void onPositiveClick(int position) {
        this.position = position;
        TextView tv = (TextView) findViewById(R.id.tv_android);
        tv.setText("Your choice : "+Android.code[this.position]);
    }
}
