package com.huangjifeng.fragment.simpleuse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangjifeng.fragment.R;

/**
 * Created by Administrator on 2017/5/20.
 */

public class UseFragment02 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_use_02, container, false);
    }
}
