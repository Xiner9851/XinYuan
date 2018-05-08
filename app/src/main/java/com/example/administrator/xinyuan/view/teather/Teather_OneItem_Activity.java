package com.example.administrator.xinyuan.view.teather;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.teatheronedatacontact.Teather_OneData_Contact;
import com.example.administrator.xinyuan.model.entity.Teather_One_Item;
import com.example.administrator.xinyuan.presenter.teatheronedatapresenter.Teather_OneItem_Presenter;
import com.example.administrator.xinyuan.view.teather.adapter.OneItemAdapter;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.HashMap;
import java.util.Map;

public class Teather_OneItem_Activity extends BaseActivity implements Teather_OneData_Contact.View {


    private RelativeLayout masterdetail_coachbtn;
    private ImageView masterdetail_img;
    private TextView masterdetail_logtime;
    private CheckBox masterdetail_replynum;
    private RoundedImageView masterdetail_teacherimg;
    private TextView masterdetail_teachername;
    private ImageView masterdetail_teachertype;
    private TextView masterdetail_teacherintro;
    private TextView masterdetail_teacher_Attention;


    private TextView masterdetail_teacherdetail_tv;
    private ImageView masterdetail_cancle;
    private ImageView masterdetail_aty_share;
    private Teather_OneItem_Presenter teather_oneItem_presenter;
    private RecyclerView masterdetail_recyclerview;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_teather__one_item_;
    }

    @Override
    protected void init() {
        masterdetail_img= (ImageView) findViewById(R.id.masterdetail_img);
        masterdetail_logtime= (TextView) findViewById(R.id.masterdetail_logtime);
        masterdetail_replynum= (CheckBox) findViewById(R.id.masterdetail_replynum);
        masterdetail_teachername= (TextView) findViewById(R.id.masterdetail_teachername);
        masterdetail_teachertype= (ImageView) findViewById(R.id.masterdetail_teachertype);
        masterdetail_teacherintro= (TextView) findViewById(R.id.masterdetail_teacherintro);
        masterdetail_teacher_Attention= (TextView) findViewById(R.id.masterdetail_teacher_Attention);
        masterdetail_teacherdetail_tv= (TextView) findViewById(R.id.masterdetail_teacherdetail_tv);
        masterdetail_cancle= (ImageView) findViewById(R.id.masterdetail_cancle);
        masterdetail_aty_share= (ImageView) findViewById(R.id.masterdetail_aty_share);
        masterdetail_teacherimg= (RoundedImageView) findViewById(R.id.masterdetail_teacherimg);
        masterdetail_recyclerview= (RecyclerView) findViewById(R.id.masterdetail_recyclerview);
        masterdetail_recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
    //ggg
    @Override
    protected void loadData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Map<String,Object> params=new HashMap<>();
        params.put("userId",id);
        teather_oneItem_presenter = new Teather_OneItem_Presenter(this);
        teather_oneItem_presenter.loadData(params);
        masterdetail_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //aaa

    }

    @Override
    public void showData(Teather_One_Item teather_one_item) {
        Teather_One_Item.DataBean.UserBean user = teather_one_item.getData().getUser();
        Glide.with(getApplicationContext()).load(user.getImages()).into(masterdetail_img);
        Glide.with(getApplicationContext()).load(user.getPhoto()).into(masterdetail_teacherimg);
        masterdetail_teachername.setText(user.getNickname());
        masterdetail_teacherintro.setText(user.getIntro());
        masterdetail_logtime.setText(user.getSkilled());
        int postsCount = teather_one_item.getData().getPostsCount();
        masterdetail_replynum.setText(postsCount+"");
        masterdetail_teacher_Attention.setText("关注");
        String details = user.getDetails();

        OneItemAdapter oneItemAdapter = new OneItemAdapter(getApplicationContext(), details);
        masterdetail_recyclerview.setAdapter(oneItemAdapter);

    }


}
