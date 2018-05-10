package com.example.administrator.xinyuan.presenter.teatherpresenter.zhaoteatheritempresenter;

import com.example.administrator.xinyuan.contact.teathercontact.zhaoteatheritemcontact.ZhaoTeatherItem_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.ZhaoTeatherItemBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2018/5/9.
 */

public class IZhaoTheatherItemPresenter implements ZhaoTeatherItem_Contact.Presenter {
    private ZhaoTeatherItem_Contact.View view;
    private final XinYuanService loadDate;

    public IZhaoTheatherItemPresenter(ZhaoTeatherItem_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }


    @Override
    public void loadData(Map<String, Object> params) {
        loadDate.zhaoTeatherItemData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ZhaoTeatherItemBean>() {
                    @Override
                    public void accept(ZhaoTeatherItemBean zhaoTeatherItemBean) throws Exception {
                        view.showData(zhaoTeatherItemBean);
                    }
                });
    }
}
