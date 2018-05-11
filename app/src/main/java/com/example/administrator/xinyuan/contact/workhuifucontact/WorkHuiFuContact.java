package com.example.administrator.xinyuan.contact.workhuifucontact;

import com.example.administrator.xinyuan.model.entity.Work_HuiFuBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/11.
 */

public class WorkHuiFuContact {
    public interface Presenter{
        void huifuData(Map<String,Object> params);

    }
    public interface View{
        void showHuiFu(Work_HuiFuBean huiFuBean);

    }
}
