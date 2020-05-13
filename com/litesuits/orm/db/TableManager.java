package com.litesuits.orm.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.assit.Querier;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.litesuits.orm.db.assit.SQLStatement;
import com.litesuits.orm.db.assit.Transaction;
import com.litesuits.orm.db.enums.AssignType;
import com.litesuits.orm.db.model.EntityTable;
import com.litesuits.orm.db.model.Primarykey;
import com.litesuits.orm.db.model.SQLiteColumn;
import com.litesuits.orm.db.model.SQLiteTable;
import com.litesuits.orm.db.utils.DataUtil;
import com.litesuits.orm.db.utils.FieldUtil;
import com.litesuits.orm.log.OrmLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class TableManager {
  private static final String[] ID = new String[] { "id", "_id" };
  
  private static final String TAG = "TableManager";
  
  private static final HashMap<String, EntityTable> mEntityTableMap = new HashMap<String, EntityTable>();
  
  private String dbName = "";
  
  private final HashMap<String, SQLiteTable> mSqlTableMap = new HashMap<String, SQLiteTable>();
  
  public TableManager(String paramString, SQLiteDatabase paramSQLiteDatabase) {
    this.dbName = paramString;
    initSqlTable(paramSQLiteDatabase);
  }
  
  private boolean checkExistAndColumns(SQLiteDatabase paramSQLiteDatabase, EntityTable paramEntityTable) {
    SQLiteTable sQLiteTable = this.mSqlTableMap.get(paramEntityTable.name);
    if (sQLiteTable != null) {
      if (OrmLog.isPrint) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Table [");
        stringBuilder.append(paramEntityTable.name);
        stringBuilder.append("] Exist");
        OrmLog.d(str, stringBuilder.toString());
      } 
      if (!sQLiteTable.isTableChecked) {
        String str;
        sQLiteTable.isTableChecked = true;
        if (OrmLog.isPrint) {
          String str1 = TAG;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Table [");
          stringBuilder.append(paramEntityTable.name);
          stringBuilder.append("] check column now.");
          OrmLog.i(str1, stringBuilder.toString());
        } 
        if (paramEntityTable.key != null && sQLiteTable.columns.get(paramEntityTable.key.column) == null) {
          SQLBuilder.buildDropTable(sQLiteTable.name).execute(paramSQLiteDatabase);
          if (OrmLog.isPrint) {
            str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Table [");
            stringBuilder.append(paramEntityTable.name);
            stringBuilder.append("] Primary Key has changed, ");
            stringBuilder.append("so drop and recreate it later.");
            OrmLog.i(str, stringBuilder.toString());
          } 
          return false;
        } 
        if (paramEntityTable.pmap != null) {
          ArrayList<String> arrayList = new ArrayList();
          for (String str1 : paramEntityTable.pmap.keySet()) {
            if (sQLiteTable.columns.get(str1) == null)
              arrayList.add(str1); 
          } 
          if (!Checker.isEmpty(arrayList)) {
            for (String str1 : arrayList)
              sQLiteTable.columns.put(str1, Integer.valueOf(1)); 
            int i = insertNewColunms((SQLiteDatabase)str, paramEntityTable.name, arrayList);
            if (OrmLog.isPrint)
              if (i > 0) {
                str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Table [");
                stringBuilder.append(paramEntityTable.name);
                stringBuilder.append("] add ");
                stringBuilder.append(i);
                stringBuilder.append(" new column ： ");
                stringBuilder.append(arrayList);
                OrmLog.i(str, stringBuilder.toString());
              } else {
                String str1 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Table [");
                stringBuilder.append(paramEntityTable.name);
                stringBuilder.append("] add ");
                stringBuilder.append(i);
                stringBuilder.append(" new column error ： ");
                stringBuilder.append(arrayList);
                OrmLog.e(str1, stringBuilder.toString());
              }  
          } 
        } 
      } 
      return true;
    } 
    if (OrmLog.isPrint) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Table [");
      stringBuilder.append(paramEntityTable.name);
      stringBuilder.append("] Not Exist");
      OrmLog.d(str, stringBuilder.toString());
    } 
    return false;
  }
  
  private static void checkPrimaryKey(Primarykey paramPrimarykey) {
    StringBuilder stringBuilder;
    if (paramPrimarykey.isAssignedBySystem()) {
      if (!FieldUtil.isNumber(paramPrimarykey.field.getType())) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(AssignType.AUTO_INCREMENT);
        stringBuilder.append(" Auto increment primary key must be a number ...\n ");
        stringBuilder.append("错误提示：自增主键必须设置为数字类型");
        throw new RuntimeException(stringBuilder.toString());
      } 
    } else {
      if (stringBuilder.isAssignedByMyself()) {
        if (String.class != ((Primarykey)stringBuilder).field.getType() && !FieldUtil.isNumber(((Primarykey)stringBuilder).field.getType())) {
          stringBuilder = new StringBuilder();
          stringBuilder.append(AssignType.BY_MYSELF);
          stringBuilder.append(" Custom primary key must be string or number ...\n ");
          stringBuilder.append("错误提示：自定义主键值必须为String或者Number类型");
          throw new RuntimeException(stringBuilder.toString());
        } 
        return;
      } 
      throw new RuntimeException(" Primary key without Assign Type ...\n 错误提示：主键无类型");
    } 
  }
  
  private boolean createTable(SQLiteDatabase paramSQLiteDatabase, EntityTable paramEntityTable) {
    return SQLBuilder.buildCreateTable(paramEntityTable).execute(paramSQLiteDatabase);
  }
  
  private static EntityTable getEntityTable(String paramString) {
    return mEntityTableMap.get(paramString);
  }
  
  public static String getMapTableName(EntityTable paramEntityTable1, EntityTable paramEntityTable2) {
    return getMapTableName(paramEntityTable1.name, paramEntityTable2.name);
  }
  
  public static String getMapTableName(Class<?> paramClass1, Class<?> paramClass2) {
    return getMapTableName(getTableName(paramClass1), getTableName(paramClass2));
  }
  
  public static String getMapTableName(String paramString1, String paramString2) {
    if (paramString1.compareTo(paramString2) < 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString1);
      stringBuilder1.append("_");
      stringBuilder1.append(paramString2);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("_");
    stringBuilder.append(paramString1);
    return stringBuilder.toString();
  }
  
  private EntityTable getMappingTable(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.dbName);
    stringBuilder.append(paramString1);
    EntityTable entityTable2 = getEntityTable(stringBuilder.toString());
    EntityTable entityTable1 = entityTable2;
    if (entityTable2 == null) {
      entityTable1 = new EntityTable();
      entityTable1.name = paramString1;
      entityTable1.pmap = new LinkedHashMap<Object, Object>();
      entityTable1.pmap.put(paramString2, null);
      entityTable1.pmap.put(paramString3, null);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.dbName);
      stringBuilder1.append(paramString1);
      putEntityTable(stringBuilder1.toString(), entityTable1);
    } 
    return entityTable1;
  }
  
  public static EntityTable getTable(Class<?> paramClass) {
    return getTable(paramClass, true);
  }
  
  public static EntityTable getTable(Class<?> paramClass, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/litesuits/orm/db/TableManager
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual getName : ()Ljava/lang/String;
    //   7: invokestatic getEntityTable : (Ljava/lang/String;)Lcom/litesuits/orm/db/model/EntityTable;
    //   10: astore_2
    //   11: aload_2
    //   12: astore_3
    //   13: aload_2
    //   14: ifnonnull -> 527
    //   17: new com/litesuits/orm/db/model/EntityTable
    //   20: astore_2
    //   21: aload_2
    //   22: invokespecial <init> : ()V
    //   25: aload_2
    //   26: aload_0
    //   27: putfield claxx : Ljava/lang/Class;
    //   30: aload_2
    //   31: aload_0
    //   32: invokestatic getTableName : (Ljava/lang/Class;)Ljava/lang/String;
    //   35: putfield name : Ljava/lang/String;
    //   38: new java/util/LinkedHashMap
    //   41: astore_3
    //   42: aload_3
    //   43: invokespecial <init> : ()V
    //   46: aload_2
    //   47: aload_3
    //   48: putfield pmap : Ljava/util/LinkedHashMap;
    //   51: aload_0
    //   52: invokestatic getAllDeclaredFields : (Ljava/lang/Class;)Ljava/util/List;
    //   55: invokeinterface iterator : ()Ljava/util/Iterator;
    //   60: astore #4
    //   62: aload #4
    //   64: invokeinterface hasNext : ()Z
    //   69: ifeq -> 251
    //   72: aload #4
    //   74: invokeinterface next : ()Ljava/lang/Object;
    //   79: checkcast java/lang/reflect/Field
    //   82: astore #5
    //   84: aload #5
    //   86: invokestatic isInvalid : (Ljava/lang/reflect/Field;)Z
    //   89: ifeq -> 95
    //   92: goto -> 62
    //   95: aload #5
    //   97: ldc_w com/litesuits/orm/db/annotation/Column
    //   100: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   103: checkcast com/litesuits/orm/db/annotation/Column
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull -> 121
    //   111: aload_3
    //   112: invokeinterface value : ()Ljava/lang/String;
    //   117: astore_3
    //   118: goto -> 127
    //   121: aload #5
    //   123: invokevirtual getName : ()Ljava/lang/String;
    //   126: astore_3
    //   127: new com/litesuits/orm/db/model/Property
    //   130: astore #6
    //   132: aload #6
    //   134: aload_3
    //   135: aload #5
    //   137: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Field;)V
    //   140: aload #5
    //   142: ldc_w com/litesuits/orm/db/annotation/PrimaryKey
    //   145: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   148: checkcast com/litesuits/orm/db/annotation/PrimaryKey
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull -> 190
    //   156: new com/litesuits/orm/db/model/Primarykey
    //   159: astore #5
    //   161: aload #5
    //   163: aload #6
    //   165: aload_3
    //   166: invokeinterface value : ()Lcom/litesuits/orm/db/enums/AssignType;
    //   171: invokespecial <init> : (Lcom/litesuits/orm/db/model/Property;Lcom/litesuits/orm/db/enums/AssignType;)V
    //   174: aload_2
    //   175: aload #5
    //   177: putfield key : Lcom/litesuits/orm/db/model/Primarykey;
    //   180: aload_2
    //   181: getfield key : Lcom/litesuits/orm/db/model/Primarykey;
    //   184: invokestatic checkPrimaryKey : (Lcom/litesuits/orm/db/model/Primarykey;)V
    //   187: goto -> 62
    //   190: aload #5
    //   192: ldc_w com/litesuits/orm/db/annotation/Mapping
    //   195: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   198: checkcast com/litesuits/orm/db/annotation/Mapping
    //   201: astore #5
    //   203: aload #5
    //   205: ifnull -> 233
    //   208: new com/litesuits/orm/db/model/MapProperty
    //   211: astore_3
    //   212: aload_3
    //   213: aload #6
    //   215: aload #5
    //   217: invokeinterface value : ()Lcom/litesuits/orm/db/enums/Relation;
    //   222: invokespecial <init> : (Lcom/litesuits/orm/db/model/Property;Lcom/litesuits/orm/db/enums/Relation;)V
    //   225: aload_2
    //   226: aload_3
    //   227: invokevirtual addMapping : (Lcom/litesuits/orm/db/model/MapProperty;)V
    //   230: goto -> 62
    //   233: aload_2
    //   234: getfield pmap : Ljava/util/LinkedHashMap;
    //   237: aload #6
    //   239: getfield column : Ljava/lang/String;
    //   242: aload #6
    //   244: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   247: pop
    //   248: goto -> 62
    //   251: aload_2
    //   252: getfield key : Lcom/litesuits/orm/db/model/Primarykey;
    //   255: ifnonnull -> 444
    //   258: aload_2
    //   259: getfield pmap : Ljava/util/LinkedHashMap;
    //   262: invokevirtual keySet : ()Ljava/util/Set;
    //   265: invokeinterface iterator : ()Ljava/util/Iterator;
    //   270: astore #4
    //   272: aload #4
    //   274: invokeinterface hasNext : ()Z
    //   279: ifeq -> 444
    //   282: aload #4
    //   284: invokeinterface next : ()Ljava/lang/Object;
    //   289: checkcast java/lang/String
    //   292: astore #6
    //   294: getstatic com/litesuits/orm/db/TableManager.ID : [Ljava/lang/String;
    //   297: astore #5
    //   299: aload #5
    //   301: arraylength
    //   302: istore #7
    //   304: iconst_0
    //   305: istore #8
    //   307: iload #8
    //   309: iload #7
    //   311: if_icmpge -> 437
    //   314: aload #5
    //   316: iload #8
    //   318: aaload
    //   319: aload #6
    //   321: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   324: ifeq -> 431
    //   327: aload_2
    //   328: getfield pmap : Ljava/util/LinkedHashMap;
    //   331: aload #6
    //   333: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   336: checkcast com/litesuits/orm/db/model/Property
    //   339: astore_3
    //   340: aload_3
    //   341: getfield field : Ljava/lang/reflect/Field;
    //   344: invokevirtual getType : ()Ljava/lang/Class;
    //   347: ldc java/lang/String
    //   349: if_acmpne -> 385
    //   352: aload_2
    //   353: getfield pmap : Ljava/util/LinkedHashMap;
    //   356: aload #6
    //   358: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   361: pop
    //   362: new com/litesuits/orm/db/model/Primarykey
    //   365: astore #6
    //   367: aload #6
    //   369: aload_3
    //   370: getstatic com/litesuits/orm/db/enums/AssignType.BY_MYSELF : Lcom/litesuits/orm/db/enums/AssignType;
    //   373: invokespecial <init> : (Lcom/litesuits/orm/db/model/Property;Lcom/litesuits/orm/db/enums/AssignType;)V
    //   376: aload_2
    //   377: aload #6
    //   379: putfield key : Lcom/litesuits/orm/db/model/Primarykey;
    //   382: goto -> 437
    //   385: aload_3
    //   386: getfield field : Ljava/lang/reflect/Field;
    //   389: invokevirtual getType : ()Ljava/lang/Class;
    //   392: invokestatic isNumber : (Ljava/lang/Class;)Z
    //   395: ifeq -> 431
    //   398: aload_2
    //   399: getfield pmap : Ljava/util/LinkedHashMap;
    //   402: aload #6
    //   404: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   407: pop
    //   408: new com/litesuits/orm/db/model/Primarykey
    //   411: astore #6
    //   413: aload #6
    //   415: aload_3
    //   416: getstatic com/litesuits/orm/db/enums/AssignType.AUTO_INCREMENT : Lcom/litesuits/orm/db/enums/AssignType;
    //   419: invokespecial <init> : (Lcom/litesuits/orm/db/model/Property;Lcom/litesuits/orm/db/enums/AssignType;)V
    //   422: aload_2
    //   423: aload #6
    //   425: putfield key : Lcom/litesuits/orm/db/model/Primarykey;
    //   428: goto -> 437
    //   431: iinc #8, 1
    //   434: goto -> 307
    //   437: aload_2
    //   438: getfield key : Lcom/litesuits/orm/db/model/Primarykey;
    //   441: ifnull -> 272
    //   444: iload_1
    //   445: ifeq -> 516
    //   448: aload_2
    //   449: getfield key : Lcom/litesuits/orm/db/model/Primarykey;
    //   452: ifnull -> 458
    //   455: goto -> 516
    //   458: new java/lang/RuntimeException
    //   461: astore_3
    //   462: new java/lang/StringBuilder
    //   465: astore_0
    //   466: aload_0
    //   467: invokespecial <init> : ()V
    //   470: aload_0
    //   471: ldc_w '你必须为['
    //   474: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload_0
    //   479: aload_2
    //   480: getfield claxx : Ljava/lang/Class;
    //   483: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   486: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload_0
    //   491: ldc_w ']设置主键(you must set the primary key...)'
    //   494: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload_0
    //   499: ldc_w '\\n 提示：在对象的属性上加PrimaryKey注解来设置主键。'
    //   502: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_3
    //   507: aload_0
    //   508: invokevirtual toString : ()Ljava/lang/String;
    //   511: invokespecial <init> : (Ljava/lang/String;)V
    //   514: aload_3
    //   515: athrow
    //   516: aload_0
    //   517: invokevirtual getName : ()Ljava/lang/String;
    //   520: aload_2
    //   521: invokestatic putEntityTable : (Ljava/lang/String;Lcom/litesuits/orm/db/model/EntityTable;)Lcom/litesuits/orm/db/model/EntityTable;
    //   524: pop
    //   525: aload_2
    //   526: astore_3
    //   527: ldc com/litesuits/orm/db/TableManager
    //   529: monitorexit
    //   530: aload_3
    //   531: areturn
    //   532: astore_0
    //   533: ldc com/litesuits/orm/db/TableManager
    //   535: monitorexit
    //   536: aload_0
    //   537: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	532	finally
    //   17	62	532	finally
    //   62	92	532	finally
    //   95	107	532	finally
    //   111	118	532	finally
    //   121	127	532	finally
    //   127	152	532	finally
    //   156	187	532	finally
    //   190	203	532	finally
    //   208	230	532	finally
    //   233	248	532	finally
    //   251	272	532	finally
    //   272	304	532	finally
    //   314	382	532	finally
    //   385	428	532	finally
    //   437	444	532	finally
    //   448	455	532	finally
    //   458	516	532	finally
    //   516	525	532	finally
  }
  
  public static EntityTable getTable(Object paramObject) {
    return getTable(paramObject.getClass(), true);
  }
  
  public static String getTableName(Class<?> paramClass) {
    Table table = paramClass.<Table>getAnnotation(Table.class);
    return (table != null) ? table.value() : paramClass.getName().replaceAll("\\.", "_");
  }
  
  private void initAllTablesFromSQLite(SQLiteDatabase paramSQLiteDatabase) {
    synchronized (this.mSqlTableMap) {
      if (Checker.isEmpty(this.mSqlTableMap)) {
        if (OrmLog.isPrint)
          OrmLog.i(TAG, "Initialize SQL table start--------------------->"); 
        SQLStatement sQLStatement = SQLBuilder.buildTableObtainAll();
        EntityTable entityTable = getTable(SQLiteTable.class, false);
        Querier.CursorParser cursorParser = new Querier.CursorParser() {
            public void parseEachCursor(SQLiteDatabase param1SQLiteDatabase, Cursor param1Cursor) throws Exception {
              SQLiteTable sQLiteTable = new SQLiteTable();
              DataUtil.injectDataToObject(param1Cursor, sQLiteTable, table);
              ArrayList<String> arrayList2 = TableManager.this.getAllColumnsFromSQLite(param1SQLiteDatabase, sQLiteTable.name);
              ArrayList<String> arrayList1 = arrayList2;
              if (Checker.isEmpty(arrayList2)) {
                OrmLog.e(TableManager.TAG, "读数据库失败了，开始解析建表语句");
                arrayList1 = TableManager.this.transformSqlToColumns(sQLiteTable.sql);
              } 
              sQLiteTable.columns = new HashMap<Object, Object>();
              for (String str : arrayList1)
                sQLiteTable.columns.put(str, Integer.valueOf(1)); 
              if (OrmLog.isPrint) {
                String str = TableManager.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Find One SQL Table: ");
                stringBuilder.append(sQLiteTable);
                OrmLog.i(str, stringBuilder.toString());
                str = TableManager.TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Table Column: ");
                stringBuilder.append(arrayList1);
                OrmLog.i(str, stringBuilder.toString());
              } 
              TableManager.this.mSqlTableMap.put(sQLiteTable.name, sQLiteTable);
            }
          };
        super(this, entityTable);
        Querier.doQuery(paramSQLiteDatabase, sQLStatement, cursorParser);
        if (OrmLog.isPrint) {
          String str = TAG;
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("Initialize SQL table end  ---------------------> ");
          stringBuilder.append(this.mSqlTableMap.size());
          OrmLog.i(str, stringBuilder.toString());
        } 
      } 
      return;
    } 
  }
  
  private int insertNewColunms(SQLiteDatabase paramSQLiteDatabase, final String tableName, final List<String> columns) {
    int i;
    if (!Checker.isEmpty(columns)) {
      Integer integer = (Integer)Transaction.execute(paramSQLiteDatabase, new Transaction.Worker<Integer>() {
            public Integer doTransaction(SQLiteDatabase param1SQLiteDatabase) {
              for (String str : columns)
                SQLBuilder.buildAddColumnSql(tableName, str).execute(param1SQLiteDatabase); 
              return Integer.valueOf(columns.size());
            }
          });
    } else {
      paramSQLiteDatabase = null;
    } 
    if (paramSQLiteDatabase == null) {
      i = 0;
    } else {
      i = paramSQLiteDatabase.intValue();
    } 
    return i;
  }
  
  private static EntityTable putEntityTable(String paramString, EntityTable paramEntityTable) {
    return mEntityTableMap.put(paramString, paramEntityTable);
  }
  
  private void putNewSqlTableIntoMap(EntityTable paramEntityTable) {
    if (OrmLog.isPrint) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Table [");
      stringBuilder.append(paramEntityTable.name);
      stringBuilder.append("] Create Success");
      OrmLog.i(str, stringBuilder.toString());
    } 
    SQLiteTable sQLiteTable = new SQLiteTable();
    sQLiteTable.name = paramEntityTable.name;
    sQLiteTable.columns = new HashMap<Object, Object>();
    if (paramEntityTable.key != null)
      sQLiteTable.columns.put(paramEntityTable.key.column, Integer.valueOf(1)); 
    if (paramEntityTable.pmap != null)
      for (String str : paramEntityTable.pmap.keySet())
        sQLiteTable.columns.put(str, Integer.valueOf(1));  
    sQLiteTable.isTableChecked = true;
    this.mSqlTableMap.put(sQLiteTable.name, sQLiteTable);
  }
  
  public void checkOrCreateMappingTable(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: aload_3
    //   5: aload #4
    //   7: invokespecial getMappingTable : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/litesuits/orm/db/model/EntityTable;
    //   10: astore_2
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: invokespecial checkExistAndColumns : (Landroid/database/sqlite/SQLiteDatabase;Lcom/litesuits/orm/db/model/EntityTable;)Z
    //   17: ifne -> 34
    //   20: aload_0
    //   21: aload_1
    //   22: aload_2
    //   23: invokespecial createTable : (Landroid/database/sqlite/SQLiteDatabase;Lcom/litesuits/orm/db/model/EntityTable;)Z
    //   26: ifeq -> 34
    //   29: aload_0
    //   30: aload_2
    //   31: invokespecial putNewSqlTableIntoMap : (Lcom/litesuits/orm/db/model/EntityTable;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	34	37	finally
  }
  
  public EntityTable checkOrCreateTable(SQLiteDatabase paramSQLiteDatabase, Class<?> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic getTable : (Ljava/lang/Class;)Lcom/litesuits/orm/db/model/EntityTable;
    //   6: astore_2
    //   7: aload_0
    //   8: aload_1
    //   9: aload_2
    //   10: invokespecial checkExistAndColumns : (Landroid/database/sqlite/SQLiteDatabase;Lcom/litesuits/orm/db/model/EntityTable;)Z
    //   13: ifne -> 30
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokespecial createTable : (Landroid/database/sqlite/SQLiteDatabase;Lcom/litesuits/orm/db/model/EntityTable;)Z
    //   22: ifeq -> 30
    //   25: aload_0
    //   26: aload_2
    //   27: invokespecial putNewSqlTableIntoMap : (Lcom/litesuits/orm/db/model/EntityTable;)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	34	finally
  }
  
  public EntityTable checkOrCreateTable(SQLiteDatabase paramSQLiteDatabase, Object paramObject) {
    return checkOrCreateTable(paramSQLiteDatabase, paramObject.getClass());
  }
  
  public void clearSqlTable() {
    synchronized (this.mSqlTableMap) {
      this.mSqlTableMap.clear();
      return;
    } 
  }
  
  public ArrayList<String> getAllColumnsFromSQLite(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    final EntityTable table = getTable(SQLiteColumn.class, false);
    final ArrayList<String> list = new ArrayList();
    Querier.doQuery(paramSQLiteDatabase, SQLBuilder.buildColumnsObtainAll(paramString), new Querier.CursorParser() {
          public void parseEachCursor(SQLiteDatabase param1SQLiteDatabase, Cursor param1Cursor) throws Exception {
            SQLiteColumn sQLiteColumn = new SQLiteColumn();
            DataUtil.injectDataToObject(param1Cursor, sQLiteColumn, table);
            list.add(sQLiteColumn.name);
          }
        });
    return arrayList;
  }
  
  public void initSqlTable(SQLiteDatabase paramSQLiteDatabase) {
    initAllTablesFromSQLite(paramSQLiteDatabase);
  }
  
  public boolean isSQLMapTableCreated(String paramString1, String paramString2) {
    boolean bool;
    if (this.mSqlTableMap.get(getMapTableName(paramString1, paramString2)) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isSQLTableCreated(String paramString) {
    boolean bool;
    if (this.mSqlTableMap.get(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void release() {
    clearSqlTable();
    mEntityTableMap.clear();
  }
  
  public ArrayList<String> transformSqlToColumns(String paramString) {
    if (paramString != null) {
      int i = paramString.indexOf("(");
      int j = paramString.lastIndexOf(")");
      if (i > 0 && j > 0) {
        String str = paramString.substring(i + 1, j);
        String[] arrayOfString = str.split(",");
        ArrayList<String> arrayList = new ArrayList();
        j = arrayOfString.length;
        for (i = 0; i < j; i++) {
          String str1 = arrayOfString[i].trim();
          int k = str1.indexOf(" ");
          paramString = str1;
          if (k > 0)
            paramString = str1.substring(0, k); 
          arrayList.add(paramString);
        } 
        paramString = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("降级：语义分析表结构（");
        stringBuilder.append(arrayList.toString());
        stringBuilder.append(" , Origin SQL is: ");
        stringBuilder.append(str);
        OrmLog.e(paramString, stringBuilder.toString());
        return arrayList;
      } 
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\TableManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */