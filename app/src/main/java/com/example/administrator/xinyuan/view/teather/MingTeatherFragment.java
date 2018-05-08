package com.example.administrator.xinyuan.view.teather;


import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.contact.teathercontact.Teather_Contact;
import com.example.administrator.xinyuan.model.entity.TeatherBean;
import com.example.administrator.xinyuan.presenter.teatherpresenter.ITeather_Presenter;
import com.example.administrator.xinyuan.view.teather.adapter.Teather_Adapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.xinyuan.R.id;

/**
 * A simple {@link Fragment} subclass.
 */
public class MingTeatherFragment extends BaseFragment implements Teather_Contact.View {
    private ArrayList<Object> teather_list;
    private Handler han=new Handler();
    private PullLoadMoreRecyclerView teather_recy;
    private ITeather_Presenter iTeather_presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ming_teather;
    }

    @Override
    protected void init() {
        teather_recy=getView().findViewById(id.teather_recy);
    }

    @Override
    protected void loadDate() {


        iTeather_presenter = new ITeather_Presenter(this);
        iTeather_presenter.loadData();
        teather_recy.setLinearLayout();
        teather_recy.setPullRefreshEnable(true);
        teather_recy.setPushRefreshEnable(true);
        teather_recy.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                han.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        iTeather_presenter.loadData();
                        teather_recy.setPullLoadMoreCompleted();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                teather_recy.setPullLoadMoreCompleted();
            }
        });




    }


    @Override
    public void showData(final TeatherBean teatherBean) {

       teather_list=new ArrayList<>();
        List<TeatherBean.DataBean.SystemAdsBean> systemAds = teatherBean.getData().getSystemAds();
        List<TeatherBean.DataBean.UsersBean> users = teatherBean.getData().getUsers();
        List<TeatherBean.DataBean.LiveCoursesBean> liveCourses = teatherBean.getData().getLiveCourses();
        List<TeatherBean.DataBean.HomewoksBean> homewoks = teatherBean.getData().getHomewoks();



        teather_list.add(systemAds);
        teather_list.add(users);
        teather_list.add(liveCourses);
        teather_list.add(homewoks);
        teather_list.add("");
        Teather_Adapter teather_adapter = new Teather_Adapter(teather_list,getActivity());
        teather_recy.setAdapter(teather_adapter);
        //one监听
        teather_adapter.setOneClick(new Teather_Adapter.OneClick() {
            @Override
            public void setOneClick(int postion) {
                int id = teatherBean.getData().getUsers().get(postion).getId();
               Intent intent = new Intent(getContext(), Teather_OneItem_Activity.class);
                intent.putExtra("id",id);
               startActivity(intent);
                Toast.makeText(getContext(), "one"+postion, Toast.LENGTH_SHORT).show();
            }
        });
        //two监听
        teather_adapter.setTwoClick(new Teather_Adapter.TwoClick() {
            @Override
            public void setTwoClick(int postion) {
                Toast.makeText(getContext(), "two"+postion, Toast.LENGTH_SHORT).show();
            }
        });
        //three监听
        teather_adapter.setThreeClick(new Teather_Adapter.ThreeClick() {
            @Override
            public void setThreeClick(int postion) {
                Toast.makeText(getContext(), "three"+postion, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
