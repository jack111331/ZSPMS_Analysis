package com.litesuits.orm.db;

import android.content.Context;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.assit.SQLiteHelper;

public class DataBaseConfig {
  public static final String DEFAULT_DB_NAME = "liteorm.db";
  
  public static final int DEFAULT_DB_VERSION = 1;
  
  public Context context;
  
  public String dbName = "liteorm.db";
  
  public int dbVersion = 1;
  
  public boolean debugged = false;
  
  public SQLiteHelper.OnUpdateListener onUpdateListener;
  
  public DataBaseConfig(Context paramContext) {
    this(paramContext, "liteorm.db");
  }
  
  public DataBaseConfig(Context paramContext, String paramString) {
    this(paramContext, paramString, false, 1, null);
  }
  
  public DataBaseConfig(Context paramContext, String paramString, boolean paramBoolean, int paramInt, SQLiteHelper.OnUpdateListener paramOnUpdateListener) {
    this.context = paramContext.getApplicationContext();
    if (!Checker.isEmpty(paramString))
      this.dbName = paramString; 
    if (paramInt > 1)
      this.dbVersion = paramInt; 
    this.debugged = paramBoolean;
    this.onUpdateListener = paramOnUpdateListener;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DataBaseConfig [mContext=");
    stringBuilder.append(this.context);
    stringBuilder.append(", mDbName=");
    stringBuilder.append(this.dbName);
    stringBuilder.append(", mDbVersion=");
    stringBuilder.append(this.dbVersion);
    stringBuilder.append(", mOnUpdateListener=");
    stringBuilder.append(this.onUpdateListener);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\DataBaseConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */