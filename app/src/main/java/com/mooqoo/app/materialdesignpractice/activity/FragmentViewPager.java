package com.mooqoo.app.materialdesignpractice.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mooqoo.app.materialdesignpractice.R;
import com.mooqoo.app.materialdesignpractice.animation.ZoomOutPageTransformer;

/**
 * Created by wade0716 on 15/7/12.
 */
public class FragmentViewPager extends Fragment {
    public static final String TAG = "FragmentViewPager";
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    //empty constructor
    public FragmentViewPager()  {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewpager, container, false);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) rootView.findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        return rootView;
    }


    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        //constructor
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
            Log.i(TAG,"Constructor: FragmentScreenSlidePage");
        }

        @Override
        public Fragment getItem(int position) {
            Log.i(TAG,"getItem: position="+position);
            return new FragmentScreenSlidePage();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
