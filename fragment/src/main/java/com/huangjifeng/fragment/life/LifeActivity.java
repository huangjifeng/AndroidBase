package com.huangjifeng.fragment.life;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.huangjifeng.fragment.R;

/**
 * Created by Administrator on 2017/5/20.
 */

public class LifeActivity extends AppCompatActivity {
    public static final String AAAA = "student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        initFragment();
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        /**
         * 1、可以将transaction存进由activity管理的back stack中，这样用户就可以进行fragment变化的回退操作。
         * */
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        LifeFragment lifeFragment = new LifeFragment();       //创建一个fragment实例
        /**
         * 当Activity类动态加载fragment时可以通过fragment的setArguments()传入值，
         * 并在fragment类中通过fragment的getArguments()方法获得传入的值
         * */
        Bundle bundle = new Bundle();       //创建一个Bundle 对象
        //bundle.putString(AAAA, "xiaoming");       //向bundle中传值
        lifeFragment.setArguments(bundle);    //将bundle通过setArguments(bundle)方法设置进fragment

        fragmentTransaction.replace(R.id.text_view, lifeFragment);

        /**
         * 1、用add(), remove(), replace()方法，把所有需要的变化加进去，然后调用commit()方法，将这些变化应用。
         * 2、在commit()方法之前，你可以调用addToBackStack()，把这个transaction加入back stack中去，
         * 这个back stack是由activity管理的，当用户按返回键时，就会回到上一个fragment的状态。
         * 3、activity的onSaveInstanceState调用过后，再commit的Transaction导致的异常。一些小伙伴建议
         * 用commitAllowingStateLoss来代替commit
         * 4、如果activity的状态被保存了，这里再提交就会检查这个状态，符合条件就抛出一个异常来终止应用进程。
         * 也就是说在activity调用了onSaveInstanceState()之后，再commit一个事务就会出现该异常。
         * 那如果不想抛出异常，也可以很简单调用commitAllowingStateLoss()方法来略过这个检查就可以了，
         * 但是Google说这是危险的，如果activity随后需要从它保存的状态中恢复，这个commit是会丢失的。
         * 因此它仅仅适用在 ui状态的改变对用户来说是可以接受的 。
         *
         * 总结：
         * 1、在activity的生命周期方法中提交事务要小心，越早越好，比如onCreate。也可以在接收用户的
         * 输入时来提交。尽量避免在onActivityResult()方法中提交。
         * 2、避免在异步的回调方法中执行commit。因为他们感知不到当前activity生命周期的状态。
         * 3、使用commitAllowingStateLoss()代替commit()。相比于crash，我觉得ui状态的改变对用户来说是
         * 可以接受的。但是也要看场景，比如涉及到金融相关的场景，用户可能突然觉得钱没了(从ui上看)，
         * 那还不如crash让系统再重新拉起 App 呢。
         * */
        /**
         * Add this transaction to the back stack.  This means that the transaction
         * will be remembered after it is committed, and will reverse its operation
         * when later popped off the stack.
         */
        //fragmentTransaction.addToBackStack("state_01");
        //fragmentTransaction.commitAllowingStateLoss();
        fragmentTransaction.commit();

    }
}
