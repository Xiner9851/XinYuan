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

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IHuoQuYZMaContact;
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
                runnable=new Runnable() {
                    @Override
                    public void run() {
                        i--;
                        if(i>-1) {
                            Message message = handler.obtainMessage(1, i);
                            handler.sendMessage(message);
                        }
                    }
                };
                handler.post(runnable);
                break;
            case R.id.zhuce:
                huoQuMaPresenter.zhuCe(tel.getText().toString(),ma.getText().toString());
                Intent intent = new Intent(this, WanSanXinXiActivity.class);
                intent.putExtra("tel",tel.getText().toString());
                startActivity(intent);
                break;
        }
    }

    @Override
    public void show() {

    }
}
