package com.example.administrator.xinyuan.view.work.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.example.administrator.xinyuan.contact.dainzancontact.DianZanContact;
import com.example.administrator.xinyuan.model.entity.WorkBean;
import com.example.administrator.xinyuan.presenter.dianzanpresenter.IDianZanPresenter;
import com.example.administrator.xinyuan.view.work.Work_ItemActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/5.
 */

public class Work_Item_Adapter extends RecyclerView.Adapter<Work_Item_Adapter.Holder> implements View.OnClickListener, DianZanContact.View {
    private List<WorkBean.DataBean.ListBean> list;
    private Context context;
    private int postions;



    public Work_Item_Adapter(List<WorkBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.work_fuyong_item, parent, false);
        Holder holder = new Holder(inflate);
        holder.itemView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        postions = position;
        final WorkBean.DataBean.ListBean listBean = list.get(position);
        Glide.with(context).load(list.get(position).getPhoto()).into(holder.work_recycler_item_title_img);
        holder.work_recycler_item_student_name.setText(list.get(position).getNickname());
        holder.work_recycler_item_from.setText(listBean.getSource());
        holder.work_recycler_item_content.setText(listBean.getContent());
        Glide.with(context).load(list.get(position).getCoverImg()).into(holder.work_recycler_item_intro_img);
        holder.itemView.setTag(position);
        //work评论
        holder.work_recycler_item_reply_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "work评论", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Work_ItemActivity.class);
                intent.putExtra("id", list.get(postions).getId());
                context.startActivity(intent);
            }
        });
        //work点赞
        final IDianZanPresenter iDianZanPresenter = new IDianZanPresenter(this);
        holder.work_recycler_item_praise_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "work点赞", Toast.LENGTH_SHORT).show();
                Map<String, Object> params = new HashMap<>();

                params.put("userId", listBean.getTUserId());
                params.put("id", listBean.getId());
                params.put("loginUserId", 668);
                params.put("type", "学生作业");
                iDianZanPresenter.loadDianZan(params);
                holder.work_recycler_item_qupraise_cb.setVisibility(View.VISIBLE);
                holder.work_recycler_item_praise_cb.setVisibility(View.GONE);
                holder.work_dianzan_geshu.setText((list.get(position).getPraiseNum()+1)+"");
            }
        });
        holder.work_recycler_item_qupraise_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "work点赞", Toast.LENGTH_SHORT).show();
                Map<String, Object> params = new HashMap<>();

                params.put("userId", listBean.getTUserId());
                params.put("id", listBean.getId());
                params.put("loginUserId", 668);
                params.put("type", "学生作业");
                iDianZanPresenter.loadQuDianZan(params);
                holder.work_recycler_item_qupraise_cb.setVisibility(View.GONE);
                holder.work_recycler_item_praise_cb.setVisibility(View.VISIBLE);
                holder.work_dianzan_geshu.setText((list.get(position).getPraiseNum())+"");
            }
        });

        //work赏
        holder.work_recycler_item_reward_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "work赏", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(context, Work_ItemActivity.class);
                intent2.putExtra("id", list.get(postions).getId());
                context.startActivity(intent2);
            }
        });
        //work分享
        holder.work_recycler_item_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "work分享", Toast.LENGTH_SHORT).show();
            }
        });
        //work头像

        holder.work_recycler_item_title_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "work头像", Toast.LENGTH_SHORT).show();
            }
        });
        holder.work_pinglin_geshu.setText(listBean.getCommentNum()+"");
        holder.work_dianzan_geshu.setText(listBean.getPraiseNum()+"");
        holder.work_zanshang_geshu.setText(listBean.getGiftNum()+"");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void dianZan(ResponseBody responseBody) {
        try {
            Log.e("gggg", responseBody.string() + "点赞");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void quDianZan(ResponseBody responseBody) {
        try {
            Log.e("gggg", responseBody.string() + "取消点赞");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        private TextView work_pinglin_geshu;
        private LinearLayout work_recycler_item_reply_group;
        private ImageView work_recycler_item_praise_cb;
        private ImageView work_recycler_item_qupraise_cb;
        private TextView work_dianzan_geshu;
        private LinearLayout work_recycler_item_praise_group;
        private CheckBox work_recycler_item_reward_cb;
        private TextView work_zanshang_geshu;
        private LinearLayout work_recycler_item_reward_group;
        private LinearLayout work_recycler_item_share;
        private LinearLayout work_item;

        public Holder(View itemView) {
            super(itemView);
            work_recycler_item_teacher_name = itemView.findViewById(R.id.work_recycler_item_teacher_name);
            work_recycler_item_teacher_intro = itemView.findViewById(R.id.work_recycler_item_teacher_intro);
            work_recycler_item_peep_price = itemView.findViewById(R.id.work_recycler_item_peep_price);
            work_recycler_item_title_img = itemView.findViewById(R.id.work_recycler_item_title_img);
            work_recycler_item_student_name = itemView.findViewById(R.id.work_recycler_item_student_name);
            work_recycler_item_time = itemView.findViewById(R.id.work_recycler_item_time);
            work_recycler_item_from = itemView.findViewById(R.id.work_recycler_item_from);
            work_recycler_item_content = itemView.findViewById(R.id.work_recycler_item_content);
            work_recycler_item_intro_img = itemView.findViewById(R.id.work_recycler_item_intro_img);
            work_item = itemView.findViewById(R.id.work_item);

            work_recycler_item_share = itemView.findViewById(R.id.work_recycler_item_share);
            work_recycler_item_reply_group = itemView.findViewById(R.id.work_recycler_item_reply_group);
            work_recycler_item_praise_group = itemView.findViewById(R.id.work_recycler_item_praise_group);
            work_recycler_item_reward_group = itemView.findViewById(R.id.work_recycler_item_reward_group);

            work_recycler_item_reply_cb = itemView.findViewById(R.id.work_recycler_item_reply_cb);
            work_recycler_item_praise_cb = itemView.findViewById(R.id.work_recycler_item_praise_cb);
            work_recycler_item_reward_cb = itemView.findViewById(R.id.work_recycler_item_reward_cb);
            work_recycler_item_qupraise_cb = itemView.findViewById(R.id.work_recycler_item_qupraise_cb);
            work_pinglin_geshu = itemView.findViewById(R.id.work_pinglin_geshu);
            work_zanshang_geshu = itemView.findViewById(R.id.work_zanshang_geshu);
            work_dianzan_geshu = itemView.findViewById(R.id.work_dianzan_geshu);

        }
    }

    public interface WorkOnClickListion {
        void setWorkOnClickListion(View view, int postion);
    }

    private WorkOnClickListion workOnClickListion;

    @Override
    public void onClick(View v) {
        if (workOnClickListion != null) {
            workOnClickListion.setWorkOnClickListion(v, (int) v.getTag());
        }
    }

    public void setworkOnClickListionItem(WorkOnClickListion workOnClickListion) {
        this.workOnClickListion = workOnClickListion;
    }
}
