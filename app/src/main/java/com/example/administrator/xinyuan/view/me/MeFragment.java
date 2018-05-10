package com.example.administrator.xinyuan.view.me;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.model.http.Constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment implements View.OnClickListener{


    private ImageView touxiang;
    private Button zhuce;
    private Button denglu;
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
    private TextView ssss;
    private LinearLayout ddd;
    private ImageView phone;
    private TextView myxinxi;
    private String set="";
    private String mobile;
    private String string;
    private boolean bbb;
    private SharedPreferences preferences;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void init() {
        initView();


    }

    @Override
    protected void loadDate() {
        preferences = getActivity().getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        string = preferences.getString(Constant.UserId, "");
        String mobile = preferences.getString("mobile", "");
        Log.e("mobile",mobile);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.touxiang:
                Intent intent = new Intent(getActivity(),ZhuCeActivity.class);
                startActivity(intent);
                break;
            case R.id.zhuce:
                Intent intent1 = new Intent(getActivity(),ZhuCeActivity.class);
                startActivity(intent1);
                break;
            case R.id.denglu:
                Intent intent2 = new Intent(getActivity(),GoToLoginActivity.class);
                startActivityForResult(intent2,10);

                break;
            case R.id.myxinxi:
                Intent intent3 = new Intent(getActivity(), MyXinXiActivity.class);
                int iad = preferences.getInt("id", 0);
                intent3.putExtra("id",iad);
                startActivity(intent3);
                break;
            case R.id.home_myselft_fragment_setting:
                if(preferences.getBoolean("bbb", false)==false){
                    startActivity(new Intent(getActivity(),ZhuCeActivity.class));
                }else {
                    Intent intent4 = new Intent(getActivity(), SettingActivity.class);
                    intent4.putExtra("mobile",mobile);
                    startActivity(intent4);

                }

                break;
            case R.id.home_myself_fragment_jindou_group:
                Intent intent4 = new Intent(getActivity(), ChongZhiActivity.class);
                startActivity(intent4);
                break;
            case R.id.home_myselft_fragment_tiezi_group:
                Intent intent5 = new Intent(getActivity(), TieZiActivity.class);
                startActivity(intent5);
                break;
            case R.id.home_myselft_fragment_guanzhu_group:
                Intent intent6 = new Intent(getActivity(), GuanZhuActivity.class);
                startActivity(intent6);
                break;
            case R.id.home_myselft_fragment_fensi_group:
                Intent intent7 = new Intent(getActivity(), FensiActivity.class);
                startActivity(intent7);
                break;
            case R.id.home_myself_fragment_selectmajor:
                Intent intent8 = new Intent(getActivity(), MyPianHaoActivity.class);
                startActivity(intent8);
                break;
            case R.id.home_myselft_fragment_message:

                break;
            case R.id.home_myselft_fragment_student_fukuan:
                Intent intent9 = new Intent(getActivity(), DaiActivity.class);
                startActivity(intent9);
                break;
            case R.id.home_myselft_fragment_student_shiyong:
                Intent intentt = new Intent(getActivity(), DaiActivity.class);
                startActivity(intentt);
                break;
            case R.id.home_myselft_fragment_student_tuiguo:
                Intent intentr = new Intent(getActivity(), DaiActivity.class);
                startActivity(intentr);
                break;
            case R.id.home_myselft_fragment_student_dingdan:
                Intent intentd= new Intent(getActivity(), DaiActivity.class);
                startActivity(intentd);
                break;
            case R.id.home_myselft_fragment_havegift_group:

                break;
        }
    }
    private void initView() {
        myxinxi=getView().findViewById(R.id.myxinxi);
        myxinxi.setOnClickListener(this);
        ssss=getView().findViewById(R.id.ssss);
        touxiang=getView().findViewById(R.id.touxiang);
        phone=getView().findViewById(R.id.phone);
        zhuce=getView().findViewById(R.id.zhuce);
        denglu=getView().findViewById(R.id.denglu);
        home_myselft_fragment_message =getView().findViewById(R.id.home_myselft_fragment_message);
        home_myselft_fragment_message_newimg = getView().findViewById(R.id.home_myselft_fragment_message_newimg);
        home_myself_message = getView().findViewById(R.id.home_myself_message);
        home_myselft_fragment_setting = getView().findViewById(R.id.home_myselft_fragment_setting);
        home_myselft_notlogin_img = getView().findViewById(R.id.home_myselft_notlogin_img);
        home_myselft_fragment_nologin_head = getView().findViewById(R.id.home_myselft_fragment_nologin_head);
        home_myself_fragment_username =getView(). findViewById(R.id.home_myself_fragment_username);
        home_myself_fragment_userinfo_group = getView().findViewById(R.id.home_myself_fragment_userinfo_group);
        home_myselft_fragment_livebtn = getView(). findViewById(R.id.home_myselft_fragment_livebtn);
        home_myselft_fragment_login_head = getView(). findViewById(R.id.home_myselft_fragment_login_head);
        home_myselft_fragment_homewokCount_tv = getView().findViewById(R.id.home_myselft_fragment_homewokCount_tv);
        home_myselft_fragment_homewokCount_status =getView(). findViewById(R.id.home_myselft_fragment_homewokCount_status);
        home_myselft_fragment_homewokCount_group = getView().findViewById(R.id.home_myselft_fragment_homewokCount_group);
        home_myselft_fragment_artcircleCount_tv = getView(). findViewById(R.id.home_myselft_fragment_artcircleCount_tv);
        home_myselft_fragment_tiezi_group =getView().findViewById(R.id.home_myselft_fragment_tiezi_group);
        home_myselft_fragment_attentionCount_tv = getView(). findViewById(R.id.home_myselft_fragment_attentionCount_tv);
        home_myselft_fragment_guanzhu_group = getView().findViewById(R.id.home_myselft_fragment_guanzhu_group);
        home_myselft_fragment_fansCount_tv = getView().findViewById(R.id.home_myselft_fragment_fansCount_tv);
        home_myselft_fragment_fensi_group =getView(). findViewById(R.id.home_myselft_fragment_fensi_group);
        home_myselft_fragment_teacher_daizhibo =getView().findViewById(R.id.home_myselft_fragment_teacher_daizhibo);
        home_myselft_fragment_teacher_daizuoye = getView().findViewById(R.id.home_myselft_fragment_teacher_daizuoye);
        home_myselft_fragment_teacher_daifudao =getView().findViewById(R.id.home_myselft_fragment_teacher_daifudao);
        home_myselft_fragment_teacher_jiaoxue = getView().findViewById(R.id.home_myselft_fragment_teacher_jiaoxue);
        home_myselft_fragment_teacher_toolline =getView().findViewById(R.id.home_myselft_fragment_teacher_toolline);
        home_myselft_fragment_student_fukuan = getView().findViewById(R.id.home_myselft_fragment_student_fukuan);
        home_myselft_fragment_student_shiyong =getView().findViewById(R.id.home_myselft_fragment_student_shiyong);
        home_myselft_fragment_student_tuiguo =getView().findViewById(R.id.home_myselft_fragment_student_tuiguo);
        home_myselft_fragment_student_dingdan = getView(). findViewById(R.id.home_myselft_fragment_student_dingdan);
        home_myselft_fragment_student_toolline =getView().findViewById(R.id.home_myselft_fragment_student_toolline);
        home_myself_fragment_jindou_tv = getView().findViewById(R.id.home_myself_fragment_jindou_tv);
        home_myself_fragment_jindou_group = getView(). findViewById(R.id.home_myself_fragment_jindou_group);
        home_myselft_fragment_havegift_group =getView().findViewById(R.id.home_myselft_fragment_havegift_group);
        home_myselft_fragment_favorites =getView().findViewById(R.id.home_myselft_fragment_favorites);
        home_myself_fragment_selectmajor = getView().findViewById(R.id.home_myself_fragment_selectmajor);
        home_myself_fragment_isauth_tv =getView().findViewById(R.id.home_myself_fragment_isauth_tv);
        home_myselft_fragment_approve = getView().findViewById(R.id.home_myselft_fragment_approve);
        home_myselft_fragment_login_body = getView(). findViewById(R.id.home_myselft_fragment_login_body);
        ddd=getView().findViewById(R.id.ddd);
        denglu.setOnClickListener(this);
        zhuce.setOnClickListener(this);
        touxiang.setOnClickListener(this);
        home_myselft_fragment_setting.setOnClickListener(this);
        home_myself_fragment_jindou_group.setOnClickListener(this);
        home_myselft_fragment_havegift_group.setOnClickListener(this);
        home_myselft_fragment_tiezi_group.setOnClickListener(this);
        home_myselft_fragment_guanzhu_group.setOnClickListener(this);
        home_myselft_fragment_fensi_group.setOnClickListener(this);
        home_myself_fragment_selectmajor.setOnClickListener(this);
        home_myselft_fragment_message.setOnClickListener(this);
        home_myselft_fragment_student_fukuan.setOnClickListener(this);
        home_myselft_fragment_student_shiyong.setOnClickListener(this);
        home_myselft_fragment_student_tuiguo.setOnClickListener(this);
        home_myselft_fragment_student_dingdan.setOnClickListener(this);
        home_myselft_fragment_havegift_group.setOnClickListener(this);
    }




    @Override
    public void onResume() {
        super.onResume();
        if(preferences.getBoolean("bbb", false)==false){
            ssss.setVisibility(View.VISIBLE);
            ddd.setVisibility(View.VISIBLE);
            phone.setVisibility(View.GONE);
            home_myselft_fragment_nologin_head.setVisibility(View.VISIBLE);
            home_myselft_fragment_student_toolline.setVisibility(View.GONE);
            home_myselft_fragment_login_body.setVisibility(View.GONE);
        }else{
            ssss.setVisibility(View.GONE);
            ddd.setVisibility(View.GONE);
            phone.setVisibility(View.VISIBLE);
            home_myselft_fragment_nologin_head.setVisibility(View.GONE);
            home_myselft_fragment_student_toolline.setVisibility(View.VISIBLE);
            home_myselft_fragment_login_body.setVisibility(View.VISIBLE);
            String mobile = preferences.getString("mobile", "");
            String aw = preferences.getString("phone", "");
            String name = preferences.getString("name", "");
            Glide.with(getActivity()).load(aw)
                    .asBitmap()
                    .override(50,50)
                    .into(new BitmapImageViewTarget(phone){
                        @Override
                        protected void setResource(Bitmap resource) {
                            super.setResource(resource);
                            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                            roundedBitmapDrawable.setCornerRadius(100);
                            phone.setImageDrawable(roundedBitmapDrawable);
                        }
                    });
            home_myself_fragment_username.setText(name);


        }


    }
}
