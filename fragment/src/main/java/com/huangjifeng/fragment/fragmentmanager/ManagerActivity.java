package com.huangjifeng.fragment.fragmentmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.huangjifeng.fragment.R;

import java.util.List;


/**
 * Created by Administrator on 2017/5/21.
 */

public class ManagerActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private ManagerFragment01 managerFragment01;
    private FragmentTransaction fragmentTransaction;
    private ManagerFragment02 managerFragment02;
    private static final String TAG_01 = "fragment_02";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        initFragment();
    }

    private void initFragment() {
        //要管理activity中的fragments，你就需要使用FragmentManager。通过getFragmentManager（）或getSupportFragmentManager（）获得
        fragmentManager = getSupportFragmentManager();
        //一般用来对当前的Fragment进行管理，包括add,replace,remove；
        fragmentTransaction = fragmentManager.beginTransaction();
        //根据ID来找到对应的Fragment实例，主要用在静态添加fragment的布局中，因为静态添加的fragment才会有ID
        managerFragment01 = (ManagerFragment01) fragmentManager.findFragmentById(R.id.manager_fragment_01);

        managerFragment02 = new ManagerFragment02();

        //将一个fragment实例添加到Activity的最上层
        //fragmentTransaction.add(R.id.frame_layout_01,managerFragment02);

        //将一个fragment实例从Activity的fragment队列中删除
        //fragmentTransaction.remove(managerFragment02);

        //替换containerViewId中的fragment实例，注意，它首先把containerViewId中所有fragment删除，然后再add进去当前的fragment
        fragmentTransaction.replace(R.id.frame_layout_01, managerFragment02, TAG_01);

        //根据TAG找到对应的Fragment实例，主要用于在动态添加的fragment中，根据TAG来找到fragment实例
        //TAG 都是事务操作时加入的
        managerFragment02 = (ManagerFragment02) fragmentManager.findFragmentByTag(TAG_01);

        //获取所有被ADD进Activity中的Fragment
        List<Fragment> list = fragmentManager.getFragments();
        fragmentTransaction.commit();


    }

    public void onClickManager(View view) {
        switch (view.getId()) {
            case R.id.button_01:

                break;
            case R.id.button_02:
                break;
        }

    }
}
