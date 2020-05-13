package com.yingxiong.until;

import android.content.Context;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;
import com.litesuits.orm.db.assit.QueryBuilder;
import java.util.List;

public class DatabaseManager {
  private static Context context;
  
  private static LiteOrm liteOrm;
  
  private static DatabaseManager ourInstance;
  
  private DatabaseManager() {
    DataBaseConfig dataBaseConfig = new DataBaseConfig(context);
    dataBaseConfig.dbName = "record.db";
    dataBaseConfig.debugged = false;
    dataBaseConfig.dbVersion = 2;
    liteOrm = LiteOrm.newCascadeInstance(dataBaseConfig);
  }
  
  public static DatabaseManager getInstance() {
    // Byte code:
    //   0: ldc com/yingxiong/until/DatabaseManager
    //   2: monitorenter
    //   3: getstatic com/yingxiong/until/DatabaseManager.ourInstance : Lcom/yingxiong/until/DatabaseManager;
    //   6: ifnonnull -> 42
    //   9: ldc com/yingxiong/until/DatabaseManager
    //   11: monitorenter
    //   12: getstatic com/yingxiong/until/DatabaseManager.ourInstance : Lcom/yingxiong/until/DatabaseManager;
    //   15: ifnonnull -> 30
    //   18: new com/yingxiong/until/DatabaseManager
    //   21: astore_0
    //   22: aload_0
    //   23: invokespecial <init> : ()V
    //   26: aload_0
    //   27: putstatic com/yingxiong/until/DatabaseManager.ourInstance : Lcom/yingxiong/until/DatabaseManager;
    //   30: ldc com/yingxiong/until/DatabaseManager
    //   32: monitorexit
    //   33: goto -> 42
    //   36: astore_0
    //   37: ldc com/yingxiong/until/DatabaseManager
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    //   42: getstatic com/yingxiong/until/DatabaseManager.ourInstance : Lcom/yingxiong/until/DatabaseManager;
    //   45: astore_0
    //   46: ldc com/yingxiong/until/DatabaseManager
    //   48: monitorexit
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: ldc com/yingxiong/until/DatabaseManager
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	51	finally
    //   12	30	36	finally
    //   30	33	36	finally
    //   37	40	36	finally
    //   40	42	51	finally
    //   42	46	51	finally
  }
  
  public static void init(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: putstatic com/yingxiong/until/DatabaseManager.context : Landroid/content/Context;
    //   4: getstatic com/yingxiong/until/DatabaseManager.ourInstance : Lcom/yingxiong/until/DatabaseManager;
    //   7: ifnonnull -> 43
    //   10: ldc com/yingxiong/until/DatabaseManager
    //   12: monitorenter
    //   13: getstatic com/yingxiong/until/DatabaseManager.ourInstance : Lcom/yingxiong/until/DatabaseManager;
    //   16: ifnonnull -> 31
    //   19: new com/yingxiong/until/DatabaseManager
    //   22: astore_0
    //   23: aload_0
    //   24: invokespecial <init> : ()V
    //   27: aload_0
    //   28: putstatic com/yingxiong/until/DatabaseManager.ourInstance : Lcom/yingxiong/until/DatabaseManager;
    //   31: ldc com/yingxiong/until/DatabaseManager
    //   33: monitorexit
    //   34: goto -> 43
    //   37: astore_0
    //   38: ldc com/yingxiong/until/DatabaseManager
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    //   43: return
    // Exception table:
    //   from	to	target	type
    //   13	31	37	finally
    //   31	34	37	finally
    //   38	41	37	finally
  }
  
  public <T> void delete(Class<T> paramClass) {
    liteOrm.delete(paramClass);
  }
  
  public <T> void delete(T paramT) {
    liteOrm.delete(paramT);
  }
  
  public void deleteDatabase() {
    liteOrm.deleteDatabase();
  }
  
  public <T> void deleteList(List<T> paramList) {
    liteOrm.delete(paramList);
  }
  
  public <T> List<T> getQueryAll(Class<T> paramClass) {
    return liteOrm.query(paramClass);
  }
  
  public <T> List<T> getQueryByWhere(Class<T> paramClass, String paramString, String[] paramArrayOfString) {
    LiteOrm liteOrm = liteOrm;
    QueryBuilder queryBuilder = new QueryBuilder(paramClass);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("=?");
    return liteOrm.query(queryBuilder.where(stringBuilder.toString(), (Object[])paramArrayOfString));
  }
  
  public <T> List<T> getQueryByWhereLength(Class<T> paramClass, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2) {
    LiteOrm liteOrm = liteOrm;
    QueryBuilder queryBuilder = new QueryBuilder(paramClass);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("=?");
    return liteOrm.query(queryBuilder.where(stringBuilder.toString(), (Object[])paramArrayOfString).limit(paramInt1, paramInt2));
  }
  
  public <T> long insert(T paramT) {
    try {
      return liteOrm.save(paramT);
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0L;
    } 
  }
  
  public <T> void insertAll(List<T> paramList) {
    liteOrm.save(paramList);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxion\\until\DatabaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */