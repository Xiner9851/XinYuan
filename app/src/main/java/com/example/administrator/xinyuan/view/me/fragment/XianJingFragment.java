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
import com.example.administrator.xinyuan.contact.IMyLiWuContact;
import com.example.administrator.xinyuan.model.entity.MyLiWuBean;
import com.example.administrator.xinyuan.presenter.MyLiWuPresent;

/**
 * A simple {@link Fragment} subclass.
 */
public class XianJingFragment extends BaseFragment implements IMyLiWuContact.View {


    private RecyclerView mRecy;
    private RelativeLayout indentlist_aty_recyclerview_empty;
    private MyLiWuPresent myLiWuPresent;

    @Override
    public void showMyLiWu(MyLiWuBean.DataBean data) {
        if(data.getSize()==0){
            mRecy.setVisibility(View.GONE);
            indentlist_aty_recyclerview_empty.setVisibility(View.VISIBLE);
        }else {
            mRecy.setVisibility(View.VISIBLE);
            indentlist_aty_recyclerview_empty.setVisibility(View.GONE);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xian_jin;
    }

    @Override
    protected void init() {
        mRecy=getView().findViewById(R.id.mRecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecy.setLayoutManager(linearLayoutManager);
        indentlist_aty_recyclerview_empty=getView().findViewById(R.id.indentlist_aty_recyclerview_empty);
    }

    @Override
    protected void loadDate() {
        SharedPreferences xiaoji = getActivity().getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        myLiWuPresent=new MyLiWuPresent(this);
        myLiWuPresent.loadMyLiWu(xiaoji.getInt("id",0),2);

    }


}
