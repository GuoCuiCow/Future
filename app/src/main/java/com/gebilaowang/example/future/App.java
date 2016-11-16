package com.gebilaowang.example.future;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.facebook.drawee.backends.pipeline.Fresco;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by cuiguo on 2016/11/14.
 */

public class App extends Application {
    public static String sPackageName;
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        Fresco.initialize(this);
        initPackageName();
    }
    private void initPackageName() {
        PackageInfo info;
        try {
            info = getApplicationContext().getPackageManager().getPackageInfo(this.getPackageName(), 0);
            sPackageName = info.packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
