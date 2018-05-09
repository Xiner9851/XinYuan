package com.example.administrator.xinyuan.contact.teathercontact.teatherbannercontact;

import com.example.administrator.xinyuan.model.entity.Teather_Banner_ItemBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/9.
 */

public interface TeatherBanner_Contact {
    public interface Presenter{
        void loadData(Map<String,Object> params);
    }
    public interface View{
        void showData(Teather_Banner_ItemBean teather_banner_itemBean);
    }
}
