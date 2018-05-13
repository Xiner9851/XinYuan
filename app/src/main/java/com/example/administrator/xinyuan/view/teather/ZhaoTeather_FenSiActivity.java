package com.example.administrator.xinyuan.view.teather;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.teathercontact.zhaoteatherfensicontact.ZhaoTeather_FenSi_Contact;
import com.example.administrator.xinyuan.model.entity.ZhaoTeather_FenSi_Bean;
import com.example.administrator.xinyuan.presenter.teatherpresenter.zhaoteatherfensipresenter.IZhaoTeatherFenSiPresenter;
import com.example.administrator.xinyuan.view.teather.adapter.ZhaoTeather_FenSi_Adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZhaoTeather_FenSiActivity extends BaseActivity implements ZhaoTeather_FenSi_Contact.View{


    private ImageView fensi_back;
    private TextView fensi_teathername;
    private RecyclerView zhaoteather_fensi_listview;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhao_teather__fen_si;
    }

    @Override
    protected void init() {
        zhaoteather_fensi_listview= (RecyclerView) findViewById(R.id.zhaoteather_fensi_listview);
        fensi_teathername= (TextView) findViewById(R.id.fensi_teathername);
        fensi_back= (ImageView) findViewById(R.id.fensi_back);
        fensi_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        zhaoteather_fensi_listview.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("idd", 0);
        String name = intent.getStringExtra("namee");
        Map<String, Object> params = new HashMap<>();
        params.put("teacherId", id);
        IZhaoTeatherFenSiPresenter iZhaoTeatherFenSiPresenter = new IZhaoTeatherFenSiPresenter(this);
        iZhaoTeatherFenSiPresenter.loadData(params);
        fensi_teathername.setText(name+"的粉丝");

    }


    @Override
    public void showData(ZhaoTeather_FenSi_Bean zhaoTeather_fenSi_bean) {
        List<ZhaoTeather_FenSi_Bean.DataBean.ListBean> list = zhaoTeather_fenSi_bean.getData().getList();
        ZhaoTeather_FenSi_Adapter zhaoTeather_fenSi_adapter=new ZhaoTeather_FenSi_Adapter(this,list);
        zhaoteather_fensi_listview.setAdapter(zhaoTeather_fenSi_adapter);

    }


}
