package com.example.administrator.xinyuan.view.me;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;

public class DaiActivity extends BaseActivity implements View.OnClickListener{


    private TextView indentlist_aty_title_cancle;
    private TextView indentlist_aty_level1_tv;
    private TextView indentlist_aty_level1_line;
    private RelativeLayout indentlist_aty_level1;
    private TextView indentlist_aty_level2_tv;
    private TextView indentlist_aty_level2_line;
    private RelativeLayout indentlist_aty_level2;
    private TextView indentlist_aty_level3_tv;
    private TextView indentlist_aty_level3_line;
    private RelativeLayout indentlist_aty_level3;
    private TextView indentlist_aty_level4_tv;
    private TextView indentlist_aty_level4_line;
    private RelativeLayout indentlist_aty_level4;
    private RecyclerView indentlist_aty_recycler;
    private RelativeLayout indentlist_aty_recyclerview_empty;

    @Override
    protected int getLayoutId() {





        return R.layout.activity_dai;
    }

    @Override
    protected void init() {
        indentlist_aty_level1= (RelativeLayout) findViewById(R.id.indentlist_aty_level1);
        indentlist_aty_level1.setOnClickListener(this);
        indentlist_aty_level2= (RelativeLayout) findViewById(R.id.indentlist_aty_level1);
        indentlist_aty_level2.setOnClickListener(this);
        indentlist_aty_level3= (RelativeLayout) findViewById(R.id.indentlist_aty_level1);
        indentlist_aty_level3.setOnClickListener(this);
        indentlist_aty_level4= (RelativeLayout) findViewById(R.id.indentlist_aty_level1);
        indentlist_aty_level4.setOnClickListener(this);
        indentlist_aty_recycler= (RecyclerView) findViewById(R.id.indentlist_aty_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        indentlist_aty_recycler.setLayoutManager(linearLayoutManager);


    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }

    @Override
    public void onClick(View v) {

    }
}
