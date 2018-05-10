package com.example.administrator.xinyuan.view.me.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.MyPianHaoBean;

import java.util.List;

/**
 * Created by fghjkl on 2018/5/9.
 */

public class PianHaoZhuanYeAdapter extends RecyclerView.Adapter<PianHaoZhuanYeAdapter.Holder> implements View.OnClickListener{
    private Context context;
    private List<MyPianHaoBean.DataBean.MajorsBean> o;

    public PianHaoZhuanYeAdapter(Context context, List<MyPianHaoBean.DataBean.MajorsBean> o) {
        this.context = context;
        this.o = o;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.one,parent,false);
        view.setOnClickListener(this);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.name.setText(o.get(position).getName());
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return o.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        private TextView name;
        public Holder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }

    public  interface Onclick{
        void wai(View view,int possi);
    }
    private Onclick onclick;
    @Override
    public void onClick(View v) {
        if(onclick!=null){
            onclick.wai(v,(int)v.getTag());
        }


    }
    public void setOnclick(Onclick onclick){
        this.onclick=onclick;
    }


}
