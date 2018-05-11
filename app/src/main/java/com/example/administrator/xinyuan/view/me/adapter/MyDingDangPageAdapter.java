package com.example.administrator.xinyuan.view.me.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by fghjkl on 2018/5/10.
 */

public class MyDingDangPageAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> mList;
    private ArrayList<String> mTitle;

    public MyDingDangPageAdapter(FragmentManager fm, ArrayList<Fragment> mList, ArrayList<String> mTitle) {
        super(fm);
        this.mList=mList;
        this.mTitle=mTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
