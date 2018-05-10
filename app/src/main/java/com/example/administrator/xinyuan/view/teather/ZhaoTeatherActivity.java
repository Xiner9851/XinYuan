package com.example.administrator.xinyuan.view.teather;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.view.teather.adapter.ZhaoVpAdapter;

import java.util.ArrayList;


public class ZhaoTeatherActivity extends BaseActivity {


    private TabLayout zhaoteather_tab;
    private ViewPager zhaoteather_vp;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private ImageView zhao_back;
    private TextView textView2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhao_teather;
    }

    @Override
    protected void init() {
        zhaoteather_tab = (TabLayout) findViewById(R.id.zhaoteather_tab);
        zhaoteather_vp = (ViewPager) findViewById(R.id.zhaoteather_vp);
        zhao_back = (ImageView) findViewById(R.id.zhao_back);

    }

    @Override
    protected void loadData() {
        titles.add("大师");
        titles.add("名师");
        titles.add("达人");

        for (int i = 0; i < titles.size(); i++) {

            ZhaoTeatherFragment zhaoTeatherFragment = new ZhaoTeatherFragment();
            fragments.add(zhaoTeatherFragment);
            Bundle bundle = new Bundle();
            bundle.putInt("type", (4 - i));
            zhaoTeatherFragment.setArguments(bundle);

        }
        ZhaoVpAdapter zhaoVpAdapter1 = new ZhaoVpAdapter(getSupportFragmentManager(), fragments, titles);
        zhaoteather_vp.setAdapter(zhaoVpAdapter1);
        zhaoteather_tab.setupWithViewPager(zhaoteather_vp);
        zhao_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



}
