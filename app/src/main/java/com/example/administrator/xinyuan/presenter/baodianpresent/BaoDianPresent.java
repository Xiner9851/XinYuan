package com.example.administrator.xinyuan.presenter.baodianpresent;

import android.util.Log;

import com.example.administrator.xinyuan.contact.baodiancontact.IBaoDianContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.BaoDianFuYongBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by fghjkl on 2018/5/7.
 */

public class BaoDianPresent implements IBaoDianContact.Presenter {
    private IBaoDianContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public BaoDianPresent(IBaoDianContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadData(int a) {
        Map<String,Integer> params=new HashMap<>();
        params.put("sortord",a);

        iHuoQuYZMaService.loadBaoDian(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String string = value.string();
                            Log.e("SSSSSSSSS",string);
                            Gson gson = new Gson();
                            BaoDianFuYongBean baoDianFuYongBean = gson.fromJson(string, BaoDianFuYongBean.class);
                            view.showData(baoDianFuYongBean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
