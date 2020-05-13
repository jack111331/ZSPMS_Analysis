package com.litesuits.orm.db.assit;

import com.litesuits.orm.db.TableManager;

public class WhereBuilder {
  public static final String AND = " AND ";
  
  public static final String COMMA_HOLDER = ",?";
  
  public static final String DELETE = "DELETE FROM ";
  
  public static final String EQUAL_HOLDER = "=?";
  
  public static final String GREATER_THAN_HOLDER = ">?";
  
  public static final String HOLDER = "?";
  
  private static final String IN = " IN ";
  
  public static final String LESS_THAN_HOLDER = "<?";
  
  public static final String NOT = " NOT ";
  
  public static final String NOTHING = "";
  
  public static final String NOT_EQUAL_HOLDER = "!=?";
  
  public static final String OR = " OR ";
  
  private static final String PARENTHESES_LEFT = "(";
  
  private static final String PARENTHESES_RIGHT = ")";
  
  public static final String WHERE = " WHERE ";
  
  protected Class tableClass;
  
  protected String where;
  
  protected Object[] whereArgs;
  
  public WhereBuilder(Class paramClass) {
    this.tableClass = paramClass;
  }
  
  public WhereBuilder(Class paramClass, String paramString, Object[] paramArrayOfObject) {
    this.where = paramString;
    this.whereArgs = paramArrayOfObject;
    this.tableClass = paramClass;
  }
  
  private String buildWhereIn(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder(paramString);
    stringBuilder.append(" IN ");
    stringBuilder.append("(");
    stringBuilder.append("?");
    for (byte b = 1; b < paramInt; b++)
      stringBuilder.append(",?"); 
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public static WhereBuilder create(Class paramClass) {
    return new WhereBuilder(paramClass);
  }
  
  public static WhereBuilder create(Class paramClass, String paramString, Object[] paramArrayOfObject) {
    return new WhereBuilder(paramClass, paramString, paramArrayOfObject);
  }
  
  public WhereBuilder and() {
    if (this.where != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.where);
      stringBuilder.append(" AND ");
      this.where = stringBuilder.toString();
    } 
    return this;
  }
  
  public WhereBuilder and(String paramString, Object... paramVarArgs) {
    return append(" AND ", paramString, paramVarArgs);
  }
  
  public WhereBuilder andEquals(String paramString, Object paramObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("=?");
    return append(" AND ", stringBuilder.toString(), new Object[] { paramObject });
  }
  
  public WhereBuilder andIn(String paramString, Object... paramVarArgs) {
    return append(" AND ", buildWhereIn(paramString, paramVarArgs.length), paramVarArgs);
  }
  
  public WhereBuilder append(String paramString1, String paramString2, Object... paramVarArgs) {
    if (this.where == null) {
      this.where = paramString2;
      this.whereArgs = paramVarArgs;
    } else {
      if (paramString1 != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.where);
        stringBuilder1.append(paramString1);
        this.where = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.where);
      stringBuilder.append(paramString2);
      this.where = stringBuilder.toString();
      if (this.whereArgs == null) {
        this.whereArgs = paramVarArgs;
      } else {
        Object[] arrayOfObject = new Object[this.whereArgs.length + paramVarArgs.length];
        System.arraycopy(this.whereArgs, 0, arrayOfObject, 0, this.whereArgs.length);
        System.arraycopy(paramVarArgs, 0, arrayOfObject, this.whereArgs.length, paramVarArgs.length);
        this.whereArgs = arrayOfObject;
      } 
    } 
    return this;
  }
  
  public SQLStatement createStatementDelete() {
    SQLStatement sQLStatement = new SQLStatement();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DELETE FROM ");
    stringBuilder.append(TableManager.getTableName(this.tableClass));
    stringBuilder.append(createWhereString());
    sQLStatement.sql = stringBuilder.toString();
    sQLStatement.bindArgs = (Object[])transToStringArray();
    return sQLStatement;
  }
  
  public String createWhereString() {
    if (this.where != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" WHERE ");
      stringBuilder.append(this.where);
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public WhereBuilder equals(String paramString, Object paramObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("=?");
    return append(null, stringBuilder.toString(), new Object[] { paramObject });
  }
  
  public Class getTableClass() {
    return this.tableClass;
  }
  
  public String getWhere() {
    return this.where;
  }
  
  public Object[] getWhereArgs() {
    return this.whereArgs;
  }
  
  public WhereBuilder greaterThan(String paramString, Object paramObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(">?");
    return append(null, stringBuilder.toString(), new Object[] { paramObject });
  }
  
  public WhereBuilder in(String paramString, Object... paramVarArgs) {
    return append(null, buildWhereIn(paramString, paramVarArgs.length), paramVarArgs);
  }
  
  public WhereBuilder lessThan(String paramString, Object paramObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("<?");
    return append(null, stringBuilder.toString(), new Object[] { paramObject });
  }
  
  public WhereBuilder noEquals(String paramString, Object paramObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("!=?");
    return append(null, stringBuilder.toString(), new Object[] { paramObject });
  }
  
  public WhereBuilder not() {
    if (this.where != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.where);
      stringBuilder.append(" NOT ");
      this.where = stringBuilder.toString();
    } 
    return this;
  }
  
  public WhereBuilder or() {
    if (this.where != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.where);
      stringBuilder.append(" OR ");
      this.where = stringBuilder.toString();
    } 
    return this;
  }
  
  public WhereBuilder or(String paramString, Object... paramVarArgs) {
    return append(" OR ", paramString, paramVarArgs);
  }
  
  public WhereBuilder orEquals(String paramString, Object paramObject) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("=?");
    return append(" OR ", stringBuilder.toString(), new Object[] { paramObject });
  }
  
  public WhereBuilder orIn(String paramString, Object... paramVarArgs) {
    return append(" OR ", buildWhereIn(paramString, paramVarArgs.length), paramVarArgs);
  }
  
  public void setWhere(String paramString) {
    this.where = paramString;
  }
  
  public void setWhereArgs(Object[] paramArrayOfObject) {
    this.whereArgs = paramArrayOfObject;
  }
  
  public String[] transToStringArray() {
    if (this.whereArgs != null && this.whereArgs.length > 0) {
      if (this.whereArgs instanceof String[])
        return (String[])this.whereArgs; 
      String[] arrayOfString = new String[this.whereArgs.length];
      for (byte b = 0; b < arrayOfString.length; b++)
        arrayOfString[b] = String.valueOf(this.whereArgs[b]); 
      return arrayOfString;
    } 
    return null;
  }
  
  public WhereBuilder where(String paramString, Object... paramVarArgs) {
    this.where = paramString;
    this.whereArgs = paramVarArgs;
    return this;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\assit\WhereBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */