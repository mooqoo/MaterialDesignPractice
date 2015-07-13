package com.mooqoo.app.materialdesignpractice.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mooqoo.app.materialdesignpractice.Interface.ClickListener;
import com.mooqoo.app.materialdesignpractice.R;
import com.mooqoo.app.materialdesignpractice.adapter.HorizontalScrollAdapter;
import com.mooqoo.app.materialdesignpractice.model.HorizontalScrollItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wade0716 on 15/7/12.
 */
public class FragmentHorizontalScroll extends Fragment {
    public static final String TAG = "Fragment_horizontal";

    //RecyclerView
    private RecyclerView recyclerView;
    private HorizontalScrollAdapter adapter;

    //List for RecyclerView
    private List<HorizontalScrollItem> items;

    //View
    View currentView;

    //init data for adapter
    private void initializeData(){
        items = new ArrayList<>();
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice1)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice2)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice3)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice4)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice5)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice1)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice2)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice3)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice4)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice5)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice1)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice2)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice3)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice4)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice5)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice1)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice2)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice3)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice4)));
        items.add(new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice5)));
    }

    //generate a random friendItem
    private HorizontalScrollItem generateItem() {
        Random random = new Random();
        switch(random.nextInt(5)) {
            case 0:
                return new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice1));
            case 1:
                return new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice2));
            case 2:
                return new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice3));
            case 3:
                return new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice4));
            case 4:
                return new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice5));
            default:
                return new HorizontalScrollItem(ContextCompat.getDrawable(getActivity(), R.drawable.img_ice1));
        }
    }

    @Bind(R.id.iv_fullphoto) ImageView iv_fullphoto;

    //Empty constructor
    public FragmentHorizontalScroll() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate");
    }

    public void liftOnTouch(View view)   {
        if(view==null)
            return;
        view.animate().translationZBy(20).setDuration(200).scaleX(1.10f).scaleY(1.15f);
    }

    public void endLift(View view)   {
        if(view==null)
            return;
        view.animate().translationZBy(-20).setDuration(200).scaleX(1.00f).scaleY(1.00f);
    }

    public void animateLift(View view, int position)   {
        endLift(currentView);
        currentView = view;
        liftOnTouch(currentView);
        adapter.getItem(position);
        iv_fullphoto.setImageDrawable(adapter.getItem(position).getDrawable());
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initializeData();

        View layout = inflater.inflate(R.layout.fragment_horizontalscroll, container, false);
        adapter = new HorizontalScrollAdapter(getActivity(), items);
        recyclerView = (RecyclerView) layout.findViewById(R.id.rv_container);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager = ((LinearLayoutManager)recyclerView.getLayoutManager());
                int firstVisiblePosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                View view = layoutManager.findViewByPosition(firstVisiblePosition);
                if(view!=null && !view.equals(currentView))
                    animateLift(view, firstVisiblePosition);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                animateLift(view, position);
                //view.animate().translationZBy(50).setDuration(500);
                //view.setTranslationZ(120);
                Log.i(TAG,"View is clicked! Position="+position);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        ButterKnife.bind(this, layout);

        return layout;
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


    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    Log.i(TAG,"onSingleTapUp");
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }
    }
}
