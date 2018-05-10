package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.MyselfModelBean;
import com.example.administrator.xinyuan.model.entity.RechargeCenterListModel;

/**
 * Created by fghjkl on 2018/5/8.
 */

public interface IMyselfContact {
    interface View{
        void showShuju(MyselfModelBean.DataBean data);
        void showShuju(RechargeCenterListModel rechargeCenterListModel);
    }
    interface Present{



        void loadMyself(int a);
        void loadMyself();
    }
}
