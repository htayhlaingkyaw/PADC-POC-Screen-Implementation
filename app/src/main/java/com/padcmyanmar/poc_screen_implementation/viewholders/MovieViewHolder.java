package com.padcmyanmar.poc_screen_implementation.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.padcmyanmar.poc_screen_implementation.R;
import com.padcmyanmar.poc_screen_implementation.data.vo.MovieVO;
import com.padcmyanmar.poc_screen_implementation.delegates.MovieItemDelegate;
import com.padcmyanmar.poc_screen_implementation.utils.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by HHK on 11/9/2017.
 */

public class MovieViewHolder extends BaseViewHolder<MovieVO> {

    @BindView(R.id.iv_poster)
    ImageView ivPoster;

    @BindView(R.id.tv_vote_average)
    TextView tvVoteAverage;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    private MovieItemDelegate mDelegate;
    private MovieVO mMovie;

    public MovieViewHolder(View itemView, MovieItemDelegate movieItemDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mDelegate = movieItemDelegate;
    }

    @Override
    public void setData(MovieVO movie) {
        mMovie = movie;

        Glide.with(ivPoster.getContext())
                .load("https://image.tmdb.org/t/p/original" + movie.getPosterPath())
                .into(ivPoster);

        tvVoteAverage.setText(String.valueOf(movie.getVoteAverage()));
        tvTitle.setText(movie.getTitle());
    }

    @OnClick(R.id.btn_movie_overview)
    public void onTapMovieOverview(View view){

    }

    @Override
    public void onClick(View view) {
        mDelegate.onTapMovie(mMovie);
    }
}
