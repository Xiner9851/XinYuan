package com.example.administrator.xinyuan.presenter;

import com.example.administrator.xinyuan.contact.IDingDangMessageContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.DingDanMessageBean;
import com.example.administrator.xinyuan.model.entity.GuanZhuMyBean;
import com.example.administrator.xinyuan.model.entity.GuanfanBean;
import com.example.administrator.xinyuan.model.entity.PingLunMessageBean;
import com.example.administrator.xinyuan.model.entity.ZanBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fghjkl on 2018/5/12.
 */

public class DingDanMessagePresent implements IDingDangMessageContact.Present{

    private IDingDangMessageContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public DingDanMessagePresent(IDingDangMessageContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadShuJu(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        iHuoQuYZMaService.loadDingDangMessage(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DingDanMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DingDanMessageBean value) {
                        DingDanMessageBean.DataBean data = value.getData();
                        view.showShuJu(data);
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
    public void loadZan(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        iHuoQuYZMaService.loadZanMessage(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZanBean value) {
                        ZanBean.DataBean data = value.getData();
                        view.showShuJu(data);
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
    public void loadPingLun(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        iHuoQuYZMaService.loadPingLunMessage(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PingLunMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PingLunMessageBean value) {
                        view.showPingLun(value.getData());
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
    public void loadZuoYe(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        iHuoQuYZMaService.loadZuoYeMessage(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PingLunMessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PingLunMessageBean value) {
                        view.showZuoYe(value.getData());
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
    public void loadTaunDui(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        iHuoQuYZMaService.loadGuanfaMessage(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GuanfanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuanfanBean value) {
                        view.showGuanFan(value.getData());
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
    public void loadGuanZhu(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        iHuoQuYZMaService.loadGuanZhuMyMessage(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GuanZhuMyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuanZhuMyBean value) {
                        view.showGuanZHuMy(value.getData());
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
