package com.example.administrator.xinyuan.view.yugao;


import android.os.Handler;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.contact.yugaocontact.YuGao_Contact;
import com.example.administrator.xinyuan.model.entity.YuDaoBean;
import com.example.administrator.xinyuan.presenter.yugaopresenter.IYuGaoPresenter;
import com.example.administrator.xinyuan.view.yugao.adapter.YuGao_Adapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class YuGaoFragment extends BaseFragment implements YuGao_Contact.View {


    private TextView yugao_shaixuan;
    private PullLoadMoreRecyclerView yugao_recy;
    private Handler han=new Handler();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yu_gao;
    }

    @Override
    protected void init() {
        yugao_shaixuan=getView().findViewById(R.id.yugao_shaixuan);
        yugao_recy=getView().findViewById(R.id.yugao_recy);

    }

    @Override
    protected void loadDate() {
        final IYuGaoPresenter iYuGaoPresenter = new IYuGaoPresenter(this);
        iYuGaoPresenter.loadData();
        yugao_recy.setLinearLayout();
        yugao_recy.setPullRefreshEnable(true);
        yugao_recy.setPushRefreshEnable(true);
        yugao_recy.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                han.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        iYuGaoPresenter.loadData();
                        yugao_recy.setPullLoadMoreCompleted();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {

                yugao_recy.setPullLoadMoreCompleted();
            }
        });
    }

    @Override
    public void showData(YuDaoBean yuDaoBean) {
        List<YuDaoBean.DataBean.ListBean> list = yuDaoBean.getData().getList();
        YuGao_Adapter yuGao_adapter = new YuGao_Adapter(getActivity(),list);
        yugao_recy.setAdapter(yuGao_adapter);
    }


}
