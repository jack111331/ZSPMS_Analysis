package com.litesuits.orm.db;

import android.database.sqlite.SQLiteDatabase;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.SQLStatement;
import com.litesuits.orm.db.assit.SQLiteHelper;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.litesuits.orm.db.model.ColumnsValue;
import com.litesuits.orm.db.model.ConflictAlgorithm;
import com.litesuits.orm.db.model.RelationKey;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface DataBase {
  void close();
  
  SQLStatement createSQLStatement(String paramString, Object[] paramArrayOfObject);
  
  int delete(WhereBuilder paramWhereBuilder);
  
  <T> int delete(Class<T> paramClass);
  
  <T> int delete(Class<T> paramClass, long paramLong1, long paramLong2, String paramString);
  
  <T> int delete(Class<T> paramClass, WhereBuilder paramWhereBuilder);
  
  int delete(Object paramObject);
  
  <T> int delete(Collection<T> paramCollection);
  
  <T> int deleteAll(Class<T> paramClass);
  
  boolean deleteDatabase();
  
  boolean deleteDatabase(File paramFile);
  
  boolean dropTable(Class<?> paramClass);
  
  @Deprecated
  boolean dropTable(Object paramObject);
  
  boolean dropTable(String paramString);
  
  boolean execute(SQLiteDatabase paramSQLiteDatabase, SQLStatement paramSQLStatement);
  
  DataBaseConfig getDataBaseConfig();
  
  SQLiteDatabase getReadableDatabase();
  
  SQLiteHelper getSQLiteHelper();
  
  TableManager getTableManager();
  
  SQLiteDatabase getWritableDatabase();
  
  <T> int insert(Collection<T> paramCollection);
  
  <T> int insert(Collection<T> paramCollection, ConflictAlgorithm paramConflictAlgorithm);
  
  long insert(Object paramObject);
  
  long insert(Object paramObject, ConflictAlgorithm paramConflictAlgorithm);
  
  <E, T> boolean mapping(Collection<E> paramCollection, Collection<T> paramCollection1);
  
  SQLiteDatabase openOrCreateDatabase();
  
  SQLiteDatabase openOrCreateDatabase(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory);
  
  <T> ArrayList<T> query(QueryBuilder<T> paramQueryBuilder);
  
  <T> ArrayList<T> query(Class<T> paramClass);
  
  <T> T queryById(long paramLong, Class<T> paramClass);
  
  <T> T queryById(String paramString, Class<T> paramClass);
  
  long queryCount(QueryBuilder paramQueryBuilder);
  
  <T> long queryCount(Class<T> paramClass);
  
  ArrayList<RelationKey> queryRelation(Class paramClass1, Class paramClass2, List<String> paramList);
  
  <T> int save(Collection<T> paramCollection);
  
  long save(Object paramObject);
  
  int update(WhereBuilder paramWhereBuilder, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm);
  
  int update(Object paramObject);
  
  int update(Object paramObject, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm);
  
  int update(Object paramObject, ConflictAlgorithm paramConflictAlgorithm);
  
  <T> int update(Collection<T> paramCollection);
  
  <T> int update(Collection<T> paramCollection, ColumnsValue paramColumnsValue, ConflictAlgorithm paramConflictAlgorithm);
  
  <T> int update(Collection<T> paramCollection, ConflictAlgorithm paramConflictAlgorithm);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\DataBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */