package com.example.administrator.xinyuan.presenter.baodianpresent;

import com.example.administrator.xinyuan.contact.baodiancontact.IWenZhangDetailContact;
import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.entity.TieZiBean;
import com.example.administrator.xinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fghjkl on 2018/5/8.
 */

public class WenZhangDetailPresent implements IWenZhangDetailContact.Present {
    private IWenZhangDetailContact.View view;
    private IHuoQuYZMaService iHuoQuYZMaService;

    public WenZhangDetailPresent(IWenZhangDetailContact.View view) {
        this.view = view;
        iHuoQuYZMaService= RetrofitUtils.getInstence().getIHuoQuYZMaService();
    }

    @Override
    public void loadDeatil(int id) {
        Map<String,Integer> params=new HashMap<>();
        params.put("artcircleId",id);
        iHuoQuYZMaService.loaddetail(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TieZiBean>() {
                    @Override
                    public void accept(TieZiBean tieZiBean) throws Exception {
                        view.showShuJu();
                    }
                });
    }
}
