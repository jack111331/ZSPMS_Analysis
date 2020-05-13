package com.litesuits.orm.db.assit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
  private OnUpdateListener onUpdateListener;
  
  public SQLiteHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, OnUpdateListener paramOnUpdateListener) {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    this.onUpdateListener = paramOnUpdateListener;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    if (this.onUpdateListener != null)
      this.onUpdateListener.onUpdate(paramSQLiteDatabase, paramInt1, paramInt2); 
  }
  
  public static interface OnUpdateListener {
    void onUpdate(SQLiteDatabase param1SQLiteDatabase, int param1Int1, int param1Int2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\assit\SQLiteHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */