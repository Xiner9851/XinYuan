package com.example.administrator.xinyuan.model.biz;

import com.example.administrator.xinyuan.model.entity.BaoDian_Item_Bean;
import com.example.administrator.xinyuan.model.entity.HuiFuLieBiaoBean;
import com.example.administrator.xinyuan.model.entity.TeatherBean;
import com.example.administrator.xinyuan.model.entity.TeatherTuiJie_Item;
import com.example.administrator.xinyuan.model.entity.Teather_Banner_ItemBean;
import com.example.administrator.xinyuan.model.entity.Teather_One_Item;
import com.example.administrator.xinyuan.model.entity.TokenBean;
import com.example.administrator.xinyuan.model.entity.WorkBean;
import com.example.administrator.xinyuan.model.entity.WorkPingLunLieBiaoBean;
import com.example.administrator.xinyuan.model.entity.WorkTiJIaoBean;
import com.example.administrator.xinyuan.model.entity.Work_HuiFuBean;
import com.example.administrator.xinyuan.model.entity.Work_Item_Bean;
import com.example.administrator.xinyuan.model.entity.XianShang_Bean;
import com.example.administrator.xinyuan.model.entity.YuDaoBean;
import com.example.administrator.xinyuan.model.entity.YuGao_ItemData;
import com.example.administrator.xinyuan.model.entity.ZhaoTeatherBean;
import com.example.administrator.xinyuan.model.entity.ZhaoTeatherItemBean;
import com.example.administrator.xinyuan.model.entity.ZhaoTeather_FenSi_Bean;
import com.example.administrator.xinyuan.model.entity.ZhaoTeather_KeCheng;
import com.example.administrator.xinyuan.model.url.Urls;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
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
    @FormUrlEncoded
    @POST(Urls.zhao_teather_url)
    Observable<ZhaoTeatherBean> zhaoTeatherData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.zhaoteather_item_check_url)
    Observable<ZhaoTeatherItemBean> zhaoTeatherItemData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.zhaoteather_item_kecheng_url)
    Observable<ZhaoTeather_KeCheng> zhaoTeatherKeChengData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.zhaotrather_item_fensi_url)
    Observable<ZhaoTeather_FenSi_Bean> zhaoTeatherFenSiData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.xianshang_url)
    Observable<XianShang_Bean> xianShangData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.teather_tuijianitem_url)
    Observable<TeatherTuiJie_Item> teatherTuiJieItemData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.zhaoteather_guanzhu)
    Observable<ResponseBody> zhaoTeaherGuanZhuData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.zhaoteather_quxiaoguanzhu)
    Observable<ResponseBody> zhaoTeaherQuGuanZhuData(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.dianzan)
    Observable<ResponseBody> dianZanMessage(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.qudianzan)
    Observable<ResponseBody> quDianZanMessage(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.shoucang)
    Observable<ResponseBody> shouCangMessage(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.qushoucang)
    Observable<ResponseBody> quShouCangMessage(@FieldMap Map<String,Object> params);

    @FormUrlEncoded
    @POST(Urls.workpinglun_url)
    Observable<WorkPingLunLieBiaoBean> workPingLunMessage(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.tijiaopinglun_url)
    Observable<WorkTiJIaoBean> tijiaoPingLunMessage(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.tijiaopinglun_url)
    Observable<Work_HuiFuBean> huifuMessage(@FieldMap Map<String,Object> params);
    @FormUrlEncoded
    @POST(Urls.huifuliebiao_url)
    Observable<HuiFuLieBiaoBean> huifuLieBiaoMessage(@FieldMap Map<String,Object> params);

}
