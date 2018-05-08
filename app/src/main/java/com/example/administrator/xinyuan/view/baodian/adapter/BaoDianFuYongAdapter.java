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

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.BaoDianFuYongBean;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fghjkl on 2018/5/7.
 */

public class BaoDianFuYongAdapter extends RecyclerView.Adapter<BaoDianFuYongAdapter.Holder> {
    List<BaoDianFuYongBean.DataBean.ArtcircleListBean.ListBean> list1;
    private Context context;
    private LinearLayout xianqin;


    public BaoDianFuYongAdapter(List<BaoDianFuYongBean.DataBean.ArtcircleListBean.ListBean> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.baodian_fuyong_adapter, parent, false);
        xianqin=view.findViewById(R.id.xianqing);
        Holder holder = new Holder(view);


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
        Date date = new Date(createDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        holder.home_valuable_listitem_time.setText(format);


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
        private LinearLayout xianqin;
        public Holder(View itemView) {
            super(itemView);
            xianqin=itemView.findViewById(R.id.xianqing);
            home_valuable_listitem_name=itemView.findViewById(R.id.home_valuable_listitem_name);
            home_valuable_listitem_contenttype=itemView.findViewById(R.id.home_valuable_listitem_contenttype);
            home_valuable_listitem_time=itemView.findViewById(R.id.home_valuable_listitem_time);
            home_valuable_listitem_title=itemView.findViewById(R.id.home_valuable_listitem_title);
            home_valuable_listitem_content=itemView.findViewById(R.id.home_valuable_listitem_content);
            home_valuable_listitem_contentimg=itemView.findViewById(R.id.home_valuable_listitem_contentimg);
        }
    }

}
