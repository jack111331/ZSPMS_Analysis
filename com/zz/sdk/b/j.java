package com.zz.sdk.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class j extends SQLiteOpenHelper {
  public j(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt) {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    Log.d("", "开始创建数据库 -- ");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS a_pay(id integer primary key autoincrement,user varchar,a_way varchar,status varchar,submitAmount varchar,a_ordernum varchar,a_time datetime)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */