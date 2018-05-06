package com.example.administrator.xinyuan.view.work;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.contact.workcontact.Work_Contact;
import com.example.administrator.xinyuan.model.entity.WorkBean;
import com.example.administrator.xinyuan.presenter.workpresenter.IWorkPresenter;
import com.example.administrator.xinyuan.view.work.adapter.Work_Item_Adapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Work_FuYong_Fragment extends BaseFragment implements Work_Contact.View {


    private PullLoadMoreRecyclerView work_pullload;
    private Handler han=new Handler();
    private IWorkPresenter iWorkPresenter;
    private Map<String, Object> params;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work__fu_yong_;
    }

    @Override
    protected void init() {
        work_pullload=getView().findViewById(R.id.work_pullload);
        Bundle arguments = getArguments();
        int anInt = arguments.getInt("012");
        Log.e("xiner",anInt+"");
        params = new HashMap<>();
        params.put("sortord", anInt);
        iWorkPresenter = new IWorkPresenter(this);
        iWorkPresenter.loadData(params);
    }

    @Override
    protected void loadDate() {
        work_pullload.setPullRefreshEnable(true);
        work_pullload.setPushRefreshEnable(true);
        work_pullload.setLinearLayout();
        work_pullload.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                han.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        iWorkPresenter.loadData(params);
                        work_pullload.setPullLoadMoreCompleted();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                han.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       // iWorkPresenter.loadData(params);
                        work_pullload.setPullLoadMoreCompleted();
                    }
                },2000);
            }
        });

    }

    @Override
    public void showData(WorkBean workBean) {
        Log.e("AAAAAAAAaxin", workBean.getMessage());
        List<WorkBean.DataBean.ListBean> list = workBean.getData().getList();
        Work_Item_Adapter work_item_adapter = new Work_Item_Adapter(list,getContext());
        work_pullload.setAdapter(work_item_adapter);

    }


}
