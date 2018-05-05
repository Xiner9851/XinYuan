package com.example.administrator.xinyuan.contact;

/**
 * Created by fghjkl on 2018/5/3.
 */

public interface IHuoQuYZMaContact {
    interface View{
        void show();


    }
    interface Presenter{
        void loadMa(String value);


        void zhuCe(String tel, String ma);


        void wangCheng(String name, String sex, String toux, String tel, String password);

        void login(String tel, String password);

        void findPass(String tel, String ma);

        void findPassNext(String tel, String pass);
    }
}
