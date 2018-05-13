package com.example.administrator.xinyuan.view.teather.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xinyuan.MainActivity;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.model.entity.TeatherBean;
import com.example.administrator.xinyuan.view.baodian.BaoDianFragment;
import com.example.administrator.xinyuan.view.teather.Teather_Banner_Item2Activity;
import com.example.administrator.xinyuan.view.teather.Teather_Banner_Item_Activity;
import com.example.administrator.xinyuan.view.teather.XianShang_Activity;
import com.example.administrator.xinyuan.view.teather.ZhaoTeatherActivity;
import com.example.administrator.xinyuan.view.work.WorkFragment;
import com.example.administrator.xinyuan.view.yugao.YuGaoFragment;
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
    private List<TeatherBean.DataBean.SystemAdsBean> systemAds;
    private List<TeatherBean.DataBean.LiveCoursesBean> liveCourses;

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
            oneAdapter.setOneOnCLickItem(new OneAdapter.OneOnClick() {
                @Override
                public void setOneOnClick(View view, int postion) {
                    oneClick.setOneClick(postion);
                }
            });
            return holder;
        }else if (viewType==two){
            View inflate = inflater.inflate(R.layout.teather_twot_item, parent, false);
            holder=new HolderTwo(inflate);
            liveCourses = (List<TeatherBean.DataBean.LiveCoursesBean>) teather_list.get(2);
            ((HolderTwo) holder).two_recy.setLayoutManager(new GridLayoutManager(context,2));
            TwoAdapter twoAdapter = new TwoAdapter(context, liveCourses);
            ((HolderTwo) holder).two_recy.setAdapter(twoAdapter);
            twoAdapter.setTwoOnCLickItem(new TwoAdapter.TwoOnClick() {
                @Override
                public void setTwoOnClick(View view, int postion) {
                    twoClick.setTwoClick(postion);
                }
            });
            return holder;
        }else if (viewType==three){
            View inflate = inflater.inflate(R.layout.teather_three_item, parent, false);
            holder = new HolderThree(inflate);
            List<TeatherBean.DataBean.HomewoksBean> homewoks= (List<TeatherBean.DataBean.HomewoksBean>) teather_list.get(3);
            ((HolderThree) holder).three_recy.setLayoutManager(new LinearLayoutManager(context));
            ThreeAdapter threeAdapter = new ThreeAdapter(context,homewoks);
            ((HolderThree) holder).three_recy.setAdapter(threeAdapter);
            threeAdapter.setThreeOnCLickItem(new ThreeAdapter.ThreeOnClick() {
                @Override
                public void setThreeOnClick(View view, int postion) {
                    threeClick.setThreeClick(postion);
                }
            });
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
            systemAds = (List<TeatherBean.DataBean.SystemAdsBean>) teather_list.get(0);
        ArrayList<String> imgs=new ArrayList<>();
          for (int i = 0; i< systemAds.size(); i++){
              imgs.add(systemAds.get(i).getMobileImgUrl());
          }
          Log.e("SSSSSSSSSSSSs",imgs.size()+"");

        ((HolderZero) holder).flyBanner.setImagesUrl(imgs);
            ((HolderZero) holder).flyBanner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(context, "轮播图"+position, Toast.LENGTH_SHORT).show();
                    String urlType = systemAds.get(position).getUrlType();
                    if (urlType.equals("3")){
                        Intent intent = new Intent(context, Teather_Banner_Item_Activity.class);
                    intent.putExtra("id", systemAds.get(position).getMobileUrl());
                        context.startActivity(intent);
                    }else if (urlType.equals("4")){
                        Intent intent = new Intent(context, Teather_Banner_Item2Activity.class);
                        intent.putExtra("id",liveCourses.get(position).getId());
                        context.startActivity(intent);
                    }

                }
            });
            //找老师监听
            ((HolderZero) holder).rb1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "找老师", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, ZhaoTeatherActivity.class);
                    context.startActivity(intent);
                }
            });
            //线上课监听
            ((HolderZero) holder).rb2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "线上课", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, XianShang_Activity.class);
                    context.startActivity(intent);
                }
            });
            //交作业监听
            ((HolderZero) holder).rb3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "交作业", Toast.LENGTH_SHORT).show();

                   // context.startActivity(new Intent(conext, WorkFragment.class));
                    ((BaseActivity)context). setContentView(R.id.fragment_manger, WorkFragment.class, null);
                    ((MainActivity)context).work_btn.setChecked(true);
                }
            });
            //聊艺考监听
            ((HolderZero) holder).rb4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "聊艺考", Toast.LENGTH_SHORT).show();
                   // context.startActivity(new Intent(context, BaoDianFragment.class));
                    ((MainActivity)context).baodian_btn.setChecked(true);
                    ((BaseActivity)context). setContentView(R.id.fragment_manger, BaoDianFragment.class, null);
                }
            });
            //线下课监听
            ((HolderZero) holder).rb5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "线下课", Toast.LENGTH_SHORT).show();
                   // context.startActivity(new Intent(context, YuGaoFragment.class));
                    ((MainActivity)context).yugao_btn.setChecked(true);
                    ((BaseActivity)context). setContentView(R.id.fragment_manger, YuGaoFragment.class, null);
                }
            });


        }else if (holder instanceof HolderOne){
            ((HolderOne) holder).one_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ZhaoTeatherActivity.class);
                    context.startActivity(intent);
                }
            });

        }else if (holder instanceof HolderTwo){
            ((HolderTwo) holder).two_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, XianShang_Activity.class);
                    context.startActivity(intent);
                }
            });

        }else if (holder instanceof HolderThree){
            ((HolderThree) holder).three_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((BaseActivity)context). setContentView(R.id.fragment_manger, WorkFragment.class, null);
                    ((MainActivity)context).work_btn.setChecked(true);
                }
            });

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
        private RadioButton rb1;
        private RadioButton rb2;
        private RadioButton rb3;
        private RadioButton rb4;
        private RadioButton rb5;


        public HolderZero(View itemView) {
            super(itemView);
            flyBanner=itemView.findViewById(R.id.teather_lunbo);
            rb1=itemView.findViewById(R.id.find_teather_btn);
            rb2=itemView.findViewById(R.id.xianshang_ke_btn);
            rb3=itemView.findViewById(R.id.jiao_work_btn);
            rb4=itemView.findViewById(R.id.liao_yikao_btn);
            rb5=itemView.findViewById(R.id.xianxia_ke_btn);


        }
    }
    public class HolderOne extends RecyclerView.ViewHolder{
        private RecyclerView one_recy;
        private TextView one_more;
        public HolderOne(View itemView) {
            super(itemView);
            one_recy=itemView.findViewById(R.id.one_recy);
            one_more=itemView.findViewById(R.id.one_more);
        }
    }
    public class HolderTwo extends RecyclerView.ViewHolder{
        private RecyclerView two_recy;
        private TextView two_more;
        public HolderTwo(View itemView) {
            super(itemView);
            two_recy=itemView.findViewById(R.id.two_recy);
            two_more =itemView.findViewById(R.id.two_more);
        }
    }
    public class HolderThree extends RecyclerView.ViewHolder{
        private RecyclerView three_recy;
        private TextView three_more;
        public HolderThree(View itemView) {
            super(itemView);
            three_recy=itemView.findViewById(R.id.teather_three_recy);
            three_more=itemView.findViewById(R.id.three_more);
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

    public interface OneClick{
        void setOneClick(int postion);
    }
    private OneClick oneClick;
    public void setOneClick(OneClick oneClick){
        this.oneClick=oneClick;
    };
    public interface TwoClick{
        void setTwoClick(int postion);
    }
    private TwoClick twoClick;
    public void setTwoClick(TwoClick twoClick){
        this.twoClick=twoClick;
    };
    public interface ThreeClick{
        void setThreeClick(int postion);
    }
    private ThreeClick threeClick;
    public void setThreeClick(ThreeClick threeClick){
        this.threeClick=threeClick;
    };

}
