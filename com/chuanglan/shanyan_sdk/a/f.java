package com.chuanglan.shanyan_sdk.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class f extends a {
  public static final String a = "report_device";
  
  public static final String b = "report_behavior";
  
  private static final int c = 1;
  
  private static final String d = "chuanglan_report_2.2.1";
  
  private static f e = null;
  
  private f(Context paramContext) {
    super(paramContext, "chuanglan_report_2.2.1.db", null, 1, true);
  }
  
  public static f a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/chuanglan/shanyan_sdk/a/f.e : Lcom/chuanglan/shanyan_sdk/a/f;
    //   3: ifnonnull -> 31
    //   6: ldc com/chuanglan/shanyan_sdk/a/f
    //   8: monitorenter
    //   9: getstatic com/chuanglan/shanyan_sdk/a/f.e : Lcom/chuanglan/shanyan_sdk/a/f;
    //   12: ifnonnull -> 28
    //   15: new com/chuanglan/shanyan_sdk/a/f
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/chuanglan/shanyan_sdk/a/f.e : Lcom/chuanglan/shanyan_sdk/a/f;
    //   28: ldc com/chuanglan/shanyan_sdk/a/f
    //   30: monitorexit
    //   31: getstatic com/chuanglan/shanyan_sdk/a/f.e : Lcom/chuanglan/shanyan_sdk/a/f;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/chuanglan/shanyan_sdk/a/f
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
    //   36	39	35	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    super.onCreate(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS report_device(DID text UNIQUE,IMEI text,IMSI text,ICCID text,MAC text,appPlatform text,device text,deviceName text)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS report_behavior(id INTEGER PRIMARY KEY AUTOINCREMENT,DID text,telcom text,sdkMode text,osVersion text,romVersion text,sdkVersion text,uuid text,ip text,network text,dbm text,wifidbm text,processName text,method text,beginTime text,costTime INTEGER ,stepTime INTEGER ,status text,resCode text,resDesc text,innerCode text,innerDesc text,count INTEGER,sid text)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    super.onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */