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
import com.example.administrator.xinyuan.model.entity.ZhaoTeather_KeCheng;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/9.
 */

public class ZhaoTeather_KeCheng_Adapter extends RecyclerView.Adapter<ZhaoTeather_KeCheng_Adapter.Holder> implements View.OnClickListener{
    private Context context;
    private List<ZhaoTeather_KeCheng.DataBean.ListBean> list;



    public ZhaoTeather_KeCheng_Adapter(Context context, List<ZhaoTeather_KeCheng.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zhaoteather_kecheng, parent, false);
        Holder holder = new Holder(inflate);
        holder.itemView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ZhaoTeather_KeCheng.DataBean.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getCoverImg()).into(holder.xsk_item_img);
        long startDate = listBean.getStartDate();
        String s = longToDate(startDate);
        holder.xsk_item_time.setText(s);
        holder.xsk_item_name.setText(listBean.getNickname());
        holder.xsk_item_price.setText(listBean.getPrice() + "");
        holder.xsk_item_type.setText("重播");
        holder.xsk_item_type.setText(listBean.getType());
        holder.xsk_item_yuyue.setText(listBean.getIsSubscribe() + "/" + listBean.getSubscribeNum());
        int type = listBean.getUserType();
        if (type == 2) {
            holder.xsk_item_usertype.setImageResource(R.mipmap.home_level_vip_blue);
        } else if (type == 3) {
            holder.xsk_item_usertype.setImageResource(R.mipmap.home_level_vip_yellow);
        } else if (type == 4) {
            holder.xsk_item_usertype.setImageResource(R.mipmap.home_level_vip_red);
        }
        holder.xsk_item_flag.setText("讲堂");
        holder.xsk_item_majorIds.setText("表演");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView xsk_item_img;
        private TextView xsk_item_type;
        private TextView xsk_item_time;
        private TextView xsk_item_name;
        private ImageView xsk_item_usertype;
        private TextView xsk_item_majorIds;
        private TextView xsk_item_flag;
        private TextView xsk_item_yuyue;
        private TextView xsk_item_price;

        public Holder(View itemView) {
            super(itemView);
            xsk_item_img = itemView.findViewById(R.id.xsk_item_img);
            xsk_item_type = itemView.findViewById(R.id.xsk_item_type);
            xsk_item_time = itemView.findViewById(R.id.xsk_item_time);
            xsk_item_name = itemView.findViewById(R.id.xsk_item_name);
            xsk_item_usertype = itemView.findViewById(R.id.xsk_item_usertype);
            xsk_item_majorIds = itemView.findViewById(R.id.xsk_item_majorIds);
            xsk_item_flag = itemView.findViewById(R.id.xsk_item_flag);
            xsk_item_yuyue = itemView.findViewById(R.id.xsk_item_yuyue);
            xsk_item_price = itemView.findViewById(R.id.xsk_item_price);

        }
    }
    public interface OnClick{
        void setOnClick(View view,int postion);
    }
    private OnClick onClick;
    @Override
    public void onClick(View v) {
        if (onClick!=null){
            onClick.setOnClick(v,(int)v.getTag());
        }

    }
    public void setOnCLickItem(OnClick onClick){
        this.onClick=onClick;

    }


    public static String longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }
}
