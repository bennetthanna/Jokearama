package com.hannabennett.jokearama;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by HannaBennett on 10/30/17.
 */

public class JokeFragment extends Fragment {
    private Joke mJoke;
    private TextView mJokeTextView1;
    private TextView mJokeTextView2;
    private TextView mJokeTextView3;
    private TextView mJokeTextView4;
    private TextView mJokeTextView5;
    private int mJokeLineIndex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID jokeId = (UUID) getActivity().getIntent().getSerializableExtra(JokeActivity.EXTRA_JOKE_ID);
        mJoke = JokeLab.getInstance(getActivity()).getJoke(jokeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_joke, container, false);

        mJokeTextView1 = (TextView) v.findViewById(R.id.joke_fragment_text_view_1);
        mJokeTextView2 = (TextView) v.findViewById(R.id.joke_fragment_text_view_2);
        mJokeTextView3 = (TextView) v.findViewById(R.id.joke_fragment_text_view_3);
        mJokeTextView4 = (TextView) v.findViewById(R.id.joke_fragment_text_view_4);
        mJokeTextView5 = (TextView) v.findViewById(R.id.joke_fragment_text_view_5);

        mJokeLineIndex = 0;
        updateJokeLine(mJokeTextView1, mJokeLineIndex);

        LinearLayout joke_layout = (LinearLayout) v.findViewById(R.id.joke_layout);
        joke_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mJokeLineIndex++;
                switch(mJokeLineIndex) {
                    case 1:
                        updateJokeLine(mJokeTextView2, mJokeLineIndex);
                        break;
                    case 2:
                        updateJokeLine(mJokeTextView3, mJokeLineIndex);
                        break;
                    case 3:
                        updateJokeLine(mJokeTextView4, mJokeLineIndex);
                        break;
                    case 4:
                        updateJokeLine(mJokeTextView5, mJokeLineIndex);
                        mJoke.setCompletelyViewed(true);
                        break;
                    default:
                        return;
                }
            }
        });

        return v;
    }

    public void updateJokeLine(TextView view, int index) {
        view.setText(mJoke.getJokeLines()[index]);
    }
}
