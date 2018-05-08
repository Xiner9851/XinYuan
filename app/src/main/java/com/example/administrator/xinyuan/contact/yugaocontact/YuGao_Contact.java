package com.example.administrator.xinyuan.contact.yugaocontact;

import com.example.administrator.xinyuan.model.entity.YuDaoBean;

/**
 * Created by Administrator on 2018/5/4.
 */

public interface YuGao_Contact {
    public interface Presenter{
        void loadData();
    }
    public interface View{
        void showData(YuDaoBean yuDaoBean);
    }
}
