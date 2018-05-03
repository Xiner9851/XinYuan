package com.example.administrator.xinyuan.contact.teathercontact;

import com.example.administrator.xinyuan.model.entity.TeatherBean;

/**
 * Created by Administrator on 2018/5/3.
 */

public interface Teather_Contact {
    public interface Presenter{
        void loadData();
    }
    public interface View{
        void showData(TeatherBean teatherBean);
    }
}
