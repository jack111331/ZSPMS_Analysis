package com.litesuits.orm.db.assit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.log.OrmLog;

public class Querier {
  private static final String TAG = "Querier";
  
  public static <T> T doQuery(SQLiteDatabase paramSQLiteDatabase, SQLStatement paramSQLStatement, CursorParser<T> paramCursorParser) {
    if (OrmLog.isPrint) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("----> Query Start: ");
      stringBuilder.append(paramSQLStatement.toString());
      OrmLog.d(str, stringBuilder.toString());
    } 
    Cursor cursor = paramSQLiteDatabase.rawQuery(paramSQLStatement.sql, (String[])paramSQLStatement.bindArgs);
    if (cursor != null) {
      paramCursorParser.process(paramSQLiteDatabase, cursor);
      if (OrmLog.isPrint) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<---- Query End , cursor size : ");
        stringBuilder.append(cursor.getCount());
        OrmLog.d(str, stringBuilder.toString());
      } 
    } else if (OrmLog.isPrint) {
      OrmLog.e(TAG, "<---- Query End : cursor is null");
    } 
    return paramCursorParser.returnResult();
  }
  
  public static abstract class CursorParser<T> {
    private boolean parse = true;
    
    public abstract void parseEachCursor(SQLiteDatabase param1SQLiteDatabase, Cursor param1Cursor) throws Exception;
    
    public final void process(SQLiteDatabase param1SQLiteDatabase, Cursor param1Cursor) {
      try {
        param1Cursor.moveToFirst();
        while (this.parse && !param1Cursor.isAfterLast()) {
          parseEachCursor(param1SQLiteDatabase, param1Cursor);
          param1Cursor.moveToNext();
        } 
        if (param1Cursor != null) {
          param1Cursor.close();
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        if (param1Cursor != null) {
          param1Cursor.close();
          return;
        } 
      } finally {}
    }
    
    public T returnResult() {
      return null;
    }
    
    public final void stopParse() {
      this.parse = false;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\assit\Querier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */