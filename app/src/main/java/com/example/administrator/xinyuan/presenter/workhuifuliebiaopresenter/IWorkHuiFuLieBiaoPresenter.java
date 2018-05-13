package com.example.administrator.xinyuan.presenter.workhuifuliebiaopresenter;

import com.example.administrator.xinyuan.contact.huifuliebiaocontact.HuiFuLieBiaoContact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.HuiFuLieBiaoBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/11.
 */

public class IWorkHuiFuLieBiaoPresenter implements HuiFuLieBiaoContact.Presenter {
    private HuiFuLieBiaoContact.View view;
    private final XinYuanService loadDate;

    public IWorkHuiFuLieBiaoPresenter(HuiFuLieBiaoContact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void huifuLieBiaoData(Map<String, Object> params) {
        loadDate.huifuLieBiaoMessage(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<HuiFuLieBiaoBean>() {
                    @Override
                    public void accept(HuiFuLieBiaoBean huiFuLieBiaoBean) throws Exception {
                        view.showHuiFuLieBiao(huiFuLieBiaoBean);
                    }
                });
    }
}
