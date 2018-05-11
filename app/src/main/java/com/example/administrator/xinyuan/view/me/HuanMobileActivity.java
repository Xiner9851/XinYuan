package com.example.administrator.xinyuan.view.me;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IHuoQuYZMaContact;
import com.example.administrator.xinyuan.model.entity.LoginBean;
import com.example.administrator.xinyuan.model.entity.UapateBean;
import com.example.administrator.xinyuan.model.entity.WangChengBean;
import com.example.administrator.xinyuan.presenter.HuoQuMaPresenter;

public class HuanMobileActivity extends BaseActivity implements IHuoQuYZMaContact.View,View.OnClickListener{


    private TextView guanbi;
    private TextView textView2;
    private TextView mobile;
    private EditText ma;
    private TextView yzm;
    private Button dian;
    private HuoQuMaPresenter huoQuMaPresenter;
    private SharedPreferences xiaoji;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_huan_mobile;
    }

    @Override
    protected void init() {
        guanbi= (TextView) findViewById(R.id.guanbi);
        yzm= (TextView) findViewById(R.id.yzm);
        ma= (EditText) findViewById(R.id.ma);
        mobile= (TextView) findViewById(R.id.mobile);
        dian= (Button) findViewById(R.id.dian);
        guanbi.setOnClickListener(this);
        yzm.setOnClickListener(this);
        dian.setOnClickListener(this);


    }

    @Override
    protected void loadData() {
        huoQuMaPresenter=new HuoQuMaPresenter(this);
        xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);

    }


    @Override
    public void loadMa(String a) {

    }

    @Override
    public void zhuCe(String s) {

    }

    @Override
    public void wangCheng(WangChengBean wangChengBean) {

    }

    @Override
    public void login(LoginBean loginBean) {

    }

    @Override
    public void findPass(String s) {

    }

    @Override
    public void findPassNext(UapateBean uapateBean) {

    }

    @Override
    public void update(String a) {
        if(a.equals("成功")){
            Toast.makeText(this, "手机号更换成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guanbi:
                finish();
                break;
            case R.id.yzm:
                huoQuMaPresenter.loadMa(mobile.getText().toString());
                break;
            case R.id.dian:
                huoQuMaPresenter.updateMobile(xiaoji.getInt("id",0)+"",mobile.getText().toString(),ma.getText().toString());
                break;
        }
    }
}
