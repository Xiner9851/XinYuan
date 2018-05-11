package com.example.administrator.xinyuan.presenter;

import com.example.administrator.xinyuan.contact.ISettingNewPassContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.SettingNewPassBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fghjkl on 2018/5/11.
 */

public class SettingNewPassPresent implements ISettingNewPassContact.Present {
    private ISettingNewPassContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public SettingNewPassPresent(ISettingNewPassContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void goToUpdata(String id, String pass) {
        Map<String,String> params=new HashMap<>();
        params.put("loginUserId",id);
        params.put("password",pass);
        iHuoQuYZMaService.loadSettingNewPass(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SettingNewPassBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SettingNewPassBean value) {
                        String message = value.getMessage();
                        view.updateOk(message);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
