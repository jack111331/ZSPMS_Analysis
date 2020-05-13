package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Map;

public final class p {
  private static p a;
  
  private static q b;
  
  private static boolean c;
  
  private p(Context paramContext, List<com.tencent.bugly.a> paramList) {
    b = new q(paramContext, paramList);
  }
  
  private int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo) {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    boolean bool = false;
    int i = 0;
    int j = 0;
    try {
      SQLiteDatabase sQLiteDatabase = b.getWritableDatabase();
      if (sQLiteDatabase != null)
        j = sQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString); 
      i = j;
      if (paramo != null)
        i = j; 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      if (paramo != null) {
        j = bool;
      } else {
        /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
        return i;
      } 
      i = j;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    return i;
  }
  
  private long a(String paramString, ContentValues paramContentValues, o paramo) {
    long l2;
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    long l1 = 0L;
    try {
      SQLiteDatabase sQLiteDatabase = b.getWritableDatabase();
      long l = l1;
      if (sQLiteDatabase != null) {
        l = l1;
        if (paramContentValues != null) {
          l = sQLiteDatabase.replace(paramString, "_id", paramContentValues);
          if (l >= 0L) {
            x.c("[Database] insert %s success.", new Object[] { paramString });
          } else {
            x.d("[Database] replace %s error.", new Object[] { paramString });
          } 
        } 
      } 
      l2 = l;
      if (paramo != null)
        l2 = l; 
    } catch (Throwable throwable) {
      long l;
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      l2 = l1;
      if (paramo != null) {
        l = l1;
      } else {
        /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
        return l2;
      } 
      l2 = l;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    return l2;
  }
  
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, o paramo) {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    o o1 = null;
    try {
      SQLiteDatabase sQLiteDatabase = b.getWritableDatabase();
      paramo = o1;
      if (sQLiteDatabase != null)
        Cursor cursor = sQLiteDatabase.query(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6); 
    } catch (Throwable throwable) {
      paramo = o1;
      if (!x.a(throwable)) {
        throwable.printStackTrace();
        paramo = o1;
      } 
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    return (Cursor)paramo;
  }
  
  public static p a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/p
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/p.a : Lcom/tencent/bugly/proguard/p;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/proguard/p
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/proguard/p
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static p a(Context paramContext, List<com.tencent.bugly.a> paramList) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/p
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/p.a : Lcom/tencent/bugly/proguard/p;
    //   6: ifnonnull -> 23
    //   9: new com/tencent/bugly/proguard/p
    //   12: astore_2
    //   13: aload_2
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial <init> : (Landroid/content/Context;Ljava/util/List;)V
    //   19: aload_2
    //   20: putstatic com/tencent/bugly/proguard/p.a : Lcom/tencent/bugly/proguard/p;
    //   23: getstatic com/tencent/bugly/proguard/p.a : Lcom/tencent/bugly/proguard/p;
    //   26: astore_0
    //   27: ldc com/tencent/bugly/proguard/p
    //   29: monitorexit
    //   30: aload_0
    //   31: areturn
    //   32: astore_0
    //   33: ldc com/tencent/bugly/proguard/p
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	32	finally
    //   23	27	32	finally
  }
  
  private static r a(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      r r = new r();
      this();
      r.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      r.b = paramCursor.getInt(paramCursor.getColumnIndex("_tp"));
      r.c = paramCursor.getString(paramCursor.getColumnIndex("_pc"));
      r.d = paramCursor.getString(paramCursor.getColumnIndex("_th"));
      r.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      r.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      return r;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  private Map<String, byte[]> a(int paramInt, o paramo) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: iload_1
    //   6: invokespecial c : (I)Ljava/util/List;
    //   9: astore #4
    //   11: aload #4
    //   13: ifnull -> 114
    //   16: new java/util/HashMap
    //   19: astore_2
    //   20: aload_2
    //   21: invokespecial <init> : ()V
    //   24: aload #4
    //   26: invokeinterface iterator : ()Ljava/util/Iterator;
    //   31: astore #4
    //   33: aload #4
    //   35: invokeinterface hasNext : ()Z
    //   40: ifeq -> 81
    //   43: aload #4
    //   45: invokeinterface next : ()Ljava/lang/Object;
    //   50: checkcast com/tencent/bugly/proguard/r
    //   53: astore_3
    //   54: aload_3
    //   55: getfield g : [B
    //   58: astore #5
    //   60: aload #5
    //   62: ifnull -> 33
    //   65: aload_2
    //   66: aload_3
    //   67: getfield f : Ljava/lang/String;
    //   70: aload #5
    //   72: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: goto -> 33
    //   81: goto -> 114
    //   84: astore #4
    //   86: aload_2
    //   87: astore_3
    //   88: goto -> 97
    //   91: astore_2
    //   92: goto -> 116
    //   95: astore #4
    //   97: aload_3
    //   98: astore_2
    //   99: aload #4
    //   101: invokestatic a : (Ljava/lang/Throwable;)Z
    //   104: ifne -> 114
    //   107: aload #4
    //   109: invokevirtual printStackTrace : ()V
    //   112: aload_3
    //   113: astore_2
    //   114: aload_2
    //   115: areturn
    //   116: aload_2
    //   117: athrow
    // Exception table:
    //   from	to	target	type
    //   4	11	95	java/lang/Throwable
    //   4	11	91	finally
    //   16	24	95	java/lang/Throwable
    //   16	24	91	finally
    //   24	33	84	java/lang/Throwable
    //   24	33	91	finally
    //   33	60	84	java/lang/Throwable
    //   33	60	91	finally
    //   65	78	84	java/lang/Throwable
    //   65	78	91	finally
    //   99	112	91	finally
  }
  
  private boolean a(int paramInt, String paramString, o paramo) {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    try {
      SQLiteDatabase sQLiteDatabase = b.getWritableDatabase();
      boolean bool = bool3;
      if (sQLiteDatabase != null) {
        String str;
        if (z.a(paramString)) {
          StringBuilder stringBuilder = new StringBuilder();
          this("_id = ");
          stringBuilder.append(paramInt);
          str = stringBuilder.toString();
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          this("_id = ");
          stringBuilder.append(paramInt);
          stringBuilder.append(" and _tp");
          stringBuilder.append(" = \"");
          stringBuilder.append(str);
          stringBuilder.append("\"");
          str = stringBuilder.toString();
        } 
        paramInt = sQLiteDatabase.delete("t_pf", str, null);
        x.c("[Database] deleted %s data %d", new Object[] { "t_pf", Integer.valueOf(paramInt) });
        bool = bool3;
        if (paramInt > 0)
          bool = true; 
      } 
      bool3 = bool;
      if (paramo != null)
        bool3 = bool; 
    } catch (Throwable throwable) {
      boolean bool;
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      bool3 = bool2;
      if (paramo != null) {
        bool = bool1;
      } else {
        /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
        return bool3;
      } 
      bool3 = bool;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/p}} */
    return bool3;
  }
  
  private boolean a(int paramInt, String paramString, byte[] paramArrayOfbyte, o paramo) {
    boolean bool;
    try {
      r r = new r();
      this();
      r.a = paramInt;
      r.f = paramString;
      r.e = System.currentTimeMillis();
      r.g = paramArrayOfbyte;
      boolean bool1 = b(r);
      bool = bool1;
      if (paramo != null)
        bool = bool1; 
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      if (paramo != null);
      bool = false;
    } finally {}
    return bool;
  }
  
  private static r b(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      r r = new r();
      this();
      r.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      r.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      r.f = paramCursor.getString(paramCursor.getColumnIndex("_tp"));
      r.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      return r;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  private boolean b(r paramr) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   13: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull -> 77
    //   21: aload_1
    //   22: invokestatic d : (Lcom/tencent/bugly/proguard/r;)Landroid/content/ContentValues;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull -> 77
    //   30: aload_2
    //   31: ldc 't_pf'
    //   33: ldc '_id'
    //   35: aload_3
    //   36: invokevirtual replace : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   39: lstore #4
    //   41: lload #4
    //   43: lconst_0
    //   44: lcmp
    //   45: iflt -> 73
    //   48: ldc '[Database] insert %s success.'
    //   50: iconst_1
    //   51: anewarray java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: ldc 't_pf'
    //   58: aastore
    //   59: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   62: pop
    //   63: aload_1
    //   64: lload #4
    //   66: putfield a : J
    //   69: aload_0
    //   70: monitorexit
    //   71: iconst_1
    //   72: ireturn
    //   73: aload_0
    //   74: monitorexit
    //   75: iconst_0
    //   76: ireturn
    //   77: aload_0
    //   78: monitorexit
    //   79: iconst_0
    //   80: ireturn
    //   81: astore_1
    //   82: goto -> 101
    //   85: astore_1
    //   86: aload_1
    //   87: invokestatic a : (Ljava/lang/Throwable;)Z
    //   90: ifne -> 97
    //   93: aload_1
    //   94: invokevirtual printStackTrace : ()V
    //   97: aload_0
    //   98: monitorexit
    //   99: iconst_0
    //   100: ireturn
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Exception table:
    //   from	to	target	type
    //   10	17	85	java/lang/Throwable
    //   10	17	81	finally
    //   21	26	85	java/lang/Throwable
    //   21	26	81	finally
    //   30	41	85	java/lang/Throwable
    //   30	41	81	finally
    //   48	69	85	java/lang/Throwable
    //   48	69	81	finally
    //   86	97	81	finally
    //   101	103	103	finally
  }
  
  private static ContentValues c(r paramr) {
    if (paramr == null)
      return null; 
    try {
      ContentValues contentValues = new ContentValues();
      this();
      if (paramr.a > 0L)
        contentValues.put("_id", Long.valueOf(paramr.a)); 
      contentValues.put("_tp", Integer.valueOf(paramr.b));
      contentValues.put("_pc", paramr.c);
      contentValues.put("_th", paramr.d);
      contentValues.put("_tm", Long.valueOf(paramr.e));
      if (paramr.g != null)
        contentValues.put("_dt", paramr.g); 
      return contentValues;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  private List<r> c(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull -> 368
    //   13: new java/lang/StringBuilder
    //   16: astore_3
    //   17: aload_3
    //   18: ldc '_id = '
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: aload_3
    //   24: iload_1
    //   25: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual toString : ()Ljava/lang/String;
    //   33: astore #4
    //   35: aload_2
    //   36: ldc 't_pf'
    //   38: aconst_null
    //   39: aload #4
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore #5
    //   50: aload #5
    //   52: ifnonnull -> 71
    //   55: aload #5
    //   57: ifnull -> 67
    //   60: aload #5
    //   62: invokeinterface close : ()V
    //   67: aload_0
    //   68: monitorexit
    //   69: aconst_null
    //   70: areturn
    //   71: aload #5
    //   73: astore_3
    //   74: new java/lang/StringBuilder
    //   77: astore #6
    //   79: aload #5
    //   81: astore_3
    //   82: aload #6
    //   84: invokespecial <init> : ()V
    //   87: aload #5
    //   89: astore_3
    //   90: new java/util/ArrayList
    //   93: astore #7
    //   95: aload #5
    //   97: astore_3
    //   98: aload #7
    //   100: invokespecial <init> : ()V
    //   103: aload #5
    //   105: astore_3
    //   106: aload #5
    //   108: invokeinterface moveToNext : ()Z
    //   113: ifeq -> 224
    //   116: aload #5
    //   118: astore_3
    //   119: aload #5
    //   121: invokestatic b : (Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/r;
    //   124: astore #8
    //   126: aload #8
    //   128: ifnull -> 147
    //   131: aload #5
    //   133: astore_3
    //   134: aload #7
    //   136: aload #8
    //   138: invokeinterface add : (Ljava/lang/Object;)Z
    //   143: pop
    //   144: goto -> 103
    //   147: aload #5
    //   149: astore_3
    //   150: aload #5
    //   152: aload #5
    //   154: ldc '_tp'
    //   156: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   161: invokeinterface getString : (I)Ljava/lang/String;
    //   166: astore #8
    //   168: aload #5
    //   170: astore_3
    //   171: aload #6
    //   173: ldc_w ' or _tp'
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload #5
    //   182: astore_3
    //   183: aload #6
    //   185: ldc_w ' = '
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload #5
    //   194: astore_3
    //   195: aload #6
    //   197: aload #8
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: goto -> 103
    //   206: astore_3
    //   207: aload #5
    //   209: astore_3
    //   210: ldc_w '[Database] unknown id.'
    //   213: iconst_0
    //   214: anewarray java/lang/Object
    //   217: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   220: pop
    //   221: goto -> 103
    //   224: aload #5
    //   226: astore_3
    //   227: aload #6
    //   229: invokevirtual length : ()I
    //   232: ifle -> 307
    //   235: aload #5
    //   237: astore_3
    //   238: aload #6
    //   240: ldc_w ' and _id'
    //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload #5
    //   249: astore_3
    //   250: aload #6
    //   252: ldc_w ' = '
    //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload #5
    //   261: astore_3
    //   262: aload #6
    //   264: iload_1
    //   265: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload #5
    //   271: astore_3
    //   272: ldc_w '[Database] deleted %s illegal data %d.'
    //   275: iconst_2
    //   276: anewarray java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: ldc 't_pf'
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload_2
    //   287: ldc 't_pf'
    //   289: aload #4
    //   291: iconst_4
    //   292: invokevirtual substring : (I)Ljava/lang/String;
    //   295: aconst_null
    //   296: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   299: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   302: aastore
    //   303: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   306: pop
    //   307: aload #5
    //   309: ifnull -> 319
    //   312: aload #5
    //   314: invokeinterface close : ()V
    //   319: aload_0
    //   320: monitorexit
    //   321: aload #7
    //   323: areturn
    //   324: astore_2
    //   325: goto -> 339
    //   328: astore #5
    //   330: aconst_null
    //   331: astore_3
    //   332: goto -> 374
    //   335: astore_2
    //   336: aconst_null
    //   337: astore #5
    //   339: aload #5
    //   341: astore_3
    //   342: aload_2
    //   343: invokestatic a : (Ljava/lang/Throwable;)Z
    //   346: ifne -> 356
    //   349: aload #5
    //   351: astore_3
    //   352: aload_2
    //   353: invokevirtual printStackTrace : ()V
    //   356: aload #5
    //   358: ifnull -> 368
    //   361: aload #5
    //   363: invokeinterface close : ()V
    //   368: aload_0
    //   369: monitorexit
    //   370: aconst_null
    //   371: areturn
    //   372: astore #5
    //   374: aload_3
    //   375: ifnull -> 391
    //   378: aload_3
    //   379: invokeinterface close : ()V
    //   384: goto -> 391
    //   387: astore_3
    //   388: goto -> 394
    //   391: aload #5
    //   393: athrow
    //   394: aload_0
    //   395: monitorexit
    //   396: aload_3
    //   397: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	335	java/lang/Throwable
    //   2	9	328	finally
    //   13	50	335	java/lang/Throwable
    //   13	50	328	finally
    //   60	67	387	finally
    //   74	79	324	java/lang/Throwable
    //   74	79	372	finally
    //   82	87	324	java/lang/Throwable
    //   82	87	372	finally
    //   90	95	324	java/lang/Throwable
    //   90	95	372	finally
    //   98	103	324	java/lang/Throwable
    //   98	103	372	finally
    //   106	116	324	java/lang/Throwable
    //   106	116	372	finally
    //   119	126	324	java/lang/Throwable
    //   119	126	372	finally
    //   134	144	324	java/lang/Throwable
    //   134	144	372	finally
    //   150	168	206	java/lang/Throwable
    //   150	168	372	finally
    //   171	180	206	java/lang/Throwable
    //   171	180	372	finally
    //   183	192	206	java/lang/Throwable
    //   183	192	372	finally
    //   195	203	206	java/lang/Throwable
    //   195	203	372	finally
    //   210	221	324	java/lang/Throwable
    //   210	221	372	finally
    //   227	235	324	java/lang/Throwable
    //   227	235	372	finally
    //   238	247	324	java/lang/Throwable
    //   238	247	372	finally
    //   250	259	324	java/lang/Throwable
    //   250	259	372	finally
    //   262	269	324	java/lang/Throwable
    //   262	269	372	finally
    //   272	307	324	java/lang/Throwable
    //   272	307	372	finally
    //   312	319	387	finally
    //   342	349	372	finally
    //   352	356	372	finally
    //   361	368	387	finally
    //   378	384	387	finally
    //   391	394	387	finally
  }
  
  private static ContentValues d(r paramr) {
    if (paramr == null || z.a(paramr.f))
      return null; 
    try {
      ContentValues contentValues = new ContentValues();
      this();
      if (paramr.a > 0L)
        contentValues.put("_id", Long.valueOf(paramr.a)); 
      contentValues.put("_tp", paramr.f);
      contentValues.put("_tm", Long.valueOf(paramr.e));
      if (paramr.g != null)
        contentValues.put("_dt", paramr.g); 
      return contentValues;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public final int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo, boolean paramBoolean) {
    return a(paramString1, paramString2, (String[])null, (o)null);
  }
  
  public final long a(String paramString, ContentValues paramContentValues, o paramo, boolean paramBoolean) {
    return a(paramString, paramContentValues, (o)null);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, o paramo, boolean paramBoolean) {
    return a(false, paramString1, paramArrayOfString1, paramString2, null, null, null, null, null, null);
  }
  
  public final List<r> a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull -> 373
    //   13: iload_1
    //   14: iflt -> 56
    //   17: new java/lang/StringBuilder
    //   20: astore_3
    //   21: aload_3
    //   22: ldc_w '_tp = '
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: aload_3
    //   29: iload_1
    //   30: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: astore_3
    //   39: goto -> 58
    //   42: astore #4
    //   44: aconst_null
    //   45: astore_3
    //   46: goto -> 360
    //   49: astore_2
    //   50: aconst_null
    //   51: astore #4
    //   53: goto -> 326
    //   56: aconst_null
    //   57: astore_3
    //   58: aload_2
    //   59: ldc_w 't_lr'
    //   62: aconst_null
    //   63: aload_3
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore #4
    //   73: aload #4
    //   75: ifnonnull -> 94
    //   78: aload #4
    //   80: ifnull -> 90
    //   83: aload #4
    //   85: invokeinterface close : ()V
    //   90: aload_0
    //   91: monitorexit
    //   92: aconst_null
    //   93: areturn
    //   94: aload #4
    //   96: astore_3
    //   97: new java/lang/StringBuilder
    //   100: astore #5
    //   102: aload #4
    //   104: astore_3
    //   105: aload #5
    //   107: invokespecial <init> : ()V
    //   110: aload #4
    //   112: astore_3
    //   113: new java/util/ArrayList
    //   116: astore #6
    //   118: aload #4
    //   120: astore_3
    //   121: aload #6
    //   123: invokespecial <init> : ()V
    //   126: aload #4
    //   128: astore_3
    //   129: aload #4
    //   131: invokeinterface moveToNext : ()Z
    //   136: ifeq -> 247
    //   139: aload #4
    //   141: astore_3
    //   142: aload #4
    //   144: invokestatic a : (Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/r;
    //   147: astore #7
    //   149: aload #7
    //   151: ifnull -> 170
    //   154: aload #4
    //   156: astore_3
    //   157: aload #6
    //   159: aload #7
    //   161: invokeinterface add : (Ljava/lang/Object;)Z
    //   166: pop
    //   167: goto -> 126
    //   170: aload #4
    //   172: astore_3
    //   173: aload #4
    //   175: aload #4
    //   177: ldc '_id'
    //   179: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   184: invokeinterface getLong : (I)J
    //   189: lstore #8
    //   191: aload #4
    //   193: astore_3
    //   194: aload #5
    //   196: ldc_w ' or _id'
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload #4
    //   205: astore_3
    //   206: aload #5
    //   208: ldc_w ' = '
    //   211: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload #4
    //   217: astore_3
    //   218: aload #5
    //   220: lload #8
    //   222: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: goto -> 126
    //   229: astore_3
    //   230: aload #4
    //   232: astore_3
    //   233: ldc_w '[Database] unknown id.'
    //   236: iconst_0
    //   237: anewarray java/lang/Object
    //   240: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   243: pop
    //   244: goto -> 126
    //   247: aload #4
    //   249: astore_3
    //   250: aload #5
    //   252: invokevirtual toString : ()Ljava/lang/String;
    //   255: astore #5
    //   257: aload #4
    //   259: astore_3
    //   260: aload #5
    //   262: invokevirtual length : ()I
    //   265: ifle -> 308
    //   268: aload #4
    //   270: astore_3
    //   271: ldc_w '[Database] deleted %s illegal data %d'
    //   274: iconst_2
    //   275: anewarray java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: ldc_w 't_lr'
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: aload_2
    //   287: ldc_w 't_lr'
    //   290: aload #5
    //   292: iconst_4
    //   293: invokevirtual substring : (I)Ljava/lang/String;
    //   296: aconst_null
    //   297: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   300: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   303: aastore
    //   304: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   307: pop
    //   308: aload #4
    //   310: ifnull -> 320
    //   313: aload #4
    //   315: invokeinterface close : ()V
    //   320: aload_0
    //   321: monitorexit
    //   322: aload #6
    //   324: areturn
    //   325: astore_2
    //   326: aload #4
    //   328: astore_3
    //   329: aload_2
    //   330: invokestatic a : (Ljava/lang/Throwable;)Z
    //   333: ifne -> 343
    //   336: aload #4
    //   338: astore_3
    //   339: aload_2
    //   340: invokevirtual printStackTrace : ()V
    //   343: aload #4
    //   345: ifnull -> 373
    //   348: aload #4
    //   350: invokeinterface close : ()V
    //   355: goto -> 373
    //   358: astore #4
    //   360: aload_3
    //   361: ifnull -> 370
    //   364: aload_3
    //   365: invokeinterface close : ()V
    //   370: aload #4
    //   372: athrow
    //   373: aload_0
    //   374: monitorexit
    //   375: aconst_null
    //   376: areturn
    //   377: astore_3
    //   378: aload_0
    //   379: monitorexit
    //   380: aload_3
    //   381: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	377	finally
    //   17	39	49	java/lang/Throwable
    //   17	39	42	finally
    //   58	73	49	java/lang/Throwable
    //   58	73	42	finally
    //   83	90	377	finally
    //   97	102	325	java/lang/Throwable
    //   97	102	358	finally
    //   105	110	325	java/lang/Throwable
    //   105	110	358	finally
    //   113	118	325	java/lang/Throwable
    //   113	118	358	finally
    //   121	126	325	java/lang/Throwable
    //   121	126	358	finally
    //   129	139	325	java/lang/Throwable
    //   129	139	358	finally
    //   142	149	325	java/lang/Throwable
    //   142	149	358	finally
    //   157	167	325	java/lang/Throwable
    //   157	167	358	finally
    //   173	191	229	java/lang/Throwable
    //   173	191	358	finally
    //   194	203	229	java/lang/Throwable
    //   194	203	358	finally
    //   206	215	229	java/lang/Throwable
    //   206	215	358	finally
    //   218	226	229	java/lang/Throwable
    //   218	226	358	finally
    //   233	244	325	java/lang/Throwable
    //   233	244	358	finally
    //   250	257	325	java/lang/Throwable
    //   250	257	358	finally
    //   260	268	325	java/lang/Throwable
    //   260	268	358	finally
    //   271	308	325	java/lang/Throwable
    //   271	308	358	finally
    //   313	320	377	finally
    //   329	336	358	finally
    //   339	343	358	finally
    //   348	355	377	finally
    //   364	370	377	finally
    //   370	373	377	finally
  }
  
  public final Map<String, byte[]> a(int paramInt, o paramo, boolean paramBoolean) {
    return a(paramInt, (o)null);
  }
  
  public final void a(List<r> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 185
    //   6: aload_1
    //   7: invokeinterface size : ()I
    //   12: ifne -> 18
    //   15: goto -> 185
    //   18: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   21: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull -> 177
    //   29: new java/lang/StringBuilder
    //   32: astore_3
    //   33: aload_3
    //   34: invokespecial <init> : ()V
    //   37: aload_1
    //   38: invokeinterface iterator : ()Ljava/util/Iterator;
    //   43: astore_1
    //   44: aload_1
    //   45: invokeinterface hasNext : ()Z
    //   50: ifeq -> 93
    //   53: aload_1
    //   54: invokeinterface next : ()Ljava/lang/Object;
    //   59: checkcast com/tencent/bugly/proguard/r
    //   62: astore #4
    //   64: aload_3
    //   65: ldc_w ' or _id'
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: ldc_w ' = '
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_3
    //   81: aload #4
    //   83: getfield a : J
    //   86: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: goto -> 44
    //   93: aload_3
    //   94: invokevirtual toString : ()Ljava/lang/String;
    //   97: astore #4
    //   99: aload #4
    //   101: astore_1
    //   102: aload #4
    //   104: invokevirtual length : ()I
    //   107: ifle -> 117
    //   110: aload #4
    //   112: iconst_4
    //   113: invokevirtual substring : (I)Ljava/lang/String;
    //   116: astore_1
    //   117: aload_3
    //   118: iconst_0
    //   119: invokevirtual setLength : (I)V
    //   122: ldc '[Database] deleted %s data %d'
    //   124: iconst_2
    //   125: anewarray java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: ldc_w 't_lr'
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: aload_2
    //   137: ldc_w 't_lr'
    //   140: aload_1
    //   141: aconst_null
    //   142: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   145: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   152: pop
    //   153: aload_0
    //   154: monitorexit
    //   155: return
    //   156: astore_1
    //   157: goto -> 175
    //   160: astore_1
    //   161: aload_1
    //   162: invokestatic a : (Ljava/lang/Throwable;)Z
    //   165: ifne -> 172
    //   168: aload_1
    //   169: invokevirtual printStackTrace : ()V
    //   172: aload_0
    //   173: monitorexit
    //   174: return
    //   175: aload_1
    //   176: athrow
    //   177: aload_0
    //   178: monitorexit
    //   179: return
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    //   185: aload_0
    //   186: monitorexit
    //   187: return
    // Exception table:
    //   from	to	target	type
    //   6	15	180	finally
    //   18	25	180	finally
    //   29	44	180	finally
    //   44	90	180	finally
    //   93	99	180	finally
    //   102	117	180	finally
    //   117	122	180	finally
    //   122	153	160	java/lang/Throwable
    //   122	153	156	finally
    //   161	172	156	finally
    //   175	177	180	finally
  }
  
  public final boolean a(int paramInt, String paramString, o paramo, boolean paramBoolean) {
    return a(555, paramString, (o)null);
  }
  
  public final boolean a(int paramInt, String paramString, byte[] paramArrayOfbyte, o paramo, boolean paramBoolean) {
    if (!paramBoolean) {
      a a = new a(this, 4, null);
      a.a(paramInt, paramString, paramArrayOfbyte);
      w.a().a(a);
      return true;
    } 
    return a(paramInt, paramString, paramArrayOfbyte, (o)null);
  }
  
  public final boolean a(r paramr) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: iconst_0
    //   9: ireturn
    //   10: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   13: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull -> 79
    //   21: aload_1
    //   22: invokestatic c : (Lcom/tencent/bugly/proguard/r;)Landroid/content/ContentValues;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull -> 79
    //   30: aload_2
    //   31: ldc_w 't_lr'
    //   34: ldc '_id'
    //   36: aload_3
    //   37: invokevirtual replace : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   40: lstore #4
    //   42: lload #4
    //   44: lconst_0
    //   45: lcmp
    //   46: iflt -> 75
    //   49: ldc '[Database] insert %s success.'
    //   51: iconst_1
    //   52: anewarray java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: ldc_w 't_lr'
    //   60: aastore
    //   61: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   64: pop
    //   65: aload_1
    //   66: lload #4
    //   68: putfield a : J
    //   71: aload_0
    //   72: monitorexit
    //   73: iconst_1
    //   74: ireturn
    //   75: aload_0
    //   76: monitorexit
    //   77: iconst_0
    //   78: ireturn
    //   79: aload_0
    //   80: monitorexit
    //   81: iconst_0
    //   82: ireturn
    //   83: astore_1
    //   84: goto -> 103
    //   87: astore_1
    //   88: aload_1
    //   89: invokestatic a : (Ljava/lang/Throwable;)Z
    //   92: ifne -> 99
    //   95: aload_1
    //   96: invokevirtual printStackTrace : ()V
    //   99: aload_0
    //   100: monitorexit
    //   101: iconst_0
    //   102: ireturn
    //   103: aload_1
    //   104: athrow
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Exception table:
    //   from	to	target	type
    //   10	17	87	java/lang/Throwable
    //   10	17	83	finally
    //   21	26	87	java/lang/Throwable
    //   21	26	83	finally
    //   30	42	87	java/lang/Throwable
    //   30	42	83	finally
    //   49	71	87	java/lang/Throwable
    //   49	71	83	finally
    //   88	99	83	finally
    //   103	105	105	finally
  }
  
  public final void b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/bugly/proguard/p.b : Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull -> 102
    //   13: iload_1
    //   14: iflt -> 50
    //   17: new java/lang/StringBuilder
    //   20: astore_3
    //   21: aload_3
    //   22: ldc_w '_tp = '
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: aload_3
    //   29: iload_1
    //   30: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: astore_3
    //   39: goto -> 52
    //   42: astore_3
    //   43: goto -> 100
    //   46: astore_3
    //   47: goto -> 86
    //   50: aconst_null
    //   51: astore_3
    //   52: ldc '[Database] deleted %s data %d'
    //   54: iconst_2
    //   55: anewarray java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: ldc_w 't_lr'
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_2
    //   67: ldc_w 't_lr'
    //   70: aload_3
    //   71: aconst_null
    //   72: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   75: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   78: aastore
    //   79: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: aload_3
    //   87: invokestatic a : (Ljava/lang/Throwable;)Z
    //   90: ifne -> 97
    //   93: aload_3
    //   94: invokevirtual printStackTrace : ()V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: aload_3
    //   101: athrow
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: astore_3
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_3
    //   109: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	105	finally
    //   17	39	46	java/lang/Throwable
    //   17	39	42	finally
    //   52	83	46	java/lang/Throwable
    //   52	83	42	finally
    //   86	97	42	finally
    //   100	102	105	finally
  }
  
  final class a extends Thread {
    private int a;
    
    private o b;
    
    private String c;
    
    private ContentValues d;
    
    private boolean e;
    
    private String[] f;
    
    private String g;
    
    private String[] h;
    
    private String i;
    
    private String j;
    
    private String k;
    
    private String l;
    
    private String m;
    
    private String[] n;
    
    private int o;
    
    private String p;
    
    private byte[] q;
    
    public a(p this$0, int param1Int, o param1o) {
      this.a = param1Int;
      this.b = param1o;
    }
    
    public final void a(int param1Int, String param1String, byte[] param1ArrayOfbyte) {
      this.o = param1Int;
      this.p = param1String;
      this.q = param1ArrayOfbyte;
    }
    
    public final void a(boolean param1Boolean, String param1String1, String[] param1ArrayOfString1, String param1String2, String[] param1ArrayOfString2, String param1String3, String param1String4, String param1String5, String param1String6) {
      this.e = param1Boolean;
      this.c = param1String1;
      this.f = param1ArrayOfString1;
      this.g = param1String2;
      this.h = param1ArrayOfString2;
      this.i = param1String3;
      this.j = param1String4;
      this.k = param1String5;
      this.l = param1String6;
    }
    
    public final void run() {
      Cursor cursor;
      switch (this.a) {
        default:
          return;
        case 6:
          p.a(this.r, this.o, this.p, this.b);
        case 5:
          p.a(this.r, this.o, this.b);
          return;
        case 4:
          p.a(this.r, this.o, this.p, this.q, this.b);
          return;
        case 3:
          cursor = p.a(this.r, this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
          if (cursor != null) {
            cursor.close();
            return;
          } 
        case 2:
          p.a(this.r, this.c, this.m, this.n, this.b);
          return;
        case 1:
          break;
      } 
      p.a(this.r, this.c, this.d, this.b);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */