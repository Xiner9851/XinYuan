package com.example.administrator.xinyuan.presenter;

import com.example.administrator.xinyuan.contact.ICunPianHaoContact;
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

public class CunPianHaoPresent implements ICunPianHaoContact.Present {
    private ICunPianHaoContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public CunPianHaoPresent(ICunPianHaoContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void cunPianHao(String id, String magorid, String collegeid) {
        Map<String,String> params=new HashMap<>();
        params.put("loginUserId",id);
        params.put("majorIds",magorid);
        params.put("collegeIds",collegeid);
        iHuoQuYZMaService.cunPianHao(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SettingNewPassBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SettingNewPassBean value) {
                        view.pianHao(value.getMessage());
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
