package com.example.administrator.xinyuan.view.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.xinyuan.R;

public class MySelfActivity extends AppCompatActivity {


    private ImageView home_myselft_fragment_message;
    private ImageView home_myselft_fragment_message_newimg;
    private RelativeLayout home_myself_message;
    private ImageView home_myselft_fragment_setting;
    private ImageView home_myselft_notlogin_img;
    private RelativeLayout home_myselft_fragment_nologin_head;
    private TextView home_myself_fragment_username;
    private LinearLayout home_myself_fragment_userinfo_group;
    private LinearLayout home_myselft_fragment_livebtn;
    private RelativeLayout home_myselft_fragment_login_head;
    private TextView home_myselft_fragment_homewokCount_tv;
    private TextView home_myselft_fragment_homewokCount_status;
    private LinearLayout home_myselft_fragment_homewokCount_group;
    private TextView home_myselft_fragment_artcircleCount_tv;
    private LinearLayout home_myselft_fragment_tiezi_group;
    private TextView home_myselft_fragment_attentionCount_tv;
    private LinearLayout home_myselft_fragment_guanzhu_group;
    private TextView home_myselft_fragment_fansCount_tv;
    private LinearLayout home_myselft_fragment_fensi_group;
    private LinearLayout home_myselft_fragment_teacher_daizhibo;
    private LinearLayout home_myselft_fragment_teacher_daizuoye;
    private LinearLayout home_myselft_fragment_teacher_daifudao;
    private LinearLayout home_myselft_fragment_teacher_jiaoxue;
    private LinearLayout home_myselft_fragment_teacher_toolline;
    private LinearLayout home_myselft_fragment_student_fukuan;
    private LinearLayout home_myselft_fragment_student_shiyong;
    private LinearLayout home_myselft_fragment_student_tuiguo;
    private LinearLayout home_myselft_fragment_student_dingdan;
    private LinearLayout home_myselft_fragment_student_toolline;
    private TextView home_myself_fragment_jindou_tv;
    private RelativeLayout home_myself_fragment_jindou_group;
    private RelativeLayout home_myselft_fragment_havegift_group;
    private RelativeLayout home_myselft_fragment_favorites;
    private RelativeLayout home_myself_fragment_selectmajor;
    private TextView home_myself_fragment_isauth_tv;
    private RelativeLayout home_myselft_fragment_approve;
    private LinearLayout home_myselft_fragment_login_body;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_self);
        initView();
    }

    private void initView() {
        home_myselft_fragment_message = (ImageView) findViewById(R.id.home_myselft_fragment_message);
        home_myselft_fragment_message_newimg = (ImageView) findViewById(R.id.home_myselft_fragment_message_newimg);
        home_myself_message = (RelativeLayout) findViewById(R.id.home_myself_message);
        home_myselft_fragment_setting = (ImageView) findViewById(R.id.home_myselft_fragment_setting);
        home_myselft_notlogin_img = (ImageView) findViewById(R.id.home_myselft_notlogin_img);
        home_myselft_fragment_nologin_head = (RelativeLayout) findViewById(R.id.home_myselft_fragment_nologin_head);
        home_myself_fragment_username = (TextView) findViewById(R.id.home_myself_fragment_username);
        home_myself_fragment_userinfo_group = (LinearLayout) findViewById(R.id.home_myself_fragment_userinfo_group);
        home_myselft_fragment_livebtn = (LinearLayout) findViewById(R.id.home_myselft_fragment_livebtn);
        home_myselft_fragment_login_head = (RelativeLayout) findViewById(R.id.home_myselft_fragment_login_head);
        home_myselft_fragment_homewokCount_tv = (TextView) findViewById(R.id.home_myselft_fragment_homewokCount_tv);
        home_myselft_fragment_homewokCount_status = (TextView) findViewById(R.id.home_myselft_fragment_homewokCount_status);
        home_myselft_fragment_homewokCount_group = (LinearLayout) findViewById(R.id.home_myselft_fragment_homewokCount_group);
        home_myselft_fragment_artcircleCount_tv = (TextView) findViewById(R.id.home_myselft_fragment_artcircleCount_tv);
        home_myselft_fragment_tiezi_group = (LinearLayout) findViewById(R.id.home_myselft_fragment_tiezi_group);
        home_myselft_fragment_attentionCount_tv = (TextView) findViewById(R.id.home_myselft_fragment_attentionCount_tv);
        home_myselft_fragment_guanzhu_group = (LinearLayout) findViewById(R.id.home_myselft_fragment_guanzhu_group);
        home_myselft_fragment_fansCount_tv = (TextView) findViewById(R.id.home_myselft_fragment_fansCount_tv);
        home_myselft_fragment_fensi_group = (LinearLayout) findViewById(R.id.home_myselft_fragment_fensi_group);
        home_myselft_fragment_teacher_daizhibo = (LinearLayout) findViewById(R.id.home_myselft_fragment_teacher_daizhibo);
        home_myselft_fragment_teacher_daizuoye = (LinearLayout) findViewById(R.id.home_myselft_fragment_teacher_daizuoye);
        home_myselft_fragment_teacher_daifudao = (LinearLayout) findViewById(R.id.home_myselft_fragment_teacher_daifudao);
        home_myselft_fragment_teacher_jiaoxue = (LinearLayout) findViewById(R.id.home_myselft_fragment_teacher_jiaoxue);
        home_myselft_fragment_teacher_toolline = (LinearLayout) findViewById(R.id.home_myselft_fragment_teacher_toolline);
        home_myselft_fragment_student_fukuan = (LinearLayout) findViewById(R.id.home_myselft_fragment_student_fukuan);
        home_myselft_fragment_student_shiyong = (LinearLayout) findViewById(R.id.home_myselft_fragment_student_shiyong);
        home_myselft_fragment_student_tuiguo = (LinearLayout) findViewById(R.id.home_myselft_fragment_student_tuiguo);
        home_myselft_fragment_student_dingdan = (LinearLayout) findViewById(R.id.home_myselft_fragment_student_dingdan);
        home_myselft_fragment_student_toolline = (LinearLayout) findViewById(R.id.home_myselft_fragment_student_toolline);
        home_myself_fragment_jindou_tv = (TextView) findViewById(R.id.home_myself_fragment_jindou_tv);
        home_myself_fragment_jindou_group = (RelativeLayout) findViewById(R.id.home_myself_fragment_jindou_group);
        home_myselft_fragment_havegift_group = (RelativeLayout) findViewById(R.id.home_myselft_fragment_havegift_group);
        home_myselft_fragment_favorites = (RelativeLayout) findViewById(R.id.home_myselft_fragment_favorites);
        home_myself_fragment_selectmajor = (RelativeLayout) findViewById(R.id.home_myself_fragment_selectmajor);
        home_myself_fragment_isauth_tv = (TextView) findViewById(R.id.home_myself_fragment_isauth_tv);
        home_myselft_fragment_approve = (RelativeLayout) findViewById(R.id.home_myselft_fragment_approve);
        home_myselft_fragment_login_body = (LinearLayout) findViewById(R.id.home_myselft_fragment_login_body);
    }
}
