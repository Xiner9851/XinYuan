package com.example.administrator.xinyuan.view.teather.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

            ((HolderOne) holder).one_recy.setLayoutManager(linearLayoutManager);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            List<TeatherBean.DataBean.UsersBean> users= (List<TeatherBean.DataBean.UsersBean>) teather_list.get(1);

            OneAdapter oneAdapter = new OneAdapter(context, users);
            ((HolderOne) holder).one_recy.setAdapter(oneAdapter);
            return holder;
        }else if (viewType==two){
            View inflate = inflater.inflate(R.layout.teather_twot_item, parent, false);
            holder=new HolderTwo(inflate);
            List<TeatherBean.DataBean.LiveCoursesBean> liveCourses= (List<TeatherBean.DataBean.LiveCoursesBean>) teather_list.get(2);
            ((HolderTwo) holder).two_recy.setLayoutManager(new GridLayoutManager(context,2));
            TwoAdapter twoAdapter = new TwoAdapter(context, liveCourses);
            ((HolderTwo) holder).two_recy.setAdapter(twoAdapter);
            return holder;
        }else if (viewType==three){
            View inflate = inflater.inflate(R.layout.teather_three_item, parent, false);
            holder = new HolderThree(inflate);
            List<TeatherBean.DataBean.HomewoksBean> homewoks= (List<TeatherBean.DataBean.HomewoksBean>) teather_list.get(3);
            ((HolderThree) holder).three_recy.setLayoutManager(new LinearLayoutManager(context));
            ThreeAdapter threeAdapter = new ThreeAdapter(context,homewoks);
            ((HolderThree) holder).three_recy.setAdapter(threeAdapter);
            return holder;
        }else if (viewType==four){
            View inflate = inflater.inflate(R.layout.teather_four_item, parent, false);
            holder=new HolderFour(inflate);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HolderZero){
            List<TeatherBean.DataBean.SystemAdsBean> systemAds= (List<TeatherBean.DataBean.SystemAdsBean>) teather_list.get(0);
        ArrayList<String> imgs=new ArrayList<>();
          for (int i=0;i<systemAds.size();i++){
              imgs.add(systemAds.get(i).getMobileImgUrl());
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
        private RecyclerView one_recy;
        public HolderOne(View itemView) {
            super(itemView);
            one_recy=itemView.findViewById(R.id.one_recy);
        }
    }
    public class HolderTwo extends RecyclerView.ViewHolder{
        private RecyclerView two_recy;
        public HolderTwo(View itemView) {
            super(itemView);
            two_recy=itemView.findViewById(R.id.two_recy);
        }
    }
    public class HolderThree extends RecyclerView.ViewHolder{
        private RecyclerView three_recy;
        public HolderThree(View itemView) {
            super(itemView);
            three_recy=itemView.findViewById(R.id.teather_three_recy);
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
