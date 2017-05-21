package com.huangjifeng.fragment.simpleuse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.huangjifeng.fragment.R;

/**
 * Created by Administrator on 2017/5/20.
 */

public class UseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use);
        initFragment();
    }

    private void initFragment() {
        UseFragment01 useFragment_01 = new UseFragment01();
        UseFragment02 useFragment_02 = new UseFragment02();

        //1.获取到FragmentManager，在V4包中通过getSupportFragmentManager，在系统中原生的Fragment是通过getFragmentManager获得的。
        FragmentManager manager = getSupportFragmentManager();
        //2.开启一个事务，通过调用beginTransaction方法开启。
        FragmentTransaction transaction = manager.beginTransaction();
        //3.向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例。
        transaction.replace(R.id.frame_layout_01, useFragment_01);
        transaction.replace(R.id.frame_layout_02, useFragment_02);
        //4.提交事务，调用commit方法提交。
        transaction.commit();

    }
}
