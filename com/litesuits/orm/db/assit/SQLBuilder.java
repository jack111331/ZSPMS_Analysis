package com.litesuits.orm.db.assit;

import android.util.SparseArray;
import com.litesuits.orm.db.TableManager;
import com.litesuits.orm.db.annotation.Check;
import com.litesuits.orm.db.annotation.Collate;
import com.litesuits.orm.db.annotation.Conflict;
import com.litesuits.orm.db.annotation.Default;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.Temporary;
import com.litesuits.orm.db.annotation.Unique;
import com.litesuits.orm.db.annotation.UniqueCombine;
import com.litesuits.orm.db.enums.AssignType;
import com.litesuits.orm.db.model.ColumnsValue;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import com.litesuits.orm.db.model.EntityTable;
import com.litesuits.orm.db.model.MapInfo;
import com.litesuits.orm.db.model.MapProperty;
import com.litesuits.orm.db.model.Primarykey;
import com.litesuits.orm.db.model.Property;
import com.litesuits.orm.db.utils.ClassUtil;
import com.litesuits.orm.db.utils.DataUtil;
import com.litesuits.orm.db.utils.FieldUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SQLBuilder {
  public static final String AND = " AND ";
  
  public static final String ASC = " ASC ";
  
  public static final String ASTERISK = "*";
  
  public static final String BLANK = " ";
  
  public static final String CHECK = "CHECK ";
  
  public static final String COLLATE = "COLLATE ";
  
  public static final String COMMA = ",";
  
  public static final String COMMA_HOLDER = ",?";
  
  public static final String CREATE = "CREATE ";
  
  public static final String DEFAULT = "DEFAULT ";
  
  public static final String DELETE_FROM = "DELETE FROM ";
  
  public static final String DESC = " DESC ";
  
  public static final String DROP_TABLE = "DROP TABLE ";
  
  public static final String EQUALS_HOLDER = "=?";
  
  public static final String FROM = " FROM ";
  
  public static final String HOLDER = "?";
  
  public static final String IN = " IN ";
  
  public static final String INSERT = "INSERT ";
  
  public static final String INTO = "INTO ";
  
  public static final String LIMIT = " LIMIT ";
  
  public static final String NOT = " NOT ";
  
  public static final String NOT_NULL = "NOT NULL ";
  
  public static final String ON_CONFLICT = "ON CONFLICT ";
  
  public static final String OR = " OR ";
  
  public static final String ORDER_BY = " ORDER BY ";
  
  public static final String PARENTHESES_LEFT = "(";
  
  public static final String PARENTHESES_RIGHT = ")";
  
  public static final String PRAGMA_TABLE_INFO = "PRAGMA table_info(";
  
  public static final String PRIMARY_KEY = "PRIMARY KEY ";
  
  public static final String PRIMARY_KEY_AUTOINCREMENT = "PRIMARY KEY AUTOINCREMENT ";
  
  public static final String REPLACE = "REPLACE ";
  
  public static final String SELECT = "SELECT ";
  
  public static final String SELECT_ANY_FROM = "SELECT * FROM ";
  
  public static final String SELECT_MAX = "SELECT MAX ";
  
  public static final String SELECT_TABLES = "SELECT * FROM sqlite_master WHERE type='table' ORDER BY name";
  
  public static final String SET = " SET ";
  
  public static final String TABLE_IF_NOT_EXISTS = "TABLE IF NOT EXISTS ";
  
  public static final String TEMP = "TEMP ";
  
  public static final String TWO_HOLDER = "(?,?)";
  
  public static final int TYPE_INSERT = 1;
  
  public static final int TYPE_REPLACE = 2;
  
  public static final int TYPE_UPDATE = 3;
  
  public static final String UNIQUE = "UNIQUE ";
  
  public static final String UPDATE = "UPDATE ";
  
  public static final String VALUES = "VALUES";
  
  public static final String WHERE = " WHERE ";
  
  public static SQLStatement buildAddColumnSql(String paramString1, String paramString2) {
    SQLStatement sQLStatement = new SQLStatement();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ALTER TABLE ");
    stringBuilder.append(paramString1);
    stringBuilder.append(" ADD COLUMN ");
    stringBuilder.append(paramString2);
    sQLStatement.sql = stringBuilder.toString();
    return sQLStatement;
  }
  
  public static SQLStatement buildColumnsObtainAll(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PRAGMA table_info(");
    stringBuilder.append(paramString);
    stringBuilder.append(")");
    return new SQLStatement(stringBuilder.toString(), null);
  }
  
  public static SQLStatement buildCreateTable(EntityTable paramEntityTable) {
    byte b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CREATE ");
    if (paramEntityTable.getAnnotation(Temporary.class) != null)
      stringBuilder.append("TEMP "); 
    stringBuilder.append("TABLE IF NOT EXISTS ");
    stringBuilder.append(paramEntityTable.name);
    stringBuilder.append("(");
    if (paramEntityTable.key != null) {
      if (paramEntityTable.key.assign == AssignType.AUTO_INCREMENT) {
        stringBuilder.append(paramEntityTable.key.column);
        stringBuilder.append(" INTEGER ");
        stringBuilder.append("PRIMARY KEY AUTOINCREMENT ");
      } else {
        stringBuilder.append(paramEntityTable.key.column);
        stringBuilder.append(DataUtil.getSQLDataType(paramEntityTable.key.classType));
        stringBuilder.append("PRIMARY KEY ");
      } 
      b = 1;
    } else {
      b = 0;
    } 
    if (!Checker.isEmpty(paramEntityTable.pmap)) {
      SparseArray sparseArray;
      if (b)
        stringBuilder.append(","); 
      Iterator<Map.Entry> iterator = paramEntityTable.pmap.entrySet().iterator();
      paramEntityTable = null;
      byte b1 = 0;
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (b1) {
          stringBuilder.append(",");
          b = b1;
        } else {
          b = 1;
        } 
        String str = (String)entry.getKey();
        stringBuilder.append(str);
        if (entry.getValue() == null) {
          stringBuilder.append(" TEXT ");
          b1 = b;
          continue;
        } 
        Field field = ((Property)entry.getValue()).field;
        stringBuilder.append(DataUtil.getSQLDataType(((Property)entry.getValue()).classType));
        if (field.getAnnotation(NotNull.class) != null)
          stringBuilder.append("NOT NULL "); 
        if (field.getAnnotation(Default.class) != null) {
          stringBuilder.append("DEFAULT ");
          stringBuilder.append(((Default)field.<Default>getAnnotation(Default.class)).value());
          stringBuilder.append(" ");
        } 
        if (field.getAnnotation(Unique.class) != null)
          stringBuilder.append("UNIQUE "); 
        if (field.getAnnotation(Conflict.class) != null) {
          stringBuilder.append("ON CONFLICT ");
          stringBuilder.append(((Conflict)field.<Conflict>getAnnotation(Conflict.class)).value().getSql());
          stringBuilder.append(" ");
        } 
        if (field.getAnnotation(Check.class) != null) {
          stringBuilder.append("CHECK (");
          stringBuilder.append(((Check)field.<Check>getAnnotation(Check.class)).value());
          stringBuilder.append(")");
          stringBuilder.append(" ");
        } 
        if (field.getAnnotation(Collate.class) != null) {
          stringBuilder.append("COLLATE ");
          stringBuilder.append(((Collate)field.<Collate>getAnnotation(Collate.class)).value());
          stringBuilder.append(" ");
        } 
        UniqueCombine uniqueCombine = field.<UniqueCombine>getAnnotation(UniqueCombine.class);
        b1 = b;
        if (uniqueCombine != null) {
          SparseArray sparseArray1;
          EntityTable entityTable = paramEntityTable;
          if (paramEntityTable == null)
            sparseArray1 = new SparseArray(); 
          ArrayList<String> arrayList2 = (ArrayList)sparseArray1.get(uniqueCombine.value());
          ArrayList<String> arrayList1 = arrayList2;
          if (arrayList2 == null) {
            arrayList1 = new ArrayList();
            sparseArray1.put(uniqueCombine.value(), arrayList1);
          } 
          arrayList1.add(str);
          b1 = b;
          sparseArray = sparseArray1;
        } 
      } 
      if (sparseArray != null) {
        int i = sparseArray.size();
        for (b = 0; b < i; b++) {
          ArrayList<String> arrayList = (ArrayList)sparseArray.valueAt(b);
          if (arrayList.size() > 1) {
            stringBuilder.append(",");
            stringBuilder.append("UNIQUE ");
            stringBuilder.append("(");
            int j = arrayList.size();
            for (b1 = 0; b1 < j; b1++) {
              if (b1 != 0)
                stringBuilder.append(","); 
              stringBuilder.append(arrayList.get(b1));
            } 
            stringBuilder.append(")");
          } 
        } 
      } 
    } 
    stringBuilder.append(")");
    return new SQLStatement(stringBuilder.toString(), null);
  }
  
  public static MapInfo buildDelAllMappingSql(Class paramClass) {
    EntityTable entityTable = TableManager.getTable(paramClass);
    if (!Checker.isEmpty(entityTable.mappingList))
      try {
        MapInfo mapInfo = new MapInfo();
        this();
        Iterator<MapProperty> iterator = entityTable.mappingList.iterator();
        while (iterator.hasNext()) {
          EntityTable entityTable1 = TableManager.getTable(getTypeByRelation(iterator.next()));
          String str = TableManager.getMapTableName(entityTable, entityTable1);
          MapInfo.MapTable mapTable = new MapInfo.MapTable();
          this(str, entityTable.name, entityTable1.name);
          mapInfo.addTable(mapTable);
          mapInfo.addDelOldRelationSQL(buildMappingDeleteAllSql(entityTable, entityTable1));
        } 
        return mapInfo;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return null;
  }
  
  public static SQLStatement buildDeleteAllSql(Class<?> paramClass) {
    SQLStatement sQLStatement = new SQLStatement();
    EntityTable entityTable = TableManager.getTable(paramClass);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DELETE FROM ");
    stringBuilder.append(entityTable.name);
    sQLStatement.sql = stringBuilder.toString();
    return sQLStatement;
  }
  
  public static SQLStatement buildDeleteSql(Class<?> paramClass, long paramLong1, long paramLong2, String paramString) {
    SQLStatement sQLStatement = new SQLStatement();
    EntityTable entityTable = TableManager.getTable(paramClass);
    String str2 = entityTable.key.column;
    String str1 = paramString;
    if (Checker.isEmpty(paramString))
      str1 = str2; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DELETE FROM ");
    stringBuilder.append(entityTable.name);
    stringBuilder.append(" WHERE ");
    stringBuilder.append(str2);
    stringBuilder.append(" IN ");
    stringBuilder.append("(");
    stringBuilder.append("SELECT ");
    stringBuilder.append(str2);
    stringBuilder.append(" FROM ");
    stringBuilder.append(entityTable.name);
    stringBuilder.append(" ORDER BY ");
    stringBuilder.append(str1);
    stringBuilder.append(" ASC ");
    stringBuilder.append(" LIMIT ");
    stringBuilder.append(paramLong1);
    stringBuilder.append(",");
    stringBuilder.append(paramLong2);
    stringBuilder.append(")");
    sQLStatement.sql = stringBuilder.toString();
    return sQLStatement;
  }
  
  public static SQLStatement buildDeleteSql(Object paramObject) {
    SQLStatement sQLStatement = new SQLStatement();
    try {
      EntityTable entityTable = TableManager.getTable(paramObject);
      Primarykey primarykey = entityTable.key;
      byte b = 0;
      if (primarykey != null) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("DELETE FROM ");
        stringBuilder.append(entityTable.name);
        stringBuilder.append(" WHERE ");
        stringBuilder.append(entityTable.key.column);
        stringBuilder.append("=?");
        sQLStatement.sql = stringBuilder.toString();
        sQLStatement.bindArgs = (Object[])new String[] { String.valueOf(FieldUtil.get(entityTable.key.field, paramObject)) };
      } else if (!Checker.isEmpty(entityTable.pmap)) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("DELETE FROM ");
        stringBuilder.append(entityTable.name);
        stringBuilder.append(" WHERE ");
        Object[] arrayOfObject = new Object[entityTable.pmap.size()];
        for (Map.Entry entry : entityTable.pmap.entrySet()) {
          if (!b) {
            stringBuilder.append((String)entry.getKey());
            stringBuilder.append("=?");
          } else {
            stringBuilder.append(" AND ");
            stringBuilder.append((String)entry.getKey());
            stringBuilder.append("=?");
          } 
          arrayOfObject[b] = FieldUtil.get(((Property)entry.getValue()).field, paramObject);
          b++;
        } 
        sQLStatement.sql = stringBuilder.toString();
        sQLStatement.bindArgs = arrayOfObject;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return sQLStatement;
  }
  
  public static SQLStatement buildDeleteSql(Collection<?> paramCollection) {
    SQLStatement sQLStatement = new SQLStatement();
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this(256);
      Collection collection = null;
      Object[] arrayOfObject = new Object[paramCollection.size()];
      byte b = 0;
      Iterator<?> iterator = paramCollection.iterator();
      paramCollection = collection;
      while (iterator.hasNext()) {
        EntityTable entityTable;
        collection = (Collection)iterator.next();
        if (!b) {
          entityTable = TableManager.getTable(collection);
          stringBuilder.append("DELETE FROM ");
          stringBuilder.append(entityTable.name);
          stringBuilder.append(" WHERE ");
          stringBuilder.append(entityTable.key.column);
          stringBuilder.append(" IN ");
          stringBuilder.append("(");
          stringBuilder.append("?");
        } else {
          stringBuilder.append(",?");
        } 
        arrayOfObject[b] = FieldUtil.get(entityTable.key.field, collection);
        b++;
      } 
      stringBuilder.append(")");
      sQLStatement.sql = stringBuilder.toString();
      sQLStatement.bindArgs = arrayOfObject;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return sQLStatement;
  }
  
  public static SQLStatement buildDropTable(EntityTable paramEntityTable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DROP TABLE ");
    stringBuilder.append(paramEntityTable.name);
    return new SQLStatement(stringBuilder.toString(), null);
  }
  
  public static SQLStatement buildDropTable(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DROP TABLE ");
    stringBuilder.append(paramString);
    return new SQLStatement(stringBuilder.toString(), null);
  }
  
  public static SQLStatement buildGetLastRowId(EntityTable paramEntityTable) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT MAX (");
    stringBuilder.append(paramEntityTable.key.column);
    stringBuilder.append(")");
    stringBuilder.append(" FROM ");
    stringBuilder.append(paramEntityTable.name);
    return new SQLStatement(stringBuilder.toString(), null);
  }
  
  public static SQLStatement buildInsertAllSql(Object paramObject, ConflictAlgorithm paramConflictAlgorithm) {
    return buildInsertSql(paramObject, false, 1, paramConflictAlgorithm);
  }
  
  public static SQLStatement buildInsertSql(Object paramObject, ConflictAlgorithm paramConflictAlgorithm) {
    return buildInsertSql(paramObject, true, 1, paramConflictAlgorithm);
  }
  
  private static SQLStatement buildInsertSql(Object paramObject, boolean paramBoolean, int paramInt, ConflictAlgorithm paramConflictAlgorithm) {
    SQLStatement sQLStatement = new SQLStatement();
    try {
      Object[] arrayOfObject;
      boolean bool;
      EntityTable entityTable = TableManager.getTable(paramObject);
      StringBuilder stringBuilder1 = new StringBuilder();
      this(128);
      if (paramInt != 2) {
        stringBuilder1.append("INSERT ");
        if (paramConflictAlgorithm != null) {
          stringBuilder1.append(paramConflictAlgorithm.getAlgorithm());
          stringBuilder1.append("INTO ");
        } else {
          stringBuilder1.append("INTO ");
        } 
      } else {
        stringBuilder1.append("REPLACE ");
        stringBuilder1.append("INTO ");
      } 
      stringBuilder1.append(entityTable.name);
      stringBuilder1.append("(");
      stringBuilder1.append(entityTable.key.column);
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      stringBuilder2.append(")");
      stringBuilder2.append("VALUES");
      stringBuilder2.append("(");
      stringBuilder2.append("?");
      paramInt = 0;
      if (!Checker.isEmpty(entityTable.pmap)) {
        bool = entityTable.pmap.size() + 1;
      } else {
        bool = true;
      } 
      paramConflictAlgorithm = null;
      if (paramBoolean) {
        arrayOfObject = new Object[bool];
        arrayOfObject[0] = FieldUtil.getAssignedKeyObject(entityTable.key, paramObject);
        paramInt = 1;
      } 
      if (!Checker.isEmpty(entityTable.pmap))
        for (Map.Entry entry : entityTable.pmap.entrySet()) {
          stringBuilder1.append(",");
          stringBuilder1.append((String)entry.getKey());
          stringBuilder2.append(",?");
          if (paramBoolean)
            arrayOfObject[paramInt] = FieldUtil.get(((Property)entry.getValue()).field, paramObject); 
          paramInt++;
        }  
      stringBuilder1.append(stringBuilder2);
      stringBuilder1.append(")");
      sQLStatement.bindArgs = arrayOfObject;
      sQLStatement.sql = stringBuilder1.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return sQLStatement;
  }
  
  public static Object[] buildInsertSqlArgsOnly(Object paramObject) throws IllegalAccessException {
    byte b2;
    EntityTable entityTable = TableManager.getTable(paramObject);
    boolean bool = Checker.isEmpty(entityTable.pmap);
    byte b1 = 1;
    if (!bool) {
      b2 = entityTable.pmap.size() + 1;
    } else {
      b2 = 1;
    } 
    Object[] arrayOfObject = new Object[b2];
    arrayOfObject[0] = FieldUtil.getAssignedKeyObject(entityTable.key, paramObject);
    if (!Checker.isEmpty(entityTable.pmap)) {
      Iterator iterator = entityTable.pmap.values().iterator();
      for (b2 = b1; iterator.hasNext(); b2++)
        arrayOfObject[b2] = FieldUtil.get(((Property)iterator.next()).field, paramObject); 
    } 
    return arrayOfObject;
  }
  
  private static SQLStatement buildMappingDeleteAllSql(EntityTable paramEntityTable1, EntityTable paramEntityTable2) throws IllegalArgumentException, IllegalAccessException {
    if (paramEntityTable2 != null) {
      String str = TableManager.getMapTableName(paramEntityTable1, paramEntityTable2);
      SQLStatement sQLStatement = new SQLStatement();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("DELETE FROM ");
      stringBuilder.append(str);
      sQLStatement.sql = stringBuilder.toString();
      return sQLStatement;
    } 
    return null;
  }
  
  public static SQLStatement buildMappingDeleteSql(Object paramObject, EntityTable paramEntityTable1, EntityTable paramEntityTable2) throws IllegalArgumentException, IllegalAccessException {
    return (paramEntityTable2 != null) ? buildMappingDeleteSql(TableManager.getMapTableName(paramEntityTable1, paramEntityTable2), paramObject, paramEntityTable1) : null;
  }
  
  public static SQLStatement buildMappingDeleteSql(String paramString, Object paramObject, EntityTable paramEntityTable) throws IllegalArgumentException, IllegalAccessException {
    if (paramString != null) {
      SQLStatement sQLStatement = new SQLStatement();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("DELETE FROM ");
      stringBuilder.append(paramString);
      stringBuilder.append(" WHERE ");
      stringBuilder.append(paramEntityTable.name);
      stringBuilder.append("=?");
      sQLStatement.sql = stringBuilder.toString();
      sQLStatement.bindArgs = new Object[] { paramObject };
      return sQLStatement;
    } 
    return null;
  }
  
  public static MapInfo buildMappingInfo(Object paramObject, boolean paramBoolean, TableManager paramTableManager) {
    EntityTable entityTable = TableManager.getTable(paramObject);
    if (!Checker.isEmpty(entityTable.mappingList))
      try {
        Object object = FieldUtil.get(entityTable.key.field, paramObject);
        if (object == null)
          return null; 
        MapInfo mapInfo = new MapInfo();
        this();
        for (MapProperty mapProperty : entityTable.mappingList) {
          EntityTable entityTable1 = TableManager.getTable(getTypeByRelation(mapProperty));
          String str = TableManager.getMapTableName(entityTable, entityTable1);
          MapInfo.MapTable mapTable = new MapInfo.MapTable();
          this(str, entityTable.name, entityTable1.name);
          mapInfo.addTable(mapTable);
          if (paramTableManager.isSQLMapTableCreated(entityTable.name, entityTable1.name))
            mapInfo.addDelOldRelationSQL(buildMappingDeleteSql(object, entityTable, entityTable1)); 
          if (paramBoolean) {
            Object object1 = FieldUtil.get(mapProperty.field, paramObject);
            if (object1 != null) {
              if (mapProperty.isToMany()) {
                ArrayList<SQLStatement> arrayList;
                if (object1 instanceof Collection) {
                  arrayList = buildMappingToManySql(object, entityTable, entityTable1, (Collection)object1);
                } else if (object1 instanceof Object[]) {
                  arrayList = buildMappingToManySql(object, entityTable, entityTable1, Arrays.asList((Object[])object1));
                } else {
                  paramObject = new RuntimeException();
                  super("OneToMany and ManyToMany Relation, You must use array or collection object");
                  throw paramObject;
                } 
                if (Checker.isEmpty(arrayList))
                  mapInfo.addNewRelationSQL(arrayList); 
                continue;
              } 
              SQLStatement sQLStatement = buildMappingToOneSql(object, entityTable, entityTable1, object1);
              if (sQLStatement != null)
                mapInfo.addNewRelationSQL(sQLStatement); 
            } 
          } 
        } 
        return mapInfo;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return null;
  }
  
  public static <T> ArrayList<SQLStatement> buildMappingToManySql(final Object key1, final EntityTable table1, final EntityTable table2, Collection<T> paramCollection) throws Exception {
    final ArrayList<SQLStatement> sqlList = new ArrayList();
    CollSpliter.split(paramCollection, 499, new CollSpliter.Spliter<T>() {
          public int oneSplit(ArrayList<T> param1ArrayList) throws Exception {
            SQLStatement sQLStatement = SQLBuilder.buildMappingToManySqlFragment(key1, table1, table2, param1ArrayList);
            if (sQLStatement != null)
              sqlList.add(sQLStatement); 
            return 0;
          }
        });
    return arrayList;
  }
  
  private static SQLStatement buildMappingToManySqlFragment(Object paramObject, EntityTable paramEntityTable1, EntityTable paramEntityTable2, Collection<?> paramCollection) throws IllegalArgumentException, IllegalAccessException {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: invokestatic getMapTableName : (Lcom/litesuits/orm/db/model/EntityTable;Lcom/litesuits/orm/db/model/EntityTable;)Ljava/lang/String;
    //   5: astore #4
    //   7: aload_3
    //   8: invokestatic isEmpty : (Ljava/util/Collection;)Z
    //   11: ifne -> 262
    //   14: iconst_1
    //   15: istore #5
    //   17: new java/lang/StringBuilder
    //   20: dup
    //   21: sipush #128
    //   24: invokespecial <init> : (I)V
    //   27: astore #6
    //   29: new java/util/ArrayList
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore #7
    //   38: aload_0
    //   39: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_3
    //   44: invokeinterface iterator : ()Ljava/util/Iterator;
    //   49: astore_3
    //   50: aload_3
    //   51: invokeinterface hasNext : ()Z
    //   56: ifeq -> 139
    //   59: aload_3
    //   60: invokeinterface next : ()Ljava/lang/Object;
    //   65: astore #8
    //   67: aload_2
    //   68: getfield key : Lcom/litesuits/orm/db/model/Primarykey;
    //   71: aload #8
    //   73: invokestatic getAssignedKeyObject : (Lcom/litesuits/orm/db/model/Primarykey;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: astore #8
    //   78: aload #8
    //   80: ifnull -> 50
    //   83: iload #5
    //   85: ifeq -> 102
    //   88: aload #6
    //   90: ldc '(?,?)'
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: iconst_0
    //   97: istore #5
    //   99: goto -> 118
    //   102: aload #6
    //   104: ldc ','
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload #6
    //   112: ldc '(?,?)'
    //   114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload #7
    //   120: aload_0
    //   121: invokevirtual add : (Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload #7
    //   127: aload #8
    //   129: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   132: invokevirtual add : (Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -> 50
    //   139: aload #7
    //   141: aload #7
    //   143: invokevirtual size : ()I
    //   146: anewarray java/lang/String
    //   149: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   152: astore #7
    //   154: aload #7
    //   156: invokestatic isEmpty : ([Ljava/lang/Object;)Z
    //   159: ifne -> 262
    //   162: new com/litesuits/orm/db/assit/SQLStatement
    //   165: dup
    //   166: invokespecial <init> : ()V
    //   169: astore_3
    //   170: new java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial <init> : ()V
    //   177: astore_0
    //   178: aload_0
    //   179: ldc_w 'REPLACE INTO '
    //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_0
    //   187: aload #4
    //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_0
    //   194: ldc '('
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_0
    //   201: aload_1
    //   202: getfield name : Ljava/lang/String;
    //   205: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_0
    //   210: ldc ','
    //   212: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_0
    //   217: aload_2
    //   218: getfield name : Ljava/lang/String;
    //   221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_0
    //   226: ldc ')'
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_0
    //   233: ldc 'VALUES'
    //   235: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_0
    //   240: aload #6
    //   242: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_3
    //   247: aload_0
    //   248: invokevirtual toString : ()Ljava/lang/String;
    //   251: putfield sql : Ljava/lang/String;
    //   254: aload_3
    //   255: aload #7
    //   257: putfield bindArgs : [Ljava/lang/Object;
    //   260: aload_3
    //   261: areturn
    //   262: aconst_null
    //   263: areturn
  }
  
  public static SQLStatement buildMappingToOneSql(Object paramObject1, EntityTable paramEntityTable1, EntityTable paramEntityTable2, Object paramObject2) throws IllegalArgumentException, IllegalAccessException {
    paramObject2 = FieldUtil.getAssignedKeyObject(paramEntityTable2.key, paramObject2);
    return (paramObject2 != null) ? buildMappingToOneSql(TableManager.getMapTableName(paramEntityTable1, paramEntityTable2), paramObject1, paramObject2, paramEntityTable1, paramEntityTable2) : null;
  }
  
  public static SQLStatement buildMappingToOneSql(String paramString, Object paramObject1, Object paramObject2, EntityTable paramEntityTable1, EntityTable paramEntityTable2) throws IllegalArgumentException, IllegalAccessException {
    if (paramObject2 != null) {
      StringBuilder stringBuilder = new StringBuilder(128);
      stringBuilder.append("INSERT ");
      stringBuilder.append("INTO ");
      stringBuilder.append(paramString);
      stringBuilder.append("(");
      stringBuilder.append(paramEntityTable1.name);
      stringBuilder.append(",");
      stringBuilder.append(paramEntityTable2.name);
      stringBuilder.append(")");
      stringBuilder.append("VALUES");
      stringBuilder.append("(?,?)");
      SQLStatement sQLStatement = new SQLStatement();
      sQLStatement.sql = stringBuilder.toString();
      sQLStatement.bindArgs = new Object[] { paramObject1, paramObject2 };
      return sQLStatement;
    } 
    return null;
  }
  
  public static SQLStatement buildQueryMapEntitySql(EntityTable paramEntityTable, Object paramObject) {
    SQLStatement sQLStatement = new SQLStatement();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT * FROM ");
    stringBuilder.append(paramEntityTable.name);
    stringBuilder.append(" WHERE ");
    stringBuilder.append(paramEntityTable.key.column);
    stringBuilder.append("=?");
    sQLStatement.sql = stringBuilder.toString();
    sQLStatement.bindArgs = (Object[])new String[] { String.valueOf(paramObject) };
    return sQLStatement;
  }
  
  public static SQLStatement buildQueryRelationSql(EntityTable paramEntityTable1, EntityTable paramEntityTable2, Object paramObject) {
    SQLStatement sQLStatement = new SQLStatement();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT * FROM ");
    stringBuilder.append(TableManager.getMapTableName(paramEntityTable1, paramEntityTable2));
    stringBuilder.append(" WHERE ");
    stringBuilder.append(paramEntityTable1.name);
    stringBuilder.append("=?");
    sQLStatement.sql = stringBuilder.toString();
    sQLStatement.bindArgs = (Object[])new String[] { String.valueOf(paramObject) };
    return sQLStatement;
  }
  
  public static SQLStatement buildQueryRelationSql(Class paramClass1, Class paramClass2, List<String> paramList) {
    return buildQueryRelationSql(paramClass1, paramClass2, paramList, null);
  }
  
  private static SQLStatement buildQueryRelationSql(Class<?> paramClass1, Class<?> paramClass2, List<String> paramList1, List<String> paramList2) {
    StringBuilder stringBuilder;
    EntityTable entityTable1 = TableManager.getTable(paramClass1);
    EntityTable entityTable2 = TableManager.getTable(paramClass2);
    QueryBuilder<?> queryBuilder = (new QueryBuilder(paramClass1)).queryMappingInfo(paramClass2);
    ArrayList<String> arrayList = new ArrayList();
    boolean bool = Checker.isEmpty(paramList1);
    byte b = 0;
    if (!bool) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(entityTable1.name);
      stringBuilder1.append(" IN ");
      stringBuilder1.append("(");
      int i = paramList1.size();
      for (byte b1 = 0; b1 < i; b1++) {
        if (b1 == 0) {
          stringBuilder1.append("?");
        } else {
          stringBuilder1.append(",?");
        } 
      } 
      stringBuilder1.append(")");
      arrayList.addAll(paramList1);
    } else {
      paramClass1 = null;
    } 
    paramClass2 = paramClass1;
    if (!Checker.isEmpty(paramList2)) {
      StringBuilder stringBuilder1;
      if (paramClass1 == null) {
        stringBuilder1 = new StringBuilder();
      } else {
        stringBuilder1.append(" AND ");
      } 
      stringBuilder1.append(entityTable2.name);
      stringBuilder1.append(" IN ");
      stringBuilder1.append("(");
      int i = paramList2.size();
      for (byte b1 = b; b1 < i; b1++) {
        if (b1 == 0) {
          stringBuilder1.append("?");
        } else {
          stringBuilder1.append(",?");
        } 
      } 
      stringBuilder1.append(")");
      arrayList.addAll(paramList2);
      stringBuilder = stringBuilder1;
    } 
    if (stringBuilder != null)
      queryBuilder.where(stringBuilder.toString(), arrayList.toArray((Object[])new String[arrayList.size()])); 
    return queryBuilder.createStatement();
  }
  
  public static SQLStatement buildReplaceAllSql(Object paramObject) {
    return buildInsertSql(paramObject, false, 2, null);
  }
  
  public static SQLStatement buildReplaceSql(Object paramObject) {
    return buildInsertSql(paramObject, true, 2, null);
  }
  
  public static SQLStatement buildTableObtainAll() {
    return new SQLStatement("SELECT * FROM sqlite_master WHERE type='table' ORDER BY name", null);
  }
  
  public static SQLStatement buildUpdateAllSql(Object paramObject, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm) {
    return buildUpdateSql(paramObject, paramColumnsValue, paramConflictAlgorithm, false);
  }
  
  public static SQLStatement buildUpdateSql(WhereBuilder paramWhereBuilder, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm) {
    SQLStatement sQLStatement = new SQLStatement();
    try {
      Object[] arrayOfObject;
      EntityTable entityTable = TableManager.getTable(paramWhereBuilder.getTableClass());
      StringBuilder stringBuilder = new StringBuilder();
      this(128);
      stringBuilder.append("UPDATE ");
      if (paramConflictAlgorithm != null)
        stringBuilder.append(paramConflictAlgorithm.getAlgorithm()); 
      stringBuilder.append(entityTable.name);
      stringBuilder.append(" SET ");
      if (paramColumnsValue != null && paramColumnsValue.checkColumns()) {
        Object[] arrayOfObject1;
        Object[] arrayOfObject2 = paramWhereBuilder.getWhereArgs();
        if (arrayOfObject2 != null) {
          arrayOfObject1 = new Object[paramColumnsValue.columns.length + arrayOfObject2.length];
        } else {
          arrayOfObject1 = new Object[paramColumnsValue.columns.length];
        } 
        byte b1 = 0;
        byte b2;
        for (b2 = 0; b2 < paramColumnsValue.columns.length; b2++) {
          if (b2 > 0)
            stringBuilder.append(","); 
          stringBuilder.append(paramColumnsValue.columns[b2]);
          stringBuilder.append("=?");
          arrayOfObject1[b2] = paramColumnsValue.getValue(paramColumnsValue.columns[b2]);
        } 
        arrayOfObject = arrayOfObject1;
        if (arrayOfObject2 != null) {
          int i = arrayOfObject2.length;
          while (true) {
            arrayOfObject = arrayOfObject1;
            if (b1 < i) {
              arrayOfObject1[b2] = arrayOfObject2[b1];
              b1++;
              b2++;
              continue;
            } 
            break;
          } 
        } 
      } else {
        arrayOfObject = paramWhereBuilder.getWhereArgs();
      } 
      stringBuilder.append(paramWhereBuilder.createWhereString());
      sQLStatement.sql = stringBuilder.toString();
      sQLStatement.bindArgs = arrayOfObject;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return sQLStatement;
  }
  
  public static SQLStatement buildUpdateSql(Object paramObject, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm) {
    return buildUpdateSql(paramObject, paramColumnsValue, paramConflictAlgorithm, true);
  }
  
  private static SQLStatement buildUpdateSql(Object paramObject, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm, boolean paramBoolean) {
    SQLStatement sQLStatement = new SQLStatement();
    try {
      Object[] arrayOfObject;
      EntityTable entityTable = TableManager.getTable(paramObject);
      StringBuilder stringBuilder = new StringBuilder();
      this(128);
      stringBuilder.append("UPDATE ");
      if (paramConflictAlgorithm != null)
        stringBuilder.append(paramConflictAlgorithm.getAlgorithm()); 
      stringBuilder.append(entityTable.name);
      stringBuilder.append(" SET ");
      byte b1 = 0;
      byte b2 = 0;
      Iterator<Map.Entry> iterator = null;
      paramConflictAlgorithm = null;
      if (paramColumnsValue != null && paramColumnsValue.checkColumns()) {
        boolean bool;
        if (paramBoolean) {
          bool = paramColumnsValue.columns.length + 1;
          arrayOfObject = new Object[bool];
        } else {
          paramConflictAlgorithm = null;
          bool = true;
        } 
        while (b2 < paramColumnsValue.columns.length) {
          if (b2 > 0)
            stringBuilder.append(","); 
          stringBuilder.append(paramColumnsValue.columns[b2]);
          stringBuilder.append("=?");
          if (paramBoolean) {
            paramConflictAlgorithm[b2] = (ConflictAlgorithm)paramColumnsValue.getValue(paramColumnsValue.columns[b2]);
            if (paramConflictAlgorithm[b2] == null)
              paramConflictAlgorithm[b2] = (ConflictAlgorithm)FieldUtil.get(((Property)entityTable.pmap.get(paramColumnsValue.columns[b2])).field, paramObject); 
          } 
          b2++;
        } 
        b2 = bool;
      } else if (!Checker.isEmpty(entityTable.pmap)) {
        ConflictAlgorithm conflictAlgorithm;
        boolean bool;
        if (paramBoolean) {
          bool = entityTable.pmap.size() + 1;
          Object[] arrayOfObject1 = new Object[bool];
        } else {
          bool = true;
          conflictAlgorithm = paramConflictAlgorithm;
        } 
        iterator = entityTable.pmap.entrySet().iterator();
        while (true) {
          paramConflictAlgorithm = conflictAlgorithm;
          b2 = bool;
          if (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (b1)
              stringBuilder.append(","); 
            stringBuilder.append((String)entry.getKey());
            stringBuilder.append("=?");
            if (paramBoolean)
              conflictAlgorithm[b1] = (ConflictAlgorithm)FieldUtil.get(((Property)entry.getValue()).field, paramObject); 
            b1++;
            continue;
          } 
          break;
        } 
      } else {
        Iterator<Map.Entry> iterator1 = iterator;
        if (paramBoolean)
          arrayOfObject = new Object[1]; 
        b2 = 1;
      } 
      if (paramBoolean)
        arrayOfObject[b2 - 1] = FieldUtil.getAssignedKeyObject(entityTable.key, paramObject); 
      stringBuilder.append(" WHERE ");
      stringBuilder.append(entityTable.key.column);
      stringBuilder.append("=?");
      sQLStatement.sql = stringBuilder.toString();
      sQLStatement.bindArgs = arrayOfObject;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return sQLStatement;
  }
  
  public static Object[] buildUpdateSqlArgsOnly(Object paramObject, ColumnsValue paramColumnsValue) throws IllegalAccessException {
    Object[] arrayOfObject;
    EntityTable entityTable = TableManager.getTable(paramObject);
    int i = 0;
    int j = 0;
    if (paramColumnsValue != null && paramColumnsValue.checkColumns()) {
      i = paramColumnsValue.columns.length + 1;
      Object[] arrayOfObject1 = new Object[i];
      while (j < paramColumnsValue.columns.length) {
        arrayOfObject1[j] = paramColumnsValue.getValue(paramColumnsValue.columns[j]);
        if (arrayOfObject1[j] == null)
          arrayOfObject1[j] = FieldUtil.get(((Property)entityTable.pmap.get(paramColumnsValue.columns[j])).field, paramObject); 
        j++;
      } 
      j = i;
      arrayOfObject = arrayOfObject1;
    } else if (!Checker.isEmpty(entityTable.pmap)) {
      int k = entityTable.pmap.size() + 1;
      Object[] arrayOfObject1 = new Object[k];
      Iterator iterator = entityTable.pmap.entrySet().iterator();
      while (true) {
        arrayOfObject = arrayOfObject1;
        j = k;
        if (iterator.hasNext()) {
          arrayOfObject1[i] = FieldUtil.get(((Property)((Map.Entry)iterator.next()).getValue()).field, paramObject);
          i++;
          continue;
        } 
        break;
      } 
    } else {
      arrayOfObject = new Object[1];
      j = 1;
    } 
    arrayOfObject[j - 1] = FieldUtil.getAssignedKeyObject(entityTable.key, paramObject);
    return arrayOfObject;
  }
  
  private static Class getTypeByRelation(MapProperty paramMapProperty) {
    Class<?> clazz;
    if (paramMapProperty.isToMany()) {
      Class<?> clazz1 = paramMapProperty.field.getType();
      if (ClassUtil.isCollection(clazz1)) {
        clazz = FieldUtil.getGenericType(paramMapProperty.field);
      } else if (ClassUtil.isArray(clazz1)) {
        clazz = FieldUtil.getComponentType(((MapProperty)clazz).field);
      } else {
        throw new RuntimeException("OneToMany and ManyToMany Relation, you must use collection or array object");
      } 
    } else {
      clazz = ((MapProperty)clazz).field.getType();
    } 
    return clazz;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\assit\SQLBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */