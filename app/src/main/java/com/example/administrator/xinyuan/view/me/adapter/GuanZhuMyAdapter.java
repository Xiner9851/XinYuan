package com.example.administrator.xinyuan.view.me.adapter;

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
import com.example.administrator.xinyuan.model.entity.GuanZhuMyBean;

import java.util.List;

/**
 * Created by fghjkl on 2018/5/13.
 */

public class GuanZhuMyAdapter extends BaseAdapter {
    private Context context;
    private List<GuanZhuMyBean.DataBean.ListBean> list;
    private Vh vh;
    public GuanZhuMyAdapter(Context context, List<GuanZhuMyBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        vh = null;
        if(convertView==null){
            vh =new Vh();
            convertView= LayoutInflater.from(context).inflate(R.layout.guanzhu,null);
            vh.img=convertView.findViewById(R.id.img);
            vh.name=convertView.findViewById(R.id.name);
            convertView.setTag(vh);
        }else {
            vh = (Vh) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getPhoto())
                .asBitmap()
                .override(50,50)
                .into(new BitmapImageViewTarget(vh.img){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        roundedBitmapDrawable.setCornerRadius(100);
                        vh.img.setImageDrawable(roundedBitmapDrawable);
                    }
                });
        vh.name.setText(list.get(position).getNickname());


        return convertView;
    }
    class Vh{
        private ImageView img;
        private TextView name;
    }
}
