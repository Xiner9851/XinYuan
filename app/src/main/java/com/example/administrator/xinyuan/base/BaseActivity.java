package com.example.administrator.xinyuan.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.xinyuan.App;


/**
 * Created by Administrator on 2018/5/3.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private BaseFragment lastframent;
    public FragmentTransaction transaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.context=this;
        init();
        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        App.context=null;
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    protected abstract void loadData();

    public void setContentView(int containerId,Class<? extends BaseFragment> fragmentClass,Bundle params){
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        String simpleName = fragmentClass.getSimpleName();
        BaseFragment fragment = (BaseFragment) manager.findFragmentByTag(simpleName);
        if (fragment==null){
           try {
               fragment  = fragmentClass.newInstance();
           } catch (InstantiationException e) {
               e.printStackTrace();
           } catch (IllegalAccessException e) {
               e.printStackTrace();
            }
            transaction.add(containerId,fragment,simpleName);
        }
        if (params!=null){
           fragment.setArguments(params);
       }
        if (lastframent!=null){
           transaction.hide(lastframent);
       }
       transaction.show(fragment);
       lastframent=fragment;

        transaction.commit();
        //return fragment;
   }
}
