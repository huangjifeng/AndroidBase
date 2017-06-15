package com.huangjifeng.animator.frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.huangjifeng.animator.R;

/**
 * Created by Administrator on 2017/5/28.
 */

public class FrameAnimationActivity extends AppCompatActivity {

    private ImageView imageView_anim1;
    private ImageView imageView_anim2;
    private ImageView imageView_anim3;
    private ImageView imageView_anim4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        //京东快递的动画
        imageView_anim1 = (ImageView) findViewById(R.id.anim1);
        imageView_anim1.setImageResource(R.drawable.frame_anim1);
        AnimationDrawable animationDrawable_anim1 = (AnimationDrawable) imageView_anim1.getDrawable();
        animationDrawable_anim1.start();

        imageView_anim2 = (ImageView) findViewById(R.id.anim2);
        imageView_anim2.setImageResource(R.drawable.frame_anim2);
        AnimationDrawable animationDrawable_anim2 = (AnimationDrawable) imageView_anim2.getDrawable();
        animationDrawable_anim2.start();

        imageView_anim3 = (ImageView) findViewById(R.id.anim3);
        imageView_anim3.setImageResource(R.drawable.frame_anim3);
        AnimationDrawable animationDrawable_anim3 = (AnimationDrawable) imageView_anim3.getDrawable();
        animationDrawable_anim3.start();

        imageView_anim4 = (ImageView) findViewById(R.id.anim4);
        imageView_anim4.setImageResource(R.drawable.frame_anim4);
        AnimationDrawable animationDrawable_anim4 = (AnimationDrawable) imageView_anim4.getDrawable();
        animationDrawable_anim4.start();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.enter_other_activity, R.anim.out_other_activity);
    }
}
