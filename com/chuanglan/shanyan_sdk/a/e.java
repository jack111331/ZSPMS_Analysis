package com.chuanglan.shanyan_sdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.chuanglan.shanyan_sdk.tool.c;
import com.chuanglan.shanyan_sdk.tool.d;
import java.util.ArrayList;
import java.util.List;

public class e implements d {
  private f a;
  
  private long b;
  
  private boolean c;
  
  public e(Context paramContext) {
    this.a = f.a(paramContext);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 10
    //   6: aload_1
    //   7: invokevirtual close : ()V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   6	10	13	finally
  }
  
  private void a(c paramc, long paramLong1, long paramLong2, int paramInt, SQLiteDatabase paramSQLiteDatabase) {
    try {
      ContentValues contentValues = new ContentValues();
      this();
      contentValues.put("count", Integer.valueOf(paramc.v + 1));
      contentValues.put("costTime", Long.valueOf(paramc.o + paramLong1));
      contentValues.put("stepTime", Long.valueOf(paramc.p + paramLong2));
      StringBuilder stringBuilder = new StringBuilder();
      this();
      paramSQLiteDatabase.update("report_behavior", contentValues, "id=?", new String[] { stringBuilder.append("").append(paramInt).toString() });
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void a(String paramString, long paramLong1, long paramLong2, SQLiteDatabase paramSQLiteDatabase) {
    int i = 0;
    try {
      ArrayList<c> arrayList = new ArrayList();
      this();
      String str = String.valueOf(paramString);
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Cursor cursor = paramSQLiteDatabase.rawQuery(stringBuilder.append("select * from report_behavior where sid = '").append(str).append("'").toString(), null);
      if (cursor.moveToLast()) {
        c c = new c();
        this();
        c.a = cursor.getString(cursor.getColumnIndex("DID"));
        c.b = cursor.getString(cursor.getColumnIndex("telcom"));
        c.c = cursor.getString(cursor.getColumnIndex("sdkMode"));
        c.d = cursor.getString(cursor.getColumnIndex("osVersion"));
        c.e = cursor.getString(cursor.getColumnIndex("romVersion"));
        c.f = cursor.getString(cursor.getColumnIndex("sdkVersion"));
        c.g = cursor.getString(cursor.getColumnIndex("uuid"));
        c.h = cursor.getString(cursor.getColumnIndex("ip"));
        c.i = cursor.getString(cursor.getColumnIndex("network"));
        c.j = cursor.getString(cursor.getColumnIndex("dbm"));
        c.k = cursor.getString(cursor.getColumnIndex("wifidbm"));
        c.l = cursor.getString(cursor.getColumnIndex("processName"));
        c.m = cursor.getString(cursor.getColumnIndex("method"));
        c.n = cursor.getString(cursor.getColumnIndex("beginTime"));
        c.o = cursor.getLong(cursor.getColumnIndex("costTime"));
        c.p = cursor.getLong(cursor.getColumnIndex("stepTime"));
        c.q = cursor.getString(cursor.getColumnIndex("status"));
        c.r = cursor.getString(cursor.getColumnIndex("resCode"));
        c.s = cursor.getString(cursor.getColumnIndex("resDesc"));
        c.t = cursor.getString(cursor.getColumnIndex("innerCode"));
        c.u = cursor.getString(cursor.getColumnIndex("innerDesc"));
        c.v = cursor.getInt(cursor.getColumnIndex("count"));
        c.w = cursor.getString(cursor.getColumnIndex("sid"));
        arrayList.add(c);
        i = cursor.getInt(cursor.getColumnIndex("id"));
      } 
      cursor.close();
      if (arrayList != null && arrayList.size() > 0) {
        a(arrayList.get(0), paramLong1, paramLong2, i, paramSQLiteDatabase);
        this.c = false;
        return;
      } 
      this.c = true;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private SQLiteDatabase d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/chuanglan/shanyan_sdk/a/f;
    //   6: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public List<d> a() {
    SQLiteDatabase sQLiteDatabase;
    try {
      Exception exception;
      sQLiteDatabase = d();
      try {
        Cursor cursor = sQLiteDatabase.query("report_device", null, null, null, null, null, "DID ASC", null);
        ArrayList<d> arrayList = new ArrayList();
        this();
        while (cursor.moveToNext()) {
          d d1 = new d();
          this();
          d1.a = cursor.getString(cursor.getColumnIndex("DID"));
          d1.b = cursor.getString(cursor.getColumnIndex("IMEI"));
          d1.c = cursor.getString(cursor.getColumnIndex("IMSI"));
          d1.d = cursor.getString(cursor.getColumnIndex("ICCID"));
          d1.e = cursor.getString(cursor.getColumnIndex("MAC"));
          d1.f = cursor.getString(cursor.getColumnIndex("appPlatform"));
          d1.g = cursor.getString(cursor.getColumnIndex("device"));
          d1.h = cursor.getString(cursor.getColumnIndex("deviceName"));
          arrayList.add(d1);
        } 
        return arrayList;
      } catch (Exception null) {
        try {
          return null;
        } finally {}
      } finally {}
      a(sQLiteDatabase);
      throw exception;
    } catch (Exception exception) {
    
    } finally {
      sQLiteDatabase = null;
      a(sQLiteDatabase);
    } 
    try {
      SYNTHETIC_LOCAL_VARIABLE_3.printStackTrace();
      a(sQLiteDatabase);
      return null;
    } finally {
      Exception exception;
    } 
  }
  
  public List<c> a(String paramString) {
    try {
      Exception exception1;
      Exception exception2;
      SQLiteDatabase sQLiteDatabase = d();
      try {
        Cursor cursor = sQLiteDatabase.query("report_behavior", null, null, null, null, null, "id ASC", paramString);
        ArrayList<c> arrayList = new ArrayList();
        return arrayList;
      } catch (Exception exception) {
        SQLiteDatabase sQLiteDatabase1 = sQLiteDatabase;
      } finally {
        Exception exception = null;
        exception1 = exception2;
      } 
      a((SQLiteDatabase)exception1);
      throw exception2;
    } catch (Exception exception) {
    
    } finally {
      paramString = null;
      a((SQLiteDatabase)paramString);
    } 
    try {
      SYNTHETIC_LOCAL_VARIABLE_2.printStackTrace();
      a((SQLiteDatabase)paramString);
      return null;
    } finally {
      Exception exception;
    } 
  }
  
  public void a(long paramLong) {
    SQLiteDatabase sQLiteDatabase = null;
    null = null;
    try {
      SQLiteDatabase sQLiteDatabase1 = d();
      null = sQLiteDatabase1;
      sQLiteDatabase = sQLiteDatabase1;
      sQLiteDatabase1.delete("report_behavior", "id <= ?", new String[] { String.valueOf(paramLong) });
      return;
    } catch (Exception exception) {
      sQLiteDatabase = null;
      exception.printStackTrace();
      return;
    } finally {
      a(sQLiteDatabase);
    } 
  }
  
  public void a(c paramc, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aconst_null
    //   6: astore #5
    //   8: aload_1
    //   9: ifnull -> 551
    //   12: aload #4
    //   14: astore #5
    //   16: aload_0
    //   17: invokespecial d : ()Landroid/database/sqlite/SQLiteDatabase;
    //   20: astore #4
    //   22: aload #4
    //   24: astore_3
    //   25: aload #4
    //   27: astore #5
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield c : Z
    //   34: iload_2
    //   35: ifeq -> 63
    //   38: aload #4
    //   40: astore_3
    //   41: aload #4
    //   43: astore #5
    //   45: aload_0
    //   46: aload_1
    //   47: getfield w : Ljava/lang/String;
    //   50: aload_1
    //   51: getfield o : J
    //   54: aload_1
    //   55: getfield o : J
    //   58: aload #4
    //   60: invokespecial a : (Ljava/lang/String;JJLandroid/database/sqlite/SQLiteDatabase;)V
    //   63: aload #4
    //   65: astore_3
    //   66: aload #4
    //   68: astore #5
    //   70: aload_0
    //   71: getfield c : Z
    //   74: ifne -> 85
    //   77: aload #4
    //   79: astore #5
    //   81: iload_2
    //   82: ifne -> 551
    //   85: aload #4
    //   87: astore_3
    //   88: aload #4
    //   90: astore #5
    //   92: new android/content/ContentValues
    //   95: astore #6
    //   97: aload #4
    //   99: astore_3
    //   100: aload #4
    //   102: astore #5
    //   104: aload #6
    //   106: invokespecial <init> : ()V
    //   109: aload #4
    //   111: astore_3
    //   112: aload #4
    //   114: astore #5
    //   116: aload #6
    //   118: ldc 'DID'
    //   120: aload_1
    //   121: getfield a : Ljava/lang/String;
    //   124: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload #4
    //   129: astore_3
    //   130: aload #4
    //   132: astore #5
    //   134: aload #6
    //   136: ldc 'telcom'
    //   138: aload_1
    //   139: getfield b : Ljava/lang/String;
    //   142: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload #4
    //   147: astore_3
    //   148: aload #4
    //   150: astore #5
    //   152: aload #6
    //   154: ldc 'sdkMode'
    //   156: aload_1
    //   157: getfield c : Ljava/lang/String;
    //   160: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload #4
    //   165: astore_3
    //   166: aload #4
    //   168: astore #5
    //   170: aload #6
    //   172: ldc 'osVersion'
    //   174: aload_1
    //   175: getfield d : Ljava/lang/String;
    //   178: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload #4
    //   183: astore_3
    //   184: aload #4
    //   186: astore #5
    //   188: aload #6
    //   190: ldc 'romVersion'
    //   192: aload_1
    //   193: getfield e : Ljava/lang/String;
    //   196: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload #4
    //   201: astore_3
    //   202: aload #4
    //   204: astore #5
    //   206: aload #6
    //   208: ldc 'sdkVersion'
    //   210: aload_1
    //   211: getfield f : Ljava/lang/String;
    //   214: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload #4
    //   219: astore_3
    //   220: aload #4
    //   222: astore #5
    //   224: aload #6
    //   226: ldc 'uuid'
    //   228: aload_1
    //   229: getfield g : Ljava/lang/String;
    //   232: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload #4
    //   237: astore_3
    //   238: aload #4
    //   240: astore #5
    //   242: aload #6
    //   244: ldc 'ip'
    //   246: aload_1
    //   247: getfield h : Ljava/lang/String;
    //   250: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload #4
    //   255: astore_3
    //   256: aload #4
    //   258: astore #5
    //   260: aload #6
    //   262: ldc 'network'
    //   264: aload_1
    //   265: getfield i : Ljava/lang/String;
    //   268: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload #4
    //   273: astore_3
    //   274: aload #4
    //   276: astore #5
    //   278: aload #6
    //   280: ldc 'dbm'
    //   282: aload_1
    //   283: getfield j : Ljava/lang/String;
    //   286: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload #4
    //   291: astore_3
    //   292: aload #4
    //   294: astore #5
    //   296: aload #6
    //   298: ldc 'wifidbm'
    //   300: aload_1
    //   301: getfield k : Ljava/lang/String;
    //   304: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload #4
    //   309: astore_3
    //   310: aload #4
    //   312: astore #5
    //   314: aload #6
    //   316: ldc 'processName'
    //   318: aload_1
    //   319: getfield l : Ljava/lang/String;
    //   322: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload #4
    //   327: astore_3
    //   328: aload #4
    //   330: astore #5
    //   332: aload #6
    //   334: ldc 'method'
    //   336: aload_1
    //   337: getfield m : Ljava/lang/String;
    //   340: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload #4
    //   345: astore_3
    //   346: aload #4
    //   348: astore #5
    //   350: aload #6
    //   352: ldc 'beginTime'
    //   354: aload_1
    //   355: getfield n : Ljava/lang/String;
    //   358: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload #4
    //   363: astore_3
    //   364: aload #4
    //   366: astore #5
    //   368: aload #6
    //   370: ldc 'costTime'
    //   372: aload_1
    //   373: getfield o : J
    //   376: invokestatic valueOf : (J)Ljava/lang/Long;
    //   379: invokevirtual put : (Ljava/lang/String;Ljava/lang/Long;)V
    //   382: aload #4
    //   384: astore_3
    //   385: aload #4
    //   387: astore #5
    //   389: aload #6
    //   391: ldc 'stepTime'
    //   393: aload_1
    //   394: getfield p : J
    //   397: invokestatic valueOf : (J)Ljava/lang/Long;
    //   400: invokevirtual put : (Ljava/lang/String;Ljava/lang/Long;)V
    //   403: aload #4
    //   405: astore_3
    //   406: aload #4
    //   408: astore #5
    //   410: aload #6
    //   412: ldc 'status'
    //   414: aload_1
    //   415: getfield q : Ljava/lang/String;
    //   418: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   421: aload #4
    //   423: astore_3
    //   424: aload #4
    //   426: astore #5
    //   428: aload #6
    //   430: ldc 'resCode'
    //   432: aload_1
    //   433: getfield r : Ljava/lang/String;
    //   436: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload #4
    //   441: astore_3
    //   442: aload #4
    //   444: astore #5
    //   446: aload #6
    //   448: ldc 'resDesc'
    //   450: aload_1
    //   451: getfield s : Ljava/lang/String;
    //   454: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload #4
    //   459: astore_3
    //   460: aload #4
    //   462: astore #5
    //   464: aload #6
    //   466: ldc 'innerCode'
    //   468: aload_1
    //   469: getfield t : Ljava/lang/String;
    //   472: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   475: aload #4
    //   477: astore_3
    //   478: aload #4
    //   480: astore #5
    //   482: aload #6
    //   484: ldc 'innerDesc'
    //   486: aload_1
    //   487: getfield u : Ljava/lang/String;
    //   490: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload #4
    //   495: astore_3
    //   496: aload #4
    //   498: astore #5
    //   500: aload #6
    //   502: ldc 'count'
    //   504: iconst_1
    //   505: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   508: invokevirtual put : (Ljava/lang/String;Ljava/lang/Integer;)V
    //   511: aload #4
    //   513: astore_3
    //   514: aload #4
    //   516: astore #5
    //   518: aload #6
    //   520: ldc 'sid'
    //   522: aload_1
    //   523: getfield w : Ljava/lang/String;
    //   526: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   529: aload #4
    //   531: astore_3
    //   532: aload #4
    //   534: astore #5
    //   536: aload #4
    //   538: ldc 'report_behavior'
    //   540: aconst_null
    //   541: aload #6
    //   543: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   546: pop2
    //   547: aload #4
    //   549: astore #5
    //   551: aload_0
    //   552: aload #5
    //   554: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   557: return
    //   558: astore_1
    //   559: aload_3
    //   560: astore #5
    //   562: aload_1
    //   563: invokevirtual printStackTrace : ()V
    //   566: aload_0
    //   567: aload_3
    //   568: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   571: goto -> 557
    //   574: astore_1
    //   575: aload_0
    //   576: aload #5
    //   578: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   581: aload_1
    //   582: athrow
    // Exception table:
    //   from	to	target	type
    //   16	22	558	java/lang/Exception
    //   16	22	574	finally
    //   29	34	558	java/lang/Exception
    //   29	34	574	finally
    //   45	63	558	java/lang/Exception
    //   45	63	574	finally
    //   70	77	558	java/lang/Exception
    //   70	77	574	finally
    //   92	97	558	java/lang/Exception
    //   92	97	574	finally
    //   104	109	558	java/lang/Exception
    //   104	109	574	finally
    //   116	127	558	java/lang/Exception
    //   116	127	574	finally
    //   134	145	558	java/lang/Exception
    //   134	145	574	finally
    //   152	163	558	java/lang/Exception
    //   152	163	574	finally
    //   170	181	558	java/lang/Exception
    //   170	181	574	finally
    //   188	199	558	java/lang/Exception
    //   188	199	574	finally
    //   206	217	558	java/lang/Exception
    //   206	217	574	finally
    //   224	235	558	java/lang/Exception
    //   224	235	574	finally
    //   242	253	558	java/lang/Exception
    //   242	253	574	finally
    //   260	271	558	java/lang/Exception
    //   260	271	574	finally
    //   278	289	558	java/lang/Exception
    //   278	289	574	finally
    //   296	307	558	java/lang/Exception
    //   296	307	574	finally
    //   314	325	558	java/lang/Exception
    //   314	325	574	finally
    //   332	343	558	java/lang/Exception
    //   332	343	574	finally
    //   350	361	558	java/lang/Exception
    //   350	361	574	finally
    //   368	382	558	java/lang/Exception
    //   368	382	574	finally
    //   389	403	558	java/lang/Exception
    //   389	403	574	finally
    //   410	421	558	java/lang/Exception
    //   410	421	574	finally
    //   428	439	558	java/lang/Exception
    //   428	439	574	finally
    //   446	457	558	java/lang/Exception
    //   446	457	574	finally
    //   464	475	558	java/lang/Exception
    //   464	475	574	finally
    //   482	493	558	java/lang/Exception
    //   482	493	574	finally
    //   500	511	558	java/lang/Exception
    //   500	511	574	finally
    //   518	529	558	java/lang/Exception
    //   518	529	574	finally
    //   536	547	558	java/lang/Exception
    //   536	547	574	finally
    //   562	566	574	finally
  }
  
  public void a(d paramd) {
    SQLiteDatabase sQLiteDatabase = null;
    if (paramd != null) {
      try {
        Exception exception1;
        Exception exception2;
        sQLiteDatabase = d();
        try {
          ContentValues contentValues = new ContentValues();
          this();
          contentValues.put("DID", paramd.a);
          contentValues.put("IMEI", paramd.b);
          contentValues.put("IMSI", paramd.c);
          contentValues.put("ICCID", paramd.d);
          contentValues.put("MAC", paramd.e);
          contentValues.put("appPlatform", paramd.f);
          contentValues.put("device", paramd.g);
          contentValues.put("deviceName", paramd.h);
          return;
        } catch (Exception exception) {
        
        } finally {
          Exception exception = null;
          exception1 = exception2;
          exception2 = exception;
          a((SQLiteDatabase)exception1);
        } 
      } catch (Exception exception) {
        paramd = null;
      } finally {
        sQLiteDatabase = null;
      } 
      a((SQLiteDatabase)paramd);
      throw sQLiteDatabase;
    } 
    a(sQLiteDatabase);
  }
  
  public boolean a(int paramInt) {
    SQLiteDatabase sQLiteDatabase = null;
    null = null;
    boolean bool1 = false;
    boolean bool2 = false;
    try {
      SQLiteDatabase sQLiteDatabase1 = d();
      null = sQLiteDatabase1;
      sQLiteDatabase = sQLiteDatabase1;
      Cursor cursor = sQLiteDatabase1.rawQuery("select count(*) from report_behavior", null);
      null = sQLiteDatabase1;
      sQLiteDatabase = sQLiteDatabase1;
      cursor.moveToFirst();
      null = sQLiteDatabase1;
      sQLiteDatabase = sQLiteDatabase1;
      long l = cursor.getLong(0);
      null = sQLiteDatabase1;
      sQLiteDatabase = sQLiteDatabase1;
      cursor.close();
      if (l > paramInt)
        bool2 = true; 
      return bool2;
    } catch (Exception exception) {
      sQLiteDatabase = null;
      exception.printStackTrace();
      return bool1;
    } finally {
      a(sQLiteDatabase);
    } 
  }
  
  public long b() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial d : ()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: ldc_w 'select count(*) from report_behavior'
    //   11: aconst_null
    //   12: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   15: astore_3
    //   16: aload_1
    //   17: astore_2
    //   18: aload_3
    //   19: invokeinterface moveToFirst : ()Z
    //   24: pop
    //   25: aload_1
    //   26: astore_2
    //   27: aload_3
    //   28: iconst_0
    //   29: invokeinterface getLong : (I)J
    //   34: lstore #4
    //   36: aload_1
    //   37: astore_2
    //   38: aload_3
    //   39: invokeinterface close : ()V
    //   44: aload_0
    //   45: aload_1
    //   46: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   49: lload #4
    //   51: lreturn
    //   52: astore_3
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_1
    //   56: astore_2
    //   57: aload_3
    //   58: invokevirtual printStackTrace : ()V
    //   61: lconst_0
    //   62: lstore #4
    //   64: aload_0
    //   65: aload_1
    //   66: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   69: goto -> 49
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_3
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: aload_3
    //   79: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_2
    //   86: astore_3
    //   87: goto -> 77
    //   90: astore_3
    //   91: goto -> 55
    // Exception table:
    //   from	to	target	type
    //   0	5	52	java/lang/Exception
    //   0	5	72	finally
    //   7	16	90	java/lang/Exception
    //   7	16	84	finally
    //   18	25	90	java/lang/Exception
    //   18	25	84	finally
    //   27	36	90	java/lang/Exception
    //   27	36	84	finally
    //   38	44	90	java/lang/Exception
    //   38	44	84	finally
    //   57	61	84	finally
  }
  
  public long c() {
    return this.b;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */