package com.example.administrator.xinyuan.presenter.workpresenter.workitempresenter;

import com.example.administrator.xinyuan.contact.workcontact.workitemcontact.Work_Item_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.Work_Item_Bean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/8.
 */

public class IWorkItemPresenter implements Work_Item_Contact.Presenter {
    private Work_Item_Contact.View view;
    private final XinYuanService loadDate;

    public IWorkItemPresenter(Work_Item_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String, Object> params) {
        loadDate.workItemData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<Work_Item_Bean>() {
                    @Override
                    public void accept(Work_Item_Bean work_item_bean) throws Exception {
                        view.showData(work_item_bean);
                    }
                });
    }
}
