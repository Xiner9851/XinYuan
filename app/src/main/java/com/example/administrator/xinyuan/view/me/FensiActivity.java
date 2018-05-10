package com.example.administrator.xinyuan.view.me;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.ITieZiContact;
import com.example.administrator.xinyuan.model.entity.FensiBean;
import com.example.administrator.xinyuan.model.entity.GuanZhuBean;
import com.example.administrator.xinyuan.model.entity.TieZiBean;
import com.example.administrator.xinyuan.presenter.TieZiPresent;
import com.example.administrator.xinyuan.view.me.adapter.FensiAdapter;

import java.util.ArrayList;
import java.util.List;

public class FensiActivity extends BaseActivity implements ITieZiContact.View{

    private List<FensiBean.DataBean.ListBean> list1=new ArrayList<>();
    private TextView masterguanzhulist_aty_title_cancle;
    private TextView masterguanzhulist_aty_title_tv;
    private ListView masterguanzhulist_recyclerview;
    private RelativeLayout masterguanzhulist_recyclerview_empty;
    private FensiAdapter fensiAdapter;
    private int size;
    TieZiPresent tieZiPresent;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_fensi;
    }

    @Override
    protected void init() {
        masterguanzhulist_aty_title_cancle= (TextView) findViewById(R.id.masterguanzhulist_aty_title_cancle);
        masterguanzhulist_recyclerview= (ListView) findViewById(R.id.masterguanzhulist_recyclerview);
        masterguanzhulist_recyclerview_empty= (RelativeLayout) findViewById(R.id.masterguanzhulist_recyclerview_empty);

    }

    @Override
    protected void loadData() {
        tieZiPresent=new TieZiPresent(this);
        SharedPreferences xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        tieZiPresent.LoadFensi(xiaoji.getInt("id",0));
    }


    @Override
    public void showShuJu(TieZiBean tieZiBean) {

    }

    @Override
    public void showGuanZhi(GuanZhuBean guanZhuBean) {

    }

    @Override
    public void showFensi(FensiBean fensiBean) {
         size = fensiBean.getData().getSize();
        List<FensiBean.DataBean.ListBean> list = fensiBean.getData().getList();
        list1.addAll(list);
        if(size==0){
            masterguanzhulist_recyclerview.setVisibility(View.GONE);
            masterguanzhulist_recyclerview_empty.setVisibility(View.VISIBLE);
        }else {
            masterguanzhulist_recyclerview.setVisibility(View.VISIBLE);
            masterguanzhulist_recyclerview_empty.setVisibility(View.GONE);
            fensiAdapter=new FensiAdapter(FensiActivity.this,list);
            masterguanzhulist_recyclerview.setAdapter(fensiAdapter);
        }
    }
}
