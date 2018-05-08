package com.example.administrator.xinyuan.view.me;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IMeMyXinXiContact;
import com.example.administrator.xinyuan.model.entity.MeMyXinXiBean;
import com.example.administrator.xinyuan.presenter.MeMyXinXiPresent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyXinXiActivity extends BaseActivity implements IMeMyXinXiContact.View ,View.OnClickListener{

    private MeMyXinXiPresent meMyXinXiPresent;
    private TextView userinfo_aty_title_cancle;
    private ImageView userinfo_aty_userimg;
    private RelativeLayout userinfo_aty_userimg_group;
    private TextView userinfo_aty_changename_tv;
    private RelativeLayout userinfo_aty_changename;
    private TextView userinfo_aty_changensex_tv;
    private RelativeLayout userinfo_aty_changesex;
    private TextView userinfo_aty_changenaddress_tv;
    private RelativeLayout userinfo_aty_changcity;
    private TextView userinfo_aty_changenbirthday_tv;
    private RelativeLayout userinfo_aty_changenbirthday;
    private ImageView userinfo_aty_changeteacherimg;
    private TextView userinfo_aty_changetitle;
    private RelativeLayout userinfo_aty_changetitle_group;
    private TextView userinfo_detail_tv;
    private TextView userinfo_aty_changedetails;
    private RelativeLayout userinfo_aty_changedetails_group;
    private LinearLayout userinfo_aty_teacherstatus_group;
    private int yea;
    private int yue;
    private int day;
    private  int sex=0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_xin_xi;
    }

    @Override
    protected void init() {
        Calendar instance = Calendar.getInstance();
        yea = instance.get(Calendar.YEAR);
        yue = instance.get(Calendar.MONTH);
        day = instance.get(Calendar.DAY_OF_MONTH);
        meMyXinXiPresent = new MeMyXinXiPresent(this);
        userinfo_aty_title_cancle= (TextView) findViewById(R.id.userinfo_aty_title_cancle);
        userinfo_aty_title_cancle.setOnClickListener(this);
        //头像
        userinfo_aty_userimg= (ImageView) findViewById(R.id.userinfo_aty_userimg);
        userinfo_aty_userimg_group= (RelativeLayout) findViewById(R.id.userinfo_aty_userimg_group);
        userinfo_aty_userimg_group.setOnClickListener(this);

        //昵称
        userinfo_aty_changename_tv= (TextView) findViewById(R.id.userinfo_aty_changename_tv);
        userinfo_aty_changename= (RelativeLayout) findViewById(R.id.userinfo_aty_changename);
        userinfo_aty_changename.setOnClickListener(this);

        //性别
        userinfo_aty_changensex_tv= (TextView) findViewById(R.id.userinfo_aty_changensex_tv);
        userinfo_aty_changesex= (RelativeLayout) findViewById(R.id.userinfo_aty_changesex);
        userinfo_aty_changesex.setOnClickListener(this);
        //地区
        userinfo_aty_changenaddress_tv= (TextView) findViewById(R.id.userinfo_aty_changenaddress_tv);
        userinfo_aty_changcity= (RelativeLayout) findViewById(R.id.userinfo_aty_changcity);
        userinfo_aty_changcity.setOnClickListener(this);

        //生日
        userinfo_aty_changenbirthday_tv= (TextView) findViewById(R.id.userinfo_aty_changenbirthday_tv);
        userinfo_aty_changenbirthday= (RelativeLayout) findViewById(R.id.userinfo_aty_changenbirthday);
        userinfo_aty_changenbirthday.setOnClickListener(this);

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Log.e("id", id + "");
        meMyXinXiPresent.loadMyXinXi(id);
    }

    @Override
    public void showXinXi(MeMyXinXiBean.DataBean data) {
        Log.e("aaaa", data.toString());
        String photo = data.getPhoto();
        Glide.with(this).load(photo).asBitmap().into(userinfo_aty_userimg);
        userinfo_aty_changename_tv.setText(data.getNickname());


        int aa = data.getSex();
        Log.e("akja",aa+"");
        if(aa==0){
            userinfo_aty_changensex_tv.setText("男");
            sex=0;
        }else if(aa==1){
            userinfo_aty_changensex_tv.setText("女");
            //sdfsf
            sex=1;
        }
        String address = (String) data.getAddress();
        userinfo_aty_changenaddress_tv.setText(address);
        Long birthday = data.getBirthday();
        Log.e("afa",birthday+"");
        Date date = new Date(birthday);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        String format = simpleDateFormat.format(date);
        userinfo_aty_changenbirthday_tv.setText(format);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.userinfo_aty_title_cancle:
                finish();
                break;
            case R.id.userinfo_aty_userimg_group:

                break;
            case R.id.userinfo_aty_changename:

                break;
            case R.id.userinfo_aty_changesex:
                final String[] items = new String[] { "男","女" };

                AlertDialog dialog = new AlertDialog.Builder(this).setTitle("请选择")
                        .setItems(items, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sex = which;
                                userinfo_aty_changensex_tv.setText(items[which]);

                            }
                        }).create();
                dialog.show();
                break;
            case R.id.userinfo_aty_changcity:

                break;
            case R.id.userinfo_aty_changenbirthday:
                new DatePickerDialog(MyXinXiActivity.this, onDateSetListener, yea, yue, day).show();
                break;
        }
    }
    /**
     * 日期选择器对话框监听
     */
    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            yea = year;
            yue = monthOfYear;
            day = dayOfMonth;
            String days;
            if (yue + 1 < 10) {
                if (day < 10) {
                    days = new StringBuffer().append(yea).append("年").append("0").
                            append(yue + 1).append("月").append("0").append(dayOfMonth).append("日").toString();
                } else {
                    days = new StringBuffer().append(yea).append("年").append("0").
                            append(yue + 1).append("月").append(day).append("日").toString();
                }

            } else {
                if (day < 10) {
                    days = new StringBuffer().append(yea).append("年").
                            append(yue + 1).append("月").append("0").append(day).append("日").toString();
                } else {
                    days = new StringBuffer().append(yea).append("年").
                            append(yue + 1).append("月").append(day).append("日").toString();
                }

            }
            userinfo_aty_changenbirthday_tv.setText(days);
        }
    };
}
