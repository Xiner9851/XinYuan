package com.example.administrator.xinyuan.view.me.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.RechargeCenterListModel;

import java.util.List;

/**
 * Created by fghjkl on 2018/5/8.
 */

public class ChongZhiAdapter extends RecyclerView.Adapter<ChongZhiAdapter.Holder>{
    private Context context;
    private  List<RechargeCenterListModel.DataBean> list;

    public ChongZhiAdapter(Context context, List<RechargeCenterListModel.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.wee,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.recharge_center_listitem_amount.setText(list.get(position).getAmountAndroid()+"");
        holder.recharge_center_listitem_price.setText(list.get(position).getPriceAndroid()+"");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView recharge_center_listitem_amount;
        private TextView  recharge_center_listitem_price;
        public Holder(View itemView) {
            super(itemView);
            recharge_center_listitem_price=itemView.findViewById(R.id.recharge_center_listitem_price);
            recharge_center_listitem_amount=itemView.findViewById(R.id.recharge_center_listitem_amount);
        }
    }
}
