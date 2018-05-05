package com.example.administrator.xinyuan.view.me;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IHuoQuYZMaContact;
import com.example.administrator.xinyuan.presenter.HuoQuMaPresenter;

public class GoToLoginActivity extends BaseActivity implements View.OnClickListener,IHuoQuYZMaContact.View{


    private TextView guanbi;
    private TextView zhuce;
    private EditText tel;
    private EditText password;
    private TextView wangpsw;
    private Button denglu;
    private ImageView weixin;
    private ImageView qq;
    private ImageView xinlang;
    private HuoQuMaPresenter huoQuMaPresenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_go_to_login;
    }

    @Override
    protected void init() {
        guanbi= (TextView) findViewById(R.id.guanbi);
        zhuce= (TextView) findViewById(R.id.zhuce);
        wangpsw= (TextView) findViewById(R.id.wangpsw);
        tel= (EditText) findViewById(R.id.tel);
        password= (EditText) findViewById(R.id.password);
        denglu= (Button) findViewById(R.id.denglu);
        weixin= (ImageView) findViewById(R.id.weixin);
        qq= (ImageView) findViewById(R.id.qq);
        xinlang= (ImageView) findViewById(R.id.xinlang);

        wangpsw.setOnClickListener(this);
        guanbi.setOnClickListener(this);
        zhuce.setOnClickListener(this);
        denglu.setOnClickListener(this);

    }

    @Override
    protected void loadData() {
        huoQuMaPresenter=new HuoQuMaPresenter(this);
    }

//监听
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guanbi:
                finish();
                break;
            case R.id.zhuce:
                Intent intent = new Intent(this, ZhuCeActivity.class);
                startActivity(intent);
                break;
            case R.id.denglu:
                huoQuMaPresenter.login(tel.getText().toString(),password.getText().toString());
                Intent intent2 = new Intent(this, MySelfActivity.class);
                startActivity(intent2);
                break;
            case R.id.wangpsw:
                Intent intent1 = new Intent(this, RetrievePassActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void show() {

    }
}
