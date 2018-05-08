package com.example.administrator.xinyuan.presenter.teatheronedatapresenter;

import com.example.administrator.xinyuan.contact.teatheronedatacontact.Teather_OneData_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.Teather_One_Item;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/7.
 */

public class Teather_OneItem_Presenter implements Teather_OneData_Contact.Presenter {
    private Teather_OneData_Contact.View view;
    private final XinYuanService loadDate;


    public Teather_OneItem_Presenter(Teather_OneData_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String,Object> params) {
        loadDate.teatherOneItemData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Consumer<Teather_One_Item>() {
                    @Override
                    public void accept(Teather_One_Item teather_one_item) throws Exception {
                        view.showData(teather_one_item);
                    }
                });
    }
}
