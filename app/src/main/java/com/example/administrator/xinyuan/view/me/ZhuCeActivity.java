package com.example.administrator.xinyuan.view.me;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IHuoQuYZMaContact;
import com.example.administrator.xinyuan.model.entity.LoginBean;
import com.example.administrator.xinyuan.model.entity.UapateBean;
import com.example.administrator.xinyuan.model.entity.WangChengBean;
import com.example.administrator.xinyuan.presenter.HuoQuMaPresenter;

public class ZhuCeActivity extends BaseActivity implements View.OnClickListener,IHuoQuYZMaContact.View{

    private int i=60;
    private ImageView quxiao;
    private EditText tel;
    private EditText ma;
    private TextView hqma;
    private Button zhuce;
    private RadioButton weixin;
    private RadioButton qq;
    private RadioButton weibo;

    private HuoQuMaPresenter huoQuMaPresenter;
    private Runnable runnable;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                int obj = (int) msg.obj;
                hqma.setText(obj+"");
                if(obj==0){

                    hqma.setText("重新获取验证码");

                }
            }
            handler.postDelayed(runnable,1000);
        }
    };
    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhu_ce;
    }

    @Override
    protected void init() {
        quxiao= (ImageView) findViewById(R.id.quxiao);
        tel= (EditText) findViewById(R.id.tel);
        ma= (EditText) findViewById(R.id.ma);
        hqma= (TextView) findViewById(R.id.hqma);
        hqma.setOnClickListener(this);
        zhuce= (Button) findViewById(R.id.zhuce);
        zhuce.setOnClickListener(this);
        weixin= (RadioButton) findViewById(R.id.weixin);
        qq= (RadioButton) findViewById(R.id.qq);
        weibo= (RadioButton) findViewById(R.id.weibo);
    }

    @Override
    protected void loadData() {
        huoQuMaPresenter = new HuoQuMaPresenter(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hqma:
                huoQuMaPresenter.loadMa(tel.getText().toString());
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        i--;
                        if (i > -1) {
                            Message message = handler.obtainMessage(1, i);
                            handler.sendMessage(message);
                        }
                    }
                };
                handler.post(runnable);
                break;
            case R.id.zhuce:
                huoQuMaPresenter.zhuCe(tel.getText().toString(),ma.getText().toString());

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
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, WanSanXinXiActivity.class);
            intent.putExtra("tel",tel.getText().toString());
            startActivity(intent);
            finish();
        }else if(s.equals("此号码已被注册，请直接登录")){
            Toast.makeText(this, "此号码已注册请登录", Toast.LENGTH_SHORT).show();
        }else if(s.equals("验证码错误")){
            Toast.makeText(this, "验证码不正确", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "手机号不正确", Toast.LENGTH_SHORT).show();
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
        if(s.equals("不值钱")){
            Toast.makeText(this, "手机号不正确", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void findPassNext(UapateBean uapateBean) {

    }
}
