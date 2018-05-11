package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.MyDingDangBean;

/**
 * Created by fghjkl on 2018/5/10.
 */

public interface IMyDingDangContact {
    interface View{
        void showSuJu(MyDingDangBean.DataBean data);
    }
    interface Present{
        void loadMyDingDang(int id,int yeshu);
    }

}
