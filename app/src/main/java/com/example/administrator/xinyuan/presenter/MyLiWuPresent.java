package com.example.administrator.xinyuan.presenter;

import com.example.administrator.xinyuan.contact.IMyLiWuContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.MyLiWuBean;
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

public class MyLiWuPresent implements IMyLiWuContact.Present{
    private IMyLiWuContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public MyLiWuPresent(IMyLiWuContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadMyLiWu(int id, int yeshu) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        params.put("type",yeshu);
        iHuoQuYZMaService.loadMyLiWu(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyLiWuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyLiWuBean value) {
                        MyLiWuBean.DataBean data = value.getData();
                        view.showMyLiWu(data);
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
