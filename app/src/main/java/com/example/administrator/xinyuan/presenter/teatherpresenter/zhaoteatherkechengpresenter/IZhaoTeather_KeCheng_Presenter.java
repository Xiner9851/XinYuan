package com.example.administrator.xinyuan.presenter.teatherpresenter.zhaoteatherkechengpresenter;

import com.example.administrator.xinyuan.contact.teathercontact.zhaoteatherkechengcontact.ZhaoTeather_KeCheng_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.ZhaoTeather_KeCheng;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/9.
 */

public class IZhaoTeather_KeCheng_Presenter implements ZhaoTeather_KeCheng_Contact.Presenter {
    private ZhaoTeather_KeCheng_Contact.View view;
    private final XinYuanService loadDate;

    public IZhaoTeather_KeCheng_Presenter(ZhaoTeather_KeCheng_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String, Object> params) {
        loadDate.zhaoTeatherKeChengData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ZhaoTeather_KeCheng>() {
                    @Override
                    public void accept(ZhaoTeather_KeCheng zhaoTeatherKeCheng) throws Exception {
                        view.showData(zhaoTeatherKeCheng);
                    }
                });
    }
}
