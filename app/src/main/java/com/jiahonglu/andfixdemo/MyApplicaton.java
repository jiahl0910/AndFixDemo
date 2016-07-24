package com.jiahonglu.andfixdemo;

import android.app.Application;
import android.content.Context;

import com.jiahonglu.andfixdemo.hotfix.HotFixManger;
import com.jiahonglu.andfixdemo.util.MAppManager;

/**
 * Created by shoyu666@163.com on 16/7/5.
 */
public class MyApplicaton extends Application{
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MAppManager.init(this);
        HotFixManger.init(this);//服务器下载的包
//        RocooFix.initPathFromAssets(base,"patch.jar");//assets的包
    }
}
