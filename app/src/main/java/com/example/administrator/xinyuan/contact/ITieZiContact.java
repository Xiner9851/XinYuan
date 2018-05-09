package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.GuanZhuBean;
import com.example.administrator.xinyuan.model.entity.TieZiBean;

/**
 * Created by fghjkl on 2018/5/9.
 */

public interface ITieZiContact {
    interface View{
        void showShuJu(TieZiBean tieZiBean);
        void showGuanZhi(GuanZhuBean guanZhuBean);
    }
    interface  Present{
        void LoadData(int id);
        void LoadGuanZhu(int id);
    }

}
