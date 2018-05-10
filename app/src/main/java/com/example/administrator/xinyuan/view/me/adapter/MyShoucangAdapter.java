package com.example.administrator.xinyuan.view.me.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.MyShoucangBean;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fghjkl on 2018/5/10.
 */

public class MyShoucangAdapter extends RecyclerView.Adapter<MyShoucangAdapter.Holder>{
    private Context context;
    private List<MyShoucangBean.DataBean.ListBean> list;

    public MyShoucangAdapter(Context context, List<MyShoucangBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyShoucangAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vie= LayoutInflater.from(parent.getContext()).inflate(R.layout.myshoucang_adapter,parent,false);
        return new Holder(vie);
    }

    @Override
    public void onBindViewHolder(MyShoucangAdapter.Holder holder, int position) {
        holder.xsk_item_name.setText(list.get(position).getNickname());
        holder.xsk_item_price.setText(list.get(position).getPrice()+"");
        holder.xsk_item_yuyue.setText(list.get(position).getIsSubscribe()+"/100");
        holder.xsk_item_majorIds.setText(list.get(position).getType());
        Date date = new Date(list.get(position).getStartDate());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        holder.xsk_item_time.setText(format);
        Picasso.with(context).load(list.get(position).getCoverImg()).into(holder.xsk_item_img);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView xsk_item_img;
        private ImageView xsk_item_usertype;
        private TextView xsk_item_type;
        private TextView xsk_item_time;
        private TextView xsk_item_name;
        private TextView xsk_item_majorIds;
        private TextView xsk_item_flag;
        private TextView xsk_item_yuyue;
        private TextView xsk_item_price;
        public Holder(View itemView) {
            super(itemView);
            xsk_item_img=itemView.findViewById(R.id.xsk_item_img);
            xsk_item_usertype=itemView.findViewById(R.id.xsk_item_usertype);
            xsk_item_majorIds=itemView.findViewById(R.id.xsk_item_majorIds);
            xsk_item_flag=itemView.findViewById(R.id.xsk_item_flag);
            xsk_item_type=itemView.findViewById(R.id.xsk_item_type);
            xsk_item_time=itemView.findViewById(R.id.xsk_item_time);
            xsk_item_name=itemView.findViewById(R.id.xsk_item_name);
            xsk_item_yuyue=itemView.findViewById(R.id.xsk_item_yuyue);
            xsk_item_price=itemView.findViewById(R.id.xsk_item_price);
        }
    }
}
