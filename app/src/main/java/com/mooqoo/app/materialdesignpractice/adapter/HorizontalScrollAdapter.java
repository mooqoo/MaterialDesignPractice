package com.mooqoo.app.materialdesignpractice.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mooqoo.app.materialdesignpractice.R;
import com.mooqoo.app.materialdesignpractice.model.HorizontalScrollItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by wade0716 on 15/7/12.
 */
public class HorizontalScrollAdapter extends RecyclerView.Adapter<HorizontalScrollAdapter.MyViewHolder> {
    List<HorizontalScrollItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    //Constructor
    public HorizontalScrollAdapter(Context context, List<HorizontalScrollItem> data)    {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public HorizontalScrollAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_photo_info, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HorizontalScrollAdapter.MyViewHolder holder, int position) {
        HorizontalScrollItem current = data.get(position);
        holder.iv_photo.setImageDrawable(current.getDrawable());
        holder.tv_id_num.setText(current.getText());
        //holder.tv_id_num.setText(current.getText());
        //holder.iv_photo.setImageDrawable(current.getDrawable());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public HorizontalScrollItem getItem(int position)   {
        return data.get(position);
    }

    //View Holder Class
    class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cv_container;
        ImageView iv_photo;
        TextView tv_id_num;

        public MyViewHolder(View itemView) {
            super(itemView);
            cv_container = (CardView) itemView.findViewById(R.id.cv_container);
            iv_photo = (ImageView) itemView.findViewById(R.id.iv_photo);
            tv_id_num = (TextView) itemView.findViewById(R.id.tv_id_num);
        }
    }

}
