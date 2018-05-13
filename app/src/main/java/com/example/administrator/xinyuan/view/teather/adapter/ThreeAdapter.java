package com.example.administrator.xinyuan.view.teather.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xinyuan.App;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.contact.dainzancontact.DianZanContact;
import com.example.administrator.xinyuan.model.entity.TeatherBean;
import com.example.administrator.xinyuan.presenter.dianzanpresenter.IDianZanPresenter;
import com.example.administrator.xinyuan.view.work.Work_ItemActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/4.
 */

public class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.Holder> implements View.OnClickListener,DianZanContact.View {
    private Context context;
    private List<TeatherBean.DataBean.HomewoksBean> homewoks;
    private Map<String, Object> params;
    private IDianZanPresenter iDianZanPresenter;
    private int postions;
    private Intent intent;
    private UMShareListener umShareListener= new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(context,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context,"取消了",Toast.LENGTH_LONG).show();

        }
    };

    public ThreeAdapter(Context context, List<TeatherBean.DataBean.HomewoksBean> homewoks) {
        this.context = context;
        this.homewoks = homewoks;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.teather_three_zi_item, parent, false);
        Holder holder = new Holder(inflate);
        holder.itemView.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        postions=position;
        if (position == 0) {
            holder.three_touxiang.setImageResource(R.mipmap.ic_launcher);
        } else {

            Glide.with(context).load(homewoks.get(position).getPhoto())
                    .asBitmap()
                    .error(R.mipmap.play_music_bg)
                    .override(50, 50)
                    .into(new BitmapImageViewTarget(holder.three_touxiang) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            super.setResource(resource);
                            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
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
     //点赞
        iDianZanPresenter = new IDianZanPresenter(this);
        params = new HashMap<>();
        params.put("userId",homewoks.get(position).getTUserId());
        params.put("id",homewoks.get(position).getId());
        SharedPreferences xiaoji =context. getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        int id1 = xiaoji.getInt("id", 0);
        params.put("loginUserId",id1);
        params.put("type","学生作业" );
        holder.work_recycler_item_praise_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){


                    iDianZanPresenter.loadDianZan(params);
                    holder.work_dianzan_geshu.setText((homewoks.get(position).getPraiseNum()+1)+"");
                }else {
                    holder.work_dianzan_geshu.setText((homewoks.get(position).getPraiseNum())+"");
                    iDianZanPresenter.loadQuDianZan(params);
                }
            }
        });
        holder.work_pinglin_geshu.setText(homewoks.get(position).getCommentNum()+"");
        holder.work_dianzan_geshu.setText(homewoks.get(position).getPraiseNum()+"");
        holder.work_zanshang_geshu.setText(homewoks.get(position).getGiftNum()+"");
        intent = new Intent(context, Work_ItemActivity.class);
        intent.putExtra("id",homewoks.get(postions).getId());
        intent.putExtra("replyId",homewoks.get(postions).getTUserId());
        intent.putExtra("refId",homewoks.get(postions).getId());
        holder.work_recycler_item_reply_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(intent);
            }
        });
        holder.work_recycler_item_reward_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(intent);
            }
        });
        holder.teather_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  new ShareAction(App.context)
                        .withMedia(image)
                        .withText("hello")
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener)
                        .open();*/
                String path = homewoks.get(position).getPath();
                UMWeb web = new UMWeb(path);
                web.setTitle("This is music title");//标题
                UMImage image = new UMImage(context,R.mipmap.ic_launcher );//网络图片
                web.setThumb(image);  //缩略图
                web.setDescription(homewoks.get(position).getContent());//描述


                new ShareAction(App.context)
                        .withMedia(web)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener)
                        .open();
            }
        });
      /*  holder.rb1.setOnClickListener(new View.OnClickListener() {
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
        });*/


    }

    @Override
    public int getItemCount() {
        return homewoks.size();
    }

    @Override
    public void dianZan(ResponseBody responseBody) {
        try {
            Log.e("homework的关注", "dianZan: "+responseBody.string() );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void quDianZan(ResponseBody responseBody) {
        try {
            Log.e("homework的取消关注", "dianZan: "+responseBody.string() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView three_touxiang;
        private TextView three_name;
        private TextView three_time;
        private TextView laizi;
        private TextView work_from;
        private TextView three_contact;
        private ImageView three_img;
        private TextView fff;
        private CheckBox work_recycler_item_reply_cb;
        private TextView work_pinglin_geshu;
        private LinearLayout work_recycler_item_reply_group;
        private CheckBox work_recycler_item_praise_cb;
        private TextView work_dianzan_geshu;
        private LinearLayout work_recycler_item_praise_group;
        private CheckBox work_recycler_item_reward_cb;
        private TextView work_zanshang_geshu;
        private LinearLayout work_recycler_item_reward_group;
        private LinearLayout work_recycler_item_share;
        private ImageView teather_share;

        public Holder(View itemView) {
            super(itemView);
            three_img = itemView.findViewById(R.id.word_image);
            three_name = itemView.findViewById(R.id.work_name);
            three_time = itemView.findViewById(R.id.work_time);
            three_contact = itemView.findViewById(R.id.work_content);
            three_touxiang = itemView.findViewById(R.id.work_img);
            work_recycler_item_reply_cb=itemView.findViewById(R.id.work_recycler_item_reply_cb);
            work_recycler_item_praise_cb=itemView.findViewById(R.id.work_recycler_item_praise_cb);
            work_recycler_item_reward_cb=itemView.findViewById(R.id.work_recycler_item_reward_cb);
            work_pinglin_geshu=itemView.findViewById(R.id.work_pinglin_geshu);
            work_dianzan_geshu=itemView.findViewById(R.id.work_dianzan_geshu);
            work_zanshang_geshu=itemView.findViewById(R.id.work_zanshang_geshu);
            teather_share=itemView.findViewById(R.id.teather_share);


        }
    }

    public static String longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }

    public interface ThreeOnClick {
        void setThreeOnClick(View view, int postion);
    }

    private ThreeOnClick threeOnClick;

    @Override
    public void onClick(View v) {
        if (threeOnClick != null) {
            threeOnClick.setThreeOnClick(v, (int) v.getTag());
        }

    }

    public void setThreeOnCLickItem(ThreeOnClick threeOnClick) {
        this.threeOnClick = threeOnClick;

    }
}
