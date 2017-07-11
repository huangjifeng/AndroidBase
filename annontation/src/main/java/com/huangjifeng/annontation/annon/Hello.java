package com.huangjifeng.annontation.annon;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  表示该注解用于什么地方。默认值为任何元素，表示该注解用于什么地方。
 *  ElementType.CONSTRUCTOR:用于描述构造器
 *  ElementType.FIELD:成员变量、对象、属性（包括enum实例）
 *  ElementType.LOCAL_VARIABLE:用于描述局部变量
 *  ElementType.METHOD:用于描述方法
 *  ElementType.PACKAGE:用于描述包
 *  ElementType.PARAMETER:用于描述参数
 *  ElementType.TYPE:用于描述类、接口(包括注解类型) 或enum声明
 */
@Target(ElementType.TYPE)
/**
 * 定义该注解的生命周期
 * RetentionPolicy.SOURCE : 在编译阶段丢弃。
 * RetentionPolicy.CLASS : 在类加载的时候丢弃。
 * RetentionPolicy.RUNTIME : 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息。
 * */
@Retention(RetentionPolicy.RUNTIME)
public @interface Hello {
}
