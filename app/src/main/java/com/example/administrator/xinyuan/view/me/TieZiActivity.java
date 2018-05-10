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

public class TieZiActivity extends BaseActivity implements ITieZiContact.View,View.OnClickListener{

    private TieZiPresent tieZiPresent;
    private TextView masterfudaolist_aty_cancle;
    private TextView masterfudaolist_aty_title_tv;
    private ListView mLiv;
    private RelativeLayout masterfudaolist_list_empty;
    private int size;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_tie_zi;
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
        tieZiPresent.LoadData(xiaoji.getInt("id",0));
        if(size==0){
            mLiv.setVisibility(View.GONE);
            masterfudaolist_list_empty.setVisibility(View.VISIBLE);
        }else {
            mLiv.setVisibility(View.VISIBLE);
            masterfudaolist_list_empty.setVisibility(View.GONE);
        }
    }


    @Override
    public void showShuJu(TieZiBean tieZiBean) {
        size = tieZiBean.getData().getArtcircleList().getSize();
    }

    @Override
    public void showGuanZhi(GuanZhuBean guanZhuBean) {

    }

    @Override
    public void showFensi(FensiBean fensiBean) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.masterfudaolist_aty_cancle:
                finish();
                break;
        }
    }
}
