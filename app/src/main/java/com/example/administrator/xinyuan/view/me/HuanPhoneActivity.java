package com.example.administrator.xinyuan.view.me;

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

public class HuanPhoneActivity extends BaseActivity implements View.OnClickListener,IHuoQuYZMaContact.View{


    private TextView guanbi;
    private TextView textView2;
    private TextView mobile;
    private TextView yzm;
    private Button dian;
    private EditText ma;
    HuoQuMaPresenter huoQuMaPresenter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_huan_phone;
    }

    @Override
    protected void init() {
        guanbi= (TextView) findViewById(R.id.guanbi);
        textView2= (TextView) findViewById(R.id.textView2);
        mobile= (TextView) findViewById(R.id.mobile);
        yzm= (TextView) findViewById(R.id.yzm);
        dian= (Button) findViewById(R.id.dian);
        ma= (EditText) findViewById(R.id.ma);
    }

    @Override
    protected void loadData() {
        huoQuMaPresenter=new HuoQuMaPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.yzm:
                huoQuMaPresenter.loadMa(mobile.getText().toString());
                break;
            case R.id.dian:
                huoQuMaPresenter.zhuCe(mobile.getText().toString(),ma.getText().toString());
                break;
        }
    }

    @Override
    public void loadMa(String a) {
        if(a.equals("验证码已发送")){
            Toast.makeText(this, "验证码发送成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "验证码发送失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void zhuCe(String s) {
        if(s.equals("成功")){


        }
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
}
