package com.example.administrator.xinyuan.view.teather.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.ZhaoTeather_FenSi_Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/9.
 */

public class ZhaoTeather_FenSi_Adapter extends BaseAdapter {

    private Context context;
    private List<ZhaoTeather_FenSi_Bean.DataBean.ListBean> list;
    private View inflate;

    public ZhaoTeather_FenSi_Adapter(Context context, List<ZhaoTeather_FenSi_Bean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater from = LayoutInflater.from(context);

        ZhaoTeather_FenSi_Adapter.Holder holder=null;
        if (convertView==null){
            convertView = from.inflate(R.layout.zhaoteather_fensi, null);
            holder=new Holder();
            holder.zhao_fensi_guanzhu= convertView.findViewById(R.id.zhao_fensi_guanzhu);
            holder.zhao_fensi_img= convertView.findViewById(R.id.zhao_fensi_img);
            holder.zhao_fensi_name= convertView.findViewById(R.id.zhao_fensi_name);
          convertView.setTag(holder);
        }else {
          holder= (Holder) convertView.getTag();
        }

        final Holder finalHolder = holder;
        Glide.with(context).load(list.get(position).getPhoto()).asBitmap()
                .override(50,50)
                .into(new BitmapImageViewTarget(finalHolder.zhao_fensi_img){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCornerRadius(100);
                        finalHolder.zhao_fensi_img.setImageDrawable(drawable);
                    }
                });
        holder.zhao_fensi_name.setText(list.get(position).getNickname());


        return convertView;
    }

    public class Holder {
        public ImageView zhao_fensi_img;
        public TextView zhao_fensi_name;
        public Button zhao_fensi_guanzhu;
    }


}
