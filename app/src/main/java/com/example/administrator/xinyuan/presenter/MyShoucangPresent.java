package com.example.administrator.xinyuan.presenter;

import com.example.administrator.xinyuan.contact.IMyShoucangContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.MyShoucangBean;
import com.example.administrator.xinyuan.model.entity.TieZiBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fghjkl on 2018/5/10.
 */

public class MyShoucangPresent implements IMyShoucangContact.Present {
    private IMyShoucangContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public MyShoucangPresent(IMyShoucangContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadMyShoucang(int id, int type) {

        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        params.put("type",type);
        iHuoQuYZMaService.loadMyShoucang(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyShoucangBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyShoucangBean value) {
                        MyShoucangBean.DataBean data = value.getData();
                        view.showShoucang(data);
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
    public void loadMyShoucangTieZi(int id, int type) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        params.put("type",type);
        iHuoQuYZMaService.loadMyShoucangTieZi(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TieZiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TieZiBean value) {
                    view.showShoucang(value);
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
