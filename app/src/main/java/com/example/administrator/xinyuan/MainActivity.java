package com.example.administrator.xinyuan;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.view.baodian.BaoDianFragment;
import com.example.administrator.xinyuan.view.me.MeFragment;
import com.example.administrator.xinyuan.view.teather.MingTeatherFragment;
import com.example.administrator.xinyuan.view.work.WorkFragment;
import com.example.administrator.xinyuan.view.yugao.YuGaoFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener{


    private ImageView ming_teather_title_img;
    private TextView panda_title;
    private ImageView message_img;
    private ImageView message_bi;
    private RelativeLayout tou;
    private FrameLayout fragment_manger;
    private RadioButton ming_teather_btn;
    private RadioButton work_btn;
    private RadioButton baodian_btn;
    private RadioButton yugao_btn;
    private RadioButton me_btn;
    private RadioGroup gp_bt;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        ming_teather_btn= (RadioButton) findViewById(R.id.ming_teather_btn);
        work_btn= (RadioButton) findViewById(R.id.work_btn);
        baodian_btn= (RadioButton) findViewById(R.id.baodian_btn);
        yugao_btn= (RadioButton) findViewById(R.id.yugao_btn);
        me_btn= (RadioButton) findViewById(R.id.me_btn);
        gp_bt= (RadioGroup) findViewById(R.id.gp_bt);
        fragment_manger= (FrameLayout) findViewById(R.id.fragment_manger);
        message_bi= (ImageView) findViewById(R.id.message_bi);
        message_img= (ImageView) findViewById(R.id.message_img);

        ming_teather_btn.setOnClickListener(this);
        work_btn.setOnClickListener(this);
        baodian_btn.setOnClickListener(this);
        yugao_btn.setOnClickListener(this);
        me_btn.setOnClickListener(this);
        message_bi.setOnClickListener(this);
        message_img.setOnClickListener(this);

    }

    @Override
    protected void loadData() {
        setContentView(R.id.fragment_manger, MingTeatherFragment.class, null);
        ming_teather_btn.setChecked(true);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ming_teather_btn:
                setContentView(R.id.fragment_manger, MingTeatherFragment.class, null);
                message_bi.setVisibility(View.GONE);
                break;
            case R.id.work_btn:
                message_bi.setVisibility(View.GONE);
                setContentView(R.id.fragment_manger, WorkFragment.class, null);
                break;
            case R.id.baodian_btn:
                setContentView(R.id.fragment_manger, BaoDianFragment.class, null);
                message_bi.setVisibility(View.VISIBLE);
                break;
            case R.id.yugao_btn:
                message_bi.setVisibility(View.GONE);
                setContentView(R.id.fragment_manger, YuGaoFragment.class, null);
                break;
            case R.id.me_btn:
                message_bi.setVisibility(View.GONE);
                setContentView(R.id.fragment_manger, MeFragment.class, null);
                break;
        }
    }

}
