package com.example.administrator.xinyuan.presenter.baodianpresent;

import android.util.Log;

import com.example.administrator.xinyuan.contact.baodiancontact.IWenZhangDetailContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by fghjkl on 2018/5/8.
 */

public class WenZhangDetailPresent implements IWenZhangDetailContact.Present {
    private IWenZhangDetailContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public WenZhangDetailPresent(IWenZhangDetailContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }



    @Override
    public void loadDeatil(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("artcircleId",id);
        iHuoQuYZMaService.loaddetail(params)
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
                            Log.e("cccccc",string);
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
