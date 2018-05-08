package com.example.administrator.xinyuan.view.me;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xinyuan.R;
import com.example.administrator.xinyuan.base.BaseActivity;
import com.example.administrator.xinyuan.contact.IHuoQuYZMaContact;
import com.example.administrator.xinyuan.model.entity.LoginBean;
import com.example.administrator.xinyuan.model.entity.UapateBean;
import com.example.administrator.xinyuan.model.entity.WangChengBean;
import com.example.administrator.xinyuan.presenter.HuoQuMaPresenter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WanSanXinXiActivity extends BaseActivity implements View.OnClickListener, IHuoQuYZMaContact.View {
    public static final int CROP_PHOTO = 2;
    public static final int PHOTO_REQUEST_CAREMA = 1;// 拍照
    private ImageView quxiao;
    private ImageView touxiang;
    private EditText name;
    private ImageView qingkong;
    private TextView textView;
    private RelativeLayout mReLayout;
    private TextView textView1;
    private RelativeLayout mReLayout2;
    private EditText password;
    private ImageView qingkong1;
    private ImageView Paizhao;
    private Button wangcheng;
    private String sex = "";
    private HuoQuMaPresenter huoQuMaPresenter;
    private String tel;
    private ImageView paizhao;
    public static File tempFile;
    private Uri imageUri;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private String stringPhoto;
    //相机拍摄的头像文件(本次演示存放在SD卡根目录下)


    @Override
    protected int getLayoutId() {
        return R.layout.activity_wan_san_xin_xi;


    }

    @Override
    protected void init() {
        quxiao = (ImageView) findViewById(R.id.quxiao);
        touxiang = (ImageView) findViewById(R.id.touxiang);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        qingkong = (ImageView) findViewById(R.id.qingkong);
        qingkong1 = (ImageView) findViewById(R.id.qingkong1);
        mReLayout = (RelativeLayout) findViewById(R.id.mReLayout);
        mReLayout2 = (RelativeLayout) findViewById(R.id.mReLayout2);
        wangcheng = (Button) findViewById(R.id.wangcheng);
        textView = (TextView) findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView1);
        paizhao = (ImageView) findViewById(R.id.paizhao);

        paizhao.setOnClickListener(this);

        touxiang.setOnClickListener(this);
        wangcheng.setOnClickListener(this);
        quxiao.setOnClickListener(this);
        mReLayout.setOnClickListener(this);
        mReLayout2.setOnClickListener(this);

    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        tel = intent.getStringExtra("tel");
        huoQuMaPresenter = new HuoQuMaPresenter(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.quxiao:
                finish();
                break;
            case R.id.mReLayout:

                textView.setTextColor(Color.parseColor("#4b76e4"));
                textView1.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.mReLayout2:

                textView.setTextColor(Color.parseColor("#000000"));
                textView1.setTextColor(Color.parseColor("#e6218d"));
                break;
            case R.id.wangcheng:
                Bitmap bm = ((BitmapDrawable) ((ImageView) touxiang).getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte bytes[] = baos.toByteArray();
                stringPhoto = Base64.encodeToString(bytes, Base64.DEFAULT);

                huoQuMaPresenter.wangCheng(name.getText().toString(), "", stringPhoto, tel, password.getText().toString());

                break;
            case R.id.touxiang:

                break;
            case R.id.paizhao:
                openCamera(this);
                break;
        }
    }


    @Override
    public void loadMa(String a) {

    }

    @Override
    public void zhuCe(String s) {

    }

    @Override
    public void wangCheng(WangChengBean wangChengBean) {
        if (wangChengBean.getMessage().equals("成功")) {
            Intent intent = new Intent(this, SetPianHaoActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "不对", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void login(LoginBean loginBean) {

    }

    @Override
    public void findPass(String s) {

    }

    @Override
    public void findPassNext(UapateBean uapateBean) {

    }

    public void openCamera(Activity activity) {
        //獲取系統版本
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        // 激活相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            SimpleDateFormat timeStampFormat = new SimpleDateFormat(
                    "yyyy_MM_dd_HH_mm_ss");
            String filename = timeStampFormat.format(new Date());
            tempFile = new File(Environment.getExternalStorageDirectory(),
                    filename + ".jpg");
            if (currentapiVersion < 24) {
                // 从文件中创建uri
                imageUri = Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            } else {
                //兼容android7.0 使用共享文件的形式
                ContentValues contentValues = new ContentValues(1);
                contentValues.put(MediaStore.Images.Media.DATA, tempFile.getAbsolutePath());
                //检查是否有存储权限，以免崩溃
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    Toast.makeText(this, "请开启存储权限", Toast.LENGTH_SHORT).show();
                    return;
                }
                imageUri = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            }
        }
        if (checkPermission(WanSanXinXiActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            //获取权限后的操作。读取文件
            // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CAREMA
            activity.startActivityForResult(intent, PHOTO_REQUEST_CAREMA);
        } else {
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }

    }

    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    private boolean checkPermission(Context context, String permission) {
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(context, permission);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PHOTO_REQUEST_CAREMA:
                if (resultCode == RESULT_OK) {
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, CROP_PHOTO); // 启动裁剪程序
                }
                break;
            case CROP_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        touxiang.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //得到了授权
                    Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                } else {
                    //未授权
                    Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
