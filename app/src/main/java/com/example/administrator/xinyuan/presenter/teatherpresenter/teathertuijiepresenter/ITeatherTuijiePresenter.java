package com.example.administrator.xinyuan.presenter.teatherpresenter.teathertuijiepresenter;

import android.util.Log;

import com.example.administrator.xinyuan.contact.teathertuijiecontact.ITeatherTuiJieContact;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.TeatherTuiJie_Item;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/10.
 */

public class ITeatherTuijiePresenter implements ITeatherTuiJieContact.Presenter {
    private ITeatherTuiJieContact.View view;
    private final XinYuanService loadDate;

    public ITeatherTuijiePresenter(ITeatherTuiJieContact.View view) {
        this.view=view;
        loadDate = RetrofitUtils.getInstence().getLoadDate();
    }

    @Override
    public void loadData(Map<String, Object> params) {
        loadDate.teatherTuiJieItemData(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<TeatherTuiJie_Item>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TeatherTuiJie_Item value) {
                        Log.e("===",value.toString());
                        view.showData(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
