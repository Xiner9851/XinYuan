package com.example.administrator.xinyuan.presenter.liwupresenter;

import com.example.administrator.xinyuan.contact.liwucontact.LiWuContact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.LiWuBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/13.
 */

public class ILIWuPresenter implements LiWuContact.Presenter {
    private LiWuContact.View view;
    private final XinYuanService loadDate;

    public ILIWuPresenter(LiWuContact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void liwuLieBiaoData(Map<String, Object> params) {
        loadDate.liwuLieBiaoMessage(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<LiWuBean>() {
                    @Override
                    public void accept(LiWuBean liWuBean) throws Exception {
                        view.showLiWuLieBiao(liWuBean);
                    }
                });
    }
}
