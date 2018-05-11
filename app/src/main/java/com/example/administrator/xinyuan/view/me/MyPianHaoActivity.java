package com.example.administrator.xinyuan.view.me;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.ICunPianHaoContact;
import com.example.administrator.xinyuan.contact.PianHaoContact;
import com.example.administrator.xinyuan.model.entity.MyPianHaoBean;
import com.example.administrator.xinyuan.presenter.CunPianHaoPresent;
import com.example.administrator.xinyuan.presenter.PianHaoPresent;
import com.example.administrator.xinyuan.view.me.adapter.PianHaoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyPianHaoActivity extends BaseActivity implements PianHaoContact.View,View.OnClickListener,ICunPianHaoContact.View{
    private TextView complete_userinfo_aty_cancle;
    private RecyclerView mRecy;
    private PianHaoPresent pianHaoPresent;
    private ArrayList<Object> list=new ArrayList<>();
    PianHaoAdapter pianHaoAdapter;
    private TextView name;
    private Button baocun;
    private int pp=0;
    private int ii=3;
    private CunPianHaoPresent cunPianHaoPresent;
    private SharedPreferences xiaoji;
    private int zhuanye;
    private int yuanXiao;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_pian_hao;
    }

    @Override
    protected void init() {
        complete_userinfo_aty_cancle= (TextView) findViewById(R.id.complete_userinfo_aty_cancle);
        complete_userinfo_aty_cancle.setOnClickListener(this);
        mRecy= (RecyclerView) findViewById(R.id.mRecy);
        baocun= (Button) findViewById(R.id.baocun);
        baocun.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecy.setLayoutManager(linearLayoutManager);


    }

    @Override
    protected void loadData() {
        xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        cunPianHaoPresent=new CunPianHaoPresent(this);
        pianHaoPresent=new PianHaoPresent(this);
        pianHaoPresent.loadPianHao();
        pianHaoAdapter=new PianHaoAdapter(this,list);
        mRecy.setAdapter(pianHaoAdapter);
        pianHaoAdapter.setCunZhi(new PianHaoAdapter.setTiao() {



            @Override
            public void bi(View view, int possi) {
                name=view.findViewById(R.id.name);
                    if(name.isClickable()) {
                        name.setClickable(false);
                        MyPianHaoBean.DataBean dataBean = (MyPianHaoBean.DataBean) list.get(0);
                        List<MyPianHaoBean.DataBean.MajorsBean> majors = dataBean.getMajors();
                        zhuanye = majors.get(possi).getId();
                    }else if(!name.isClickable()) {
                        name.setClickable(true);

                    }
                }
        });
        pianHaoAdapter.setCunZhi(new PianHaoAdapter.setTwo() {
            @Override
            public void bi(View view, int possi) {
                name=view.findViewById(R.id.name);
                if(name.isClickable()){
                    MyPianHaoBean.DataBean dataBean = (MyPianHaoBean.DataBean) list.get(0);
                    MyPianHaoBean.DataBean.CollegesBean collegesBean = dataBean.getColleges().get(possi);
                    yuanXiao = collegesBean.getId();
                    name.setClickable(false);
                }else if(!name.isClickable()){

                    name.setClickable(true);
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
            case R.id.baocun:
                cunPianHaoPresent.cunPianHao(xiaoji.getInt("id",0)+"",zhuanye+"",yuanXiao+"");
                break;
        }
    }
    @Override
    public void showPianHao(MyPianHaoBean.DataBean data) {
        list.add(data);
        list.add(data);
        pianHaoAdapter.notifyDataSetChanged();
    }

    @Override
    public void pianHao(String a) {
        if(a.equals("成功")){
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
