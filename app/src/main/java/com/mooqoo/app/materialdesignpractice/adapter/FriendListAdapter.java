package com.mooqoo.app.materialdesignpractice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mooqoo.app.materialdesignpractice.R;
import com.mooqoo.app.materialdesignpractice.model.FriendsListItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by wade0716 on 15/7/9.
 */
public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.MyViewHolder> {
    List<FriendsListItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public FriendListAdapter(Context context, List<FriendsListItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void add(FriendsListItem item) {
        data.add(item);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_friendslist, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FriendsListItem current = data.get(position);
        holder.tv_name.setText(current.getText());
        holder.iv_photo.setImageDrawable(current.getDrawable());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        ImageView iv_photo;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            iv_photo = (ImageView) itemView.findViewById(R.id.iv_photo);
        }
    }
}
