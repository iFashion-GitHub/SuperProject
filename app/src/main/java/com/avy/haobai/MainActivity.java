package com.avy.haobai;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.avy.superproject.R;
import com.light.play.api.LightPlay;
import com.light.play.api.LightPlayView;
import com.light.play.api.OnPlayErrorListener;
import com.light.play.api.OnPlayPreparedListener;
import com.light.play.api.OnPlayReleasedListener;
import com.light.play.api.OnPlayStatusListener;
import com.light.play.api.PlayFrameRate;
import com.light.play.api.PlayQualityLevel;
import com.light.play.config.ErrorCode;


public class MainActivity extends AppCompatActivity {
    private final static String AppId = "xiaowo";
    private final static String BizId = "lightplay_sdk_android";
    private final static String AccessKeyId = "a61e6fcd1b978f80de1f93e12c1367a3";
    private final static String AccessKey = "a940a78629396067670e635c90c39df1";
    public static String token = null;
    private final static String userid = "15012817001";
    private final static String Woid = "third_id_484";
    public final static String URL = "http://220.248.55.105:18088";
    LightPlay lightPlay;
    private LightPlayView view;
    int level,gameid,frameRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maingame_main);
        lightPlay = LightPlayManager.getInstance().getLightPlay();
        lightPlay.setLogPath("/sdcard/viuplaylogs");
        Intent intent = getIntent();
//        String level = intent.getStringExtra("level");//视频等级
//        String gameid = intent.getStringExtra("gameid");//游戏ID
//        String frameRate = intent.getStringExtra("frame");//帧数
         level = intent.getIntExtra("level",0);//视频等级
         gameid = intent.getIntExtra("gameid",0);//游戏ID
         frameRate = intent.getIntExtra("frame",0);//帧数
        Log.d("lu++++++++++", "onCreate level: " + level);
        Log.d("lu++++++++++", "onCreate gameid: " + gameid);
        Log.d("lu++++++++++", "onCreate frameRate: " + frameRate);
        request(level,gameid,frameRate);
    }

    /**
     * 设置分辨率等级
     *
     *         if (quality == 0){
     *             level = PlayQualityLevel.P480;
     *         }else if (quality == 1){
     *             level = PlayQualityLevel.P720;
     *         }else if (quality == 2){
     *             level = PlayQualityLevel.P1080;
     *         }else if (quality == 3){
     *             level = PlayQualityLevel.P1440;
     *         }else if (quality == 4){
     *             level = PlayQualityLevel.P4K;
     *         }
     * @param quality
     */
    private void setQualityLevel(int quality){
        PlayQualityLevel level = PlayQualityLevel.P720;
        if (quality == 0){
            level = PlayQualityLevel.P480;
        }else if (quality == 1){
            level = PlayQualityLevel.P720;
        }else if (quality == 2){
            level = PlayQualityLevel.P1080;
        }else if (quality == 3){
            level = PlayQualityLevel.P1440;
        }else if (quality == 4){
            level = PlayQualityLevel.P4K;
        }
        lightPlay.setQuality(level);
    }

    /** 设置帧率*/
    private void setFrameRate(int frameRate){
        lightPlay.setFrameRate(frameRate<= 30? PlayFrameRate.F30:PlayFrameRate.F60);
    }
    /** 启动游戏*/
    private void tokenSend(final String gameid) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
                    Log.d("token", "run: " + token);
                    lightPlay.init(MainActivity.this,AppId,AccessKeyId,BizId,AccessKey,userid,token,true);//初始化

                    view = findViewById(R.id.surfaceView);
                    lightPlay.setOnErrorListener(new OnPlayErrorListener() {
                        @Override
                        public void onError(final int errorCode, final String message) {

                            Log.e("MainActivity","on error back code "+errorCode+ " msg "+message);
                            switch (errorCode) {
                                case 1001: //服务器繁忙
                                case 1002: //启动游戏失败
                                case 1003: //内部协议错误
                                case 1004: //硬件性能不够
                                case 1005: //加载游戏超时
                                    //case 1006://token过期
                                case 1007: //游戏ID不正确
                                case 1008: //游戏被断开
                                case 1009: //应用未授权使用SDK
                                case 1010: //余额不足
                                case 1011://游戏拉起失败，有游戏正在运行

                                    break;
                            }

                        }
                    });

                    lightPlay.setOnStatusListener(new OnPlayStatusListener() {
                        @Override
                        public void onStatus(int code, int value1, int value2,String message) {
                            Log.e("MainActivity","on status back code "+code+" value1 "+value1+" value2 "+value2+ " msg "+message);
                            if (code == ErrorCode.STATUS_SERVER_UPEATE_QUEUE_RANK) {
                                message="正在排队"+value1+"/"+value2;
                            }
                            final String finalMessage = message;


                            switch (code){
                                case 2007: //游戏资源被回收
                                    String text = "游戏资源被回收(code=" + code +")";
                                    showNormalDialog(text);
                                    break;
                                case 2011: //余额不足游戏资源被回收
                                     text = "余额不足游戏资源被回收(code=" + code +")";
                                    showNormalDialog(text);
                                    break;
                                case 2012: //游戏空闲超时游戏资源被回收
                                    text = "游戏空闲超时游戏资源被回收(code=" + code +")";
                                    showNormalDialog(text);
                                    break;
                                case 2013://游戏分配资源未开始游戏超时

//                                    final DialogMessageEntity entity = new DialogMessageEntity();
//                                    entity.btn1Text = "知道了";
//                                    entity.message =  message+"("+code+")";
                                   // exit();
                                    text = "游戏空闲超时游戏资源被回收(code=" + code +")";
                                    showNormalDialog(text);
                                    break;
                                case 2001:
                                    break;
                                case 2014:
                                    Log.d("MainActivity"," SELECT BUTTON CLICKED TIME OUT");
                                    break;
                            }
                        }
                    });
                    lightPlay.setOnPreparedListener(new OnPlayPreparedListener() {
                        @Override
                        public void onPrepared() {
                            lightPlay.startPlay(view,MainActivity.this);

                        }
                    });

                    lightPlay.setOnReleasedListener(new OnPlayReleasedListener() {
                        @Override
                        public void onReleased() {

                            Log.d("MainActivity","onReleased can do next prepare");
                        }
                    });
                    lightPlay.prepare(gameid);
//        play.setVibrate(true);
//        play.setVirtualControlAlpha(10);
//        play.setVirtualControlType(VirtualControlType.SIMPLE);

                Log.d("MainActivity","token "+token);
//                }catch (JSONException e){
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
    }
    private void showNormalDialog(String text){
        //创建dialog构造器
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        //设置title
        normalDialog.setTitle("系统错误");
        //设置icon
        normalDialog.setIcon(R.mipmap.ic_launcher_round);
        //设置内容
        normalDialog.setMessage(text);
        //设置按钮
        normalDialog.setPositiveButton("确定"
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exit();
                        dialog.dismiss();
                    }
                });
        //创建并显示
        normalDialog.create().show();
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setTitle("提示").setMessage("确定要退出吗？");
        build.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exit();
                        finish();
                    }
                });
        build.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                AlertDialog.Builder build = new AlertDialog.Builder(this);
                build.setTitle("提示").setMessage("确定要退出吗？");
                build.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                exit();
                                finish();
                            }
                        });
                build.setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).show();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }

    public void exit(){
        lightPlay.release();
        lightPlay = null;
        finish();
    }

    protected void request(int level, int gameid, int frameRate) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//版本判断
            if (checkSelfPermission(Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);
            } else {
                //你的操作
                setQualityLevel(level);
                tokenSend(gameid + "");
                setFrameRate(frameRate);
            }
        } else {
            //你的操作
            setQualityLevel(level);
            tokenSend(gameid + "");
            setFrameRate(frameRate);
        }
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.detectFileUriExposure();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted 授予权限
                    //处理授权之后逻辑
                    setQualityLevel(level);
                    tokenSend(gameid + "");
                    setFrameRate(frameRate);
                } else {
                    // Permission Denied 权限被拒绝

                }
                break;
            default:
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //判断是否有焦点
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION//隐藏nav栏
                            | View.SYSTEM_UI_FLAG_FULLSCREEN//隐藏状态栏
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );

        }
    }
}
