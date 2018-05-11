package com.example.administrator.xinyuan.presenter.teatherpresenter.xianshangpresenter;

import com.example.administrator.xinyuan.contact.xianshangcontact.XianShang_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.XianShang_Bean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/10.
 */

public class IXianShang_Presenter implements XianShang_Contact.Presenter {
    private XianShang_Contact.View view;
    private final XinYuanService loadDate;

    public IXianShang_Presenter( XianShang_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String, Object> params) {
        loadDate.xianShangData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<XianShang_Bean>() {
                    @Override
                    public void accept(XianShang_Bean xianShang_bean) throws Exception {
                        view.showData(xianShang_bean);
                    }
                });
    }
}
