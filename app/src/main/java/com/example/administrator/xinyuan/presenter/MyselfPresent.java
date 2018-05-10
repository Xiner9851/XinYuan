package com.example.administrator.xinyuan.presenter;

import android.util.Log;

import com.example.administrator.xinyuan.contact.IMyselfContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.MyselfModelBean;
import com.example.administrator.xinyuan.model.entity.RechargeCenterListModel;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fghjkl on 2018/5/8.
 */

public class MyselfPresent implements IMyselfContact.Present {
    private IMyselfContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public MyselfPresent(IMyselfContact.View view) {


        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadMyself(int a) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",a);
        iHuoQuYZMaService.getMyselftData(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyselfModelBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyselfModelBean value) {
                        Log.e("va",value.getData().getMobile());
                        MyselfModelBean.DataBean data = value.getData();
                        view.showShuju(data);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void loadMyself() {
        iHuoQuYZMaService.getMyselftData("v1/m/record/bean/setting")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RechargeCenterListModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RechargeCenterListModel value) {
                    view.showShuju(value);
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
