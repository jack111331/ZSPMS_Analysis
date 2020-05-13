package com.litesuits.orm.db.assit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import com.litesuits.orm.db.TableManager;
import com.litesuits.orm.db.model.ColumnsValue;
import com.litesuits.orm.db.model.EntityTable;
import com.litesuits.orm.db.model.MapInfo;
import com.litesuits.orm.db.model.Property;
import com.litesuits.orm.db.utils.ClassUtil;
import com.litesuits.orm.db.utils.DataUtil;
import com.litesuits.orm.db.utils.FieldUtil;
import com.litesuits.orm.log.OrmLog;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class SQLStatement implements Serializable {
  public static final int IN_TOP_LIMIT = 999;
  
  public static final short NONE = -1;
  
  public static final short NORMAL = 0;
  
  private static final String TAG = "SQLStatement";
  
  private static final long serialVersionUID = -3790876762607683712L;
  
  public Object[] bindArgs;
  
  private SQLiteStatement mStatement;
  
  public String sql;
  
  public SQLStatement() {}
  
  public SQLStatement(String paramString, Object[] paramArrayOfObject) {
    this.sql = paramString;
    this.bindArgs = paramArrayOfObject;
  }
  
  private void mapRelationToDb(final Object mapTable, final boolean insertNew, final boolean tableCheck, SQLiteDatabase paramSQLiteDatabase, final TableManager tableManager) {
    mapTable = SQLBuilder.buildMappingInfo(mapTable, insertNew, tableManager);
    if (mapTable != null && !mapTable.isEmpty())
      Transaction.execute(paramSQLiteDatabase, new Transaction.Worker<Boolean>() {
            public Boolean doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception {
              if (insertNew && tableCheck)
                for (MapInfo.MapTable mapTable : mapTable.tableList)
                  tableManager.checkOrCreateMappingTable(param1SQLiteDatabase, mapTable.name, mapTable.column1, mapTable.column2);  
              if (mapTable.delOldRelationSQL != null) {
                Iterator<SQLStatement> iterator = mapTable.delOldRelationSQL.iterator();
                while (iterator.hasNext()) {
                  long l = ((SQLStatement)iterator.next()).execDelete(param1SQLiteDatabase);
                  if (OrmLog.isPrint) {
                    String str = SQLStatement.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Exec delete mapping success, nums: ");
                    stringBuilder.append(l);
                    OrmLog.v(str, stringBuilder.toString());
                  } 
                } 
              } 
              if (insertNew && mapTable.mapNewRelationSQL != null) {
                Iterator<SQLStatement> iterator = mapTable.mapNewRelationSQL.iterator();
                while (iterator.hasNext()) {
                  long l = ((SQLStatement)iterator.next()).execInsert(param1SQLiteDatabase);
                  if (OrmLog.isPrint) {
                    String str = SQLStatement.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Exec save mapping success, nums: ");
                    stringBuilder.append(l);
                    OrmLog.v(str, stringBuilder.toString());
                  } 
                } 
              } 
              return Boolean.valueOf(true);
            }
          }); 
  }
  
  private void printSQL() {
    if (OrmLog.isPrint) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SQL Execute: [");
      stringBuilder.append(this.sql);
      stringBuilder.append("] ARGS--> ");
      stringBuilder.append(Arrays.toString(this.bindArgs));
      OrmLog.d(str, stringBuilder.toString());
    } 
  }
  
  private void realease() {
    if (this.mStatement != null)
      this.mStatement.close(); 
    this.bindArgs = null;
    this.mStatement = null;
  }
  
  protected void bind(int paramInt, Object paramObject) throws IOException {
    if (paramObject == null) {
      this.mStatement.bindNull(paramInt);
    } else {
      if (paramObject instanceof CharSequence || paramObject instanceof Boolean || paramObject instanceof Character) {
        this.mStatement.bindString(paramInt, String.valueOf(paramObject));
        return;
      } 
      if (paramObject instanceof Float || paramObject instanceof Double) {
        this.mStatement.bindDouble(paramInt, ((Number)paramObject).doubleValue());
        return;
      } 
      if (paramObject instanceof Number) {
        this.mStatement.bindLong(paramInt, ((Number)paramObject).longValue());
      } else if (paramObject instanceof Date) {
        this.mStatement.bindLong(paramInt, ((Date)paramObject).getTime());
      } else if (paramObject instanceof byte[]) {
        this.mStatement.bindBlob(paramInt, (byte[])paramObject);
      } else if (paramObject instanceof Serializable) {
        this.mStatement.bindBlob(paramInt, DataUtil.objectToByte(paramObject));
      } else {
        this.mStatement.bindNull(paramInt);
      } 
    } 
  }
  
  public int execDelete(SQLiteDatabase paramSQLiteDatabase) throws IOException {
    return execDeleteWithMapping(paramSQLiteDatabase, null, null);
  }
  
  public int execDeleteCollection(SQLiteDatabase paramSQLiteDatabase, Collection<?> paramCollection) throws IOException {
    return execDeleteCollectionWithMapping(paramSQLiteDatabase, paramCollection, null);
  }
  
  public int execDeleteCollectionWithMapping(SQLiteDatabase paramSQLiteDatabase, final Collection<?> collection, final TableManager tableManager) throws IOException {
    int i;
    printSQL();
    this.mStatement = paramSQLiteDatabase.compileStatement(this.sql);
    if (this.bindArgs != null)
      for (i = 0; i < this.bindArgs.length; i = j) {
        int j = i + 1;
        bind(j, this.bindArgs[i]);
      }  
    if (Build.VERSION.SDK_INT < 11) {
      this.mStatement.execute();
      i = collection.size();
    } else {
      i = this.mStatement.executeUpdateDelete();
    } 
    if (OrmLog.isPrint) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SQL execute delete, changed rows --> ");
      stringBuilder.append(i);
      OrmLog.v(str, stringBuilder.toString());
    } 
    realease();
    if (tableManager != null) {
      Boolean bool = Transaction.<Boolean>execute(paramSQLiteDatabase, new Transaction.Worker<Boolean>() {
            public Boolean doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception {
              Iterator<Object> iterator = collection.iterator();
              for (boolean bool = true; iterator.hasNext(); bool = false) {
                Object object = iterator.next();
                SQLStatement.this.mapRelationToDb(object, false, bool, param1SQLiteDatabase, tableManager);
              } 
              return Boolean.valueOf(true);
            }
          });
      if (OrmLog.isPrint) {
        String str1;
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exec delete collection mapping: ");
        if (bool != null && bool.booleanValue()) {
          str1 = "成功";
        } else {
          str1 = "失败";
        } 
        stringBuilder.append(str1);
        OrmLog.i(str2, stringBuilder.toString());
      } 
    } 
    return i;
  }
  
  public int execDeleteWithMapping(SQLiteDatabase paramSQLiteDatabase, Object paramObject, TableManager paramTableManager) throws IOException {
    int i;
    printSQL();
    this.mStatement = paramSQLiteDatabase.compileStatement(this.sql);
    Object[] arrayOfObject = this.bindArgs;
    boolean bool = false;
    if (arrayOfObject != null)
      for (i = 0; i < this.bindArgs.length; i = j) {
        int j = i + 1;
        bind(j, this.bindArgs[i]);
      }  
    if (Build.VERSION.SDK_INT < 11) {
      this.mStatement.execute();
      i = bool;
    } else {
      i = this.mStatement.executeUpdateDelete();
    } 
    if (OrmLog.isPrint) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SQL execute delete, changed rows--> ");
      stringBuilder.append(i);
      OrmLog.v(str, stringBuilder.toString());
    } 
    realease();
    if (paramTableManager != null && paramObject != null)
      mapRelationToDb(paramObject, false, false, paramSQLiteDatabase, paramTableManager); 
    return i;
  }
  
  public long execInsert(SQLiteDatabase paramSQLiteDatabase) throws IOException, IllegalAccessException {
    return execInsertWithMapping(paramSQLiteDatabase, null, null);
  }
  
  public long execInsert(SQLiteDatabase paramSQLiteDatabase, Object paramObject) throws IOException, IllegalAccessException {
    return execInsertWithMapping(paramSQLiteDatabase, paramObject, null);
  }
  
  public int execInsertCollection(SQLiteDatabase paramSQLiteDatabase, Collection<?> paramCollection) {
    return execInsertCollectionWithMapping(paramSQLiteDatabase, paramCollection, null);
  }
  
  public int execInsertCollectionWithMapping(SQLiteDatabase paramSQLiteDatabase, Collection<?> paramCollection, TableManager paramTableManager) {
    printSQL();
    paramSQLiteDatabase.beginTransaction();
    if (OrmLog.isPrint)
      OrmLog.i(TAG, "----> BeginTransaction[insert col]"); 
    try {
      this.mStatement = paramSQLiteDatabase.compileStatement(this.sql);
      Iterator<?> iterator = paramCollection.iterator();
      EntityTable entityTable = null;
      boolean bool = true;
      while (iterator.hasNext()) {
        byte b;
        this.mStatement.clearBindings();
        Object object = iterator.next();
        EntityTable entityTable1 = entityTable;
        if (entityTable == null)
          entityTable1 = TableManager.getTable(object); 
        if (entityTable1.key != null) {
          Object object1 = FieldUtil.getAssignedKeyObject(entityTable1.key, object);
          b = 2;
          bind(1, object1);
        } else {
          entityTable = null;
          b = 1;
        } 
        if (!Checker.isEmpty(entityTable1.pmap)) {
          Iterator iterator1 = entityTable1.pmap.values().iterator();
          while (iterator1.hasNext()) {
            bind(b, FieldUtil.get(((Property)iterator1.next()).field, object));
            b++;
          } 
        } 
        long l = this.mStatement.executeInsert();
        FieldUtil.setKeyValueIfneed(object, entityTable1.key, entityTable, l);
        entityTable = entityTable1;
        if (paramTableManager != null) {
          mapRelationToDb(object, true, bool, paramSQLiteDatabase, paramTableManager);
          bool = false;
          entityTable = entityTable1;
        } 
      } 
      if (OrmLog.isPrint) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Exec insert [");
        stringBuilder.append(paramCollection.size());
        stringBuilder.append("] rows , SQL: ");
        stringBuilder.append(this.sql);
        OrmLog.i(str, stringBuilder.toString());
      } 
      paramSQLiteDatabase.setTransactionSuccessful();
      if (OrmLog.isPrint)
        OrmLog.i(TAG, "----> BeginTransaction[insert col] Successful"); 
      int i = paramCollection.size();
      realease();
      paramSQLiteDatabase.endTransaction();
      return i;
    } catch (Exception exception) {
      if (OrmLog.isPrint)
        OrmLog.e(TAG, "----> BeginTransaction[insert col] Failling"); 
      exception.printStackTrace();
      realease();
      paramSQLiteDatabase.endTransaction();
      return -1;
    } finally {}
    realease();
    paramSQLiteDatabase.endTransaction();
    throw paramCollection;
  }
  
  public long execInsertWithMapping(SQLiteDatabase paramSQLiteDatabase, Object paramObject, TableManager paramTableManager) throws IllegalAccessException, IOException {
    Object object;
    printSQL();
    this.mStatement = paramSQLiteDatabase.compileStatement(this.sql);
    if (!Checker.isEmpty(this.bindArgs)) {
      object = this.bindArgs;
      int i = 0;
      Object object1 = object[0];
      while (true) {
        Object object2 = object1;
        if (i < this.bindArgs.length) {
          int j = i + 1;
          bind(j, this.bindArgs[i]);
          i = j;
          continue;
        } 
        break;
      } 
    } else {
      object = null;
    } 
    try {
      long l = this.mStatement.executeInsert();
      realease();
      if (OrmLog.isPrint) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SQL Execute Insert RowID --> ");
        stringBuilder.append(l);
        stringBuilder.append("    sql: ");
        stringBuilder.append(this.sql);
        OrmLog.i(str, stringBuilder.toString());
      } 
      if (paramObject != null)
        FieldUtil.setKeyValueIfneed(paramObject, (TableManager.getTable(paramObject)).key, object, l); 
      return l;
    } finally {
      realease();
    } 
  }
  
  public int execUpdate(SQLiteDatabase paramSQLiteDatabase) throws IOException {
    return execUpdateWithMapping(paramSQLiteDatabase, null, null);
  }
  
  public int execUpdateCollection(SQLiteDatabase paramSQLiteDatabase, Collection<?> paramCollection, ColumnsValue paramColumnsValue) {
    return execUpdateCollectionWithMapping(paramSQLiteDatabase, paramCollection, paramColumnsValue, null);
  }
  
  public int execUpdateCollectionWithMapping(SQLiteDatabase paramSQLiteDatabase, Collection<?> paramCollection, ColumnsValue paramColumnsValue, TableManager paramTableManager) {
    printSQL();
    paramSQLiteDatabase.beginTransaction();
    if (OrmLog.isPrint)
      OrmLog.d(TAG, "----> BeginTransaction[update col]"); 
    try {
      this.mStatement = paramSQLiteDatabase.compileStatement(this.sql);
      Iterator<?> iterator = paramCollection.iterator();
      EntityTable entityTable = null;
      boolean bool = true;
      while (iterator.hasNext()) {
        this.mStatement.clearBindings();
        Object object = iterator.next();
        EntityTable entityTable1 = entityTable;
        if (entityTable == null)
          entityTable1 = TableManager.getTable(object); 
        this.bindArgs = SQLBuilder.buildUpdateSqlArgsOnly(object, paramColumnsValue);
        if (!Checker.isEmpty(this.bindArgs)) {
          int j;
          for (j = 0; j < this.bindArgs.length; j = k) {
            int k = j + 1;
            bind(k, this.bindArgs[j]);
          } 
        } 
        this.mStatement.execute();
        entityTable = entityTable1;
        if (paramTableManager != null) {
          mapRelationToDb(object, true, bool, paramSQLiteDatabase, paramTableManager);
          bool = false;
          entityTable = entityTable1;
        } 
      } 
      if (OrmLog.isPrint) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Exec update [");
        stringBuilder.append(paramCollection.size());
        stringBuilder.append("] rows , SQL: ");
        stringBuilder.append(this.sql);
        OrmLog.i(str, stringBuilder.toString());
      } 
      paramSQLiteDatabase.setTransactionSuccessful();
      if (OrmLog.isPrint)
        OrmLog.d(TAG, "----> BeginTransaction[update col] Successful"); 
      int i = paramCollection.size();
      realease();
      paramSQLiteDatabase.endTransaction();
      return i;
    } catch (Exception exception) {
      if (OrmLog.isPrint)
        OrmLog.e(TAG, "----> BeginTransaction[update col] Failling"); 
      exception.printStackTrace();
      realease();
      paramSQLiteDatabase.endTransaction();
      return -1;
    } finally {}
    realease();
    paramSQLiteDatabase.endTransaction();
    throw paramCollection;
  }
  
  public int execUpdateWithMapping(SQLiteDatabase paramSQLiteDatabase, Object paramObject, TableManager paramTableManager) throws IOException {
    int i;
    printSQL();
    this.mStatement = paramSQLiteDatabase.compileStatement(this.sql);
    boolean bool = Checker.isEmpty(this.bindArgs);
    boolean bool1 = false;
    if (!bool)
      for (i = 0; i < this.bindArgs.length; i = j) {
        int j = i + 1;
        bind(j, this.bindArgs[i]);
      }  
    if (Build.VERSION.SDK_INT < 11) {
      this.mStatement.execute();
      i = bool1;
    } else {
      i = this.mStatement.executeUpdateDelete();
    } 
    realease();
    if (OrmLog.isPrint) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SQL Execute update, changed rows --> ");
      stringBuilder.append(i);
      OrmLog.i(str, stringBuilder.toString());
    } 
    if (paramTableManager != null && paramObject != null)
      mapRelationToDb(paramObject, true, true, paramSQLiteDatabase, paramTableManager); 
    return i;
  }
  
  public boolean execute(SQLiteDatabase paramSQLiteDatabase) {
    printSQL();
    try {
      this.mStatement = paramSQLiteDatabase.compileStatement(this.sql);
      if (this.bindArgs != null)
        for (int i = 0; i < this.bindArgs.length; i = j) {
          int j = i + 1;
          bind(j, this.bindArgs[i]);
        }  
      this.mStatement.execute();
      realease();
      return true;
    } catch (Exception exception) {
      exception.printStackTrace();
      realease();
      return false;
    } finally {}
    realease();
    throw paramSQLiteDatabase;
  }
  
  public <T> ArrayList<T> query(SQLiteDatabase paramSQLiteDatabase, Class<T> paramClass) {
    printSQL();
    ArrayList<T> arrayList = new ArrayList();
    try {
      EntityTable entityTable = TableManager.getTable(paramClass, false);
      Querier.CursorParser<?> cursorParser = new Querier.CursorParser() {
          public void parseEachCursor(SQLiteDatabase param1SQLiteDatabase, Cursor param1Cursor) throws Exception {
            Object object = ClassUtil.newInstance(claxx);
            DataUtil.injectDataToObject(param1Cursor, object, table);
            list.add(object);
          }
        };
      super(this, paramClass, entityTable, arrayList);
      Querier.doQuery(paramSQLiteDatabase, this, cursorParser);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return arrayList;
  }
  
  public long queryForLong(SQLiteDatabase paramSQLiteDatabase) {
    printSQL();
    try {
      this.mStatement = paramSQLiteDatabase.compileStatement(this.sql);
      if (this.bindArgs != null)
        for (int i = 0; i < this.bindArgs.length; i = j) {
          int j = i + 1;
          bind(j, this.bindArgs[i]);
        }  
      long l1 = this.mStatement.simpleQueryForLong();
      long l2 = l1;
      try {
        if (OrmLog.isPrint) {
          String str = TAG;
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("SQL execute query for count --> ");
          stringBuilder.append(l1);
          OrmLog.i(str, stringBuilder.toString());
          l2 = l1;
        } 
      } catch (Exception exception) {
        l2 = l1;
      } 
    } catch (Exception exception) {
      long l = 0L;
    } finally {}
    paramSQLiteDatabase.printStackTrace();
  }
  
  public <T> T queryOneEntity(SQLiteDatabase paramSQLiteDatabase, final Class<T> claxx) {
    printSQL();
    return Querier.doQuery(paramSQLiteDatabase, this, new Querier.CursorParser<T>() {
          T t;
          
          public void parseEachCursor(SQLiteDatabase param1SQLiteDatabase, Cursor param1Cursor) throws Exception {
            this.t = (T)ClassUtil.newInstance(claxx);
            DataUtil.injectDataToObject(param1Cursor, this.t, table);
            stopParse();
          }
          
          public T returnResult() {
            return this.t;
          }
        });
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SQLStatement [sql=");
    stringBuilder.append(this.sql);
    stringBuilder.append(", bindArgs=");
    stringBuilder.append(Arrays.toString(this.bindArgs));
    stringBuilder.append(", mStatement=");
    stringBuilder.append(this.mStatement);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\assit\SQLStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */