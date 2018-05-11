package com.example.administrator.xinyuan.view.work;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.workcontact.workitemcontact.Work_Item_Contact;
import com.example.administrator.xinyuan.model.entity.Work_Item_Bean;
import com.example.administrator.xinyuan.presenter.workpresenter.workitempresenter.IWorkItemPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.administrator.xinyuan.App.context;

public class Work_ItemActivity extends BaseActivity implements Work_Item_Contact.View {


    private ImageView work_check_img;
    private TextView work_check_name;
    private TextView work_check_time;
    private TextView work_laixing;
    private RelativeLayout qqq;
    private TextView work_check_title;
    private TextView work_check_content;
    private ImageView work_check_path;
    private TextView work_check_biaoqian;
    private LinearLayout rrr;
    private TextView ttt;
    private Button work_check_zansnag;
    private TextView ggg;
    private TextView one_title;
    private RelativeLayout aaa;
    private ImageView work_again_back;
    private EditText work_item_pinglun;
    private ImageView work_item_xiaoxi;
    private ImageView work_item_dianzan;
    private RelativeLayout fudao;
    private ImageView work_check_img2;
    private TextView work_check_name2;
    private TextView work_check_time2;
    private TextView work_recycler_item_peep_price;
    private LinearLayout work_item_touting;
    private RelativeLayout yyy;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work__item;
    }

    @Override
    protected void init() {
        work_check_img= (ImageView) findViewById(R.id.work_check_img);
        work_again_back = (ImageView) findViewById(R.id.work_again_back);
        work_check_name = (TextView) findViewById(R.id.work_check_name);
        work_check_time = (TextView) findViewById(R.id.work_check_time);
        work_laixing = (TextView) findViewById(R.id.work_laixing);
        work_check_title = (TextView) findViewById(R.id.work_check_title);
        work_check_content = (TextView) findViewById(R.id.work_check_content);
        work_check_path = (ImageView) findViewById(R.id.work_check_path);
        work_check_biaoqian = (TextView) findViewById(R.id.work_check_biaoqian);
        work_check_zansnag = (Button) findViewById(R.id.work_check_zansnag);
        work_item_pinglun = (EditText) findViewById(R.id.work_item_pinglun);
        work_item_xiaoxi = (ImageView) findViewById(R.id.work_item_xiaoxi);
        work_item_dianzan = (ImageView) findViewById(R.id.work_item_dianzan);
        work_check_img2 = (ImageView) findViewById(R.id.work_check_img2);
        work_check_name2 = (TextView) findViewById(R.id.work_check_name2);
        work_check_time2 = (TextView) findViewById(R.id.work_check_time2);
        work_item_touting = (LinearLayout) findViewById(R.id.work_item_touting);


    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        Map<String, Object> params = new HashMap<>();
        params.put("homewokId", id);
        IWorkItemPresenter iWorkItemPresenter = new IWorkItemPresenter(this);
        iWorkItemPresenter.loadData(params);
    }

    @Override
    public void showData(Work_Item_Bean work_item_bean) {
        Work_Item_Bean.DataBean.HomewokBean homewok = work_item_bean.getData().getHomewok();

        Glide.with(this).load(work_item_bean.getData().getHomewok().getPhoto())
                .asBitmap()
                .override(50,50)
                .into(new BitmapImageViewTarget(work_check_img){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCornerRadius(100);
                        work_check_img.setImageDrawable(drawable);
                    }
                });
        work_check_name.setText(homewok.getNickname());
        long createDate = homewok.getCreateDate();
        String s = longToDate(createDate);
        work_check_time.setText(s);
        work_laixing.setText(homewok.getSource());
        work_check_title.setText(homewok.getContent());
        Glide.with(this).load(work_item_bean.getData().getHomewok().getPath()).into(work_check_path);
        Glide.with(this).load(work_item_bean.getData().getHomewok().getTPhoto())
                .asBitmap()
                .override(50,50)
                .into(new BitmapImageViewTarget(work_check_img2){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCornerRadius(100);
                        work_check_img2.setImageDrawable(drawable);
                    }
                });
        work_check_name2.setText(homewok.getTRealname());
        work_check_time2.setText(homewok.getTIntro());


    }
    public static String longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }


}
