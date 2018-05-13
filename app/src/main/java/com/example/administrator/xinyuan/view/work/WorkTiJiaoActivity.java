package com.example.administrator.xinyuan.view.work;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;

public class WorkTiJiaoActivity extends BaseActivity {


    private ImageView zhaoteather_work_back;
    private TextView tijiao_work_name;
    private ImageView empty_content;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work_ti_jiao;
    }

    @Override
    protected void init() {
        zhaoteather_work_back= (ImageView) findViewById(R.id.zhaoteather_work_back);
        tijiao_work_name= (TextView) findViewById(R.id.tijiao_work_name);
        empty_content= (ImageView) findViewById(R.id.empty_content);

    }

    @Override
    protected void loadData() {
        zhaoteather_work_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tijiao_work_name.setText("作业题列表");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
