package com.mooqoo.app.materialdesignpractice.activity;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.mooqoo.app.materialdesignpractice.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wade0716 on 15/7/10.
 */
public class Activity_PhotoDetail extends Activity {
    public static final String TAG = "PhotoDetail";

    @Bind(R.id.tv_description) TextView tv_description;
    @Bind(R.id.iv_fullphoto) ImageView iv_fullphoto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // enable transitions, it must be called before adding content
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photodetail);

        ButterKnife.bind(this);

    }


}
