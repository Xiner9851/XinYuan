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

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.Holder> implements View.OnClickListener{
    private Context context;
    private List<TeatherBean.DataBean.UsersBean> users;

    public OneAdapter(Context context, List<TeatherBean.DataBean.UsersBean> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public OneAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.teather_one_zi_item, parent, false);
        Holder holder = new Holder(inflate);
        holder.itemView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(OneAdapter.Holder holder, int position) {
        Glide.with(context).load(users.get(position).getImages()).into(holder.img);
        holder.name.setText(users.get(position).getNickname());
        holder.contect.setText(users.get(position).getIntro());

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }



    public class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private TextView contect;
        public Holder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.one_zi_img);
            name=itemView.findViewById(R.id.one_zi_name);
            contect=itemView.findViewById(R.id.one_zi_contact);
        }
    }
    public interface OneOnClick{
        void setOneOnClick(View view,int postion);
    }
    private OneOnClick oneOnClick;
    @Override
    public void onClick(View v) {
        if (oneOnClick!=null){
            oneOnClick.setOneOnClick(v,(int)v.getTag());
        }
    }
    public void setOneOnCLickItem(OneOnClick oneOnClick){
        this.oneOnClick=oneOnClick;

    }
}
