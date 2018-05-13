package com.example.administrator.xinyuan.view.teather;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.view.teather.adapter.XianShang_ViewPager;

import java.util.ArrayList;

public class XianShang_Activity extends BaseActivity {


    private ImageView xianshang_back;
    private TextView kecheng_teathername;
    private TabLayout xianshang_tab;
    private ViewPager xianshang_vp;
    private ArrayList<String> titles=new ArrayList<>();
    private ArrayList<Fragment> fragments=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xian_shang_;
    }

    @Override
    protected void init() {
    xianshang_back= (ImageView) findViewById(R.id.xianshang_back);
        xianshang_tab= (TabLayout) findViewById(R.id.xianshang_tab);
        xianshang_vp= (ViewPager) findViewById(R.id.xianshang_vp);

    }

    @Override
    protected void loadData() {
        titles.add("课程");
        titles.add("直播live");

            XianShang_Fragment xianShang_fragment = new XianShang_Fragment();
        XianShang2_Fragment xianShang2_fragment = new XianShang2_Fragment();
        fragments.add(xianShang_fragment);
        fragments.add(xianShang2_fragment);



        XianShang_ViewPager xianShang_viewPager = new XianShang_ViewPager(getSupportFragmentManager(), titles, fragments);
        xianshang_vp.setAdapter(xianShang_viewPager);
        xianshang_tab.setupWithViewPager(xianshang_vp);
        xianshang_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
