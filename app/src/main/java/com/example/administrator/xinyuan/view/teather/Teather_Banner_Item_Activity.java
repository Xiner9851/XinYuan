package com.example.administrator.xinyuan.view.teather;

import android.content.Intent;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.teathercontact.teatherbannercontact.TeatherBanner_Contact;
import com.example.administrator.xinyuan.model.entity.Teather_Banner_ItemBean;
import com.example.administrator.xinyuan.presenter.teatherpresenter.teatherbannerpresenter.ITeatherBanner_Presenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Teather_Banner_Item_Activity extends BaseActivity implements TeatherBanner_Contact.View {

    String webUrl = "http://share.univstar.com/view/course.html?courseid=%s";
    private ImageView trather_banner_item_img;
    private TextView teather_banner_item_geshu;
    private TextView yiyuyue;
    private TextView teather_banner_item_time;
    private RelativeLayout again_teacher;
    private RelativeLayout again_bigImg;
    private TextView teather_banner_item_address;
    private TextView teather_banner_item_prices;
    private RelativeLayout yugao_item_xinxi;
    private WebView teather_banner_Item_Content;
    private RelativeLayout again_NameTeacherHead;
    private ImageView teather_banner__back;
    private ImageView teather_banner_share;
    private RadioButton teather_banner_item_btn;
    private RelativeLayout fudao;
    private int idd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_teather__banner__item_;
    }

    @Override
    protected void init() {
        teather_banner__back= (ImageView) findViewById(R.id.teather_banner__back);
        teather_banner_item_geshu= (TextView) findViewById(R.id.teather_banner_item_geshu);
        teather_banner_item_time= (TextView) findViewById(R.id.teather_banner_item_time);
        teather_banner_item_address= (TextView) findViewById(R.id.teather_banner_item_address);
        teather_banner_item_prices= (TextView) findViewById(R.id.teather_banner_item_prices);
        teather_banner_Item_Content= (WebView) findViewById(R.id.teather_banner_Item_Content);
        teather_banner_share= (ImageView) findViewById(R.id.teather_banner_share);
        teather_banner_item_btn= (RadioButton) findViewById(R.id.teather_banner_item_btn);
        trather_banner_item_img= (ImageView) findViewById(R.id.trather_banner_item_img);

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        idd = intent.getIntExtra("id", 0);
        Map<String, Object> params = new HashMap<>();
        params.put("courseId", idd);
        ITeatherBanner_Presenter iTeatherBanner_presenter = new ITeatherBanner_Presenter(this);
        iTeatherBanner_presenter.loadData(params);
    }


    @Override
    public void showData(Teather_Banner_ItemBean teather_banner_itemBean) {
        Glide.with(this).load(teather_banner_itemBean.getData().getCoverImg()).into(trather_banner_item_img);
        Log.e("LLLLL",teather_banner_itemBean.getMessage());
        teather_banner_item_address.setText(teather_banner_itemBean.getData().getAddress());
        teather_banner_item_prices.setText(teather_banner_itemBean.getData().getPrice()+"");
        teather_banner_item_geshu.setText(teather_banner_itemBean.getData().getReservationNum()+"/"+teather_banner_itemBean.getData().getSubscribeNum());
        long startDate = teather_banner_itemBean.getData().getStartDate();
        String s = longToDate(startDate);
        teather_banner_item_time.setText(s);
        //声明WebSettings子类
        WebSettings webSettings = teather_banner_Item_Content.getSettings();

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
       teather_banner_Item_Content.loadUrl(String.format(webUrl,idd ));
    }
    public static String longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }


}
