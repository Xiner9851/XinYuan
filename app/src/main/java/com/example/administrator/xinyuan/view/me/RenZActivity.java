package com.example.administrator.xinyuan.view.me;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;

public class RenZActivity extends BaseActivity {


    private TextView approve_user_aty_back;
    private EditText approve_user_aty_name;
    private EditText approve_user_aty_majors;
    private EditText approve_user_aty_input;
    private ImageView approve_user_aty_show_idcard;
    private LinearLayout approve_user_aty_post_idcard;
    private LinearLayout approve_user_aty_genghuan_btn;
    private ProgressBar approve_user_aty_progressBar;
    private LinearLayout approve_user_aty_genghuan_group;
    private Button approve_user_aty_post_btn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ren_z;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }


}
