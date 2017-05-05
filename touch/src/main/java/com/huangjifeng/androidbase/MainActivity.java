package com.huangjifeng.androidbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);


        /*
        * setClickable 设置为true时，表明控件可以点击，如果为false，就不能点击；“点击”适用于鼠标、键盘按键、遥控器等；
        注意，setOnClickListener方法会默认把控件的setClickable设置为true。
        setEnabled  如果设置为false，该控件永远不会活动，不管设置为什么属性，都无效；设置为true，
        表明激活该控件，控件处于活动状态，处于活动状态，就能响应事件了，比如触摸、点击、按键事件等；
        setEnabled就相当于总开关一样，只有总开关打开了，才能使用其他事件。
        setFocusable 使控件获得焦点，设置为true时，并不是说立刻获得焦点，要想立刻获得焦点，
        得用requestFocus；使能获得焦点，就是说具备获得焦点的机会、能力，当有焦点在控件之间移动时，
        控件就有这个机会、能力得到焦点。
        * */
        button.setClickable(true);
        button.setEnabled(true);
        button.setFocusable(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*
        * onTouch和onTouchEvent都是在View的dispatchTouchEvent中调用的，onTouch优先于onTouchEvent执行。
        * 如果在onTouch方法中通过返回true将事件消费掉，onTouchEvent将不会再执行。
        * onTouch能够得到执行需要两个前提条件，第一mOnTouchListener的值不能为空，第二当前点击的控件
        * 必须是enable的。因此如果你有一个控件是非enable的，那么给它注册onTouch事件将永远得不到执行。
        * 对于这一类控件，如果我们想要监听它的touch事件，就必须通过在该控件中重写onTouchEvent方法来实现。
        * android:clickable="true"        ---> 对应的是可点击     onClick(View v)
          android:enabled="true"          ---> 对应的是可触摸     onTouch(View v, MotionEvent event)
        *
        *
        *
        * */
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
        button.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });
        button.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                return false;
            }
        });
        button.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                return false;
            }
        });
        button.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
    }
}
