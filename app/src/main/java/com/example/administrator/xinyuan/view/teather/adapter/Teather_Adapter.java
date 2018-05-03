package com.example.administrator.xinyuan.view.teather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.model.entity.TeatherBean;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */

public class Teather_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int zero =0;
    private int one=1;
    private int two=2;
    private int three=3;
    private int four=4;
    private int five=5;
    private int six=6;
    private ArrayList<Object> teather_list;
    private Context context;

    public Teather_Adapter(ArrayList<Object> teather_list,Context context) {
        this.context = context;
        this.teather_list=teather_list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        RecyclerView.ViewHolder holder=null;
        if (viewType==zero){
            View inflate = inflater.inflate(R.layout.teather_zero_item,parent,false);
            holder=new HolderZero(inflate);
            return holder;
        }else if (viewType==one){
            View inflate = inflater.inflate(R.layout.teather_one_item, parent, false);
            holder=new HolderOne(inflate);
            return holder;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HolderZero){
            List<TeatherBean.DataBean.LiveCoursesBean> liveCourses= (List<TeatherBean.DataBean.LiveCoursesBean>) teather_list.get(0);
        ArrayList<String> imgs=new ArrayList<>();
          for (int i=0;i<liveCourses.size();i++){
              imgs.add(liveCourses.get(i).getCoverImg());
          }
          Log.e("SSSSSSSSSSSSs",imgs.size()+"");
        ((HolderZero) holder).flyBanner.setImagesUrl(imgs);

        }else if (holder instanceof HolderOne){


        }else if (holder instanceof HolderTwo){

        }else if (holder instanceof HolderThree){

        }else if (holder instanceof HolderFour){

        }else if (holder instanceof HolderFive){

        }else if (holder instanceof HolderSix){

        }
    }

    @Override
    public int getItemCount() {
        return teather_list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==zero){
            return zero;
        }else if (position==one){
            return one;
        }else if (position==two){
            return two;
        }else if (position==three){
            return three;
        }else if (position==four){
            return four;
        }else if (position==five){
            return five;
        }else {
            return six;
        }



    }
    public class HolderZero extends RecyclerView.ViewHolder{
        private FlyBanner flyBanner;
        public HolderZero(View itemView) {
            super(itemView);
            flyBanner=itemView.findViewById(R.id.teather_lunbo);
        }
    }
    public class HolderOne extends RecyclerView.ViewHolder{

        public HolderOne(View itemView) {
            super(itemView);
        }
    }
    public class HolderTwo extends RecyclerView.ViewHolder{

        public HolderTwo(View itemView) {
            super(itemView);
        }
    }
    public class HolderThree extends RecyclerView.ViewHolder{

        public HolderThree(View itemView) {
            super(itemView);
        }
    }
    public class HolderFour extends RecyclerView.ViewHolder{

        public HolderFour(View itemView) {
            super(itemView);
        }
    }
    public class HolderFive extends RecyclerView.ViewHolder{

        public HolderFive(View itemView) {
            super(itemView);
        }
    }
    public class HolderSix extends RecyclerView.ViewHolder{

        public HolderSix(View itemView) {
            super(itemView);
        }
    }

}
