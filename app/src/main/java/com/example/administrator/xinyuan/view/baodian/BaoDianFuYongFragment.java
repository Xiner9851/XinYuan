package com.example.administrator.xinyuan.view.baodian;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.contact.baodiancontact.IBaoDianContact;
import com.example.administrator.xinyuan.model.entity.BaoDianFuYongBean;
import com.example.administrator.xinyuan.presenter.baodianpresent.BaoDianPresent;
import com.example.administrator.xinyuan.view.baodian.adapter.BaoDianFuYongAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaoDianFuYongFragment extends BaseFragment implements IBaoDianContact.View{
    private RecyclerView mRecy;
    BaoDianPresent baoDianPresent;
    BaoDianFuYongAdapter baoDianFuYongAdapter;
    List<BaoDianFuYongBean.DataBean.ArtcircleListBean.ListBean> list1;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bao_dian_fu_yong;
    }

    @Override
    protected void init() {
        mRecy=getView().findViewById(R.id.mRecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecy.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void loadDate() {
        Bundle arguments = getArguments();
        int i = arguments.getInt("a");
        if (i <= 2) {
            baoDianPresent = new BaoDianPresent(this);
            baoDianPresent.loadData(i);
        }


    }

    @Override
    public void showData(BaoDianFuYongBean baoDianFuYongBean) {
//        final List<BaoDianFuYongBean.DataBean.ArtcircleListBean.ListBean> list = baoDianFuYongBean.getData().getArtcircleList().getList();
//        if(list.size()!=0) {
//            baoDianFuYongAdapter = new BaoDianFuYongAdapter(list, getContext());
//            mRecy.setAdapter(baoDianFuYongAdapter);
//            baoDianFuYongAdapter.setBaoDianOnClickListionItem(new BaoDianFuYongAdapter.BaoDianOnClickListion() {
//                @Override
//                public void setBaoDianOnClickListion(View view, int postion) {
//                    Intent intent = new Intent(getContext(), BaoDian_ItemActivity.class);
//                    intent.putExtra("id", list.get(postion).getId());
//                    startActivity(intent);
//
//                }
//            });
//            baoDianFuYongAdapter.notifyDataSetChanged();
//
//
//        }
    }
}
