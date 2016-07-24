package com.jiahonglu.andfixdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jiahonglu.andfixdemo.hookdemo.Test;
import com.jiahonglu.andfixdemo.hotfix.PatchManger;
import com.jiahonglu.andfixdemo.hotfix.PatchUpdateInfo;
import com.jiahonglu.andfixdemo.util.MAppInfoManager;
import com.jiahonglu.andfixdemo.util.MAppManager;

import java.io.File;

public class MainActivity extends BasePermissionActivity {

    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        TextView tv = (TextView)findViewById(R.id.textView);
        File patchJarDir = PatchManger.getGlobalPatchManger().patchFileDir.getPatchJarDir();
        tv.setText(Test.getText()+" 补丁初始化路径"+(patchJarDir!=null?patchJarDir.getAbsolutePath():" error"));
        PatchUpdateInfo mock = PatchUpdateInfo.mock;
        if(mock.targetVersion== MAppInfoManager.getVersionCode(this)&&!mock.newPatchMd5.equals(getCurrentPatchMd5())){
            //更新patch
//            HotFixManger.updatePatchJar();
        }
    }

    private void initView() {

        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NiHao hack = new NiHao();
                Toast.makeText(MainActivity.this, hack.sayHello(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 获得当前Patch.jar Md5
     * @return
     */
    private String getCurrentPatchMd5() {
        File ff = PatchManger.getGlobalPatchManger().patchFileDir.getCurrentPatchJar();
        //TODO
        return "ssssssssssssss";
    }


    @Override
    public void onBackPressed() {
        // LxApplication.exit();
        MAppManager.AppExit(this);
    }
}
