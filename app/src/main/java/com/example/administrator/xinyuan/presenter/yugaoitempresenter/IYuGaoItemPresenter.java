package com.example.administrator.xinyuan.presenter.yugaoitempresenter;

import com.example.administrator.xinyuan.contact.yugaoitemcontact.YuGao_Item_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.YuGao_ItemData;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/8.
 */

public class IYuGaoItemPresenter implements YuGao_Item_Contact.Presenter{
    private YuGao_Item_Contact.View view;
    private final XinYuanService loadDate;

    public IYuGaoItemPresenter(YuGao_Item_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String, Object> params) {
        loadDate.yugaoItemData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<YuGao_ItemData>() {
                    @Override
                    public void accept(YuGao_ItemData yuGao_itemData) throws Exception {
                        view.showData(yuGao_itemData);
                    }
                });
    }
}
