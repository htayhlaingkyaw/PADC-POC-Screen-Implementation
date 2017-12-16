package com.padcmyanmar.poc_screen_implementation.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;


import com.padcmyanmar.poc_screen_implementation.R;
import com.padcmyanmar.poc_screen_implementation.adapters.TrailerAdapter;
import com.padcmyanmar.poc_screen_implementation.components.EmptyViewPod;
import com.padcmyanmar.poc_screen_implementation.components.SmartRecyclerView;
import com.padcmyanmar.poc_screen_implementation.data.vo.MovieVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aspire on 12/16/2017.
 */

public class MovieDetailActivity extends BaseActivity {

    @BindView(R.id.rv_trailer_movies)
    SmartRecyclerView rvTrailerMovies;

    @BindView(R.id.vp_empty_trailer_movies)
    EmptyViewPod vpEmptyTrailerMovies;

    TrailerAdapter mTrailerAdapter;

    private static final String tap_movie_id = "tap_movie_id";

    public static Intent newIntent(Context context, MovieVO movie){
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(tap_movie_id, movie.getId());
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this, this);

        rvTrailerMovies.setEmptyView(vpEmptyTrailerMovies);
        rvTrailerMovies.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        mTrailerAdapter = new TrailerAdapter(getApplicationContext());
        rvTrailerMovies.setAdapter(mTrailerAdapter);

    }
}
