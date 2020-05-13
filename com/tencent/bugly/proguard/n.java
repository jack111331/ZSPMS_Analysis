package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class n {
  public static final long a = System.currentTimeMillis();
  
  private static n b;
  
  private Context c;
  
  private String d;
  
  private Map<Integer, Map<String, m>> e;
  
  private SharedPreferences f;
  
  private n(Context paramContext) {
    this.c = paramContext;
    this.e = new HashMap<Integer, Map<String, m>>();
    this.d = (a.b()).d;
    this.f = paramContext.getSharedPreferences("crashrecord", 0);
  }
  
  public static n a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/n
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/n.b : Lcom/tencent/bugly/proguard/n;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/proguard/n
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/proguard/n
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static n a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/n
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/n.b : Lcom/tencent/bugly/proguard/n;
    //   6: ifnonnull -> 22
    //   9: new com/tencent/bugly/proguard/n
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/tencent/bugly/proguard/n.b : Lcom/tencent/bugly/proguard/n;
    //   22: getstatic com/tencent/bugly/proguard/n.b : Lcom/tencent/bugly/proguard/n;
    //   25: astore_0
    //   26: ldc com/tencent/bugly/proguard/n
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/tencent/bugly/proguard/n
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	26	31	finally
  }
  
  private <T extends List<?>> void a(int paramInt, T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: new java/io/File
    //   12: astore_3
    //   13: aload_0
    //   14: getfield c : Landroid/content/Context;
    //   17: ldc 'crashrecord'
    //   19: iconst_0
    //   20: invokevirtual getDir : (Ljava/lang/String;I)Ljava/io/File;
    //   23: astore #4
    //   25: new java/lang/StringBuilder
    //   28: astore #5
    //   30: aload #5
    //   32: invokespecial <init> : ()V
    //   35: aload #5
    //   37: iload_1
    //   38: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: aload #4
    //   45: aload #5
    //   47: invokevirtual toString : ()Ljava/lang/String;
    //   50: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   53: aconst_null
    //   54: astore #6
    //   56: aconst_null
    //   57: astore #7
    //   59: aload #7
    //   61: astore #5
    //   63: new java/io/ObjectOutputStream
    //   66: astore #4
    //   68: aload #7
    //   70: astore #5
    //   72: new java/io/FileOutputStream
    //   75: astore #8
    //   77: aload #7
    //   79: astore #5
    //   81: aload #8
    //   83: aload_3
    //   84: invokespecial <init> : (Ljava/io/File;)V
    //   87: aload #7
    //   89: astore #5
    //   91: aload #4
    //   93: aload #8
    //   95: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   98: aload #4
    //   100: aload_2
    //   101: invokevirtual writeObject : (Ljava/lang/Object;)V
    //   104: aload #4
    //   106: invokevirtual close : ()V
    //   109: goto -> 203
    //   112: astore_2
    //   113: aload #4
    //   115: astore #5
    //   117: goto -> 176
    //   120: astore #5
    //   122: aload #4
    //   124: astore_2
    //   125: aload #5
    //   127: astore #4
    //   129: goto -> 141
    //   132: astore_2
    //   133: goto -> 176
    //   136: astore #4
    //   138: aload #6
    //   140: astore_2
    //   141: aload_2
    //   142: astore #5
    //   144: aload #4
    //   146: invokevirtual printStackTrace : ()V
    //   149: aload_2
    //   150: astore #5
    //   152: ldc 'open record file error'
    //   154: iconst_0
    //   155: anewarray java/lang/Object
    //   158: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   161: pop
    //   162: aload_2
    //   163: ifnull -> 173
    //   166: aload_2
    //   167: invokevirtual close : ()V
    //   170: goto -> 203
    //   173: aload_0
    //   174: monitorexit
    //   175: return
    //   176: aload #5
    //   178: ifnull -> 186
    //   181: aload #5
    //   183: invokevirtual close : ()V
    //   186: aload_2
    //   187: athrow
    //   188: astore_2
    //   189: goto -> 206
    //   192: astore_2
    //   193: ldc 'writeCrashRecord error'
    //   195: iconst_0
    //   196: anewarray java/lang/Object
    //   199: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   202: pop
    //   203: aload_0
    //   204: monitorexit
    //   205: return
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_2
    //   209: athrow
    // Exception table:
    //   from	to	target	type
    //   9	53	192	java/lang/Exception
    //   9	53	188	finally
    //   63	68	136	java/io/IOException
    //   63	68	132	finally
    //   72	77	136	java/io/IOException
    //   72	77	132	finally
    //   81	87	136	java/io/IOException
    //   81	87	132	finally
    //   91	98	136	java/io/IOException
    //   91	98	132	finally
    //   98	104	120	java/io/IOException
    //   98	104	112	finally
    //   104	109	192	java/lang/Exception
    //   104	109	188	finally
    //   144	149	132	finally
    //   152	162	132	finally
    //   166	170	192	java/lang/Exception
    //   166	170	188	finally
    //   181	186	192	java/lang/Exception
    //   181	186	188	finally
    //   186	188	192	java/lang/Exception
    //   186	188	188	finally
    //   193	203	188	finally
  }
  
  private boolean b(int paramInt) {
    Exception exception;
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/proguard/n}} */
    try {
      List list = (List)c(paramInt);
      if (list == null) {
        /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/n}} */
        return false;
      } 
      long l = System.currentTimeMillis();
      ArrayList<m> arrayList1 = new ArrayList();
      this();
      ArrayList<m> arrayList2 = new ArrayList();
      this();
      for (m m : list) {
        if (m.b != null && m.b.equalsIgnoreCase(this.d) && m.d > 0)
          arrayList1.add(m); 
        if (m.c + 86400000L < l)
          arrayList2.add(m); 
      } 
      Collections.sort(arrayList1);
      if (arrayList1.size() >= 2) {
        if (arrayList1.size() > 0 && ((m)arrayList1.get(arrayList1.size() - 1)).c + 86400000L < l) {
          list.clear();
          a(paramInt, list);
          /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/n}} */
          return false;
        } 
        /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/n}} */
        return true;
      } 
      list.removeAll(arrayList2);
      a(paramInt, list);
      /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/n}} */
      return false;
    } catch (Exception null) {
      x.e("isFrequentCrash failed", new Object[0]);
      /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/n}} */
      return false;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/proguard/n}} */
    throw exception;
  }
  
  private <T extends List<?>> T c(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/io/File
    //   5: astore_2
    //   6: aload_0
    //   7: getfield c : Landroid/content/Context;
    //   10: ldc 'crashrecord'
    //   12: iconst_0
    //   13: invokevirtual getDir : (Ljava/lang/String;I)Ljava/io/File;
    //   16: astore_3
    //   17: new java/lang/StringBuilder
    //   20: astore #4
    //   22: aload #4
    //   24: invokespecial <init> : ()V
    //   27: aload #4
    //   29: iload_1
    //   30: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: aload_3
    //   36: aload #4
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   44: aload_2
    //   45: invokevirtual exists : ()Z
    //   48: istore #5
    //   50: iload #5
    //   52: ifne -> 59
    //   55: aload_0
    //   56: monitorexit
    //   57: aconst_null
    //   58: areturn
    //   59: new java/io/ObjectInputStream
    //   62: astore_3
    //   63: new java/io/FileInputStream
    //   66: astore #4
    //   68: aload #4
    //   70: aload_2
    //   71: invokespecial <init> : (Ljava/io/File;)V
    //   74: aload_3
    //   75: aload #4
    //   77: invokespecial <init> : (Ljava/io/InputStream;)V
    //   80: aload_3
    //   81: astore_2
    //   82: aload_3
    //   83: invokevirtual readObject : ()Ljava/lang/Object;
    //   86: checkcast java/util/List
    //   89: astore #4
    //   91: aload_3
    //   92: invokevirtual close : ()V
    //   95: aload_0
    //   96: monitorexit
    //   97: aload #4
    //   99: areturn
    //   100: astore_3
    //   101: aconst_null
    //   102: astore_2
    //   103: goto -> 155
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_3
    //   109: aload_3
    //   110: astore_2
    //   111: ldc 'get object error'
    //   113: iconst_0
    //   114: anewarray java/lang/Object
    //   117: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   120: pop
    //   121: aload_3
    //   122: ifnull -> 180
    //   125: aload_3
    //   126: invokevirtual close : ()V
    //   129: goto -> 180
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_3
    //   135: aload_3
    //   136: astore_2
    //   137: ldc 'open record file error'
    //   139: iconst_0
    //   140: anewarray java/lang/Object
    //   143: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   146: pop
    //   147: aload_3
    //   148: ifnull -> 180
    //   151: goto -> 125
    //   154: astore_3
    //   155: aload_2
    //   156: ifnull -> 163
    //   159: aload_2
    //   160: invokevirtual close : ()V
    //   163: aload_3
    //   164: athrow
    //   165: astore_2
    //   166: goto -> 184
    //   169: astore_2
    //   170: ldc 'readCrashRecord error'
    //   172: iconst_0
    //   173: anewarray java/lang/Object
    //   176: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   179: pop
    //   180: aload_0
    //   181: monitorexit
    //   182: aconst_null
    //   183: areturn
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_2
    //   187: athrow
    //   188: astore_2
    //   189: goto -> 135
    //   192: astore_2
    //   193: goto -> 109
    // Exception table:
    //   from	to	target	type
    //   2	50	169	java/lang/Exception
    //   2	50	165	finally
    //   59	80	132	java/io/IOException
    //   59	80	106	java/lang/ClassNotFoundException
    //   59	80	100	finally
    //   82	91	188	java/io/IOException
    //   82	91	192	java/lang/ClassNotFoundException
    //   82	91	154	finally
    //   91	95	169	java/lang/Exception
    //   91	95	165	finally
    //   111	121	154	finally
    //   125	129	169	java/lang/Exception
    //   125	129	165	finally
    //   137	147	154	finally
    //   159	163	169	java/lang/Exception
    //   159	163	165	finally
    //   163	165	169	java/lang/Exception
    //   163	165	165	finally
    //   170	180	165	finally
  }
  
  public final void a(int paramInt1, int paramInt2) {
    w.a().a(new Runnable(this, 1004, paramInt2) {
          public final void run() {
            try {
              m m;
              Object object;
              boolean bool1;
              if (TextUtils.isEmpty(n.a(this.c)))
                return; 
              List<m> list1 = n.a(this.c, this.a);
              List<m> list2 = list1;
              if (list1 == null) {
                list2 = new ArrayList();
                super();
              } 
              if (n.b(this.c).get(Integer.valueOf(this.a)) == null) {
                HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                this();
                n.b(this.c).put(Integer.valueOf(this.a), hashMap);
              } 
              if (((Map)n.b(this.c).get(Integer.valueOf(this.a))).get(n.a(this.c)) == null) {
                m = new m();
                this();
                m.a = this.a;
                m.g = n.a;
                m.b = n.a(this.c);
                m.f = (a.b()).j;
                a.b().getClass();
                m.e = "3.1.0";
                m.c = System.currentTimeMillis();
                m.d = this.b;
                ((Map<String, m>)n.b(this.c).get(Integer.valueOf(this.a))).put(n.a(this.c), m);
              } else {
                m = (m)((Map)n.b(this.c).get(Integer.valueOf(this.a))).get(n.a(this.c));
                m.d = this.b;
              } 
              ArrayList<Object> arrayList = new ArrayList();
              this();
              Iterator<m> iterator = list2.iterator();
              boolean bool2 = false;
              while (iterator.hasNext()) {
                boolean bool;
                m m1 = iterator.next();
                Object object1 = object;
                if (m1.g == m.g) {
                  object1 = object;
                  if (m1.b != null) {
                    object1 = object;
                    if (m1.b.equalsIgnoreCase(m.b)) {
                      bool = true;
                      m1.d = m.d;
                    } 
                  } 
                } 
                if ((m1.e == null || m1.e.equalsIgnoreCase(m.e)) && (m1.f == null || m1.f.equalsIgnoreCase(m.f))) {
                  bool1 = bool;
                  if (m1.d <= 0)
                    continue; 
                  continue;
                } 
                continue;
                arrayList.add(SYNTHETIC_LOCAL_VARIABLE_6);
                object = SYNTHETIC_LOCAL_VARIABLE_7;
              } 
              list2.removeAll(arrayList);
              if (!bool1)
                list2.add(m); 
              n.a(this.c, this.a, list2);
              return;
            } catch (Exception exception) {
              x.e("saveCrashRecord failed", new Object[0]);
              return;
            } 
          }
        });
  }
  
  public final boolean a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: istore_2
    //   4: aload_0
    //   5: getfield f : Landroid/content/SharedPreferences;
    //   8: astore_3
    //   9: new java/lang/StringBuilder
    //   12: astore #4
    //   14: aload #4
    //   16: invokespecial <init> : ()V
    //   19: aload #4
    //   21: iload_1
    //   22: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload #4
    //   28: ldc '_'
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload #4
    //   36: aload_0
    //   37: getfield d : Ljava/lang/String;
    //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_3
    //   45: aload #4
    //   47: invokevirtual toString : ()Ljava/lang/String;
    //   50: iconst_1
    //   51: invokeinterface getBoolean : (Ljava/lang/String;Z)Z
    //   56: istore #5
    //   58: invokestatic a : ()Lcom/tencent/bugly/proguard/w;
    //   61: astore_3
    //   62: new com/tencent/bugly/proguard/n$2
    //   65: astore #4
    //   67: aload #4
    //   69: aload_0
    //   70: iload_1
    //   71: invokespecial <init> : (Lcom/tencent/bugly/proguard/n;I)V
    //   74: aload_3
    //   75: aload #4
    //   77: invokevirtual a : (Ljava/lang/Runnable;)Z
    //   80: pop
    //   81: aload_0
    //   82: monitorexit
    //   83: iload #5
    //   85: ireturn
    //   86: astore #4
    //   88: goto -> 96
    //   91: astore #4
    //   93: goto -> 111
    //   96: ldc 'canInit error'
    //   98: iconst_0
    //   99: anewarray java/lang/Object
    //   102: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   105: pop
    //   106: aload_0
    //   107: monitorexit
    //   108: iload #5
    //   110: ireturn
    //   111: aload_0
    //   112: monitorexit
    //   113: aload #4
    //   115: athrow
    //   116: astore #4
    //   118: iload_2
    //   119: istore #5
    //   121: goto -> 96
    // Exception table:
    //   from	to	target	type
    //   4	58	116	java/lang/Exception
    //   4	58	91	finally
    //   58	81	86	java/lang/Exception
    //   58	81	91	finally
    //   96	106	91	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */