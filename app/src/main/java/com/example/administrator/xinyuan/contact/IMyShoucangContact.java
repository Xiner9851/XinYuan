package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.MyShoucangBean;
import com.example.administrator.xinyuan.model.entity.TieZiBean;

/**
 * Created by fghjkl on 2018/5/10.
 */

public interface IMyShoucangContact {
    interface View{
        void showShoucang(MyShoucangBean.DataBean data);
        void showShoucang(TieZiBean tieZiBean);
    }
    interface Present{
        void loadMyShoucang(int id,int type);
        void loadMyShoucangTieZi(int id,int type);
    }
}
