package com.litesuits.orm.db.impl;

import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;
import com.litesuits.orm.db.TableManager;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.assit.CollSpliter;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.litesuits.orm.db.assit.SQLStatement;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.litesuits.orm.db.model.ColumnsValue;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import com.litesuits.orm.db.model.EntityTable;
import java.util.ArrayList;
import java.util.Collection;

public final class SingleSQLiteImpl extends LiteOrm {
  public static final String TAG = "SingleSQLiteImpl";
  
  protected SingleSQLiteImpl(LiteOrm paramLiteOrm) {
    super(paramLiteOrm);
  }
  
  private SingleSQLiteImpl(DataBaseConfig paramDataBaseConfig) {
    super(paramDataBaseConfig);
  }
  
  public static LiteOrm newInstance(DataBaseConfig paramDataBaseConfig) {
    // Byte code:
    //   0: ldc com/litesuits/orm/db/impl/SingleSQLiteImpl
    //   2: monitorenter
    //   3: new com/litesuits/orm/db/impl/SingleSQLiteImpl
    //   6: dup
    //   7: aload_0
    //   8: invokespecial <init> : (Lcom/litesuits/orm/db/DataBaseConfig;)V
    //   11: astore_0
    //   12: ldc com/litesuits/orm/db/impl/SingleSQLiteImpl
    //   14: monitorexit
    //   15: aload_0
    //   16: areturn
    //   17: astore_0
    //   18: ldc com/litesuits/orm/db/impl/SingleSQLiteImpl
    //   20: monitorexit
    //   21: aload_0
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	17	finally
  }
  
  public LiteOrm cascade() {
    if (this.otherDatabase == null)
      this.otherDatabase = new CascadeSQLiteImpl(this); 
    return this.otherDatabase;
  }
  
  public int delete(WhereBuilder paramWhereBuilder) {
    EntityTable entityTable = TableManager.getTable(paramWhereBuilder.getTableClass(), false);
    if (this.mTableManager.isSQLTableCreated(entityTable.name)) {
      acquireReference();
      try {
        SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
        int i = paramWhereBuilder.createStatementDelete().execDelete(sQLiteDatabase);
        releaseReference();
        return i;
      } catch (Exception exception) {
        exception.printStackTrace();
        releaseReference();
      } finally {}
    } 
    return -1;
  }
  
  public <T> int delete(Class<T> paramClass) {
    return deleteAll(paramClass);
  }
  
  public <T> int delete(Class<T> paramClass, long paramLong1, long paramLong2, String paramString) {
    EntityTable entityTable = TableManager.getTable(paramClass, false);
    if (this.mTableManager.isSQLTableCreated(entityTable.name)) {
      acquireReference();
      if (paramLong1 >= 0L && paramLong2 >= paramLong1) {
        long l = paramLong1;
        if (paramLong1 != 0L)
          l = paramLong1 - 1L; 
        if (paramLong2 == 2147483647L) {
          paramLong1 = -1L;
        } else {
          paramLong1 = paramLong2 - l;
        } 
        try {
          int i = SQLBuilder.buildDeleteSql(paramClass, l, paramLong1, paramString).execDelete(this.mHelper.getWritableDatabase());
          releaseReference();
          return i;
        } catch (Exception exception) {
          exception.printStackTrace();
          releaseReference();
        } finally {}
      } else {
        RuntimeException runtimeException = new RuntimeException();
        this("start must >=0 and smaller than end");
        throw runtimeException;
      } 
    } 
    return -1;
  }
  
  @Deprecated
  public <T> int delete(Class<T> paramClass, WhereBuilder paramWhereBuilder) {
    return delete(paramWhereBuilder);
  }
  
  public int delete(Object paramObject) {
    EntityTable entityTable = TableManager.getTable(paramObject);
    if (this.mTableManager.isSQLTableCreated(entityTable.name)) {
      acquireReference();
      try {
        SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
        int i = SQLBuilder.buildDeleteSql(paramObject).execDelete(sQLiteDatabase);
        releaseReference();
        return i;
      } catch (Exception exception) {
        exception.printStackTrace();
        releaseReference();
      } finally {}
    } 
    return -1;
  }
  
  public <T> int delete(Collection<T> paramCollection) {
    acquireReference();
    try {
      if (!Checker.isEmpty(paramCollection)) {
        EntityTable entityTable = TableManager.getTable(paramCollection.iterator().next());
        if (this.mTableManager.isSQLTableCreated(entityTable.name)) {
          SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
          sQLiteDatabase.beginTransaction();
          try {
            CollSpliter.Spliter<T> spliter = new CollSpliter.Spliter<T>() {
                public int oneSplit(ArrayList<T> param1ArrayList) throws Exception {
                  return SQLBuilder.buildDeleteSql(param1ArrayList).execDeleteCollection(db, param1ArrayList);
                }
              };
            super(this, sQLiteDatabase);
            int i = CollSpliter.split(paramCollection, 999, spliter);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            return i;
          } finally {
            sQLiteDatabase.endTransaction();
          } 
        } 
      } 
      releaseReference();
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
    } finally {}
    return -1;
  }
  
  public <T> int deleteAll(Class<T> paramClass) {
    EntityTable entityTable = TableManager.getTable(paramClass, false);
    if (this.mTableManager.isSQLTableCreated(entityTable.name)) {
      acquireReference();
      try {
        SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
        int i = SQLBuilder.buildDeleteAllSql(paramClass).execDelete(sQLiteDatabase);
        releaseReference();
        return i;
      } catch (Exception exception) {
        exception.printStackTrace();
        releaseReference();
      } finally {}
    } 
    return -1;
  }
  
  public <T> int insert(Collection<T> paramCollection) {
    return insert(paramCollection, (ConflictAlgorithm)null);
  }
  
  public <T> int insert(Collection<T> paramCollection, ConflictAlgorithm paramConflictAlgorithm) {
    acquireReference();
    try {
      if (!Checker.isEmpty(paramCollection)) {
        SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
        Object object = paramCollection.iterator().next();
        SQLStatement sQLStatement = SQLBuilder.buildInsertAllSql(object, paramConflictAlgorithm);
        this.mTableManager.checkOrCreateTable(sQLiteDatabase, object);
        int i = sQLStatement.execInsertCollection(sQLiteDatabase, paramCollection);
        releaseReference();
        return i;
      } 
      releaseReference();
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
    } finally {}
    return -1;
  }
  
  public long insert(Object paramObject) {
    return insert(paramObject, (ConflictAlgorithm)null);
  }
  
  public long insert(Object paramObject, ConflictAlgorithm paramConflictAlgorithm) {
    acquireReference();
    try {
      SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
      this.mTableManager.checkOrCreateTable(sQLiteDatabase, paramObject);
      long l = SQLBuilder.buildInsertSql(paramObject, paramConflictAlgorithm).execInsert(sQLiteDatabase, paramObject);
      releaseReference();
      return l;
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
      return -1L;
    } finally {}
    releaseReference();
    throw paramObject;
  }
  
  public <T> ArrayList<T> query(QueryBuilder<T> paramQueryBuilder) {
    EntityTable entityTable = TableManager.getTable(paramQueryBuilder.getQueryClass(), false);
    if (this.mTableManager.isSQLTableCreated(entityTable.name)) {
      acquireReference();
      try {
        return paramQueryBuilder.createStatement().query(this.mHelper.getReadableDatabase(), paramQueryBuilder.getQueryClass());
      } finally {
        releaseReference();
      } 
    } 
    return new ArrayList<T>();
  }
  
  public <T> ArrayList<T> query(Class<T> paramClass) {
    return query(new QueryBuilder(paramClass));
  }
  
  public <T> T queryById(long paramLong, Class<T> paramClass) {
    return queryById(String.valueOf(paramLong), paramClass);
  }
  
  public <T> T queryById(String paramString, Class<T> paramClass) {
    EntityTable entityTable = TableManager.getTable(paramClass, false);
    if (this.mTableManager.isSQLTableCreated(entityTable.name)) {
      acquireReference();
      try {
        QueryBuilder queryBuilder = new QueryBuilder();
        this(paramClass);
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(entityTable.key.column);
        stringBuilder.append("=?");
        ArrayList<ArrayList> arrayList = queryBuilder.where(stringBuilder.toString(), (Object[])new String[] { paramString }).createStatement().query(this.mHelper.getReadableDatabase(), paramClass);
        if (!Checker.isEmpty(arrayList)) {
          arrayList = arrayList.get(0);
          return (T)arrayList;
        } 
      } finally {
        releaseReference();
      } 
    } 
    return null;
  }
  
  public <T> int save(Collection<T> paramCollection) {
    acquireReference();
    try {
      if (!Checker.isEmpty(paramCollection)) {
        SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
        Object object = paramCollection.iterator().next();
        this.mTableManager.checkOrCreateTable(sQLiteDatabase, object);
        int i = SQLBuilder.buildReplaceAllSql(object).execInsertCollection(sQLiteDatabase, paramCollection);
        releaseReference();
        return i;
      } 
      releaseReference();
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
    } finally {}
    return -1;
  }
  
  public long save(Object paramObject) {
    acquireReference();
    try {
      SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
      this.mTableManager.checkOrCreateTable(sQLiteDatabase, paramObject);
      long l = SQLBuilder.buildReplaceSql(paramObject).execInsert(sQLiteDatabase, paramObject);
      releaseReference();
      return l;
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
      return -1L;
    } finally {}
    releaseReference();
    throw paramObject;
  }
  
  public LiteOrm single() {
    return this;
  }
  
  public int update(Object paramObject) {
    return update(paramObject, (ColumnsValue)null, (ConflictAlgorithm)null);
  }
  
  public int update(Object paramObject, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm) {
    acquireReference();
    try {
      SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
      this.mTableManager.checkOrCreateTable(sQLiteDatabase, paramObject);
      int i = SQLBuilder.buildUpdateSql(paramObject, paramColumnsValue, paramConflictAlgorithm).execUpdate(sQLiteDatabase);
      releaseReference();
      return i;
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
      return -1;
    } finally {}
    releaseReference();
    throw paramObject;
  }
  
  public int update(Object paramObject, ConflictAlgorithm paramConflictAlgorithm) {
    return update(paramObject, (ColumnsValue)null, paramConflictAlgorithm);
  }
  
  public <T> int update(Collection<T> paramCollection) {
    return update(paramCollection, (ColumnsValue)null, (ConflictAlgorithm)null);
  }
  
  public <T> int update(Collection<T> paramCollection, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm) {
    acquireReference();
    try {
      if (!Checker.isEmpty(paramCollection)) {
        SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
        Object object = paramCollection.iterator().next();
        this.mTableManager.checkOrCreateTable(sQLiteDatabase, object);
        int i = SQLBuilder.buildUpdateAllSql(object, paramColumnsValue, paramConflictAlgorithm).execUpdateCollection(sQLiteDatabase, paramCollection, paramColumnsValue);
        releaseReference();
        return i;
      } 
      releaseReference();
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
    } finally {}
    return -1;
  }
  
  public <T> int update(Collection<T> paramCollection, ConflictAlgorithm paramConflictAlgorithm) {
    return update(paramCollection, (ColumnsValue)null, paramConflictAlgorithm);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\impl\SingleSQLiteImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */