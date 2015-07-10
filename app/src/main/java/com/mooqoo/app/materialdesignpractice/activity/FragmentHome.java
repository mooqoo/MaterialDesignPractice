package com.mooqoo.app.materialdesignpractice.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mooqoo.app.materialdesignpractice.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wade0716 on 15/7/8.
 */
public class FragmentHome extends Fragment {
    public static final String TAG = "FragmentHome";


    //init View
    @Bind(R.id.photo) ImageView iv_photo;
    @OnClick(R.id.cv)
    public void onClick() {
        Log.i(TAG,"CardView is clicked!");

        //get the window of the activity and set the exit transition to slide
        getActivity().getWindow().setExitTransition(new Slide());
        Intent intent = new Intent(getActivity(), Activity_PhotoDetail.class);

        //Start an activity with a shared element
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), iv_photo, "photo");
        // start the new activity
        getActivity().startActivity(intent, options.toBundle());


        //getActivity().startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
    }

    //Constructor: Empty
    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, rootView);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
