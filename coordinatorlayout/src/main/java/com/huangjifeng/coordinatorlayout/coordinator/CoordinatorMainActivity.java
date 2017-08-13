package com.huangjifeng.coordinatorlayout.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.huangjifeng.coordinatorlayout.R;

/**
 * http://www.jianshu.com/p/f09723b7e887
 *
 *
 * AppBarLayout的参数详解：
 * 注意事项：它是继承自LinearLayout的，默认方向是Vertical; 它必须作为CoordinatorLayout的直接子View，
 * 否则它的大部分功能将不会生效
 * app:layout_scrollFlags="scroll|enterAlways"
 *      SCROLL_FLAG_ENTER_ALWAYS：（(entering) / (scrolling on screen)）下拉的时候，这个View也会跟着滑出
 *      SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED：另一种enterAlways，但是只显示折叠后的高度。
 *      SCROLL_FLAG_EXIT_UNTIL_COLLAPSED：（(exiting) / (scrolling off screen)）上拉的时候，这个View会跟着滑动直到折叠
 *      SCROLL_FLAG_SCROLL：这个View将会响应Scroll事件
 *      SCROLL_FLAG_SNAP：在Scroll滑动事件结束以前，如果这个View部分可见，那么这个View会停在最接近当前View的位置
 *
 *
 * CollapsingToolBarLayout的详解：
 * 它继承自FrameLayout; 简单来说，CollapsingToolBarLayout是工具栏的包装器，它通常作为AppBarLayout的孩子。
 *
 *      COLLAPSE_MODE_OFF：这个View将会呈现正常的结果，不会表现出折叠效果
 *      COLLAPSE_MODE_PARALLAX：在滑动的时候这个View会呈现出视觉特差效果
 *      COLLAPSE_MODE_PIN：当这个View到达CollapsingToolbarLayout的底部的时候，这个View 将会被放置，
 *      即代替整个CollapsingToolbarLayout
 *
 *
 */

public class CoordinatorMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_coordiantor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }








}
