package com.example.administrator.xinyuan.view.me;

import android.content.Intent;
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

public class ResetPassActivity extends BaseActivity implements View.OnClickListener,IHuoQuYZMaContact.View{

    private String phone;
    private TextView resetpass_aty_cancle;
    private EditText resetpass_aty_et;
    private EditText resetpass_aty_rp_et;
    private Button resetpass_aty_loginbtn;
    private HuoQuMaPresenter huoQuMaPresenter;
    @Override
    protected int getLayoutId() {
        return R.layout.resetpass_aty;
    }

    @Override
    protected void init() {
        resetpass_aty_et= (EditText) findViewById(R.id.resetpass_aty_et);
        resetpass_aty_rp_et= (EditText) findViewById(R.id.resetpass_aty_rp_et);
        resetpass_aty_loginbtn= (Button) findViewById(R.id.resetpass_aty_loginbtn);
        resetpass_aty_loginbtn.setOnClickListener(this);
    }
    @Override
    protected void loadData() {
        huoQuMaPresenter=new HuoQuMaPresenter(this);
        Intent intent = getIntent();
         phone = intent.getStringExtra("phone");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.resetpass_aty_loginbtn:
                huoQuMaPresenter.findPassNext(phone,resetpass_aty_rp_et.getText().toString());
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

    }

    @Override
    public void findPass(String s) {

    }

    @Override
    public void findPassNext(UapateBean uapateBean) {
        if(uapateBean.getMessage().equals("成功")){
            Toast.makeText(this, "密码重置成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, GoToLoginActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void update(String a) {

    }
}
