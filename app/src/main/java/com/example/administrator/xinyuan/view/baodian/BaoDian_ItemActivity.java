package com.example.administrator.xinyuan.view.baodian;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.baodiancontact.baodianitemcontact.BaoDian_Item_Contact;
import com.example.administrator.xinyuan.model.entity.BaoDian_Item_Bean;
import com.example.administrator.xinyuan.presenter.baodianpresent.baodianitempresenter.IBaoDianItemPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaoDian_ItemActivity extends BaseActivity implements BaoDian_Item_Contact.View {


    private ImageView baodian_check_img;
    private TextView baodian_check_name;
    private TextView baodian_check_time;
    private TextView home_valuable_listitem_contenttype;
    private TextView baodian_check_title;
    private TextView baodian_check_content;
    private ImageView baodian_check_path;
    private TextView baodian_check_biaoqian;
    private TextView one_title;
    private ImageView again_back;
    private ImageView yuyue_item_btn;
    private RelativeLayout fudao;
    private TextView laixing;
    private RelativeLayout qqq;
    private LinearLayout rrr;
    private TextView ttt;
    private Button baodian_check_zansnag;
    private ImageView kaola;
    private RelativeLayout aaa;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bao_dian__item;
    }

    @Override
    protected void init() {
        baodian_check_img = (ImageView) findViewById(R.id.baodian_check_img);
        baodian_check_name = (TextView) findViewById(R.id.baodian_check_name);
        baodian_check_time = (TextView) findViewById(R.id.baodian_check_time);
        baodian_check_title = (TextView) findViewById(R.id.baodian_check_title);
        baodian_check_content = (TextView) findViewById(R.id.baodian_check_content);
        again_back = (ImageView) findViewById(R.id.again_back);

        baodian_check_path = (ImageView) findViewById(R.id.baodian_check_path);
        baodian_check_biaoqian = (TextView) findViewById(R.id.baodian_check_biaoqian);
        laixing = (TextView) findViewById(R.id.laixing);


    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Map<String, Object> params = new HashMap<>();
        params.put("artcircleId", id);

        IBaoDianItemPresenter iBaoDianItemPresenter = new IBaoDianItemPresenter(this);
        iBaoDianItemPresenter.loadData(params);
        again_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public void showData(BaoDian_Item_Bean baoDian_item_bean) {
        BaoDian_Item_Bean.DataBean.ArtcircleBean artcircle = baoDian_item_bean.getData().getArtcircle();


        Glide.with(this).load(artcircle.getCoverImg()).into(baodian_check_img);
        baodian_check_name.setText(artcircle.getNickname());
        baodian_check_title.setText(artcircle.getTitle());
        baodian_check_content.setText(artcircle.getContent());
        long createDate = artcircle.getCreateDate();
        String s = longToDate(createDate);
        baodian_check_time.setText(s);
        Glide.with(this).load(artcircle.getPath()).into(baodian_check_path);
        laixing.setText(artcircle.getContentType());


    }

    public static String longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }



}
