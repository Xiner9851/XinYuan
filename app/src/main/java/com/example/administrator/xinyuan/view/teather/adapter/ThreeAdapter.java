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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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

public class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.Holder> implements View.OnClickListener{
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
        holder.itemView.setOnClickListener(this);
        holder.rb1.setOnClickListener(this);
        holder.rb2.setOnClickListener(this);
        holder.rb3.setOnClickListener(this);
        holder.rb4.setOnClickListener(this);
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
        holder.itemView.setTag(position);
        holder.rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "评论", Toast.LENGTH_SHORT).show();

            }
        });
        holder.rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点赞", Toast.LENGTH_SHORT).show();
            }
        });
        holder.rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "赏钱", Toast.LENGTH_SHORT).show();

            }
        });
        holder.rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "分享", Toast.LENGTH_SHORT).show();
            }
        });


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
        private RadioButton rb1;
        private RadioButton rb2;
        private RadioButton rb3;
        private RadioButton rb4;
        public Holder(View itemView) {
            super(itemView);
            three_img=itemView.findViewById(R.id.word_image);
            three_name=itemView.findViewById(R.id.work_name);
            three_time=itemView.findViewById(R.id.work_time);
            three_contact=itemView.findViewById(R.id.work_content);
            three_touxiang=itemView.findViewById(R.id.work_img);
            rb1=itemView.findViewById(R.id.teather_pinglun);
            rb2=itemView.findViewById(R.id.teather_dianzan);
            rb3=itemView.findViewById(R.id.trather_shang);
            rb4=itemView.findViewById(R.id.teather_share);




        }
    }
    public static String longToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }
    public interface ThreeOnClick{
        void setThreeOnClick(View view,int postion);
    }
    private ThreeOnClick threeOnClick;
    @Override
    public void onClick(View v) {
        if (threeOnClick!=null){
            threeOnClick.setThreeOnClick(v,(int)v.getTag());
        }

    }
    public void setThreeOnCLickItem(ThreeOnClick threeOnClick){
        this.threeOnClick=threeOnClick;

    }
}
