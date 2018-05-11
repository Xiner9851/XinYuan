package com.example.administrator.xinyuan.contact;

import com.example.administrator.xinyuan.model.entity.LoginBean;
import com.example.administrator.xinyuan.model.entity.UapateBean;
import com.example.administrator.xinyuan.model.entity.WangChengBean;

/**
 * Created by fghjkl on 2018/5/3.
 */

public interface IHuoQuYZMaContact {
    interface View{
        void loadMa(String a);

        void zhuCe(String s);

        void wangCheng(WangChengBean wangChengBean);

        void login( LoginBean loginBean);

        void findPass(String s);

        void findPassNext(UapateBean uapateBean);


        void update(String a);
    }
    interface Presenter{
        void loadMa(String value);


        void zhuCe(String tel, String ma);


        void wangCheng(String name, String sex, String toux, String tel, String password);

        void login(String tel, String password);

        void findPass(String tel, String ma);

        void findPassNext(String tel, String pass);


        void updateMobile(String id,String mobile,String code);
    }
}
