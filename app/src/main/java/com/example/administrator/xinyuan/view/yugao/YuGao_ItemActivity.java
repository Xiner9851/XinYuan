package com.example.administrator.xinyuan.view.yugao;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.shoucang.ShouCangContact;
import com.example.administrator.xinyuan.contact.yugaocontact.yugaoitemcontact.YuGao_Item_Contact;
import com.example.administrator.xinyuan.model.entity.YuGao_ItemData;
import com.example.administrator.xinyuan.presenter.shoucangpresenter.IShouCangPresenter;
import com.example.administrator.xinyuan.presenter.yugaopresenter.yugaoitempresenter.IYuGaoItemPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;

public class YuGao_ItemActivity extends BaseActivity implements YuGao_Item_Contact.View,ShouCangContact.View {


    private ImageView yugao_item_img;
    private TextView yugao_item_geshu;
    private TextView yugao_item_time;
    private RelativeLayout again_teacher;
    private RelativeLayout again_bigImg;
    private TextView yugao_item_address;
    private TextView yugao_item_price;
    private WebView again_NameTeacherContent;
    private RelativeLayout again_NameTeacherHead;
    private ImageView again_back;
    private ImageView again_share;
    private RelativeLayout fudao;
    String webUrl = "http://share.univstar.com/view/course.html?courseid=%s";
    private int id;
    private TextView yiyuyue;
    private TextView yugao_item_prices;
    private RelativeLayout yugao_item_xinxi;
    private RadioButton yuyue_btn,yugao_item_shoucang,yugao_item_qushoucang;
    private int price;
    private int id1;
    private IShouCangPresenter iShouCangPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yu_gao__item;
    }

    @Override
    protected void init() {
        yugao_item_img = (ImageView) findViewById(R.id.yugao_item_img);
        yugao_item_geshu = (TextView) findViewById(R.id.yugao_item_geshu);
        yugao_item_time = (TextView) findViewById(R.id.yugao_item_time);
        yugao_item_address = (TextView) findViewById(R.id.yugao_item_address);
        yugao_item_price = (TextView) findViewById(R.id.yugao_item_prices);
        again_NameTeacherContent = (WebView) findViewById(R.id.again_NameTeacherContent);
        again_back = (ImageView) findViewById(R.id.again_back);
        yuyue_btn= (RadioButton) findViewById(R.id.yuyue_item_btn);
        yugao_item_shoucang= (RadioButton) findViewById(R.id.yugao_item_shoucang);
        yugao_item_qushoucang= (RadioButton) findViewById(R.id.yugao_item_qushoucang);


    }
    //aa

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        Map<String, Object> params = new HashMap<>();
        params.put("courseId", id);
        IYuGaoItemPresenter iYuGaoItemPresenter = new IYuGaoItemPresenter(this);
        iYuGaoItemPresenter.loadData(params);
        again_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iShouCangPresenter = new IShouCangPresenter(this);

    }

    @Override
    public void showData(YuGao_ItemData yuGao_itemData) {
        final YuGao_ItemData.DataBean data = yuGao_itemData.getData();
        Glide.with(this).load(data.getCoverImg()).into(yugao_item_img);
        yugao_item_geshu.setText(data.getReservationNum() + "/" + data.getSubscribeNum());
        yugao_item_address.setText(data.getAddress());
        yugao_item_price.setText(data.getPrice() + "");
        long startDate = data.getStartDate();
        String s = longToDate(startDate);

        yugao_item_time.setText(s);
        price = data.getPrice();
        //again_NameTeacherContent.loadUrl(String.format(webUrl,id));
        //again_NameTeacherContent.setWebViewClient(new WebViewClient());
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
        again_NameTeacherContent.loadUrl(String.format(webUrl, id));
        yuyue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplication(), YuYue_Activity.class);
                intent1.putExtra("jiage",price);
                startActivity(intent1);
            }
        });
        SharedPreferences xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        id1 = xiaoji.getInt("id", 0);

        yugao_item_qushoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> params=new HashMap<>();
                params.put("id",data.getId());
                params.put("loginUserId", id1);
                params.put("type","体验课");

                iShouCangPresenter.loadQuShouCang(params);
                yugao_item_shoucang.setVisibility(View.VISIBLE);
                yugao_item_qushoucang.setVisibility(View.GONE);
            }
        });
        yugao_item_shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> params=new HashMap<>();
                params.put("id",data.getId());
                params.put("loginUserId", id1);
                params.put("type","体验课");

                iShouCangPresenter.loadShouCang(params);
                yugao_item_shoucang.setVisibility(View.GONE);
                yugao_item_qushoucang.setVisibility(View.VISIBLE);
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

    }

    @Override
    public void quShouCang(ResponseBody responseBody) {

    }
}
