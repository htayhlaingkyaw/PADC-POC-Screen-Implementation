package com.padcmyanmar.poc_screen_implementation.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.padcmyanmar.poc_screen_implementation.fragments.MostPopularFragment;
import com.padcmyanmar.poc_screen_implementation.fragments.NowOnMovieFragment;
import com.padcmyanmar.poc_screen_implementation.fragments.UpcomingFragment;

/**
 * Created by HHK on 11/10/2017.
 */

public class MovieFragmentPagerAdapter extends FragmentPagerAdapter {

    public MovieFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NowOnMovieFragment();
            case 1:
                return new UpcomingFragment();
            case 2:
                return new MostPopularFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Now On Cinema";
            case 1:
                return "Upcoming";
            case 2:
                return "Most Popular";
            default:
                return null;
        }
    }
}
