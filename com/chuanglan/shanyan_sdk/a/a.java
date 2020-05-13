package com.chuanglan.shanyan_sdk.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

class a extends SQLiteOpenHelper {
  private File a;
  
  a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, boolean paramBoolean) {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    File file;
    if (paramBoolean) {
      paramContext = null;
    } else {
      file = c.a(c.a(), paramString);
    } 
    this.a = file;
  }
  
  public SQLiteDatabase getReadableDatabase() {
    if (this.a == null) {
      SQLiteDatabase sQLiteDatabase1 = super.getReadableDatabase();
      onCreate(sQLiteDatabase1);
      return sQLiteDatabase1;
    } 
    SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.a, null);
    onCreate(sQLiteDatabase);
    return sQLiteDatabase;
  }
  
  public SQLiteDatabase getWritableDatabase() {
    if (this.a == null) {
      SQLiteDatabase sQLiteDatabase1 = super.getWritableDatabase();
      onCreate(sQLiteDatabase1);
      return sQLiteDatabase1;
    } 
    SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.a, null);
    onCreate(sQLiteDatabase);
    return sQLiteDatabase;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */