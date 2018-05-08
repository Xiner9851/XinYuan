package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.MeMyXinXiBean;

/**
 * Created by fghjkl on 2018/5/7.
 */

public interface IMeMyXinXiContact {
    interface View{
        void showXinXi(MeMyXinXiBean.DataBean data);
    }
    interface Present{
        void loadMyXinXi(int a);
    }

}
