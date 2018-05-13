package com.example.administrator.xinyuan.view.work.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.LiWuBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/13.
 */

public class LiWuPopAdapter extends RecyclerView.Adapter<LiWuPopAdapter.Holder> {
    private List<LiWuBean.DataBean.GiftListBean> giftList;
    private Context context;

    public LiWuPopAdapter(List<LiWuBean.DataBean.GiftListBean> giftList, Context context) {
        this.giftList = giftList;
        this.context = context;
    }

    @Override
    public LiWuPopAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.liwu_pop_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(LiWuPopAdapter.Holder holder, int position) {
        holder.name.setText(giftList.get(position).getName());
        holder.price.setText(giftList.get(position).getAmount()+"");
        Glide.with(context).load(giftList.get(position).getImg()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return giftList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView price;
        private TextView name;

        public Holder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.liwu_img);
            price=itemView.findViewById(R.id.liwu_price);
            name=itemView.findViewById(R.id.liwu_name);
        }
    }
}
