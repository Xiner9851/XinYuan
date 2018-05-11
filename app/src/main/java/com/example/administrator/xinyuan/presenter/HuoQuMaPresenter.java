package com.example.administrator.xinyuan.presenter;

import android.util.Log;

import com.example.administrator.xinyuan.contact.IHuoQuYZMaContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.HuoQuMa;
import com.example.administrator.xinyuan.model.entity.LoginBean;
import com.example.administrator.xinyuan.model.entity.SettingNewPassBean;
import com.example.administrator.xinyuan.model.entity.UapateBean;
import com.example.administrator.xinyuan.model.entity.WangChengBean;
import com.example.administrator.xinyuan.model.entity.ZhuCeBean;
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
 * Created by fghjkl on 2018/5/3.
 */

public class HuoQuMaPresenter implements IHuoQuYZMaContact.Presenter {
    private IHuoQuYZMaContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public HuoQuMaPresenter(IHuoQuYZMaContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadMa(String value) {
        Map<String,String> params=new HashMap<>();
        params.put("mobile",value);

        iHuoQuYZMaService.loadMa(params)
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
                            Gson gson = new Gson();
                            HuoQuMa huoQuMa = gson.fromJson(string, HuoQuMa.class);
                            view.loadMa(huoQuMa.getMessage());
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

    @Override
    public void zhuCe(String tel, String ma) {
        Map<String,String> paramw=new HashMap<>();
        paramw.put("mobile",tel);
        paramw.put("mobileValidCode",ma);

        iHuoQuYZMaService.zhuCe(paramw)
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
                            Gson gson = new Gson();
                            ZhuCeBean zhuCeBean = gson.fromJson(string, ZhuCeBean.class);
                            String message = zhuCeBean.getMessage();
                            view.zhuCe(message);
                        } catch (IOException e) {


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

    @Override
    public void wangCheng(String name, String sex, String photo, String tel, String password) {
        Map<String,String> param=new HashMap<>();
        param.put("nickname",name);
        param.put("sex",sex);
        param.put("photo",photo);
        param.put("mobile",tel);
        param.put("psw",password);


        iHuoQuYZMaService.wangCheng(param)
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
                            Gson gson = new Gson();
                            WangChengBean wangChengBean = gson.fromJson(string, WangChengBean.class);

                            view.wangCheng(wangChengBean);
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

    @Override
    public void login(String tel, String password) {
        Map<String,String> para=new HashMap<>();
        para.put("mobile",tel);
        para.put("password",password);
        iHuoQuYZMaService.login(para)
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
                            Log.e("kjkk",string);
                            Gson gson = new Gson();
                            LoginBean loginBean = gson.fromJson(string, LoginBean.class);
                            view.login(loginBean);
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

    @Override
    public void findPass(String tel, String ma) {
        Map<String,String> psw=new HashMap<>();
        psw.put("mobile",tel);
        psw.put("authCode",ma);
        iHuoQuYZMaService.findPass(psw)
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
                            Gson gson = new Gson();
                            ZhuCeBean zhuCeBean = gson.fromJson(string, ZhuCeBean.class);
                            String message = zhuCeBean.getMessage();
                            view.findPass(message);
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

    @Override
    public void findPassNext(String tel, String pass) {
        Map<String,String> psws=new HashMap<>();
        psws.put("mobile",tel);
        psws.put("password",pass);
        iHuoQuYZMaService.findPassNext(psws)
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
                            Gson gson = new Gson();
                            UapateBean uapateBean = gson.fromJson(string, UapateBean.class);
                            view.findPassNext(uapateBean);
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

    @Override
    public void updateMobile(String id, String mobile, String code) {
        Map<String,String> params=new HashMap<>();
        params.put("loginUserId",id);
        params.put("mobile",mobile);
        params.put("code",code);
        iHuoQuYZMaService.goToUpdateMobile(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SettingNewPassBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SettingNewPassBean value) {
                    view.update(value.getMessage());
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
