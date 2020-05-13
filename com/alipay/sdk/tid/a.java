package com.alipay.sdk.tid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.alipay.sdk.encrypt.b;
import java.lang.ref.WeakReference;
import java.util.List;

public final class a extends SQLiteOpenHelper {
  private static final String a = "msp.db";
  
  private static final int b = 1;
  
  private WeakReference<Context> c;
  
  public a(Context paramContext) {
    super(paramContext, "msp.db", null, 1);
    this.c = new WeakReference<Context>(paramContext);
  }
  
  private List<String> a() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore_3
    //   15: aload_3
    //   16: ldc 'select tid from tb_tid'
    //   18: aconst_null
    //   19: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore #4
    //   24: aload #4
    //   26: astore_1
    //   27: aload_1
    //   28: invokeinterface moveToNext : ()Z
    //   33: ifeq -> 111
    //   36: aload_1
    //   37: iconst_0
    //   38: invokeinterface getString : (I)Ljava/lang/String;
    //   43: astore #4
    //   45: aload #4
    //   47: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   50: ifne -> 27
    //   53: aload_2
    //   54: iconst_2
    //   55: aload #4
    //   57: aload_0
    //   58: getfield c : Ljava/lang/ref/WeakReference;
    //   61: invokevirtual get : ()Ljava/lang/Object;
    //   64: checkcast android/content/Context
    //   67: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   70: invokestatic a : (ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: invokeinterface add : (Ljava/lang/Object;)Z
    //   78: pop
    //   79: goto -> 27
    //   82: astore #4
    //   84: aload_1
    //   85: ifnull -> 94
    //   88: aload_1
    //   89: invokeinterface close : ()V
    //   94: aload_3
    //   95: ifnull -> 109
    //   98: aload_3
    //   99: invokevirtual isOpen : ()Z
    //   102: ifeq -> 109
    //   105: aload_3
    //   106: invokevirtual close : ()V
    //   109: aload_2
    //   110: areturn
    //   111: aload_1
    //   112: ifnull -> 121
    //   115: aload_1
    //   116: invokeinterface close : ()V
    //   121: aload_3
    //   122: ifnull -> 109
    //   125: aload_3
    //   126: invokevirtual isOpen : ()Z
    //   129: ifeq -> 109
    //   132: aload_3
    //   133: invokevirtual close : ()V
    //   136: goto -> 109
    //   139: astore #4
    //   141: aconst_null
    //   142: astore_3
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull -> 155
    //   149: aload_1
    //   150: invokeinterface close : ()V
    //   155: aload_3
    //   156: ifnull -> 170
    //   159: aload_3
    //   160: invokevirtual isOpen : ()Z
    //   163: ifeq -> 170
    //   166: aload_3
    //   167: invokevirtual close : ()V
    //   170: aload #4
    //   172: athrow
    //   173: astore #4
    //   175: aconst_null
    //   176: astore_1
    //   177: goto -> 145
    //   180: astore #4
    //   182: goto -> 145
    //   185: astore_3
    //   186: aconst_null
    //   187: astore_3
    //   188: goto -> 84
    //   191: astore #4
    //   193: goto -> 84
    // Exception table:
    //   from	to	target	type
    //   10	15	185	java/lang/Exception
    //   10	15	139	finally
    //   15	24	191	java/lang/Exception
    //   15	24	173	finally
    //   27	79	82	java/lang/Exception
    //   27	79	180	finally
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase) {
    byte b1 = 0;
    Cursor cursor = paramSQLiteDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
    if (cursor.getCount() <= 14) {
      cursor.close();
      return;
    } 
    int i = cursor.getCount() - 14;
    String[] arrayOfString = new String[i];
    if (cursor.moveToFirst()) {
      int j = 0;
      while (true) {
        arrayOfString[j] = cursor.getString(0);
        int k = j + 1;
        if (cursor.moveToNext()) {
          j = k;
          if (i <= k)
            break; 
          continue;
        } 
        break;
      } 
    } 
    cursor.close();
    byte b2 = b1;
    while (true) {
      if (b2 < i) {
        if (!TextUtils.isEmpty(arrayOfString[b2]))
          a(paramSQLiteDatabase, arrayOfString[b2]); 
        b2++;
        continue;
      } 
      return;
    } 
  }
  
  static void a(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    try {
      paramSQLiteDatabase.delete("tb_tid", "name=?", new String[] { paramString });
    } catch (Exception exception) {}
  }
  
  private static boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2) {
    boolean bool = true;
    Cursor cursor1 = null;
    Cursor cursor2 = null;
    try {
      boolean bool1;
      Cursor cursor = paramSQLiteDatabase.rawQuery("select count(*) from tb_tid where name=?", new String[] { c(paramString1, paramString2) });
      cursor2 = cursor;
      cursor1 = cursor;
      if (cursor.moveToFirst()) {
        cursor2 = cursor;
        cursor1 = cursor;
        bool1 = cursor.getInt(0);
      } else {
        bool1 = false;
      } 
      if (cursor != null)
        cursor.close(); 
      return bool;
    } catch (Exception exception) {
      boolean bool1;
      if (cursor2 != null) {
        cursor2.close();
        bool1 = false;
      } else {
        bool1 = false;
      } 
      return bool;
    } finally {
      if (cursor1 != null)
        cursor1.close(); 
    } 
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4) {
    byte b1 = 0;
    paramString3 = b.a(1, paramString3, com.alipay.sdk.util.a.c(this.c.get()));
    paramSQLiteDatabase.execSQL("insert into tb_tid (name, tid, key_tid, dt) values (?, ?, ?, datetime('now', 'localtime'))", new Object[] { c(paramString1, paramString2), paramString3, paramString4 });
    Cursor cursor = paramSQLiteDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
    if (cursor.getCount() <= 14) {
      cursor.close();
      return;
    } 
    int i = cursor.getCount() - 14;
    String[] arrayOfString = new String[i];
    if (cursor.moveToFirst()) {
      int j = 0;
      while (true) {
        arrayOfString[j] = cursor.getString(0);
        int k = j + 1;
        if (cursor.moveToNext()) {
          j = k;
          if (i <= k)
            break; 
          continue;
        } 
        break;
      } 
    } 
    cursor.close();
    byte b2 = b1;
    while (true) {
      if (b2 < i) {
        if (!TextUtils.isEmpty(arrayOfString[b2]))
          a(paramSQLiteDatabase, arrayOfString[b2]); 
        b2++;
        continue;
      } 
      return;
    } 
  }
  
  static String c(String paramString1, String paramString2) {
    return paramString1 + paramString2;
  }
  
  private void d(String paramString1, String paramString2) {
    SQLiteDatabase sQLiteDatabase1 = null;
    SQLiteDatabase sQLiteDatabase2 = null;
    try {
      SQLiteDatabase sQLiteDatabase = getWritableDatabase();
      sQLiteDatabase2 = sQLiteDatabase;
      sQLiteDatabase1 = sQLiteDatabase;
      a(sQLiteDatabase, paramString1, paramString2, "", "");
      sQLiteDatabase2 = sQLiteDatabase;
      sQLiteDatabase1 = sQLiteDatabase;
      a(sQLiteDatabase, c(paramString1, paramString2));
      return;
    } catch (Exception exception) {
      return;
    } finally {
      if (sQLiteDatabase1 != null && sQLiteDatabase1.isOpen())
        sQLiteDatabase1.close(); 
    } 
  }
  
  private long e(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aconst_null
    //   6: astore #5
    //   8: aconst_null
    //   9: astore #6
    //   11: lconst_0
    //   12: lstore #7
    //   14: aload_0
    //   15: invokevirtual getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore #9
    //   20: aload #4
    //   22: astore_3
    //   23: aload #5
    //   25: astore #6
    //   27: aload #9
    //   29: ldc 'select dt from tb_tid where name=?'
    //   31: iconst_1
    //   32: anewarray java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_1
    //   38: aload_2
    //   39: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: aastore
    //   43: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: lload #7
    //   49: lstore #10
    //   51: aload_1
    //   52: astore_3
    //   53: aload_1
    //   54: astore #6
    //   56: aload_1
    //   57: invokeinterface moveToFirst : ()Z
    //   62: ifeq -> 109
    //   65: aload_1
    //   66: astore_3
    //   67: aload_1
    //   68: astore #6
    //   70: new java/text/SimpleDateFormat
    //   73: astore_2
    //   74: aload_1
    //   75: astore_3
    //   76: aload_1
    //   77: astore #6
    //   79: aload_2
    //   80: ldc 'yyyy-MM-dd HH:mm:ss'
    //   82: invokestatic getDefault : ()Ljava/util/Locale;
    //   85: invokespecial <init> : (Ljava/lang/String;Ljava/util/Locale;)V
    //   88: aload_1
    //   89: astore_3
    //   90: aload_1
    //   91: astore #6
    //   93: aload_2
    //   94: aload_1
    //   95: iconst_0
    //   96: invokeinterface getString : (I)Ljava/lang/String;
    //   101: invokevirtual parse : (Ljava/lang/String;)Ljava/util/Date;
    //   104: invokevirtual getTime : ()J
    //   107: lstore #10
    //   109: aload_1
    //   110: ifnull -> 119
    //   113: aload_1
    //   114: invokeinterface close : ()V
    //   119: lload #10
    //   121: lstore #12
    //   123: aload #9
    //   125: ifnull -> 149
    //   128: lload #10
    //   130: lstore #12
    //   132: aload #9
    //   134: invokevirtual isOpen : ()Z
    //   137: ifeq -> 149
    //   140: aload #9
    //   142: invokevirtual close : ()V
    //   145: lload #10
    //   147: lstore #12
    //   149: lload #12
    //   151: lreturn
    //   152: astore_1
    //   153: aconst_null
    //   154: astore #9
    //   156: aload #6
    //   158: ifnull -> 168
    //   161: aload #6
    //   163: invokeinterface close : ()V
    //   168: lload #7
    //   170: lstore #12
    //   172: aload #9
    //   174: ifnull -> 149
    //   177: lload #7
    //   179: lstore #12
    //   181: aload #9
    //   183: invokevirtual isOpen : ()Z
    //   186: ifeq -> 149
    //   189: aload #9
    //   191: invokevirtual close : ()V
    //   194: lload #7
    //   196: lstore #12
    //   198: goto -> 149
    //   201: astore_1
    //   202: aconst_null
    //   203: astore #9
    //   205: aload_3
    //   206: ifnull -> 215
    //   209: aload_3
    //   210: invokeinterface close : ()V
    //   215: aload #9
    //   217: ifnull -> 233
    //   220: aload #9
    //   222: invokevirtual isOpen : ()Z
    //   225: ifeq -> 233
    //   228: aload #9
    //   230: invokevirtual close : ()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: goto -> 205
    //   239: astore_1
    //   240: goto -> 156
    // Exception table:
    //   from	to	target	type
    //   14	20	152	java/lang/Exception
    //   14	20	201	finally
    //   27	47	239	java/lang/Exception
    //   27	47	235	finally
    //   56	65	239	java/lang/Exception
    //   56	65	235	finally
    //   70	74	239	java/lang/Exception
    //   70	74	235	finally
    //   79	88	239	java/lang/Exception
    //   79	88	235	finally
    //   93	109	239	java/lang/Exception
    //   93	109	235	finally
  }
  
  public final String a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore #4
    //   8: aload #4
    //   10: ldc 'select tid from tb_tid where name=?'
    //   12: iconst_1
    //   13: anewarray java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aload_2
    //   20: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   23: aastore
    //   24: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore_2
    //   28: aload_3
    //   29: astore_1
    //   30: aload_2
    //   31: invokeinterface moveToFirst : ()Z
    //   36: ifeq -> 47
    //   39: aload_2
    //   40: iconst_0
    //   41: invokeinterface getString : (I)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_2
    //   48: ifnull -> 57
    //   51: aload_2
    //   52: invokeinterface close : ()V
    //   57: aload #4
    //   59: ifnull -> 205
    //   62: aload #4
    //   64: invokevirtual isOpen : ()Z
    //   67: ifeq -> 205
    //   70: aload #4
    //   72: invokevirtual close : ()V
    //   75: aload_1
    //   76: astore_2
    //   77: aload_1
    //   78: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   81: ifne -> 103
    //   84: iconst_2
    //   85: aload_1
    //   86: aload_0
    //   87: getfield c : Ljava/lang/ref/WeakReference;
    //   90: invokevirtual get : ()Ljava/lang/Object;
    //   93: checkcast android/content/Context
    //   96: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   99: invokestatic a : (ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   102: astore_2
    //   103: aload_2
    //   104: areturn
    //   105: astore_1
    //   106: aconst_null
    //   107: astore_2
    //   108: aconst_null
    //   109: astore #4
    //   111: aload_2
    //   112: ifnull -> 121
    //   115: aload_2
    //   116: invokeinterface close : ()V
    //   121: aload #4
    //   123: ifnull -> 200
    //   126: aload #4
    //   128: invokevirtual isOpen : ()Z
    //   131: ifeq -> 200
    //   134: aload #4
    //   136: invokevirtual close : ()V
    //   139: aconst_null
    //   140: astore_1
    //   141: goto -> 75
    //   144: astore_1
    //   145: aconst_null
    //   146: astore #4
    //   148: aconst_null
    //   149: astore_2
    //   150: aload_2
    //   151: ifnull -> 160
    //   154: aload_2
    //   155: invokeinterface close : ()V
    //   160: aload #4
    //   162: ifnull -> 178
    //   165: aload #4
    //   167: invokevirtual isOpen : ()Z
    //   170: ifeq -> 178
    //   173: aload #4
    //   175: invokevirtual close : ()V
    //   178: aload_1
    //   179: athrow
    //   180: astore_1
    //   181: aconst_null
    //   182: astore_2
    //   183: goto -> 150
    //   186: astore_1
    //   187: goto -> 150
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_2
    //   193: goto -> 111
    //   196: astore_1
    //   197: goto -> 111
    //   200: aconst_null
    //   201: astore_1
    //   202: goto -> 75
    //   205: goto -> 75
    // Exception table:
    //   from	to	target	type
    //   2	8	105	java/lang/Exception
    //   2	8	144	finally
    //   8	28	190	java/lang/Exception
    //   8	28	180	finally
    //   30	47	196	java/lang/Exception
    //   30	47	186	finally
  }
  
  final void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4) {
    paramSQLiteDatabase.execSQL("update tb_tid set tid=?, key_tid=?, dt=datetime('now', 'localtime') where name=?", new Object[] { b.a(1, paramString3, com.alipay.sdk.util.a.c(this.c.get())), paramString4, c(paramString1, paramString2) });
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore #6
    //   6: aload_0
    //   7: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore #7
    //   12: aload #7
    //   14: astore #6
    //   16: aload #7
    //   18: astore #5
    //   20: aload #7
    //   22: aload_1
    //   23: aload_2
    //   24: invokestatic a : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z
    //   27: ifeq -> 68
    //   30: aload #7
    //   32: astore #6
    //   34: aload #7
    //   36: astore #5
    //   38: aload_0
    //   39: aload #7
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: aload #4
    //   46: invokevirtual a : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload #7
    //   51: ifnull -> 67
    //   54: aload #7
    //   56: invokevirtual isOpen : ()Z
    //   59: ifeq -> 67
    //   62: aload #7
    //   64: invokevirtual close : ()V
    //   67: return
    //   68: aload #7
    //   70: astore #6
    //   72: aload #7
    //   74: astore #5
    //   76: iconst_1
    //   77: aload_3
    //   78: aload_0
    //   79: getfield c : Ljava/lang/ref/WeakReference;
    //   82: invokevirtual get : ()Ljava/lang/Object;
    //   85: checkcast android/content/Context
    //   88: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   91: invokestatic a : (ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: astore_3
    //   95: aload #7
    //   97: astore #6
    //   99: aload #7
    //   101: astore #5
    //   103: aload #7
    //   105: ldc 'insert into tb_tid (name, tid, key_tid, dt) values (?, ?, ?, datetime('now', 'localtime'))'
    //   107: iconst_3
    //   108: anewarray java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_1
    //   114: aload_2
    //   115: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: aload_3
    //   122: aastore
    //   123: dup
    //   124: iconst_2
    //   125: aload #4
    //   127: aastore
    //   128: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload #7
    //   133: astore #6
    //   135: aload #7
    //   137: astore #5
    //   139: aload #7
    //   141: ldc 'select name from tb_tid where tid!='' order by dt asc'
    //   143: aconst_null
    //   144: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   147: astore_1
    //   148: aload #7
    //   150: astore #6
    //   152: aload #7
    //   154: astore #5
    //   156: aload_1
    //   157: invokeinterface getCount : ()I
    //   162: bipush #14
    //   164: if_icmpgt -> 206
    //   167: aload #7
    //   169: astore #6
    //   171: aload #7
    //   173: astore #5
    //   175: aload_1
    //   176: invokeinterface close : ()V
    //   181: goto -> 49
    //   184: astore_1
    //   185: aload #6
    //   187: ifnull -> 67
    //   190: aload #6
    //   192: invokevirtual isOpen : ()Z
    //   195: ifeq -> 67
    //   198: aload #6
    //   200: invokevirtual close : ()V
    //   203: goto -> 67
    //   206: aload #7
    //   208: astore #6
    //   210: aload #7
    //   212: astore #5
    //   214: aload_1
    //   215: invokeinterface getCount : ()I
    //   220: bipush #14
    //   222: isub
    //   223: istore #8
    //   225: aload #7
    //   227: astore #6
    //   229: aload #7
    //   231: astore #5
    //   233: iload #8
    //   235: anewarray java/lang/String
    //   238: astore_2
    //   239: aload #7
    //   241: astore #6
    //   243: aload #7
    //   245: astore #5
    //   247: aload_1
    //   248: invokeinterface moveToFirst : ()Z
    //   253: ifeq -> 312
    //   256: iconst_0
    //   257: istore #9
    //   259: aload #7
    //   261: astore #6
    //   263: aload #7
    //   265: astore #5
    //   267: aload_2
    //   268: iload #9
    //   270: aload_1
    //   271: iconst_0
    //   272: invokeinterface getString : (I)Ljava/lang/String;
    //   277: aastore
    //   278: iload #9
    //   280: iconst_1
    //   281: iadd
    //   282: istore #10
    //   284: aload #7
    //   286: astore #6
    //   288: aload #7
    //   290: astore #5
    //   292: aload_1
    //   293: invokeinterface moveToNext : ()Z
    //   298: ifeq -> 312
    //   301: iload #10
    //   303: istore #9
    //   305: iload #8
    //   307: iload #10
    //   309: if_icmpgt -> 259
    //   312: aload #7
    //   314: astore #6
    //   316: aload #7
    //   318: astore #5
    //   320: aload_1
    //   321: invokeinterface close : ()V
    //   326: iconst_0
    //   327: istore #9
    //   329: iload #9
    //   331: iload #8
    //   333: if_icmpge -> 49
    //   336: aload #7
    //   338: astore #6
    //   340: aload #7
    //   342: astore #5
    //   344: aload_2
    //   345: iload #9
    //   347: aaload
    //   348: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   351: ifne -> 371
    //   354: aload #7
    //   356: astore #6
    //   358: aload #7
    //   360: astore #5
    //   362: aload #7
    //   364: aload_2
    //   365: iload #9
    //   367: aaload
    //   368: invokestatic a : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   371: iinc #9, 1
    //   374: goto -> 329
    //   377: astore_1
    //   378: aload #5
    //   380: ifnull -> 396
    //   383: aload #5
    //   385: invokevirtual isOpen : ()Z
    //   388: ifeq -> 396
    //   391: aload #5
    //   393: invokevirtual close : ()V
    //   396: aload_1
    //   397: athrow
    // Exception table:
    //   from	to	target	type
    //   6	12	184	java/lang/Exception
    //   6	12	377	finally
    //   20	30	184	java/lang/Exception
    //   20	30	377	finally
    //   38	49	184	java/lang/Exception
    //   38	49	377	finally
    //   76	95	184	java/lang/Exception
    //   76	95	377	finally
    //   103	131	184	java/lang/Exception
    //   103	131	377	finally
    //   139	148	184	java/lang/Exception
    //   139	148	377	finally
    //   156	167	184	java/lang/Exception
    //   156	167	377	finally
    //   175	181	184	java/lang/Exception
    //   175	181	377	finally
    //   214	225	184	java/lang/Exception
    //   214	225	377	finally
    //   233	239	184	java/lang/Exception
    //   233	239	377	finally
    //   247	256	184	java/lang/Exception
    //   247	256	377	finally
    //   267	278	184	java/lang/Exception
    //   267	278	377	finally
    //   292	301	184	java/lang/Exception
    //   292	301	377	finally
    //   320	326	184	java/lang/Exception
    //   320	326	377	finally
    //   344	354	184	java/lang/Exception
    //   344	354	377	finally
    //   362	371	184	java/lang/Exception
    //   362	371	377	finally
  }
  
  public final String b(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aload_0
    //   6: invokevirtual getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore #5
    //   11: aload #5
    //   13: ldc 'select key_tid from tb_tid where name=?'
    //   15: iconst_1
    //   16: anewarray java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: aload_1
    //   22: aload_2
    //   23: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   26: aastore
    //   27: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_1
    //   31: aload #4
    //   33: astore_2
    //   34: aload_1
    //   35: invokeinterface moveToFirst : ()Z
    //   40: ifeq -> 51
    //   43: aload_1
    //   44: iconst_0
    //   45: invokeinterface getString : (I)Ljava/lang/String;
    //   50: astore_2
    //   51: aload_1
    //   52: ifnull -> 61
    //   55: aload_1
    //   56: invokeinterface close : ()V
    //   61: aload_2
    //   62: astore_1
    //   63: aload #5
    //   65: ifnull -> 85
    //   68: aload_2
    //   69: astore_1
    //   70: aload #5
    //   72: invokevirtual isOpen : ()Z
    //   75: ifeq -> 85
    //   78: aload #5
    //   80: invokevirtual close : ()V
    //   83: aload_2
    //   84: astore_1
    //   85: aload_1
    //   86: areturn
    //   87: astore_1
    //   88: aconst_null
    //   89: astore_1
    //   90: aconst_null
    //   91: astore #5
    //   93: aload_1
    //   94: ifnull -> 103
    //   97: aload_1
    //   98: invokeinterface close : ()V
    //   103: aload_3
    //   104: astore_1
    //   105: aload #5
    //   107: ifnull -> 85
    //   110: aload_3
    //   111: astore_1
    //   112: aload #5
    //   114: invokevirtual isOpen : ()Z
    //   117: ifeq -> 85
    //   120: aload #5
    //   122: invokevirtual close : ()V
    //   125: aload_3
    //   126: astore_1
    //   127: goto -> 85
    //   130: astore_2
    //   131: aconst_null
    //   132: astore #5
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull -> 146
    //   140: aload_1
    //   141: invokeinterface close : ()V
    //   146: aload #5
    //   148: ifnull -> 164
    //   151: aload #5
    //   153: invokevirtual isOpen : ()Z
    //   156: ifeq -> 164
    //   159: aload #5
    //   161: invokevirtual close : ()V
    //   164: aload_2
    //   165: athrow
    //   166: astore_2
    //   167: aconst_null
    //   168: astore_1
    //   169: goto -> 136
    //   172: astore_2
    //   173: goto -> 136
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_1
    //   179: goto -> 93
    //   182: astore_2
    //   183: goto -> 93
    // Exception table:
    //   from	to	target	type
    //   5	11	87	java/lang/Exception
    //   5	11	130	finally
    //   11	31	176	java/lang/Exception
    //   11	31	166	finally
    //   34	51	182	java/lang/Exception
    //   34	51	172	finally
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    paramSQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    paramSQLiteDatabase.execSQL("drop table if exists tb_tid");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\tid\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */