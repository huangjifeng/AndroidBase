package com.huangjifeng.dialogfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.huangjifeng.dialogfragment.test.TestActivity;

/**
 * 1、DialogFragment会由于FragmentManager管理DialogFragment.手机配置发生变化的时候，FragmentManager
 * 负责现场的恢复工作，调用DialogFragment的setArguments(bundle)方法进行数据的设置，可以保证DialogFragment
 * 的数据也能恢复
 * 2、DialogFragment里的onCreateView()和onCreateDialog()两个方法，onCreateView()可以用来创建自定义的
 * dialog,onCreateDialog可以用Dialog来创建系统原生的Dialog,
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button01:
                startActivity(new Intent(MainActivity.this, TestActivity.class));
                break;
            case R.id.button02:
                break;
            case R.id.button03:
                break;
            case R.id.button04:
                break;
        }
    }
}
