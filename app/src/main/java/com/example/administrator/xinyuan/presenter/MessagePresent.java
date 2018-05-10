package com.example.administrator.xinyuan.presenter;

import com.example.administrator.xinyuan.contact.IMessageContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.MessageBean;
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

public class MessagePresent implements IMessageContact.Present {
    private IMessageContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public MessagePresent(IMessageContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadShuJu(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",id);
        iHuoQuYZMaService.loadMessage(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MessageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MessageBean value) {
                    view.showData(value);
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
