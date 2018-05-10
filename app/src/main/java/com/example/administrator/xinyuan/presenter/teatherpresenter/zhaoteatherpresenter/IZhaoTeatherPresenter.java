package com.example.administrator.xinyuan.presenter.teatherpresenter.zhaoteatherpresenter;

import com.example.administrator.xinyuan.contact.teathercontact.zhaoteathercontact.IZhaoTeather_Contact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.ZhaoTeatherBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/9.
 */

public class IZhaoTeatherPresenter implements IZhaoTeather_Contact.Presenter {
    private IZhaoTeather_Contact.View view;
    private final XinYuanService loadDate;

    public IZhaoTeatherPresenter(IZhaoTeather_Contact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String,Object> params) {
            loadDate.zhaoTeatherData(params)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(new Consumer<ZhaoTeatherBean>() {
                        @Override
                        public void accept(ZhaoTeatherBean zhaoTeatherBean) throws Exception {
                            view.showData(zhaoTeatherBean);
                        }
                    });
    }
}
