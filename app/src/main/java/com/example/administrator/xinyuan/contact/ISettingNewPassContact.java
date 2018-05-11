package com.example.administrator.xinyuan.contact;

/**
 * Created by fghjkl on 2018/5/11.
 */

public interface ISettingNewPassContact {
    interface View{
        void updateOk(String a);
    }
    interface Present{
        void goToUpdata(String id,String pass);
    }
}
