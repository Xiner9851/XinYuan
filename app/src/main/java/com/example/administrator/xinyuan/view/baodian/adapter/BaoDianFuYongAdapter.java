package com.example.administrator.xinyuan.view.baodian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.BaoDianFuYongBean;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fghjkl on 2018/5/7.
 */

public class BaoDianFuYongAdapter extends RecyclerView.Adapter<BaoDianFuYongAdapter.Holder> implements View.OnClickListener{
    List<BaoDianFuYongBean.DataBean.ArtcircleListBean.ListBean> list1;
    private Context context;



    public BaoDianFuYongAdapter(List<BaoDianFuYongBean.DataBean.ArtcircleListBean.ListBean> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.baodian_fuyong_adapter, parent, false);
        Holder holder = new Holder(view);
        holder.itemView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.home_valuable_listitem_name.setText(list1.get(position).getNickname());
        holder.home_valuable_listitem_contenttype.setText(list1.get(position).getContentType());

        long createDate = list1.get(position).getCreateDate();

        holder.home_valuable_listitem_title.setText(list1.get(position).getTitle());
        holder.home_valuable_listitem_content.setText(list1.get(position).getContent());
        Picasso.with(context).load(list1.get(position).getCoverImg() ).into(holder.home_valuable_listitem_contentimg);
        Glide.with(context).load(list1.get(position).getPhoto()).into(holder.home_valuable_listitem_img);
        Date date = new Date(createDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        holder.home_valuable_listitem_time.setText(format);
        holder.home_valuable_listitem_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "宝典头像", Toast.LENGTH_SHORT).show();
            }
        });
        holder.home_valuable_list_item_collect_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "收藏", Toast.LENGTH_SHORT).show();
            }
        });
        holder.home_valuable_list_item_reply_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "评论", Toast.LENGTH_SHORT).show();
            }
        });
        holder.home_valuable_list_item_praise_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点赞", Toast.LENGTH_SHORT).show();
            }
        });
        holder.home_valuable_list_item_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "分享", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }



    public class Holder extends RecyclerView.ViewHolder {
        private ImageView home_valuable_listitem_img;
        private TextView home_valuable_listitem_name;
        private TextView home_valuable_listitem_contenttype;
        private TextView home_valuable_listitem_time;
        private TextView home_valuable_listitem_title;
        private TextView home_valuable_listitem_content;
        private ImageView home_valuable_listitem_contentimg;
        private ImageView home_valuable_listitem_audioimg;
        private TextView home_valuable_listitem_audio_time;
        private RelativeLayout home_valuable_listitem_audio_gorpu;
        private TextView home_valuable_listitem_video_time;
        private LinearLayout home_valuable_listitem_video_gorpu;
        private RelativeLayout home_valuable_listitem_contentimg_group;
        private TextView home_valuable_listitem_worktype;
        private CheckBox home_valuable_list_item_collect_cb;
        private LinearLayout home_valuable_list_item_collect_group;
        private CheckBox home_valuable_list_item_reply_cb;
        private LinearLayout home_valuable_list_item_reply_group;
        private CheckBox home_valuable_list_item_praise_cb;
        private LinearLayout home_valuable_list_item_praise_group;
        private LinearLayout home_valuable_list_item_share;
        public Holder(View itemView) {
            super(itemView);
            home_valuable_listitem_name=itemView.findViewById(R.id.home_valuable_listitem_name);
            home_valuable_listitem_contenttype=itemView.findViewById(R.id.home_valuable_listitem_contenttype);
            home_valuable_listitem_time=itemView.findViewById(R.id.home_valuable_listitem_time);
            home_valuable_listitem_title=itemView.findViewById(R.id.home_valuable_listitem_title);
            home_valuable_listitem_content=itemView.findViewById(R.id.home_valuable_listitem_content);
            home_valuable_listitem_contentimg=itemView.findViewById(R.id.home_valuable_listitem_contentimg);
            home_valuable_listitem_img=itemView.findViewById(R.id.home_valuable_listitem_img);

            home_valuable_list_item_collect_group=itemView.findViewById(R.id.home_valuable_list_item_collect_group);
            home_valuable_list_item_reply_group=itemView.findViewById(R.id.home_valuable_list_item_reply_group);
            home_valuable_list_item_praise_group=itemView.findViewById(R.id.home_valuable_list_item_praise_group);
            home_valuable_list_item_share=itemView.findViewById(R.id.home_valuable_list_item_share);

            home_valuable_list_item_collect_cb=itemView.findViewById(R.id.home_valuable_list_item_collect_cb);
            home_valuable_list_item_reply_cb=itemView.findViewById(R.id.home_valuable_list_item_reply_cb);
            home_valuable_list_item_praise_cb=itemView.findViewById(R.id.home_valuable_list_item_praise_cb);


        }
    }
    public interface BaoDianOnClickListion{
        void setBaoDianOnClickListion(View view,int postion);
    }
    private BaoDianOnClickListion baoDianOnClickListion;
    @Override
    public void onClick(View v) {
        if (baoDianOnClickListion!=null){
            baoDianOnClickListion.setBaoDianOnClickListion(v,(int)v.getTag());
        }
    }
    public void setBaoDianOnClickListionItem(BaoDianOnClickListion baoDianOnClickListion){
        this.baoDianOnClickListion=baoDianOnClickListion;

    }
}
