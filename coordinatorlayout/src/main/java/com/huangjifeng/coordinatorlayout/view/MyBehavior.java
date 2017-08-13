package com.huangjifeng.coordinatorlayout.view;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 这个类是使用CoordinatorLayout的核心，
 * 1、Child：CoordinatorLayout的子view的意思，即要执行动作的CoordinatorLayout的子View
 * 2、Dependency：Child依赖的View
 * <p>
 * CoordinatorLayout.Behavior<T>中泛型参数T是我们要执行动作的View类，也就是Child
 */

public class MyBehavior extends CoordinatorLayout.Behavior<Button> {


    private final Context context;
    private final int width;
    private final int height;

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;

    }

    /**
     * 判断Child 的布局是否依赖dependency，主要是根据各种逻辑关系来判断
     * true：表示依赖，false：表示不依赖
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        //如果dependency是TempView的实例，说明它就是我们所需要的dependency
        return dependency instanceof TempView;
    }

    /**
     * 当Dependency发生改变时（位置，宽高等），执行这个函数
     * true：表示child的位置或者宽高要发生改变，false：表示不改变
     * 方法中执行child具体要执行的动作
     * <p>
     * 每次dependency位置发生变化，都会执行onDependentViewChanged方法
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button child, View dependency) {

        //根据dependency的位置，设置Button的位置
        int x = (int) (width - dependency.getX() - child.getWidth());
        int y = (int) dependency.getY();
        Log.e("haha0", " x = " + x + ",  y = " + y);
        setPosition(child, x, y);
        return true;
    }

    private void setPosition(View view, int x, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        view.setLayoutParams(layoutParams);
    }
}
