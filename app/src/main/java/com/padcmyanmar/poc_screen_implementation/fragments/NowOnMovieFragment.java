package com.padcmyanmar.poc_screen_implementation.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.poc_screen_implementation.R;
import com.padcmyanmar.poc_screen_implementation.adapters.NowOnMovieAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowOnMovieFragment extends Fragment {

    RecyclerView rvNowOnCinema;

    public NowOnMovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_now_on_cinema, container, false);

        rvNowOnCinema = view.findViewById(R.id.rv_now_on_cinema);
        rvNowOnCinema.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        NowOnMovieAdapter nowOnMovieAdapter = new NowOnMovieAdapter(getContext());
        rvNowOnCinema.setAdapter(nowOnMovieAdapter);

        return view;
    }

}
