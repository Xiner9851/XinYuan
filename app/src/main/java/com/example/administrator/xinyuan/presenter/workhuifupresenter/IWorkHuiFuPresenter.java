package com.example.administrator.xinyuan.presenter.workhuifupresenter;

import com.example.administrator.xinyuan.contact.workhuifucontact.WorkHuiFuContact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.Work_HuiFuBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/11.
 */

public class IWorkHuiFuPresenter implements WorkHuiFuContact.Presenter {
    private WorkHuiFuContact.View view;
    private final XinYuanService loadDate;

    public IWorkHuiFuPresenter( WorkHuiFuContact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void huifuData(Map<String, Object> params) {
        loadDate.huifuMessage(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<Work_HuiFuBean>() {
                    @Override
                    public void accept(Work_HuiFuBean huiFuBean) throws Exception {
                             view.showHuiFu(huiFuBean);
                    }
                });
    }
}
