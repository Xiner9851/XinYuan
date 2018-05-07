package com.example.administrator.xinyuan.view.baodian;


import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.contact.baodiancontact.IBaoDianContact;
import com.example.administrator.xinyuan.model.entity.BaoDianFuYongBean;
import com.example.administrator.xinyuan.presenter.baodianpresent.BaoDianPresent;
import com.example.administrator.xinyuan.view.work.adapter.Work_Viewpager_Adapter;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaoDianFragment extends BaseFragment implements IBaoDianContact.View{

    private List<String> list=new ArrayList<>();
    private FlyBanner baodian_fly;
    private TabLayout mtab;
    private ViewPager viewPager;
    ArrayList<Fragment> aaa=new ArrayList<>();
    private Handler han=new Handler();
    private ArrayList<String> mTitle=new ArrayList<>();
    private int a=0;
    private String b="1";
    private String c="2";
    private BaoDianPresent baoDianPresent;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bao_dian;
    }

    @Override
    protected void init() {
        baodian_fly=getView().findViewById(R.id.baodian_fly);
        mtab=getView().findViewById(R.id.mTab);
        viewPager=getView().findViewById(R.id.vpage);

    }

    @Override
    protected void loadDate() {
        baoDianPresent=new BaoDianPresent(this);
        baoDianPresent.loadData(a);
        mTitle.add("智能筛选");
        mTitle.add("赞数最多");
        mTitle.add("最新评论");
        mTitle.add("经验分享");
        mTitle.add("新闻动态");
        mTitle.add("书籍推荐");
        mTitle.add("招生简章");
        mTitle.add("微信族群");
        mTitle.add("艺考答疑");
        for (int i = 0; i < mTitle.size(); i++) {
            Bundle bundle = new Bundle();
            BaoDianFuYongFragment baoDianFuYongFragment = new BaoDianFuYongFragment();
            aaa.add(baoDianFuYongFragment);
            bundle.putInt("a",i);
            baoDianFuYongFragment.setArguments(bundle);
        }
        Work_Viewpager_Adapter work_viewpager_adapter=new Work_Viewpager_Adapter(((BaseActivity) getActivity()).getSupportFragmentManager(),aaa,mTitle);
        viewPager.setAdapter(work_viewpager_adapter);
        mtab.setupWithViewPager(viewPager);
        mtab.setTabMode(TabLayout.MODE_SCROLLABLE);

    }







    @Override
    public void showData(BaoDianFuYongBean baoDianFuYongBean) {
        list.add(baoDianFuYongBean.getData().getSystemAds().get(0).getMobileImgUrl());
        list.add(baoDianFuYongBean.getData().getSystemAds().get(1).getMobileImgUrl());
        baodian_fly.setImagesUrl(list);



    }
}
