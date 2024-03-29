package com.hannabennett.jokearama;

import java.util.UUID;

/**
 * Created by HannaBennett on 10/30/17.
 */

public class Joke {
    private UUID mId;
    private String mTitle;
    private boolean mCompletelyViewed;
    private String[] mJokeLines;

    public Joke() {
        mId = UUID.randomUUID();
        mCompletelyViewed = false;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isCompletelyViewed() {
        return mCompletelyViewed;
    }

    public void setCompletelyViewed(boolean completelyViewed) {
        mCompletelyViewed = completelyViewed;
    }

    public String[] getJokeLines() {
        return mJokeLines;
    }

    public void setJokeLines(String[] jokeLines) {
        mJokeLines = jokeLines;
    }
}
