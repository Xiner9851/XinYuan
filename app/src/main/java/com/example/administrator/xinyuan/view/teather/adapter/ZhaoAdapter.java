package com.example.administrator.xinyuan.view.teather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.ZhaoTeatherBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9.
 */

public class ZhaoAdapter extends RecyclerView.Adapter<ZhaoAdapter.Holder> implements View.OnClickListener{
    private Context context;
    private List<ZhaoTeatherBean.DataBean.ListBean> list;

    public ZhaoAdapter(Context context, List<ZhaoTeatherBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ZhaoAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zhao_item, parent, false);
        Holder holder = new Holder(inflate);
        holder.itemView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ZhaoAdapter.Holder holder, int position) {
        holder.zhaotheather_name.setText(list.get(position).getNickname());
        Glide.with(context).load(list.get(position).getPhoto()).into(holder.zhaotheather_img);
        holder.zhaotheather_leixing.setText(list.get(position).getIntro());

        int type = list.get(position).getUserType();
        if (type == 2) {
            holder.zhaotheather_tubiao.setImageResource(R.mipmap.home_level_vip_blue);
        } else if (type == 3) {
            holder.zhaotheather_tubiao.setImageResource(R.mipmap.home_level_vip_yellow);
        } else if (type == 4) {
           holder. zhaotheather_tubiao.setImageResource(R.mipmap.home_level_vip_red);
        }
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class Holder extends RecyclerView.ViewHolder {
        private TextView zhaotheather_name;
        private TextView zhaotheather_leixing;
        private ImageView zhaotheather_img;
        private ImageView zhaotheather_tubiao;
        public Holder(View itemView) {
            super(itemView);
            zhaotheather_img=itemView.findViewById(R.id.zhaotheather_img);
            zhaotheather_leixing=itemView.findViewById(R.id.zhaotheather_leixing);
            zhaotheather_name=itemView.findViewById(R.id.zhaotheather_name);
            zhaotheather_tubiao=itemView.findViewById(R.id.zhao_tubiao);
        }
    }
    public interface OnClickListion{
        void setOnCLickListion(View view,int postion);
    }
    private OnClickListion onClickListion;
    @Override
    public void onClick(View v) {
        if (onClickListion!=null){
            onClickListion.setOnCLickListion(v,(int)v.getTag());
        }
    }
    public void setOnClickItemListion(OnClickListion onClickListion){
        this.onClickListion=onClickListion;
    }
}
