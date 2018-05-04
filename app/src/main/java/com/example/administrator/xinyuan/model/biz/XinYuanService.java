package com.example.administrator.xinyuan.model.biz;

import com.example.administrator.xinyuan.model.entity.TeatherBean;
import com.example.administrator.xinyuan.model.entity.TokenBean;
import com.example.administrator.xinyuan.model.entity.YuDaoBean;
import com.example.administrator.xinyuan.model.url.Urls;

import io.reactivex.Observable;
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
}
