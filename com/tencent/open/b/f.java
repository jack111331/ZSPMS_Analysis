package com.tencent.open.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.Serializable;
import java.util.List;

public class f extends SQLiteOpenHelper {
  protected static final String[] a = new String[] { "key" };
  
  protected static f b;
  
  public f(Context paramContext) {
    super(paramContext, "sdk_report.db", null, 2);
  }
  
  public static f a() {
    // Byte code:
    //   0: ldc com/tencent/open/b/f
    //   2: monitorenter
    //   3: getstatic com/tencent/open/b/f.b : Lcom/tencent/open/b/f;
    //   6: ifnonnull -> 24
    //   9: new com/tencent/open/b/f
    //   12: astore_0
    //   13: aload_0
    //   14: invokestatic a : ()Landroid/content/Context;
    //   17: invokespecial <init> : (Landroid/content/Context;)V
    //   20: aload_0
    //   21: putstatic com/tencent/open/b/f.b : Lcom/tencent/open/b/f;
    //   24: getstatic com/tencent/open/b/f.b : Lcom/tencent/open/b/f;
    //   27: astore_0
    //   28: ldc com/tencent/open/b/f
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: astore_0
    //   34: ldc com/tencent/open/b/f
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	33	finally
    //   24	28	33	finally
  }
  
  public List<Serializable> a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: astore_2
    //   6: aload_2
    //   7: invokespecial <init> : ()V
    //   10: aload_2
    //   11: invokestatic synchronizedList : (Ljava/util/List;)Ljava/util/List;
    //   14: astore_3
    //   15: aload_1
    //   16: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   19: istore #4
    //   21: iload #4
    //   23: ifeq -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_3
    //   29: areturn
    //   30: aload_0
    //   31: invokevirtual getReadableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore #5
    //   36: aload #5
    //   38: ifnonnull -> 44
    //   41: goto -> 26
    //   44: aload #5
    //   46: ldc 'via_cgi_report'
    //   48: aconst_null
    //   49: ldc 'type = ?'
    //   51: iconst_1
    //   52: anewarray java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: aastore
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull -> 172
    //   70: aload_1
    //   71: invokeinterface getCount : ()I
    //   76: ifle -> 172
    //   79: aload_1
    //   80: invokeinterface moveToFirst : ()Z
    //   85: pop
    //   86: aload_1
    //   87: aload_1
    //   88: ldc 'blob'
    //   90: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   95: invokeinterface getBlob : (I)[B
    //   100: astore_2
    //   101: new java/io/ByteArrayInputStream
    //   104: astore #6
    //   106: aload #6
    //   108: aload_2
    //   109: invokespecial <init> : ([B)V
    //   112: new java/io/ObjectInputStream
    //   115: astore_2
    //   116: aload_2
    //   117: aload #6
    //   119: invokespecial <init> : (Ljava/io/InputStream;)V
    //   122: aload_2
    //   123: invokevirtual readObject : ()Ljava/lang/Object;
    //   126: checkcast java/io/Serializable
    //   129: astore #7
    //   131: aload_2
    //   132: ifnull -> 139
    //   135: aload_2
    //   136: invokevirtual close : ()V
    //   139: aload #6
    //   141: invokevirtual close : ()V
    //   144: aload #7
    //   146: astore_2
    //   147: aload_2
    //   148: ifnull -> 159
    //   151: aload_3
    //   152: aload_2
    //   153: invokeinterface add : (Ljava/lang/Object;)Z
    //   158: pop
    //   159: aload_1
    //   160: invokeinterface moveToNext : ()Z
    //   165: istore #4
    //   167: iload #4
    //   169: ifne -> 86
    //   172: aload_1
    //   173: ifnull -> 182
    //   176: aload_1
    //   177: invokeinterface close : ()V
    //   182: iconst_0
    //   183: ifeq -> 194
    //   186: new java/lang/NullPointerException
    //   189: dup
    //   190: invokespecial <init> : ()V
    //   193: athrow
    //   194: aload #5
    //   196: ifnull -> 204
    //   199: aload #5
    //   201: invokevirtual close : ()V
    //   204: goto -> 26
    //   207: astore_2
    //   208: aconst_null
    //   209: astore_2
    //   210: aload_2
    //   211: ifnull -> 218
    //   214: aload_2
    //   215: invokevirtual close : ()V
    //   218: aload #6
    //   220: invokevirtual close : ()V
    //   223: aconst_null
    //   224: astore_2
    //   225: goto -> 147
    //   228: astore_2
    //   229: aconst_null
    //   230: astore_2
    //   231: goto -> 147
    //   234: astore #7
    //   236: aconst_null
    //   237: astore_2
    //   238: aload_2
    //   239: ifnull -> 246
    //   242: aload_2
    //   243: invokevirtual close : ()V
    //   246: aload #6
    //   248: invokevirtual close : ()V
    //   251: aload #7
    //   253: athrow
    //   254: astore_2
    //   255: ldc 'openSDK_LOG.ReportDatabaseHelper'
    //   257: ldc 'getReportItemFromDB has exception.'
    //   259: aload_2
    //   260: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   263: aload_1
    //   264: ifnull -> 273
    //   267: aload_1
    //   268: invokeinterface close : ()V
    //   273: iconst_0
    //   274: ifeq -> 285
    //   277: new java/lang/NullPointerException
    //   280: dup
    //   281: invokespecial <init> : ()V
    //   284: athrow
    //   285: aload #5
    //   287: ifnull -> 204
    //   290: aload #5
    //   292: invokevirtual close : ()V
    //   295: goto -> 204
    //   298: astore_1
    //   299: aload_0
    //   300: monitorexit
    //   301: aload_1
    //   302: athrow
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual printStackTrace : ()V
    //   308: goto -> 194
    //   311: astore_1
    //   312: aload_1
    //   313: invokevirtual printStackTrace : ()V
    //   316: goto -> 285
    //   319: astore_2
    //   320: aconst_null
    //   321: astore_1
    //   322: aload_1
    //   323: ifnull -> 332
    //   326: aload_1
    //   327: invokeinterface close : ()V
    //   332: iconst_0
    //   333: ifeq -> 344
    //   336: new java/lang/NullPointerException
    //   339: dup
    //   340: invokespecial <init> : ()V
    //   343: athrow
    //   344: aload #5
    //   346: ifnull -> 354
    //   349: aload #5
    //   351: invokevirtual close : ()V
    //   354: aload_2
    //   355: athrow
    //   356: astore_1
    //   357: aload_1
    //   358: invokevirtual printStackTrace : ()V
    //   361: goto -> 344
    //   364: astore_2
    //   365: goto -> 139
    //   368: astore_2
    //   369: aload #7
    //   371: astore_2
    //   372: goto -> 147
    //   375: astore_2
    //   376: goto -> 218
    //   379: astore_2
    //   380: goto -> 246
    //   383: astore_2
    //   384: goto -> 251
    //   387: astore_2
    //   388: goto -> 322
    //   391: astore_2
    //   392: goto -> 322
    //   395: astore_2
    //   396: aconst_null
    //   397: astore_1
    //   398: goto -> 255
    //   401: astore #7
    //   403: goto -> 238
    //   406: astore #7
    //   408: goto -> 210
    // Exception table:
    //   from	to	target	type
    //   2	21	298	finally
    //   30	36	298	finally
    //   44	66	395	java/lang/Exception
    //   44	66	319	finally
    //   70	86	254	java/lang/Exception
    //   70	86	387	finally
    //   86	112	254	java/lang/Exception
    //   86	112	387	finally
    //   112	122	207	java/lang/Exception
    //   112	122	234	finally
    //   122	131	406	java/lang/Exception
    //   122	131	401	finally
    //   135	139	364	java/io/IOException
    //   135	139	254	java/lang/Exception
    //   135	139	387	finally
    //   139	144	368	java/io/IOException
    //   139	144	254	java/lang/Exception
    //   139	144	387	finally
    //   151	159	254	java/lang/Exception
    //   151	159	387	finally
    //   159	167	254	java/lang/Exception
    //   159	167	387	finally
    //   176	182	298	finally
    //   186	194	303	java/io/IOException
    //   186	194	298	finally
    //   199	204	298	finally
    //   214	218	375	java/io/IOException
    //   214	218	254	java/lang/Exception
    //   214	218	387	finally
    //   218	223	228	java/io/IOException
    //   218	223	254	java/lang/Exception
    //   218	223	387	finally
    //   242	246	379	java/io/IOException
    //   242	246	254	java/lang/Exception
    //   242	246	387	finally
    //   246	251	383	java/io/IOException
    //   246	251	254	java/lang/Exception
    //   246	251	387	finally
    //   251	254	254	java/lang/Exception
    //   251	254	387	finally
    //   255	263	391	finally
    //   267	273	298	finally
    //   277	285	311	java/io/IOException
    //   277	285	298	finally
    //   290	295	298	finally
    //   304	308	298	finally
    //   312	316	298	finally
    //   326	332	298	finally
    //   336	344	356	java/io/IOException
    //   336	344	298	finally
    //   349	354	298	finally
    //   354	356	298	finally
    //   357	361	298	finally
  }
  
  public void a(String paramString, List<Serializable> paramList) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_2
    //   5: invokeinterface size : ()I
    //   10: istore #4
    //   12: iload #4
    //   14: ifne -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: iload #4
    //   22: bipush #20
    //   24: if_icmpgt -> 182
    //   27: aload_1
    //   28: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   31: ifne -> 17
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual b : (Ljava/lang/String;)V
    //   39: aload_0
    //   40: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   43: astore #5
    //   45: aload #5
    //   47: ifnull -> 17
    //   50: aload #5
    //   52: invokevirtual beginTransaction : ()V
    //   55: new android/content/ContentValues
    //   58: astore #6
    //   60: aload #6
    //   62: invokespecial <init> : ()V
    //   65: iconst_0
    //   66: istore #7
    //   68: iload #7
    //   70: iload #4
    //   72: if_icmpge -> 266
    //   75: aload_2
    //   76: iload #7
    //   78: invokeinterface get : (I)Ljava/lang/Object;
    //   83: checkcast java/io/Serializable
    //   86: astore #8
    //   88: aload #8
    //   90: ifnull -> 171
    //   93: aload #6
    //   95: ldc 'type'
    //   97: aload_1
    //   98: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   101: new java/io/ByteArrayOutputStream
    //   104: astore #9
    //   106: aload #9
    //   108: sipush #512
    //   111: invokespecial <init> : (I)V
    //   114: new java/io/ObjectOutputStream
    //   117: astore #10
    //   119: aload #10
    //   121: aload #9
    //   123: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   126: aload #10
    //   128: aload #8
    //   130: invokevirtual writeObject : (Ljava/lang/Object;)V
    //   133: aload #10
    //   135: ifnull -> 143
    //   138: aload #10
    //   140: invokevirtual close : ()V
    //   143: aload #9
    //   145: invokevirtual close : ()V
    //   148: aload #6
    //   150: ldc 'blob'
    //   152: aload #9
    //   154: invokevirtual toByteArray : ()[B
    //   157: invokevirtual put : (Ljava/lang/String;[B)V
    //   160: aload #5
    //   162: ldc 'via_cgi_report'
    //   164: aconst_null
    //   165: aload #6
    //   167: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   170: pop2
    //   171: aload #6
    //   173: invokevirtual clear : ()V
    //   176: iinc #7, 1
    //   179: goto -> 68
    //   182: bipush #20
    //   184: istore #4
    //   186: goto -> 27
    //   189: astore #10
    //   191: aconst_null
    //   192: astore #10
    //   194: aload #10
    //   196: ifnull -> 204
    //   199: aload #10
    //   201: invokevirtual close : ()V
    //   204: aload #9
    //   206: invokevirtual close : ()V
    //   209: goto -> 148
    //   212: astore #10
    //   214: goto -> 148
    //   217: astore_1
    //   218: aload_3
    //   219: astore_2
    //   220: aload_2
    //   221: ifnull -> 228
    //   224: aload_2
    //   225: invokevirtual close : ()V
    //   228: aload #9
    //   230: invokevirtual close : ()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: ldc 'openSDK_LOG.ReportDatabaseHelper'
    //   238: ldc 'saveReportItemToDB has exception.'
    //   240: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload #5
    //   245: invokevirtual endTransaction : ()V
    //   248: aload #5
    //   250: ifnull -> 17
    //   253: aload #5
    //   255: invokevirtual close : ()V
    //   258: goto -> 17
    //   261: astore_1
    //   262: aload_0
    //   263: monitorexit
    //   264: aload_1
    //   265: athrow
    //   266: aload #5
    //   268: invokevirtual setTransactionSuccessful : ()V
    //   271: aload #5
    //   273: invokevirtual endTransaction : ()V
    //   276: aload #5
    //   278: ifnull -> 17
    //   281: aload #5
    //   283: invokevirtual close : ()V
    //   286: goto -> 17
    //   289: astore_1
    //   290: aload #5
    //   292: invokevirtual endTransaction : ()V
    //   295: aload #5
    //   297: ifnull -> 305
    //   300: aload #5
    //   302: invokevirtual close : ()V
    //   305: aload_1
    //   306: athrow
    //   307: astore #10
    //   309: goto -> 143
    //   312: astore #10
    //   314: goto -> 148
    //   317: astore #10
    //   319: goto -> 204
    //   322: astore_2
    //   323: goto -> 228
    //   326: astore_2
    //   327: goto -> 233
    //   330: astore_1
    //   331: aload #10
    //   333: astore_2
    //   334: goto -> 220
    //   337: astore #8
    //   339: goto -> 194
    // Exception table:
    //   from	to	target	type
    //   4	12	261	finally
    //   27	45	261	finally
    //   50	55	261	finally
    //   55	65	235	java/lang/Exception
    //   55	65	289	finally
    //   75	88	235	java/lang/Exception
    //   75	88	289	finally
    //   93	114	235	java/lang/Exception
    //   93	114	289	finally
    //   114	126	189	java/io/IOException
    //   114	126	217	finally
    //   126	133	337	java/io/IOException
    //   126	133	330	finally
    //   138	143	307	java/io/IOException
    //   138	143	235	java/lang/Exception
    //   138	143	289	finally
    //   143	148	312	java/io/IOException
    //   143	148	235	java/lang/Exception
    //   143	148	289	finally
    //   148	171	235	java/lang/Exception
    //   148	171	289	finally
    //   171	176	235	java/lang/Exception
    //   171	176	289	finally
    //   199	204	317	java/io/IOException
    //   199	204	235	java/lang/Exception
    //   199	204	289	finally
    //   204	209	212	java/io/IOException
    //   204	209	235	java/lang/Exception
    //   204	209	289	finally
    //   224	228	322	java/io/IOException
    //   224	228	235	java/lang/Exception
    //   224	228	289	finally
    //   228	233	326	java/io/IOException
    //   228	233	235	java/lang/Exception
    //   228	233	289	finally
    //   233	235	235	java/lang/Exception
    //   233	235	289	finally
    //   236	243	289	finally
    //   243	248	261	finally
    //   253	258	261	finally
    //   266	271	235	java/lang/Exception
    //   266	271	289	finally
    //   271	276	261	finally
    //   281	286	261	finally
    //   290	295	261	finally
    //   300	305	261	finally
    //   305	307	261	finally
  }
  
  public void b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull -> 11
    //   23: aload_3
    //   24: ldc 'via_cgi_report'
    //   26: ldc 'type = ?'
    //   28: iconst_1
    //   29: anewarray java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aastore
    //   36: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   39: pop
    //   40: aload_3
    //   41: ifnull -> 11
    //   44: aload_3
    //   45: invokevirtual close : ()V
    //   48: goto -> 11
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    //   56: astore_1
    //   57: ldc 'openSDK_LOG.ReportDatabaseHelper'
    //   59: ldc 'clearReportItem has exception.'
    //   61: aload_1
    //   62: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   65: aload_3
    //   66: ifnull -> 11
    //   69: aload_3
    //   70: invokevirtual close : ()V
    //   73: goto -> 11
    //   76: astore_1
    //   77: aload_3
    //   78: ifnull -> 85
    //   81: aload_3
    //   82: invokevirtual close : ()V
    //   85: aload_1
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	51	finally
    //   14	19	51	finally
    //   23	40	56	java/lang/Exception
    //   23	40	76	finally
    //   44	48	51	finally
    //   57	65	76	finally
    //   69	73	51	finally
    //   81	85	51	finally
    //   85	87	51	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */