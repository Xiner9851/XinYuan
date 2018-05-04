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
import com.example.administrator.xinyuan.model.entity.TeatherBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.Holder> {
    private Context context;
    private List<TeatherBean.DataBean.HomewoksBean> homewoks;

    public ThreeAdapter(Context context, List<TeatherBean.DataBean.HomewoksBean> homewoks) {
        this.context = context;
        this.homewoks = homewoks;
    }

    @Override
    public ThreeAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.teather_three_zi_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ThreeAdapter.Holder holder, int position) {
        if (position==0){
            holder.three_touxiang.setImageResource(R.mipmap.ic_launcher);
        }else {
            Glide.with(context).load(homewoks.get(position).getPhoto()).into(holder.three_touxiang);
        }
        Glide.with(context).load(homewoks.get(position).getCoverImg()).into(holder.three_img);

        holder.three_name.setText(homewoks.get(position).getNickname());
        holder.three_contact.setText(homewoks.get(position).getContent());
        holder.three_time.setText(homewoks.get(position).getPushDate()+"");
    }

    @Override
    public int getItemCount() {
        return homewoks.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView three_touxiang;
        private ImageView three_img;

        private TextView three_name;
        private TextView three_time;
        private TextView three_contact;
        public Holder(View itemView) {
            super(itemView);
            three_img=itemView.findViewById(R.id.word_image);
            three_name=itemView.findViewById(R.id.work_name);
            three_time=itemView.findViewById(R.id.work_time);
            three_contact=itemView.findViewById(R.id.work_content);
            three_touxiang=itemView.findViewById(R.id.work_img);

        }
    }
}
