package com.litesuits.orm.db.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;
import com.litesuits.orm.db.TableManager;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.assit.Querier;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.litesuits.orm.db.assit.SQLStatement;
import com.litesuits.orm.db.assit.Transaction;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.litesuits.orm.db.model.ColumnsValue;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import com.litesuits.orm.db.model.EntityTable;
import com.litesuits.orm.db.model.MapProperty;
import com.litesuits.orm.db.model.Primarykey;
import com.litesuits.orm.db.model.Property;
import com.litesuits.orm.db.model.RelationKey;
import com.litesuits.orm.db.utils.ClassUtil;
import com.litesuits.orm.db.utils.DataUtil;
import com.litesuits.orm.db.utils.FieldUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class CascadeSQLiteImpl extends LiteOrm {
  public static final String TAG = "CascadeSQLiteImpl";
  
  public static final int TYPE_DELETE = 3;
  
  public static final int TYPE_INSERT = 1;
  
  public static final int TYPE_UPDATE = 2;
  
  protected CascadeSQLiteImpl(LiteOrm paramLiteOrm) {
    super(paramLiteOrm);
  }
  
  private CascadeSQLiteImpl(DataBaseConfig paramDataBaseConfig) {
    super(paramDataBaseConfig);
  }
  
  private int checkTableAndDeleteRecursive(Object paramObject, SQLiteDatabase paramSQLiteDatabase, HashMap<String, Integer> paramHashMap) throws Exception {
    EntityTable entityTable = TableManager.getTable(paramObject);
    return this.mTableManager.isSQLTableCreated(entityTable.name) ? deleteRecursive(SQLBuilder.buildDeleteSql(paramObject), paramObject, paramSQLiteDatabase, paramHashMap) : -1;
  }
  
  private <T> ArrayList<T> checkTableAndQuery(Class<T> paramClass, QueryBuilder paramQueryBuilder) {
    acquireReference();
    ArrayList<T> arrayList = new ArrayList();
    try {
      EntityTable entityTable = TableManager.getTable(paramClass, false);
      if (this.mTableManager.isSQLTableCreated(entityTable.name)) {
        HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
        this();
        HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        this();
        SQLiteDatabase sQLiteDatabase = this.mHelper.getReadableDatabase();
        SQLStatement sQLStatement = paramQueryBuilder.createStatement();
        Querier.CursorParser cursorParser = new Querier.CursorParser() {
            public void parseEachCursor(SQLiteDatabase param1SQLiteDatabase, Cursor param1Cursor) throws Exception {
              Object object = ClassUtil.newInstance(claxx);
              DataUtil.injectDataToObject(param1Cursor, object, table);
              list.add(object);
              HashMap<String, Object> hashMap = entityMap;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(table.name);
              stringBuilder.append(FieldUtil.get(table.key.field, object));
              hashMap.put(stringBuilder.toString(), object);
            }
          };
        super(this, paramClass, entityTable, arrayList, hashMap1);
        Querier.doQuery(sQLiteDatabase, sQLStatement, cursorParser);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext())
          queryForMappingRecursive(iterator.next(), sQLiteDatabase, (HashMap)hashMap2, (HashMap)hashMap1); 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {}
    releaseReference();
    return arrayList;
  }
  
  private long checkTableAndSaveRecursive(Object paramObject, SQLiteDatabase paramSQLiteDatabase, HashMap<String, Integer> paramHashMap) throws Exception {
    this.mTableManager.checkOrCreateTable(paramSQLiteDatabase, paramObject);
    return insertRecursive(SQLBuilder.buildReplaceSql(paramObject), paramObject, paramSQLiteDatabase, paramHashMap);
  }
  
  private <T> int deleteCollectionIfTableHasCreated(final Collection<T> collection) {
    if (!Checker.isEmpty(collection)) {
      final Iterator<T> iterator = collection.iterator();
      final T entity = iterator.next();
      EntityTable entityTable = TableManager.getTable(t);
      if (this.mTableManager.isSQLTableCreated(entityTable.name)) {
        Integer integer = (Integer)Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Integer>() {
              public Integer doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception {
                HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                SQLStatement sQLStatement = SQLBuilder.buildDeleteSql(entity);
                CascadeSQLiteImpl.this.deleteRecursive(sQLStatement, entity, param1SQLiteDatabase, (HashMap)hashMap);
                while (iterator.hasNext()) {
                  Object object = iterator.next();
                  sQLStatement.bindArgs = CascadeSQLiteImpl.getDeleteStatementArgs(object);
                  CascadeSQLiteImpl.this.deleteRecursive(sQLStatement, object, param1SQLiteDatabase, (HashMap)hashMap);
                } 
                return Integer.valueOf(collection.size());
              }
            });
        if (integer != null)
          return integer.intValue(); 
      } 
    } 
    return -1;
  }
  
  private int deleteRecursive(SQLStatement paramSQLStatement, Object paramObject, SQLiteDatabase paramSQLiteDatabase, HashMap<String, Integer> paramHashMap) throws Exception {
    EntityTable entityTable = TableManager.getTable(paramObject);
    Object object = FieldUtil.get(entityTable.key.field, paramObject);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(entityTable.name);
    stringBuilder2.append(object);
    if (paramHashMap.get(stringBuilder2.toString()) != null)
      return -1; 
    int i = paramSQLStatement.execDelete(paramSQLiteDatabase);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(entityTable.name);
    stringBuilder1.append(object);
    paramHashMap.put(stringBuilder1.toString(), Integer.valueOf(1));
    handleMapping(object, paramObject, paramSQLiteDatabase, false, paramHashMap);
    return i;
  }
  
  public static Object[] getDeleteStatementArgs(Object paramObject) throws IllegalAccessException {
    EntityTable entityTable = TableManager.getTable(paramObject);
    Primarykey primarykey = entityTable.key;
    byte b = 0;
    if (primarykey != null)
      return (Object[])new String[] { String.valueOf(FieldUtil.get(entityTable.key.field, paramObject)) }; 
    if (!Checker.isEmpty(entityTable.pmap)) {
      Object[] arrayOfObject = new Object[entityTable.pmap.size()];
      Iterator iterator = entityTable.pmap.values().iterator();
      while (iterator.hasNext()) {
        arrayOfObject[b] = FieldUtil.get(((Property)iterator.next()).field, paramObject);
        b++;
      } 
      return arrayOfObject;
    } 
    return null;
  }
  
  private long handleEntityRecursive(int paramInt, SQLStatement paramSQLStatement, Object paramObject, SQLiteDatabase paramSQLiteDatabase, HashMap<String, Integer> paramHashMap) throws Exception {
    Object object1;
    boolean bool;
    EntityTable entityTable = TableManager.getTable(paramObject);
    Object object2 = FieldUtil.get(entityTable.key.field, paramObject);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(entityTable.name);
    stringBuilder.append(object2);
    stringBuilder = (StringBuilder)paramHashMap.get(stringBuilder.toString());
    long l = -1L;
    if (stringBuilder != null)
      return -1L; 
    switch (paramInt) {
      default:
        object1 = object2;
        break;
      case 3:
        l = object1.execDelete(paramSQLiteDatabase);
      case 2:
        l = object1.execUpdate(paramSQLiteDatabase);
      case 1:
        l = object1.execInsert(paramSQLiteDatabase, paramObject);
        object1 = FieldUtil.get(entityTable.key.field, paramObject);
        break;
    } 
    object2 = new StringBuilder();
    object2.append(entityTable.name);
    object2.append(object1);
    paramHashMap.put(object2.toString(), Integer.valueOf(1));
    if (paramInt != 3) {
      bool = true;
    } else {
      bool = false;
    } 
    handleMapping(object1, paramObject, paramSQLiteDatabase, bool, paramHashMap);
    return l;
  }
  
  private void handleMapToMany(EntityTable paramEntityTable1, EntityTable paramEntityTable2, Object paramObject, Collection paramCollection, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, HashMap<String, Integer> paramHashMap) throws Exception {
    if (paramCollection != null)
      for (Object object : paramCollection) {
        if (object != null) {
          if (paramBoolean) {
            checkTableAndSaveRecursive(object, paramSQLiteDatabase, paramHashMap);
            continue;
          } 
          checkTableAndDeleteRecursive(object, paramSQLiteDatabase, paramHashMap);
        } 
      }  
    String str = TableManager.getMapTableName(paramEntityTable1, paramEntityTable2);
    this.mTableManager.checkOrCreateMappingTable(paramSQLiteDatabase, str, paramEntityTable1.name, paramEntityTable2.name);
    SQLBuilder.buildMappingDeleteSql(str, paramObject, paramEntityTable1).execDelete(paramSQLiteDatabase);
    if (paramBoolean && !Checker.isEmpty(paramCollection)) {
      ArrayList arrayList = SQLBuilder.buildMappingToManySql(paramObject, paramEntityTable1, paramEntityTable2, paramCollection);
      if (!Checker.isEmpty(arrayList)) {
        Iterator<SQLStatement> iterator = arrayList.iterator();
        while (iterator.hasNext())
          ((SQLStatement)iterator.next()).execInsert(paramSQLiteDatabase); 
      } 
    } 
  }
  
  private void handleMapToOne(EntityTable paramEntityTable1, EntityTable paramEntityTable2, Object paramObject1, Object paramObject2, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, HashMap<String, Integer> paramHashMap) throws Exception {
    if (paramObject2 != null)
      if (paramBoolean) {
        checkTableAndSaveRecursive(paramObject2, paramSQLiteDatabase, paramHashMap);
      } else {
        checkTableAndDeleteRecursive(paramObject2, paramSQLiteDatabase, paramHashMap);
      }  
    String str = TableManager.getMapTableName(paramEntityTable1, paramEntityTable2);
    this.mTableManager.checkOrCreateMappingTable(paramSQLiteDatabase, str, paramEntityTable1.name, paramEntityTable2.name);
    SQLBuilder.buildMappingDeleteSql(str, paramObject1, paramEntityTable1).execDelete(paramSQLiteDatabase);
    if (paramBoolean && paramObject2 != null) {
      SQLStatement sQLStatement = SQLBuilder.buildMappingToOneSql(str, paramObject1, FieldUtil.get(paramEntityTable2.key.field, paramObject2), paramEntityTable1, paramEntityTable2);
      if (sQLStatement != null)
        sQLStatement.execInsert(paramSQLiteDatabase); 
    } 
  }
  
  private void handleMapping(Object paramObject1, Object paramObject2, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, HashMap<String, Integer> paramHashMap) throws Exception {
    EntityTable entityTable = TableManager.getTable(paramObject2);
    if (entityTable.mappingList != null)
      for (MapProperty mapProperty : entityTable.mappingList) {
        if (mapProperty.isToOne()) {
          Object object = FieldUtil.get(mapProperty.field, paramObject2);
          handleMapToOne(entityTable, TableManager.getTable(mapProperty.field.getType()), paramObject1, object, paramSQLiteDatabase, paramBoolean, paramHashMap);
          continue;
        } 
        if (mapProperty.isToMany()) {
          Object object = FieldUtil.get(mapProperty.field, paramObject2);
          if (ClassUtil.isCollection(mapProperty.field.getType())) {
            handleMapToMany(entityTable, TableManager.getTable(FieldUtil.getGenericType(mapProperty.field)), paramObject1, (Collection)object, paramSQLiteDatabase, paramBoolean, paramHashMap);
            continue;
          } 
          if (ClassUtil.isArray(mapProperty.field.getType())) {
            List list;
            EntityTable entityTable1 = TableManager.getTable(FieldUtil.getComponentType(mapProperty.field));
            mapProperty = null;
            if (object != null)
              list = Arrays.asList((Object[])object); 
            handleMapToMany(entityTable, entityTable1, paramObject1, list, paramSQLiteDatabase, paramBoolean, paramHashMap);
            continue;
          } 
          throw new RuntimeException("OneToMany and ManyToMany Relation, you must use collection or array object");
        } 
      }  
  }
  
  private <T> int insertCollection(final Collection<T> collection, final ConflictAlgorithm conflictAlgorithm) {
    if (!Checker.isEmpty(collection)) {
      Integer integer = (Integer)Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Integer>() {
            public Integer doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception {
              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
              Iterator<Object> iterator = collection.iterator();
              Object object = iterator.next();
              SQLStatement sQLStatement = SQLBuilder.buildInsertSql(object, conflictAlgorithm);
              CascadeSQLiteImpl.this.mTableManager.checkOrCreateTable(param1SQLiteDatabase, object);
              CascadeSQLiteImpl.this.insertRecursive(sQLStatement, object, param1SQLiteDatabase, (HashMap)hashMap);
              while (iterator.hasNext()) {
                object = iterator.next();
                sQLStatement.bindArgs = SQLBuilder.buildInsertSqlArgsOnly(object);
                CascadeSQLiteImpl.this.insertRecursive(sQLStatement, object, param1SQLiteDatabase, (HashMap)hashMap);
              } 
              return Integer.valueOf(collection.size());
            }
          });
      if (integer != null)
        return integer.intValue(); 
    } 
    return -1;
  }
  
  private long insertRecursive(SQLStatement paramSQLStatement, Object paramObject, SQLiteDatabase paramSQLiteDatabase, HashMap<String, Integer> paramHashMap) throws Exception {
    EntityTable entityTable = TableManager.getTable(paramObject);
    Object object = FieldUtil.get(entityTable.key.field, paramObject);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(entityTable.name);
    stringBuilder2.append(object);
    if (paramHashMap.get(stringBuilder2.toString()) != null)
      return -1L; 
    long l = paramSQLStatement.execInsert(paramSQLiteDatabase, paramObject);
    object = FieldUtil.get(entityTable.key.field, paramObject);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(entityTable.name);
    stringBuilder1.append(object);
    paramHashMap.put(stringBuilder1.toString(), Integer.valueOf(1));
    handleMapping(object, paramObject, paramSQLiteDatabase, true, paramHashMap);
    return l;
  }
  
  public static LiteOrm newInstance(DataBaseConfig paramDataBaseConfig) {
    // Byte code:
    //   0: ldc com/litesuits/orm/db/impl/CascadeSQLiteImpl
    //   2: monitorenter
    //   3: new com/litesuits/orm/db/impl/CascadeSQLiteImpl
    //   6: dup
    //   7: aload_0
    //   8: invokespecial <init> : (Lcom/litesuits/orm/db/DataBaseConfig;)V
    //   11: astore_0
    //   12: ldc com/litesuits/orm/db/impl/CascadeSQLiteImpl
    //   14: monitorexit
    //   15: aload_0
    //   16: areturn
    //   17: astore_0
    //   18: ldc com/litesuits/orm/db/impl/CascadeSQLiteImpl
    //   20: monitorexit
    //   21: aload_0
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	17	finally
  }
  
  private void queryForMappingRecursive(Object paramObject, SQLiteDatabase paramSQLiteDatabase, HashMap<String, Integer> paramHashMap, HashMap<String, Object> paramHashMap1) throws IllegalAccessException, InstantiationException {
    EntityTable entityTable = TableManager.getTable(paramObject);
    Object object = FieldUtil.getAssignedKeyObject(entityTable.key, paramObject);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(entityTable.name);
    stringBuilder.append(object);
    String str = stringBuilder.toString();
    if (paramHashMap.get(str) == null) {
      paramHashMap.put(str, Integer.valueOf(1));
      if (entityTable.mappingList != null)
        for (MapProperty mapProperty : entityTable.mappingList) {
          if (mapProperty.isToOne()) {
            queryMapToOne(entityTable, object, paramObject, mapProperty.field, paramSQLiteDatabase, paramHashMap, paramHashMap1);
            continue;
          } 
          if (mapProperty.isToMany())
            queryMapToMany(entityTable, object, paramObject, mapProperty.field, paramSQLiteDatabase, paramHashMap, paramHashMap1); 
        }  
    } 
  }
  
  private void queryMapToMany(EntityTable paramEntityTable, final Object table2, Object paramObject2, Field paramField, SQLiteDatabase paramSQLiteDatabase, HashMap<String, Integer> paramHashMap, final HashMap<String, Object> entityMap) throws IllegalAccessException, InstantiationException {
    final Class class2;
    if (Collection.class.isAssignableFrom(paramField.getType())) {
      clazz = FieldUtil.getGenericType(paramField);
    } else if (paramField.getType().isArray()) {
      clazz = FieldUtil.getComponentType(paramField);
    } else {
      throw new RuntimeException("OneToMany and ManyToMany Relation, you must use collection or array object");
    } 
    final EntityTable table2 = TableManager.getTable(clazz);
    if (this.mTableManager.isSQLMapTableCreated(paramEntityTable.name, entityTable.name)) {
      table2 = SQLBuilder.buildQueryRelationSql(paramEntityTable, entityTable, table2);
      final ArrayList<String> key2List = new ArrayList();
      Querier.doQuery(paramSQLiteDatabase, (SQLStatement)table2, new Querier.CursorParser() {
            public void parseEachCursor(SQLiteDatabase param1SQLiteDatabase, Cursor param1Cursor) throws Exception {
              key2List.add(param1Cursor.getString(param1Cursor.getColumnIndex(table2.name)));
            }
          });
      if (!Checker.isEmpty(arrayList)) {
        final ArrayList<Object> allList2 = new ArrayList();
        int i;
        for (i = arrayList.size() - 1; i >= 0; i--) {
          table2 = new StringBuilder();
          table2.append(entityTable.name);
          table2.append(arrayList.get(i));
          table2 = entityMap.get(table2.toString());
          if (table2 != null) {
            arrayList1.add(table2);
            arrayList.remove(i);
          } 
        } 
        i = 0;
        byte b = 0;
        table2 = entityTable;
        while (i < arrayList.size()) {
          int j = ++b * 999;
          List<String> list = arrayList.subList(i, Math.min(arrayList.size(), j));
          Querier.doQuery(paramSQLiteDatabase, QueryBuilder.create(clazz).whereIn(((EntityTable)table2).key.column, list.toArray((Object[])new String[list.size()])).createStatement(), new Querier.CursorParser() {
                public void parseEachCursor(SQLiteDatabase param1SQLiteDatabase, Cursor param1Cursor) throws Exception {
                  Object object = ClassUtil.newInstance(class2);
                  DataUtil.injectDataToObject(param1Cursor, object, table2);
                  allList2.add(object);
                  HashMap<String, Object> hashMap = entityMap;
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(table2.name);
                  stringBuilder.append(FieldUtil.get(table2.key.field, object));
                  hashMap.put(stringBuilder.toString(), object);
                }
              });
          i = j;
        } 
        if (!Checker.isEmpty(arrayList1)) {
          if (Collection.class.isAssignableFrom(paramField.getType())) {
            Collection<Object> collection = (Collection)ClassUtil.newCollectionForField(paramField);
            collection.addAll(arrayList1);
            FieldUtil.set(paramField, paramObject2, collection);
          } else if (paramField.getType().isArray()) {
            FieldUtil.set(paramField, paramObject2, arrayList1.toArray((Object[])ClassUtil.newArray(clazz, arrayList1.size())));
          } else {
            throw new RuntimeException("OneToMany and ManyToMany Relation, you must use collection or array object");
          } 
          Iterator iterator = arrayList1.iterator();
          while (iterator.hasNext())
            queryForMappingRecursive(iterator.next(), paramSQLiteDatabase, paramHashMap, entityMap); 
        } 
      } 
    } 
  }
  
  private void queryMapToOne(final EntityTable table1, Object paramObject1, Object paramObject2, Field paramField, SQLiteDatabase paramSQLiteDatabase, HashMap<String, Integer> paramHashMap, HashMap<String, Object> paramHashMap1) throws IllegalAccessException, InstantiationException {
    final EntityTable table2 = TableManager.getTable(paramField.getType());
    if (this.mTableManager.isSQLMapTableCreated(table1.name, entityTable.name)) {
      paramObject1 = SQLBuilder.buildQueryRelationSql(table1, entityTable, paramObject1);
      final RelationKey relation = new RelationKey();
      Querier.doQuery(paramSQLiteDatabase, (SQLStatement)paramObject1, new Querier.CursorParser() {
            public void parseEachCursor(SQLiteDatabase param1SQLiteDatabase, Cursor param1Cursor) throws Exception {
              relation.key1 = param1Cursor.getString(param1Cursor.getColumnIndex(table1.name));
              relation.key2 = param1Cursor.getString(param1Cursor.getColumnIndex(table2.name));
              stopParse();
            }
          });
      if (relationKey.isOK()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(entityTable.name);
        stringBuilder.append(relationKey.key2);
        String str = stringBuilder.toString();
        paramObject1 = paramHashMap1.get(str);
        Object object = paramObject1;
        if (paramObject1 == null) {
          object = SQLBuilder.buildQueryMapEntitySql(entityTable, relationKey.key2).queryOneEntity(paramSQLiteDatabase, entityTable.claxx);
          paramHashMap1.put(str, object);
        } 
        if (object != null) {
          FieldUtil.set(paramField, paramObject2, object);
          queryForMappingRecursive(object, paramSQLiteDatabase, paramHashMap, paramHashMap1);
        } 
      } 
    } 
  }
  
  private <T> int saveCollection(final Collection<T> collection) {
    if (!Checker.isEmpty(collection)) {
      Integer integer = (Integer)Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Integer>() {
            public Integer doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception {
              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
              Iterator<Object> iterator = collection.iterator();
              Object object = iterator.next();
              SQLStatement sQLStatement = SQLBuilder.buildReplaceSql(object);
              CascadeSQLiteImpl.this.mTableManager.checkOrCreateTable(param1SQLiteDatabase, object);
              CascadeSQLiteImpl.this.insertRecursive(sQLStatement, object, param1SQLiteDatabase, (HashMap)hashMap);
              while (iterator.hasNext()) {
                object = iterator.next();
                sQLStatement.bindArgs = SQLBuilder.buildInsertSqlArgsOnly(object);
                CascadeSQLiteImpl.this.insertRecursive(sQLStatement, object, param1SQLiteDatabase, (HashMap)hashMap);
              } 
              return Integer.valueOf(collection.size());
            }
          });
      if (integer != null)
        return integer.intValue(); 
    } 
    return -1;
  }
  
  private <T> int updateCollection(final Collection<T> collection, final ColumnsValue cvs, final ConflictAlgorithm conflictAlgorithm) {
    if (!Checker.isEmpty(collection)) {
      Integer integer = (Integer)Transaction.execute(this.mHelper.getWritableDatabase(), new Transaction.Worker<Integer>() {
            public Integer doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception {
              HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
              Iterator<Object> iterator = collection.iterator();
              Object object = iterator.next();
              SQLStatement sQLStatement = SQLBuilder.buildUpdateSql(object, cvs, conflictAlgorithm);
              CascadeSQLiteImpl.this.mTableManager.checkOrCreateTable(param1SQLiteDatabase, object);
              CascadeSQLiteImpl.this.updateRecursive(sQLStatement, object, param1SQLiteDatabase, (HashMap)hashMap);
              while (iterator.hasNext()) {
                object = iterator.next();
                sQLStatement.bindArgs = SQLBuilder.buildUpdateSqlArgsOnly(object, cvs);
                CascadeSQLiteImpl.this.updateRecursive(sQLStatement, object, param1SQLiteDatabase, (HashMap)hashMap);
              } 
              return Integer.valueOf(collection.size());
            }
          });
      if (integer != null)
        return integer.intValue(); 
    } 
    return -1;
  }
  
  private int updateRecursive(SQLStatement paramSQLStatement, Object paramObject, SQLiteDatabase paramSQLiteDatabase, HashMap<String, Integer> paramHashMap) throws Exception {
    EntityTable entityTable = TableManager.getTable(paramObject);
    Object object = FieldUtil.get(entityTable.key.field, paramObject);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(entityTable.name);
    stringBuilder2.append(object);
    if (paramHashMap.get(stringBuilder2.toString()) != null)
      return -1; 
    int i = paramSQLStatement.execUpdate(paramSQLiteDatabase);
    object = FieldUtil.get(entityTable.key.field, paramObject);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(entityTable.name);
    stringBuilder1.append(object);
    paramHashMap.put(stringBuilder1.toString(), Integer.valueOf(1));
    handleMapping(object, paramObject, paramSQLiteDatabase, true, paramHashMap);
    return i;
  }
  
  public LiteOrm cascade() {
    return this;
  }
  
  public int delete(WhereBuilder paramWhereBuilder) {
    acquireReference();
    try {
      EntityTable entityTable = TableManager.getTable(paramWhereBuilder.getTableClass());
      deleteCollectionIfTableHasCreated(query(QueryBuilder.create(paramWhereBuilder.getTableClass()).columns(new String[] { entityTable.key.column }).where(paramWhereBuilder)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {}
    releaseReference();
    return -1;
  }
  
  public <T> int delete(Class<T> paramClass) {
    return deleteAll(paramClass);
  }
  
  public <T> int delete(Class<T> paramClass, long paramLong1, long paramLong2, String paramString) {
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
        EntityTable entityTable = TableManager.getTable(paramClass);
        QueryBuilder queryBuilder = QueryBuilder.create(paramClass);
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(l);
        stringBuilder.append(",");
        stringBuilder.append(paramLong1);
        return delete(query(queryBuilder.limit(stringBuilder.toString()).appendOrderAscBy(paramString).columns(new String[] { entityTable.key.column })));
      } finally {
        releaseReference();
      } 
    } 
    RuntimeException runtimeException = new RuntimeException();
    this("start must >=0 and smaller than end");
    throw runtimeException;
  }
  
  public <T> int delete(Class<T> paramClass, WhereBuilder paramWhereBuilder) {
    acquireReference();
    try {
      EntityTable entityTable = TableManager.getTable(paramClass);
      delete(query(QueryBuilder.create(paramClass).columns(new String[] { entityTable.key.column }).where(paramWhereBuilder)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {}
    releaseReference();
    return -1;
  }
  
  public int delete(Object paramObject) {
    acquireReference();
    try {
      SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
      Transaction.Worker<Integer> worker = new Transaction.Worker<Integer>() {
          public Integer doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            return Integer.valueOf(CascadeSQLiteImpl.this.checkTableAndDeleteRecursive(entity, param1SQLiteDatabase, (HashMap)hashMap));
          }
        };
      super(this, paramObject);
      paramObject = Transaction.execute(sQLiteDatabase, worker);
      if (paramObject != null) {
        int i = paramObject.intValue();
        releaseReference();
        return i;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {}
    releaseReference();
    return -1;
  }
  
  public <T> int delete(Collection<T> paramCollection) {
    acquireReference();
    try {
      int i = deleteCollectionIfTableHasCreated(paramCollection);
      releaseReference();
      return i;
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
      return -1;
    } finally {}
    releaseReference();
    throw paramCollection;
  }
  
  public <T> int deleteAll(Class<T> paramClass) {
    acquireReference();
    try {
      EntityTable entityTable = TableManager.getTable(paramClass);
      return delete(query(QueryBuilder.create(paramClass).columns(new String[] { entityTable.key.column })));
    } finally {
      releaseReference();
    } 
  }
  
  public <T> int insert(Collection<T> paramCollection) {
    return insert(paramCollection, (ConflictAlgorithm)null);
  }
  
  public <T> int insert(Collection<T> paramCollection, ConflictAlgorithm paramConflictAlgorithm) {
    acquireReference();
    try {
      int i = insertCollection(paramCollection, paramConflictAlgorithm);
      releaseReference();
      return i;
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
      return -1;
    } finally {}
    releaseReference();
    throw paramCollection;
  }
  
  public long insert(Object paramObject) {
    return insert(paramObject, (ConflictAlgorithm)null);
  }
  
  public long insert(Object paramObject, ConflictAlgorithm paramConflictAlgorithm) {
    acquireReference();
    try {
      long l;
      SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
      Transaction.Worker<Long> worker = new Transaction.Worker<Long>() {
          public Long doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception {
            CascadeSQLiteImpl.this.mTableManager.checkOrCreateTable(param1SQLiteDatabase, entity);
            return Long.valueOf(CascadeSQLiteImpl.this.insertRecursive(SQLBuilder.buildInsertSql(entity, conflictAlgorithm), entity, param1SQLiteDatabase, (HashMap)new HashMap<Object, Object>()));
          }
        };
      super(this, paramObject, paramConflictAlgorithm);
      paramObject = Transaction.execute(sQLiteDatabase, worker);
      if (paramObject == null) {
        l = -1L;
      } else {
        l = paramObject.longValue();
      } 
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
    return checkTableAndQuery(paramQueryBuilder.getQueryClass(), paramQueryBuilder);
  }
  
  public <T> ArrayList<T> query(Class<T> paramClass) {
    return checkTableAndQuery(paramClass, new QueryBuilder(paramClass));
  }
  
  public <T> T queryById(long paramLong, Class<T> paramClass) {
    return queryById(String.valueOf(paramLong), paramClass);
  }
  
  public <T> T queryById(String paramString, Class<T> paramClass) {
    EntityTable entityTable = TableManager.getTable(paramClass);
    ArrayList<T> arrayList = checkTableAndQuery(paramClass, (new QueryBuilder(paramClass)).whereEquals(entityTable.key.column, String.valueOf(paramString)));
    return !Checker.isEmpty(arrayList) ? arrayList.get(0) : null;
  }
  
  public <T> int save(Collection<T> paramCollection) {
    acquireReference();
    try {
      return saveCollection(paramCollection);
    } finally {
      releaseReference();
    } 
  }
  
  public long save(Object paramObject) {
    acquireReference();
    try {
      long l;
      SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
      Transaction.Worker<Long> worker = new Transaction.Worker<Long>() {
          public Long doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            return Long.valueOf(CascadeSQLiteImpl.this.checkTableAndSaveRecursive(entity, param1SQLiteDatabase, (HashMap)hashMap));
          }
        };
      super(this, paramObject);
      paramObject = Transaction.execute(sQLiteDatabase, worker);
      if (paramObject == null) {
        l = -1L;
      } else {
        l = paramObject.longValue();
      } 
      return l;
    } finally {
      releaseReference();
    } 
  }
  
  public LiteOrm single() {
    if (this.otherDatabase == null)
      this.otherDatabase = new SingleSQLiteImpl(this); 
    return this.otherDatabase;
  }
  
  public int update(Object paramObject) {
    return update(paramObject, (ColumnsValue)null, (ConflictAlgorithm)null);
  }
  
  public int update(Object paramObject, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm) {
    acquireReference();
    try {
      int i;
      SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
      Transaction.Worker<Integer> worker = new Transaction.Worker<Integer>() {
          public Integer doTransaction(SQLiteDatabase param1SQLiteDatabase) throws Exception {
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            SQLStatement sQLStatement = SQLBuilder.buildUpdateSql(entity, cvs, conflictAlgorithm);
            CascadeSQLiteImpl.this.mTableManager.checkOrCreateTable(param1SQLiteDatabase, entity);
            return Integer.valueOf(CascadeSQLiteImpl.this.updateRecursive(sQLStatement, entity, param1SQLiteDatabase, (HashMap)hashMap));
          }
        };
      super(this, paramObject, paramColumnsValue, paramConflictAlgorithm);
      paramObject = Transaction.execute(sQLiteDatabase, worker);
      if (paramObject == null) {
        i = -1;
      } else {
        i = paramObject.intValue();
      } 
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
      int i = updateCollection(paramCollection, paramColumnsValue, paramConflictAlgorithm);
      releaseReference();
      return i;
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
      return -1;
    } finally {}
    releaseReference();
    throw paramCollection;
  }
  
  public <T> int update(Collection<T> paramCollection, ConflictAlgorithm paramConflictAlgorithm) {
    return update(paramCollection, (ColumnsValue)null, paramConflictAlgorithm);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\impl\CascadeSQLiteImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */