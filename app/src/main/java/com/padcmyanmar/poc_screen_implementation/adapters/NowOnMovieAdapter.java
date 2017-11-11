package com.padcmyanmar.poc_screen_implementation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.poc_screen_implementation.R;
import com.padcmyanmar.poc_screen_implementation.viewholders.MovieFragmentViewHolder;

/**
 * Created by HHK on 11/10/2017.
 */

public class NowOnMovieAdapter extends RecyclerView.Adapter<MovieFragmentViewHolder> {

    private LayoutInflater mLayoutInflater;

    public NowOnMovieAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MovieFragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View nowOnCinemaView = mLayoutInflater.inflate(R.layout.view_item_now_on_cinema, parent, false);
        return new MovieFragmentViewHolder(nowOnCinemaView);
    }

    @Override
    public void onBindViewHolder(MovieFragmentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
