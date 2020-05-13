package com.unionpay.sdk;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class bc extends as {
  private static volatile bc a = null;
  
  private static SQLiteDatabase b;
  
  private static int c;
  
  private final int d = 1;
  
  private final int e = 2;
  
  private final int f = 3;
  
  private long a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt) {
    // Byte code:
    //   0: lconst_0
    //   1: lstore #6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: invokestatic b : (Ljava/lang/String;)Z
    //   9: istore #8
    //   11: iload #8
    //   13: ifeq -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: lload #6
    //   20: lreturn
    //   21: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   24: invokevirtual beginTransaction : ()V
    //   27: iload #5
    //   29: tableswitch default -> 56, 1 -> 80, 2 -> 98, 3 -> 119
    //   56: lload #6
    //   58: lstore #9
    //   60: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   63: invokevirtual setTransactionSuccessful : ()V
    //   66: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   69: invokevirtual endTransaction : ()V
    //   72: goto -> 16
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    //   80: lload #6
    //   82: lstore #9
    //   84: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   87: aload_1
    //   88: aconst_null
    //   89: aload_2
    //   90: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   93: lstore #6
    //   95: goto -> 56
    //   98: lload #6
    //   100: lstore #9
    //   102: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   105: aload_1
    //   106: aload_2
    //   107: aload_3
    //   108: aload #4
    //   110: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   113: i2l
    //   114: lstore #6
    //   116: goto -> 56
    //   119: lload #6
    //   121: lstore #9
    //   123: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   126: aload_1
    //   127: aload_3
    //   128: aload #4
    //   130: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   133: istore #5
    //   135: iload #5
    //   137: i2l
    //   138: lstore #6
    //   140: goto -> 56
    //   143: astore_1
    //   144: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   147: invokevirtual endTransaction : ()V
    //   150: lload #9
    //   152: lstore #6
    //   154: goto -> 16
    //   157: astore_1
    //   158: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   161: invokevirtual endTransaction : ()V
    //   164: aload_1
    //   165: athrow
    // Exception table:
    //   from	to	target	type
    //   5	11	75	finally
    //   21	27	75	finally
    //   60	66	143	java/lang/Throwable
    //   60	66	157	finally
    //   66	72	75	finally
    //   84	95	143	java/lang/Throwable
    //   84	95	157	finally
    //   102	116	143	java/lang/Throwable
    //   102	116	157	finally
    //   123	135	143	java/lang/Throwable
    //   123	135	157	finally
    //   144	150	75	finally
    //   158	166	75	finally
  }
  
  private long a(String paramString, m.c paramc, StringBuffer paramStringBuffer) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   5: ldc 'error_report'
    //   7: getstatic com/unionpay/sdk/bc$c.a : [Ljava/lang/String;
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: ldc '_id'
    //   16: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore #4
    //   21: aload_1
    //   22: ldc '\\r\\n'
    //   24: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   27: astore #5
    //   29: aload #5
    //   31: arraylength
    //   32: istore #6
    //   34: iload #6
    //   36: iconst_3
    //   37: if_icmpge -> 60
    //   40: aload #4
    //   42: ifnull -> 52
    //   45: aload #4
    //   47: invokeinterface close : ()V
    //   52: lconst_0
    //   53: lstore #7
    //   55: aload_0
    //   56: monitorexit
    //   57: lload #7
    //   59: lreturn
    //   60: new java/lang/StringBuilder
    //   63: astore_1
    //   64: aload_1
    //   65: invokespecial <init> : ()V
    //   68: aload_1
    //   69: aload #5
    //   71: iconst_0
    //   72: aaload
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc '\\r\\n'
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload #5
    //   83: iconst_1
    //   84: aaload
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc '\\r\\n'
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload #5
    //   95: iconst_2
    //   96: aaload
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual toString : ()Ljava/lang/String;
    //   103: astore_1
    //   104: aload_3
    //   105: aload_1
    //   106: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   112: pop
    //   113: aload #4
    //   115: invokeinterface moveToFirst : ()Z
    //   120: ifeq -> 369
    //   123: aload #4
    //   125: invokeinterface isAfterLast : ()Z
    //   130: istore #9
    //   132: iload #9
    //   134: ifne -> 369
    //   137: aload_2
    //   138: aload #4
    //   140: iconst_1
    //   141: invokeinterface getString : (I)Ljava/lang/String;
    //   146: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   149: invokestatic parseLong : (Ljava/lang/String;)J
    //   152: putfield a : J
    //   155: aload_2
    //   156: aload #4
    //   158: iconst_2
    //   159: invokeinterface getBlob : (I)[B
    //   164: putfield d : [B
    //   167: aload_2
    //   168: aload #4
    //   170: iconst_3
    //   171: invokeinterface getString : (I)Ljava/lang/String;
    //   176: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   179: invokestatic parseInt : (Ljava/lang/String;)I
    //   182: putfield b : I
    //   185: new java/lang/String
    //   188: astore_3
    //   189: aload_3
    //   190: aload_2
    //   191: getfield d : [B
    //   194: ldc 'UTF-8'
    //   196: invokespecial <init> : ([BLjava/lang/String;)V
    //   199: aload_3
    //   200: invokevirtual length : ()I
    //   203: aload_1
    //   204: invokevirtual length : ()I
    //   207: if_icmplt -> 123
    //   210: aload_3
    //   211: ldc '\\r\\n'
    //   213: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   216: astore_3
    //   217: aload_3
    //   218: arraylength
    //   219: iconst_3
    //   220: if_icmplt -> 123
    //   223: new java/lang/StringBuilder
    //   226: astore #5
    //   228: aload #5
    //   230: invokespecial <init> : ()V
    //   233: aload #5
    //   235: aload_3
    //   236: iconst_0
    //   237: aaload
    //   238: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc '\\r\\n'
    //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_3
    //   247: iconst_1
    //   248: aaload
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc '\\r\\n'
    //   254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_3
    //   258: iconst_2
    //   259: aaload
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual toString : ()Ljava/lang/String;
    //   266: aload_1
    //   267: invokevirtual equals : (Ljava/lang/Object;)Z
    //   270: ifeq -> 343
    //   273: aload #4
    //   275: iconst_0
    //   276: invokeinterface getLong : (I)J
    //   281: lstore #10
    //   283: lload #10
    //   285: lstore #7
    //   287: aload #4
    //   289: ifnull -> 55
    //   292: aload #4
    //   294: invokeinterface close : ()V
    //   299: lload #10
    //   301: lstore #7
    //   303: goto -> 55
    //   306: astore_1
    //   307: aload_0
    //   308: monitorexit
    //   309: aload_1
    //   310: athrow
    //   311: astore_3
    //   312: aload #4
    //   314: invokeinterface moveToNext : ()Z
    //   319: pop
    //   320: goto -> 123
    //   323: astore_1
    //   324: aload #4
    //   326: astore_1
    //   327: aload_1
    //   328: ifnull -> 337
    //   331: aload_1
    //   332: invokeinterface close : ()V
    //   337: lconst_0
    //   338: lstore #7
    //   340: goto -> 55
    //   343: aload #4
    //   345: invokeinterface moveToNext : ()Z
    //   350: pop
    //   351: goto -> 123
    //   354: astore_1
    //   355: aload #4
    //   357: ifnull -> 367
    //   360: aload #4
    //   362: invokeinterface close : ()V
    //   367: aload_1
    //   368: athrow
    //   369: aload #4
    //   371: ifnull -> 337
    //   374: aload #4
    //   376: invokeinterface close : ()V
    //   381: goto -> 337
    //   384: astore_1
    //   385: aconst_null
    //   386: astore #4
    //   388: goto -> 355
    //   391: astore_1
    //   392: aconst_null
    //   393: astore_1
    //   394: goto -> 327
    // Exception table:
    //   from	to	target	type
    //   2	21	391	java/lang/Throwable
    //   2	21	384	finally
    //   21	34	323	java/lang/Throwable
    //   21	34	354	finally
    //   45	52	306	finally
    //   60	123	323	java/lang/Throwable
    //   60	123	354	finally
    //   123	132	323	java/lang/Throwable
    //   123	132	354	finally
    //   137	185	311	java/lang/Throwable
    //   137	185	354	finally
    //   185	283	323	java/lang/Throwable
    //   185	283	354	finally
    //   292	299	306	finally
    //   312	320	323	java/lang/Throwable
    //   312	320	354	finally
    //   331	337	306	finally
    //   343	351	323	java/lang/Throwable
    //   343	351	354	finally
    //   360	367	306	finally
    //   367	369	306	finally
    //   374	381	306	finally
  }
  
  private static Map a(byte[] paramArrayOfbyte) {
    Closeable closeable;
    Map<Object, Object> map1 = null;
    Map<Object, Object> map2 = map1;
    if (paramArrayOfbyte != null) {
      if (paramArrayOfbyte.length == 0)
        return map1; 
    } else {
      return map2;
    } 
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
      this(paramArrayOfbyte);
      try {
        closeable = new DataInputStream();
        this(byteArrayInputStream);
        try {
          int i = closeable.readInt();
          for (byte b = 0; b < i; b++) {
            String str1;
            String str2 = closeable.readUTF();
            int j = closeable.readInt();
            if (j == 66) {
              Double double_ = Double.valueOf(closeable.readDouble());
            } else if (j == 88) {
              str1 = closeable.readUTF();
            } else {
              a(byteArrayInputStream);
              a(closeable);
              null = map1;
              // Byte code: goto -> 15
            } 
            hashMap.put(str2, str1);
          } 
          a((Closeable)null);
          a(closeable);
          null = hashMap;
        } catch (Throwable throwable) {
          DataInputStream dataInputStream = (DataInputStream)closeable;
        } finally {}
        a((Closeable)null);
        a(closeable);
        throw paramArrayOfbyte;
      } catch (Throwable throwable) {
      
      } finally {
        closeable = null;
        a((Closeable)null);
        a(closeable);
      } 
      return map1;
    } catch (Throwable throwable) {
      throwable = null;
      map2 = null;
      return map1;
    } finally {
      paramArrayOfbyte = null;
      closeable = null;
    } 
    a((Closeable)map2);
    a(closeable);
    throw paramArrayOfbyte;
  }
  
  private static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
      } catch (Throwable throwable) {} 
  }
  
  private static byte[] a(Map paramMap) {
    int i;
    Closeable closeable;
    if (paramMap == null || paramMap.size() == 0)
      return null; 
    if (paramMap.size() > 50) {
      i = 50;
    } else {
      i = paramMap.size();
    } 
    try {
      Closeable closeable1;
      closeable = new ByteArrayOutputStream();
      this();
      try {
        closeable1 = new DataOutputStream();
        this((OutputStream)closeable);
      } catch (Throwable throwable) {
      
      } finally {
        paramMap = null;
      } 
      a(closeable);
      a(closeable1);
      throw paramMap;
    } catch (Throwable throwable) {
    
    } finally {
      Closeable closeable1 = null;
      closeable = null;
      a(closeable);
      a(closeable1);
    } 
    a(closeable);
    a((Closeable)paramMap);
    paramMap = null;
  }
  
  static bc d() {
    // Byte code:
    //   0: getstatic com/unionpay/sdk/bc.a : Lcom/unionpay/sdk/bc;
    //   3: ifnonnull -> 30
    //   6: ldc com/unionpay/sdk/bc
    //   8: monitorenter
    //   9: getstatic com/unionpay/sdk/bc.a : Lcom/unionpay/sdk/bc;
    //   12: ifnonnull -> 27
    //   15: new com/unionpay/sdk/bc
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/unionpay/sdk/bc.a : Lcom/unionpay/sdk/bc;
    //   27: ldc com/unionpay/sdk/bc
    //   29: monitorexit
    //   30: getstatic com/unionpay/sdk/bc.a : Lcom/unionpay/sdk/bc;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/unionpay/sdk/bc
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
  }
  
  private long e(long paramLong) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 'activity'
    //   10: getstatic com/unionpay/sdk/bc$a.a : [Ljava/lang/String;
    //   13: ldc_w '_id=?'
    //   16: iconst_1
    //   17: anewarray java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: lload_1
    //   23: invokestatic valueOf : (J)Ljava/lang/String;
    //   26: aastore
    //   27: aconst_null
    //   28: aconst_null
    //   29: ldc '_id'
    //   31: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore #4
    //   36: aload #4
    //   38: invokeinterface moveToFirst : ()Z
    //   43: ifeq -> 95
    //   46: aload #4
    //   48: invokeinterface isAfterLast : ()Z
    //   53: ifne -> 95
    //   56: aload #4
    //   58: bipush #6
    //   60: invokeinterface getString : (I)Ljava/lang/String;
    //   65: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic parseLong : (Ljava/lang/String;)J
    //   71: lstore #5
    //   73: lload #5
    //   75: lstore_1
    //   76: aload #4
    //   78: ifnull -> 91
    //   81: aload #4
    //   83: invokeinterface close : ()V
    //   88: lload #5
    //   90: lstore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: lload_1
    //   94: lreturn
    //   95: aload #4
    //   97: ifnull -> 107
    //   100: aload #4
    //   102: invokeinterface close : ()V
    //   107: lconst_0
    //   108: lstore_1
    //   109: goto -> 91
    //   112: astore #4
    //   114: aconst_null
    //   115: astore #4
    //   117: aload #4
    //   119: ifnull -> 107
    //   122: aload #4
    //   124: invokeinterface close : ()V
    //   129: goto -> 107
    //   132: astore #4
    //   134: aload_0
    //   135: monitorexit
    //   136: aload #4
    //   138: athrow
    //   139: astore #4
    //   141: aload_3
    //   142: ifnull -> 151
    //   145: aload_3
    //   146: invokeinterface close : ()V
    //   151: aload #4
    //   153: athrow
    //   154: astore #7
    //   156: aload #4
    //   158: astore_3
    //   159: aload #7
    //   161: astore #4
    //   163: goto -> 141
    //   166: astore_3
    //   167: goto -> 117
    // Exception table:
    //   from	to	target	type
    //   4	36	112	java/lang/Throwable
    //   4	36	139	finally
    //   36	73	166	java/lang/Throwable
    //   36	73	154	finally
    //   81	88	132	finally
    //   100	107	132	finally
    //   122	129	132	finally
    //   145	151	132	finally
    //   151	154	132	finally
  }
  
  private void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   5: ifnull -> 111
    //   8: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   11: ifnonnull -> 138
    //   14: new java/io/File
    //   17: astore_1
    //   18: aload_1
    //   19: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   22: invokevirtual getFilesDir : ()Ljava/io/File;
    //   25: ldc_w 'UPtcagent.db'
    //   28: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   31: aload_1
    //   32: invokevirtual exists : ()Z
    //   35: istore_2
    //   36: aload_1
    //   37: invokevirtual getParentFile : ()Ljava/io/File;
    //   40: invokevirtual exists : ()Z
    //   43: ifne -> 54
    //   46: aload_1
    //   47: invokevirtual getParentFile : ()Ljava/io/File;
    //   50: invokevirtual mkdirs : ()Z
    //   53: pop
    //   54: aload_1
    //   55: aconst_null
    //   56: invokestatic openOrCreateDatabase : (Ljava/io/File;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   59: putstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   62: aload_1
    //   63: invokevirtual length : ()J
    //   66: ldc2_w 6144000
    //   69: lcmp
    //   70: ifle -> 90
    //   73: aload_1
    //   74: invokevirtual length : ()J
    //   77: ldc2_w 8089600
    //   80: lcmp
    //   81: ifle -> 90
    //   84: invokestatic f : ()V
    //   87: invokestatic g : ()V
    //   90: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   93: ldc2_w 8192000
    //   96: invokevirtual setMaximumSize : (J)J
    //   99: pop2
    //   100: iconst_1
    //   101: putstatic com/unionpay/sdk/bc.c : I
    //   104: iload_2
    //   105: ifne -> 114
    //   108: invokestatic g : ()V
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: bipush #6
    //   116: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   119: invokevirtual getVersion : ()I
    //   122: if_icmple -> 111
    //   125: invokestatic f : ()V
    //   128: invokestatic g : ()V
    //   131: goto -> 111
    //   134: astore_1
    //   135: goto -> 111
    //   138: getstatic com/unionpay/sdk/bc.c : I
    //   141: iconst_1
    //   142: iadd
    //   143: putstatic com/unionpay/sdk/bc.c : I
    //   146: goto -> 111
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    // Exception table:
    //   from	to	target	type
    //   2	54	134	java/lang/Throwable
    //   2	54	149	finally
    //   54	90	134	java/lang/Throwable
    //   54	90	149	finally
    //   90	104	134	java/lang/Throwable
    //   90	104	149	finally
    //   108	111	134	java/lang/Throwable
    //   108	111	149	finally
    //   114	131	134	java/lang/Throwable
    //   114	131	149	finally
    //   138	146	134	java/lang/Throwable
    //   138	146	149	finally
  }
  
  private static void f() {
    b.setVersion(6);
    d.b(b);
    a.b(b);
    b.b(b);
    c.b(b);
  }
  
  private static void g() {
    b.setVersion(6);
    d.a(b);
    a.a(b);
    b.a(b);
    c.a(b);
  }
  
  private void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/unionpay/sdk/bc.c : I
    //   5: iconst_1
    //   6: isub
    //   7: putstatic com/unionpay/sdk/bc.c : I
    //   10: iconst_0
    //   11: getstatic com/unionpay/sdk/bc.c : I
    //   14: invokestatic max : (II)I
    //   17: istore_1
    //   18: iload_1
    //   19: putstatic com/unionpay/sdk/bc.c : I
    //   22: iload_1
    //   23: ifne -> 42
    //   26: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   29: ifnull -> 42
    //   32: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   35: invokevirtual close : ()V
    //   38: aconst_null
    //   39: putstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_2
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_2
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	45	finally
    //   26	42	45	finally
  }
  
  final long a(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc_w 'activity'
    //   6: aconst_null
    //   7: ldc_w '_id<=? AND duration !=? '
    //   10: iconst_2
    //   11: anewarray java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: lload_1
    //   17: invokestatic valueOf : (J)Ljava/lang/String;
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc_w '0'
    //   26: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   29: aastore
    //   30: iconst_3
    //   31: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   34: lstore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: lload_1
    //   38: lreturn
    //   39: astore_3
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	39	finally
  }
  
  final long a(long paramLong1, long paramLong2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lload_3
    //   3: aload_0
    //   4: lload_1
    //   5: invokespecial e : (J)J
    //   8: lsub
    //   9: ldc2_w 1000
    //   12: ldiv
    //   13: lstore_3
    //   14: new android/content/ContentValues
    //   17: astore #5
    //   19: aload #5
    //   21: invokespecial <init> : ()V
    //   24: aload #5
    //   26: ldc_w 'duration'
    //   29: lload_3
    //   30: invokestatic valueOf : (J)Ljava/lang/String;
    //   33: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   36: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: ldc_w 'activity'
    //   43: aload #5
    //   45: ldc_w '_id=?'
    //   48: iconst_1
    //   49: anewarray java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: lload_1
    //   55: invokestatic valueOf : (J)Ljava/lang/String;
    //   58: aastore
    //   59: iconst_2
    //   60: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   63: lstore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: lload_1
    //   67: lreturn
    //   68: astore #5
    //   70: aload_0
    //   71: monitorexit
    //   72: aload #5
    //   74: athrow
    // Exception table:
    //   from	to	target	type
    //   2	64	68	finally
  }
  
  final long a(long paramLong, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/content/ContentValues
    //   5: astore #4
    //   7: aload #4
    //   9: invokespecial <init> : ()V
    //   12: aload #4
    //   14: ldc_w 'error_time'
    //   17: lload_1
    //   18: invokestatic valueOf : (J)Ljava/lang/String;
    //   21: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   24: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   27: new com/unionpay/sdk/m$c
    //   30: astore #5
    //   32: aload #5
    //   34: invokespecial <init> : ()V
    //   37: new java/lang/StringBuffer
    //   40: astore #6
    //   42: aload #6
    //   44: ldc_w ''
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: aload_0
    //   51: aload_3
    //   52: aload #5
    //   54: aload #6
    //   56: invokespecial a : (Ljava/lang/String;Lcom/unionpay/sdk/m$c;Ljava/lang/StringBuffer;)J
    //   59: lstore_1
    //   60: lconst_0
    //   61: lload_1
    //   62: lcmp
    //   63: ifne -> 127
    //   66: aload #4
    //   68: ldc_w 'message'
    //   71: aload_3
    //   72: ldc 'UTF-8'
    //   74: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   77: invokevirtual put : (Ljava/lang/String;[B)V
    //   80: aload #4
    //   82: ldc_w 'repeat'
    //   85: iconst_1
    //   86: invokestatic valueOf : (I)Ljava/lang/String;
    //   89: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload #4
    //   97: ldc_w 'shorthashcode'
    //   100: aload #6
    //   102: invokevirtual toString : ()Ljava/lang/String;
    //   105: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_0
    //   112: ldc 'error_report'
    //   114: aload #4
    //   116: aconst_null
    //   117: aconst_null
    //   118: iconst_1
    //   119: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   122: lstore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: lload_1
    //   126: lreturn
    //   127: aload #4
    //   129: ldc_w 'repeat'
    //   132: aload #5
    //   134: getfield b : I
    //   137: iconst_1
    //   138: iadd
    //   139: invokestatic valueOf : (I)Ljava/lang/String;
    //   142: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_0
    //   149: ldc 'error_report'
    //   151: aload #4
    //   153: ldc_w '_id=?'
    //   156: iconst_1
    //   157: anewarray java/lang/String
    //   160: dup
    //   161: iconst_0
    //   162: lload_1
    //   163: invokestatic valueOf : (J)Ljava/lang/String;
    //   166: aastore
    //   167: iconst_2
    //   168: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   171: lstore_1
    //   172: goto -> 123
    //   175: astore_3
    //   176: lconst_0
    //   177: lstore_1
    //   178: goto -> 123
    //   181: astore_3
    //   182: aload_0
    //   183: monitorexit
    //   184: aload_3
    //   185: athrow
    // Exception table:
    //   from	to	target	type
    //   2	50	181	finally
    //   50	60	175	java/lang/Throwable
    //   50	60	181	finally
    //   66	123	175	java/lang/Throwable
    //   66	123	181	finally
    //   127	172	175	java/lang/Throwable
    //   127	172	181	finally
  }
  
  final long a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/content/ContentValues
    //   5: astore_2
    //   6: aload_2
    //   7: invokespecial <init> : ()V
    //   10: aload_2
    //   11: ldc_w 'is_launch'
    //   14: iconst_2
    //   15: invokestatic valueOf : (I)Ljava/lang/String;
    //   18: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   21: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: ldc_w 'session'
    //   28: aload_2
    //   29: ldc_w 'session_id=?'
    //   32: iconst_1
    //   33: anewarray java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   42: aastore
    //   43: iconst_2
    //   44: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   47: lstore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: lload_3
    //   51: lreturn
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	48	52	finally
  }
  
  final long a(String paramString, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/content/ContentValues
    //   5: astore_3
    //   6: aload_3
    //   7: invokespecial <init> : ()V
    //   10: aload_3
    //   11: ldc_w 'duration'
    //   14: iload_2
    //   15: invokestatic valueOf : (I)Ljava/lang/String;
    //   18: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   21: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: ldc_w 'session'
    //   28: aload_3
    //   29: ldc_w 'session_id=?'
    //   32: iconst_1
    //   33: anewarray java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   42: aastore
    //   43: iconst_2
    //   44: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   47: lstore #4
    //   49: aload_0
    //   50: monitorexit
    //   51: lload #4
    //   53: lreturn
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   2	49	54	finally
  }
  
  final long a(String paramString, long paramLong1, long paramLong2, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/content/ContentValues
    //   5: astore #7
    //   7: aload #7
    //   9: invokespecial <init> : ()V
    //   12: aload #7
    //   14: ldc_w 'session_id'
    //   17: aload_1
    //   18: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   21: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload #7
    //   26: ldc_w 'start_time'
    //   29: lload_2
    //   30: invokestatic valueOf : (J)Ljava/lang/String;
    //   33: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   36: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload #7
    //   41: ldc_w 'duration'
    //   44: iconst_0
    //   45: invokestatic valueOf : (I)Ljava/lang/String;
    //   48: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   51: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload #7
    //   56: ldc_w 'is_launch'
    //   59: iconst_0
    //   60: invokestatic valueOf : (I)Ljava/lang/String;
    //   63: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   66: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload #7
    //   71: ldc_w 'interval'
    //   74: lload #4
    //   76: invokestatic valueOf : (J)Ljava/lang/String;
    //   79: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   82: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload #7
    //   87: ldc_w 'is_connected'
    //   90: iload #6
    //   92: invokestatic valueOf : (I)Ljava/lang/String;
    //   95: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   98: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_0
    //   102: ldc_w 'session'
    //   105: aload #7
    //   107: aconst_null
    //   108: aconst_null
    //   109: iconst_1
    //   110: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   113: lstore_2
    //   114: aload_0
    //   115: monitorexit
    //   116: lload_2
    //   117: lreturn
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Exception table:
    //   from	to	target	type
    //   2	114	118	finally
  }
  
  final long a(String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/content/ContentValues
    //   5: astore #8
    //   7: aload #8
    //   9: invokespecial <init> : ()V
    //   12: aload #8
    //   14: ldc_w 'session_id'
    //   17: aload_1
    //   18: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   21: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload #8
    //   26: ldc_w 'name'
    //   29: aload_2
    //   30: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   33: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload #8
    //   38: ldc_w 'start_time'
    //   41: lload_3
    //   42: invokestatic valueOf : (J)Ljava/lang/String;
    //   45: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   48: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload #8
    //   53: ldc_w 'duration'
    //   56: iconst_0
    //   57: invokestatic valueOf : (I)Ljava/lang/String;
    //   60: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   63: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload #8
    //   68: ldc_w 'refer'
    //   71: aload #5
    //   73: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   76: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload #8
    //   81: ldc_w 'realtime'
    //   84: lload #6
    //   86: invokestatic valueOf : (J)Ljava/lang/String;
    //   89: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: ldc_w 'activity'
    //   99: aload #8
    //   101: aconst_null
    //   102: aconst_null
    //   103: iconst_1
    //   104: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   107: lstore_3
    //   108: aload_0
    //   109: monitorexit
    //   110: lload_3
    //   111: lreturn
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Exception table:
    //   from	to	target	type
    //   2	108	112	finally
  }
  
  final long a(String paramString1, String paramString2, String paramString3, long paramLong, Map paramMap) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new android/content/ContentValues
    //   5: astore #7
    //   7: aload #7
    //   9: invokespecial <init> : ()V
    //   12: aload #7
    //   14: ldc_w 'event_id'
    //   17: aload_2
    //   18: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   21: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload #7
    //   26: ldc_w 'event_label'
    //   29: aload_3
    //   30: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   33: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload #7
    //   38: ldc_w 'session_id'
    //   41: aload_1
    //   42: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   45: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload #7
    //   50: ldc_w 'occurtime'
    //   53: lload #4
    //   55: invokestatic valueOf : (J)Ljava/lang/String;
    //   58: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   61: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload #7
    //   66: ldc_w 'paramap'
    //   69: aload #6
    //   71: invokestatic a : (Ljava/util/Map;)[B
    //   74: invokevirtual put : (Ljava/lang/String;[B)V
    //   77: aload_0
    //   78: ldc_w 'app_event'
    //   81: aload #7
    //   83: aconst_null
    //   84: aconst_null
    //   85: iconst_1
    //   86: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   89: lstore #4
    //   91: aload_0
    //   92: monitorexit
    //   93: lload #4
    //   95: lreturn
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Exception table:
    //   from	to	target	type
    //   2	91	96	finally
  }
  
  final long a(List paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface size : ()I
    //   8: istore_2
    //   9: iload_2
    //   10: ifne -> 19
    //   13: lconst_0
    //   14: lstore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_3
    //   18: lreturn
    //   19: iinc #2, -1
    //   22: lconst_0
    //   23: lstore_3
    //   24: iload_2
    //   25: iflt -> 232
    //   28: lload_3
    //   29: lstore #5
    //   31: new java/lang/StringBuilder
    //   34: astore #7
    //   36: lload_3
    //   37: lstore #5
    //   39: aload #7
    //   41: invokespecial <init> : ()V
    //   44: lload_3
    //   45: lstore #5
    //   47: aload #7
    //   49: ldc_w 'SELECT MAX(_id) from activity where duration != 0 and session_id =?'
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aconst_null
    //   57: astore #8
    //   59: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   62: aload #7
    //   64: invokevirtual toString : ()Ljava/lang/String;
    //   67: iconst_1
    //   68: anewarray java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: iload_2
    //   75: invokeinterface get : (I)Ljava/lang/Object;
    //   80: checkcast com/unionpay/sdk/m$j
    //   83: getfield a : Ljava/lang/String;
    //   86: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   89: aastore
    //   90: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   93: astore #7
    //   95: lload_3
    //   96: lstore #9
    //   98: aload #7
    //   100: invokeinterface moveToFirst : ()Z
    //   105: ifeq -> 157
    //   108: aload #7
    //   110: iconst_0
    //   111: invokeinterface getLong : (I)J
    //   116: lstore #5
    //   118: lload #5
    //   120: lconst_0
    //   121: lcmp
    //   122: ifeq -> 153
    //   125: lload #5
    //   127: lstore_3
    //   128: aload #7
    //   130: ifnull -> 15
    //   133: aload #7
    //   135: invokeinterface close : ()V
    //   140: lload #5
    //   142: lstore_3
    //   143: goto -> 15
    //   146: astore_1
    //   147: lload #5
    //   149: lstore_3
    //   150: goto -> 15
    //   153: lload #5
    //   155: lstore #9
    //   157: aload #7
    //   159: ifnull -> 173
    //   162: lload #9
    //   164: lstore #5
    //   166: aload #7
    //   168: invokeinterface close : ()V
    //   173: iinc #2, -1
    //   176: lload #9
    //   178: lstore_3
    //   179: goto -> 24
    //   182: astore #7
    //   184: aload #8
    //   186: astore_1
    //   187: aload #7
    //   189: astore #8
    //   191: aload_1
    //   192: ifnull -> 204
    //   195: lload_3
    //   196: lstore #5
    //   198: aload_1
    //   199: invokeinterface close : ()V
    //   204: lload_3
    //   205: lstore #5
    //   207: aload #8
    //   209: athrow
    //   210: astore_1
    //   211: lload #5
    //   213: lstore_3
    //   214: goto -> 15
    //   217: astore_1
    //   218: aload_0
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: aload_1
    //   224: astore #8
    //   226: aload #7
    //   228: astore_1
    //   229: goto -> 191
    //   232: goto -> 15
    // Exception table:
    //   from	to	target	type
    //   2	9	217	finally
    //   31	36	210	java/lang/Throwable
    //   31	36	217	finally
    //   39	44	210	java/lang/Throwable
    //   39	44	217	finally
    //   47	56	210	java/lang/Throwable
    //   47	56	217	finally
    //   59	95	182	finally
    //   98	118	222	finally
    //   133	140	146	java/lang/Throwable
    //   133	140	217	finally
    //   166	173	210	java/lang/Throwable
    //   166	173	217	finally
    //   198	204	210	java/lang/Throwable
    //   198	204	217	finally
    //   207	210	210	java/lang/Throwable
    //   207	210	217	finally
  }
  
  final void a() {
    e();
  }
  
  final long b(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc_w 'app_event'
    //   6: aconst_null
    //   7: ldc_w '_id<=? '
    //   10: iconst_1
    //   11: anewarray java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: lload_1
    //   17: invokestatic valueOf : (J)Ljava/lang/String;
    //   20: aastore
    //   21: iconst_3
    //   22: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   25: lstore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: lload_1
    //   29: lreturn
    //   30: astore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_3
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	30	finally
  }
  
  final long b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc_w 'session'
    //   6: aconst_null
    //   7: ldc_w 'session_id=?'
    //   10: iconst_1
    //   11: anewarray java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   20: aastore
    //   21: iconst_3
    //   22: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   25: lstore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: lload_2
    //   29: lreturn
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	30	finally
  }
  
  final long b(List paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokeinterface size : ()I
    //   8: istore_2
    //   9: iload_2
    //   10: ifne -> 19
    //   13: lconst_0
    //   14: lstore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_3
    //   18: lreturn
    //   19: iinc #2, -1
    //   22: iload_2
    //   23: iflt -> 133
    //   26: new java/lang/StringBuilder
    //   29: astore #5
    //   31: aload #5
    //   33: invokespecial <init> : ()V
    //   36: aload #5
    //   38: ldc_w 'SELECT MAX(_id) from app_event where session_id =?'
    //   41: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aconst_null
    //   46: astore #6
    //   48: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   51: aload #5
    //   53: invokevirtual toString : ()Ljava/lang/String;
    //   56: iconst_1
    //   57: anewarray java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: iload_2
    //   64: invokeinterface get : (I)Ljava/lang/Object;
    //   69: checkcast com/unionpay/sdk/m$j
    //   72: getfield a : Ljava/lang/String;
    //   75: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   78: aastore
    //   79: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   82: astore #5
    //   84: aload #5
    //   86: invokeinterface moveToFirst : ()Z
    //   91: ifeq -> 138
    //   94: aload #5
    //   96: iconst_0
    //   97: invokeinterface getLong : (I)J
    //   102: lstore #7
    //   104: lload #7
    //   106: lconst_0
    //   107: lcmp
    //   108: ifeq -> 138
    //   111: lload #7
    //   113: lstore_3
    //   114: aload #5
    //   116: ifnull -> 15
    //   119: aload #5
    //   121: invokeinterface close : ()V
    //   126: lload #7
    //   128: lstore_3
    //   129: goto -> 15
    //   132: astore_1
    //   133: lconst_0
    //   134: lstore_3
    //   135: goto -> 15
    //   138: aload #5
    //   140: ifnull -> 150
    //   143: aload #5
    //   145: invokeinterface close : ()V
    //   150: iinc #2, -1
    //   153: goto -> 22
    //   156: astore_1
    //   157: aload #6
    //   159: ifnull -> 169
    //   162: aload #6
    //   164: invokeinterface close : ()V
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload #5
    //   179: astore #6
    //   181: goto -> 157
    // Exception table:
    //   from	to	target	type
    //   2	9	171	finally
    //   26	45	132	java/lang/Throwable
    //   26	45	171	finally
    //   48	84	156	finally
    //   84	104	176	finally
    //   119	126	132	java/lang/Throwable
    //   119	126	171	finally
    //   143	150	132	java/lang/Throwable
    //   143	150	171	finally
    //   162	169	132	java/lang/Throwable
    //   162	169	171	finally
    //   169	171	132	java/lang/Throwable
    //   169	171	171	finally
  }
  
  final void b() {
    h();
  }
  
  final long c(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 'error_report'
    //   5: aconst_null
    //   6: ldc_w '_id<=?'
    //   9: iconst_1
    //   10: anewarray java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: lload_1
    //   16: invokestatic valueOf : (J)Ljava/lang/String;
    //   19: aastore
    //   20: iconst_3
    //   21: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   24: lstore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: lload_1
    //   28: lreturn
    //   29: astore_3
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_3
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	29	finally
  }
  
  final long c(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc_w 'activity'
    //   6: aconst_null
    //   7: ldc_w 'session_id=? '
    //   10: iconst_1
    //   11: anewarray java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   20: aastore
    //   21: iconst_3
    //   22: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   25: lstore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: lload_2
    //   29: lreturn
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	30	finally
  }
  
  final List c() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: new java/util/ArrayList
    //   7: astore_2
    //   8: aload_2
    //   9: invokespecial <init> : ()V
    //   12: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   15: ldc_w 'session'
    //   18: getstatic com/unionpay/sdk/bc$d.a : [Ljava/lang/String;
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: ldc '_id'
    //   27: ldc_w '10'
    //   30: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_3
    //   34: aload_3
    //   35: invokeinterface moveToFirst : ()Z
    //   40: ifeq -> 319
    //   43: aload_3
    //   44: invokeinterface isAfterLast : ()Z
    //   49: ifne -> 319
    //   52: new com/unionpay/sdk/m$j
    //   55: astore #4
    //   57: aload #4
    //   59: invokespecial <init> : ()V
    //   62: aload #4
    //   64: aload_3
    //   65: iconst_1
    //   66: invokeinterface getString : (I)Ljava/lang/String;
    //   71: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   74: putfield a : Ljava/lang/String;
    //   77: aload #4
    //   79: aload_3
    //   80: iconst_2
    //   81: invokeinterface getString : (I)Ljava/lang/String;
    //   86: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic parseLong : (Ljava/lang/String;)J
    //   92: putfield b : J
    //   95: aload #4
    //   97: aload_3
    //   98: iconst_3
    //   99: invokeinterface getString : (I)Ljava/lang/String;
    //   104: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic parseInt : (Ljava/lang/String;)I
    //   110: putfield d : I
    //   113: aload_3
    //   114: iconst_4
    //   115: invokeinterface getString : (I)Ljava/lang/String;
    //   120: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull -> 259
    //   128: aload_1
    //   129: ldc_w 'null'
    //   132: invokevirtual equals : (Ljava/lang/Object;)Z
    //   135: ifne -> 259
    //   138: aload_1
    //   139: invokestatic parseInt : (Ljava/lang/String;)I
    //   142: ifne -> 259
    //   145: aload #4
    //   147: iconst_1
    //   148: putfield c : I
    //   151: iconst_1
    //   152: aload #4
    //   154: getfield c : I
    //   157: if_icmpne -> 206
    //   160: aload #4
    //   162: aload_3
    //   163: iconst_5
    //   164: invokeinterface getString : (I)Ljava/lang/String;
    //   169: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   172: invokestatic parseInt : (Ljava/lang/String;)I
    //   175: putfield g : I
    //   178: aload #4
    //   180: getfield g : I
    //   183: ifge -> 192
    //   186: aload #4
    //   188: iconst_0
    //   189: putfield g : I
    //   192: aload #4
    //   194: aload #4
    //   196: getfield g : I
    //   199: sipush #1000
    //   202: idiv
    //   203: putfield d : I
    //   206: aload #4
    //   208: aload_3
    //   209: bipush #6
    //   211: invokeinterface getString : (I)Ljava/lang/String;
    //   216: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic parseInt : (Ljava/lang/String;)I
    //   222: putfield h : I
    //   225: aload_2
    //   226: aload #4
    //   228: invokeinterface add : (Ljava/lang/Object;)Z
    //   233: pop
    //   234: aload_3
    //   235: invokeinterface moveToNext : ()Z
    //   240: pop
    //   241: goto -> 43
    //   244: astore_1
    //   245: aload_3
    //   246: ifnull -> 255
    //   249: aload_3
    //   250: invokeinterface close : ()V
    //   255: aload_0
    //   256: monitorexit
    //   257: aload_2
    //   258: areturn
    //   259: aload #4
    //   261: getfield d : I
    //   264: ifeq -> 313
    //   267: iconst_3
    //   268: istore #5
    //   270: aload #4
    //   272: iload #5
    //   274: putfield c : I
    //   277: goto -> 151
    //   280: astore_1
    //   281: aload_3
    //   282: invokeinterface moveToNext : ()Z
    //   287: pop
    //   288: goto -> 43
    //   291: astore_2
    //   292: aload_3
    //   293: astore_1
    //   294: aload_2
    //   295: astore_3
    //   296: aload_1
    //   297: ifnull -> 306
    //   300: aload_1
    //   301: invokeinterface close : ()V
    //   306: aload_3
    //   307: athrow
    //   308: astore_3
    //   309: aload_0
    //   310: monitorexit
    //   311: aload_3
    //   312: athrow
    //   313: iconst_2
    //   314: istore #5
    //   316: goto -> 270
    //   319: aload_3
    //   320: ifnull -> 255
    //   323: aload_3
    //   324: invokeinterface close : ()V
    //   329: goto -> 255
    //   332: astore_3
    //   333: goto -> 296
    //   336: astore_3
    //   337: aconst_null
    //   338: astore_3
    //   339: goto -> 245
    // Exception table:
    //   from	to	target	type
    //   4	12	308	finally
    //   12	34	336	java/lang/Throwable
    //   12	34	332	finally
    //   34	43	244	java/lang/Throwable
    //   34	43	291	finally
    //   43	62	244	java/lang/Throwable
    //   43	62	291	finally
    //   62	124	280	java/lang/Throwable
    //   62	124	291	finally
    //   128	151	280	java/lang/Throwable
    //   128	151	291	finally
    //   151	192	244	java/lang/Throwable
    //   151	192	291	finally
    //   192	206	244	java/lang/Throwable
    //   192	206	291	finally
    //   206	241	244	java/lang/Throwable
    //   206	241	291	finally
    //   249	255	308	finally
    //   259	267	280	java/lang/Throwable
    //   259	267	291	finally
    //   270	277	280	java/lang/Throwable
    //   270	277	291	finally
    //   281	288	244	java/lang/Throwable
    //   281	288	291	finally
    //   300	306	308	finally
    //   306	308	308	finally
    //   323	329	308	finally
  }
  
  final List d(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: astore_3
    //   6: aload_3
    //   7: invokespecial <init> : ()V
    //   10: aconst_null
    //   11: astore #4
    //   13: new java/lang/StringBuilder
    //   16: astore #5
    //   18: aload #5
    //   20: invokespecial <init> : ()V
    //   23: aload #5
    //   25: ldc_w 'SELECT error_time,message,repeat, shorthashcode from error_report where _id<=?'
    //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   35: aload #5
    //   37: invokevirtual toString : ()Ljava/lang/String;
    //   40: iconst_1
    //   41: anewarray java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: lload_1
    //   47: invokestatic valueOf : (J)Ljava/lang/String;
    //   50: aastore
    //   51: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore #5
    //   56: aload #5
    //   58: astore #4
    //   60: aload #4
    //   62: invokeinterface moveToFirst : ()Z
    //   67: ifeq -> 284
    //   70: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   73: ifnull -> 239
    //   76: invokestatic h : ()I
    //   79: invokestatic valueOf : (I)Ljava/lang/String;
    //   82: astore #5
    //   84: aload #4
    //   86: invokeinterface isAfterLast : ()Z
    //   91: ifne -> 284
    //   94: new com/unionpay/sdk/m$i
    //   97: astore #6
    //   99: aload #6
    //   101: invokespecial <init> : ()V
    //   104: aload #6
    //   106: iconst_3
    //   107: putfield a : I
    //   110: new com/unionpay/sdk/m$c
    //   113: astore #7
    //   115: aload #7
    //   117: invokespecial <init> : ()V
    //   120: aload #7
    //   122: aload #4
    //   124: iconst_0
    //   125: invokeinterface getString : (I)Ljava/lang/String;
    //   130: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   133: invokestatic parseLong : (Ljava/lang/String;)J
    //   136: putfield a : J
    //   139: aload #7
    //   141: aload #4
    //   143: iconst_1
    //   144: invokeinterface getBlob : (I)[B
    //   149: putfield d : [B
    //   152: aload #7
    //   154: aload #4
    //   156: iconst_2
    //   157: invokeinterface getString : (I)Ljava/lang/String;
    //   162: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   165: invokestatic parseInt : (Ljava/lang/String;)I
    //   168: putfield b : I
    //   171: aload #7
    //   173: aload #4
    //   175: iconst_3
    //   176: invokeinterface getString : (I)Ljava/lang/String;
    //   181: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   184: putfield e : Ljava/lang/String;
    //   187: aload #7
    //   189: aload #5
    //   191: putfield c : Ljava/lang/String;
    //   194: aload #6
    //   196: aload #7
    //   198: putfield d : Lcom/unionpay/sdk/m$c;
    //   201: aload_3
    //   202: aload #6
    //   204: invokeinterface add : (Ljava/lang/Object;)Z
    //   209: pop
    //   210: aload #4
    //   212: invokeinterface moveToNext : ()Z
    //   217: pop
    //   218: goto -> 84
    //   221: astore #5
    //   223: aload #4
    //   225: ifnull -> 235
    //   228: aload #4
    //   230: invokeinterface close : ()V
    //   235: aload_0
    //   236: monitorexit
    //   237: aload_3
    //   238: areturn
    //   239: ldc_w ''
    //   242: astore #5
    //   244: goto -> 84
    //   247: astore #7
    //   249: aload #4
    //   251: invokeinterface moveToNext : ()Z
    //   256: pop
    //   257: goto -> 84
    //   260: astore #5
    //   262: aload #4
    //   264: ifnull -> 274
    //   267: aload #4
    //   269: invokeinterface close : ()V
    //   274: aload #5
    //   276: athrow
    //   277: astore #4
    //   279: aload_0
    //   280: monitorexit
    //   281: aload #4
    //   283: athrow
    //   284: aload #4
    //   286: ifnull -> 235
    //   289: aload #4
    //   291: invokeinterface close : ()V
    //   296: goto -> 235
    //   299: astore #5
    //   301: aconst_null
    //   302: astore #4
    //   304: goto -> 262
    //   307: astore #5
    //   309: goto -> 223
    // Exception table:
    //   from	to	target	type
    //   2	10	277	finally
    //   13	56	307	java/lang/Throwable
    //   13	56	299	finally
    //   60	84	221	java/lang/Throwable
    //   60	84	260	finally
    //   84	104	221	java/lang/Throwable
    //   84	104	260	finally
    //   104	201	247	java/lang/Throwable
    //   104	201	260	finally
    //   201	218	221	java/lang/Throwable
    //   201	218	260	finally
    //   228	235	277	finally
    //   249	257	221	java/lang/Throwable
    //   249	257	260	finally
    //   267	274	277	finally
    //   274	277	277	finally
    //   289	296	277	finally
  }
  
  final List d(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new java/util/ArrayList
    //   7: astore_3
    //   8: aload_3
    //   9: invokespecial <init> : ()V
    //   12: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   15: ldc_w 'activity'
    //   18: getstatic com/unionpay/sdk/bc$a.a : [Ljava/lang/String;
    //   21: ldc_w 'session_id=? AND duration !=? '
    //   24: iconst_2
    //   25: anewarray java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc_w '0'
    //   40: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   43: aastore
    //   44: aconst_null
    //   45: aconst_null
    //   46: ldc '_id'
    //   48: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore_1
    //   52: aload_1
    //   53: invokeinterface moveToFirst : ()Z
    //   58: ifeq -> 206
    //   61: aload_1
    //   62: invokeinterface isAfterLast : ()Z
    //   67: ifne -> 206
    //   70: new com/unionpay/sdk/m$a
    //   73: astore_2
    //   74: aload_2
    //   75: invokespecial <init> : ()V
    //   78: aload_2
    //   79: aload_1
    //   80: iconst_1
    //   81: invokeinterface getString : (I)Ljava/lang/String;
    //   86: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   89: putfield a : Ljava/lang/String;
    //   92: aload_2
    //   93: aload_1
    //   94: iconst_2
    //   95: invokeinterface getString : (I)Ljava/lang/String;
    //   100: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   103: invokestatic parseLong : (Ljava/lang/String;)J
    //   106: putfield b : J
    //   109: aload_2
    //   110: aload_1
    //   111: iconst_3
    //   112: invokeinterface getString : (I)Ljava/lang/String;
    //   117: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   120: invokestatic parseInt : (Ljava/lang/String;)I
    //   123: putfield c : I
    //   126: aload_2
    //   127: aload_1
    //   128: iconst_5
    //   129: invokeinterface getString : (I)Ljava/lang/String;
    //   134: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   137: putfield d : Ljava/lang/String;
    //   140: aload_3
    //   141: aload_2
    //   142: invokeinterface add : (Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload_1
    //   149: invokeinterface moveToNext : ()Z
    //   154: pop
    //   155: goto -> 61
    //   158: astore_2
    //   159: aload_1
    //   160: ifnull -> 169
    //   163: aload_1
    //   164: invokeinterface close : ()V
    //   169: aload_0
    //   170: monitorexit
    //   171: aload_3
    //   172: areturn
    //   173: astore_2
    //   174: aload_1
    //   175: invokeinterface moveToNext : ()Z
    //   180: pop
    //   181: goto -> 61
    //   184: astore_3
    //   185: aload_1
    //   186: astore_2
    //   187: aload_3
    //   188: astore_1
    //   189: aload_2
    //   190: ifnull -> 199
    //   193: aload_2
    //   194: invokeinterface close : ()V
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    //   206: aload_1
    //   207: ifnull -> 169
    //   210: aload_1
    //   211: invokeinterface close : ()V
    //   216: goto -> 169
    //   219: astore_1
    //   220: goto -> 189
    //   223: astore_1
    //   224: aconst_null
    //   225: astore_1
    //   226: goto -> 159
    // Exception table:
    //   from	to	target	type
    //   4	12	201	finally
    //   12	52	223	java/lang/Throwable
    //   12	52	219	finally
    //   52	61	158	java/lang/Throwable
    //   52	61	184	finally
    //   61	78	158	java/lang/Throwable
    //   61	78	184	finally
    //   78	140	173	java/lang/Throwable
    //   78	140	184	finally
    //   140	155	158	java/lang/Throwable
    //   140	155	184	finally
    //   163	169	201	finally
    //   174	181	158	java/lang/Throwable
    //   174	181	184	finally
    //   193	199	201	finally
    //   199	201	201	finally
    //   210	216	201	finally
  }
  
  final long e(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc_w 'app_event'
    //   6: aconst_null
    //   7: ldc_w 'session_id=? '
    //   10: iconst_1
    //   11: anewarray java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   20: aastore
    //   21: iconst_3
    //   22: invokespecial a : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;I)J
    //   25: lstore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: lload_2
    //   29: lreturn
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	30	finally
  }
  
  final List f(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new java/util/ArrayList
    //   7: astore_3
    //   8: aload_3
    //   9: invokespecial <init> : ()V
    //   12: aload_2
    //   13: astore #4
    //   15: new java/lang/StringBuilder
    //   18: astore #5
    //   20: aload_2
    //   21: astore #4
    //   23: aload #5
    //   25: invokespecial <init> : ()V
    //   28: aload_2
    //   29: astore #4
    //   31: aload #5
    //   33: ldc_w 'SELECT COUNT(_id), MAX(occurtime), event_id, event_label, paramap from app_event where session_id = ? group by event_id, event_label, paramap'
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_2
    //   41: astore #4
    //   43: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   46: aload #5
    //   48: invokevirtual toString : ()Ljava/lang/String;
    //   51: iconst_1
    //   52: anewarray java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: aload_1
    //   58: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   61: aastore
    //   62: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore_1
    //   66: aload_1
    //   67: astore #4
    //   69: aload_1
    //   70: invokeinterface moveToFirst : ()Z
    //   75: ifeq -> 255
    //   78: aload_1
    //   79: astore #4
    //   81: aload_1
    //   82: invokeinterface isAfterLast : ()Z
    //   87: ifne -> 255
    //   90: aload_1
    //   91: astore #4
    //   93: new com/unionpay/sdk/m$b
    //   96: astore_2
    //   97: aload_1
    //   98: astore #4
    //   100: aload_2
    //   101: invokespecial <init> : ()V
    //   104: aload_2
    //   105: aload_1
    //   106: iconst_0
    //   107: invokeinterface getInt : (I)I
    //   112: putfield c : I
    //   115: aload_2
    //   116: aload_1
    //   117: iconst_1
    //   118: invokeinterface getString : (I)Ljava/lang/String;
    //   123: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   126: invokestatic parseLong : (Ljava/lang/String;)J
    //   129: putfield d : J
    //   132: aload_2
    //   133: aload_1
    //   134: iconst_2
    //   135: invokeinterface getString : (I)Ljava/lang/String;
    //   140: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   143: putfield a : Ljava/lang/String;
    //   146: aload_2
    //   147: aload_1
    //   148: iconst_3
    //   149: invokeinterface getString : (I)Ljava/lang/String;
    //   154: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   157: putfield b : Ljava/lang/String;
    //   160: aload_2
    //   161: aconst_null
    //   162: putfield e : Ljava/util/Map;
    //   165: aload_2
    //   166: aload_1
    //   167: iconst_4
    //   168: invokeinterface getBlob : (I)[B
    //   173: invokestatic a : ([B)Ljava/util/Map;
    //   176: putfield e : Ljava/util/Map;
    //   179: aload_1
    //   180: astore #4
    //   182: aload_3
    //   183: aload_2
    //   184: invokeinterface add : (Ljava/lang/Object;)Z
    //   189: pop
    //   190: aload_1
    //   191: astore #4
    //   193: aload_1
    //   194: invokeinterface moveToNext : ()Z
    //   199: pop
    //   200: goto -> 78
    //   203: astore_1
    //   204: aload #4
    //   206: ifnull -> 216
    //   209: aload #4
    //   211: invokeinterface close : ()V
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_3
    //   219: areturn
    //   220: astore #4
    //   222: aload_1
    //   223: astore #4
    //   225: aload_1
    //   226: invokeinterface moveToNext : ()Z
    //   231: pop
    //   232: goto -> 78
    //   235: astore #4
    //   237: aload_1
    //   238: ifnull -> 247
    //   241: aload_1
    //   242: invokeinterface close : ()V
    //   247: aload #4
    //   249: athrow
    //   250: astore_1
    //   251: aload_0
    //   252: monitorexit
    //   253: aload_1
    //   254: athrow
    //   255: aload_1
    //   256: ifnull -> 216
    //   259: aload_1
    //   260: invokeinterface close : ()V
    //   265: goto -> 216
    //   268: astore #4
    //   270: aconst_null
    //   271: astore_1
    //   272: goto -> 237
    // Exception table:
    //   from	to	target	type
    //   4	12	250	finally
    //   15	20	203	java/lang/Throwable
    //   15	20	268	finally
    //   23	28	203	java/lang/Throwable
    //   23	28	268	finally
    //   31	40	203	java/lang/Throwable
    //   31	40	268	finally
    //   43	66	203	java/lang/Throwable
    //   43	66	268	finally
    //   69	78	203	java/lang/Throwable
    //   69	78	235	finally
    //   81	90	203	java/lang/Throwable
    //   81	90	235	finally
    //   93	97	203	java/lang/Throwable
    //   93	97	235	finally
    //   100	104	203	java/lang/Throwable
    //   100	104	235	finally
    //   104	179	220	java/lang/Throwable
    //   104	179	235	finally
    //   182	190	203	java/lang/Throwable
    //   182	190	235	finally
    //   193	200	203	java/lang/Throwable
    //   193	200	235	finally
    //   209	216	250	finally
    //   225	232	203	java/lang/Throwable
    //   225	232	235	finally
    //   241	247	250	finally
    //   247	250	250	finally
    //   259	265	250	finally
  }
  
  final long g(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new java/lang/StringBuilder
    //   7: astore_3
    //   8: aload_3
    //   9: invokespecial <init> : ()V
    //   12: aload_3
    //   13: ldc_w 'SELECT MAX(_id) from '
    //   16: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_3
    //   21: aload_1
    //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: getstatic com/unionpay/sdk/bc.b : Landroid/database/sqlite/SQLiteDatabase;
    //   29: aload_3
    //   30: invokevirtual toString : ()Ljava/lang/String;
    //   33: aconst_null
    //   34: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_1
    //   38: aload_1
    //   39: invokeinterface moveToFirst : ()Z
    //   44: ifeq -> 88
    //   47: aload_1
    //   48: invokeinterface isAfterLast : ()Z
    //   53: ifne -> 88
    //   56: aload_1
    //   57: iconst_0
    //   58: invokeinterface getLong : (I)J
    //   63: lstore #4
    //   65: lload #4
    //   67: lstore #6
    //   69: aload_1
    //   70: ifnull -> 83
    //   73: aload_1
    //   74: invokeinterface close : ()V
    //   79: lload #4
    //   81: lstore #6
    //   83: aload_0
    //   84: monitorexit
    //   85: lload #6
    //   87: lreturn
    //   88: aload_1
    //   89: ifnull -> 98
    //   92: aload_1
    //   93: invokeinterface close : ()V
    //   98: lconst_0
    //   99: lstore #6
    //   101: goto -> 83
    //   104: astore_1
    //   105: aload_2
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull -> 98
    //   111: aload_1
    //   112: invokeinterface close : ()V
    //   117: goto -> 98
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull -> 138
    //   132: aload_1
    //   133: invokeinterface close : ()V
    //   138: aload_2
    //   139: athrow
    //   140: astore_2
    //   141: goto -> 128
    //   144: astore_2
    //   145: goto -> 107
    // Exception table:
    //   from	to	target	type
    //   4	38	104	java/lang/Throwable
    //   4	38	125	finally
    //   38	65	144	java/lang/Throwable
    //   38	65	140	finally
    //   73	79	120	finally
    //   92	98	120	finally
    //   111	117	120	finally
    //   132	138	120	finally
    //   138	140	120	finally
  }
  
  static final class a implements BaseColumns {
    static final String[] a = new String[] { "_id", "name", "start_time", "duration", "session_id", "refer", "realtime" };
    
    static final void a(SQLiteDatabase param1SQLiteDatabase) {
      param1SQLiteDatabase.execSQL("CREATE TABLE activity (_id INTEGER PRIMARY KEY autoincrement,name TEXT,start_time LONG,duration INTEGER,session_id TEXT,refer TEXT,realtime LONG)");
    }
    
    static final void b(SQLiteDatabase param1SQLiteDatabase) {
      param1SQLiteDatabase.execSQL("DROP TABLE IF EXISTS activity");
    }
  }
  
  static final class b implements BaseColumns {
    static final String[] a = new String[] { "_id", "event_id", "event_label", "session_id", "occurtime", "paramap" };
    
    static final void a(SQLiteDatabase param1SQLiteDatabase) {
      param1SQLiteDatabase.execSQL("CREATE TABLE app_event (_id INTEGER PRIMARY KEY autoincrement,event_id TEXT,event_label TEXT,session_id TEXT,occurtime LONG,paramap BLOB)");
    }
    
    static final void b(SQLiteDatabase param1SQLiteDatabase) {
      param1SQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_event");
    }
  }
  
  static final class c implements BaseColumns {
    static final String[] a = new String[] { "_id", "error_time", "message", "repeat", "shorthashcode" };
    
    static final void a(SQLiteDatabase param1SQLiteDatabase) {
      param1SQLiteDatabase.execSQL("CREATE TABLE error_report (_id INTEGER PRIMARY KEY autoincrement,error_time LONG,message BLOB,repeat INTERGER,shorthashcode TEXT)");
    }
    
    static final void b(SQLiteDatabase param1SQLiteDatabase) {
      param1SQLiteDatabase.execSQL("DROP TABLE IF EXISTS error_report");
    }
  }
  
  static final class d implements BaseColumns {
    static final String[] a = new String[] { "_id", "session_id", "start_time", "duration", "is_launch", "interval", "is_connected" };
    
    static final void a(SQLiteDatabase param1SQLiteDatabase) {
      param1SQLiteDatabase.execSQL("CREATE TABLE session (_id INTEGER PRIMARY KEY autoincrement,session_id TEXT,start_time LONG,duration INTEGER,is_launch INTEGER,interval LONG, is_connected INTEGER)");
    }
    
    static final void b(SQLiteDatabase param1SQLiteDatabase) {
      param1SQLiteDatabase.execSQL("DROP TABLE IF EXISTS session");
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */