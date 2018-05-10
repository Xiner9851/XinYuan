package com.example.administrator.xinyuan.view.me;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
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
import com.example.administrator.xinyuan.view.me.adapter.GuanZhuAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuanZhuActivity extends BaseActivity implements View.OnClickListener,ITieZiContact.View{
    private TieZiPresent tieZiPresent;
    private TextView masterfudaolist_aty_cancle;
    private TextView masterfudaolist_aty_title_tv;
    private ListView mLiv;
    private RelativeLayout masterfudaolist_list_empty;
    private int size;
    private List<GuanZhuBean.DataBean.ListBean> list1=new ArrayList<>();
    private GuanZhuAdapter guanZhuAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guan_zhu;
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
        tieZiPresent=new TieZiPresent(this);
        SharedPreferences xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        tieZiPresent.LoadGuanZhu(xiaoji.getInt("id",0));


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
    public void showShuJu(TieZiBean tieZiBean) {

    }

    @Override
    public void showGuanZhi(GuanZhuBean guanZhuBean) {
         size = guanZhuBean.getData().getList().size();
        Log.e("size",size+"");
        List<GuanZhuBean.DataBean.ListBean> list = guanZhuBean.getData().getList();
        list1.addAll(list);
        if(size==0){
            mLiv.setVisibility(View.GONE);
            masterfudaolist_list_empty.setVisibility(View.VISIBLE);
        }else {
            mLiv.setVisibility(View.VISIBLE);
            masterfudaolist_list_empty.setVisibility(View.GONE);
            guanZhuAdapter = new GuanZhuAdapter(this,list1);
            mLiv.setAdapter(guanZhuAdapter);
        }
    }

    @Override
    public void showFensi(FensiBean fensiBean) {

    }
}
