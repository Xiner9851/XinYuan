package com.example.administrator.xinyuan.view.work.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/5.
 */

public class Work_Viewpager_Adapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    public Work_Viewpager_Adapter(FragmentManager fm,ArrayList<Fragment> fragments,ArrayList<String> titles) {

        super(fm);
        this.fragments=fragments;
        this.titles=titles;
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
