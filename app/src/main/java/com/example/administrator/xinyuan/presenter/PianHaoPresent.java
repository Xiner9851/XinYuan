package com.example.administrator.xinyuan.presenter;

import com.example.administrator.xinyuan.contact.PianHaoContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.MyPianHaoBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fghjkl on 2018/5/9.
 */

public class PianHaoPresent implements PianHaoContact.Present {
    private PianHaoContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public PianHaoPresent(PianHaoContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadPianHao() {
        iHuoQuYZMaService.loadPianHao()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyPianHaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyPianHaoBean value) {
                        MyPianHaoBean.DataBean data = value.getData();
                        view.showPianHao(data);
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
