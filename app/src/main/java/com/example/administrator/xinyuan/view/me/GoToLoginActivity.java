package com.example.administrator.xinyuan.view.me;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IHuoQuYZMaContact;
import com.example.administrator.xinyuan.model.entity.LoginBean;
import com.example.administrator.xinyuan.model.entity.UapateBean;
import com.example.administrator.xinyuan.model.entity.WangChengBean;
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
                break;
            case R.id.wangpsw:
                Intent intent1 = new Intent(this, RetrievePassActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
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
        if (loginBean.getMessage().equals("cid为空")){



            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            Log.e("logid",loginBean.getData().getId()+"");
            SharedPreferences sharedPreferences1 = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);


            SharedPreferences.Editor edit = sharedPreferences1.edit();

            edit.putBoolean("bbb",true);

            edit.putString("name",loginBean.getData().getNickname());
            edit.putString("mobile",loginBean.getData().getMobile());
            String photo= (String) loginBean.getData().getPhoto();
            edit.putString("phone",photo);
            edit.putInt("id",loginBean.getData().getId());
            Log.e("DDDDDDDDD",photo);
            edit.commit();
            //      intent.putExtra("phone",photo);
            finish();
        }else {
            Toast.makeText(this, "登录失败，请重新输入", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void findPass(String s) {

    }

    @Override
    public void findPassNext(UapateBean uapateBean) {

    }
}
