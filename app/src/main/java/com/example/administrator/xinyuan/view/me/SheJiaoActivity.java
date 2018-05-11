package com.example.administrator.xinyuan.view.me;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;

public class SheJiaoActivity extends BaseActivity implements View.OnClickListener{


    private TextView setting_aty_cancle;

    private RelativeLayout bindaccount_qq_group;

    private RelativeLayout bindaccount_sina_group;

    private RelativeLayout bindaccount_weixin_group;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_she_jiao;
    }

    @Override
    protected void init() {
        setting_aty_cancle= (TextView) findViewById(R.id.setting_aty_cancle);
        setting_aty_cancle.setOnClickListener(this);
        bindaccount_qq_group= (RelativeLayout) findViewById(R.id.bindaccount_qq_group);
        bindaccount_qq_group.setOnClickListener(this);
        bindaccount_sina_group= (RelativeLayout) findViewById(R.id.bindaccount_sina_group);
        bindaccount_sina_group.setOnClickListener(this);
        bindaccount_weixin_group= (RelativeLayout) findViewById(R.id.bindaccount_weixin_group);
        bindaccount_weixin_group.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }


    @Override
    public void onClick(View v) {

    }
}
