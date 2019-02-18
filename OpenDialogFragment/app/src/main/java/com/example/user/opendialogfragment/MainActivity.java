package com.example.user.opendialogfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Country.name);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TimeDialogFragment timeDialogFragment = new TimeDialogFragment();
                Bundle b = new Bundle();
                b.putInt("position",position);
                timeDialogFragment.setArguments(b);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                TimeDialogFragment tPrev = (TimeDialogFragment) fragmentManager.findFragmentByTag("time_dialog");
                if(tPrev != null)
                    fragmentTransaction.remove(tPrev);
                    timeDialogFragment.show(fragmentTransaction, "time_dialog");
            }
        };
       list.setOnItemClickListener(listener);

    }

}
