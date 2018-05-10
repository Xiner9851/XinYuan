package com.example.administrator.xinyuan.contact.teathercontact.zhaoteatheritemcontact;

import com.example.administrator.xinyuan.model.entity.ZhaoTeatherItemBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/9.
 */

public interface ZhaoTeatherItem_Contact {
    public interface Presenter{
        void loadData(Map<String,Object> params);
    }
    public interface View{
        void showData(ZhaoTeatherItemBean zhaoTeatherItemBean);
    }
}
