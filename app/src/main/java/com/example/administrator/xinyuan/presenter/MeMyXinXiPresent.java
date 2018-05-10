package com.example.administrator.xinyuan.presenter;

import android.util.Log;

import com.example.administrator.xinyuan.contact.IMeMyXinXiContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.MeMyXinXiBean;
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

public class MeMyXinXiPresent implements IMeMyXinXiContact.Present{
    private IMeMyXinXiContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public MeMyXinXiPresent(IMeMyXinXiContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadMyXinXi(int a) {
        Map<String,Integer> params=new HashMap<>();
        params.put("loginUserId",a);
        iHuoQuYZMaService.loadMyXinxi(params)
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
                            Log.e("aaa",string);
                            MeMyXinXiBean meMyXinXiBean = new Gson().fromJson(string, MeMyXinXiBean.class);
                            MeMyXinXiBean.DataBean data = meMyXinXiBean.getData();
                            Log.e("data",data.getMobile());
                            view.showXinXi(data);

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
