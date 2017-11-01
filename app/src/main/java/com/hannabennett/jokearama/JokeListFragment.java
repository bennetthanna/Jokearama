package com.hannabennett.jokearama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by HannaBennett on 10/30/17.
 */

public class JokeListFragment extends Fragment {

    private RecyclerView mJokeRecyclerView;
    private JokeAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_joke_list, container, false);

        mJokeRecyclerView = (RecyclerView) v.findViewById(R.id.joke_recycler_view);
        mJokeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_joke_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset_jokes_viewed:
                Toast.makeText(getActivity(), "Reset jokes viewed", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        JokeLab jokeLab = JokeLab.getInstance(getActivity());
        List<Joke> jokes = jokeLab.getJokes();

        if (mAdapter == null) {
            mAdapter = new JokeAdapter(jokes);
            mJokeRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class JokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleTextView;
        private Joke mJoke;

        public JokeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_joke, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.joke_title);
        }

        public void bind(Joke joke) {
            mJoke = joke;
            mTitleTextView.setText(mJoke.getTitle());
            if (mJoke.isCompletelyViewed()) {
                mTitleTextView.setBackgroundColor(0xff888888);
            }
        }

        @Override
        public void onClick(View v) {
            Intent intent = JokeActivity.newIntent(getActivity(), mJoke.getId());
            startActivity(intent);
        }
    }

    private class JokeAdapter extends RecyclerView.Adapter<JokeHolder> {
        private List<Joke> mJokes;

        public JokeAdapter(List<Joke> jokes) {
            mJokes = jokes;
        }

        @Override
        public JokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new JokeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(JokeHolder holder, int position) {
            Joke joke = mJokes.get(position);
            holder.bind(joke);
        }

        @Override
        public int getItemCount() {
            return mJokes.size();
        }
    }
}
