package com.huangjifeng.dialogfragment.test;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.huangjifeng.dialogfragment.R;

/**
 * 如果你的DialogFragment是Activity的内部类，必须将DialogFragment定义为静态的。否则会报错！！！
 */

public class TestActivity extends AppCompatActivity {

    private boolean isShowDialog = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //showDialog();
        showDialogByView();


    }

    public void setShowedDialog(boolean b) {
        isShowDialog = b;
    }

    private void showDialogByView() {
        if (!isShowDialog) {
            isShowDialog = true;
            TestViewFragment viewFragment = new TestViewFragment();
            viewFragment.show(getSupportFragmentManager(), "test_view_fragment");
        }
    }

    private void showDialog() {
        /**
         * 以下代码为直接通过AlertDialog.Builder来创建dialog的，链式调用
         *
         * */
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("标题：这是我直接创建dialog")
                .setMessage("主要内容：哈哈哈哈哈哈哈哈哈哈哈。。。。")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TestActivity.this, "确定按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("中立", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TestActivity.this, "我也不知道怎么选", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TestActivity.this, "取消按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}
