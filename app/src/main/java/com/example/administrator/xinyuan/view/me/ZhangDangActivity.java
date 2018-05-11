package com.example.administrator.xinyuan.view.me;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;

public class ZhangDangActivity extends BaseActivity implements View.OnClickListener{
    private static final int CHONGZHI = 0;

    private static final int XIAOFEI = 1;
    private int type;

    private int sortord;

    private TextView bill_center_aty_cancle;
    private TextView bill_center_aty_chongzhi_tv;
    private TextView bill_center_aty_chongzhi_line;
    private RelativeLayout bill_center_aty_chongzhi_group;
    private TextView bill_center_aty_xiaofei_tv;
    private TextView bill_center_aty_xiaofei_line;
    private RelativeLayout bill_center_aty_xiaofei_group;
    private RecyclerView bill_center_aty_recyclerview;
    private RelativeLayout bill_center_aty_recyclerview_empty;
    private Button bill_center_aty_recyclerview_fault_btn;
    private RelativeLayout bill_center_aty_recyclerview_fault;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhang_dang2;
    }

    @Override
    protected void init() {
        bill_center_aty_cancle= (TextView) findViewById(R.id.bill_center_aty_cancle);
        bill_center_aty_cancle.setOnClickListener(this);
        bill_center_aty_chongzhi_group= (RelativeLayout) findViewById(R.id.bill_center_aty_chongzhi_group);
        bill_center_aty_chongzhi_group.setOnClickListener(this);
        bill_center_aty_xiaofei_group= (RelativeLayout) findViewById(R.id.bill_center_aty_xiaofei_group);
        bill_center_aty_xiaofei_group.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bill_center_aty_chongzhi_group:
                if(sortord==CHONGZHI){
                    return;
                }

                break;
            case R.id.bill_center_aty_cancle:

                finish();
                break;
        }

    }
}
