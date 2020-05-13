package com.litesuits.orm.db.assit;

import com.litesuits.orm.db.TableManager;
import java.util.regex.Pattern;

public class QueryBuilder<T> {
  public static final String AND = " AND ";
  
  public static final String ASC = " ASC";
  
  public static final String ASTERISK = "*";
  
  public static final String COMMA = ",";
  
  public static final String COMMA_HOLDER = ",?";
  
  public static final String DESC = " DESC";
  
  public static final String DISTINCT = " DISTINCT ";
  
  public static final String EQUAL_HOLDER = "=?";
  
  public static final String FROM = " FROM ";
  
  public static final String GROUP_BY = " GROUP BY ";
  
  public static final String HAVING = " HAVING ";
  
  public static final String LIMIT = " LIMIT ";
  
  public static final String OR = " OR ";
  
  public static final String ORDER_BY = " ORDER BY ";
  
  public static final String SELECT = "SELECT ";
  
  public static final String SELECT_COUNT = "SELECT COUNT(*) FROM ";
  
  private static final Pattern limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
  
  protected Class<T> clazz;
  
  protected Class clazzMapping;
  
  protected String[] columns;
  
  protected boolean distinct;
  
  protected String group;
  
  protected String having;
  
  protected String limit;
  
  protected String order;
  
  protected WhereBuilder whereBuilder;
  
  public QueryBuilder(Class<T> paramClass) {
    this.clazz = paramClass;
    this.whereBuilder = new WhereBuilder(paramClass);
  }
  
  private static void appendClause(StringBuilder paramStringBuilder, String paramString1, String paramString2) {
    if (!Checker.isEmpty(paramString2)) {
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append(paramString2);
    } 
  }
  
  private static void appendColumns(StringBuilder paramStringBuilder, String[] paramArrayOfString) {
    int i = paramArrayOfString.length;
    for (byte b = 0; b < i; b++) {
      String str = paramArrayOfString[b];
      if (str != null) {
        if (b > 0)
          paramStringBuilder.append(","); 
        paramStringBuilder.append(str);
      } 
    } 
    paramStringBuilder.append(" ");
  }
  
  private String buildWhereIn(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder(paramString);
    stringBuilder.append(" IN (?");
    for (byte b = 1; b < paramInt; b++)
      stringBuilder.append(",?"); 
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public static <T> QueryBuilder<T> create(Class<T> paramClass) {
    return new QueryBuilder<T>(paramClass);
  }
  
  public QueryBuilder<T> appendColumns(String[] paramArrayOfString) {
    if (this.columns != null) {
      String[] arrayOfString = new String[this.columns.length + paramArrayOfString.length];
      System.arraycopy(this.columns, 0, arrayOfString, 0, this.columns.length);
      System.arraycopy(paramArrayOfString, 0, arrayOfString, this.columns.length, paramArrayOfString.length);
      this.columns = arrayOfString;
    } else {
      this.columns = paramArrayOfString;
    } 
    return this;
  }
  
  public QueryBuilder<T> appendOrderAscBy(String paramString) {
    if (this.order == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" ASC");
      this.order = stringBuilder.toString();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.order);
      stringBuilder.append(", ");
      stringBuilder.append(paramString);
      stringBuilder.append(" ASC");
      this.order = stringBuilder.toString();
    } 
    return this;
  }
  
  public QueryBuilder<T> appendOrderDescBy(String paramString) {
    if (this.order == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" DESC");
      this.order = stringBuilder.toString();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.order);
      stringBuilder.append(", ");
      stringBuilder.append(paramString);
      stringBuilder.append(" DESC");
      this.order = stringBuilder.toString();
    } 
    return this;
  }
  
  public QueryBuilder<T> columns(String[] paramArrayOfString) {
    this.columns = paramArrayOfString;
    return this;
  }
  
  public SQLStatement createStatement() {
    if (this.clazz != null) {
      if (!Checker.isEmpty(this.group) || Checker.isEmpty(this.having)) {
        if (Checker.isEmpty(this.limit) || limitPattern.matcher(this.limit).matches()) {
          StringBuilder stringBuilder1 = new StringBuilder(120);
          stringBuilder1.append("SELECT ");
          if (this.distinct)
            stringBuilder1.append(" DISTINCT "); 
          if (!Checker.isEmpty((Object[])this.columns)) {
            appendColumns(stringBuilder1, this.columns);
          } else {
            stringBuilder1.append("*");
          } 
          stringBuilder1.append(" FROM ");
          stringBuilder1.append(getTableName());
          stringBuilder1.append(this.whereBuilder.createWhereString());
          appendClause(stringBuilder1, " GROUP BY ", this.group);
          appendClause(stringBuilder1, " HAVING ", this.having);
          appendClause(stringBuilder1, " ORDER BY ", this.order);
          appendClause(stringBuilder1, " LIMIT ", this.limit);
          SQLStatement sQLStatement = new SQLStatement();
          sQLStatement.sql = stringBuilder1.toString();
          sQLStatement.bindArgs = (Object[])this.whereBuilder.transToStringArray();
          return sQLStatement;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invalid LIMIT clauses:");
        stringBuilder.append(this.limit);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("HAVING仅允许在有GroupBy的时候使用(HAVING clauses are only permitted when using a groupBy clause)");
    } 
    throw new IllegalArgumentException("U Must Set A Query Entity Class By queryWho(Class) or QueryBuilder(Class)");
  }
  
  public SQLStatement createStatementForCount() {
    StringBuilder stringBuilder = new StringBuilder(120);
    stringBuilder.append("SELECT COUNT(*) FROM ");
    stringBuilder.append(getTableName());
    SQLStatement sQLStatement = new SQLStatement();
    if (this.whereBuilder != null) {
      stringBuilder.append(this.whereBuilder.createWhereString());
      sQLStatement.bindArgs = (Object[])this.whereBuilder.transToStringArray();
    } 
    sQLStatement.sql = stringBuilder.toString();
    return sQLStatement;
  }
  
  public QueryBuilder<T> distinct(boolean paramBoolean) {
    this.distinct = paramBoolean;
    return this;
  }
  
  public Class<T> getQueryClass() {
    return this.clazz;
  }
  
  public String getTableName() {
    return (this.clazzMapping == null) ? TableManager.getTableName(this.clazz) : TableManager.getMapTableName(this.clazz, this.clazzMapping);
  }
  
  public WhereBuilder getwhereBuilder() {
    return this.whereBuilder;
  }
  
  public QueryBuilder<T> groupBy(String paramString) {
    this.group = paramString;
    return this;
  }
  
  public QueryBuilder<T> having(String paramString) {
    this.having = paramString;
    return this;
  }
  
  public QueryBuilder<T> limit(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append(",");
    stringBuilder.append(paramInt2);
    this.limit = stringBuilder.toString();
    return this;
  }
  
  public QueryBuilder<T> limit(String paramString) {
    this.limit = paramString;
    return this;
  }
  
  public QueryBuilder<T> orderBy(String paramString) {
    this.order = paramString;
    return this;
  }
  
  public QueryBuilder<T> queryMappingInfo(Class paramClass) {
    this.clazzMapping = paramClass;
    return this;
  }
  
  public QueryBuilder<T> where(WhereBuilder paramWhereBuilder) {
    this.whereBuilder = paramWhereBuilder;
    return this;
  }
  
  public QueryBuilder<T> where(String paramString, Object... paramVarArgs) {
    this.whereBuilder.where(paramString, paramVarArgs);
    return this;
  }
  
  public QueryBuilder<T> whereAnd(String paramString, Object... paramVarArgs) {
    this.whereBuilder.and(paramString, paramVarArgs);
    return this;
  }
  
  public QueryBuilder<T> whereAppend(String paramString, Object... paramVarArgs) {
    this.whereBuilder.append(null, paramString, paramVarArgs);
    return this;
  }
  
  public QueryBuilder<T> whereAppendAnd() {
    this.whereBuilder.and();
    return this;
  }
  
  public QueryBuilder<T> whereAppendNot() {
    this.whereBuilder.not();
    return this;
  }
  
  public QueryBuilder<T> whereAppendOr() {
    this.whereBuilder.or();
    return this;
  }
  
  public QueryBuilder<T> whereEquals(String paramString, Object paramObject) {
    this.whereBuilder.equals(paramString, paramObject);
    return this;
  }
  
  public QueryBuilder<T> whereGreaterThan(String paramString, Object paramObject) {
    this.whereBuilder.greaterThan(paramString, paramObject);
    return this;
  }
  
  public QueryBuilder<T> whereIn(String paramString, Object... paramVarArgs) {
    this.whereBuilder.in(paramString, paramVarArgs);
    return this;
  }
  
  public QueryBuilder<T> whereLessThan(String paramString, Object paramObject) {
    this.whereBuilder.lessThan(paramString, paramObject);
    return this;
  }
  
  public QueryBuilder<T> whereNoEquals(String paramString, Object paramObject) {
    this.whereBuilder.noEquals(paramString, paramObject);
    return this;
  }
  
  public QueryBuilder<T> whereOr(String paramString, Object... paramVarArgs) {
    this.whereBuilder.or(paramString, paramVarArgs);
    return this;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\assit\QueryBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */