package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.FensiBean;
import com.example.administrator.xinyuan.model.entity.GuanZhuBean;
import com.example.administrator.xinyuan.model.entity.TieZiBean;

/**
 * Created by fghjkl on 2018/5/9.
 */

public interface ITieZiContact {
    interface View{
        void showShuJu(TieZiBean tieZiBean);
        void showGuanZhi(GuanZhuBean guanZhuBean);
        void showFensi(FensiBean fensiBean);
    }
    interface  Present{

        void LoadData(int id);
        void LoadGuanZhu(int id);
        void LoadFensi(int id);


    }

}
