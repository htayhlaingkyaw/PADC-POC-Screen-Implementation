package com.padcmyanmar.poc_screen_implementation.data.models;

import android.text.TextUtils;

import com.padcmyanmar.poc_screen_implementation.data.vo.MovieVO;
import com.padcmyanmar.poc_screen_implementation.events.RestApiEvents;
import com.padcmyanmar.poc_screen_implementation.network.MovieDataAgentImpl;
import com.padcmyanmar.poc_screen_implementation.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by User on 12/7/2017.
 */

public class MovieModel {

    private static MovieModel objInstance;

    private List<MovieVO> mMovies;
    private int mMoviesPageIndex = 1;

    private MovieModel() {
        EventBus.getDefault().register(this);
        mMovies = new ArrayList<>();
    }

    public static MovieModel getInstance() {
        if(objInstance == null){
            objInstance = new MovieModel();
        }
        return objInstance;
    }

    public void startLoadingPopularMovies(){
        MovieDataAgentImpl.getInstance().loadPopularMovies(AppConstants.ACCESS_TOKEN, mMoviesPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPopularMoviesDataLoaded(RestApiEvents.PopularMoviesDataLoadedEvent event){
        mMovies.addAll(event.getLoadedMovies());
        mMoviesPageIndex = event.getLoadedPageIndex() + 1;
    }

    public MovieVO getMovieById(int id){
        for(MovieVO movies : mMovies){
            if(movies.getId()== id){
                return movies;
            }
        }
        return null;
    }
}
