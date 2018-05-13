package com.example.administrator.xinyuan.presenter;

import com.example.administrator.xinyuan.contact.QQBangDContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.QQBangDingBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fghjkl on 2018/5/13.
 */

public class QQBangDPresent implements QQBangDContact.Present {
    private QQBangDContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public QQBangDPresent(QQBangDContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void QQBangD(String id, String uid, String openId) {
        Map<String,String> params=new HashMap<>();
        params.put("loginUserId",id);
        params.put("uid",uid);
        params.put("type",openId);
        iHuoQuYZMaService.qqBangD(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QQBangDingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(QQBangDingBean value) {
                        view.showQQ(value.getMessage());
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
