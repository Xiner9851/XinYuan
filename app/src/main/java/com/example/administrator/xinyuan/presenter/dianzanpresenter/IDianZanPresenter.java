package com.example.administrator.xinyuan.presenter.dianzanpresenter;

import com.example.administrator.xinyuan.contact.dainzancontact.DianZanContact;
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

public class IDianZanPresenter implements DianZanContact.Presenter{
    private DianZanContact.View view;
    private final XinYuanService loadDate;

    public IDianZanPresenter(DianZanContact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadDianZan(Map<String, Object> params) {
        loadDate.dianZanMessage(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                       view.dianZan(responseBody);
                    }
                });
    }

    @Override
    public void loadQuDianZan(Map<String, Object> params) {
        loadDate.quDianZanMessage(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        view.quDianZan(responseBody);
                    }
                });
    }
}
