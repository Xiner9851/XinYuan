package com.example.administrator.xinyuan.model.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.example.administrator.xinyuan.model.biz.IHuoQuYZMaService;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.entity.TokenBean;
import com.example.administrator.xinyuan.model.url.Urls;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.administrator.xinyuan.App.context;

/**
 * Created by Administrator on 2018/4/7.
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private final Retrofit retrofit;
    private static String s;
    private RetrofitUtils(){
       /* Interceptor interceptor = new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                s = response.header("Set-Cookie");


                return response;
            }
        };*/
        Cache cache = new Cache(context.getCacheDir(), 1024 * 1024 * 10);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor(context))
                .addInterceptor(new ReceivedCookiesInterceptor(context))
                .addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                if (TextUtils.isEmpty(response.cacheControl().toString())) {
                    Response build = response.newBuilder().addHeader("Cache-Control", "max-age=" + 60 * 60 * 60).build();
                    return build;
                }
                return response;
            }
        }).cache(cache).build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Urls.xinyuan_serviceurl)
                .build();

        if(TextUtils.isEmpty(RetrofitUtils.getAppToken(context))){
            RetrofitUtils.loadApptoken(context);
        }
    }
    public static void loadApptoken(final Context context){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(Constant.ConnectTimeout, TimeUnit.SECONDS)
                .readTimeout(Constant.ReadTimeout,TimeUnit.SECONDS)
                .writeTimeout(Constant.WriteTimeout,TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .addInterceptor(new ReceivedCookiesInterceptor(context))
                .addInterceptor(new AddCookiesInterceptor(context))
                .build();

        Retrofit retrofit= new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constant.Root_url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        retrofit.create(XinYuanService.class)
                .tokenValue()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TokenBean>() {
                    @Override
                    public void accept(TokenBean tokenBean) throws Exception {
                        if(tokenBean==null||tokenBean.getData()==null){
                            return;
                        }

                        String apptoken = tokenBean.getData().getApptoken();

                        long time = System.currentTimeMillis();

                        try {
                            String desApptoken= EncryptUtil.decrypt(apptoken);

                            String headerApptoken=EncryptUtil.encrypt(time + desApptoken).replaceAll("\\n","").toUpperCase();

                            RetrofitUtils.saveAppToken(context,headerApptoken,time);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

    }


    public static RetrofitUtils getInstence(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }
    public static String getDateToString(long time) {
        Date d = new Date(time);
        return new SimpleDateFormat("MM-dd HH:mm").format(d);
    }

    public static boolean isLogin(Context context){

        if(context==null){
            return false ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);

        //TODO测试id
        return !TextUtils.isEmpty(sharedPreferences.getString(Constant.UserId, ""));
    }


    public static Integer getUserId(Context context){

        if(context==null){
            return 0 ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);

        String id = sharedPreferences.getString(Constant.UserId, "");
        if(TextUtils.isEmpty(id)){
            return 0;
        }

        Integer idInteger= Integer.parseInt(id);

        //TODU测试id
        return idInteger;

    }

    public static String getAppToken(Context context){

        if(context==null){
            return "" ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);

        String apptoken = sharedPreferences.getString(Constant.AppToken, "");
        if(TextUtils.isEmpty(apptoken)){
            return "";
        }

        //TODU测试id
        return apptoken;

    }


    public static void saveId(Context context,String id){
        if(context==null){
            return ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.UserId, id);
        editor.commit();

    }

    public static void saveToken(Context context,String token){
        if(context==null){
            return ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.CookieName,token);
        editor.commit();

    }

    public static void saveAppToken(Context context,String token ,long time){
        if(context==null){
            return ;
        }

        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(Constant.CookieSP, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.AppToken,token+"."+time);
        editor.commit();

    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
    public XinYuanService getLoadDate(){

        return retrofit.create(XinYuanService.class);
    }
    public static String getJSESSIONID(){
        return s;
    }
    public IHuoQuYZMaService getIHuoQuYZMaService(){
        return retrofit.create(IHuoQuYZMaService.class);
    }
}
