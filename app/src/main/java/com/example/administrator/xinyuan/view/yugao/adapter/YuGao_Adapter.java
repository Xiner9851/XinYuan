package com.example.administrator.xinyuan.view.yugao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.YuDaoBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class YuGao_Adapter extends RecyclerView.Adapter<YuGao_Adapter.Holder> implements View.OnClickListener {
    private Context context;
    private List<YuDaoBean.DataBean.ListBean> list;

    public YuGao_Adapter(Context context, List<YuDaoBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public YuGao_Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yugao_item, parent, false);
        Holder holder = new Holder(inflate);
        holder.itemView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(YuGao_Adapter.Holder holder, int position) {
        Glide.with(context).load(list.get(position).getCoverImg()).into(holder.yugao_img);
        holder.yugao_addss.setText(list.get(position).getAddress());
        holder.yugao_data.setText(list.get(position).getStartDate()+"");
        holder.price.setText(list.get(position).getPrice()+"");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class Holder extends RecyclerView.ViewHolder {
        private ImageView yugao_img;
        private TextView yugao_addss;
        private TextView yugao_data;
        private TextView price;
        public Holder(View itemView) {
            super(itemView);
            yugao_img=itemView.findViewById(R.id.yugao_img);
            yugao_addss=itemView.findViewById(R.id.yudao_address);
            yugao_data=itemView.findViewById(R.id.yudao_startdata);
            price=itemView.findViewById(R.id.yugao_price);
        }
    }
    public  interface YuGaoOnClickListion{
        void setOnClickListion(View view,int postion);
    }
    private YuGaoOnClickListion yuGaoOnClickListion;
    @Override
    public void onClick(View v) {
        if (yuGaoOnClickListion!=null){
            yuGaoOnClickListion.setOnClickListion(v,(int)v.getTag());
        }
    }
    public void setOnClickListionItem(YuGaoOnClickListion yuGaoOnClickListion){
        this.yuGaoOnClickListion=yuGaoOnClickListion;

    }

}
