package com.hannabennett.jokearama;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

/**
 * Created by HannaBennett on 10/30/17.
 */

public class JokeActivity extends FragmentActivity {

    public static final String EXTRA_JOKE_ID = "com.hannabennett.jokearama.joke_id";

    public static Intent newIntent(Context packageContext, UUID jokeId) {
        Intent intent = new Intent(packageContext, JokeActivity.class);
        intent.putExtra(EXTRA_JOKE_ID, jokeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new JokeFragment();
    }
}
