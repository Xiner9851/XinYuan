package com.example.administrator.xinyuan.view.teather.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.TeatherBean;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void onBindViewHolder(final ThreeAdapter.Holder holder, int position) {
        if (position==0){
            holder.three_touxiang.setImageResource(R.mipmap.ic_launcher);
        }else {

            Glide.with(context).load(homewoks.get(position).getPhoto())
                    .asBitmap()
                    .override(50,50)
                    .into(new BitmapImageViewTarget(holder.three_touxiang){
                        @Override
                        protected void setResource(Bitmap resource) {
                            super.setResource(resource);
                            RoundedBitmapDrawable drawable= RoundedBitmapDrawableFactory.create(context.getResources(),resource);
                            drawable.setCornerRadius(100);
                            holder.three_touxiang.setImageDrawable(drawable);
                        }
                    });
        }
        Glide.with(context).load(homewoks.get(position).getCoverImg()).into(holder.three_img);

        holder.three_name.setText(homewoks.get(position).getNickname());
        holder.three_contact.setText(homewoks.get(position).getContent());
        long pushDate = homewoks.get(position).getPushDate();
        String s = longToDate(pushDate);
        holder.three_time.setText(s);
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
    public static String longToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }
}
