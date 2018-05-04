package com.example.administrator.xinyuan.presenter.yugaopresenter;

import com.example.administrator.xinyuan.contact.yugaocontact.YuGao_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.YuDaoBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/4.
 */

public class IYuGaoPresenter implements YuGao_Contact.Presenter {
    private YuGao_Contact.View view;
    private final XinYuanService loadDate;

    public IYuGaoPresenter(YuGao_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();

    }

    @Override
    public void loadData() {
        loadDate.yudaoData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<YuDaoBean>() {
                    @Override
                    public void accept(YuDaoBean yuDaoBean) throws Exception {
                            view.showData(yuDaoBean);
                    }
                });
    }
}
