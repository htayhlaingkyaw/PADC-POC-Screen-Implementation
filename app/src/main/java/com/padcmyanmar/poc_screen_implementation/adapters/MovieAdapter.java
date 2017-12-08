package com.padcmyanmar.poc_screen_implementation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.poc_screen_implementation.R;
import com.padcmyanmar.poc_screen_implementation.adapters.BaseRecyclerAdapter;
import com.padcmyanmar.poc_screen_implementation.data.vo.MovieVO;
import com.padcmyanmar.poc_screen_implementation.delegates.MovieItemDelegate;
import com.padcmyanmar.poc_screen_implementation.viewholders.MovieViewHolder;


/**
 * Created by User on 11/9/2017.
 */

public class MovieAdapter extends BaseRecyclerAdapter<MovieViewHolder, MovieVO> {

    private MovieItemDelegate mMovieItemDelegate;

    public MovieAdapter(Context context, MovieItemDelegate movieItemDelegate) {
        super(context);
        mMovieItemDelegate = movieItemDelegate;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieItemView = mLayoutInflater.inflate(R.layout.view_item_movie, parent, false);
        return new MovieViewHolder(movieItemView, mMovieItemDelegate);
    }

}
