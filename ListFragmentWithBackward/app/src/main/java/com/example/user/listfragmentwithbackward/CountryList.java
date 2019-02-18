package com.example.user.listfragmentwithbackward;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CountryList extends ListFragment {

    /**
     * The list of countries to be shown in the ListFragment
     */
    String[] countries = new String[] {
            "India",
            "Pakistan",
            "Sri Lanka",
            "China",
            "Bangladesh",
            "Nepal",
            "Afghanistan",
            "North Korea",
            "South Korea",
            "Japan"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /**
         * Creating an array adapter to host the list of items to be displayed in the ListFragment
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, countries);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}