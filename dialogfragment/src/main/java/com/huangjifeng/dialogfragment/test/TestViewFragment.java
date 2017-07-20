package com.huangjifeng.dialogfragment.test;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.huangjifeng.dialogfragment.R;

/**
 * Created by Administrator on 2017/7/17.
 */

public class TestViewFragment extends DialogFragment {

    private EditText editText_test;
    private static final String INPUT_DATA = "input data";
    private static TestViewFragment testViewFragment;


    public static TestViewFragment getInstance() {
        if (testViewFragment == null) {
            testViewFragment = new TestViewFragment();
        }
        return testViewFragment;
    }

    /**
     * 可以在onCreate（）方法中设置对话框的风格和各种属性，但是千万别设置关于View的东西，因为
     * 这个时候对话框还没有建立，所以没有View之说
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    /**
     * 这里面主要进行一些View相关的操作，设置监听等
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_view_test, container);

        /*editText_test = (EditText) view.findViewById(R.id.edit_text_test);
        if (savedInstanceState != null) {
            editText_test.setText(savedInstanceState.getCharSequence(INPUT_DATA));
        }*/

        Button button_test = (Button) view.findViewById(R.id.button_test);
        button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissAllowingStateLoss();
            }
        });

        return view;
    }

    /**
     * 调用dismiss();方法之后会回调该onDismiss（）方法
     */
    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //outState.putCharSequence(INPUT_DATA, editText_test.getText());
        super.onSaveInstanceState(outState);
    }
}
