package com.huangjifeng.sqlitedatabase.tool001;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * SQLiteOpenHelper：可以实现对数据库版本进行管理来实现创建或者升级数据库表
 * <p>
 * getWritableDatabase()，getReadableDatabase的区别是当数据库写满时，调用前者会报错，
 * 调用后者不会，所以如果不是更新数据库的话，最好调用后者来获得数据库连接。
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    //类没有实例化，是不能用作父类构造器的参数，必须声明为静态
    private static final String name = "huangdb";    //数据库名称
    private static final int version = 1;            //数据库版本


    public MySQLiteOpenHelper(Context context) {
        /**
         * 这个帮助类的构造方法是必须实现的，第三个参数CursorFactory指定在执行查询时获得一个游标
         * 实例的工厂，设置为null,代表使用系统默认的工厂类
         * */
        super(context, name, null, version);
    }

    /**
     * 可以生成数据库表结构及添加一些应用使用到的初始化数据
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS persion ( personid integer primary key autoincrement," +
                "name varchar(20), age INTERGER)");
    }

    /**
     * 在数据库的版本发生变化时会被调用，一般在软件升级时才需改变版本号
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE person ADD phont VARCHAR(12) NULL");    //往表中增加一列
        //db.execSQL("DROP TABLE IF EXISTS person");    //删除表
    }
}
