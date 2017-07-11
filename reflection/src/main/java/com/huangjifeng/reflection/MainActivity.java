package com.huangjifeng.reflection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * http://www.sczyh30.com/posts/Java/java-reflection-1/
 * <p>
 * 反射机制：在Java运行时环境中，动态获取类的信息以及动态调用对象的功能
 * 反射机制主要的功能：
 * 1、在运行时判断任意一个对象所属的类
 * 2、在运行时构造任意一个类的对象
 * 3、在运行时判断任意一个类所具有的成员变量和方法
 * 4、在运行时调用任意一个对象的方法
 * <p>
 * <p>
 * 反射中使用到的类：
 * Class类：代表一个类
 * Field类：代表类的成员变量（成员变量也称为类的属性）
 * Method类：代表类的方法
 * Constructor类：代表类的构造方法
 * Array类：提供了动态创建数组，以及访问数组的元素的静态方法
 *
 *
 * 注意：
 * 1、要想使用反射，首先需要获取待处理类或对象锁对应的Class对象
 * 2、获取某个类或某个对象所对应的Class对象的常用的3种方式：
 *      (1)使用Class类的静态方法：forName:   Class.forName("java.lang.String")
 *      (2)使用类的.class语法： String.class;
 *      (3)使用对象的getClass()方法： String s = "aa";  Class<?> clazz = s.getClass();
 * 3、
 *
 */
public class MainActivity extends AppCompatActivity {

    private Class<?> classType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getClassDeclaredName();

        getInvokeTest();
    }

    private void getInvokeTest() {
        /**
         * 这是以前的写法，不是动态的，编译的时候就知道的
         * InvokeTester invokeTester = new InvokeTester();
         Log.v("haha", "----------" + invokeTester.add(2, 7));
         Log.v("haha", "----------" + invokeTester.echo("ying"));*/

        Class<?> classType = InvokeTester.class;         //获取Class类

        try {
            Object invokeTester = classType.newInstance();      //获取对象

            /**
             * 获取方法的类
             * 传进去的参数：可确定唯一的方法
             * 1、方法名
             * 2、参数所对应的是参数Class构成的数组，避免重载
             * */
            Method addMethod = classType.getMethod("add", new Class[]{int.class, int.class});
            /**
             * 参数1：哪个对象调用此方法
             * 参数2：方法传入的参数，实际的参数,Object对应的数组
             * */
            Object result01 = addMethod.invoke(invokeTester, new Object[]{5, 2});
            Log.v("haha", "----------" + (Integer) result01);

            Method echoMethod = classType.getMethod("echo", new Class[]{String.class});
            Object result02 = echoMethod.invoke(invokeTester, new Object[]{"我是刘书印"});
            Log.v("haha", "----------" + (String) result02);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 这个例子是获取类申明的方法
     */
    public void getClassDeclaredName() {
        /**第一步用于是获取到需要操作的class对象*/
        try {
            classType = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = classType.getDeclaredMethods();

        for (Method method : methods) {
            Log.v("haha", "----------" + method.toString());
        }
    }


}
