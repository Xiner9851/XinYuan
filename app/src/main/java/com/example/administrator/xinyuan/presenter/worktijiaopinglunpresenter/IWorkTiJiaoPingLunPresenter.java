package com.example.administrator.xinyuan.presenter.worktijiaopinglunpresenter;

import com.example.administrator.xinyuan.contact.worktijiaopinglun.WorkTiJiaoPingLunContact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.WorkTiJIaoBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/11.
 */

public class IWorkTiJiaoPingLunPresenter implements WorkTiJiaoPingLunContact.Presenter {
    private WorkTiJiaoPingLunContact.View view;
    private final XinYuanService loadDate;


    public IWorkTiJiaoPingLunPresenter(WorkTiJiaoPingLunContact.View view) {
        this.view=view;


        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void tijiaoData(Map<String, Object> params) {
        loadDate.tijiaoPingLunMessage(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<WorkTiJIaoBean>() {
                    @Override
                    public void accept(WorkTiJIaoBean workTiJIaoBean) throws Exception {
                        view.showTiJiao(workTiJIaoBean);
                    }
                });
    }
}
