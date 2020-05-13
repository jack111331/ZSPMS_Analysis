package com.litesuits.orm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.db.DataBase;
import com.litesuits.orm.db.DataBaseConfig;
import com.litesuits.orm.db.TableManager;
import com.litesuits.orm.db.assit.Checker;
import com.litesuits.orm.db.assit.CollSpliter;
import com.litesuits.orm.db.assit.Querier;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.litesuits.orm.db.assit.SQLStatement;
import com.litesuits.orm.db.assit.SQLiteHelper;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.litesuits.orm.db.model.ColumnsValue;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import com.litesuits.orm.db.model.EntityTable;
import com.litesuits.orm.db.model.RelationKey;
import com.litesuits.orm.log.OrmLog;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class LiteOrm extends SQLiteClosable implements DataBase {
  public static final String TAG = "LiteOrm";
  
  protected DataBaseConfig mConfig;
  
  protected SQLiteHelper mHelper;
  
  protected TableManager mTableManager;
  
  protected LiteOrm otherDatabase;
  
  protected LiteOrm(LiteOrm paramLiteOrm) {
    this.mHelper = paramLiteOrm.mHelper;
    this.mConfig = paramLiteOrm.mConfig;
    this.mTableManager = paramLiteOrm.mTableManager;
    this.otherDatabase = paramLiteOrm;
  }
  
  protected LiteOrm(DataBaseConfig paramDataBaseConfig) {
    paramDataBaseConfig.context = paramDataBaseConfig.context.getApplicationContext();
    if (paramDataBaseConfig.dbName == null)
      paramDataBaseConfig.dbName = "liteorm.db"; 
    if (paramDataBaseConfig.dbVersion <= 0)
      paramDataBaseConfig.dbVersion = 1; 
    this.mConfig = paramDataBaseConfig;
    setDebugged(paramDataBaseConfig.debugged);
    openOrCreateDatabase();
  }
  
  private void initDatabasePath(String paramString) {
    String str1 = TAG;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("create  database path: ");
    stringBuilder2.append(paramString);
    OrmLog.i(str1, stringBuilder2.toString());
    paramString = this.mConfig.context.getDatabasePath(this.mConfig.dbName).getPath();
    String str2 = TAG;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("context database path: ");
    stringBuilder1.append(paramString);
    OrmLog.i(str2, stringBuilder1.toString());
    File file = (new File(paramString)).getParentFile();
    if (file != null && !file.exists()) {
      boolean bool = file.mkdirs();
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create database, parent file mkdirs: ");
      stringBuilder.append(bool);
      stringBuilder.append("  path:");
      stringBuilder.append(file.getAbsolutePath());
      OrmLog.i(str, stringBuilder.toString());
    } 
  }
  
  private <E, T> boolean keepMapping(Collection<E> paramCollection, Collection<T> paramCollection1) throws IllegalAccessException, InstantiationException {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface iterator : ()Ljava/util/Iterator;
    //   6: invokeinterface next : ()Ljava/lang/Object;
    //   11: invokevirtual getClass : ()Ljava/lang/Class;
    //   14: astore_3
    //   15: aload_2
    //   16: invokeinterface iterator : ()Ljava/util/Iterator;
    //   21: invokeinterface next : ()Ljava/lang/Object;
    //   26: invokevirtual getClass : ()Ljava/lang/Class;
    //   29: astore #4
    //   31: aload_3
    //   32: invokestatic getTable : (Ljava/lang/Class;)Lcom/litesuits/orm/db/model/EntityTable;
    //   35: astore #5
    //   37: aload #4
    //   39: invokestatic getTable : (Ljava/lang/Class;)Lcom/litesuits/orm/db/model/EntityTable;
    //   42: astore #6
    //   44: aload #5
    //   46: getfield mappingList : Ljava/util/ArrayList;
    //   49: ifnull -> 690
    //   52: aload #5
    //   54: getfield mappingList : Ljava/util/ArrayList;
    //   57: invokevirtual iterator : ()Ljava/util/Iterator;
    //   60: astore #7
    //   62: aload #7
    //   64: invokeinterface hasNext : ()Z
    //   69: ifeq -> 690
    //   72: aload #7
    //   74: invokeinterface next : ()Ljava/lang/Object;
    //   79: checkcast com/litesuits/orm/db/model/MapProperty
    //   82: astore #8
    //   84: aload #8
    //   86: getfield field : Ljava/lang/reflect/Field;
    //   89: invokevirtual getType : ()Ljava/lang/Class;
    //   92: astore #9
    //   94: aload #9
    //   96: astore #10
    //   98: aload #8
    //   100: invokevirtual isToMany : ()Z
    //   103: ifeq -> 158
    //   106: aload #9
    //   108: invokestatic isCollection : (Ljava/lang/Class;)Z
    //   111: ifeq -> 127
    //   114: aload #8
    //   116: getfield field : Ljava/lang/reflect/Field;
    //   119: invokestatic getGenericType : (Ljava/lang/reflect/Field;)Ljava/lang/Class;
    //   122: astore #10
    //   124: goto -> 158
    //   127: aload #9
    //   129: invokevirtual isArray : ()Z
    //   132: ifeq -> 148
    //   135: aload #8
    //   137: getfield field : Ljava/lang/reflect/Field;
    //   140: invokestatic getComponentType : (Ljava/lang/reflect/Field;)Ljava/lang/Class;
    //   143: astore #10
    //   145: goto -> 158
    //   148: new java/lang/RuntimeException
    //   151: dup
    //   152: ldc 'OneToMany and ManyToMany Relation, Must use collection or array object'
    //   154: invokespecial <init> : (Ljava/lang/String;)V
    //   157: athrow
    //   158: aload #10
    //   160: aload #4
    //   162: if_acmpne -> 62
    //   165: new java/util/ArrayList
    //   168: dup
    //   169: invokespecial <init> : ()V
    //   172: astore #11
    //   174: new java/util/HashMap
    //   177: dup
    //   178: invokespecial <init> : ()V
    //   181: astore #9
    //   183: aload_1
    //   184: invokeinterface iterator : ()Ljava/util/Iterator;
    //   189: astore #12
    //   191: aload #12
    //   193: invokeinterface hasNext : ()Z
    //   198: ifeq -> 262
    //   201: aload #12
    //   203: invokeinterface next : ()Ljava/lang/Object;
    //   208: astore #13
    //   210: aload #13
    //   212: ifnull -> 191
    //   215: aload #5
    //   217: getfield key : Lcom/litesuits/orm/db/model/Primarykey;
    //   220: getfield field : Ljava/lang/reflect/Field;
    //   223: aload #13
    //   225: invokestatic get : (Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/Object;
    //   228: astore #14
    //   230: aload #14
    //   232: ifnull -> 191
    //   235: aload #11
    //   237: aload #14
    //   239: invokevirtual toString : ()Ljava/lang/String;
    //   242: invokevirtual add : (Ljava/lang/Object;)Z
    //   245: pop
    //   246: aload #9
    //   248: aload #14
    //   250: invokevirtual toString : ()Ljava/lang/String;
    //   253: aload #13
    //   255: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   258: pop
    //   259: goto -> 191
    //   262: aload_0
    //   263: aload_3
    //   264: aload #4
    //   266: aload #11
    //   268: invokevirtual queryRelation : (Ljava/lang/Class;Ljava/lang/Class;Ljava/util/List;)Ljava/util/ArrayList;
    //   271: astore #11
    //   273: aload #11
    //   275: invokestatic isEmpty : (Ljava/util/Collection;)Z
    //   278: ifne -> 62
    //   281: new java/util/HashMap
    //   284: dup
    //   285: invokespecial <init> : ()V
    //   288: astore #5
    //   290: aload_2
    //   291: invokeinterface iterator : ()Ljava/util/Iterator;
    //   296: astore #7
    //   298: aload #7
    //   300: invokeinterface hasNext : ()Z
    //   305: ifeq -> 351
    //   308: aload #7
    //   310: invokeinterface next : ()Ljava/lang/Object;
    //   315: astore_1
    //   316: aload_1
    //   317: ifnull -> 298
    //   320: aload #6
    //   322: getfield key : Lcom/litesuits/orm/db/model/Primarykey;
    //   325: getfield field : Ljava/lang/reflect/Field;
    //   328: aload_1
    //   329: invokestatic get : (Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/Object;
    //   332: astore_2
    //   333: aload_2
    //   334: ifnull -> 298
    //   337: aload #5
    //   339: aload_2
    //   340: invokevirtual toString : ()Ljava/lang/String;
    //   343: aload_1
    //   344: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: pop
    //   348: goto -> 298
    //   351: new java/util/HashMap
    //   354: dup
    //   355: invokespecial <init> : ()V
    //   358: astore #6
    //   360: aload #11
    //   362: invokevirtual iterator : ()Ljava/util/Iterator;
    //   365: astore_3
    //   366: aload_3
    //   367: invokeinterface hasNext : ()Z
    //   372: ifeq -> 484
    //   375: aload_3
    //   376: invokeinterface next : ()Ljava/lang/Object;
    //   381: checkcast com/litesuits/orm/db/model/RelationKey
    //   384: astore_1
    //   385: aload #9
    //   387: aload_1
    //   388: getfield key1 : Ljava/lang/String;
    //   391: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   394: astore #7
    //   396: aload #5
    //   398: aload_1
    //   399: getfield key2 : Ljava/lang/String;
    //   402: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   405: astore #4
    //   407: aload #7
    //   409: ifnull -> 366
    //   412: aload #4
    //   414: ifnull -> 366
    //   417: aload #8
    //   419: invokevirtual isToMany : ()Z
    //   422: ifeq -> 469
    //   425: aload #6
    //   427: aload #7
    //   429: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   432: checkcast java/util/ArrayList
    //   435: astore_2
    //   436: aload_2
    //   437: astore_1
    //   438: aload_2
    //   439: ifnonnull -> 459
    //   442: new java/util/ArrayList
    //   445: dup
    //   446: invokespecial <init> : ()V
    //   449: astore_1
    //   450: aload #6
    //   452: aload #7
    //   454: aload_1
    //   455: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   458: pop
    //   459: aload_1
    //   460: aload #4
    //   462: invokevirtual add : (Ljava/lang/Object;)Z
    //   465: pop
    //   466: goto -> 366
    //   469: aload #8
    //   471: getfield field : Ljava/lang/reflect/Field;
    //   474: aload #7
    //   476: aload #4
    //   478: invokestatic set : (Ljava/lang/reflect/Field;Ljava/lang/Object;Ljava/lang/Object;)V
    //   481: goto -> 366
    //   484: aload #6
    //   486: invokestatic isEmpty : (Ljava/util/Map;)Z
    //   489: ifne -> 688
    //   492: aload #6
    //   494: invokevirtual entrySet : ()Ljava/util/Set;
    //   497: invokeinterface iterator : ()Ljava/util/Iterator;
    //   502: astore_2
    //   503: aload_2
    //   504: invokeinterface hasNext : ()Z
    //   509: ifeq -> 688
    //   512: aload_2
    //   513: invokeinterface next : ()Ljava/lang/Object;
    //   518: checkcast java/util/Map$Entry
    //   521: astore #9
    //   523: aload #9
    //   525: invokeinterface getKey : ()Ljava/lang/Object;
    //   530: astore_1
    //   531: aload #9
    //   533: invokeinterface getValue : ()Ljava/lang/Object;
    //   538: checkcast java/util/Collection
    //   541: astore #6
    //   543: aload #10
    //   545: invokestatic isCollection : (Ljava/lang/Class;)Z
    //   548: ifeq -> 597
    //   551: aload #8
    //   553: getfield field : Ljava/lang/reflect/Field;
    //   556: aload_1
    //   557: invokestatic get : (Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/Object;
    //   560: checkcast java/util/Collection
    //   563: astore #9
    //   565: aload #9
    //   567: ifnonnull -> 584
    //   570: aload #8
    //   572: getfield field : Ljava/lang/reflect/Field;
    //   575: aload_1
    //   576: aload #6
    //   578: invokestatic set : (Ljava/lang/reflect/Field;Ljava/lang/Object;Ljava/lang/Object;)V
    //   581: goto -> 503
    //   584: aload #9
    //   586: aload #6
    //   588: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   593: pop
    //   594: goto -> 503
    //   597: aload #10
    //   599: invokestatic isArray : (Ljava/lang/Class;)Z
    //   602: ifeq -> 503
    //   605: aload #10
    //   607: aload #6
    //   609: invokeinterface size : ()I
    //   614: invokestatic newArray : (Ljava/lang/Class;I)Ljava/lang/Object;
    //   617: checkcast [Ljava/lang/Object;
    //   620: astore #9
    //   622: aload #6
    //   624: aload #9
    //   626: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   631: pop
    //   632: aload #8
    //   634: getfield field : Ljava/lang/reflect/Field;
    //   637: aload_1
    //   638: invokestatic get : (Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/Object;
    //   641: checkcast [Ljava/lang/Object;
    //   644: astore #6
    //   646: aload #6
    //   648: ifnonnull -> 665
    //   651: aload #8
    //   653: getfield field : Ljava/lang/reflect/Field;
    //   656: aload_1
    //   657: aload #9
    //   659: invokestatic set : (Ljava/lang/reflect/Field;Ljava/lang/Object;Ljava/lang/Object;)V
    //   662: goto -> 503
    //   665: aload #6
    //   667: aload #9
    //   669: invokestatic concat : ([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;
    //   672: astore #9
    //   674: aload #8
    //   676: getfield field : Ljava/lang/reflect/Field;
    //   679: aload_1
    //   680: aload #9
    //   682: invokestatic set : (Ljava/lang/reflect/Field;Ljava/lang/Object;Ljava/lang/Object;)V
    //   685: goto -> 503
    //   688: iconst_1
    //   689: ireturn
    //   690: iconst_0
    //   691: ireturn
  }
  
  public static LiteOrm newCascadeInstance(Context paramContext, String paramString) {
    return newCascadeInstance(new DataBaseConfig(paramContext, paramString));
  }
  
  public static LiteOrm newCascadeInstance(DataBaseConfig paramDataBaseConfig) {
    // Byte code:
    //   0: ldc com/litesuits/orm/LiteOrm
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic newInstance : (Lcom/litesuits/orm/db/DataBaseConfig;)Lcom/litesuits/orm/LiteOrm;
    //   7: astore_0
    //   8: ldc com/litesuits/orm/LiteOrm
    //   10: monitorexit
    //   11: aload_0
    //   12: areturn
    //   13: astore_0
    //   14: ldc com/litesuits/orm/LiteOrm
    //   16: monitorexit
    //   17: aload_0
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	13	finally
  }
  
  public static LiteOrm newSingleInstance(Context paramContext, String paramString) {
    return newSingleInstance(new DataBaseConfig(paramContext, paramString));
  }
  
  public static LiteOrm newSingleInstance(DataBaseConfig paramDataBaseConfig) {
    // Byte code:
    //   0: ldc com/litesuits/orm/LiteOrm
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic newInstance : (Lcom/litesuits/orm/db/DataBaseConfig;)Lcom/litesuits/orm/LiteOrm;
    //   7: astore_0
    //   8: ldc com/litesuits/orm/LiteOrm
    //   10: monitorexit
    //   11: aload_0
    //   12: areturn
    //   13: astore_0
    //   14: ldc com/litesuits/orm/LiteOrm
    //   16: monitorexit
    //   17: aload_0
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	13	finally
  }
  
  public static int releaseMemory() {
    return SQLiteDatabase.releaseMemory();
  }
  
  public abstract LiteOrm cascade();
  
  public void close() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual releaseReference : ()V
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	9	finally
  }
  
  public SQLStatement createSQLStatement(String paramString, Object[] paramArrayOfObject) {
    return new SQLStatement(paramString, paramArrayOfObject);
  }
  
  public boolean deleteDatabase() {
    String str1 = this.mHelper.getWritableDatabase().getPath();
    justRelease();
    String str2 = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("data has cleared. delete Database path: ");
    stringBuilder.append(str1);
    OrmLog.i(str2, stringBuilder.toString());
    return deleteDatabase(new File(str1));
  }
  
  public boolean deleteDatabase(File paramFile) {
    Exception exception;
    acquireReference();
    if (paramFile != null) {
      try {
        int i;
        boolean bool1 = paramFile.delete();
        File file1 = new File();
        StringBuilder stringBuilder2 = new StringBuilder();
        this();
        stringBuilder2.append(paramFile.getPath());
        stringBuilder2.append("-journal");
        this(stringBuilder2.toString());
        boolean bool2 = file1.delete();
        file1 = new File();
        stringBuilder2 = new StringBuilder();
        this();
        stringBuilder2.append(paramFile.getPath());
        stringBuilder2.append("-shm");
        this(stringBuilder2.toString());
        boolean bool3 = file1.delete();
        File file2 = new File();
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        stringBuilder1.append(paramFile.getPath());
        stringBuilder1.append("-wal");
        this(stringBuilder1.toString());
        int k = bool1 | bool2 | bool3 | file2.delete();
        file2 = paramFile.getParentFile();
        int j = k;
        if (file2 != null) {
          stringBuilder1 = new StringBuilder();
          this();
          stringBuilder1.append(paramFile.getName());
          stringBuilder1.append("-mj");
          String str = stringBuilder1.toString();
          FileFilter fileFilter = new FileFilter() {
              public boolean accept(File param1File) {
                return param1File.getName().startsWith(prefix);
              }
            };
          super(this, str);
          File[] arrayOfFile = file2.listFiles(fileFilter);
          int m = arrayOfFile.length;
          j = k;
          for (byte b = 0; b < m; b++) {
            int n = arrayOfFile[b].delete();
            i = j | n;
          } 
        } 
        releaseReference();
        return i;
      } catch (Exception null) {
        exception.printStackTrace();
        releaseReference();
        return false;
      } finally {}
    } else {
      exception = new IllegalArgumentException();
      this("file must not be null");
      throw exception;
    } 
    releaseReference();
    throw exception;
  }
  
  public boolean dropTable(Class<?> paramClass) {
    return dropTable((TableManager.getTable(paramClass, false)).name);
  }
  
  @Deprecated
  public boolean dropTable(Object paramObject) {
    return dropTable(paramObject.getClass());
  }
  
  public boolean dropTable(String paramString) {
    acquireReference();
    try {
      boolean bool = SQLBuilder.buildDropTable(paramString).execute(this.mHelper.getWritableDatabase());
      releaseReference();
      return bool;
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
      return false;
    } finally {}
    releaseReference();
    throw paramString;
  }
  
  public boolean execute(SQLiteDatabase paramSQLiteDatabase, SQLStatement paramSQLStatement) {
    acquireReference();
    if (paramSQLStatement != null)
      try {
        boolean bool = paramSQLStatement.execute(paramSQLiteDatabase);
        releaseReference();
        return bool;
      } catch (Exception exception) {
        exception.printStackTrace();
      } finally {} 
    releaseReference();
    return false;
  }
  
  public DataBaseConfig getDataBaseConfig() {
    return this.mConfig;
  }
  
  public SQLiteDatabase getReadableDatabase() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mHelper : Lcom/litesuits/orm/db/assit/SQLiteHelper;
    //   6: invokevirtual getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public SQLiteHelper getSQLiteHelper() {
    return this.mHelper;
  }
  
  public TableManager getTableManager() {
    return this.mTableManager;
  }
  
  public SQLiteDatabase getWritableDatabase() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mHelper : Lcom/litesuits/orm/db/assit/SQLiteHelper;
    //   6: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  protected void justRelease() {
    if (this.mHelper != null) {
      this.mHelper.getWritableDatabase().close();
      this.mHelper.close();
      this.mHelper = null;
    } 
    if (this.mTableManager != null) {
      this.mTableManager.release();
      this.mTableManager = null;
    } 
  }
  
  public <E, T> boolean mapping(Collection<E> paramCollection, Collection<T> paramCollection1) {
    if (Checker.isEmpty(paramCollection) || Checker.isEmpty(paramCollection1))
      return false; 
    acquireReference();
    try {
      boolean bool1 = keepMapping(paramCollection, paramCollection1);
      boolean bool2 = keepMapping(paramCollection1, paramCollection);
      releaseReference();
      return bool2 | bool1;
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
      return false;
    } finally {}
    releaseReference();
    throw paramCollection;
  }
  
  protected void onAllReferencesReleased() {
    justRelease();
  }
  
  public SQLiteDatabase openOrCreateDatabase() {
    initDatabasePath(this.mConfig.dbName);
    if (this.mHelper != null)
      justRelease(); 
    this.mHelper = new SQLiteHelper(this.mConfig.context.getApplicationContext(), this.mConfig.dbName, null, this.mConfig.dbVersion, this.mConfig.onUpdateListener);
    this.mTableManager = new TableManager(this.mConfig.dbName, this.mHelper.getReadableDatabase());
    return this.mHelper.getWritableDatabase();
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory) {
    return SQLiteDatabase.openOrCreateDatabase(this.mConfig.context.getDatabasePath(this.mConfig.dbName).getPath(), paramCursorFactory);
  }
  
  public long queryCount(QueryBuilder paramQueryBuilder) {
    acquireReference();
    try {
      if (this.mTableManager.isSQLTableCreated(paramQueryBuilder.getTableName())) {
        SQLiteDatabase sQLiteDatabase = this.mHelper.getReadableDatabase();
        long l = paramQueryBuilder.createStatementForCount().queryForLong(sQLiteDatabase);
        releaseReference();
        return l;
      } 
      releaseReference();
      return 0L;
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
      return -1L;
    } finally {}
    releaseReference();
    throw paramQueryBuilder;
  }
  
  public <T> long queryCount(Class<T> paramClass) {
    return queryCount(new QueryBuilder(paramClass));
  }
  
  public ArrayList<RelationKey> queryRelation(Class paramClass1, Class paramClass2, List<String> paramList) {
    acquireReference();
    ArrayList<RelationKey> arrayList = new ArrayList();
    try {
      EntityTable entityTable1 = TableManager.getTable(paramClass1);
      EntityTable entityTable2 = TableManager.getTable(paramClass2);
      if (this.mTableManager.isSQLMapTableCreated(entityTable1.name, entityTable2.name)) {
        CollSpliter.Spliter<String> spliter = new CollSpliter.Spliter<String>() {
            public int oneSplit(ArrayList<String> param1ArrayList) throws Exception {
              SQLStatement sQLStatement = SQLBuilder.buildQueryRelationSql(class1, class2, key1List);
              Querier.doQuery(LiteOrm.this.mHelper.getReadableDatabase(), sQLStatement, new Querier.CursorParser() {
                    public void parseEachCursor(SQLiteDatabase param2SQLiteDatabase, Cursor param2Cursor) throws Exception {
                      RelationKey relationKey = new RelationKey();
                      relationKey.key1 = param2Cursor.getString(param2Cursor.getColumnIndex(table1.name));
                      relationKey.key2 = param2Cursor.getString(param2Cursor.getColumnIndex(table2.name));
                      rList.add(relationKey);
                    }
                  });
              return 0;
            }
          };
        super(this, paramClass1, paramClass2, paramList, entityTable1, entityTable2, arrayList);
        CollSpliter.split(paramList, 999, spliter);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {}
    releaseReference();
    return arrayList;
  }
  
  public void setDebugged(boolean paramBoolean) {
    this.mConfig.debugged = paramBoolean;
    OrmLog.isPrint = paramBoolean;
  }
  
  public abstract LiteOrm single();
  
  public int update(WhereBuilder paramWhereBuilder, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm) {
    acquireReference();
    try {
      SQLiteDatabase sQLiteDatabase = this.mHelper.getWritableDatabase();
      int i = SQLBuilder.buildUpdateSql(paramWhereBuilder, paramColumnsValue, paramConflictAlgorithm).execUpdate(sQLiteDatabase);
      releaseReference();
      return i;
    } catch (Exception exception) {
      exception.printStackTrace();
      releaseReference();
      return -1;
    } finally {}
    releaseReference();
    throw paramWhereBuilder;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\LiteOrm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */