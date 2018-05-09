package com.example.administrator.xinyuan.model.biz;

import com.example.administrator.xinyuan.model.entity.BaoDian_Item_Bean;
import com.example.administrator.xinyuan.model.entity.TeatherBean;
import com.example.administrator.xinyuan.model.entity.Teather_Banner_ItemBean;
import com.example.administrator.xinyuan.model.entity.Teather_One_Item;
import com.example.administrator.xinyuan.model.entity.TokenBean;
import com.example.administrator.xinyuan.model.entity.WorkBean;
import com.example.administrator.xinyuan.model.entity.Work_Item_Bean;
import com.example.administrator.xinyuan.model.entity.YuDaoBean;
import com.example.administrator.xinyuan.model.entity.YuGao_ItemData;
import com.example.administrator.xinyuan.model.url.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/5/3.
 */

public interface XinYuanService {

    @POST(Urls.teather_url)
    Observable<TeatherBean> teatherData();
    @POST(Urls.token_url)
    Observable<TokenBean> tokenValue();
    @POST(Urls.yugao_url)
    Observable<YuDaoBean> yudaoData();
    @FormUrlEncoded
    @POST(Urls.work_url)
    Observable<WorkBean> workData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.teather_one_url)
    Observable<Teather_One_Item> teatherOneItemData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.yugao_item_url)
    Observable<YuGao_ItemData> yugaoItemData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.baodian_item_url)
    Observable<BaoDian_Item_Bean> baoDianItemData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.work_item_url)
    Observable<Work_Item_Bean> workItemData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.teather_banner_url)
    Observable<Teather_Banner_ItemBean> teatherBannerItemData(@FieldMap Map<String,Object> params);


}
