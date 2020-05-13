package com.zz.sdk.b;

import android.content.Context;
import android.database.Cursor;
import java.util.LinkedList;

public class n extends b {
  public n(Context paramContext) {
    super(paramContext);
  }
  
  public LinkedList a(String paramString) {
    LinkedList<m> linkedList = new LinkedList();
    Cursor cursor = a("a_pay", null, "user='" + paramString + "'", null, null, null, null);
    while (cursor.moveToNext()) {
      m m = new m();
      m.c(paramString);
      m.d(cursor.getString(cursor.getColumnIndex("a_ordernum")));
      m.e(cursor.getString(cursor.getColumnIndex("a_time")));
      m.f(cursor.getString(cursor.getColumnIndex("a_way")));
      m.g(cursor.getString(cursor.getColumnIndex("status")));
      m.a(cursor.getString(cursor.getColumnIndex("submitAmount")));
      linkedList.add(m);
    } 
    if (cursor != null && !cursor.isClosed())
      cursor.close(); 
    return linkedList;
  }
  
  public LinkedList a(String paramString, String... paramVarArgs) {
    StringBuilder stringBuilder = (new StringBuilder()).append("(");
    for (byte b1 = 0; b1 < paramVarArgs.length; b1++) {
      if (b1 > 0)
        stringBuilder.append(","); 
      stringBuilder.append("'").append(paramVarArgs[b1]).append("'");
    } 
    stringBuilder.append(")");
    LinkedList<m> linkedList = new LinkedList();
    Cursor cursor = a("a_pay", null, "user='" + paramString + "' and " + "status" + " in " + stringBuilder.toString(), null, null, null, null);
    while (cursor.moveToNext()) {
      m m = new m();
      m.c(paramString);
      m.d(cursor.getString(cursor.getColumnIndex("a_ordernum")));
      m.e(cursor.getString(cursor.getColumnIndex("a_time")));
      m.f(cursor.getString(cursor.getColumnIndex("a_way")));
      m.g(cursor.getString(cursor.getColumnIndex("status")));
      m.a(cursor.getString(cursor.getColumnIndex("submitAmount")));
      linkedList.add(m);
    } 
    if (cursor != null && !cursor.isClosed())
      cursor.close(); 
    return linkedList;
  }
  
  public boolean a(m paramm) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new android/content/ContentValues
    //   7: astore_3
    //   8: aload_3
    //   9: invokespecial <init> : ()V
    //   12: aload_3
    //   13: ldc 'user'
    //   15: aload_1
    //   16: invokevirtual a : ()Ljava/lang/String;
    //   19: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_3
    //   23: ldc 'a_ordernum'
    //   25: aload_1
    //   26: invokevirtual d : ()Ljava/lang/String;
    //   29: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_3
    //   33: ldc 'a_time'
    //   35: aload_1
    //   36: invokevirtual e : ()Ljava/lang/String;
    //   39: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_3
    //   43: ldc 'a_way'
    //   45: aload_1
    //   46: invokevirtual f : ()Ljava/lang/String;
    //   49: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_3
    //   53: ldc 'status'
    //   55: aload_1
    //   56: invokevirtual g : ()Ljava/lang/String;
    //   59: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_3
    //   63: ldc 'submitAmount'
    //   65: aload_1
    //   66: invokevirtual c : ()Ljava/lang/String;
    //   69: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload_0
    //   73: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   76: ldc 'a_pay'
    //   78: aload_3
    //   79: ldc 'a_ordernum=?'
    //   81: iconst_1
    //   82: anewarray java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: aload_1
    //   88: invokevirtual d : ()Ljava/lang/String;
    //   91: aastore
    //   92: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   95: i2l
    //   96: lstore #4
    //   98: lload #4
    //   100: lstore #6
    //   102: lload #4
    //   104: lconst_0
    //   105: lcmp
    //   106: ifgt -> 122
    //   109: aload_0
    //   110: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   113: ldc 'a_pay'
    //   115: aconst_null
    //   116: aload_3
    //   117: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   120: lstore #6
    //   122: lload #6
    //   124: lconst_0
    //   125: lcmp
    //   126: ifle -> 133
    //   129: aload_0
    //   130: monitorexit
    //   131: iload_2
    //   132: ireturn
    //   133: iconst_0
    //   134: istore_2
    //   135: goto -> 129
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Exception table:
    //   from	to	target	type
    //   4	98	138	finally
    //   109	122	138	finally
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3) {
    boolean bool;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      paramString2 = stringBuilder.append("update a_pay set status='").append(paramString2).append("'where ").append("a_ordernum").append("='").append(paramString1).append("'").toString();
      stringBuilder = new StringBuilder();
      this();
      paramString1 = stringBuilder.append("update a_pay set a_time='").append(paramString3).append("'where ").append("a_ordernum").append("='").append(paramString1).append("'").toString();
      this.b.execSQL(paramString2);
      this.b.execSQL(paramString1);
      bool = true;
    } catch (Exception exception) {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */