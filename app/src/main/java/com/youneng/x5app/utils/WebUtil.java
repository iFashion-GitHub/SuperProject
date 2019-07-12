package com.youneng.x5app.utils;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;

public class WebUtil {
    private static final String TAG= "WatchDog";
    private boolean isInit;

    private WebUtil () {
    }

    private static class Holder {
        private static final WebUtil INSTANCE = new WebUtil ();
    }

    public static WebUtil  getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 初始化
     */
    public void init(final Context context) {
        if (context == null) {
            Log.d(TAG,"context==null");
            return;
        }
        if (isInit) {
            Log.d(TAG,"isInit==true");
            return;
        }
        isInit = true;
        //--搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.setDownloadWithoutWifi(true);//允许在非WIFI条件下下载X5内核

    }






    public void preinstallStaticTbs(final Context context){
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    QbSdk.preinstallStaticTbs(context);
                }
            }).start();
            Log.d(TAG,"QbSdk.preinstallStaticTbs(context);");
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG,"preinstall failed");
        }
    }


    public void initX5Environment(Context context){
        try {
            QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
                @Override
                public void onViewInitFinished(boolean arg0) {
                }

                @Override
                public void onCoreInitFinished() {
                }
            };
            //x5内核初始化接口
            QbSdk.initX5Environment(context.getApplicationContext(), cb);
            Log.d(TAG," QbSdk.initX5Environment(context.getApplicationContext(), cb);");
        } catch (Throwable e) {
            e.printStackTrace();
            Log.d(TAG," initX5Environment failed");
        }
    }
}
