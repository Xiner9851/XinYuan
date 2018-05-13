package com.example.administrator.xinyuan.view.teather.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.contact.zhaoteatherguanzhucontact.ZhaoTeatherGuanZhuContact;
import com.example.administrator.xinyuan.model.entity.ZhaoTeather_FenSi_Bean;
import com.example.administrator.xinyuan.presenter.zhaoteatherguanzhupresenter.IZhao_GuanZhu_Presenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/9.
 */

public class ZhaoTeather_FenSi_Adapter extends RecyclerView.Adapter<ZhaoTeather_FenSi_Adapter.Holder> implements ZhaoTeatherGuanZhuContact.View {

    private Context context;
    private IZhao_GuanZhu_Presenter iZhao_guanZhu_presenter;
    private int id1;

    private List<ZhaoTeather_FenSi_Bean.DataBean.ListBean> list;
    private View inflate;

    public ZhaoTeather_FenSi_Adapter(Context context, List<ZhaoTeather_FenSi_Bean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ZhaoTeather_FenSi_Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zhaoteather_fensi, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ZhaoTeather_FenSi_Adapter.Holder holder, final int position) {
        Glide.with(context).load(list.get(position).getPhoto()).asBitmap()
                .override(50,50)
                .error(R.mipmap.user_head_portrait)
                .into(new BitmapImageViewTarget(holder.img){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCornerRadius(100);
                        holder.img.setImageDrawable(drawable);
                    }
                });
        holder.name.setText(list.get(position).getNickname());
        holder.guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.quguanzhu.setVisibility(View.VISIBLE);

                holder.guanzhu.setVisibility(View.GONE);

                Map<String, Object> params = new HashMap<>();
                params.put("attentionId", list.get(position).getFansId());
                params.put("loginUserId", 668);

                iZhao_guanZhu_presenter.loadGuanZhu(params);


            }
        });
        iZhao_guanZhu_presenter = new IZhao_GuanZhu_Presenter(this);
        SharedPreferences xiaoji = context.getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        id1 = xiaoji.getInt("id", 0);
        holder.quguanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> params = new HashMap<>();
                params.put("attentionId",list.get(position).getFansId());
                params.put("loginUserId", 668);

                iZhao_guanZhu_presenter.loadQuGuan(params);
                holder.quguanzhu.setVisibility(View.GONE);

                holder.guanzhu.setVisibility(View.VISIBLE);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void guanzhu(ResponseBody responseBody) {

    }

    @Override
    public void quguan(ResponseBody responseBody) {

    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private Button guanzhu,quguanzhu;
        public Holder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.zhao_fensi_img);
            name=itemView.findViewById(R.id.zhao_fensi_name);
            guanzhu=itemView.findViewById(R.id.zhao_fensi_guanzhu);
            quguanzhu=itemView.findViewById(R.id.zhao_fensi_quguanzhu);
        }
    }
}
