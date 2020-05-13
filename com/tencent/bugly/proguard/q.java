package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.a;
import java.util.List;

public final class q extends SQLiteOpenHelper {
  public static String a = "bugly_db";
  
  private static int b = 15;
  
  private Context c;
  
  private List<a> d;
  
  public q(Context paramContext, List<a> paramList) {
    super(paramContext, stringBuilder.toString(), null, b);
    this.c = paramContext;
    this.d = paramList;
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase) {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/q}} */
    try {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "t_lr";
      arrayOfString[1] = "t_ui";
      arrayOfString[2] = "t_pf";
      int i = arrayOfString.length;
      for (byte b = 0; b < i; b++) {
        String str = arrayOfString[b];
        StringBuilder stringBuilder = new StringBuilder();
        this("DROP TABLE IF EXISTS ");
        stringBuilder.append(str);
        paramSQLiteDatabase.execSQL(stringBuilder.toString(), (Object[])new String[0]);
      } 
      /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/q}} */
      return true;
    } catch (Throwable throwable) {
      if (!x.b(throwable))
        throwable.printStackTrace(); 
      /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/q}} */
      return false;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/q}} */
    throw paramSQLiteDatabase;
  }
  
  public final SQLiteDatabase getReadableDatabase() {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/q}} */
    SQLiteDatabase sQLiteDatabase = null;
    byte b = 0;
    while (sQLiteDatabase == null && b < 5) {
      b++;
      try {
        SQLiteDatabase sQLiteDatabase1 = super.getReadableDatabase();
        sQLiteDatabase = sQLiteDatabase1;
        continue;
      } catch (Throwable throwable) {
        x.d("[Database] Try to get db(count: %d).", new Object[] { Integer.valueOf(b) });
        if (b == 5)
          x.e("[Database] Failed to get db.", new Object[0]); 
        try {
          Thread.sleep(200L);
        } catch (InterruptedException interruptedException) {
          interruptedException.printStackTrace();
        } 
        continue;
      } finally {}
      /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/q}} */
      throw sQLiteDatabase;
    } 
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/q}} */
    return sQLiteDatabase;
  }
  
  public final SQLiteDatabase getWritableDatabase() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: iconst_0
    //   5: istore_2
    //   6: aload_1
    //   7: ifnonnull -> 78
    //   10: iload_2
    //   11: iconst_5
    //   12: if_icmpge -> 78
    //   15: iinc #2, 1
    //   18: aload_0
    //   19: invokespecial getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_1
    //   25: goto -> 6
    //   28: astore_3
    //   29: ldc '[Database] Try to get db(count: %d).'
    //   31: iconst_1
    //   32: anewarray java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload_2
    //   38: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   41: aastore
    //   42: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: iload_2
    //   47: iconst_5
    //   48: if_icmpne -> 61
    //   51: ldc '[Database] Failed to get db.'
    //   53: iconst_0
    //   54: anewarray java/lang/Object
    //   57: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: ldc2_w 200
    //   64: invokestatic sleep : (J)V
    //   67: goto -> 6
    //   70: astore_3
    //   71: aload_3
    //   72: invokevirtual printStackTrace : ()V
    //   75: goto -> 6
    //   78: aload_1
    //   79: ifnonnull -> 100
    //   82: ldc '[Database] db error delay error record 1min.'
    //   84: iconst_0
    //   85: anewarray java/lang/Object
    //   88: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   91: pop
    //   92: goto -> 100
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: areturn
    // Exception table:
    //   from	to	target	type
    //   18	23	28	java/lang/Throwable
    //   18	23	95	finally
    //   29	46	95	finally
    //   51	61	95	finally
    //   61	67	70	java/lang/InterruptedException
    //   61	67	95	finally
    //   71	75	95	finally
    //   82	92	95	finally
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/q}} */
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.setLength(0);
      stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_ui");
      stringBuilder.append(" ( _id");
      stringBuilder.append(" INTEGER PRIMARY KEY");
      stringBuilder.append(" , _tm");
      stringBuilder.append(" int");
      stringBuilder.append(" , _ut");
      stringBuilder.append(" int");
      stringBuilder.append(" , _tp");
      stringBuilder.append(" int");
      stringBuilder.append(" , _dt");
      stringBuilder.append(" blob");
      stringBuilder.append(" , _pc");
      stringBuilder.append(" text");
      stringBuilder.append(" ) ");
      x.c(stringBuilder.toString(), new Object[0]);
      paramSQLiteDatabase.execSQL(stringBuilder.toString(), (Object[])new String[0]);
      stringBuilder.setLength(0);
      stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_lr");
      stringBuilder.append(" ( _id");
      stringBuilder.append(" INTEGER PRIMARY KEY");
      stringBuilder.append(" , _tp");
      stringBuilder.append(" int");
      stringBuilder.append(" , _tm");
      stringBuilder.append(" int");
      stringBuilder.append(" , _pc");
      stringBuilder.append(" text");
      stringBuilder.append(" , _th");
      stringBuilder.append(" text");
      stringBuilder.append(" , _dt");
      stringBuilder.append(" blob");
      stringBuilder.append(" ) ");
      x.c(stringBuilder.toString(), new Object[0]);
      paramSQLiteDatabase.execSQL(stringBuilder.toString(), (Object[])new String[0]);
      stringBuilder.setLength(0);
      stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_pf");
      stringBuilder.append(" ( _id");
      stringBuilder.append(" integer");
      stringBuilder.append(" , _tp");
      stringBuilder.append(" text");
      stringBuilder.append(" , _tm");
      stringBuilder.append(" int");
      stringBuilder.append(" , _dt");
      stringBuilder.append(" blob");
      stringBuilder.append(",primary key(_id");
      stringBuilder.append(",_tp");
      stringBuilder.append(" )) ");
      x.c(stringBuilder.toString(), new Object[0]);
      paramSQLiteDatabase.execSQL(stringBuilder.toString(), (Object[])new String[0]);
      stringBuilder.setLength(0);
      stringBuilder.append(" CREATE TABLE IF NOT EXISTS t_cr");
      stringBuilder.append(" ( _id");
      stringBuilder.append(" INTEGER PRIMARY KEY");
      stringBuilder.append(" , _tm");
      stringBuilder.append(" int");
      stringBuilder.append(" , _s1");
      stringBuilder.append(" text");
      stringBuilder.append(" , _up");
      stringBuilder.append(" int");
      stringBuilder.append(" , _me");
      stringBuilder.append(" int");
      stringBuilder.append(" , _uc");
      stringBuilder.append(" int");
      stringBuilder.append(" , _dt");
      stringBuilder.append(" blob");
      stringBuilder.append(" ) ");
      x.c(stringBuilder.toString(), new Object[0]);
      paramSQLiteDatabase.execSQL(stringBuilder.toString(), (Object[])new String[0]);
      stringBuilder.setLength(0);
      stringBuilder.append(" CREATE TABLE IF NOT EXISTS dl_1002");
      stringBuilder.append(" (_id");
      stringBuilder.append(" integer primary key autoincrement, _dUrl");
      stringBuilder.append(" varchar(100), _sFile");
      stringBuilder.append(" varchar(100), _sLen");
      stringBuilder.append(" INTEGER, _tLen");
      stringBuilder.append(" INTEGER, _MD5");
      stringBuilder.append(" varchar(100), _DLTIME");
      stringBuilder.append(" INTEGER)");
      x.c(stringBuilder.toString(), new Object[0]);
      paramSQLiteDatabase.execSQL(stringBuilder.toString(), (Object[])new String[0]);
      stringBuilder.setLength(0);
      stringBuilder.append("CREATE TABLE IF NOT EXISTS ge_1002");
      stringBuilder.append(" (_id");
      stringBuilder.append(" integer primary key autoincrement, _time");
      stringBuilder.append(" INTEGER, _datas");
      stringBuilder.append(" blob)");
      x.c(stringBuilder.toString(), new Object[0]);
      paramSQLiteDatabase.execSQL(stringBuilder.toString(), (Object[])new String[0]);
      stringBuilder.setLength(0);
      stringBuilder.append(" CREATE TABLE IF NOT EXISTS st_1002");
      stringBuilder.append(" ( _id");
      stringBuilder.append(" integer");
      stringBuilder.append(" , _tp");
      stringBuilder.append(" text");
      stringBuilder.append(" , _tm");
      stringBuilder.append(" int");
      stringBuilder.append(" , _dt");
      stringBuilder.append(" blob");
      stringBuilder.append(",primary key(_id");
      stringBuilder.append(",_tp");
      stringBuilder.append(" )) ");
      x.c(stringBuilder.toString(), new Object[0]);
      paramSQLiteDatabase.execSQL(stringBuilder.toString(), (Object[])new String[0]);
    } catch (Throwable throwable) {
      if (!x.b(throwable))
        throwable.printStackTrace(); 
    } finally {}
    List<a> list = this.d;
    if (list == null) {
      /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/q}} */
      return;
    } 
    for (a a : this.d) {
      try {
        a.onDbCreate(paramSQLiteDatabase);
      } catch (Throwable throwable) {
        if (!x.b(throwable))
          throwable.printStackTrace(); 
      } 
    } 
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/q}} */
  }
  
  @TargetApi(11)
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic c : ()I
    //   5: bipush #11
    //   7: if_icmplt -> 156
    //   10: ldc '[Database] Downgrade %d to %d drop tables.'
    //   12: iconst_2
    //   13: anewarray java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iload_2
    //   19: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: iload_3
    //   26: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   29: aastore
    //   30: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   33: pop
    //   34: aload_0
    //   35: getfield d : Ljava/util/List;
    //   38: ifnull -> 103
    //   41: aload_0
    //   42: getfield d : Ljava/util/List;
    //   45: invokeinterface iterator : ()Ljava/util/Iterator;
    //   50: astore #4
    //   52: aload #4
    //   54: invokeinterface hasNext : ()Z
    //   59: ifeq -> 103
    //   62: aload #4
    //   64: invokeinterface next : ()Ljava/lang/Object;
    //   69: checkcast com/tencent/bugly/a
    //   72: astore #5
    //   74: aload #5
    //   76: aload_1
    //   77: iload_2
    //   78: iload_3
    //   79: invokevirtual onDbDowngrade : (Landroid/database/sqlite/SQLiteDatabase;II)V
    //   82: goto -> 52
    //   85: astore #5
    //   87: aload #5
    //   89: invokestatic b : (Ljava/lang/Throwable;)Z
    //   92: ifne -> 52
    //   95: aload #5
    //   97: invokevirtual printStackTrace : ()V
    //   100: goto -> 52
    //   103: aload_0
    //   104: aload_1
    //   105: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;)Z
    //   108: ifeq -> 119
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual onCreate : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   116: aload_0
    //   117: monitorexit
    //   118: return
    //   119: ldc '[Database] Failed to drop, delete db.'
    //   121: iconst_0
    //   122: anewarray java/lang/Object
    //   125: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   128: pop
    //   129: aload_0
    //   130: getfield c : Landroid/content/Context;
    //   133: getstatic com/tencent/bugly/proguard/q.a : Ljava/lang/String;
    //   136: invokevirtual getDatabasePath : (Ljava/lang/String;)Ljava/io/File;
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull -> 156
    //   144: aload_1
    //   145: invokevirtual canWrite : ()Z
    //   148: ifeq -> 156
    //   151: aload_1
    //   152: invokevirtual delete : ()Z
    //   155: pop
    //   156: aload_0
    //   157: monitorexit
    //   158: return
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Exception table:
    //   from	to	target	type
    //   2	52	159	finally
    //   52	74	159	finally
    //   74	82	85	java/lang/Throwable
    //   74	82	159	finally
    //   87	100	159	finally
    //   103	116	159	finally
    //   119	140	159	finally
    //   144	156	159	finally
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w '[Database] Upgrade %d to %d , drop tables!'
    //   5: iconst_2
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: iload_2
    //   12: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: iload_3
    //   19: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   22: aastore
    //   23: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   26: pop
    //   27: aload_0
    //   28: getfield d : Ljava/util/List;
    //   31: ifnull -> 96
    //   34: aload_0
    //   35: getfield d : Ljava/util/List;
    //   38: invokeinterface iterator : ()Ljava/util/Iterator;
    //   43: astore #4
    //   45: aload #4
    //   47: invokeinterface hasNext : ()Z
    //   52: ifeq -> 96
    //   55: aload #4
    //   57: invokeinterface next : ()Ljava/lang/Object;
    //   62: checkcast com/tencent/bugly/a
    //   65: astore #5
    //   67: aload #5
    //   69: aload_1
    //   70: iload_2
    //   71: iload_3
    //   72: invokevirtual onDbUpgrade : (Landroid/database/sqlite/SQLiteDatabase;II)V
    //   75: goto -> 45
    //   78: astore #5
    //   80: aload #5
    //   82: invokestatic b : (Ljava/lang/Throwable;)Z
    //   85: ifne -> 45
    //   88: aload #5
    //   90: invokevirtual printStackTrace : ()V
    //   93: goto -> 45
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;)Z
    //   101: ifeq -> 112
    //   104: aload_0
    //   105: aload_1
    //   106: invokevirtual onCreate : (Landroid/database/sqlite/SQLiteDatabase;)V
    //   109: aload_0
    //   110: monitorexit
    //   111: return
    //   112: ldc '[Database] Failed to drop, delete db.'
    //   114: iconst_0
    //   115: anewarray java/lang/Object
    //   118: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: getfield c : Landroid/content/Context;
    //   126: getstatic com/tencent/bugly/proguard/q.a : Ljava/lang/String;
    //   129: invokevirtual getDatabasePath : (Ljava/lang/String;)Ljava/io/File;
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull -> 149
    //   137: aload_1
    //   138: invokevirtual canWrite : ()Z
    //   141: ifeq -> 149
    //   144: aload_1
    //   145: invokevirtual delete : ()Z
    //   148: pop
    //   149: aload_0
    //   150: monitorexit
    //   151: return
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    // Exception table:
    //   from	to	target	type
    //   2	45	152	finally
    //   45	67	152	finally
    //   67	75	78	java/lang/Throwable
    //   67	75	152	finally
    //   80	93	152	finally
    //   96	109	152	finally
    //   112	133	152	finally
    //   137	149	152	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */