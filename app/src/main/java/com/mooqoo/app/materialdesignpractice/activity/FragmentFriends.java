package com.mooqoo.app.materialdesignpractice.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mooqoo.app.materialdesignpractice.R;
import com.mooqoo.app.materialdesignpractice.adapter.FriendListAdapter;
import com.mooqoo.app.materialdesignpractice.model.FriendsListItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wade0716 on 15/7/8.
 */
public class FragmentFriends extends Fragment {
    public static final String TAG = "Fragment_friends";

    //RecyclerView
    private RecyclerView recyclerView;
    private FriendListAdapter adapter;

    //List for RecyclerView
    private List<FriendsListItem> friends;

    //init View
    @OnClick({ R.id.btn_add, R.id.btn_remove})
    public void onClick(View view) {
        switch(view.getId())    {
            case R.id.btn_add:
                if(adapter!=null)
                    adapter.add(generateFriendItem());
                //Toast.makeText(getActivity(),"btn add clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_remove:
                if(adapter!=null && adapter.getItemCount()>0)
                    adapter.delete(0);
                //Toast.makeText(getActivity(),"btn remove clicked!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //init data for adapter
    private void initializeData(){
        friends = new ArrayList<>();
        friends.add(new FriendsListItem("ICE ONE", ContextCompat.getDrawable(getActivity(), R.drawable.img_ice1)));
        friends.add(new FriendsListItem("ICE TWO", ContextCompat.getDrawable(getActivity(), R.drawable.img_ice2)));
        friends.add(new FriendsListItem("ICE THREE", ContextCompat.getDrawable(getActivity(), R.drawable.img_ice3)));
    }

    //generate a random friendItem
    private FriendsListItem generateFriendItem() {
        Random random = new Random();
        switch(random.nextInt(5)) {
            case 0:
                return new FriendsListItem("ICE ONE", ContextCompat.getDrawable(getActivity(), R.drawable.img_ice1));
            case 1:
                return new FriendsListItem("ICE TWO", ContextCompat.getDrawable(getActivity(), R.drawable.img_ice2));
            case 2:
                return new FriendsListItem("ICE THREE", ContextCompat.getDrawable(getActivity(), R.drawable.img_ice3));
            case 3:
                return new FriendsListItem("ICE FOUR", ContextCompat.getDrawable(getActivity(), R.drawable.img_ice4));
            case 4:
                return new FriendsListItem("ICE FIVE", ContextCompat.getDrawable(getActivity(), R.drawable.img_ice5));
            default:
                return new FriendsListItem("ICE ERROR", ContextCompat.getDrawable(getActivity(), R.drawable.img_ice1));
        }
    }

    //Empty constructor
    public FragmentFriends() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initializeData();

        View layout = inflater.inflate(R.layout.fragment_friends, container, false);
        adapter = new FriendListAdapter(getActivity(), friends);
        recyclerView = (RecyclerView) layout.findViewById(R.id.rv_container);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ButterKnife.bind(this, layout);
        /*
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                mDrawerLayout.closeDrawer(containerView);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        */

        // Inflate the layout for this fragment
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

}
