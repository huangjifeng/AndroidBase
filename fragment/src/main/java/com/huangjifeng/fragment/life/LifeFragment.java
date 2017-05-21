package com.huangjifeng.fragment.life;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huangjifeng.fragment.R;

/**
 * Fragment的优点：
 * 1、Fragment可以使你能够将activity分离成多个可重用的组件，每个都有它自己的生命周期和UI。
 * 2、Fragment可以轻松得创建动态灵活的UI设计，可以适应于不同的屏幕尺寸。从手机到平板电脑。
 * 3、Fragment是一个独立的模块,紧紧地与activity绑定在一起。可以运行中动态地移除、加入、交换等。
 * 4、Fragment提供一个新的方式让你在不同的安卓设备上统一你的UI。
 * 5、Fragment 解决Activity间的切换不流畅，轻量切换。
 * 6、Fragment 替代TabActivity做导航，性能更好。
 * 7、Fragment 在4.2.版本中新增嵌套fragmeng使用方法，能够生成更好的界面效果。
 * 8、Fragment做局部内容更新更方便，原来为了到达这一点要把多个布局放到一个activity里面，现在可以用多
 * Fragment来代替，只有在需要的时候才加载Fragment，提高性能
 */

public class LifeFragment extends Fragment {


    /**
     * Called when a fragment is first attached to its context.
     * {@link #onCreate(Bundle)} will be called after this.
     * <p>
     * onAttach()在fragment与Activity关联之后调调查用。需要注意的是，初始化fragment参数可以
     * 从getArguments()获得，但是，当Fragment附加到Activity之后，就无法再调用setArguments()。
     * 所以除了在最开始时，其它时间都无法向初始化参数添加内容。
     * <p>
     * 一旦Activity与Fragment Attached就可以通过getActivity()来获取相关联的Activity的实例。
     * Fragment依附于不同的activity则getActivity（）返回不同的activity.
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /**
     * fragment初次创建时调用。尽管它看起来像是Activity的OnCreate()函数，但这个只是用来创建Fragment的。
     * 此时的Activity还没有创建完成，因为我们的Fragment也是Activity创建的一部分。所以如果你想在这里
     * 使用Activity中的一些资源，将会获取不到。比如：获取同一个Activity中其它Frament的控件实例。(代码如下：)，
     * 如果想要获得Activity相关联的资源，必须在onActivityCreated中获取。
     * If the fragment is being re-created froma previous saved state, this is the state.
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 1、Container，可以为NULL，如果父窗口值为NULL，这意味着该Fragment不可见，因为它没有附加到任何的视图层次中。
     * 2、attachToRoot:一般为FALSE，它的意义为，是否当前XML的根结点作为整个APP视图的根结点，
     * 如果设为TRUE，那返回的VIEW将是整个APP视图架构的根结点，我们一般不需要这么做。因为我们的
     * Fragment是依附于Activity的，Activity上可能有其它控件，我们的Fragment只是其中的一个小分支，
     * 如果这里设为TRUE，那么Fragment以外的分支将被全部删除，整个APP视图将会只有Fragment；
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_life, container, false);
        //String student_name = getArguments().getString(LifeActivity.AAAA);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * Called when the fragment's activity has been created and this
     * fragment's view hierarchy instantiated.  It can be used to do final
     * initialization once these pieces are in place, such as retrieving
     * views or restoring state.  It is also useful for fragments that use
     * {@link #setRetainInstance(boolean)} to retain their instance,
     * as this callback tells the fragment when it is fully associated with
     * the new activity instance.  This is called after {@link #onCreateView}
     * and before {@link #onViewStateRestored(Bundle)}.
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     *                           <p>
     *                           在Activity的OnCreate()结束后，会调用此方法。所以到这里的时候，Activity已经创建完成！
     *                           在这个函数中才可以使用Activity的所有资源。
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * 当这个fragment不再使用时调用。需要注意的是，它即使经过了onDestroy()阶段，但仍然能从Activity中找到，因为它还没有Detach。
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Fragment生命周期中最后一个回调是onDetach()。调用它以后，Fragment就不再与Activity相绑定，
     * 它也不再拥有视图层次结构，它的所有资源都将被释放。
     */
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
