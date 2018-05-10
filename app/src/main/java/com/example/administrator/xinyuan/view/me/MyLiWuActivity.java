package com.example.administrator.xinyuan.view.me;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.view.me.adapter.MyDingDangPageAdapter;
import com.example.administrator.xinyuan.view.me.fragment.ShouDaoLiWuFragment;
import com.example.administrator.xinyuan.view.me.fragment.XianJingFragment;

import java.util.ArrayList;

public class MyLiWuActivity extends BaseActivity {

    private ViewPager vpge;
    private TabLayout mTab;
    private ArrayList<Fragment> mList = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();
    private MyDingDangPageAdapter myDingDangPageAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_shoucang;
    }

    @Override
    protected void init() {
        mTab = (TabLayout) findViewById(R.id.mTab);
        vpge = (ViewPager) findViewById(R.id.vpage);

    }

    @Override
    protected void loadData() {
        ShouDaoLiWuFragment shouDaoLiWuFragment = new ShouDaoLiWuFragment();
        XianJingFragment xianJingFragment = new XianJingFragment();
        mList.add(shouDaoLiWuFragment);
        mList.add(xianJingFragment);

        mTitle.add("收到礼物");
        mTitle.add("现金收入");

        myDingDangPageAdapter = new MyDingDangPageAdapter(getSupportFragmentManager(), mList, mTitle);
        vpge.setAdapter(myDingDangPageAdapter);
        mTab.setupWithViewPager(vpge);

    }


}
