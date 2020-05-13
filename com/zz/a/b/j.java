package com.zz.a.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class j extends SQLiteOpenHelper {
  private static final String b = "douwan_sdk_db";
  
  private static final int c = 3;
  
  public j(i parami, Context paramContext) {
    super(paramContext, "douwan_sdk_db", null, 3);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    paramSQLiteDatabase.execSQL("create table if not exists session ( _id integer primary key autoincrement , user_id String, user_name String, password String , email String , money integer, auto_login integer, last_login_time long );");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    Log.d("android__log", "Upgrading database from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS session");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */