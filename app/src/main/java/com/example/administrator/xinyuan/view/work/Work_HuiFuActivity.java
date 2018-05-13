package com.example.administrator.xinyuan.view.work;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.huifuliebiaocontact.HuiFuLieBiaoContact;
import com.example.administrator.xinyuan.contact.workhuifucontact.WorkHuiFuContact;
import com.example.administrator.xinyuan.model.entity.HuiFuLieBiaoBean;
import com.example.administrator.xinyuan.model.entity.Work_HuiFuBean;
import com.example.administrator.xinyuan.presenter.workhuifuliebiaopresenter.IWorkHuiFuLieBiaoPresenter;
import com.example.administrator.xinyuan.presenter.workhuifupresenter.IWorkHuiFuPresenter;
import com.example.administrator.xinyuan.view.work.adapter.Work_HuiFu_Adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.administrator.xinyuan.App.context;

public class Work_HuiFuActivity extends BaseActivity implements WorkHuiFuContact.View,HuiFuLieBiaoContact.View{


    private ImageView work_again_back;
    private RelativeLayout www;
    private ListView huifu_listive;
    private EditText work_item_pinglun;
    private ImageView work_item_xiaoxi;
    private ImageView work_item_dianzan;
    private Button work_tijiao_btn;
    private RelativeLayout fudao;
    private IWorkHuiFuPresenter iWorkHuiFuPresenter;
    private Map<String, Object> params,params2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work__hui_fu;
    }

    @Override
    protected void init() {
        work_again_back= (ImageView) findViewById(R.id.work_again_back);
        huifu_listive= (ListView) findViewById(R.id.huifu_listive);
        work_item_pinglun= (EditText) findViewById(R.id.work_item_pinglun);
        work_item_xiaoxi= (ImageView) findViewById(R.id.work_item_xiaoxi);
        work_item_dianzan= (ImageView) findViewById(R.id.work_item_dianzan);
        work_tijiao_btn= (Button) findViewById(R.id.work_tijiao_btn);

    }

    @Override

    protected void loadData() {
        Intent intent = getIntent();
        int toId = intent.getIntExtra("toId", 0);
        String toContent = intent.getStringExtra("toContent");
        int replyId = intent.getIntExtra("replyId", 0);
        int refId = intent.getIntExtra("refId", 0);
        SharedPreferences xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        int id1 = xiaoji.getInt("id", 0);
        params = new HashMap<>();
        params.put("pid",id1);
        params.put("userId",id1);
        params.put("content",work_item_pinglun.getText().toString());
        params.put("toId",toId);
        params.put("toContent",toContent);
        params.put("replyId",replyId);
        params.put("refId",refId);
        params.put("refType","作业回复");
        iWorkHuiFuPresenter = new IWorkHuiFuPresenter(this);
        work_item_pinglun.clearFocus();
        work_item_pinglun.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                work_tijiao_btn.setVisibility(View.VISIBLE);
                work_item_xiaoxi.setVisibility(View.GONE);
                work_item_dianzan.setVisibility(View.GONE);
            }
        });
        work_tijiao_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work_tijiao_btn.setVisibility(View.GONE);
                work_item_xiaoxi.setVisibility(View.VISIBLE);
                work_item_dianzan.setVisibility(View.VISIBLE);
                iWorkHuiFuPresenter.huifuData(params);
                work_item_pinglun.setText("");
            }
        });
        SharedPreferences pinglunid = context.getSharedPreferences("pinglunid", context.MODE_PRIVATE);
        int pingid = pinglunid.getInt("pingid", 0);
        SharedPreferences workid = context.getSharedPreferences("workid", context.MODE_PRIVATE);
        int homewokId = workid.getInt("homewokId", 0);
        params2 = new HashMap<>();
        params2.put("homewokId",homewokId);
        params2.put("commentsId",pingid);
        IWorkHuiFuLieBiaoPresenter iWorkHuiFuLieBiaoPresenter = new IWorkHuiFuLieBiaoPresenter(this);
        iWorkHuiFuLieBiaoPresenter.huifuLieBiaoData(params2);

    }


    @Override
    public void showHuiFu(Work_HuiFuBean huiFuBean) {
        Log.e("huifu", "showHuiFu: "+huiFuBean.getMessage() );
    }

    @Override
    public void showHuiFuLieBiao(HuiFuLieBiaoBean huiFuLieBiaoBean) {
        List<HuiFuLieBiaoBean.DataBean.CommentsBean.ListBean> list = huiFuLieBiaoBean.getData().getComments().getList();
        Log.e("huifuliebiao", "showHuiFuliebaio: "+huiFuLieBiaoBean.getMessage() );
        Work_HuiFu_Adapter work_huiFu_adapter = new Work_HuiFu_Adapter(list, this);
        huifu_listive.setAdapter(work_huiFu_adapter);
        work_huiFu_adapter.notifyDataSetChanged();
    }
}
