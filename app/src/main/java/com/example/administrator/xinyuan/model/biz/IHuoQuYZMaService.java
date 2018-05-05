package com.example.administrator.xinyuan.model.biz;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by fghjkl on 2018/5/3.
 */

public interface IHuoQuYZMaService {
    @FormUrlEncoded
    @POST("v1/m/user/authcode")
    Observable<ResponseBody> loadMa(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("v1/m/user/register/mobile")
    Observable<ResponseBody> zhuCe(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("v1/m/user/saveCompleteUser")
    Observable<ResponseBody> wangCheng(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("v1/m/user/login/mobile")
    Observable<ResponseBody> login(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("v1/m/user/verify/authcode")
    Observable<ResponseBody> findPass(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("v1/m/user/save/password")
    Observable<ResponseBody> findPassNext(@FieldMap Map<String, String> params);
}