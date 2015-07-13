package com.mooqoo.app.materialdesignpractice.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mooqoo.app.materialdesignpractice.R;

/**
 * Created by wade0716 on 15/7/13.
 */
public class FragmentScreenSlidePage extends Fragment {
    public static final String TAG = "FragmentScreenSlidePage";

    //empty constructor
    public FragmentScreenSlidePage() {
        Log.i(TAG,"Constructor: FragmentScreenSlidePage");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_slide_page, container, false);

        return rootView;
    }
}