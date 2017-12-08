package com.padcmyanmar.poc_screen_implementation.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.poc_screen_implementation.data.vo.MovieVO;

import java.util.List;



/**
 * Created by User on 12/7/2017.
 */

public class GetMovieResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("pageNo")
    private int pageNo;

    @SerializedName("popular-movies")
    private List<MovieVO> popularMovies;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPageNo() {
        return pageNo;
    }

    public List<MovieVO> getPopularMovies() {
        return popularMovies;
    }
}
