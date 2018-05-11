package com.example.administrator.xinyuan.view.me;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
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

public class RetrievePassActivity extends BaseActivity implements IHuoQuYZMaContact.View,View.OnClickListener{

    private int i=60;
    private TextView retrievepass_cancle;
    private EditText retrievepass_aty_phone_et;
    private ImageView retrievepass_aty_phone_et_clear;
    private EditText retrievepass_aty_getcode_et;
    private TextView retrievepass_aty_getcode_reset;
    private ImageView retrievepass_aty_getcode_reset_clear;
    private Button retrievepass_aty_loginbtn;
    private HuoQuMaPresenter huoQuMaPresenter;
    private Runnable runnable;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                int obj = (int) msg.obj;
                retrievepass_aty_getcode_reset.setText(obj+"");
                if(obj==0){

                    retrievepass_aty_getcode_reset.setText("重新获取验证码");

                }
            }
            handler.postDelayed(runnable,1000);
        }
    };
    @Override
    protected int getLayoutId() {
        return R.layout.activity_retrieve_pass;
    }

    @Override
    protected void init() {
        retrievepass_cancle= (TextView) findViewById(R.id.retrievepass_cancle);
        retrievepass_aty_getcode_reset= (TextView) findViewById(R.id.retrievepass_aty_getcode_reset);
        retrievepass_aty_phone_et= (EditText) findViewById(R.id.retrievepass_aty_phone_et);
        retrievepass_aty_getcode_et= (EditText) findViewById(R.id.retrievepass_aty_getcode_et);
        retrievepass_aty_phone_et_clear= (ImageView) findViewById(R.id.retrievepass_aty_phone_et_clear);
        retrievepass_aty_getcode_reset_clear= (ImageView) findViewById(R.id.retrievepass_aty_getcode_reset_clear);
        retrievepass_aty_loginbtn= (Button) findViewById(R.id.retrievepass_aty_loginbtn);

        retrievepass_aty_loginbtn.setOnClickListener(this);
        retrievepass_aty_getcode_reset.setOnClickListener(this);

    }

    @Override
    protected void loadData() {
        huoQuMaPresenter=new HuoQuMaPresenter(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.retrievepass_aty_loginbtn:
                huoQuMaPresenter.findPass(retrievepass_aty_phone_et.getText().toString(),retrievepass_aty_getcode_et.getText().toString());

                break;
            case R.id.retrievepass_aty_getcode_reset:
                huoQuMaPresenter.loadMa(retrievepass_aty_phone_et.getText().toString());
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

        }
    }


    @Override
    public void loadMa(String a) {
        if(a.equals("验证码已发送")){
            Toast.makeText(this, "验证码已发送", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "验证码发送失败", Toast.LENGTH_SHORT).show();
        }
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
        if(s.equals("成功")){
            Intent intent = new Intent(this, ResetPassActivity.class);
            intent.putExtra("phone",retrievepass_aty_phone_et.getText().toString());
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "重新输入", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void findPassNext(UapateBean uapateBean) {

    }

    @Override
    public void update(String a) {

    }
}
