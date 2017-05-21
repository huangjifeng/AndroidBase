package com.huangjifeng.fragment.fragmentmanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangjifeng.fragment.R;

/**
 * Created by Administrator on 2017/5/21.
 */

public class ManagerFragment02 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_manager_02, container, false);
    }
}
