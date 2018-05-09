package com.example.administrator.xinyuan.view.yugao;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;

public class YuYue_Activity extends BaseActivity {


    private ImageView zhifu_img;
    private TextView zhifu_time;
    private TextView zhifu_price;
    private ImageView weixin_play_img;
    private ImageView weixin_zhifu;
    private ImageView zhifubao_play_img;
    private ImageView zhifubao_zhifu;
    private Button zhifu_btn;
    private ImageView zhifu_back;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yu_yue_;
    }

    @Override
    protected void init() {
        zhifu_back= (ImageView) findViewById(R.id.zhifu_back);
        zhifu_img= (ImageView) findViewById(R.id.zhifu_img);
        zhifu_time= (TextView) findViewById(R.id.zhifu_time);
        zhifu_price= (TextView) findViewById(R.id.zhifu_price);
        weixin_play_img= (ImageView) findViewById(R.id.weixin_play_img);
        weixin_zhifu= (ImageView) findViewById(R.id.weixin_zhifu);
        zhifubao_play_img= (ImageView) findViewById(R.id.zhifubao_play_img);
        zhifubao_zhifu= (ImageView) findViewById(R.id.zhifubao_zhifu);
        zhifu_btn= (Button) findViewById(R.id.zhifu_btn);


    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();

        int jiage = intent.getIntExtra("jiage", 0);
        zhifu_price.setText("￥"+jiage+"");
        zhifu_btn.setText("确定支付  ￥"+jiage+"");

        zhifu_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}
