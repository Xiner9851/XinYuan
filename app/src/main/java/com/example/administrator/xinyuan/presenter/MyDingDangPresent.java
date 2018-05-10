package com.example.administrator.xinyuan.presenter;

import com.example.administrator.xinyuan.contact.IMyDingDangContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.MyDingDangBean;
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

public class MyDingDangPresent implements IMyDingDangContact.Present {
    private IMyDingDangContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public MyDingDangPresent(IMyDingDangContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadMyDingDang(int id, int yeshu) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        params.put("status",yeshu);
        iHuoQuYZMaService.loadMyDingDang(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyDingDangBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyDingDangBean value) {
                        MyDingDangBean.DataBean data = value.getData();

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
