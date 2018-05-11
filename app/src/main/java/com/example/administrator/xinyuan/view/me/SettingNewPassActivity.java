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
import com.example.administrator.xinyuan.contact.ISettingNewPassContact;
import com.example.administrator.xinyuan.presenter.SettingNewPassPresent;

public class SettingNewPassActivity extends BaseActivity implements View.OnClickListener,ISettingNewPassContact.View{


    private TextView guanbi;
    private EditText pass;
    private EditText password;
    private Button wancheng;
    SettingNewPassPresent settingNewPassPresent;
    private int id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting_new_pass;
    }

    @Override
    protected void init() {
        guanbi= (TextView) findViewById(R.id.guanbi);
        guanbi.setOnClickListener(this);
        pass= (EditText) findViewById(R.id.pass);
        password= (EditText) findViewById(R.id.password);

        wancheng= (Button) findViewById(R.id.wancheng);
        wancheng.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        settingNewPassPresent=new SettingNewPassPresent(this);
        SharedPreferences xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        id = xiaoji.getInt("id", 0);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case  R.id.guanbi:
            finish();
            break;
            case R.id.wancheng:

                settingNewPassPresent.goToUpdata(id+"",pass.getText().toString());
                break;
        }
    }

    @Override
    public void updateOk(String a) {
        if(a.equals("成功")){
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
