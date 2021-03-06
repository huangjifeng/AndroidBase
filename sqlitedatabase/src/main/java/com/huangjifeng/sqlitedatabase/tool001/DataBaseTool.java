package com.huangjifeng.sqlitedatabase.tool001;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 查询语句：select * from 表名 where 条件子句 group by 分组字句 having ... order by 排序子句
 * 查询语句（跳过几条查几条）：select * from Account limit 5 offset 3 或者 select * from Account limit 3,5
 * 插入语句：insert into 表名(字段列表) values(值列表)
 * 更新语句：update 表名 set 字段名=值 where 条件子句
 * 删除语句：delete from 表名 where 条件子句
 */

public class DataBaseTool {

    private final MySQLiteOpenHelper openHelper;

    public DataBaseTool(Context context) {
        openHelper = new MySQLiteOpenHelper(context);
    }

    public void insertPerson() {
        SQLiteDatabase database = openHelper.getWritableDatabase();
        /**
         * 不推荐使用：
         * database.execSQL("insert into person (name, age) values ('林计钦', 24)");
         * 当用户输入的内容含有单引号时，组拼出来的SQL语句就会存在语法错误。要解决这个问题需要
         * 对单引号进行转义，也就是把单引号转换成两个单引号。有些时候用户往往还会输入像“ & ”这些
         * 特殊SQL符号，为保证组拼好的SQL语句语法正确，必须对SQL语句中的这些特殊SQL符号都进行转义，
         * 显然，对每条SQL语句都做这样的处理工作是比较烦琐的。
         * */
        /**execSQL(String sql, Object[] bindArgs)方法的第一个参数为SQL语句，第二个参数为SQL语句
         * 中占位符参数的值，参数值在数组中的顺序要和占位符的位置对应。*/
        database.execSQL("insert into person (name, age) values(?, ?)", new Object[]{"黄基锋", 4});
        database.close();
    }

    public void queryPerson() {
        SQLiteDatabase database = openHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from person", null);
        //Cursor cursor = database.rawQuery("select * from person where name like ? and age = ?",
        //               new String[]{"%林计钦%", "4"});
        while (cursor.moveToNext()) {
            int personId = cursor.getInt(0);    //获取第一列的值，第一列的索引从0开始
            String name = cursor.getString(1);  //获取第二列的值
            int age = cursor.getInt(3);         //获取第三列的值
        }
        cursor.close();
        database.close();
    }


}
