package com.example.administrator.xinyuan.view.me;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment implements View.OnClickListener{


    private ImageView touxiang;
    private Button zhuce;
    private Button denglu;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void init() {
        touxiang=getView().findViewById(R.id.touxiang);
        zhuce=getView().findViewById(R.id.zhuce);
        denglu=getView().findViewById(R.id.denglu);
        zhuce.setOnClickListener(this);
        touxiang.setOnClickListener(this);
        denglu.setOnClickListener(this);
    }

    @Override
    protected void loadDate() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.touxiang:
                Intent intent = new Intent(getActivity(),ZhuCeActivity.class);
                startActivity(intent);
                break;
            case R.id.zhuce:
                Intent intent1 = new Intent(getActivity(),ZhuCeActivity.class);
                startActivity(intent1);
                break;
            case R.id.denglu:
                Intent intent2 = new Intent(getActivity(),GoToLoginActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
