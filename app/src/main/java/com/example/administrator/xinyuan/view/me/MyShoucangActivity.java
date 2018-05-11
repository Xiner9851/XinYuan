package com.example.administrator.xinyuan.view.me;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.view.me.adapter.MyDingDangPageAdapter;
import com.example.administrator.xinyuan.view.me.fragment.TiYanFragment;
import com.example.administrator.xinyuan.view.me.fragment.TieziFragment;
import com.example.administrator.xinyuan.view.me.fragment.TouTingFragment;
import com.example.administrator.xinyuan.view.me.fragment.ZhiBoFragment;

import java.util.ArrayList;

public class MyShoucangActivity extends BaseActivity{



    private ViewPager vpge;
    private TabLayout mTab;
    private ArrayList<Fragment> mList=new ArrayList<>();
    private ArrayList<String> mTitle=new ArrayList<>();
    private MyDingDangPageAdapter myDingDangPageAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_shoucang;
    }

    @Override
    protected void init() {
        mTab= (TabLayout) findViewById(R.id.mTab);
        vpge= (ViewPager) findViewById(R.id.vpage);

    }

    @Override
    protected void loadData() {
        ZhiBoFragment zhiBoFragment=new ZhiBoFragment();
        TiYanFragment tiYanFragment=new TiYanFragment();
        TouTingFragment touTingFragment=new TouTingFragment();
        TieziFragment tieziFragment=new TieziFragment();
        mList.add(zhiBoFragment);
        mList.add(tiYanFragment);
        mList.add(touTingFragment);
        mList.add(tieziFragment);
        mTitle.add("直播课程");
        mTitle.add("体验课程");
        mTitle.add("偷听作业");
        mTitle.add("帖子");
        myDingDangPageAdapter=new MyDingDangPageAdapter(getSupportFragmentManager(),mList,mTitle);
        vpge.setAdapter(myDingDangPageAdapter);
        mTab.setupWithViewPager(vpge);

    }






}
