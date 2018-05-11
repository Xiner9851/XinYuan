package com.example.administrator.xinyuan.view.me.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.contact.IMyDingDangContact;
import com.example.administrator.xinyuan.model.entity.MyDingDangBean;
import com.example.administrator.xinyuan.presenter.MyDingDangPresent;
import com.example.administrator.xinyuan.view.me.adapter.MyDingDangAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuiHuoFragment extends BaseFragment implements IMyDingDangContact.View {


    MyDingDangPresent myDingDangPresent;
    private RelativeLayout indentlist_aty_recyclerview_empty;
    private RecyclerView mRecy;
    private MyDingDangAdapter myDingDangAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tui_huo;
    }

    @Override
    protected void init() {
        indentlist_aty_recyclerview_empty=getView().findViewById(R.id.indentlist_aty_recyclerview_empty);
        mRecy=getView().findViewById(R.id.mRecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecy.setLayoutManager(linearLayoutManager);
        indentlist_aty_recyclerview_empty=getView().findViewById(R.id.indentlist_aty_recyclerview_empty);

    }

    @Override
    protected void loadDate() {
        myDingDangPresent=new MyDingDangPresent(this);
        SharedPreferences xiaoji = getActivity().getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        myDingDangPresent.loadMyDingDang(xiaoji.getInt("id",0),3);


    }

    @Override
    public void showSuJu(MyDingDangBean.DataBean data) {
        if(data.getSize()==0){
            indentlist_aty_recyclerview_empty.setVisibility(View.VISIBLE);
            mRecy.setVisibility(View.GONE);
        }else {
            indentlist_aty_recyclerview_empty.setVisibility(View.VISIBLE);
            mRecy.setVisibility(View.VISIBLE);
            myDingDangAdapter=new MyDingDangAdapter();
        }

    }



}
