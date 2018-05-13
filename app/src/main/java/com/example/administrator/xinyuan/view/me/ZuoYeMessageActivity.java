package com.example.administrator.xinyuan.view.me;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IDingDangMessageContact;
import com.example.administrator.xinyuan.model.entity.DingDanMessageBean;
import com.example.administrator.xinyuan.model.entity.GuanZhuMyBean;
import com.example.administrator.xinyuan.model.entity.GuanfanBean;
import com.example.administrator.xinyuan.model.entity.PingLunMessageBean;
import com.example.administrator.xinyuan.model.entity.ZanBean;
import com.example.administrator.xinyuan.presenter.DingDanMessagePresent;

public class ZuoYeMessageActivity extends BaseActivity implements IDingDangMessageContact.View,View.OnClickListener{
    private DingDanMessagePresent dingDanMessagePresent;
    private TextView masterfudaolist_aty_cancle;
    private TextView masterfudaolist_aty_title_tv;
    private ListView mLiv;
    private RelativeLayout masterfudaolist_list_empty;
    private int size;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_zuo_ye_message;
    }

    @Override
    protected void init() {
        masterfudaolist_aty_cancle= (TextView) findViewById(R.id.masterfudaolist_aty_cancle);
        masterfudaolist_aty_cancle.setOnClickListener(this);
        mLiv= (ListView) findViewById(R.id.mLiv);
        masterfudaolist_list_empty= (RelativeLayout) findViewById(R.id.masterfudaolist_list_empty);

    }

    @Override
    protected void loadData() {
        dingDanMessagePresent=new DingDanMessagePresent(this);
        SharedPreferences xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        dingDanMessagePresent.loadPingLun(xiaoji.getInt("id",0));

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.masterfudaolist_aty_cancle:
                finish();
                break;
        }
    }

    @Override
    public void showShuJu(DingDanMessageBean.DataBean data) {

    }

    @Override
    public void showShuJu(ZanBean.DataBean zanBean) {

    }

    @Override
    public void showPingLun(PingLunMessageBean.DataBean ping) {

    }

    @Override
    public void showZuoYe(PingLunMessageBean.DataBean data) {
        if(data.getSize()==0){
            mLiv.setVisibility(View.GONE);
            masterfudaolist_list_empty.setVisibility(View.VISIBLE);
        }else {
            mLiv.setVisibility(View.VISIBLE);
            masterfudaolist_list_empty.setVisibility(View.GONE);
        }
    }

    @Override
    public void showGuanFan(GuanfanBean.DataBean data) {

    }

    @Override
    public void showGuanZHuMy(GuanZhuMyBean.DataBean data) {

    }


}
