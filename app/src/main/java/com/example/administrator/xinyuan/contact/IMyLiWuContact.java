package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.MyLiWuBean;

/**
 * Created by fghjkl on 2018/5/10.
 */

public interface IMyLiWuContact  {
    interface View{
        void showMyLiWu(MyLiWuBean.DataBean data);
    }
    interface Present{
        void loadMyLiWu(int id,int yeshu);
    }
}
