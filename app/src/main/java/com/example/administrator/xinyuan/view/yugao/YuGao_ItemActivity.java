package com.example.administrator.xinyuan.view.yugao;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.yugaoitemcontact.YuGao_Item_Contact;
import com.example.administrator.xinyuan.model.entity.YuGao_ItemData;
import com.example.administrator.xinyuan.presenter.yugaoitempresenter.IYuGaoItemPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class YuGao_ItemActivity extends BaseActivity implements YuGao_Item_Contact.View {


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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yu_gao__item;
    }

    @Override
    protected void init() {
        yugao_item_img= (ImageView) findViewById(R.id.yugao_item_img);
        yugao_item_geshu= (TextView) findViewById(R.id.yugao_item_geshu);
        yugao_item_time= (TextView) findViewById(R.id.yugao_item_time);
        yugao_item_address= (TextView) findViewById(R.id.yugao_item_address);
        yugao_item_price= (TextView) findViewById(R.id.yugao_item_prices);
        again_NameTeacherContent= (WebView) findViewById(R.id.again_NameTeacherContent);
        again_back= (ImageView) findViewById(R.id.again_back);

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
    }

    @Override
    public void showData(YuGao_ItemData yuGao_itemData) {
        YuGao_ItemData.DataBean data = yuGao_itemData.getData();
        Glide.with(this).load(data.getCoverImg()).into(yugao_item_img);
        yugao_item_geshu.setText(data.getReservationNum()+"/"+data.getSubscribeNum());
        yugao_item_address.setText(data.getAddress());
        yugao_item_price.setText(data.getPrice()+"");
        long startDate = data.getStartDate();
        String s = longToDate(startDate);

        yugao_item_time.setText(s);

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


    }
    public static String longToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }

}
