package com.hannabennett.jokearama;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by HannaBennett on 10/30/17.
 */

public class JokeLab {
    private static JokeLab sJokeLab;
    private List<Joke> mJokes;
    private int mNumJokes;
    private int mNumJokesCompletelyViewed;

    public static JokeLab getInstance(Context context) {
        if (sJokeLab == null) {
            sJokeLab = new JokeLab(context);
        }
        return sJokeLab;
    }

    private JokeLab(Context context) {
        mJokes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Joke joke = new Joke();
            joke.setTitle("Joke #" + i);
            joke.setJokeLines(new String[] {
                    "knock knock", "who's there", "boo", "boo who",
                    "it was just a joke, didn't mean to make you cry"
            });
            mJokes.add(joke);
        }
    }

    public List<Joke> getJokes() {
        return mJokes;
    }

    public Joke getJoke(UUID id) {
        for (Joke joke : mJokes) {
            if (joke.getId().equals(id)) {
                return joke;
            }
        }

        return null;
    }

    public int getNumJokes() {
        return mJokes.size();
    }

    public int getNumJokesCompletelyViewed() {
        mNumJokesCompletelyViewed = 0;
        for (Joke joke : mJokes) {
            if (joke.isCompletelyViewed()) {
                mNumJokesCompletelyViewed++;
            }
        }
        return mNumJokesCompletelyViewed;
    }
}
