package com.example.administrator.xinyuan.view.work;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.dainzancontact.DianZanContact;
import com.example.administrator.xinyuan.contact.liwucontact.LiWuContact;
import com.example.administrator.xinyuan.contact.workcontact.workitemcontact.Work_Item_Contact;
import com.example.administrator.xinyuan.contact.workpingluncontact.WorkPinglunContact;
import com.example.administrator.xinyuan.contact.worktijiaopinglun.WorkTiJiaoPingLunContact;
import com.example.administrator.xinyuan.model.entity.LiWuBean;
import com.example.administrator.xinyuan.model.entity.WorkPingLunLieBiaoBean;
import com.example.administrator.xinyuan.model.entity.WorkTiJIaoBean;
import com.example.administrator.xinyuan.model.entity.Work_Item_Bean;
import com.example.administrator.xinyuan.model.entity.Work_ZanShangBean;
import com.example.administrator.xinyuan.presenter.dianzanpresenter.IDianZanPresenter;
import com.example.administrator.xinyuan.presenter.liwupresenter.ILIWuPresenter;
import com.example.administrator.xinyuan.presenter.workpinglunliebiaopresenter.IWorkPingLunLieBiaoPresenter;
import com.example.administrator.xinyuan.presenter.workpresenter.workitempresenter.IWorkItemPresenter;
import com.example.administrator.xinyuan.presenter.worktijiaopinglunpresenter.IWorkTiJiaoPingLunPresenter;
import com.example.administrator.xinyuan.view.work.adapter.LiWuPopAdapter;
import com.example.administrator.xinyuan.view.work.adapter.Work_PingLun_Adapter;
import com.example.administrator.xinyuan.view.work.adapter.Work_ZanShangAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;

import static com.example.administrator.xinyuan.App.context;

public class Work_ItemActivity extends BaseActivity implements Work_Item_Contact.View,WorkPinglunContact.View,WorkTiJiaoPingLunContact.View,LiWuContact.View,DianZanContact.View {


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
    private ImageView work_item_dianzan,work_item_qudianzan;
    private RelativeLayout fudao;
    private ImageView work_check_img2;
    private TextView work_check_name2;
    private TextView work_check_time2;
    private TextView work_recycler_item_peep_price;
    private LinearLayout work_item_touting;
    private RelativeLayout yyy;
    private ImageView work_item_pinglun_img;
    private ListView work_item_pinglun_listview;
    private IWorkPingLunLieBiaoPresenter iWorkPingLunLieBiaoPresenter;
    private Map<String, Object> params,tijiaoparams;
    private  TextView work_more_pinglun,work_dianzan_geshu,work_xiaoxi_geshu;
    private Button work_tijiao_btn;
    private RecyclerView work_zanshang_recy;
    private IWorkTiJiaoPingLunPresenter iWorkTiJiaoPingLunPresenter;
    private Work_PingLun_Adapter work_pingLun_adapter;
    private int id;
    private int replyId;
    private int refId;
    private int id1;
    private View inflater;
    private PopupWindow popupWindow;
    private List<LiWuBean.DataBean.GiftListBean> giftList;
    private IDianZanPresenter iDianZanPresenter;
    private int postion;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_work__item;
    }

    @Override
    protected void init() {
        work_check_img = (ImageView) findViewById(R.id.work_check_img);
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
        work_item_pinglun_img = (ImageView) findViewById(R.id.work_item_pinglun_img);
        work_item_pinglun_listview = (ListView) findViewById(R.id.work_item_pinglun_listview);
        work_more_pinglun= (TextView) findViewById(R.id.work_more_pinglun);
        work_tijiao_btn = (Button) findViewById(R.id.work_tijiao_btn);
        work_item_pinglun = (EditText) findViewById(R.id.work_item_pinglun);
        work_zanshang_recy = (RecyclerView) findViewById(R.id.work_zansang_recy);
        work_item_qudianzan= (ImageView) findViewById(R.id.work_item_qudianzan);
        work_dianzan_geshu = (TextView) findViewById(R.id.work_dianzan_geshu);
        work_xiaoxi_geshu = (TextView) findViewById(R.id.work_xiaoxi_geshu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        work_zanshang_recy.setLayoutManager(linearLayoutManager);



    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        replyId = intent.getIntExtra("replyId", 0);
        refId = intent.getIntExtra("refId", 0);
        params = new HashMap<>();
        params.put("homewokId", id);
        IWorkItemPresenter iWorkItemPresenter = new IWorkItemPresenter(this);
        iWorkItemPresenter.loadData(params);
        iWorkItemPresenter.zanShangLoadData(params);
        iWorkPingLunLieBiaoPresenter = new IWorkPingLunLieBiaoPresenter(this);
        iWorkPingLunLieBiaoPresenter.pinglunData(params);

        tijiaoparams = new HashMap<>();

        SharedPreferences xiaoji = getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        id1 = xiaoji.getInt("id", 0);

        iWorkTiJiaoPingLunPresenter = new IWorkTiJiaoPingLunPresenter(this);
        work_item_pinglun.clearFocus();
        work_item_pinglun.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                work_tijiao_btn.setVisibility(View.VISIBLE);
                work_item_xiaoxi.setVisibility(View.GONE);
                work_item_dianzan.setVisibility(View.GONE);

            }
        });
        work_tijiao_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                work_tijiao_btn.setVisibility(View.GONE);
                work_item_xiaoxi.setVisibility(View.VISIBLE);
                work_item_dianzan.setVisibility(View.VISIBLE);
                String s = work_item_pinglun.getText().toString();
                tijiaoparams.put("userId", id1);
                tijiaoparams.put("content",s );
                tijiaoparams.put("replyId", replyId);
                tijiaoparams.put("refId", refId);
                tijiaoparams.put("refType", "作业评论");
                iWorkTiJiaoPingLunPresenter.tijiaoData(tijiaoparams);
                work_item_pinglun.setText("");
            }
        });

        //listview置顶
        work_item_xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
        iDianZanPresenter = new IDianZanPresenter(this);



        Map<String,Object> params=new HashMap<>();
        params.put("loginUserId",id1);
        ILIWuPresenter iliWuPresenter=new ILIWuPresenter(this);
        iliWuPresenter.liwuLieBiaoData(params);
    }

    @Override
    public void showData(Work_Item_Bean work_item_bean) {
        Work_Item_Bean.DataBean.HomewokBean homewok = work_item_bean.getData().getHomewok();

        Glide.with(this).load(work_item_bean.getData().getHomewok().getPhoto())
                .asBitmap()
                .override(50, 50)
                .into(new BitmapImageViewTarget(work_check_img) {
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
                .override(50, 50)
                .into(new BitmapImageViewTarget(work_check_img2) {
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

    @Override
    public void zanShangshowData(final Work_ZanShangBean work_item_bean) {
        final List<Work_ZanShangBean.DataBean.RewardUserListBean> rewardUserList = work_item_bean.getData().getRewardUserList();

        Work_ZanShangAdapter work_zanShangAdapter = new Work_ZanShangAdapter(rewardUserList,this);
        Log.e("zanShang",work_zanShangAdapter.getItemCount()+"");
        work_zanshang_recy.setAdapter(work_zanShangAdapter);
        int width = work_zanshang_recy.getWidth();
        int height = work_zanshang_recy.getHeight();

        Log.e("aaaaaaaaaaa",width+"");
        Log.e("aaaaaaaaaaa",height+"");
        inflater = LayoutInflater.from(this).inflate(R.layout.work_zanshang_item, null);
     /*   work_zanshang_recy.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
                super.getItemOffsets(outRect, itemPosition, parent);

                if (parent.getChildLayoutPosition(inflater) != (work_item_bean.getData().getRewardUserList().size() - 1)){
                    outRect.right = -30;
                }
            }
        });*/
    }

    public static String longToDate(long lo) {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
        return sd.format(date);
    }




    @Override
    public void showPingLun(WorkPingLunLieBiaoBean workPingLunLieBiaoBean) {
        final List<WorkPingLunLieBiaoBean.DataBean.CommentsBean.ListBean> list = workPingLunLieBiaoBean.getData().getComments().getList();
        work_pingLun_adapter = new Work_PingLun_Adapter(list, this);
        if (workPingLunLieBiaoBean.getData().getComments().getList().size()!=0){
            work_item_pinglun_listview.setVisibility(View.VISIBLE);

            work_item_pinglun_listview.setAdapter(work_pingLun_adapter);
            work_pingLun_adapter.notifyDataSetChanged();
            work_item_pinglun_img.setVisibility(View.GONE);


        }else {
            work_item_pinglun_img.setVisibility(View.VISIBLE);
            work_item_pinglun_listview.setVisibility(View.GONE);
            work_more_pinglun.setVisibility(View.GONE);
        }
        work_item_pinglun_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                work_item_pinglun.clearFocus();
                work_item_pinglun.setText("");
                work_tijiao_btn.setVisibility(View.GONE);
                work_item_xiaoxi.setVisibility(View.VISIBLE);
                work_item_dianzan.setVisibility(View.VISIBLE);
            }
        });
        Intent intent = getIntent();
        postion = intent.getIntExtra("postion", 0);
        params = new HashMap<>();
        params.put("userId",list.get(postion).getUserId());
        params.put("id",list.get(postion).getId());
        SharedPreferences xiaoji =context. getSharedPreferences("xiaoji", Context.MODE_PRIVATE);
        int id1 = xiaoji.getInt("id", 0);
        params.put("loginUserId",id1);
        params.put("type","学生作业" );
        work_dianzan_geshu.setText(list.get(postion).getPraiseNum()+"");
        work_xiaoxi_geshu.setText(list.get(postion).getReplyNum()+"");

        work_item_dianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iDianZanPresenter.loadDianZan(params);
                work_item_qudianzan.setVisibility(View.VISIBLE);
                work_item_dianzan.setVisibility(View.GONE);
                work_dianzan_geshu.setText((list.get(postion).getPraiseNum()+1)+"");
            }
        });
        work_item_qudianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iDianZanPresenter.loadQuDianZan(params);
                work_item_qudianzan.setVisibility(View.GONE);
                work_item_dianzan.setVisibility(View.VISIBLE);
                work_dianzan_geshu.setText((list.get(postion).getPraiseNum())+"");
            }
        });

    }

    @Override
    public void showTiJiao(WorkTiJIaoBean workTiJIaoBean) {
        Log.e("tijiao",workTiJIaoBean.getMessage());
        iWorkPingLunLieBiaoPresenter.pinglunData(params);
        work_pingLun_adapter.notifyDataSetChanged();



    }

    @Override
    public void showLiWuLieBiao(LiWuBean liWuBean) {
        giftList = liWuBean.getData().getGiftList();
        work_check_zansnag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.popup_grant, null);
                //设置布局，给PopupWindow
                popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                //设置其他地方可以点击
                popupWindow.setOutsideTouchable(true);
                //设置背景颜色
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                //设置相对于布局的位置
                popupWindow.showAtLocation(findViewById(R.id.fu), Gravity.BOTTOM, 0, 0);

                //  initView(view);

//获取pop的参数
                RecyclerView popup_recyclerview = (RecyclerView) view.findViewById(R.id.popup_recyclerview);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplication(), 2);
                gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                popup_recyclerview.setLayoutManager(gridLayoutManager);

                TextView  popup_jindou = (TextView) view.findViewById(R.id.popup_jindou);
                LinearLayout   popup_recharge = (LinearLayout) view.findViewById(R.id.popup_recharge);
                popup_recharge.setOnClickListener(this);
                TextView  popup_send = (TextView) view.findViewById(R.id.popup_send);
                popup_send.setOnClickListener(this);


                //  presenter.setPopupGrant(params1, headers);
                LiWuPopAdapter liWuPopAdapter = new LiWuPopAdapter(giftList, getApplication());
                popup_recyclerview.setAdapter(liWuPopAdapter);

            }
        });
    }

    @Override
    public void dianZan(ResponseBody responseBody) {

    }

    @Override
    public void quDianZan(ResponseBody responseBody) {

    }
}
