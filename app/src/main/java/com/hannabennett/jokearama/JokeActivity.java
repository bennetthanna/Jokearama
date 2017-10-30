package com.hannabennett.jokearama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HannaBennett on 10/30/17.
 */

public class JokeActivity extends FragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new JokeFragment();
    }
}
