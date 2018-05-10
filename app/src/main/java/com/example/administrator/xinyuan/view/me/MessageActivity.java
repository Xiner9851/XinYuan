package com.example.administrator.xinyuan.view.me;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IMessageContact;
import com.example.administrator.xinyuan.model.entity.MessageBean;
import com.example.administrator.xinyuan.presenter.MessagePresent;
import com.example.administrator.xinyuan.view.me.adapter.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends BaseActivity implements IMessageContact.View,View.OnClickListener{


    private TextView message_list_aty_cancle;
    private RecyclerView mRecy;
    private MessagePresent messagePresent;
    private List<MessageBean.DataBean> list=new ArrayList<>();
    private MessageAdapter messageAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void init() {
        mRecy= (RecyclerView) findViewById(R.id.mRecy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecy.setLayoutManager(linearLayoutManager);
        message_list_aty_cancle= (TextView) findViewById(R.id.message_list_aty_cancle);
        message_list_aty_cancle.setOnClickListener(this);

    }

    @Override
    protected void loadData() {


        messagePresent=new MessagePresent(this);
        messagePresent.loadShuJu(getSharedPreferences("xiaoji", Context.MODE_PRIVATE).getInt("id",0));
        messageAdapter=new MessageAdapter(this,list);
        mRecy.setAdapter(messageAdapter);
    }


    @Override
    public void showData(MessageBean value) {
        List<MessageBean.DataBean> data = value.getData();
        list.addAll(data);
        messageAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message_list_aty_cancle:

                finish();
                break;
        }
    }
}
