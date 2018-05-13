package com.example.administrator.xinyuan.presenter.zhaoteatherguanzhupresenter;

import com.example.administrator.xinyuan.contact.zhaoteatherguanzhucontact.ZhaoTeatherGuanZhuContact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/5/10.
 */

public class IZhao_GuanZhu_Presenter implements ZhaoTeatherGuanZhuContact.Presenter {
    private ZhaoTeatherGuanZhuContact.View view;
    private final XinYuanService loadDate;

    public IZhao_GuanZhu_Presenter( ZhaoTeatherGuanZhuContact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadGuanZhu(Map<String, Object> params) {
        loadDate.zhaoTeaherGuanZhuData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        view.guanzhu(responseBody);
                    }
                });

    }

    @Override
    public void loadQuGuan(Map<String, Object> params) {
        loadDate.zhaoTeaherQuGuanZhuData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        view.quguan(responseBody);
                    }
                });
    }
}
