package com.example.administrator.xinyuan.presenter.workpinglunliebiaopresenter;

import com.example.administrator.xinyuan.contact.workpingluncontact.WorkPinglunContact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.WorkPingLunLieBiaoBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/11.
 */

public class IWorkPingLunLieBiaoPresenter implements WorkPinglunContact.Presenter {
    private WorkPinglunContact.View view;
    private final XinYuanService loadDate;

    public IWorkPingLunLieBiaoPresenter(WorkPinglunContact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void pinglunData(Map<String, Object> params) {
        loadDate.workPingLunMessage(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<WorkPingLunLieBiaoBean>() {
                    @Override
                    public void accept(WorkPingLunLieBiaoBean workPingLunLieBiao) throws Exception {
                            view.showPingLun(workPingLunLieBiao);
                    }
                });
    }
}
