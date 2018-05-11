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
import com.example.administrator.xinyuan.contact.IMyShoucangContact;
import com.example.administrator.xinyuan.model.entity.MyShoucangBean;
import com.example.administrator.xinyuan.model.entity.TieZiBean;
import com.example.administrator.xinyuan.presenter.MyShoucangPresent;
import com.example.administrator.xinyuan.view.me.adapter.MyShoucangAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TouTingFragment extends BaseFragment implements IMyShoucangContact.View{


    private RecyclerView mRecy;
    private RelativeLayout indentlist_aty_recyclerview_empty;
    private MyShoucangPresent myShoucangPresent;
    private MyShoucangAdapter myShoucangAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tou_ting;
    }

    @Override
    protected void init() {
        indentlist_aty_recyclerview_empty=getView().findViewById(R.id.indentlist_aty_recyclerview_empty);
        mRecy=getView().findViewById(R.id.mRecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecy.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void loadDate() {
        myShoucangPresent=new MyShoucangPresent(this);
        SharedPreferences xiaoji = getActivity().getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        myShoucangPresent.loadMyShoucang(xiaoji.getInt("id",0),3);

    }


    @Override
    public void showShoucang(MyShoucangBean.DataBean data) {
        if(data.getSize()==0){
            indentlist_aty_recyclerview_empty.setVisibility(View.VISIBLE);
            mRecy.setVisibility(View.GONE);

        }else {
            indentlist_aty_recyclerview_empty.setVisibility(View.GONE);
            mRecy.setVisibility(View.VISIBLE);
            List<MyShoucangBean.DataBean.ListBean> list = data.getList();
            myShoucangAdapter=new MyShoucangAdapter(getContext(),list);
            mRecy.setAdapter(myShoucangAdapter);
        }
    }

    @Override
    public void showShoucang(TieZiBean tieZiBean) {

    }
}
