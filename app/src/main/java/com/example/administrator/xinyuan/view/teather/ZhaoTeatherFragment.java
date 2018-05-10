package com.example.administrator.xinyuan.view.teather;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.contact.teathercontact.zhaoteathercontact.IZhaoTeather_Contact;
import com.example.administrator.xinyuan.model.entity.ZhaoTeatherBean;
import com.example.administrator.xinyuan.presenter.teatherpresenter.zhaoteatherpresenter.IZhaoTeatherPresenter;
import com.example.administrator.xinyuan.view.teather.adapter.ZhaoAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhaoTeatherFragment extends BaseFragment implements IZhaoTeather_Contact.View {


    private RecyclerView zhao_recy;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhao_teather;
    }

    @Override
    protected void init() {
        zhao_recy=getView().findViewById(R.id.zhao_recy);
        zhao_recy.setLayoutManager(new GridLayoutManager(getContext(),2));

    }

    @Override
    protected void loadDate() {
        Bundle arguments = getArguments();
        int type = arguments.getInt("type");
       if (type == 2) {

        } else if (type == 3) {

        } else if (type == 4) {

        }
        Map<String, Object> params = new HashMap<>();
        params.put("userType", type);
        IZhaoTeatherPresenter iZhaoTeatherPresenter = new IZhaoTeatherPresenter(this);
        iZhaoTeatherPresenter.loadData(params);
    }

    @Override
    public void showData(ZhaoTeatherBean zhaoTeatherBean) {
        final ZhaoTeatherBean.DataBean data = zhaoTeatherBean.getData();
        final List<ZhaoTeatherBean.DataBean.ListBean> list = data.getList();
        ZhaoAdapter zhaoAdapter = new ZhaoAdapter(getContext(),list);
        zhao_recy.setAdapter(zhaoAdapter);
        zhaoAdapter.setOnClickItemListion(new ZhaoAdapter.OnClickListion() {
            @Override
            public void setOnCLickListion(View view, int postion) {
                Intent intent = new Intent(getContext(), ZhaoTeather_ItemCheck_Activity.class);
                int pid =  list.get(postion).get_$Id168();
                intent.putExtra("id",pid);
                startActivity(intent);
            }
        });

    }



}
