package com.padcmyanmar.poc_screen_implementation.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.poc_screen_implementation.R;
import com.padcmyanmar.poc_screen_implementation.data.vo.MovieVO;
import com.padcmyanmar.poc_screen_implementation.viewholders.TrailerViewHolder;

/**
 * Created by Aspire on 12/16/2017.
 */

public class TrailerAdapter extends BaseRecyclerAdapter<TrailerViewHolder, MovieVO> {

    public TrailerAdapter(Context context) {
        super(context);
    }

    @Override
    public TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View trailerItemView = mLayoutInflater.inflate(R.layout.view_item_trailer, parent, false);
        return new TrailerViewHolder(trailerItemView);
    }

    @Override
    public void onBindViewHolder(TrailerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
