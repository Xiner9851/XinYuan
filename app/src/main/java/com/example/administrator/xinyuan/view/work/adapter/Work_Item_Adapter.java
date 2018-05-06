package com.example.administrator.xinyuan.view.work.adapter;

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

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.WorkBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/5.
 */

public class Work_Item_Adapter extends RecyclerView.Adapter<Work_Item_Adapter.Holder> {
    private List<WorkBean.DataBean.ListBean> list;
    private Context context;


    public Work_Item_Adapter(List<WorkBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.work_fuyong_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        WorkBean.DataBean.ListBean listBean = list.get(position);
        Glide.with(context).load(list.get(position).getPhoto()).into(holder.work_recycler_item_title_img);
        holder.work_recycler_item_student_name.setText(list.get(position).getNickname());
        holder.work_recycler_item_from.setText(listBean.getSource());
        holder. work_recycler_item_content.setText(listBean.getContent());
        Glide.with(context).load(list.get(position).getCoverImg()).into(holder.work_recycler_item_intro_img);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private RoundedImageView work_recycler_item_title_img;
        private TextView work_recycler_item_student_name;
        private TextView work_recycler_item_time;
        private TextView work_recycler_item_from;
        private TextView work_recycler_item_content;
        private TextView work_recycler_item_content_intro;
        private ImageView work_recycler_item_intro_img;
        private ImageView work_recycler_item_audio_img;
        private TextView work_recycler_item_audio_time;
        private RelativeLayout work_recycler_item_audio_gorpu;
        private TextView work_recycler_item_video_time;
        private LinearLayout work_recycler_item_video_gorpu;
        private RelativeLayout work_recycler_item_intro_img_group;
        private TextView work_recycler_item_work_type;
        private RoundedImageView work_recycler_item_teacher_img;
        private TextView work_recycler_item_teacher_name;
        private TextView work_recycler_item_teacher_intro;
        private TextView work_recycler_item_peep_price;
        private LinearLayout work_recycler_item_peep;
        private RelativeLayout work_recycler_item_teacher_group;
        private TextView home_masterwork_listitem_teacher_group_line;
        private CheckBox work_recycler_item_reply_cb;
        private LinearLayout work_recycler_item_reply_group;
        private CheckBox work_recycler_item_praise_cb;
        private LinearLayout work_recycler_item_praise_group;
        private CheckBox work_recycler_item_reward_cb;
        private LinearLayout work_recycler_item_reward_group;
        private LinearLayout work_recycler_item_share;
        public Holder(View itemView) {
            super(itemView);
            work_recycler_item_teacher_name=itemView.findViewById(R.id.work_recycler_item_teacher_name);
         work_recycler_item_teacher_intro=itemView.findViewById(R.id.work_recycler_item_teacher_intro);
          work_recycler_item_peep_price=itemView.findViewById(R.id.work_recycler_item_peep_price);
            work_recycler_item_title_img=itemView.findViewById(R.id.work_recycler_item_title_img);
          work_recycler_item_student_name=itemView.findViewById(R.id.work_recycler_item_student_name);
          work_recycler_item_time=itemView.findViewById(R.id.work_recycler_item_time);
           work_recycler_item_from=itemView.findViewById(R.id.work_recycler_item_from);
            work_recycler_item_content=itemView.findViewById(R.id. work_recycler_item_content);
            work_recycler_item_intro_img=itemView.findViewById(R.id.work_recycler_item_intro_img);
        }
    }
}
