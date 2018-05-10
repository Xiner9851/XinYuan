package com.example.administrator.xinyuan.presenter;

import com.example.administrator.xinyuan.contact.ITieZiContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.FensiBean;
import com.example.administrator.xinyuan.model.entity.GuanZhuBean;
import com.example.administrator.xinyuan.model.entity.TieZiBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fghjkl on 2018/5/9.
 */

public class TieZiPresent implements ITieZiContact.Present {
    private ITieZiContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public TieZiPresent(ITieZiContact.View view) {


        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void LoadData(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);

        iHuoQuYZMaService.loadTieZi(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TieZiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TieZiBean value) {
                        view.showShuJu(value);
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
    public void LoadGuanZhu(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        iHuoQuYZMaService.loadGuanzhu(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GuanZhuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GuanZhuBean value) {
                    view.showGuanZhi(value);
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
    public void LoadFensi(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        iHuoQuYZMaService.loadFensi(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FensiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FensiBean value) {
                    view.showFensi(value);
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
