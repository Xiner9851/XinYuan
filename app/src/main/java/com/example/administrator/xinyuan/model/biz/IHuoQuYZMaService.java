package com.example.administrator.xinyuan.model.biz;

import com.example.administrator.xinyuan.model.entity.FensiBean;
import com.example.administrator.xinyuan.model.entity.GuanZhuBean;
import com.example.administrator.xinyuan.model.entity.MessageBean;
import com.example.administrator.xinyuan.model.entity.MyDingDangBean;
import com.example.administrator.xinyuan.model.entity.MyLiWuBean;
import com.example.administrator.xinyuan.model.entity.MyPianHaoBean;
import com.example.administrator.xinyuan.model.entity.MyShoucangBean;
import com.example.administrator.xinyuan.model.entity.MyselfModelBean;
import com.example.administrator.xinyuan.model.entity.RechargeCenterListModel;
import com.example.administrator.xinyuan.model.entity.SettingNewPassBean;
import com.example.administrator.xinyuan.model.entity.TieZiBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

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


    @FormUrlEncoded
    @POST("v1/m/artcircle/home")
    Observable<ResponseBody> loadBaoDian(@FieldMap Map<String, Integer> params);

    @FormUrlEncoded
    @POST("v1/m/user/info")
    Observable<ResponseBody> loadMyXinxi(@FieldMap Map<String, Integer> params);

    @FormUrlEncoded
    @POST("v1/m/artcircle/detail")
    Observable<TieZiBean> loaddetail(@FieldMap Map<String, Integer> params);

    @FormUrlEncoded
    @POST("/v1/m/user/my")
    Observable<MyselfModelBean> getMyselftData(@FieldMap Map<String,Integer> params);



    @POST
    Observable<RechargeCenterListModel> getMyselftData(@Url String url);

    @FormUrlEncoded
    @POST("v1/m/user/my/artcircle")
    Observable<TieZiBean> loadTieZi(@FieldMap Map<String,Integer> params);


    @FormUrlEncoded
    @POST("v1/m/user/my/attention")
    Observable<GuanZhuBean> loadGuanzhu(@FieldMap Map<String,Integer> params);

    @FormUrlEncoded
    @POST("v1/m/user/my/fans")
    Observable<FensiBean> loadFensi(@FieldMap Map<String,Integer> params);


    @GET("v1/m/user/preference")
    Observable<MyPianHaoBean> loadPianHao();

    @FormUrlEncoded
    @POST("v1/m/user/my/orders")
    Observable<MyDingDangBean> loadMyDingDang(@FieldMap Map<String,Integer> params);


    @FormUrlEncoded
    @POST("v1/m/record/detail")
    Observable<MyLiWuBean> loadMyLiWu(@FieldMap Map<String,Integer> params);

    @FormUrlEncoded
    @POST("v1/m/user/my/favorites")
    Observable<MyShoucangBean> loadMyShoucang(@FieldMap Map<String,Integer> params);

    @FormUrlEncoded
    @POST("v1/m/user/my/favorites")
    Observable<TieZiBean> loadMyShoucangTieZi(@FieldMap Map<String,Integer> params);


    @FormUrlEncoded
    @POST("v1/m/message/list")
    Observable<MessageBean> loadMessage(@FieldMap Map<String,Integer> params);

    @FormUrlEncoded
    @POST("v1/m/user/setting/password")
    Observable<SettingNewPassBean> loadSettingNewPass(@FieldMap Map<String,String> params);

    @FormUrlEncoded
    @POST("v1/m/user/setting/mobile")
    Observable<SettingNewPassBean> goToUpdateMobile(@FieldMap Map<String,String> params);


    @FormUrlEncoded
    @POST("v1/m/user/my/preference/save")
    Observable<SettingNewPassBean> cunPianHao(@FieldMap Map<String,String> params);
}
