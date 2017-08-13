package com.huangjifeng.coordinatorlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /**
     * http://blog.csdn.net/huachao1001/article/details/51554608
     *
     *
     * CoordinatorLayout能帮我们协调子View的布局
     * 这个控件的使用需要导入正确的包：'com.android.support:design:26.0.0-alpha1'
     *
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
