package com.example.administrator.xinyuan.presenter.teatherpresenter;

import com.example.administrator.xinyuan.contact.teathercontact.Teather_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.TeatherBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/3.
 */

public class ITeather_Presenter implements Teather_Contact.Presenter {
    private Teather_Contact.View view;
    private final XinYuanService loadDate;

    public ITeather_Presenter(Teather_Contact.View view) {
        this.view = view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData() {
        loadDate.teatherData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<TeatherBean>() {
                    @Override
                    public void accept(TeatherBean teatherBean) throws Exception {
                        view.showData(teatherBean);
                    }
                });
    }
}
