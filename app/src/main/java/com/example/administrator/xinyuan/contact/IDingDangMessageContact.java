package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.DingDanMessageBean;
import com.example.administrator.xinyuan.model.entity.GuanZhuMyBean;
import com.example.administrator.xinyuan.model.entity.GuanfanBean;
import com.example.administrator.xinyuan.model.entity.PingLunMessageBean;
import com.example.administrator.xinyuan.model.entity.ZanBean;

/**
 * Created by fghjkl on 2018/5/12.
 */

public interface IDingDangMessageContact {
    interface View{
        void showShuJu(DingDanMessageBean.DataBean data);
        void showShuJu(ZanBean.DataBean zanBean);
        void showPingLun(PingLunMessageBean.DataBean ping);
        void showZuoYe(PingLunMessageBean.DataBean data);
        void showGuanFan(GuanfanBean.DataBean data);
        void showGuanZHuMy(GuanZhuMyBean.DataBean data);

    }
    interface Present{
        void loadShuJu(int id);
        void loadZan(int id);
        void loadPingLun(int id);
        void loadZuoYe(int id);
        void loadTaunDui(int id);
        void loadGuanZhu(int id);
    }
}
