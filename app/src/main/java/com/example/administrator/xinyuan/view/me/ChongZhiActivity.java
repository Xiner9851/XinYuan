package com.example.administrator.xinyuan.view.me;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IMyselfContact;
import com.example.administrator.xinyuan.model.entity.MyselfModelBean;
import com.example.administrator.xinyuan.model.entity.RechargeCenterListModel;
import com.example.administrator.xinyuan.presenter.MyselfPresent;
import com.example.administrator.xinyuan.view.me.adapter.ChongZhiAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChongZhiActivity extends BaseActivity implements View.OnClickListener ,IMyselfContact.View{


    private TextView recharge_center_aty_bottom;
    private TextView recharge_center_aty_cancle;
    private TextView recharge_center_aty_zhangdan;
    private TextView recharge_center_aty_zhanghao_tv;
    private TextView recharge_center_aty_yue_tv;
    private RecyclerView recharge_center_aty_recyclerview;
    private RelativeLayout recharge_center_aty_group;
    private ChongZhiAdapter chongZhiAdapter;
    private MyselfPresent myselfPresent;
    private List<RechargeCenterListModel.DataBean> list=new ArrayList<>();
    private SharedPreferences preferences;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chong_zhi;
    }

    @Override
    protected void init() {
        recharge_center_aty_bottom= (TextView) findViewById(R.id.recharge_center_aty_bottom);
        recharge_center_aty_cancle= (TextView) findViewById(R.id.recharge_center_aty_cancle);
        recharge_center_aty_zhangdan= (TextView) findViewById(R.id.recharge_center_aty_zhangdan);
        recharge_center_aty_zhanghao_tv= (TextView) findViewById(R.id.recharge_center_aty_zhanghao_tv);
        recharge_center_aty_yue_tv= (TextView) findViewById(R.id.recharge_center_aty_yue_tv);
        recharge_center_aty_recyclerview= (RecyclerView) findViewById(R.id.recharge_center_aty_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recharge_center_aty_recyclerview.setLayoutManager(linearLayoutManager);
        recharge_center_aty_group= (RelativeLayout) findViewById(R.id.recharge_center_aty_group);
        recharge_center_aty_group.setOnClickListener(this);
        recharge_center_aty_cancle.setOnClickListener(this);
        recharge_center_aty_zhangdan.setOnClickListener(this);

    }

    @Override
    protected void loadData() {
        preferences =getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        myselfPresent=new MyselfPresent(this);
        myselfPresent.loadMyself();
        chongZhiAdapter=new ChongZhiAdapter(this,list);
        recharge_center_aty_recyclerview.setAdapter(chongZhiAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();



        myselfPresent.loadMyself(preferences.getInt("id",0));
        Log.e("id",preferences.getInt("UserId",0)+"");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.recharge_center_aty_cancle:
                finish();
                break;
            case R.id.recharge_center_aty_zhangdan:

                break;
        }
    }

    @Override
    public void showShuju(MyselfModelBean.DataBean data) {
        String mobile = data.getMobile();
        recharge_center_aty_zhanghao_tv.setText(data.getMobile());
        recharge_center_aty_yue_tv.setText(String.format("%s星豆",data.getBeanAmount()));

    }

    @Override
    public void showShuju(RechargeCenterListModel rechargeCenterListModel) {
        list.addAll(rechargeCenterListModel.getData());
        chongZhiAdapter.notifyDataSetChanged();

    }
}
