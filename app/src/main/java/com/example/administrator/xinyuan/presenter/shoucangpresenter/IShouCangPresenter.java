package com.example.administrator.xinyuan.presenter.shoucangpresenter;

import com.example.administrator.xinyuan.contact.shoucang.ShouCangContact;
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

public class IShouCangPresenter implements ShouCangContact.Presenter {
    private ShouCangContact.View view;
    private final XinYuanService loadDate;
    public IShouCangPresenter(ShouCangContact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadShouCang(Map<String, Object> params) {
        loadDate.shouCangMessage(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        view.shouCang(responseBody);
                    }
                });
    }

    @Override
    public void loadQuShouCang(Map<String, Object> params) {
        loadDate.quShouCangMessage(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        view.quShouCang(responseBody);
                    }
                });
    }
}
