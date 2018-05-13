package com.example.administrator.xinyuan.view.teather;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.contact.xianshangcontact.XianShang_Contact;
import com.example.administrator.xinyuan.model.entity.XianShang_Bean;
import com.example.administrator.xinyuan.presenter.teatherpresenter.xianshangpresenter.IXianShang_Presenter;
import com.example.administrator.xinyuan.view.teather.adapter.XianShangAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class XianShang_Fragment extends BaseFragment implements XianShang_Contact.View{


    private RecyclerView xianshang_recy;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xian_shang_;
    }

    @Override
    protected void init() {
        xianshang_recy=getView().findViewById(R.id.xianshang_recy);
        xianshang_recy.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void loadDate() {


            Map<String,Object> params=new HashMap<>();

            params.put("type","讲堂");

            IXianShang_Presenter iXianShang_presenter = new IXianShang_Presenter(this);
            iXianShang_presenter.loadData(params);


    }


    @Override
    public void showData(XianShang_Bean xianShang_bean) {
        List<XianShang_Bean.DataBean.ListBean> list = xianShang_bean.getData().getList();
        XianShangAdapter xianShangAdapter = new XianShangAdapter(getContext(), list);
        xianshang_recy.setAdapter(xianShangAdapter);
    }
}
