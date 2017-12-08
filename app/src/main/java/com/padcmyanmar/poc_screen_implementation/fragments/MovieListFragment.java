package com.padcmyanmar.poc_screen_implementation.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.poc_screen_implementation.R;
import com.padcmyanmar.poc_screen_implementation.activities.MovieOverviewActivity;
import com.padcmyanmar.poc_screen_implementation.adapters.MovieAdapter;
import com.padcmyanmar.poc_screen_implementation.components.EmptyViewPod;
import com.padcmyanmar.poc_screen_implementation.components.SmartRecyclerView;
import com.padcmyanmar.poc_screen_implementation.components.SmartScrollListener;
import com.padcmyanmar.poc_screen_implementation.data.models.MovieModel;
import com.padcmyanmar.poc_screen_implementation.data.vo.MovieVO;
import com.padcmyanmar.poc_screen_implementation.delegates.MovieItemDelegate;
import com.padcmyanmar.poc_screen_implementation.events.RestApiEvents;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by User on 11/10/2017.
 */

public class MovieListFragment extends Fragment implements MovieItemDelegate {

    @BindView(R.id.rv_movies)
    SmartRecyclerView rvMovies;

    @BindView(R.id.vp_empty_movies)
    EmptyViewPod vpEmptyMovies;

    private SmartScrollListener mSmartScrollListener;

    MovieAdapter moviesAdapter;

    public static MovieListFragment newInstance() {
        return new MovieListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);
        ButterKnife.bind(this, view);

        MovieModel.getInstance().startLoadingPopularMovies();

        rvMovies.setEmptyView(vpEmptyMovies);
        rvMovies.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        moviesAdapter = new MovieAdapter(getContext(), this);
        rvMovies.setAdapter(moviesAdapter);

        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                Snackbar.make(rvMovies, "This is all the data.", Snackbar.LENGTH_SHORT).show();
            }
        });

        rvMovies.addOnScrollListener(mSmartScrollListener);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPopularMoviesDataLoaded(RestApiEvents.PopularMoviesDataLoadedEvent event){
        moviesAdapter.appendNewData(event.getLoadedMovies());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event){
        Snackbar.make(rvMovies, event.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void onTapMovieOverview(MovieVO movie) {
        Intent intent = MovieOverviewActivity.newIntent(getContext(), movie);
        startActivity(intent);

    }
}
