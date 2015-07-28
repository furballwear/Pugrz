package com.furballwear.apps.pugrz.basicsyncadapter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.furballwear.apps.pugrz.R;

/**
 * Activity for holding EntryListFragment.
 */
public class EntryListActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }
}
