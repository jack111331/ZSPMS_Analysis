package com.zz.sdk.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class x extends SQLiteOpenHelper {
  private static final String b = "zz_sdk_db";
  
  private static final int c = 5;
  
  private static final String d = "create table if not exists sdkuser ( _id integer primary key autoincrement , user_id String, login_id String,login_name String, password String , auto_login integer, last_login_time long, login_type integer, local_login_count integer, user_type integer );";
  
  public x(w paramw, Context paramContext) {
    super(paramContext, "zz_sdk_db", null, 5);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    paramSQLiteDatabase.execSQL("create table if not exists sdkuser ( _id integer primary key autoincrement , user_id String, login_id String,login_name String, password String , auto_login integer, last_login_time long, login_type integer, local_login_count integer, user_type integer );");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    Log.d("android__log", "Upgrading database from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
    if (paramInt1 < 5)
      this.a.a(paramSQLiteDatabase, "sdkuser", "create table if not exists sdkuser ( _id integer primary key autoincrement , user_id String, login_id String,login_name String, password String , auto_login integer, last_login_time long, login_type integer, local_login_count integer, user_type integer );", this.a.a(paramSQLiteDatabase, "sdkuser")); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */