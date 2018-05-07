package com.example.administrator.xinyuan.contact.baodiancontact;

import com.example.administrator.xinyuan.model.entity.BaoDianFuYongBean;

/**
 * Created by fghjkl on 2018/5/6.
 */

public interface IBaoDianContact {
    interface View{
        void showData(BaoDianFuYongBean baoDianFuYongBean);
    }
    interface Presenter{
        void loadData(int a);
    }

}
