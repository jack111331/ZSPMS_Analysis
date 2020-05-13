package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class b implements ac {
  private AtomicInteger a = new AtomicInteger(0);
  
  private long b = -1L;
  
  private final Context c;
  
  private final a d;
  
  private final w e;
  
  private final a f;
  
  private final String g;
  
  private final com.tencent.bugly.crashreport.crash.b h;
  
  private FileObserver i;
  
  private boolean j = true;
  
  private ab k;
  
  private int l;
  
  public b(Context paramContext, a parama, a parama1, w paramw, com.tencent.bugly.crashreport.crash.b paramb) {
    this.c = z.a(paramContext);
    this.g = paramContext.getDir("bugly", 0).getAbsolutePath();
    this.d = parama1;
    this.e = paramw;
    this.f = parama;
    this.h = paramb;
  }
  
  private static ActivityManager.ProcessErrorStateInfo a(Context paramContext, long paramLong) {
    try {
      x.c("to find!", new Object[0]);
      ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
      for (byte b1 = 0;; b1++) {
        x.c("waiting!", new Object[0]);
        List list = activityManager.getProcessesInErrorState();
        if (list != null)
          for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : list) {
            if (processErrorStateInfo.condition == 2) {
              x.c("found!", new Object[0]);
              return processErrorStateInfo;
            } 
          }  
        z.b(500L);
        if (b1 >= 20L) {
          x.c("end!", new Object[0]);
          break;
        } 
      } 
    } catch (Exception exception) {
      x.b(exception);
    } 
    return null;
  }
  
  private CrashDetailBean a(a parama) {
    CrashDetailBean crashDetailBean = new CrashDetailBean();
    try {
      String str;
      crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
      crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
      crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
      crashDetailBean.F = this.d.p();
      crashDetailBean.G = this.d.o();
      crashDetailBean.H = this.d.q();
      crashDetailBean.w = z.a(this.c, c.e, null);
      crashDetailBean.b = 3;
      crashDetailBean.e = this.d.h();
      crashDetailBean.f = this.d.j;
      crashDetailBean.g = this.d.w();
      crashDetailBean.m = this.d.g();
      crashDetailBean.n = "ANR_EXCEPTION";
      crashDetailBean.o = parama.f;
      crashDetailBean.q = parama.g;
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      crashDetailBean.O = hashMap;
      crashDetailBean.O.put("BUGLY_CR_01", parama.e);
      int i = -1;
      if (crashDetailBean.q != null)
        i = crashDetailBean.q.indexOf("\n"); 
      if (i > 0) {
        str = crashDetailBean.q.substring(0, i);
      } else {
        str = "GET_FAIL";
      } 
      crashDetailBean.p = str;
      crashDetailBean.r = parama.c;
      if (crashDetailBean.q != null)
        crashDetailBean.u = z.b(crashDetailBean.q.getBytes()); 
      crashDetailBean.z = parama.b;
      crashDetailBean.A = parama.a;
      crashDetailBean.B = "main(1)";
      crashDetailBean.I = this.d.y();
      crashDetailBean.h = this.d.v();
      crashDetailBean.i = this.d.J();
      crashDetailBean.v = parama.d;
      crashDetailBean.L = this.d.n;
      crashDetailBean.M = this.d.a;
      crashDetailBean.N = this.d.a();
      crashDetailBean.P = this.d.H();
      crashDetailBean.Q = this.d.I();
      crashDetailBean.R = this.d.B();
      crashDetailBean.S = this.d.G();
      this.h.c(crashDetailBean);
      crashDetailBean.y = y.a();
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
    } 
    return crashDetailBean;
  }
  
  private boolean a(Context paramContext, String paramString, ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo, long paramLong, Map<String, String> paramMap) {
    int i;
    File file = paramContext.getFilesDir();
    StringBuilder stringBuilder = new StringBuilder("bugly/bugly_trace_");
    stringBuilder.append(paramLong);
    stringBuilder.append(".txt");
    file = new File(file, stringBuilder.toString());
    a a1 = new a();
    a1.c = paramLong;
    a1.d = file.getAbsolutePath();
    if (paramProcessErrorStateInfo != null) {
      str1 = paramProcessErrorStateInfo.processName;
    } else {
      str1 = "";
    } 
    a1.a = str1;
    if (paramProcessErrorStateInfo != null) {
      str1 = paramProcessErrorStateInfo.shortMsg;
    } else {
      str1 = "";
    } 
    a1.f = str1;
    if (paramProcessErrorStateInfo != null) {
      str1 = paramProcessErrorStateInfo.longMsg;
    } else {
      str1 = "";
    } 
    a1.e = str1;
    a1.b = paramMap;
    if (paramMap != null)
      for (String str1 : paramMap.keySet()) {
        if (str1.startsWith("main("))
          a1.g = paramMap.get(str1); 
      }  
    paramLong = a1.c;
    String str2 = a1.d;
    String str3 = a1.a;
    str1 = a1.f;
    String str4 = a1.e;
    if (a1.b == null) {
      i = 0;
    } else {
      i = a1.b.size();
    } 
    x.c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", new Object[] { Long.valueOf(paramLong), str2, str3, str1, str4, Integer.valueOf(i) });
    if (!this.f.b()) {
      x.e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
      com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), a1.a, "main", a1.e, null);
      return false;
    } 
    if (!(this.f.c()).j) {
      x.d("ANR Report is closed!", new Object[0]);
      return false;
    } 
    x.a("found visiable anr , start to upload!", new Object[0]);
    CrashDetailBean crashDetailBean = a(a1);
    if (crashDetailBean == null) {
      x.e("pack anr fail!", new Object[0]);
      return false;
    } 
    c.a().a(crashDetailBean);
    if (crashDetailBean.a >= 0L) {
      x.a("backup anr record success!", new Object[0]);
    } else {
      x.d("backup anr record fail!", new Object[0]);
    } 
    if (paramString != null && (new File(paramString)).exists()) {
      this.a.set(3);
      if (a(paramString, a1.d, a1.a))
        x.a("backup trace success", new Object[0]); 
    } 
    com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), a1.a, "main", a1.e, crashDetailBean);
    if (!this.h.a(crashDetailBean))
      this.h.a(crashDetailBean, 3000L, true); 
    this.h.b(crashDetailBean);
    return true;
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3) {
    TraceFileHelper.a a1 = TraceFileHelper.readTargetDumpInfo(paramString3, paramString1, true);
    if (a1 == null || a1.d == null || a1.d.size() <= 0) {
      x.e("not found trace dump for %s", new Object[] { paramString3 });
      return false;
    } 
    File file = new File(paramString2);
    try {
      String str;
      if (!file.exists()) {
        if (!file.getParentFile().exists())
          file.getParentFile().mkdirs(); 
        file.createNewFile();
      } 
      if (!file.exists() || !file.canWrite()) {
        x.e("backup file create fail %s", new Object[] { paramString2 });
        return false;
      } 
      String[] arrayOfString = null;
      paramString3 = null;
      paramString1 = paramString3;
      try {
        BufferedWriter bufferedWriter = new BufferedWriter();
        paramString1 = paramString3;
        FileWriter fileWriter = new FileWriter();
        paramString1 = paramString3;
        this(file, false);
        paramString1 = paramString3;
        this(fileWriter);
        try {
          arrayOfString = a1.d.get("main");
          if (arrayOfString != null && arrayOfString.length >= 3) {
            paramString1 = arrayOfString[0];
            paramString3 = arrayOfString[1];
            String str1 = arrayOfString[2];
            StringBuilder stringBuilder1 = new StringBuilder();
            this("\"main\" tid=");
            stringBuilder1.append(str1);
            stringBuilder1.append(" :\n");
            stringBuilder1.append(paramString1);
            stringBuilder1.append("\n");
            stringBuilder1.append(paramString3);
            stringBuilder1.append("\n\n");
            bufferedWriter.write(stringBuilder1.toString());
            bufferedWriter.flush();
          } 
          return true;
        } catch (IOException null) {
        
        } finally {
          String str1;
          paramString3 = null;
          BufferedWriter bufferedWriter1 = bufferedWriter;
        } 
      } catch (IOException iOException) {
        paramString2 = str;
      } finally {}
      paramString1 = paramString2;
      if (!x.a(iOException)) {
        paramString1 = paramString2;
        iOException.printStackTrace();
      } 
      paramString1 = paramString2;
      StringBuilder stringBuilder = new StringBuilder();
      paramString1 = paramString2;
      this();
      paramString1 = paramString2;
      stringBuilder.append(iOException.getClass().getName());
      paramString1 = paramString2;
      stringBuilder.append(":");
      paramString1 = paramString2;
      stringBuilder.append(iOException.getMessage());
      paramString1 = paramString2;
      x.e("dump trace fail %s", new Object[] { stringBuilder.toString() });
      if (paramString2 != null)
        try {
          paramString2.close();
        } catch (IOException iOException1) {
          if (!x.a(iOException1))
            iOException1.printStackTrace(); 
        }  
      return false;
    } catch (Exception exception) {
      if (!x.a(exception))
        exception.printStackTrace(); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(exception.getClass().getName());
      stringBuilder.append(":");
      stringBuilder.append(exception.getMessage());
      x.e("backup file create error! %s  %s", new Object[] { stringBuilder.toString(), paramString2 });
      return false;
    } 
  }
  
  private void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 17
    //   6: aload_0
    //   7: invokespecial e : ()V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: goto -> 24
    //   17: aload_0
    //   18: invokespecial f : ()V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   6	10	13	finally
    //   17	21	13	finally
  }
  
  private void c(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: iload_1
    //   7: if_icmpeq -> 33
    //   10: ldc_w 'user change anr %b'
    //   13: iconst_1
    //   14: anewarray java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: iload_1
    //   20: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   23: aastore
    //   24: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   27: pop
    //   28: aload_0
    //   29: iload_1
    //   30: putfield j : Z
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	33	36	finally
  }
  
  private void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial g : ()Z
    //   6: ifeq -> 23
    //   9: ldc_w 'start when started!'
    //   12: iconst_0
    //   13: anewarray java/lang/Object
    //   16: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: new com/tencent/bugly/crashreport/crash/anr/b$1
    //   26: astore_1
    //   27: aload_1
    //   28: aload_0
    //   29: ldc_w '/data/anr/'
    //   32: bipush #8
    //   34: invokespecial <init> : (Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   37: aload_0
    //   38: aload_1
    //   39: putfield i : Landroid/os/FileObserver;
    //   42: aload_0
    //   43: getfield i : Landroid/os/FileObserver;
    //   46: invokevirtual startWatching : ()V
    //   49: ldc_w 'start anr monitor!'
    //   52: iconst_0
    //   53: anewarray java/lang/Object
    //   56: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield e : Lcom/tencent/bugly/proguard/w;
    //   64: astore_2
    //   65: new com/tencent/bugly/crashreport/crash/anr/b$2
    //   68: astore_1
    //   69: aload_1
    //   70: aload_0
    //   71: invokespecial <init> : (Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   74: aload_2
    //   75: aload_1
    //   76: invokevirtual a : (Ljava/lang/Runnable;)Z
    //   79: pop
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield i : Landroid/os/FileObserver;
    //   89: ldc_w 'start anr monitor failed!'
    //   92: iconst_0
    //   93: anewarray java/lang/Object
    //   96: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   99: pop
    //   100: aload_1
    //   101: invokestatic a : (Ljava/lang/Throwable;)Z
    //   104: ifne -> 111
    //   107: aload_1
    //   108: invokevirtual printStackTrace : ()V
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: astore_1
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	114	finally
    //   23	42	114	finally
    //   42	80	83	java/lang/Throwable
    //   42	80	114	finally
    //   84	111	114	finally
  }
  
  private void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial g : ()Z
    //   6: ifne -> 23
    //   9: ldc_w 'close when closed!'
    //   12: iconst_0
    //   13: anewarray java/lang/Object
    //   16: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield i : Landroid/os/FileObserver;
    //   27: invokevirtual stopWatching : ()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield i : Landroid/os/FileObserver;
    //   35: ldc_w 'close anr monitor!'
    //   38: iconst_0
    //   39: anewarray java/lang/Object
    //   42: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: ldc_w 'stop anr monitor failed!'
    //   53: iconst_0
    //   54: anewarray java/lang/Object
    //   57: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_1
    //   62: invokestatic a : (Ljava/lang/Throwable;)Z
    //   65: ifne -> 72
    //   68: aload_1
    //   69: invokevirtual printStackTrace : ()V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	75	finally
    //   23	46	49	java/lang/Throwable
    //   23	46	75	finally
    //   50	72	75	finally
  }
  
  private boolean g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : Landroid/os/FileObserver;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  private boolean h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public final void a(StrategyBean paramStrategyBean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_1
    //   10: getfield j : Z
    //   13: aload_0
    //   14: invokespecial g : ()Z
    //   17: if_icmpeq -> 41
    //   20: ldc_w 'server anr changed to %b'
    //   23: iconst_1
    //   24: anewarray java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: getfield j : Z
    //   33: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   36: aastore
    //   37: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   40: pop
    //   41: getstatic android/os/Build$VERSION.SDK_INT : I
    //   44: bipush #19
    //   46: if_icmpgt -> 104
    //   49: aload_1
    //   50: getfield j : Z
    //   53: ifeq -> 68
    //   56: aload_0
    //   57: invokespecial h : ()Z
    //   60: ifeq -> 68
    //   63: iconst_1
    //   64: istore_2
    //   65: goto -> 70
    //   68: iconst_0
    //   69: istore_2
    //   70: iload_2
    //   71: aload_0
    //   72: invokespecial g : ()Z
    //   75: if_icmpeq -> 101
    //   78: ldc_w 'anr changed to %b'
    //   81: iconst_1
    //   82: anewarray java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: iload_2
    //   88: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   91: aastore
    //   92: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   95: pop
    //   96: aload_0
    //   97: iload_2
    //   98: invokespecial b : (Z)V
    //   101: aload_0
    //   102: monitorexit
    //   103: return
    //   104: aload_1
    //   105: getfield j : Z
    //   108: ifeq -> 119
    //   111: aload_0
    //   112: invokevirtual c : ()Z
    //   115: pop
    //   116: aload_0
    //   117: monitorexit
    //   118: return
    //   119: aload_0
    //   120: invokevirtual d : ()Z
    //   123: pop
    //   124: aload_0
    //   125: monitorexit
    //   126: return
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Exception table:
    //   from	to	target	type
    //   9	41	127	finally
    //   41	63	127	finally
    //   70	101	127	finally
    //   104	116	127	finally
    //   119	124	127	finally
  }
  
  public final void a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual get : ()I
    //   9: ifeq -> 26
    //   12: ldc_w 'trace started return '
    //   15: iconst_0
    //   16: anewarray java/lang/Object
    //   19: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_1
    //   31: invokevirtual set : (I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: ldc_w 'read trace first dump for create time!'
    //   39: iconst_0
    //   40: anewarray java/lang/Object
    //   43: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_1
    //   48: iconst_0
    //   49: invokestatic readFirstDumpInfo : (Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull -> 65
    //   57: aload_2
    //   58: getfield c : J
    //   61: lstore_3
    //   62: goto -> 69
    //   65: ldc2_w -1
    //   68: lstore_3
    //   69: lload_3
    //   70: lstore #5
    //   72: lload_3
    //   73: ldc2_w -1
    //   76: lcmp
    //   77: ifne -> 96
    //   80: ldc_w 'trace dump fail could not get time!'
    //   83: iconst_0
    //   84: anewarray java/lang/Object
    //   87: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   90: pop
    //   91: invokestatic currentTimeMillis : ()J
    //   94: lstore #5
    //   96: lload #5
    //   98: aload_0
    //   99: getfield b : J
    //   102: lsub
    //   103: invokestatic abs : (J)J
    //   106: ldc2_w 10000
    //   109: lcmp
    //   110: ifge -> 142
    //   113: ldc_w 'should not process ANR too Fre in %d'
    //   116: iconst_1
    //   117: anewarray java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: sipush #10000
    //   125: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   128: aastore
    //   129: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   132: pop
    //   133: aload_0
    //   134: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   137: iconst_0
    //   138: invokevirtual set : (I)V
    //   141: return
    //   142: aload_0
    //   143: lload #5
    //   145: putfield b : J
    //   148: aload_0
    //   149: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   152: iconst_1
    //   153: invokevirtual set : (I)V
    //   156: getstatic com/tencent/bugly/crashreport/crash/c.f : I
    //   159: iconst_0
    //   160: invokestatic a : (IZ)Ljava/util/Map;
    //   163: astore_2
    //   164: aload_2
    //   165: ifnull -> 279
    //   168: aload_2
    //   169: invokeinterface size : ()I
    //   174: ifgt -> 180
    //   177: goto -> 279
    //   180: aload_0
    //   181: getfield c : Landroid/content/Context;
    //   184: ldc2_w 10000
    //   187: invokestatic a : (Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   190: astore #7
    //   192: aload #7
    //   194: ifnonnull -> 211
    //   197: ldc_w 'proc state is unvisiable!'
    //   200: iconst_0
    //   201: anewarray java/lang/Object
    //   204: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   207: pop
    //   208: goto -> 133
    //   211: aload #7
    //   213: getfield pid : I
    //   216: invokestatic myPid : ()I
    //   219: if_icmpeq -> 244
    //   222: ldc_w 'not mind proc!'
    //   225: iconst_1
    //   226: anewarray java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload #7
    //   233: getfield processName : Ljava/lang/String;
    //   236: aastore
    //   237: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   240: pop
    //   241: goto -> 133
    //   244: ldc_w 'found visiable anr , start to process!'
    //   247: iconst_0
    //   248: anewarray java/lang/Object
    //   251: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   254: pop
    //   255: aload_0
    //   256: aload_0
    //   257: getfield c : Landroid/content/Context;
    //   260: aload_1
    //   261: aload #7
    //   263: lload #5
    //   265: aload_2
    //   266: invokespecial a : (Landroid/content/Context;Ljava/lang/String;Landroid/app/ActivityManager$ProcessErrorStateInfo;JLjava/util/Map;)Z
    //   269: pop
    //   270: aload_0
    //   271: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   274: iconst_0
    //   275: invokevirtual set : (I)V
    //   278: return
    //   279: ldc_w 'can't get all thread skip this anr'
    //   282: iconst_0
    //   283: anewarray java/lang/Object
    //   286: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   289: pop
    //   290: goto -> 133
    //   293: astore_1
    //   294: aload_1
    //   295: invokestatic a : (Ljava/lang/Throwable;)Z
    //   298: pop
    //   299: ldc_w 'get all thread stack fail!'
    //   302: iconst_0
    //   303: anewarray java/lang/Object
    //   306: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   309: pop
    //   310: goto -> 133
    //   313: astore_1
    //   314: goto -> 353
    //   317: astore_1
    //   318: aload_1
    //   319: invokestatic a : (Ljava/lang/Throwable;)Z
    //   322: ifne -> 329
    //   325: aload_1
    //   326: invokevirtual printStackTrace : ()V
    //   329: ldc_w 'handle anr error %s'
    //   332: iconst_1
    //   333: anewarray java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload_1
    //   339: invokevirtual getClass : ()Ljava/lang/Class;
    //   342: invokevirtual toString : ()Ljava/lang/String;
    //   345: aastore
    //   346: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   349: pop
    //   350: goto -> 270
    //   353: aload_0
    //   354: getfield a : Ljava/util/concurrent/atomic/AtomicInteger;
    //   357: iconst_0
    //   358: invokevirtual set : (I)V
    //   361: aload_1
    //   362: athrow
    //   363: astore_1
    //   364: aload_0
    //   365: monitorexit
    //   366: aload_1
    //   367: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	363	finally
    //   26	36	363	finally
    //   36	53	317	java/lang/Throwable
    //   36	53	313	finally
    //   57	62	317	java/lang/Throwable
    //   57	62	313	finally
    //   80	96	317	java/lang/Throwable
    //   80	96	313	finally
    //   96	133	317	java/lang/Throwable
    //   96	133	313	finally
    //   142	156	317	java/lang/Throwable
    //   142	156	313	finally
    //   156	164	293	java/lang/Throwable
    //   156	164	313	finally
    //   168	177	317	java/lang/Throwable
    //   168	177	313	finally
    //   180	192	317	java/lang/Throwable
    //   180	192	313	finally
    //   197	208	317	java/lang/Throwable
    //   197	208	313	finally
    //   211	241	317	java/lang/Throwable
    //   211	241	313	finally
    //   244	270	317	java/lang/Throwable
    //   244	270	313	finally
    //   279	290	317	java/lang/Throwable
    //   279	290	313	finally
    //   294	310	317	java/lang/Throwable
    //   294	310	313	finally
    //   318	329	313	finally
    //   329	350	313	finally
  }
  
  public final void a(boolean paramBoolean) {
    c(paramBoolean);
    boolean bool = h();
    a a1 = a.a();
    paramBoolean = bool;
    if (a1 != null)
      if (bool && (a1.c()).g) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }  
    if (paramBoolean != g()) {
      x.a("anr changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
      b(paramBoolean);
    } 
  }
  
  public final boolean a() {
    return (this.a.get() != 0);
  }
  
  public final boolean a(Thread paramThread) {
    new HashMap<Object, Object>();
    if (paramThread.getName().contains("main")) {
      ActivityManager.ProcessErrorStateInfo processErrorStateInfo = a(this.c, 10000L);
      if (processErrorStateInfo == null) {
        x.c("anr handler onThreadBlock proc state is unvisiable!", new Object[0]);
        return false;
      } 
      if (processErrorStateInfo.pid != Process.myPid()) {
        x.c("onThreadBlock not mind proc!", new Object[] { processErrorStateInfo.processName });
        return false;
      } 
      try {
        Map<String, String> map = z.a(200000, false);
        x.a("onThreadBlock found visiable anr , start to process!", new Object[0]);
        a(this.c, "", processErrorStateInfo, System.currentTimeMillis(), map);
      } catch (Throwable throwable) {
        return false;
      } 
    } else {
      x.c("anr handler onThreadBlock only care main thread", new Object[0]);
    } 
    return true;
  }
  
  protected final void b() {
    long l1 = z.b();
    long l2 = c.g;
    File file = new File(this.g);
    if (file.exists() && file.isDirectory())
      try {
        Object object;
        File[] arrayOfFile = file.listFiles();
        if (arrayOfFile == null || arrayOfFile.length == 0)
          return; 
        int i = "bugly_trace_".length();
        int j = arrayOfFile.length;
        byte b1 = 0;
        boolean bool = false;
        while (b1 < j) {
          file = arrayOfFile[b1];
          String str = file.getName();
          boolean bool1 = str.startsWith("bugly_trace_");
          Object object1 = object;
          if (bool1) {
            try {
              int k = str.indexOf(".txt");
              if (k > 0) {
                long l = Long.parseLong(str.substring(i, k));
                if (l >= l1 - l2) {
                  Object object2 = object;
                  continue;
                } 
              } 
            } catch (Throwable throwable) {
              StringBuilder stringBuilder1 = new StringBuilder();
              this("Trace file that has invalid format: ");
              stringBuilder1.append(str);
              x.c(stringBuilder1.toString(), new Object[0]);
            } 
            object1 = object;
            if (file.delete())
              int k = object + 1; 
          } 
          continue;
          b1++;
          object = SYNTHETIC_LOCAL_VARIABLE_13;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        this("Number of overdue trace files that has deleted: ");
        stringBuilder.append(object);
        x.c(stringBuilder.toString(), new Object[0]);
        return;
      } catch (Throwable throwable) {
        x.a(throwable);
      }  
  }
  
  public final boolean c() {
    if (this.k != null && this.k.isAlive())
      return false; 
    this.k = new ab();
    ab ab1 = this.k;
    StringBuilder stringBuilder = new StringBuilder("Bugly-ThreadMonitor");
    int i = this.l;
    this.l = i + 1;
    stringBuilder.append(i);
    ab1.setName(stringBuilder.toString());
    this.k.a();
    this.k.a(this);
    return this.k.d();
  }
  
  public final boolean d() {
    boolean bool;
    if (this.k != null) {
      this.k.b();
      this.k.b(this);
      bool = this.k.c();
      this.k = null;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\crash\anr\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */