package com.example.administrator.xinyuan.presenter.baodianpresent.baodianitempresenter;

import com.example.administrator.xinyuan.contact.baodiancontact.baodianitemcontact.BaoDian_Item_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.BaoDian_Item_Bean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/8.
 */

public class IBaoDianItemPresenter implements BaoDian_Item_Contact.Presenter {
    private BaoDian_Item_Contact.View view;
    private final XinYuanService loadDate;

    public IBaoDianItemPresenter(BaoDian_Item_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String, Object> params) {
        loadDate.baoDianItemData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<BaoDian_Item_Bean>() {
                    @Override
                    public void accept(BaoDian_Item_Bean baoDian_item_bean) throws Exception {
                        view.showData(baoDian_item_bean);
                    }
                });
    }
}
