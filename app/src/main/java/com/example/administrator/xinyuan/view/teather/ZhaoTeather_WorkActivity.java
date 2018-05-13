package com.example.administrator.xinyuan.view.teather;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;

public class ZhaoTeather_WorkActivity extends BaseActivity {


    private ImageView zhaoteather_work_back;
    private TextView zhaoteather_work_name;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhao_teather__work;
    }

    @Override
    protected void init() {
        zhaoteather_work_back= (ImageView) findViewById(R.id.zhaoteather_work_back);
        zhaoteather_work_name= (TextView) findViewById(R.id.zhaoteather_work_name);


    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        zhaoteather_work_name.setText(name);
        zhaoteather_work_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
