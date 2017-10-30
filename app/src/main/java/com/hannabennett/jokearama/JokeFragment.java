package com.hannabennett.jokearama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by HannaBennett on 10/30/17.
 */

public class JokeFragment extends Fragment {
    private Joke mJoke;
    private TextView mJokeTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID jokeId = (UUID) getActivity().getIntent().getSerializableExtra(JokeActivity.EXTRA_JOKE_ID);
        mJoke = JokeLab.getInstance(getActivity()).getJoke(jokeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_joke, container, false);

        mJokeTextView = (TextView) v.findViewById(R.id.joke_fragment_text_view);
        mJokeTextView.setText(mJoke.getJokeLines()[0]);

        return v;
    }
}
