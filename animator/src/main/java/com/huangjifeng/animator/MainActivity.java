package com.huangjifeng.animator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huangjifeng.animator.frameanimation.FrameAnimationActivity;

/**
 * http://www.jianshu.com/p/420629118c10
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_01:
                startActivity(new Intent(MainActivity.this, FrameAnimationActivity.class));
                /**
                 * 转场动画：overridePendingTransition(R.anim.enter_main_activity, R.anim.out_main_activity);
                 * R.anim.enter_main_activity：指进入的activity的动画
                 * R.anim.out_main_activity：指当前的activity从屏幕消失的动画
                 * android.R.anim.slide_in_left :指使用系统自带的动画
                 * 转场动画最好使用在startActivity()或者finish()方法之后
                 * */
                overridePendingTransition(R.anim.enter_main_activity, R.anim.out_main_activity);
                //overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.button_02:
                break;
            case R.id.button_03:
                break;
            case R.id.button_04:
                break;
        }

    }

}
