package com.example.administrator.xinyuan.presenter.teatherpresenter.zhaoteatherfensipresenter;

import com.example.administrator.xinyuan.contact.teathercontact.zhaoteatherfensicontact.ZhaoTeather_FenSi_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.ZhaoTeather_FenSi_Bean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/9.
 */

public class IZhaoTeatherFenSiPresenter implements ZhaoTeather_FenSi_Contact.Presenter {
    private ZhaoTeather_FenSi_Contact.View view;
    private XinYuanService loadDate;

    public IZhaoTeatherFenSiPresenter(ZhaoTeather_FenSi_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String, Object> params) {
        loadDate.zhaoTeatherFenSiData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<ZhaoTeather_FenSi_Bean>() {
                    @Override
                    public void accept(ZhaoTeather_FenSi_Bean zhaoTeather_fenSi_bean) throws Exception {
                            view.showData(zhaoTeather_fenSi_bean);
                    }
                });
    }
}
