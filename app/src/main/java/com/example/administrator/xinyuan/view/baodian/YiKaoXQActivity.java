package com.example.administrator.xinyuan.view.baodian;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.baodiancontact.IWenZhangDetailContact;
import com.example.administrator.xinyuan.presenter.baodianpresent.WenZhangDetailPresent;

public class YiKaoXQActivity extends BaseActivity implements View.OnClickListener,IWenZhangDetailContact.View{
    private ImageView guanbi;
    private ImageView fenxian;
    private ListView mLiv;
    WenZhangDetailPresent wenZhangDetailPresent;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_yi_kao_xq;
    }

    @Override
    protected void init() {
        guanbi= (ImageView) findViewById(R.id.guanbi);
        fenxian= (ImageView) findViewById(R.id.fenxian);
        mLiv= (ListView) findViewById(R.id.mLiv);
    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        wenZhangDetailPresent=new WenZhangDetailPresent(this);
        wenZhangDetailPresent.loadDeatil(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guanbi:
                finish();
                break;
            case R.id.fenxian:

                break;
        }
    }

    @Override
    public void showShuJu() {

    }
}
