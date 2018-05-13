package com.example.administrator.xinyuan.view.teather;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.shoucang.ShouCangContact;
import com.example.administrator.xinyuan.contact.teathertuijiecontact.ITeatherTuiJieContact;
import com.example.administrator.xinyuan.model.entity.TeatherTuiJie_Item;
import com.example.administrator.xinyuan.presenter.shoucangpresenter.IShouCangPresenter;
import com.example.administrator.xinyuan.presenter.teatherpresenter.teathertuijiepresenter.ITeatherTuijiePresenter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;

public class TuiJie_ItemActivity extends BaseActivity implements ITeatherTuiJieContact.View,ShouCangContact.View {


    private ImageView again_img;
    private TextView again_teacherlabel;
    private CheckBox again_teacherzan;
    private RelativeLayout again_teacher;
    private RelativeLayout again_bigImg;
    private ImageView again_NameteacherHead_teacherImg;
    private TextView again_NameteacherHead_teacherName;
    private ImageView again_NameteacherHead_teacherVipImg;
    private TextView again_teacherHead_NameteacherTitle;
    private Button again_NameteacherHead_teacherConcern;
    private RelativeLayout again_NameTeacherHead1;
    private TextView biaoqian;
    private TextView biaoqian2;
    private LinearLayout aaa;
    private RelativeLayout again_NameTeacherHead2;
    private RelativeLayout again_Rela;
    private WebView again_NameTeacherContent;
    private RelativeLayout again_NameTeacherHead;
    private ImageView again_back;
    private ImageView again_share;
    private RelativeLayout fudao;
    private TextView tuijie_jiege;
    private TextView yuyuegeshu;
    private TextView textView5;
    private TextView ketang;
    private TextView ketangtime;
    private TextView price;

    String webUrl = "http://share.univstar.com/view/live.html?id=%s";
    private int idd;
    private ImageView tuijie_shoucang;
    private ImageView tuijie_qushoucang;
    private IShouCangPresenter iShouCangPresenter;
    private int id1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tui_jie__item;
    }

    @Override
    protected void init() {

        again_img = (ImageView) findViewById(R.id.again_img);
        again_teacherlabel = (TextView) findViewById(R.id.again_teacherlabel);
        again_teacherzan = (CheckBox) findViewById(R.id.again_teacherzan);
        again_teacher = (RelativeLayout) findViewById(R.id.again_teacher);
        again_bigImg = (RelativeLayout) findViewById(R.id.again_bigImg);
        again_NameteacherHead_teacherImg = (ImageView) findViewById(R.id.again_NameteacherHead_teacherImg);
        again_NameteacherHead_teacherName = (TextView) findViewById(R.id.again_NameteacherHead_teacherName);
        again_NameteacherHead_teacherVipImg = (ImageView) findViewById(R.id.again_NameteacherHead_teacherVipImg);
        again_teacherHead_NameteacherTitle = (TextView) findViewById(R.id.again_teacherHead_NameteacherTitle);
        again_NameteacherHead_teacherConcern = (Button) findViewById(R.id.again_NameteacherHead_teacherConcern);
        again_NameTeacherHead1 = (RelativeLayout) findViewById(R.id.again_NameTeacherHead1);
        biaoqian = (TextView) findViewById(R.id.biaoqian);
        biaoqian2 = (TextView) findViewById(R.id.biaoqian2);
        again_NameTeacherContent = (WebView) findViewById(R.id.again_NameTeacherContent);
        again_back = (ImageView) findViewById(R.id.again_back);
        again_share = (ImageView) findViewById(R.id.again_share);

        yuyuegeshu = (TextView) findViewById(R.id.yuyuegeshu);
        textView5 = (TextView) findViewById(R.id.textView5);
        ketangtime = (TextView) findViewById(R.id.ketangtime);
        price = (TextView) findViewById(R.id.price);
        tuijie_shoucang = (ImageView) findViewById(R.id.tuijie_shoucang);
        tuijie_qushoucang = (ImageView) findViewById(R.id.tuijie_qushoucang);

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        idd = intent.getIntExtra("id", 0);
        Map<String, Object> params = new HashMap<>();
        params.put("id", idd);
        ITeatherTuijiePresenter iTeatherTuijiePresenter = new ITeatherTuijiePresenter(this);
        iTeatherTuijiePresenter.loadData(params);

        again_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iShouCangPresenter = new IShouCangPresenter(this);


    }

    @Override
    public void showData(TeatherTuiJie_Item teatherTuiJie_item) {
        final TeatherTuiJie_Item.DataBean data = teatherTuiJie_item.getData();
        Glide.with(this).load(data.getCoverImg()).into(again_img);
        again_teacherlabel.setText("重播");
        long startDate = data.getStartDate();
        String s = longToDate(startDate);
        ketangtime.setText(s);
        Glide.with(this).load(data.getPhoto()).asBitmap()
                .override(50, 50)
                .into(new BitmapImageViewTarget(again_NameteacherHead_teacherImg) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
                        drawable.setCornerRadius(100);
                        again_NameteacherHead_teacherImg.setImageDrawable(drawable);
                    }
                });
        again_NameteacherHead_teacherName.setText(data.getNickname());
        int userType = data.getUserType();
        if (userType == 4) {
            again_NameteacherHead_teacherVipImg.setImageResource(R.mipmap.home_level_vip_red);
        } else if (userType == 3) {
            again_NameteacherHead_teacherVipImg.setImageResource(R.mipmap.home_level_vip_yellow);
        } else if (userType == 2) {
            again_NameteacherHead_teacherVipImg.setImageResource(R.mipmap.home_level_vip_blue);
        }
        again_teacherHead_NameteacherTitle.setText(data.getIntro());
        yuyuegeshu.setText(data.getSubscribe() + "/" + data.getSubscribeNum());
        price.setText("￥" + data.getPrice());
        //声明WebSettings子类
        WebSettings webSettings = again_NameTeacherContent.getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);

        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        again_NameTeacherContent.loadUrl(String.format(webUrl, idd));
        SharedPreferences xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        id1 = xiaoji.getInt("id", 0);
        tuijie_shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> params=new HashMap<>();
                params.put("id",data.getId());
                params.put("loginUserId",id1);
                params.put("type","直播课");

                iShouCangPresenter.loadShouCang(params);
                tuijie_shoucang.setVisibility(View.GONE);
                tuijie_qushoucang.setVisibility(View.VISIBLE);
            }
        });
        tuijie_qushoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> params=new HashMap<>();
                params.put("id",data.getId());
                params.put("loginUserId",id1);
                params.put("type","直播课");

                iShouCangPresenter.loadQuShouCang(params);
                tuijie_shoucang.setVisibility(View.VISIBLE);
                tuijie_qushoucang.setVisibility(View.GONE);
            }
        });
    }

    public static String longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }


    @Override
    public void shouCang(ResponseBody responseBody) {
        try {
            Log.e("hhhh",responseBody.string()+"收藏");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void quShouCang(ResponseBody responseBody) {
        try {
            Log.e("hhhh",responseBody.string()+"取消收藏");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
