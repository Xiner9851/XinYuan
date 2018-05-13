package com.example.administrator.xinyuan.view.work.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.Work_ZanShangBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class Work_ZanShangAdapter extends RecyclerView.Adapter<Work_ZanShangAdapter.Holder> {
    private List<Work_ZanShangBean.DataBean.RewardUserListBean> rewardUserList;
    private Context context;

    public Work_ZanShangAdapter(List<Work_ZanShangBean.DataBean.RewardUserListBean> rewardUserList, Context context) {
        this.rewardUserList = rewardUserList;
        this.context = context;
    }

    @Override
    public Work_ZanShangAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.work_zanshang_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final Work_ZanShangAdapter.Holder holder, int position) {
        Glide.with(context).load(rewardUserList.get(position).getUserPhoto()).asBitmap()
                .error(R.mipmap.user_head_portrait)
                .override(50,50)
                .into(new BitmapImageViewTarget(holder.img){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCornerRadius(50);
                        holder.img.setImageDrawable(drawable);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return rewardUserList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        public Holder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.work_zanshang_img);
        }
    }
}
