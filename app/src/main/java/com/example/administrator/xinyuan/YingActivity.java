package com.example.administrator.xinyuan;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.administrator.xinyuan.base.BaseActivity;

public class YingActivity extends BaseActivity {


    private ImageView ying_img;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ying;
    }

    @Override
    protected void init() {
    ying_img= (ImageView) findViewById(R.id.ying_img);

    }

    @Override
    protected void loadData() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.my_ying);
        ying_img.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(YingActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
