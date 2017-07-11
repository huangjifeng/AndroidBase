package com.huangjifeng.annontation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 注解：它提供了一种安全的类似注释的机制，用来将任何的信息或元数据（metadata）与程序元素
 * （类、方法、成员变量等）进行关联。为程序的元素（类、方法、成员变量）加上更直观更明了的说明，
 * 这些说明信息是与程序的业务逻辑无关，并且供指定的工具或框架使用。Annontation像一种修饰符一样，
 * 应用于包、类、构造方法、方法、成员变量、参数及本地变量的声明语句中。
 *
 * 注解的用处：
 1、生成文档。这是最常见的，也是java 最早提供的注解。常用的有@param @return 等
 2、跟踪代码依赖性，实现替代配置文件功能。比如Dagger 2依赖注入，未来java开发，将大量注解配置，具有很大用处;
 3、在编译时进行格式检查。如@override 放在方法前，如果你这个方法并不是覆盖了超类方法，则编译时就能检查出。
 *
 * http://www.cnblogs.com/whoislcj/p/5671622.html
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
