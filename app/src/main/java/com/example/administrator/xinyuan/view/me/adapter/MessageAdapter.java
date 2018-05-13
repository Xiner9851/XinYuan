package com.example.administrator.xinyuan.view.me.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.MessageBean;
import com.example.administrator.xinyuan.model.http.TimeShift;

import java.util.List;

/**
 * Created by fghjkl on 2018/5/10.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.Holder> implements View.OnClickListener{
    private Context context;
    private List<MessageBean.DataBean> list;


    public MessageAdapter(Context context, List<MessageBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_message, parent, false);
        view.setOnClickListener(this);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        if(position==0) {
            holder.message_listitem_typeimg.setImageResource(R.mipmap.message_order);
            holder.message_listitem_title.setText("订单提醒");
            holder.message_listitem_content.setText(list.get(position).getContent());
            if(list.get(position).getIsRead()==0){
                holder.message_listitem_newimg.setVisibility(View.GONE);
            }else {
                holder.message_listitem_newimg.setVisibility(View.VISIBLE);
            }
            holder.message_listitem_time.setText(TimeShift.getChatTime(list.get(position).getCreateDate()));
        }else if(position==1){
            holder.message_listitem_typeimg.setImageResource(R.mipmap.message_praise);
            holder.message_listitem_title.setText("攒我的");
            holder.message_listitem_content.setText(list.get(position).getContent());
            if(list.get(position).getIsRead()==0){
                holder.message_listitem_newimg.setVisibility(View.GONE);
            }else {
                holder.message_listitem_newimg.setVisibility(View.VISIBLE);
            }
            holder.message_listitem_time.setText(TimeShift.getChatTime(list.get(position).getCreateDate()));
        }else if(position==2){
            holder.message_listitem_typeimg.setImageResource(R.mipmap.message_comment);
            holder.message_listitem_title.setText("评论我的");
            holder.message_listitem_content.setText(list.get(position).getContent());
            if(list.get(position).getIsRead()==0){
                holder.message_listitem_newimg.setVisibility(View.GONE);
            }else {
                holder.message_listitem_newimg.setVisibility(View.VISIBLE);
            }
            holder.message_listitem_time.setText(TimeShift.getChatTime(list.get(position).getCreateDate()));
        }else if(position==3){
            holder.message_listitem_typeimg.setImageResource(R.mipmap.message_job);
            holder.message_listitem_title.setText("作业提醒");
            holder.message_listitem_content.setText(list.get(position).getContent());
            if(list.get(position).getIsRead()==0){
                holder.message_listitem_newimg.setVisibility(View.GONE);
            }else {
                holder.message_listitem_newimg.setVisibility(View.VISIBLE);
            }
            holder.message_listitem_time.setText(TimeShift.getChatTime(list.get(position).getCreateDate()));
        }else if(position==4){
            holder.message_listitem_typeimg.setImageResource(R.mipmap.message_official);
            holder.message_listitem_flag.setVisibility(View.VISIBLE);
            holder.message_listitem_title.setText("UnivStar团队");
            holder.message_listitem_content.setText(list.get(position).getContent());
            if(list.get(position).getIsRead()==0){
                holder.message_listitem_newimg.setVisibility(View.GONE);
            }else {
                holder.message_listitem_newimg.setVisibility(View.VISIBLE);
            }
            holder.message_listitem_time.setText(TimeShift.getChatTime(list.get(position).getCreateDate()));
        }else if(position==5){
            holder.message_listitem_title.setText("关注提醒");
            holder.message_listitem_content.setText(list.get(position).getContent());
            if(list.get(position).getIsRead()==0){
                holder.message_listitem_newimg.setVisibility(View.GONE);
            }else {
                holder.message_listitem_newimg.setVisibility(View.VISIBLE);
            }
            holder.message_listitem_time.setText(TimeShift.getChatTime(list.get(position).getCreateDate()));
        }

        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class Holder extends RecyclerView.ViewHolder {

        private ImageView message_listitem_typeimg;
        private TextView message_listitem_title;
        private TextView message_listitem_flag;
        private ImageView message_listitem_newimg;
        private TextView message_listitem_content;
        private TextView message_listitem_time;
        public Holder(View itemView) {
            super(itemView);
            message_listitem_typeimg=itemView.findViewById(R.id.message_listitem_typeimg);
            message_listitem_newimg=itemView.findViewById(R.id.message_listitem_newimg);
            message_listitem_title=itemView.findViewById(R.id.message_listitem_title);
            message_listitem_flag=itemView.findViewById(R.id.message_listitem_flag);
            message_listitem_content=itemView.findViewById(R.id.message_listitem_content);
            message_listitem_time=itemView.findViewById(R.id.message_listitem_time);
        }
    }
    public interface Onclick{
        void wai(View view,int possi);
    }
    private Onclick onclick;
    @Override
    public void onClick(View v) {
        if(onclick!=null){
            onclick.wai(v,(int)v.getTag());
        }
    }
    public void setTiao(Onclick onclick){
        this.onclick =onclick;
    }


}
