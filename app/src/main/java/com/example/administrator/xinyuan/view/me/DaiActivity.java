package com.example.administrator.xinyuan.view.me;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.view.me.adapter.MyDingDangPageAdapter;
import com.example.administrator.xinyuan.view.me.fragment.DaiFuKuanFragment;
import com.example.administrator.xinyuan.view.me.fragment.DaiShiYongFragment;
import com.example.administrator.xinyuan.view.me.fragment.QuanBuFragment;
import com.example.administrator.xinyuan.view.me.fragment.TuiHuoFragment;

import java.util.ArrayList;

public class DaiActivity extends BaseActivity {


    private TextView indentlist_aty_title_cancle;
    private TabLayout mTab;
    private ViewPager vpage;
    private ArrayList<String> mTitle=new ArrayList<>();
    private ArrayList<Fragment> mList=new ArrayList<>();


    @Override
    protected int getLayoutId() {

        return R.layout.activity_dai;


    }

    @Override
    protected void init() {
        indentlist_aty_title_cancle= (TextView) findViewById(R.id.indentlist_aty_title_cancle);
        mTab= (TabLayout) findViewById(R.id.mTab);
        vpage= (ViewPager) findViewById(R.id.vpage);


    }

    @Override
    protected void loadData() {
        mTitle.add("全部");
        mTitle.add("代付款");
        mTitle.add("带使用");
        mTitle.add("退货");
        QuanBuFragment quanBuFragment=new QuanBuFragment();
        DaiFuKuanFragment daiFuKuanFragment=new DaiFuKuanFragment();
        DaiShiYongFragment daiShiYongFragment=new DaiShiYongFragment();
        TuiHuoFragment tuiHuoFragment=new TuiHuoFragment();
        mList.add(quanBuFragment);
        mList.add(daiFuKuanFragment);
        mList.add(daiShiYongFragment);
        mList.add(tuiHuoFragment);
        MyDingDangPageAdapter myDingDangAdapter = new MyDingDangPageAdapter(getSupportFragmentManager(), mList, mTitle);
        vpage.setAdapter(myDingDangAdapter);
        mTab.setupWithViewPager(vpage);

    }



}
