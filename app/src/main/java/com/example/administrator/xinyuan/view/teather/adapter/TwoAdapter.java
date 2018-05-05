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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.Holder> {
    private Context context;
    private List<TeatherBean.DataBean.LiveCoursesBean> liveCourses;

    public TwoAdapter(Context context, List<TeatherBean.DataBean.LiveCoursesBean> liveCourses) {
        this.context = context;
        this.liveCourses = liveCourses;
    }

    @Override
    public TwoAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.teather_two_zi_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(TwoAdapter.Holder holder, int position) {
        Glide.with(context).load(liveCourses.get(position).getCoverImg()).into(holder.img);
        holder.name.setText(liveCourses.get(position).getNickname());
        long endDate = liveCourses.get(position).getEndDate();
        String s = longToDate(endDate);

        holder.time.setText(s);
    }

    @Override
    public int getItemCount() {
        return liveCourses.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private TextView time;
        public Holder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.two_zi_img);
            name=itemView.findViewById(R.id.two_zi_name);
            time=itemView.findViewById(R.id.two_zi_time);
        }
    }
    public static String longToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }

}
