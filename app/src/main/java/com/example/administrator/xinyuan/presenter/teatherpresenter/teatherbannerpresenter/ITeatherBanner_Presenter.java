package com.example.administrator.xinyuan.presenter.teatherpresenter.teatherbannerpresenter;

import com.example.administrator.xinyuan.contact.teathercontact.teatherbannercontact.TeatherBanner_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.Teather_Banner_ItemBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/9.
 */

public class ITeatherBanner_Presenter   implements TeatherBanner_Contact.Presenter {
    private TeatherBanner_Contact.View view;
    private final XinYuanService loadDate;

    public ITeatherBanner_Presenter(TeatherBanner_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String,Object> params) {
        loadDate.teatherBannerItemData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<Teather_Banner_ItemBean>() {
                    @Override
                    public void accept(Teather_Banner_ItemBean teather_banner_itemBean) throws Exception {
                        view.showData(teather_banner_itemBean);
                    }
                });
    }
}
