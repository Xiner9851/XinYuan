package com.example.administrator.xinyuan.view.teather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;

/**
 * Created by Administrator on 2018/5/8.
 */

public class OneItemAdapter extends RecyclerView.Adapter<OneItemAdapter.Holder> {
    private Context context;
    private String data;

    public OneItemAdapter(Context context, String data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public OneItemAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.teather_onecheck_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(OneItemAdapter.Holder holder, int position) {
        holder.onecheck_data.setText(data);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView onecheck_data;
        public Holder(View itemView) {
            super(itemView);
            onecheck_data=itemView.findViewById(R.id.onecheck_data);
        }
    }
}
