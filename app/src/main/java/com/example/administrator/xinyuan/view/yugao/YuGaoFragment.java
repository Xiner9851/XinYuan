package com.example.administrator.xinyuan.view.yugao;


import android.app.DatePickerDialog;
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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class YuGaoFragment extends BaseFragment implements YuGao_Contact.View {


    private TextView yugao_shaixuan;
    private PullLoadMoreRecyclerView yugao_recy;
    private Handler han = new Handler();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yu_gao;
    }

    @Override
    protected void init() {
        yugao_shaixuan = getView().findViewById(R.id.yugao_shaixuan);
        yugao_recy = getView().findViewById(R.id.yugao_recy);

    }

    @Override
    protected void loadDate() {
        final IYuGaoPresenter iYuGaoPresenter = new IYuGaoPresenter(this);
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
                        iYuGaoPresenter.loadData();
                        yugao_recy.setPullLoadMoreCompleted();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {

                yugao_recy.setPullLoadMoreCompleted();
            }
        });
        yugao_shaixuan.setOnClickListener(new View.OnClickListener() {
            private Button data_queding;
            private Button data_chongzhi;
            private EditText end_data;
            private EditText start_data;

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

                end_data.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

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
                        popupWindow.dismiss();
                    }
                });

                //DatePickerDialog日历选择器的对话框，监听为OnDateSetListener(){..}
            }
        });
    }




    @Override
    public void showData(YuDaoBean yuDaoBean) {
        List<YuDaoBean.DataBean.ListBean> list = yuDaoBean.getData().getList();
        YuGao_Adapter yuGao_adapter = new YuGao_Adapter(getActivity(), list);
        yugao_recy.setAdapter(yuGao_adapter);
        yuGao_adapter.setOnClickListionItem(new YuGao_Adapter.YuGaoOnClickListion() {
            @Override
            public void setOnClickListion(View view, int postion) {
                Toast.makeText(getContext(), "预告监听", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
