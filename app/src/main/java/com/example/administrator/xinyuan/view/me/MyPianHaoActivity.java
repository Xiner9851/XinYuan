package com.example.administrator.xinyuan.view.me;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.PianHaoContact;
import com.example.administrator.xinyuan.model.entity.MyPianHaoBean;
import com.example.administrator.xinyuan.presenter.PianHaoPresent;
import com.example.administrator.xinyuan.view.me.adapter.PianHaoAdapter;

import java.util.ArrayList;

public class MyPianHaoActivity extends BaseActivity implements PianHaoContact.View,View.OnClickListener{
    private TextView complete_userinfo_aty_cancle;
    private RecyclerView mRecy;
    private PianHaoPresent pianHaoPresent;
    private ArrayList<Object> list=new ArrayList<>();
    PianHaoAdapter pianHaoAdapter;
    private TextView name;
    private int pp=0;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_pian_hao;
    }

    @Override
    protected void init() {
        complete_userinfo_aty_cancle= (TextView) findViewById(R.id.complete_userinfo_aty_cancle);
        complete_userinfo_aty_cancle.setOnClickListener(this);
        mRecy= (RecyclerView) findViewById(R.id.mRecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecy.setLayoutManager(linearLayoutManager);


    }

    @Override
    protected void loadData() {
        pianHaoPresent=new PianHaoPresent(this);
        pianHaoPresent.loadPianHao();
        pianHaoAdapter=new PianHaoAdapter(this,list);
        mRecy.setAdapter(pianHaoAdapter);
        pianHaoAdapter.setCunZhi(new PianHaoAdapter.setTiao() {
            @Override
            public void bi(View view, int possi) {
                name=view.findViewById(R.id.name);
                if(pp==0) {
                    name.setTextColor(Color.parseColor("#ffffff"));
                    name.setBackground(getResources().getDrawable(R.drawable.valuable_listitem_type_bg_two));
                    pp=1;
                }else if(pp==1){
                    name.setTextColor(Color.parseColor("#000000"));
                    name.setBackground(getResources().getDrawable(R.drawable.valuable_listitem_type_bg));
                    pp=0;
                }
            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.complete_userinfo_aty_cancle:
                finish();
                break;
        }
    }
    @Override
    public void showPianHao(MyPianHaoBean.DataBean data) {
        list.add(data);
        list.add(data);
        pianHaoAdapter.notifyDataSetChanged();
    }
}
