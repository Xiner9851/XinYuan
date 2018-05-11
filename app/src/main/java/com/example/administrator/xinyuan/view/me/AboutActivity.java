package com.example.administrator.xinyuan.view.me;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;

public class AboutActivity extends BaseActivity implements View.OnClickListener{


    private TextView about_aty_title_cancle;
    private RelativeLayout about_aty_aboutintro_group;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;


    }

    @Override
    protected void init() {
        about_aty_title_cancle= (TextView) findViewById(R.id.about_aty_title_cancle);
        about_aty_title_cancle.setOnClickListener(this);
        about_aty_aboutintro_group= (RelativeLayout) findViewById(R.id.about_aty_aboutintro_group);
        about_aty_aboutintro_group.setOnClickListener(this);

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.about_aty_title_cancle:
                finish();
                break;
            case R.id.about_aty_aboutintro_group:
                Intent intent = new Intent(this, AboutJieShaoActivity.class);
                startActivity(intent);
                break;
        }

    }
}
