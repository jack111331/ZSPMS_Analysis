package com.zz.sdk.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.cv;
import java.util.ArrayList;
import java.util.List;

public class w {
  private static final String a = "sdkuser";
  
  private static final String b = "user_id";
  
  private static final String c = "login_id";
  
  private static final String d = "login_name";
  
  private static final String e = "password";
  
  private static final String f = "auto_login";
  
  private static final String g = "last_login_time";
  
  private static final String h = "login_type";
  
  private static final String i = "local_login_count";
  
  private static final String j = "user_type";
  
  private static final long k = 1000L;
  
  private static w m;
  
  private SQLiteDatabase l;
  
  private w(Context paramContext) {
    try {
      x x = new x();
      this(this, paramContext);
      this.l = x.getWritableDatabase();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private v a(Cursor paramCursor) {
    v v = new v();
    v.a = paramCursor.getInt(paramCursor.getColumnIndex("user_id"));
    v.o = cv.d(paramCursor.getString(paramCursor.getColumnIndex("login_id")));
    v.b = cv.d(paramCursor.getString(paramCursor.getColumnIndex("login_name")));
    v.c = cv.d(paramCursor.getString(paramCursor.getColumnIndex("password")));
    v.d = paramCursor.getInt(paramCursor.getColumnIndex("auto_login"));
    v.f = paramCursor.getLong(paramCursor.getColumnIndex("last_login_time"));
    if (paramCursor.getString(paramCursor.getColumnIndex("login_type")) == null) {
      byte b = -1;
      v.h = b;
      v.p = paramCursor.getInt(paramCursor.getColumnIndex("local_login_count"));
      v.i = paramCursor.getInt(paramCursor.getColumnIndex("user_type"));
      return v;
    } 
    int i = paramCursor.getInt(paramCursor.getColumnIndex("login_type"));
    v.h = i;
    v.p = paramCursor.getInt(paramCursor.getColumnIndex("local_login_count"));
    v.i = paramCursor.getInt(paramCursor.getColumnIndex("user_type"));
    return v;
  }
  
  public static w a(Context paramContext) {
    if (m == null)
      m = new w(paramContext); 
    return m;
  }
  
  private ContentValues b(v paramv) {
    if (paramv == null)
      return null; 
    ContentValues contentValues = new ContentValues();
    contentValues.put("user_id", Integer.valueOf(paramv.a));
    if (!TextUtils.isEmpty(paramv.o))
      contentValues.put("login_id", cv.c(paramv.o)); 
    contentValues.put("login_name", cv.c(paramv.b));
    contentValues.put("password", cv.c(paramv.c));
    contentValues.put("auto_login", Integer.valueOf(paramv.d));
    contentValues.put("last_login_time", Long.valueOf(System.currentTimeMillis()));
    contentValues.put("login_type", Integer.valueOf(paramv.h));
    contentValues.put("local_login_count", Integer.valueOf(paramv.p));
    contentValues.put("user_type", Integer.valueOf(paramv.i));
    return contentValues;
  }
  
  private String[] b(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aconst_null
    //   6: astore #5
    //   8: new java/lang/StringBuilder
    //   11: astore #6
    //   13: aload #6
    //   15: invokespecial <init> : ()V
    //   18: aload_1
    //   19: aload #6
    //   21: ldc 'PRAGMA table_info('
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_2
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc ')'
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: aconst_null
    //   39: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull -> 268
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: ldc 'name'
    //   52: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   57: istore #7
    //   59: iconst_m1
    //   60: iload #7
    //   62: if_icmpne -> 115
    //   65: aload #5
    //   67: astore_2
    //   68: aload_1
    //   69: ifnull -> 81
    //   72: aload_1
    //   73: invokeinterface close : ()V
    //   78: aload #5
    //   80: astore_2
    //   81: aload_2
    //   82: areturn
    //   83: astore_1
    //   84: new java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial <init> : ()V
    //   91: ldc 'LocalSqLiteHelper.getColumnNames(SQLiteDatabase db, String tableName) finally catch '
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual toString : ()Ljava/lang/String;
    //   106: invokestatic a : (Ljava/lang/Object;)V
    //   109: aload #5
    //   111: astore_2
    //   112: goto -> 81
    //   115: aload_1
    //   116: astore_2
    //   117: aload_1
    //   118: invokeinterface getCount : ()I
    //   123: anewarray java/lang/String
    //   126: astore #4
    //   128: aload_1
    //   129: astore_2
    //   130: aload_1
    //   131: invokeinterface moveToFirst : ()Z
    //   136: pop
    //   137: iconst_0
    //   138: istore #8
    //   140: aload_1
    //   141: astore_2
    //   142: aload_1
    //   143: invokeinterface isAfterLast : ()Z
    //   148: ifne -> 268
    //   151: aload_1
    //   152: astore_2
    //   153: aload #4
    //   155: iload #8
    //   157: aload_1
    //   158: iload #7
    //   160: invokeinterface getString : (I)Ljava/lang/String;
    //   165: aastore
    //   166: iinc #8, 1
    //   169: aload_1
    //   170: astore_2
    //   171: aload_1
    //   172: invokeinterface moveToNext : ()Z
    //   177: pop
    //   178: goto -> 140
    //   181: astore #5
    //   183: aload_1
    //   184: astore_2
    //   185: new java/lang/StringBuilder
    //   188: astore_3
    //   189: aload_1
    //   190: astore_2
    //   191: aload_3
    //   192: invokespecial <init> : ()V
    //   195: aload_1
    //   196: astore_2
    //   197: aload_3
    //   198: ldc 'LocalSqLiteHelper.getColumnNames(SQLiteDatabase db, String tableName) catch '
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload #5
    //   205: invokevirtual toString : ()Ljava/lang/String;
    //   208: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual toString : ()Ljava/lang/String;
    //   214: invokestatic a : (Ljava/lang/Object;)V
    //   217: aload #4
    //   219: astore_2
    //   220: aload_1
    //   221: ifnull -> 81
    //   224: aload_1
    //   225: invokeinterface close : ()V
    //   230: aload #4
    //   232: astore_2
    //   233: goto -> 81
    //   236: astore_1
    //   237: new java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial <init> : ()V
    //   244: ldc 'LocalSqLiteHelper.getColumnNames(SQLiteDatabase db, String tableName) finally catch '
    //   246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual toString : ()Ljava/lang/String;
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual toString : ()Ljava/lang/String;
    //   259: invokestatic a : (Ljava/lang/Object;)V
    //   262: aload #4
    //   264: astore_2
    //   265: goto -> 81
    //   268: aload #4
    //   270: astore_2
    //   271: aload_1
    //   272: ifnull -> 81
    //   275: aload_1
    //   276: invokeinterface close : ()V
    //   281: aload #4
    //   283: astore_2
    //   284: goto -> 81
    //   287: astore_1
    //   288: new java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial <init> : ()V
    //   295: ldc 'LocalSqLiteHelper.getColumnNames(SQLiteDatabase db, String tableName) finally catch '
    //   297: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_1
    //   301: invokevirtual toString : ()Ljava/lang/String;
    //   304: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual toString : ()Ljava/lang/String;
    //   310: invokestatic a : (Ljava/lang/Object;)V
    //   313: aload #4
    //   315: astore_2
    //   316: goto -> 81
    //   319: astore_1
    //   320: aconst_null
    //   321: astore_2
    //   322: aload_2
    //   323: ifnull -> 332
    //   326: aload_2
    //   327: invokeinterface close : ()V
    //   332: aload_1
    //   333: athrow
    //   334: astore_2
    //   335: new java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial <init> : ()V
    //   342: ldc 'LocalSqLiteHelper.getColumnNames(SQLiteDatabase db, String tableName) finally catch '
    //   344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_2
    //   348: invokevirtual toString : ()Ljava/lang/String;
    //   351: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual toString : ()Ljava/lang/String;
    //   357: invokestatic a : (Ljava/lang/Object;)V
    //   360: goto -> 332
    //   363: astore_1
    //   364: goto -> 322
    //   367: astore #5
    //   369: aconst_null
    //   370: astore_1
    //   371: aload_3
    //   372: astore #4
    //   374: goto -> 183
    //   377: astore #5
    //   379: aload_3
    //   380: astore #4
    //   382: goto -> 183
    // Exception table:
    //   from	to	target	type
    //   8	43	367	java/lang/Exception
    //   8	43	319	finally
    //   49	59	377	java/lang/Exception
    //   49	59	363	finally
    //   72	78	83	java/lang/Exception
    //   117	128	377	java/lang/Exception
    //   117	128	363	finally
    //   130	137	181	java/lang/Exception
    //   130	137	363	finally
    //   142	151	181	java/lang/Exception
    //   142	151	363	finally
    //   153	166	181	java/lang/Exception
    //   153	166	363	finally
    //   171	178	181	java/lang/Exception
    //   171	178	363	finally
    //   185	189	363	finally
    //   191	195	363	finally
    //   197	217	363	finally
    //   224	230	236	java/lang/Exception
    //   275	281	287	java/lang/Exception
    //   326	332	334	java/lang/Exception
  }
  
  public v a() {
    return a("auto_login=?", new String[] { "1" });
  }
  
  public v a(String paramString) {
    return (paramString == null) ? null : a("login_name=?", new String[] { cv.c(paramString) });
  }
  
  public v a(String paramString, String[] paramArrayOfString) {
    v v;
    String str1 = null;
    String str2 = null;
    if (this.l == null)
      return (v)str2; 
    Cursor cursor = this.l.query("sdkuser", null, paramString, paramArrayOfString, null, null, "last_login_time desc ");
    paramString = str1;
    if (cursor.moveToFirst()) {
      paramString = str1;
      if (!cursor.isAfterLast())
        v = a(cursor); 
    } 
    cursor.close();
    return v;
  }
  
  public String a(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    String[] arrayOfString = b(paramSQLiteDatabase, paramString);
    StringBuilder stringBuilder = new StringBuilder();
    if (arrayOfString != null && arrayOfString.length > 0) {
      stringBuilder.append(arrayOfString[0]);
      for (byte b = 1; b < arrayOfString.length; b++)
        stringBuilder.append(",").append(arrayOfString[b]); 
    } 
    return stringBuilder.toString();
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3) {
    try {
      paramSQLiteDatabase.beginTransaction();
      StringBuilder stringBuilder3 = new StringBuilder();
      this();
      String str = stringBuilder3.append(paramString1).append("_temp").toString();
      StringBuilder stringBuilder4 = new StringBuilder();
      this();
      paramSQLiteDatabase.execSQL(stringBuilder4.append("ALTER TABLE ").append(paramString1).append(" RENAME TO ").append(str).toString(), new Object[0]);
      paramSQLiteDatabase.execSQL(paramString2, new Object[0]);
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      paramSQLiteDatabase.execSQL(stringBuilder2.append("INSERT INTO ").append(paramString1).append(" (").append(paramString3).append(")  SELECT ").append(paramString3).append(" FROM ").append(str).toString(), new Object[0]);
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      paramSQLiteDatabase.execSQL(stringBuilder1.append("DROP TABLE IF EXISTS ").append(str).toString(), new Object[0]);
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      bp.a(stringBuilder.append("LocalSqLiteHelper.upgradeTables(SQLiteDatabase db, String tableName, String createTableSql, String columns) catch ").append(exception.toString()).toString());
      return;
    } finally {
      paramSQLiteDatabase.endTransaction();
    } 
  }
  
  public boolean a(v paramv) {
    long l1;
    boolean bool = true;
    if (paramv == null || this.l == null)
      return false; 
    if (!TextUtils.isEmpty(paramv.b)) {
      contentValues = (ContentValues)a("login_name=?", new String[] { cv.c(paramv.b) });
    } else if (!TextUtils.isEmpty(paramv.o)) {
      contentValues = (ContentValues)a("login_id=?", new String[] { cv.c(paramv.o) });
    } else {
      contentValues = null;
    } 
    if (contentValues != null)
      paramv.p = ((v)contentValues).p + 1; 
    ContentValues contentValues = b(paramv);
    if (!TextUtils.isEmpty(paramv.b)) {
      l1 = this.l.update("sdkuser", contentValues, "login_name=?", new String[] { cv.c(paramv.b) });
    } else if (!TextUtils.isEmpty(paramv.o)) {
      long l = this.l.update("sdkuser", contentValues, "login_id=?", new String[] { cv.c(paramv.o) });
      l1 = l;
      if (l <= 0L) {
        this.l.delete("sdkuser", "login_name=?", new String[] { cv.c(paramv.b) });
        l1 = l;
      } 
    } else {
      l1 = 0L;
    } 
    long l2 = l1;
    if (l1 <= 0L)
      l2 = this.l.insert("sdkuser", null, contentValues); 
    if (l2 <= 0L)
      bool = false; 
    return bool;
  }
  
  public boolean a(String paramString, int paramInt) {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.l == null)
      return bool2; 
    if (this.l.delete("sdkuser", "login_name=?", new String[] { cv.c(paramString) }) <= 0)
      bool1 = false; 
    return bool1;
  }
  
  public v[] a(int paramInt) {
    String[] arrayOfString;
    if (paramInt != -1) {
      null = (Cursor)"login_type=?";
      arrayOfString = new String[1];
      arrayOfString[0] = paramInt + "";
    } else {
      arrayOfString = null;
      null = null;
    } 
    null = this.l.query("sdkuser", null, (String)null, arrayOfString, null, null, "last_login_time desc ");
    ArrayList<v> arrayList = new ArrayList();
    if (null.moveToFirst())
      while (!null.isAfterLast()) {
        arrayList.add(a(null));
        null.moveToNext();
      }  
    null.close();
    return (arrayList.size() > 0) ? arrayList.<v>toArray(new v[arrayList.size()]) : null;
  }
  
  public List b() {
    ArrayList<v> arrayList1 = null;
    Cursor cursor = this.l.query("sdkuser", null, null, null, null, null, "last_login_time desc ");
    ArrayList<v> arrayList2 = new ArrayList();
    if (cursor.moveToFirst())
      while (!cursor.isAfterLast()) {
        arrayList2.add(a(cursor));
        cursor.moveToNext();
      }  
    cursor.close();
    if (arrayList2.size() > 0)
      arrayList1 = arrayList2; 
    return arrayList1;
  }
  
  public boolean b(String paramString) {
    return a(paramString, 0);
  }
  
  public v[] c() {
    return a(-1);
  }
  
  public boolean d() {
    boolean bool = false;
    if (this.l != null && this.l.delete("sdkuser", null, null) > 0)
      bool = true; 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */