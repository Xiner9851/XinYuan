package com.example.administrator.xinyuan.view.teather;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.teathercontact.zhaoteatherkechengcontact.ZhaoTeather_KeCheng_Contact;
import com.example.administrator.xinyuan.model.entity.ZhaoTeather_KeCheng;
import com.example.administrator.xinyuan.presenter.teatherpresenter.zhaoteatherkechengpresenter.IZhaoTeather_KeCheng_Presenter;
import com.example.administrator.xinyuan.view.teather.adapter.ZhaoTeather_KeCheng_Adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZhaoTeather_KeCheng_Activity extends BaseActivity implements ZhaoTeather_KeCheng_Contact.View {


    private RecyclerView zhaoteather_kecheng_recy;
    private ImageView kecheng_back;
    private TextView kecheng_teathername;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhao_teather__ke_cheng_;
    }

    @Override
    protected void init() {

        zhaoteather_kecheng_recy = (RecyclerView) findViewById(R.id.zhaoteather_kecheng_recy);
        kecheng_back= (ImageView) findViewById(R.id.kecheng_back);
        kecheng_teathername = (TextView) findViewById(R.id.kecheng_teathername);
        zhaoteather_kecheng_recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int id = intent.getIntExtra("id", 0);
        Map<String, Object> params = new HashMap<>();
        params.put("teacherId", id);
        IZhaoTeather_KeCheng_Presenter iZhaoTeather_keCheng_presenter = new IZhaoTeather_KeCheng_Presenter(this);
        iZhaoTeather_keCheng_presenter.loadData(params);
        kecheng_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
       kecheng_teathername.setText(name+"的直播");
    }

    @Override
    public void showData(ZhaoTeather_KeCheng zhaoTeatherKeCheng) {
        List<ZhaoTeather_KeCheng.DataBean.ListBean> list = zhaoTeatherKeCheng.getData().getList();
        ZhaoTeather_KeCheng_Adapter zhaoTeather_keCheng_adapter = new ZhaoTeather_KeCheng_Adapter(this, list);
        zhaoteather_kecheng_recy.setAdapter(zhaoTeather_keCheng_adapter);
        zhaoTeather_keCheng_adapter.setOnCLickItem(new ZhaoTeather_KeCheng_Adapter.OnClick() {
            @Override
            public void setOnClick(View view, int postion) {
                Intent intent = new Intent(ZhaoTeather_KeCheng_Activity.this, TuiJie_ItemActivity.class);
                startActivity(intent);
            }
        });
    }


}
