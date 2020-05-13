package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.crashreport.a;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.b;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

public class NativeCrashHandler implements a {
  private static NativeCrashHandler a;
  
  private static boolean l = false;
  
  private static boolean m = false;
  
  private static boolean o = true;
  
  private final Context b;
  
  private final a c;
  
  private final w d;
  
  private NativeExceptionHandler e;
  
  private String f;
  
  private final boolean g;
  
  private boolean h;
  
  private boolean i;
  
  private boolean j;
  
  private boolean k;
  
  private b n;
  
  @SuppressLint({"SdCardPath"})
  private NativeCrashHandler(Context paramContext, a parama, b paramb, w paramw, boolean paramBoolean, String paramString) {
    String str;
    this.h = false;
    this.i = false;
    this.j = false;
    this.k = false;
    this.b = z.a(paramContext);
    try {
      if (z.a(paramString))
        paramString = paramContext.getDir("bugly", 0).getAbsolutePath(); 
    } catch (Throwable throwable) {
      str = (a.a(paramContext)).c;
      StringBuilder stringBuilder = new StringBuilder("/data/data/");
      stringBuilder.append(str);
      stringBuilder.append("/app_bugly");
      str = stringBuilder.toString();
    } 
    this.n = paramb;
    this.f = str;
    this.c = parama;
    this.d = paramw;
    this.g = paramBoolean;
    this.e = new a(paramContext, parama, paramb, a.a());
  }
  
  private void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: ifeq -> 22
    //   9: ldc '[Native] Native crash report has already registered.'
    //   11: iconst_0
    //   12: anewarray java/lang/Object
    //   15: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield i : Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifeq -> 318
    //   31: aload_0
    //   32: aload_0
    //   33: getfield f : Ljava/lang/String;
    //   36: iload_1
    //   37: iconst_1
    //   38: invokevirtual regist : (Ljava/lang/String;ZI)Ljava/lang/String;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull -> 667
    //   46: ldc '[Native] Native Crash Report enable.'
    //   48: iconst_0
    //   49: anewarray java/lang/Object
    //   52: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   55: pop
    //   56: ldc '[Native] Check extra jni for Bugly NDK v%s'
    //   58: iconst_1
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_3
    //   65: aastore
    //   66: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   69: pop
    //   70: ldc '2.1.1'
    //   72: ldc '.'
    //   74: ldc ''
    //   76: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   79: astore #4
    //   81: ldc '2.3.0'
    //   83: ldc '.'
    //   85: ldc ''
    //   87: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   90: astore #5
    //   92: aload_3
    //   93: ldc '.'
    //   95: ldc ''
    //   97: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   100: astore #6
    //   102: aload #6
    //   104: invokevirtual length : ()I
    //   107: iconst_2
    //   108: if_icmpne -> 147
    //   111: new java/lang/StringBuilder
    //   114: astore #7
    //   116: aload #7
    //   118: invokespecial <init> : ()V
    //   121: aload #7
    //   123: aload #6
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload #7
    //   131: ldc '0'
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload #7
    //   139: invokevirtual toString : ()Ljava/lang/String;
    //   142: astore #7
    //   144: goto -> 189
    //   147: aload #6
    //   149: astore #7
    //   151: aload #6
    //   153: invokevirtual length : ()I
    //   156: iconst_1
    //   157: if_icmpne -> 189
    //   160: new java/lang/StringBuilder
    //   163: astore #7
    //   165: aload #7
    //   167: invokespecial <init> : ()V
    //   170: aload #7
    //   172: aload #6
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload #7
    //   180: ldc '00'
    //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: goto -> 137
    //   189: aload #7
    //   191: invokestatic parseInt : (Ljava/lang/String;)I
    //   194: aload #4
    //   196: invokestatic parseInt : (Ljava/lang/String;)I
    //   199: if_icmplt -> 206
    //   202: iconst_1
    //   203: putstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.l : Z
    //   206: aload #7
    //   208: invokestatic parseInt : (Ljava/lang/String;)I
    //   211: aload #5
    //   213: invokestatic parseInt : (Ljava/lang/String;)I
    //   216: if_icmplt -> 223
    //   219: iconst_1
    //   220: putstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.m : Z
    //   223: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.m : Z
    //   226: ifeq -> 242
    //   229: ldc '[Native] Info setting jni can be accessed.'
    //   231: iconst_0
    //   232: anewarray java/lang/Object
    //   235: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   238: pop
    //   239: goto -> 252
    //   242: ldc '[Native] Info setting jni can not be accessed.'
    //   244: iconst_0
    //   245: anewarray java/lang/Object
    //   248: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.l : Z
    //   255: ifeq -> 271
    //   258: ldc '[Native] Extra jni can be accessed.'
    //   260: iconst_0
    //   261: anewarray java/lang/Object
    //   264: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   267: pop
    //   268: goto -> 281
    //   271: ldc '[Native] Extra jni can not be accessed.'
    //   273: iconst_0
    //   274: anewarray java/lang/Object
    //   277: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   280: pop
    //   281: aload_0
    //   282: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   285: aload_3
    //   286: putfield n : Ljava/lang/String;
    //   289: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.l : Z
    //   292: invokestatic a : (Z)V
    //   295: aload_0
    //   296: iconst_1
    //   297: putfield j : Z
    //   300: aload_0
    //   301: monitorexit
    //   302: return
    //   303: astore #7
    //   305: ldc '[Native] Failed to load Bugly SO file.'
    //   307: iconst_0
    //   308: anewarray java/lang/Object
    //   311: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   314: pop
    //   315: goto -> 667
    //   318: aload_0
    //   319: getfield h : Z
    //   322: istore_2
    //   323: iload_2
    //   324: ifeq -> 667
    //   327: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   330: astore #7
    //   332: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   335: astore_3
    //   336: aload_0
    //   337: getfield f : Ljava/lang/String;
    //   340: astore #6
    //   342: aload_0
    //   343: getfield b : Landroid/content/Context;
    //   346: iconst_0
    //   347: invokestatic a : (Landroid/content/Context;Z)Ljava/lang/String;
    //   350: astore #4
    //   352: iconst_5
    //   353: istore #8
    //   355: iload_1
    //   356: ifeq -> 365
    //   359: iconst_1
    //   360: istore #9
    //   362: goto -> 368
    //   365: iconst_5
    //   366: istore #9
    //   368: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   370: ldc 'registNativeExceptionHandler2'
    //   372: aconst_null
    //   373: iconst_4
    //   374: anewarray java/lang/Class
    //   377: dup
    //   378: iconst_0
    //   379: ldc java/lang/String
    //   381: aastore
    //   382: dup
    //   383: iconst_1
    //   384: ldc java/lang/String
    //   386: aastore
    //   387: dup
    //   388: iconst_2
    //   389: aload #7
    //   391: aastore
    //   392: dup
    //   393: iconst_3
    //   394: aload_3
    //   395: aastore
    //   396: iconst_4
    //   397: anewarray java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: aload #6
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: aload #4
    //   409: aastore
    //   410: dup
    //   411: iconst_2
    //   412: iload #9
    //   414: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   417: aastore
    //   418: dup
    //   419: iconst_3
    //   420: iconst_1
    //   421: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   424: aastore
    //   425: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   428: checkcast java/lang/String
    //   431: astore #6
    //   433: aload #6
    //   435: astore #7
    //   437: aload #6
    //   439: ifnonnull -> 524
    //   442: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   445: astore #7
    //   447: aload_0
    //   448: getfield f : Ljava/lang/String;
    //   451: astore_3
    //   452: aload_0
    //   453: getfield b : Landroid/content/Context;
    //   456: iconst_0
    //   457: invokestatic a : (Landroid/content/Context;Z)Ljava/lang/String;
    //   460: astore #6
    //   462: invokestatic b : ()Lcom/tencent/bugly/crashreport/common/info/a;
    //   465: pop
    //   466: invokestatic K : ()I
    //   469: istore #9
    //   471: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   473: ldc 'registNativeExceptionHandler'
    //   475: aconst_null
    //   476: iconst_3
    //   477: anewarray java/lang/Class
    //   480: dup
    //   481: iconst_0
    //   482: ldc java/lang/String
    //   484: aastore
    //   485: dup
    //   486: iconst_1
    //   487: ldc java/lang/String
    //   489: aastore
    //   490: dup
    //   491: iconst_2
    //   492: aload #7
    //   494: aastore
    //   495: iconst_3
    //   496: anewarray java/lang/Object
    //   499: dup
    //   500: iconst_0
    //   501: aload_3
    //   502: aastore
    //   503: dup
    //   504: iconst_1
    //   505: aload #6
    //   507: aastore
    //   508: dup
    //   509: iconst_2
    //   510: iload #9
    //   512: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   515: aastore
    //   516: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   519: checkcast java/lang/String
    //   522: astore #7
    //   524: aload #7
    //   526: ifnull -> 667
    //   529: aload_0
    //   530: iconst_1
    //   531: putfield j : Z
    //   534: invokestatic b : ()Lcom/tencent/bugly/crashreport/common/info/a;
    //   537: aload #7
    //   539: putfield n : Ljava/lang/String;
    //   542: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   544: ldc 'checkExtraJni'
    //   546: aconst_null
    //   547: iconst_1
    //   548: anewarray java/lang/Class
    //   551: dup
    //   552: iconst_0
    //   553: ldc java/lang/String
    //   555: aastore
    //   556: iconst_1
    //   557: anewarray java/lang/Object
    //   560: dup
    //   561: iconst_0
    //   562: aload #7
    //   564: aastore
    //   565: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   568: checkcast java/lang/Boolean
    //   571: astore #7
    //   573: aload #7
    //   575: ifnull -> 592
    //   578: aload #7
    //   580: invokevirtual booleanValue : ()Z
    //   583: istore_2
    //   584: iload_2
    //   585: putstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.l : Z
    //   588: iload_2
    //   589: invokestatic a : (Z)V
    //   592: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   594: ldc 'enableHandler'
    //   596: aconst_null
    //   597: iconst_1
    //   598: anewarray java/lang/Class
    //   601: dup
    //   602: iconst_0
    //   603: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   606: aastore
    //   607: iconst_1
    //   608: anewarray java/lang/Object
    //   611: dup
    //   612: iconst_0
    //   613: iconst_1
    //   614: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   617: aastore
    //   618: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   621: pop
    //   622: iload #8
    //   624: istore #9
    //   626: iload_1
    //   627: ifeq -> 633
    //   630: iconst_1
    //   631: istore #9
    //   633: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   635: ldc 'setLogMode'
    //   637: aconst_null
    //   638: iconst_1
    //   639: anewarray java/lang/Class
    //   642: dup
    //   643: iconst_0
    //   644: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   647: aastore
    //   648: iconst_1
    //   649: anewarray java/lang/Object
    //   652: dup
    //   653: iconst_0
    //   654: iload #9
    //   656: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   659: aastore
    //   660: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   663: pop
    //   664: aload_0
    //   665: monitorexit
    //   666: return
    //   667: aload_0
    //   668: iconst_0
    //   669: putfield i : Z
    //   672: aload_0
    //   673: iconst_0
    //   674: putfield h : Z
    //   677: aload_0
    //   678: monitorexit
    //   679: return
    //   680: astore #7
    //   682: aload_0
    //   683: monitorexit
    //   684: aload #7
    //   686: athrow
    //   687: astore #7
    //   689: goto -> 223
    //   692: astore #7
    //   694: goto -> 667
    // Exception table:
    //   from	to	target	type
    //   2	19	680	finally
    //   22	27	680	finally
    //   31	42	303	java/lang/Throwable
    //   31	42	680	finally
    //   46	137	303	java/lang/Throwable
    //   46	137	680	finally
    //   137	144	303	java/lang/Throwable
    //   137	144	680	finally
    //   151	186	303	java/lang/Throwable
    //   151	186	680	finally
    //   189	206	687	java/lang/Throwable
    //   189	206	680	finally
    //   206	223	687	java/lang/Throwable
    //   206	223	680	finally
    //   223	239	303	java/lang/Throwable
    //   223	239	680	finally
    //   242	252	303	java/lang/Throwable
    //   242	252	680	finally
    //   252	268	303	java/lang/Throwable
    //   252	268	680	finally
    //   271	281	303	java/lang/Throwable
    //   271	281	680	finally
    //   281	300	303	java/lang/Throwable
    //   281	300	680	finally
    //   305	315	680	finally
    //   318	323	680	finally
    //   327	352	692	java/lang/Throwable
    //   327	352	680	finally
    //   368	433	692	java/lang/Throwable
    //   368	433	680	finally
    //   442	524	692	java/lang/Throwable
    //   442	524	680	finally
    //   529	573	692	java/lang/Throwable
    //   529	573	680	finally
    //   578	592	692	java/lang/Throwable
    //   578	592	680	finally
    //   592	622	692	java/lang/Throwable
    //   592	622	680	finally
    //   633	664	692	java/lang/Throwable
    //   633	664	680	finally
    //   667	677	680	finally
  }
  
  private boolean a(int paramInt, String paramString) {
    if (!this.i || !m)
      return false; 
    try {
      setNativeInfo(paramInt, paramString);
      return true;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      m = false;
      return false;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return false;
    } 
  }
  
  private static boolean a(String paramString, boolean paramBoolean) {
    boolean bool = true;
    try {
      x.a("[Native] Trying to load so: %s", new Object[] { paramString });
      if (paramBoolean) {
        System.load(paramString);
      } else {
        System.loadLibrary(paramString);
      } 
      try {
        x.a("[Native] Successfully loaded SO: %s", new Object[] { paramString });
        paramBoolean = bool;
      } catch (Throwable null) {
        paramBoolean = true;
      } 
    } catch (Throwable throwable) {
      paramBoolean = false;
    } 
    x.d(throwable.getMessage(), new Object[0]);
    x.d("[Native] Failed to load so: %s", new Object[] { paramString });
  }
  
  private void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 17
    //   6: aload_0
    //   7: invokevirtual startNativeMonitor : ()V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: goto -> 24
    //   17: aload_0
    //   18: invokespecial c : ()V
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
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Z
    //   6: ifne -> 23
    //   9: ldc_w '[Native] Native crash report has already unregistered.'
    //   12: iconst_0
    //   13: anewarray java/lang/Object
    //   16: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: invokevirtual unregist : ()Ljava/lang/String;
    //   27: ifnull -> 61
    //   30: ldc_w '[Native] Successfully closed native crash report.'
    //   33: iconst_0
    //   34: anewarray java/lang/Object
    //   37: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield j : Z
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: ldc_w '[Native] Failed to close native crash report.'
    //   53: iconst_0
    //   54: anewarray java/lang/Object
    //   57: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: ldc 'com.tencent.feedback.eup.jni.NativeExceptionUpload'
    //   63: ldc 'enableHandler'
    //   65: aconst_null
    //   66: iconst_1
    //   67: anewarray java/lang/Class
    //   70: dup
    //   71: iconst_0
    //   72: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   75: aastore
    //   76: iconst_1
    //   77: anewarray java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: iconst_0
    //   83: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   86: aastore
    //   87: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield j : Z
    //   96: ldc_w '[Native] Successfully closed native crash report.'
    //   99: iconst_0
    //   100: anewarray java/lang/Object
    //   103: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: astore_1
    //   111: ldc_w '[Native] Failed to close native crash report.'
    //   114: iconst_0
    //   115: anewarray java/lang/Object
    //   118: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield i : Z
    //   127: aload_0
    //   128: iconst_0
    //   129: putfield h : Z
    //   132: aload_0
    //   133: monitorexit
    //   134: return
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	135	finally
    //   23	46	49	java/lang/Throwable
    //   23	46	135	finally
    //   50	61	135	finally
    //   61	107	110	java/lang/Throwable
    //   61	107	135	finally
    //   111	132	135	finally
  }
  
  private void c(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Z
    //   6: iload_1
    //   7: if_icmpeq -> 33
    //   10: ldc_w 'user change native %b'
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
    //   30: putfield k : Z
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
  
  public static NativeCrashHandler getInstance() {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static NativeCrashHandler getInstance(Context paramContext, a parama, b paramb, a parama1, w paramw, boolean paramBoolean, String paramString) {
    // Byte code:
    //   0: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   6: ifnonnull -> 30
    //   9: new com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   12: astore_3
    //   13: aload_3
    //   14: aload_0
    //   15: aload_1
    //   16: aload_2
    //   17: aload #4
    //   19: iload #5
    //   21: aload #6
    //   23: invokespecial <init> : (Landroid/content/Context;Lcom/tencent/bugly/crashreport/common/info/a;Lcom/tencent/bugly/crashreport/crash/b;Lcom/tencent/bugly/proguard/w;ZLjava/lang/String;)V
    //   26: aload_3
    //   27: putstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   30: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.a : Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   33: astore_0
    //   34: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: ldc com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	30	39	finally
    //   30	34	39	finally
  }
  
  public static boolean isShouldHandleInJava() {
    return o;
  }
  
  public static void setShouldHandleInJava(boolean paramBoolean) {
    o = paramBoolean;
    if (a != null) {
      NativeCrashHandler nativeCrashHandler = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramBoolean);
      nativeCrashHandler.a(999, stringBuilder.toString());
    } 
  }
  
  protected final void a() {
    // Byte code:
    //   0: invokestatic b : ()J
    //   3: lstore_1
    //   4: getstatic com/tencent/bugly/crashreport/crash/c.g : J
    //   7: lstore_3
    //   8: invokestatic b : ()J
    //   11: lstore #5
    //   13: new java/io/File
    //   16: dup
    //   17: aload_0
    //   18: getfield f : Ljava/lang/String;
    //   21: invokespecial <init> : (Ljava/lang/String;)V
    //   24: astore #7
    //   26: aload #7
    //   28: invokevirtual exists : ()Z
    //   31: ifeq -> 226
    //   34: aload #7
    //   36: invokevirtual isDirectory : ()Z
    //   39: ifeq -> 226
    //   42: aload #7
    //   44: invokevirtual listFiles : ()[Ljava/io/File;
    //   47: astore #8
    //   49: aload #8
    //   51: ifnull -> 217
    //   54: aload #8
    //   56: arraylength
    //   57: ifne -> 63
    //   60: goto -> 217
    //   63: aload #8
    //   65: arraylength
    //   66: istore #9
    //   68: iconst_0
    //   69: istore #10
    //   71: iconst_0
    //   72: istore #11
    //   74: iconst_0
    //   75: istore #12
    //   77: iload #10
    //   79: iload #9
    //   81: if_icmpge -> 189
    //   84: aload #8
    //   86: iload #10
    //   88: aaload
    //   89: astore #7
    //   91: aload #7
    //   93: invokevirtual lastModified : ()J
    //   96: lstore #13
    //   98: lload #13
    //   100: lload_1
    //   101: lload_3
    //   102: lsub
    //   103: lcmp
    //   104: iflt -> 127
    //   107: iload #11
    //   109: istore #15
    //   111: iload #12
    //   113: istore #16
    //   115: lload #13
    //   117: lload #5
    //   119: ldc2_w 86400000
    //   122: ladd
    //   123: lcmp
    //   124: iflt -> 175
    //   127: ldc_w '[Native] Delete record file: %s'
    //   130: iconst_1
    //   131: anewarray java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload #7
    //   138: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   141: aastore
    //   142: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   145: pop
    //   146: iinc #11, 1
    //   149: iload #11
    //   151: istore #15
    //   153: iload #12
    //   155: istore #16
    //   157: aload #7
    //   159: invokevirtual delete : ()Z
    //   162: ifeq -> 175
    //   165: iload #12
    //   167: iconst_1
    //   168: iadd
    //   169: istore #16
    //   171: iload #11
    //   173: istore #15
    //   175: iinc #10, 1
    //   178: iload #15
    //   180: istore #11
    //   182: iload #16
    //   184: istore #12
    //   186: goto -> 77
    //   189: ldc_w '[Native] Number of record files overdue: %d, has deleted: %d'
    //   192: iconst_2
    //   193: anewarray java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: iload #11
    //   200: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: iload #12
    //   208: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   211: aastore
    //   212: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   215: pop
    //   216: return
    //   217: return
    //   218: astore #7
    //   220: aload #7
    //   222: invokestatic a : (Ljava/lang/Throwable;)Z
    //   225: pop
    //   226: return
    // Exception table:
    //   from	to	target	type
    //   42	49	218	java/lang/Throwable
    //   54	60	218	java/lang/Throwable
    //   63	68	218	java/lang/Throwable
    //   91	98	218	java/lang/Throwable
    //   127	146	218	java/lang/Throwable
    //   157	165	218	java/lang/Throwable
    //   189	216	218	java/lang/Throwable
  }
  
  public boolean appendLogToNative(String paramString1, String paramString2, String paramString3) {
    if (!this.h && !this.i)
      return false; 
    if (!l)
      return false; 
    if (paramString1 == null || paramString2 == null || paramString3 == null)
      return false; 
    try {
      if (this.i)
        return appendNativeLog(paramString1, paramString2, paramString3); 
      Boolean bool = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return (bool != null) ? bool.booleanValue() : false;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      l = false;
      return false;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return false;
    } 
  }
  
  protected native boolean appendNativeLog(String paramString1, String paramString2, String paramString3);
  
  protected native boolean appendWholeNativeLog(String paramString);
  
  public void checkUploadRecordCrash() {
    this.d.a(new Runnable(this) {
          public final void run() {
            if (!z.a(NativeCrashHandler.a(this.a), "native_record_lock", 10000L)) {
              x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
              return;
            } 
            if (!NativeCrashHandler.b())
              NativeCrashHandler.a(this.a, 999, "false"); 
            CrashDetailBean crashDetailBean = b.a(NativeCrashHandler.a(this.a), NativeCrashHandler.b(this.a), NativeCrashHandler.c(this.a));
            if (crashDetailBean != null) {
              x.a("[Native] Get crash from native record.", new Object[0]);
              if (!NativeCrashHandler.d(this.a).a(crashDetailBean))
                NativeCrashHandler.d(this.a).a(crashDetailBean, 3000L, false); 
              b.a(false, NativeCrashHandler.b(this.a));
            } 
            this.a.a();
            z.b(NativeCrashHandler.a(this.a), "native_record_lock");
          }
        });
  }
  
  public boolean filterSigabrtSysLog() {
    return a(998, "true");
  }
  
  public String getDumpFilePath() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public String getLogFromNative() {
    if (!this.h && !this.i)
      return null; 
    if (!l)
      return null; 
    try {
      return this.i ? getNativeLog() : (String)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      l = false;
      return null;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public NativeExceptionHandler getNativeExceptionHandler() {
    return this.e;
  }
  
  protected native String getNativeKeyValueList();
  
  protected native String getNativeLog();
  
  public boolean isUserOpened() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Z
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
  
  public void onStrategyChanged(StrategyBean paramStrategyBean) {
    boolean bool;
    /* monitor enter ThisExpression{ObjectType{com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler}} */
    if (paramStrategyBean != null)
      try {
        if (paramStrategyBean.g != this.j)
          x.d("server native changed to %b", new Object[] { Boolean.valueOf(paramStrategyBean.g) }); 
      } finally {} 
    if ((a.a().c()).g && this.k) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool != this.j) {
      x.a("native changed to %b", new Object[] { Boolean.valueOf(bool) });
      b(bool);
    } 
    /* monitor exit ThisExpression{ObjectType{com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler}} */
  }
  
  public boolean putKeyValueToNative(String paramString1, String paramString2) {
    if (!this.h && !this.i)
      return false; 
    if (!l)
      return false; 
    if (paramString1 == null || paramString2 == null)
      return false; 
    try {
      if (this.i)
        return putNativeKeyValue(paramString1, paramString2); 
      Boolean bool = (Boolean)z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[] { String.class, String.class }, new Object[] { paramString1, paramString2 });
      return (bool != null) ? bool.booleanValue() : false;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      l = false;
      return false;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return false;
    } 
  }
  
  protected native boolean putNativeKeyValue(String paramString1, String paramString2);
  
  protected native String regist(String paramString, boolean paramBoolean, int paramInt);
  
  public void removeEmptyNativeRecordFiles() {
    b.c(this.f);
  }
  
  protected native String removeNativeKeyValue(String paramString);
  
  public void setDumpFilePath(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield f : Ljava/lang/String;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public boolean setNativeAppChannel(String paramString) {
    return a(12, paramString);
  }
  
  public boolean setNativeAppPackage(String paramString) {
    return a(13, paramString);
  }
  
  public boolean setNativeAppVersion(String paramString) {
    return a(10, paramString);
  }
  
  protected native void setNativeInfo(int paramInt, String paramString);
  
  public boolean setNativeIsAppForeground(boolean paramBoolean) {
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    } 
    return a(14, str);
  }
  
  public boolean setNativeLaunchTime(long paramLong) {
    try {
      return a(15, String.valueOf(paramLong));
    } catch (NumberFormatException numberFormatException) {
      if (!x.a(numberFormatException))
        numberFormatException.printStackTrace(); 
      return false;
    } 
  }
  
  public boolean setNativeUserId(String paramString) {
    return a(11, paramString);
  }
  
  public void setUserOpened(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial c : (Z)V
    //   7: aload_0
    //   8: invokevirtual isUserOpened : ()Z
    //   11: istore_2
    //   12: invokestatic a : ()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   15: astore_3
    //   16: iload_2
    //   17: istore_1
    //   18: aload_3
    //   19: ifnull -> 43
    //   22: iload_2
    //   23: ifeq -> 41
    //   26: aload_3
    //   27: invokevirtual c : ()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   30: getfield g : Z
    //   33: ifeq -> 41
    //   36: iconst_1
    //   37: istore_1
    //   38: goto -> 43
    //   41: iconst_0
    //   42: istore_1
    //   43: iload_1
    //   44: aload_0
    //   45: getfield j : Z
    //   48: if_icmpeq -> 74
    //   51: ldc_w 'native changed to %b'
    //   54: iconst_1
    //   55: anewarray java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: iload_1
    //   61: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   64: aastore
    //   65: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   68: pop
    //   69: aload_0
    //   70: iload_1
    //   71: invokespecial b : (Z)V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	77	finally
    //   26	36	77	finally
    //   43	74	77	finally
  }
  
  public void startNativeMonitor() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : Z
    //   6: ifne -> 178
    //   9: aload_0
    //   10: getfield h : Z
    //   13: ifeq -> 19
    //   16: goto -> 178
    //   19: ldc_w 'Bugly'
    //   22: astore_1
    //   23: aload_0
    //   24: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   27: getfield m : Ljava/lang/String;
    //   30: invokestatic a : (Ljava/lang/String;)Z
    //   33: iconst_1
    //   34: ixor
    //   35: istore_2
    //   36: aload_0
    //   37: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   40: getfield m : Ljava/lang/String;
    //   43: astore_3
    //   44: iload_2
    //   45: ifne -> 61
    //   48: aload_0
    //   49: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   52: invokevirtual getClass : ()Ljava/lang/Class;
    //   55: pop
    //   56: aload_1
    //   57: astore_3
    //   58: goto -> 61
    //   61: aload_0
    //   62: aload_3
    //   63: iload_2
    //   64: invokestatic a : (Ljava/lang/String;Z)Z
    //   67: putfield i : Z
    //   70: aload_0
    //   71: getfield i : Z
    //   74: ifne -> 89
    //   77: aload_0
    //   78: getfield h : Z
    //   81: istore_2
    //   82: iload_2
    //   83: ifne -> 89
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: aload_0
    //   90: aload_0
    //   91: getfield g : Z
    //   94: invokespecial a : (Z)V
    //   97: getstatic com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler.l : Z
    //   100: ifeq -> 175
    //   103: aload_0
    //   104: aload_0
    //   105: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   108: getfield j : Ljava/lang/String;
    //   111: invokevirtual setNativeAppVersion : (Ljava/lang/String;)Z
    //   114: pop
    //   115: aload_0
    //   116: aload_0
    //   117: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   120: getfield l : Ljava/lang/String;
    //   123: invokevirtual setNativeAppChannel : (Ljava/lang/String;)Z
    //   126: pop
    //   127: aload_0
    //   128: aload_0
    //   129: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   132: getfield c : Ljava/lang/String;
    //   135: invokevirtual setNativeAppPackage : (Ljava/lang/String;)Z
    //   138: pop
    //   139: aload_0
    //   140: aload_0
    //   141: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   144: invokevirtual g : ()Ljava/lang/String;
    //   147: invokevirtual setNativeUserId : (Ljava/lang/String;)Z
    //   150: pop
    //   151: aload_0
    //   152: aload_0
    //   153: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   156: invokevirtual a : ()Z
    //   159: invokevirtual setNativeIsAppForeground : (Z)Z
    //   162: pop
    //   163: aload_0
    //   164: aload_0
    //   165: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   168: getfield a : J
    //   171: invokevirtual setNativeLaunchTime : (J)Z
    //   174: pop
    //   175: aload_0
    //   176: monitorexit
    //   177: return
    //   178: aload_0
    //   179: aload_0
    //   180: getfield g : Z
    //   183: invokespecial a : (Z)V
    //   186: aload_0
    //   187: monitorexit
    //   188: return
    //   189: astore_3
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_3
    //   193: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	189	finally
    //   23	44	189	finally
    //   48	56	189	finally
    //   61	82	189	finally
    //   89	175	189	finally
    //   178	186	189	finally
  }
  
  protected native void testCrash();
  
  public void testNativeCrash() {
    if (!this.i) {
      x.d("[Native] Bugly SO file has not been load.", new Object[0]);
      return;
    } 
    testCrash();
  }
  
  public void testNativeCrash(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBoolean1);
    a(16, stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramBoolean2);
    a(17, stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramBoolean3);
    a(18, stringBuilder.toString());
    testNativeCrash();
  }
  
  protected native String unregist();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\NativeCrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */