package com.example.administrator.xinyuan.view.work;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.view.teather.ZhaoQingTa_FuDaoActivity;
import com.example.administrator.xinyuan.view.work.adapter.Work_Viewpager_Adapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkFragment extends BaseFragment implements View.OnClickListener {


    private RadioButton work_commit;
    private RadioButton work_submit;
    private RadioGroup work_rg;
    private TabLayout work_tab;
    private ViewPager work_vp;
    private Work_FuYong_Fragment fuYong_fragment;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private ImageView imageView;
    private TextView textView;
    private LinearLayout work_tijiao;
    private LinearLayout work_fabu_zuoping;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work;
    }

    @Override
    protected void init() {
        //work_commit=getView().findViewById(R.id.work_commit);
        // work_submit=getView().findViewById(R.id.work_submit);
        work_tab = getView().findViewById(R.id.work_tab);
        work_vp = getView().findViewById(R.id.work_vp);
        work_fabu_zuoping=getView().findViewById(R.id.work_fabu_zuoping);
        work_tijiao=getView().findViewById(R.id.work_tijiao);

        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        fuYong_fragment = new Work_FuYong_Fragment();


    }

    //你好啊
    @Override
    protected void loadDate() {
        titles.add("智能筛选");
        titles.add("偷听更多");
        titles.add("最新点评");


        for (int i = 0; i < titles.size(); i++) {
            Bundle bundle = new Bundle();
            bundle.putInt("012", i);

            fuYong_fragment = new Work_FuYong_Fragment();
            fuYong_fragment.setArguments(bundle);
            fragments.add(fuYong_fragment);
            Log.e("aaaa", i + "");

        }
        Work_Viewpager_Adapter work_viewpager_adapter = new Work_Viewpager_Adapter(((BaseActivity) getActivity()).getSupportFragmentManager(), fragments, titles);
        work_vp.setAdapter(work_viewpager_adapter);
        work_tab.setupWithViewPager(work_vp);
        work_fabu_zuoping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ZhaoQingTa_FuDaoActivity.class);
                startActivity(intent);
            }
        });
        work_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WorkTiJiaoActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.work_fabu_zuoping:
                Toast.makeText(getContext(), "提交", Toast.LENGTH_SHORT).show();
                break;
            case R.id.work_tijiao:
                Toast.makeText(getContext(), "发布作品", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
