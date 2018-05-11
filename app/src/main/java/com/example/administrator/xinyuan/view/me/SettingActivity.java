package com.example.administrator.xinyuan.view.me;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;

public class SettingActivity extends BaseActivity implements View.OnClickListener{


    private TextView setting_aty_cancle;
    private TextView setting_aty_phone_tv;
    private RelativeLayout setting_aty_changephone_group;
    private RelativeLayout setting_aty_bind_group;
    private RelativeLayout setting_aty_pass_group;
    private TextView setting_glide_cahce_tv;
    private RelativeLayout setting_aty_about_group;
    private RelativeLayout setting_aty_tuichu_group;
    private RelativeLayout quchu;
    private String mobile;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {


        setting_aty_cancle= (TextView) findViewById(R.id.setting_aty_cancle);
        setting_aty_phone_tv= (TextView) findViewById(R.id.setting_aty_phone_tv);
        setting_glide_cahce_tv= (TextView) findViewById(R.id.setting_glide_cahce_tv);
        setting_aty_changephone_group= (RelativeLayout) findViewById(R.id.setting_aty_changephone_group);
        setting_aty_bind_group= (RelativeLayout) findViewById(R.id.setting_aty_bind_group);
        setting_aty_pass_group= (RelativeLayout) findViewById(R.id.setting_aty_pass_group);
        quchu= (RelativeLayout) findViewById(R.id.quchu_huancun);
        quchu.setOnClickListener(this);
        setting_aty_about_group= (RelativeLayout) findViewById(R.id.setting_aty_about_group);
        setting_aty_tuichu_group= (RelativeLayout) findViewById(R.id.setting_aty_tuichu_group);
        setting_glide_cahce_tv= (TextView) findViewById(R.id.setting_glide_cahce_tv);

        setting_aty_changephone_group.setOnClickListener(this);
        setting_aty_bind_group.setOnClickListener(this);
        setting_aty_pass_group.setOnClickListener(this);
        setting_aty_about_group.setOnClickListener(this);
        setting_aty_tuichu_group.setOnClickListener(this);
        setting_aty_cancle.setOnClickListener(this);

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");
        setting_aty_phone_tv.setText(mobile);
        try {
            String totalCacheSize = HuanCunChuLi.getTotalCacheSize(this);
            setting_glide_cahce_tv.setText(totalCacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_aty_changephone_group:
                Intent intent = new Intent(this, HuanPhoneActivity.class);
                intent.putExtra("mobile",mobile);
                startActivityForResult(intent,10);
                break;
            case R.id.setting_aty_tuichu_group:
                SharedPreferences xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = xiaoji.edit();
                edit.putBoolean("bbb",false);
                edit.commit();
                finish();
                break;
            case  R.id.setting_aty_cancle:
                finish();
                break;
            case R.id.setting_aty_bind_group:
                Intent intent1 = new Intent(this, SheJiaoActivity.class);
                startActivity(intent1);
                break;
            case R.id.setting_aty_pass_group:
                Intent intent2 = new Intent(this, SettingPassActivity.class);
                startActivity(intent2);
                break;
            case R.id.quchu_huancun:
                HuanCunChuLi.clearAllCache(this);
                setting_glide_cahce_tv.setText("清理完成");
                break;
            case R.id.setting_aty_about_group:
                Intent intent3 = new Intent(this, AboutActivity.class);
                startActivity(intent3);
                break;

        }

    }
}
