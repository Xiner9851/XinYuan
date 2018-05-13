package com.example.administrator.xinyuan.view.me;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.QQBangDContact;
import com.example.administrator.xinyuan.model.entity.QQBean;
import com.example.administrator.xinyuan.presenter.QQBangDPresent;
import com.google.gson.Gson;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class SheJiaoActivity extends BaseActivity implements View.OnClickListener,QQBangDContact.View{
    private String qqId;

    private TextView setting_aty_cancle;
    private TextView bindaccount_qq_tv;

    private RelativeLayout bindaccount_qq_group;

    private RelativeLayout bindaccount_sina_group;

    private RelativeLayout bindaccount_weixin_group;
    private QQBangDPresent qqBangDPresent;
    private SharedPreferences xiaoji;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_she_jiao;
    }

    @Override
    protected void init() {
        setting_aty_cancle= (TextView) findViewById(R.id.setting_aty_cancle);
        bindaccount_qq_tv= (TextView) findViewById(R.id.bindaccount_qq_tv);
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
        qqBangDPresent = new QQBangDPresent(this);
        xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bindaccount_qq_group:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.setting_aty_cancle:

                finish();
                break;
            case R.id.bindaccount_sina_group:

                break;
            case R.id.bindaccount_weixin_group:

                break;
        }
    }
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            Gson gson = new Gson();
            QQBean qqBean = gson.fromJson(gson.toJson(data), QQBean.class);
            qqId=qqBean.getUid();
           qqBangDPresent.QQBangD(xiaoji.getInt("id",0)+"",qqId,"qq");

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void showQQ(String s) {
        Log.e("sss",s);
        if(s.equals("string")){
            Toast.makeText(this, "绑定成功", Toast.LENGTH_SHORT).show();
            bindaccount_qq_tv.setText("取消绑定");
        }
    }
}
