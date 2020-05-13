package com.tencent.wxop.stat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

final class ac extends SQLiteOpenHelper {
  private String a = "";
  
  private Context co = null;
  
  public ac(Context paramContext, String paramString) {
    super(paramContext, paramString, null, 3);
    this.a = paramString;
    this.co = paramContext.getApplicationContext();
    if (c.k())
      t.ao().b("SQLiteOpenHelper " + this.a); 
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ldc 'user'
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_2
    //   15: aload_2
    //   16: astore_3
    //   17: new android/content/ContentValues
    //   20: astore #4
    //   22: aload_2
    //   23: astore_3
    //   24: aload #4
    //   26: invokespecial <init> : ()V
    //   29: aload_2
    //   30: astore_3
    //   31: aload_2
    //   32: invokeinterface moveToNext : ()Z
    //   37: ifeq -> 93
    //   40: aload_2
    //   41: astore_3
    //   42: aload_2
    //   43: iconst_0
    //   44: invokeinterface getString : (I)Ljava/lang/String;
    //   49: astore_1
    //   50: aload_2
    //   51: astore_3
    //   52: aload_2
    //   53: iconst_1
    //   54: invokeinterface getInt : (I)I
    //   59: pop
    //   60: aload_2
    //   61: astore_3
    //   62: aload_2
    //   63: iconst_2
    //   64: invokeinterface getString : (I)Ljava/lang/String;
    //   69: pop
    //   70: aload_2
    //   71: astore_3
    //   72: aload_2
    //   73: iconst_3
    //   74: invokeinterface getLong : (I)J
    //   79: pop2
    //   80: aload_2
    //   81: astore_3
    //   82: aload #4
    //   84: ldc 'uid'
    //   86: aload_1
    //   87: invokestatic q : (Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_1
    //   94: ifnull -> 118
    //   97: aload_2
    //   98: astore_3
    //   99: aload_0
    //   100: ldc 'user'
    //   102: aload #4
    //   104: ldc 'uid=?'
    //   106: iconst_1
    //   107: anewarray java/lang/String
    //   110: dup
    //   111: iconst_0
    //   112: aload_1
    //   113: aastore
    //   114: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   117: pop
    //   118: aload_2
    //   119: ifnull -> 128
    //   122: aload_2
    //   123: invokeinterface close : ()V
    //   128: return
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: astore_3
    //   134: invokestatic ao : ()Lcom/tencent/wxop/stat/b/b;
    //   137: aload_0
    //   138: invokevirtual b : (Ljava/lang/Throwable;)V
    //   141: aload_2
    //   142: ifnull -> 128
    //   145: aload_2
    //   146: invokeinterface close : ()V
    //   151: goto -> 128
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_3
    //   157: aload_3
    //   158: ifnull -> 167
    //   161: aload_3
    //   162: invokeinterface close : ()V
    //   167: aload_0
    //   168: athrow
    //   169: astore_0
    //   170: goto -> 157
    //   173: astore_0
    //   174: goto -> 132
    // Exception table:
    //   from	to	target	type
    //   2	15	129	java/lang/Throwable
    //   2	15	154	finally
    //   17	22	173	java/lang/Throwable
    //   17	22	169	finally
    //   24	29	173	java/lang/Throwable
    //   24	29	169	finally
    //   31	40	173	java/lang/Throwable
    //   31	40	169	finally
    //   42	50	173	java/lang/Throwable
    //   42	50	169	finally
    //   52	60	173	java/lang/Throwable
    //   52	60	169	finally
    //   62	70	173	java/lang/Throwable
    //   62	70	169	finally
    //   72	80	173	java/lang/Throwable
    //   72	80	169	finally
    //   82	93	173	java/lang/Throwable
    //   82	93	169	finally
    //   99	118	173	java/lang/Throwable
    //   99	118	169	finally
    //   134	141	169	finally
  }
  
  private static void b(SQLiteDatabase paramSQLiteDatabase) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'events'
    //   3: aconst_null
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: aconst_null
    //   9: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   12: astore_1
    //   13: new java/util/ArrayList
    //   16: astore_2
    //   17: aload_2
    //   18: invokespecial <init> : ()V
    //   21: aload_1
    //   22: invokeinterface moveToNext : ()Z
    //   27: ifeq -> 117
    //   30: aload_1
    //   31: iconst_0
    //   32: invokeinterface getLong : (I)J
    //   37: lstore_3
    //   38: aload_1
    //   39: iconst_1
    //   40: invokeinterface getString : (I)Ljava/lang/String;
    //   45: astore #5
    //   47: aload_1
    //   48: iconst_2
    //   49: invokeinterface getInt : (I)I
    //   54: istore #6
    //   56: aload_1
    //   57: iconst_3
    //   58: invokeinterface getInt : (I)I
    //   63: istore #7
    //   65: new com/tencent/wxop/stat/ad
    //   68: astore #8
    //   70: aload #8
    //   72: lload_3
    //   73: aload #5
    //   75: iload #6
    //   77: iload #7
    //   79: invokespecial <init> : (JLjava/lang/String;II)V
    //   82: aload_2
    //   83: aload #8
    //   85: invokeinterface add : (Ljava/lang/Object;)Z
    //   90: pop
    //   91: goto -> 21
    //   94: astore #8
    //   96: aload_1
    //   97: astore_0
    //   98: invokestatic ao : ()Lcom/tencent/wxop/stat/b/b;
    //   101: aload #8
    //   103: invokevirtual b : (Ljava/lang/Throwable;)V
    //   106: aload_0
    //   107: ifnull -> 116
    //   110: aload_0
    //   111: invokeinterface close : ()V
    //   116: return
    //   117: new android/content/ContentValues
    //   120: astore #8
    //   122: aload #8
    //   124: invokespecial <init> : ()V
    //   127: aload_2
    //   128: invokeinterface iterator : ()Ljava/util/Iterator;
    //   133: astore #5
    //   135: aload #5
    //   137: invokeinterface hasNext : ()Z
    //   142: ifeq -> 211
    //   145: aload #5
    //   147: invokeinterface next : ()Ljava/lang/Object;
    //   152: checkcast com/tencent/wxop/stat/ad
    //   155: astore_2
    //   156: aload #8
    //   158: ldc 'content'
    //   160: aload_2
    //   161: getfield b : Ljava/lang/String;
    //   164: invokestatic q : (Ljava/lang/String;)Ljava/lang/String;
    //   167: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload_0
    //   171: ldc 'events'
    //   173: aload #8
    //   175: ldc 'event_id=?'
    //   177: iconst_1
    //   178: anewarray java/lang/String
    //   181: dup
    //   182: iconst_0
    //   183: aload_2
    //   184: getfield K : J
    //   187: invokestatic toString : (J)Ljava/lang/String;
    //   190: aastore
    //   191: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   194: pop
    //   195: goto -> 135
    //   198: astore_0
    //   199: aload_1
    //   200: ifnull -> 209
    //   203: aload_1
    //   204: invokeinterface close : ()V
    //   209: aload_0
    //   210: athrow
    //   211: aload_1
    //   212: ifnull -> 116
    //   215: aload_1
    //   216: invokeinterface close : ()V
    //   221: goto -> 116
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_1
    //   227: goto -> 199
    //   230: astore_1
    //   231: aload_0
    //   232: astore #8
    //   234: aload_1
    //   235: astore_0
    //   236: aload #8
    //   238: astore_1
    //   239: goto -> 199
    //   242: astore #8
    //   244: aconst_null
    //   245: astore_0
    //   246: goto -> 98
    // Exception table:
    //   from	to	target	type
    //   0	13	242	java/lang/Throwable
    //   0	13	224	finally
    //   13	21	94	java/lang/Throwable
    //   13	21	198	finally
    //   21	91	94	java/lang/Throwable
    //   21	91	198	finally
    //   98	106	230	finally
    //   117	135	94	java/lang/Throwable
    //   117	135	198	finally
    //   135	195	94	java/lang/Throwable
    //   135	195	198	finally
  }
  
  public final void close() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial close : ()V
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
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    paramSQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
    paramSQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    paramSQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    t.ao().debug("upgrade DB from oldVersion " + paramInt1 + " to newVersion " + paramInt2);
    if (paramInt1 == 1) {
      paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    } 
    if (paramInt1 == 2) {
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */