package com.huangjifeng.coordinatorlayout.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/**
 * 这个类是使用CoordinatorLayout的核心，
 * 1、Child：CoordinatorLayout的子view的意思，即要执行动作的CoordinatorLayout的子View
 * 2、Dependency：Child依赖的View
 *
 * CoordinatorLayout.Behavior<T>中泛型参数T是我们要执行动作的View类，也就是Child
 */

public class MyBehavior extends CoordinatorLayout.Behavior<Button> {

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 判断Child 的布局是否依赖dependency，主要是根据各种逻辑关系来判断
     * true：表示依赖，false：表示不依赖
     * */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    /**
     * 当Dependency发生改变时（位置，宽高等），执行这个函数
     * true：表示child的位置或者宽高要发生改变，false：表示不改变
     * 方法中执行child具体要执行的动作
     * */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
