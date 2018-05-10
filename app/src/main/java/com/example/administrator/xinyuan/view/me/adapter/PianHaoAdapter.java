package com.example.administrator.xinyuan.view.me.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.MyPianHaoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fghjkl on 2018/5/9.
 */

public class PianHaoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Object> list;
    private final int ONE_ITEM=0;
    private final int TWO_ITEM=1;

    public PianHaoAdapter(Context context, ArrayList<Object> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if(viewType==ONE_ITEM){
            MyPianHaoBean.DataBean dataBean = (MyPianHaoBean.DataBean) list.get(ONE_ITEM);
            final List<MyPianHaoBean.DataBean.MajorsBean> majors = dataBean.getMajors();
            Log.e("majors",majors.size()+"");
            PianHaoZhuanYeAdapter pianHaoZhuanYeAdapter = new PianHaoZhuanYeAdapter(parent.getContext(), majors);
            pianHaoZhuanYeAdapter.setOnclick(new PianHaoZhuanYeAdapter.Onclick() {
                @Override
                public void wai(View view, int possi) {
                    etTiao.bi(view,majors.get(possi).getId());
                }
            });
            return new OneHolder(getZhuanyeView(parent,R.layout.pianhao_zhuanye,R.id.mRecy,pianHaoZhuanYeAdapter));
        }else if(viewType==TWO_ITEM){
            MyPianHaoBean.DataBean dataBeen = (MyPianHaoBean.DataBean) list.get(ONE_ITEM);
            List<MyPianHaoBean.DataBean.CollegesBean> colleges = dataBeen.getColleges();
            return new TwoHolder(getYuanXiaoView(parent,R.layout.pianhao_yuanxiao,R.id.mRecy,new PianHaoYuanXiaoAdapter(parent.getContext(),colleges)));
        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof OneHolder){

        }else if(holder instanceof  TwoHolder){

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return ONE_ITEM;
        }else {
            return TWO_ITEM;
        }
    }
    class OneHolder extends RecyclerView.ViewHolder{


        public OneHolder(View itemView) {
            super(itemView);
        }
    }
    class TwoHolder extends RecyclerView.ViewHolder{


        public TwoHolder(View itemView) {
            super(itemView);
        }
    }


    private View getZhuanyeView(ViewGroup parent,int item,int id,RecyclerView.Adapter adapter){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(item, parent, false);
        RecyclerView recyclerView = inflate.findViewById(id);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(parent.getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return inflate;



    }
    private View getYuanXiaoView(ViewGroup parent,int item,int id,RecyclerView.Adapter adapter){
        View inflate = LayoutInflater.from(parent.getContext()).inflate(item, parent, false);
        RecyclerView recyclerView = inflate.findViewById(id);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(parent.getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return inflate;



    }
    public interface setTiao{
        void bi(View view,int possi);
    }
    private setTiao etTiao;
    public void setCunZhi(setTiao etTiao){
        this.etTiao=etTiao;

    }


}
