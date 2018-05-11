package com.example.administrator.xinyuan.view.teather;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.View;
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
import com.example.administrator.xinyuan.contact.teathercontact.zhaoteatheritemcontact.ZhaoTeatherItem_Contact;
import com.example.administrator.xinyuan.model.entity.ZhaoTeatherItemBean;
import com.example.administrator.xinyuan.presenter.teatherpresenter.zhaoteatheritempresenter.IZhaoTheatherItemPresenter;

import java.util.HashMap;
import java.util.Map;

import static com.example.administrator.xinyuan.App.context;

public class ZhaoTeather_ItemCheck_Activity extends BaseActivity implements ZhaoTeatherItem_Contact.View {


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
    private TextView again_NameteacherHead_teacherCourseNum;
    private RelativeLayout course;
    private TextView again_NameteacherHead_teacherWorkNum;
    private TextView again_NameteacherHead_teacherCoachNum;
    private TextView again_NameteacherHead_teacherInvitationNum;
    private TextView again_NameteacherHead_teacherConcernNum;
    private TextView again_NameteacherHead_teacherFSNum;
    private LinearLayout aaa;
    private RelativeLayout again_NameTeacherHead2;
    private RelativeLayout again_Rela;
    private TextView again_NameTeacherContent;
    private RelativeLayout again_NameTeacherHead;
    private ImageView again_back;
    private ImageView again_share;
    private RelativeLayout fudao;
    private RelativeLayout teather_work;
    private RelativeLayout teather_fudao;
    private RelativeLayout tianzi;
    private TextView again_NameteacherHead_teacherConcernNum1;
    private RelativeLayout guanzhu;
    private RelativeLayout fengsi;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhao_teather__item_check_;
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
        again_NameteacherHead_teacherCourseNum = (TextView) findViewById(R.id.again_NameteacherHead_teacherCourseNum);
        again_NameteacherHead_teacherWorkNum = (TextView) findViewById(R.id.again_NameteacherHead_teacherWorkNum);
        again_NameteacherHead_teacherCoachNum = (TextView) findViewById(R.id.again_NameteacherHead_teacherCoachNum);
        again_NameteacherHead_teacherInvitationNum = (TextView) findViewById(R.id.again_NameteacherHead_teacherInvitationNum);
        again_NameteacherHead_teacherConcernNum = (TextView) findViewById(R.id.again_NameteacherHead_teacherConcernNum1);
        again_NameteacherHead_teacherFSNum = (TextView) findViewById(R.id.again_NameteacherHead_teacherFSNum);
        again_NameTeacherContent = (TextView) findViewById(R.id.again_NameTeacherContent);
        again_back = (ImageView) findViewById(R.id.again_back);
        again_share = (ImageView) findViewById(R.id.again_share);
        course = (RelativeLayout) findViewById(R.id.course);
        guanzhu= (RelativeLayout) findViewById(R.id.guanzhu);
        teather_fudao= (RelativeLayout) findViewById(R.id.teather_fudao);
        fengsi= (RelativeLayout) findViewById(R.id.fengsi);
        tianzi= (RelativeLayout) findViewById(R.id.tianzi);
        teather_work= (RelativeLayout) findViewById(R.id.teather_work);
    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Map<String, Object> params = new HashMap<>();
        params.put("teacherId", id);
        IZhaoTheatherItemPresenter iZhaoTheatherItemPresenter = new IZhaoTheatherItemPresenter(this);
        iZhaoTheatherItemPresenter.loadData(params);
        again_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void showData(ZhaoTeatherItemBean zhaoTeatherItemBean) {
        Log.e("DDDDDDDDDDDD", zhaoTeatherItemBean.getMessage());
        final ZhaoTeatherItemBean.DataBean.UserBean user = zhaoTeatherItemBean.getData().getUser();

        Glide.with(this).load(user.getImages()).into(again_img);
        again_teacherlabel.setText(user.getSkilled());
        again_teacherHead_NameteacherTitle.setText(user.getIntro());
        again_teacherzan.setText(zhaoTeatherItemBean.getData().getPraise().getPraiseCount() + "");
        Glide.with(this).load(user.getPhoto())
                .asBitmap()
                .override(50, 50)
                .into(new BitmapImageViewTarget(again_NameteacherHead_teacherImg) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCornerRadius(100);
                        again_NameteacherHead_teacherImg.setImageDrawable(drawable);
                    }
                });
        int userType = user.getUserType();
        if (userType == 4) {
            again_NameteacherHead_teacherVipImg.setImageResource(R.mipmap.home_level_vip_red);
        } else if (userType == 3) {
            again_NameteacherHead_teacherVipImg.setImageResource(R.mipmap.home_level_vip_yellow);
        } else if (userType == 2) {
            again_NameteacherHead_teacherVipImg.setImageResource(R.mipmap.home_level_vip_blue);
        }
        again_NameteacherHead_teacherName.setText(user.getNickname());
        //again_NameteacherHead_teacherImg.setTag(user.getIntro());
        again_NameteacherHead_teacherCourseNum.setText(zhaoTeatherItemBean.getData().getLiveCount() + "");
        again_NameteacherHead_teacherWorkNum.setText(zhaoTeatherItemBean.getData().getHomewokPublishCount() + "");
        again_NameteacherHead_teacherCoachNum.setText(zhaoTeatherItemBean.getData().getCoachingCount() + "");
        again_NameteacherHead_teacherInvitationNum.setText(zhaoTeatherItemBean.getData().getPostsCount() + "");
        again_NameteacherHead_teacherConcernNum.setText(zhaoTeatherItemBean.getData().getAttentionCount() + "");
        again_NameteacherHead_teacherFSNum.setText(zhaoTeatherItemBean.getData().getFansCount() + "");
        again_NameTeacherContent.setText(zhaoTeatherItemBean.getData().getUser().getDetails());
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),ZhaoTeather_KeCheng_Activity.class);
                intent.putExtra("id",user.get_$Id141());
                intent.putExtra("name",user.getNickname());
                startActivity(intent);
            }
        });
        fengsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplication(),ZhaoTeather_FenSiActivity.class);
                intent1.putExtra("idd",user.get_$Id141());
                intent1.putExtra("namee",user.getNickname());
                startActivity(intent1);
            }
        });
    }



}