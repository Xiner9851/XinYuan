package com.example.administrator.xinyuan.view.me;

import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IHuoQuYZMaContact;
import com.example.administrator.xinyuan.model.entity.LoginBean;
import com.example.administrator.xinyuan.model.entity.UapateBean;
import com.example.administrator.xinyuan.model.entity.WangChengBean;
import com.example.administrator.xinyuan.presenter.HuoQuMaPresenter;

import java.io.File;

public class WanSanXinXiActivity extends BaseActivity implements View.OnClickListener,IHuoQuYZMaContact.View{


    private ImageView quxiao;
    private ImageView touxiang;
    private EditText name;
    private ImageView qingkong;
    private TextView textView;
    private RelativeLayout mReLayout;
    private TextView textView1;
    private RelativeLayout mReLayout2;
    private EditText password;
    private ImageView qingkong1;
    private Button wangcheng;
    private String sex="";
    private HuoQuMaPresenter huoQuMaPresenter;
    private String tel;
    private ImageView paizhao;
    //相机拍摄的头像文件(本次演示存放在SD卡根目录下)
    private static final File USER_ICON = new File(Environment.getExternalStorageDirectory(), "user_icon.jpg");

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wan_san_xin_xi;


    }

    @Override
    protected void init() {
        quxiao= (ImageView) findViewById(R.id.quxiao);
        touxiang= (ImageView) findViewById(R.id.touxiang);
        name= (EditText) findViewById(R.id.name);
        password= (EditText) findViewById(R.id.password);
        qingkong= (ImageView) findViewById(R.id.qingkong);
        qingkong1= (ImageView) findViewById(R.id.qingkong1);
        mReLayout= (RelativeLayout) findViewById(R.id.mReLayout);
        mReLayout2= (RelativeLayout) findViewById(R.id.mReLayout2);
        wangcheng= (Button) findViewById(R.id.wangcheng);
        textView= (TextView) findViewById(R.id.textView);
        textView1= (TextView) findViewById(R.id.textView1);

        touxiang.setOnClickListener(this);
        wangcheng.setOnClickListener(this);
        quxiao.setOnClickListener(this);
        mReLayout.setOnClickListener(this);
        mReLayout2.setOnClickListener(this);

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        tel = intent.getStringExtra("tel");
        huoQuMaPresenter=new HuoQuMaPresenter(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.quxiao:
                finish();
                break;
            case R.id.mReLayout:
                sex="男";
                textView.setTextColor(Color.parseColor("#4b76e4"));
                textView1.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.mReLayout2:
                sex="女";
                textView.setTextColor(Color.parseColor("#000000"));
                textView1.setTextColor(Color.parseColor("#e6218d"));
                break;
            case R.id.wangcheng:
                huoQuMaPresenter.wangCheng(name.getText().toString(),"","",tel,password.getText().toString());

                break;
            case R.id.touxiang:

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
        if(wangChengBean.getMessage().equals("成功")){
            Intent intent = new Intent(this, SetPianHaoActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "不对", Toast.LENGTH_SHORT).show();
        }
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

    }
}
