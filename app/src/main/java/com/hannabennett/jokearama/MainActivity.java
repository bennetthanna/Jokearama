package com.hannabennett.jokearama;

import android.support.v4.app.Fragment;

public class MainActivity extends FragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new JokeListFragment();
    }
}
