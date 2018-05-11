package com.example.administrator.xinyuan.view.me;

import android.view.View;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;

public class AboutJieShaoActivity extends BaseActivity implements View.OnClickListener{


    private TextView about_aty_intro_title_cancle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_jie_shao;
    }

    @Override
    protected void init() {
        about_aty_intro_title_cancle= (TextView) findViewById(R.id.about_aty_intro_title_cancle);
        about_aty_intro_title_cancle.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.about_aty_intro_title_cancle:
                finish();
                break;
        }
    }
}
