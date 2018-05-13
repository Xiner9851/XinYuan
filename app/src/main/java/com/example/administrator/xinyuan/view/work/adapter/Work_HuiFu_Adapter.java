package com.example.administrator.xinyuan.view.work.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.HuiFuLieBiaoBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class Work_HuiFu_Adapter extends BaseAdapter{
    private  List<HuiFuLieBiaoBean.DataBean.CommentsBean.ListBean> list;
    private Context context;

    public Work_HuiFu_Adapter( List<HuiFuLieBiaoBean.DataBean.CommentsBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.work_huifu_item, null);
        final ViewHolder viewHolder = new ViewHolder(inflate);
        if (list.get(position).getPhoto() != "") {
            Glide.with(context).load(list.get(position).getPhoto()).asBitmap()
                    .override(50, 50)
                    .into(new BitmapImageViewTarget(viewHolder.work_pinglun_touxiang) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            super.setResource(resource);
                            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                            drawable.setCornerRadius(100);
                            viewHolder.work_pinglun_touxiang.setImageDrawable(drawable);
                        }
                    });

        } else {
            viewHolder.work_pinglun_touxiang.setImageResource(R.mipmap.user_head_portrait);
        }


        viewHolder.work_pinglun_name.setText(list.get(position).getNickname());
        viewHolder.work_pinglun_message.setText(list.get(position).getContent());
        long createDate = list.get(position).getCreateDate();
        String s = longToDate(createDate);
        viewHolder.work_pinglun_time.setText(s);
        viewHolder.work_dianzan_geshu.setText(list.get(position).getPraiseNum() + "");
       /* viewHolder.work_huifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Work_HuiFuActivity.class);
                int id = list.get(position).getId();
                int userId = list.get(position).getUserId();
                String s1 = viewHolder.work_pinglun_message.getText().toString();

                intent.putExtra("toId",id);
                intent.putExtra("toContent",s1);
                intent.putExtra("replyId",userId);
                intent.putExtra("refId",id);
                context.startActivity(intent);
            }
        });*/
        return inflate;
    }



    public static class ViewHolder {
        public View rootView;
        public ImageView work_pinglun_touxiang;
        public TextView work_pinglun_name;
        public TextView work_pinglun_message;
        public TextView work_pinglun_time;
        public ImageView work_praise_normal;
        public ImageView work_praise_active;
        public TextView work_dianzan_geshu;
       // public TextView work_huifu;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.work_pinglun_touxiang = (ImageView) rootView.findViewById(R.id.work_pinglun_touxiang);
            this.work_pinglun_name = (TextView) rootView.findViewById(R.id.work_pinglun_name);
            this.work_pinglun_message = (TextView) rootView.findViewById(R.id.work_pinglun_message);
            this.work_pinglun_time = (TextView) rootView.findViewById(R.id.work_pinglun_time);
            this.work_praise_normal = (ImageView) rootView.findViewById(R.id.work_praise_normal);
            this.work_praise_active = (ImageView) rootView.findViewById(R.id.work_praise_active);
            this.work_dianzan_geshu = (TextView) rootView.findViewById(R.id.work_dianzan_geshu);
           // work_huifu=rootView.findViewById(R.id.work_huifu);
        }

    }

    public static String longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }

}
