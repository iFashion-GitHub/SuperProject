package com.youneng.x5app.base;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import com.youneng.x5app.utils.WebUtil;


public class AppApplication extends Application {
    private static final String TAG= "WatchDog";

    @Override
    public void onCreate() {
        super.onCreate();
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        initX5();
    }

    private void initX5(){
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                Log.d(TAG, " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                Log.d(TAG, " onCoreInitFinished ");
            }
        };

        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {
                Log.d(TAG, "onDownloadFinish: "+i);
            }

            @Override
            public void onInstallFinish(int i) {
                Log.d(TAG, "onInstallFinish: "+i);
            }

            @Override
            public void onDownloadProgress(int i) {
                Log.d(TAG, "onDownloadProgress: "+i);
            }
        });
        //x5内核初始化接口，调用preInit接口会导致initX5Enrironment中传入的callback无效。不要调用其他无关接口。
        //静态加载
        WebUtil.getInstance().init(getApplicationContext());
        WebUtil.getInstance().preinstallStaticTbs(getApplicationContext());

//        动态加载、预加载
//        WebUtil.getInstance().initX5Environment(getApplicationContext());
    }
}