package com.example.administrator.xinyuan.presenter.workpresenter;

import com.example.administrator.xinyuan.contact.workcontact.Work_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.WorkBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/5.
 */

public class IWorkPresenter implements Work_Contact.Presenter {
    private Work_Contact.View view;
    private final XinYuanService loadDate;

    public IWorkPresenter(Work_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String,Object> params) {

        loadDate.workData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<WorkBean>() {
                    @Override
                    public void accept(WorkBean workBean) throws Exception {
                        view.showData(workBean);
                    }
                });
    }
}
