package com.example.administrator.xinyuan.view.teather.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/10.
 */

public class XianShang_ViewPager extends FragmentPagerAdapter {
    //en1
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    public XianShang_ViewPager(FragmentManager fm,ArrayList<String> titles,ArrayList<Fragment> fragments) {
        super(fm);
        this.titles=titles;
        this.fragments=fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
