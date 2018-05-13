package com.example.administrator.xinyuan.view.yugao;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseFragment;
import com.example.administrator.xinyuan.contact.yugaocontact.YuGao_Contact;
import com.example.administrator.xinyuan.model.entity.YuDaoBean;
import com.example.administrator.xinyuan.presenter.yugaopresenter.IYuGaoPresenter;
import com.example.administrator.xinyuan.view.yugao.adapter.YuGao_Adapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class YuGaoFragment extends BaseFragment implements YuGao_Contact.View {
//ccc
private Button data_queding;
    private Button data_chongzhi;
    private EditText end_data;
    private EditText start_data;
    private TextView yugao_shaixuan;
    private PullLoadMoreRecyclerView yugao_recy;
    private Handler han = new Handler();
    private IYuGaoPresenter iYuGaoPresenter;
    private Map<String, Object> params;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yu_gao;
    }

    @Override
    protected void init() {
        yugao_shaixuan = getView().findViewById(R.id.yugao_shaixuan);
        yugao_recy = getView().findViewById(R.id.yugao_recy);

    }
//bbb
    @Override
    protected void loadDate() {
        iYuGaoPresenter=new IYuGaoPresenter(this);
        iYuGaoPresenter.loadData();
        yugao_recy.setLinearLayout();
        yugao_recy.setPullRefreshEnable(true);
        yugao_recy.setPushRefreshEnable(true);
        yugao_recy.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                han.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        iYuGaoPresenter.loadData(params);
                        yugao_recy.setPullLoadMoreCompleted();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {

                yugao_recy.setPullLoadMoreCompleted();
            }
        });
        //时间选择器
        yugao_shaixuan.setOnClickListener(new View.OnClickListener() {


            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.time_shaixuan, null);
                data_queding = inflate.findViewById(R.id.data_queding);
                data_chongzhi = inflate.findViewById(R.id.data_chongzhi);
                start_data = inflate.findViewById(R.id.start_data);
                end_data = inflate.findViewById(R.id.end_data);
                final PopupWindow popupWindow = new PopupWindow(inflate, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT, true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f2f0f0")));
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(getView().findViewById(R.id.yugao_shaixuan), 0, 0, Gravity.CENTER);
                start_data.clearFocus();
                start_data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                start_data.setText(String.format("%d-%d-%d", year, monthOfYear + 1, dayOfMonth));
                            }
                        }, 2000, 1, 2).show();
                    }
                });

                end_data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                end_data.setText( String.format("%d-%d-%d", year, monthOfYear + 1, dayOfMonth));
                            }
                        }, 2000, 1, 2).show();
                    }
                });

                data_chongzhi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        start_data.setText("");
                        end_data.setText("");
                    }
                });
                data_queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        params = new HashMap<>();
                        String trim = start_data.getText().toString().trim();
                        String trim1 = end_data.getText().toString().trim();
                        long timeString = getTimeString(trim);
                        long timeString1 = getTimeString(trim1);
                        params.put("startDate",timeString);
                        params.put("endDate",timeString1);
                       iYuGaoPresenter.loadData(params);
                        popupWindow.dismiss();
                    }
                });

                //DatePickerDialog日历选择器的对话框，监听为OnDateSetListener(){..}
            }
        });

    }



//aaaaaa
    @Override
    public void showData(YuDaoBean yuDaoBean) {
        final List<YuDaoBean.DataBean.ListBean> list = yuDaoBean.getData().getList();
        YuGao_Adapter yuGao_adapter = new YuGao_Adapter(getActivity(), list);
        yugao_recy.setAdapter(yuGao_adapter);
        yuGao_adapter.setOnClickListionItem(new YuGao_Adapter.YuGaoOnClickListion() {
            @Override
            public void setOnClickListion(View view, int postion) {
                Toast.makeText(getContext(), "预告监听", Toast.LENGTH_SHORT).show();
            }
        });
        yuGao_adapter.setOnClickListionItem(new YuGao_Adapter.YuGaoOnClickListion() {
            @Override
            public void setOnClickListion(View view, int postion) {
                int id = list.get(postion).getId();
                Intent intent = new Intent(getContext(), YuGao_ItemActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
    private long getTimeString(String s) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2=null;
        try {
            d2=sdf.parse(s);//将String to Date类型
            System.out.println(d2);

            long t3=d2.getTime();
            return t3;
        } catch (ParseException e) {
            e.printStackTrace();
        }

      return 0;

    }

}
