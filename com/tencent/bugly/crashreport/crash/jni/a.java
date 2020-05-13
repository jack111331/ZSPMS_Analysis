package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.b;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public final class a implements NativeExceptionHandler {
  private final Context a;
  
  private final b b;
  
  private final com.tencent.bugly.crashreport.common.info.a c;
  
  private final com.tencent.bugly.crashreport.common.strategy.a d;
  
  public a(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1) {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
    this.d = parama1;
  }
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7) {
    x.a("Native Crash Happen v1", new Object[0]);
    handleNativeException2(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7, null);
  }
  
  public final void handleNativeException2(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7, String[] paramArrayOfString) {
    // Byte code:
    //   0: ldc 'Native Crash Happen v2'
    //   2: iconst_0
    //   3: anewarray java/lang/Object
    //   6: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload #9
    //   12: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   15: astore #19
    //   17: ldc 'UNKNOWN'
    //   19: astore #9
    //   21: iload #11
    //   23: ifle -> 86
    //   26: new java/lang/StringBuilder
    //   29: astore #9
    //   31: aload #9
    //   33: invokespecial <init> : ()V
    //   36: aload #9
    //   38: aload #7
    //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload #9
    //   46: ldc '('
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload #9
    //   54: aload #12
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload #9
    //   62: ldc ')'
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload #9
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: astore #9
    //   75: ldc 'UNKNOWN'
    //   77: astore #12
    //   79: ldc 'KERNEL'
    //   81: astore #16
    //   83: goto -> 181
    //   86: iload #13
    //   88: ifle -> 104
    //   91: aload_0
    //   92: getfield a : Landroid/content/Context;
    //   95: astore #9
    //   97: iload #13
    //   99: invokestatic a : (I)Ljava/lang/String;
    //   102: astore #9
    //   104: aload #9
    //   106: iload #13
    //   108: invokestatic valueOf : (I)Ljava/lang/String;
    //   111: invokevirtual equals : (Ljava/lang/Object;)Z
    //   114: ifne -> 169
    //   117: new java/lang/StringBuilder
    //   120: astore #16
    //   122: aload #16
    //   124: invokespecial <init> : ()V
    //   127: aload #16
    //   129: aload #9
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload #16
    //   137: ldc '('
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload #16
    //   145: iload #13
    //   147: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload #16
    //   153: ldc ')'
    //   155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload #16
    //   161: invokevirtual toString : ()Ljava/lang/String;
    //   164: astore #9
    //   166: goto -> 169
    //   169: aload #12
    //   171: astore #16
    //   173: aload #9
    //   175: astore #12
    //   177: aload #7
    //   179: astore #9
    //   181: new java/util/HashMap
    //   184: astore #20
    //   186: aload #20
    //   188: invokespecial <init> : ()V
    //   191: aload #18
    //   193: ifnull -> 294
    //   196: iconst_0
    //   197: istore_1
    //   198: iload_1
    //   199: aload #18
    //   201: arraylength
    //   202: if_icmpge -> 304
    //   205: aload #18
    //   207: iload_1
    //   208: aaload
    //   209: astore #21
    //   211: aload #21
    //   213: ifnull -> 288
    //   216: ldc 'Extra message[%d]: %s'
    //   218: iconst_2
    //   219: anewarray java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: iload_1
    //   225: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: aload #21
    //   233: aastore
    //   234: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   237: pop
    //   238: aload #21
    //   240: ldc '='
    //   242: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   245: astore #7
    //   247: aload #7
    //   249: arraylength
    //   250: iconst_2
    //   251: if_icmpne -> 273
    //   254: aload #20
    //   256: aload #7
    //   258: iconst_0
    //   259: aaload
    //   260: aload #7
    //   262: iconst_1
    //   263: aaload
    //   264: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   269: pop
    //   270: goto -> 288
    //   273: ldc 'bad extraMsg %s'
    //   275: iconst_1
    //   276: anewarray java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: aload #21
    //   283: aastore
    //   284: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   287: pop
    //   288: iinc #1, 1
    //   291: goto -> 198
    //   294: ldc 'not found extraMsg'
    //   296: iconst_0
    //   297: anewarray java/lang/Object
    //   300: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   303: pop
    //   304: aload #20
    //   306: ldc 'HasPendingException'
    //   308: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   313: checkcast java/lang/String
    //   316: astore #7
    //   318: aload #7
    //   320: ifnull -> 349
    //   323: aload #7
    //   325: ldc 'true'
    //   327: invokevirtual equals : (Ljava/lang/Object;)Z
    //   330: ifeq -> 349
    //   333: ldc 'Native crash happened with a Java pending exception.'
    //   335: iconst_0
    //   336: anewarray java/lang/Object
    //   339: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   342: pop
    //   343: iconst_1
    //   344: istore #22
    //   346: goto -> 352
    //   349: iconst_0
    //   350: istore #22
    //   352: aload #20
    //   354: ldc 'ExceptionProcessName'
    //   356: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   361: checkcast java/lang/String
    //   364: astore #18
    //   366: aload #18
    //   368: ifnull -> 400
    //   371: aload #18
    //   373: invokevirtual length : ()I
    //   376: ifne -> 382
    //   379: goto -> 400
    //   382: ldc 'Name of crash process: %s'
    //   384: iconst_1
    //   385: anewarray java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: aload #18
    //   392: aastore
    //   393: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   396: pop
    //   397: goto -> 409
    //   400: aload_0
    //   401: getfield c : Lcom/tencent/bugly/crashreport/common/info/a;
    //   404: getfield d : Ljava/lang/String;
    //   407: astore #18
    //   409: aload #20
    //   411: ldc 'ExceptionThreadName'
    //   413: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   418: checkcast java/lang/String
    //   421: astore #7
    //   423: aload #7
    //   425: ifnull -> 621
    //   428: aload #7
    //   430: invokevirtual length : ()I
    //   433: ifne -> 439
    //   436: goto -> 621
    //   439: ldc 'Name of crash thread: %s'
    //   441: iconst_1
    //   442: anewarray java/lang/Object
    //   445: dup
    //   446: iconst_0
    //   447: aload #7
    //   449: aastore
    //   450: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   453: pop
    //   454: invokestatic getAllStackTraces : ()Ljava/util/Map;
    //   457: invokeinterface keySet : ()Ljava/util/Set;
    //   462: invokeinterface iterator : ()Ljava/util/Iterator;
    //   467: astore #23
    //   469: aload #23
    //   471: invokeinterface hasNext : ()Z
    //   476: ifeq -> 561
    //   479: aload #23
    //   481: invokeinterface next : ()Ljava/lang/Object;
    //   486: checkcast java/lang/Thread
    //   489: astore #21
    //   491: aload #21
    //   493: invokevirtual getName : ()Ljava/lang/String;
    //   496: aload #7
    //   498: invokevirtual equals : (Ljava/lang/Object;)Z
    //   501: ifeq -> 469
    //   504: new java/lang/StringBuilder
    //   507: astore #23
    //   509: aload #23
    //   511: invokespecial <init> : ()V
    //   514: aload #23
    //   516: aload #7
    //   518: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload #23
    //   524: ldc '('
    //   526: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload #23
    //   532: aload #21
    //   534: invokevirtual getId : ()J
    //   537: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload #23
    //   543: ldc ')'
    //   545: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload #23
    //   551: invokevirtual toString : ()Ljava/lang/String;
    //   554: astore #7
    //   556: iconst_1
    //   557: istore_1
    //   558: goto -> 563
    //   561: iconst_0
    //   562: istore_1
    //   563: iload_1
    //   564: ifne -> 618
    //   567: new java/lang/StringBuilder
    //   570: astore #21
    //   572: aload #21
    //   574: invokespecial <init> : ()V
    //   577: aload #21
    //   579: aload #7
    //   581: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload #21
    //   587: ldc '('
    //   589: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload #21
    //   595: iload_2
    //   596: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload #21
    //   602: ldc ')'
    //   604: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload #21
    //   610: invokevirtual toString : ()Ljava/lang/String;
    //   613: astore #7
    //   615: goto -> 681
    //   618: goto -> 681
    //   621: invokestatic currentThread : ()Ljava/lang/Thread;
    //   624: astore #7
    //   626: new java/lang/StringBuilder
    //   629: astore #21
    //   631: aload #21
    //   633: invokespecial <init> : ()V
    //   636: aload #21
    //   638: aload #7
    //   640: invokevirtual getName : ()Ljava/lang/String;
    //   643: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload #21
    //   649: ldc '('
    //   651: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload #21
    //   657: aload #7
    //   659: invokevirtual getId : ()J
    //   662: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload #21
    //   668: ldc ')'
    //   670: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload #21
    //   676: invokevirtual toString : ()Ljava/lang/String;
    //   679: astore #7
    //   681: lload #5
    //   683: ldc2_w 1000
    //   686: ldiv
    //   687: lstore #5
    //   689: aload #20
    //   691: ldc 'SysLogPath'
    //   693: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   698: checkcast java/lang/String
    //   701: astore #21
    //   703: aload #20
    //   705: ldc 'JniLogPath'
    //   707: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   712: checkcast java/lang/String
    //   715: astore #20
    //   717: aload_0
    //   718: getfield d : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   721: invokevirtual b : ()Z
    //   724: ifne -> 737
    //   727: ldc 'no remote but still store!'
    //   729: iconst_0
    //   730: anewarray java/lang/Object
    //   733: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   736: pop
    //   737: aload_0
    //   738: getfield d : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   741: invokevirtual c : ()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   744: getfield g : Z
    //   747: ifne -> 848
    //   750: aload_0
    //   751: getfield d : Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   754: invokevirtual b : ()Z
    //   757: ifeq -> 848
    //   760: ldc 'crash report was closed by remote , will not upload to Bugly , print local for helpful!'
    //   762: iconst_0
    //   763: anewarray java/lang/Object
    //   766: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   769: pop
    //   770: invokestatic a : ()Ljava/lang/String;
    //   773: astore #16
    //   775: new java/lang/StringBuilder
    //   778: astore #12
    //   780: aload #12
    //   782: invokespecial <init> : ()V
    //   785: aload #12
    //   787: aload #9
    //   789: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: pop
    //   793: aload #12
    //   795: ldc '\\n'
    //   797: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: aload #12
    //   803: aload #8
    //   805: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: aload #12
    //   811: ldc '\\n'
    //   813: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload #12
    //   819: aload #19
    //   821: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: ldc 'NATIVE_CRASH'
    //   827: aload #16
    //   829: aload #18
    //   831: aload #7
    //   833: aload #12
    //   835: invokevirtual toString : ()Ljava/lang/String;
    //   838: aconst_null
    //   839: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   842: aload #10
    //   844: invokestatic b : (Ljava/lang/String;)V
    //   847: return
    //   848: aload_0
    //   849: aload #18
    //   851: aload #7
    //   853: lload_3
    //   854: ldc2_w 1000
    //   857: lmul
    //   858: lload #5
    //   860: ladd
    //   861: aload #9
    //   863: aload #8
    //   865: aload #19
    //   867: aload #16
    //   869: aload #12
    //   871: aload #10
    //   873: aload #21
    //   875: aload #20
    //   877: aload #17
    //   879: aconst_null
    //   880: aconst_null
    //   881: iconst_1
    //   882: iload #22
    //   884: invokevirtual packageCrashDatas : (Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/util/Map;ZZ)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   887: astore #10
    //   889: aload #10
    //   891: ifnonnull -> 905
    //   894: ldc 'pkg crash datas fail!'
    //   896: iconst_0
    //   897: anewarray java/lang/Object
    //   900: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   903: pop
    //   904: return
    //   905: invokestatic a : ()Ljava/lang/String;
    //   908: astore #12
    //   910: new java/lang/StringBuilder
    //   913: astore #16
    //   915: aload #16
    //   917: invokespecial <init> : ()V
    //   920: aload #16
    //   922: aload #9
    //   924: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: pop
    //   928: aload #16
    //   930: ldc '\\n'
    //   932: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: aload #16
    //   938: aload #8
    //   940: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: aload #16
    //   946: ldc '\\n'
    //   948: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: pop
    //   952: aload #16
    //   954: aload #19
    //   956: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: pop
    //   960: ldc 'NATIVE_CRASH'
    //   962: aload #12
    //   964: aload #18
    //   966: aload #7
    //   968: aload #16
    //   970: invokevirtual toString : ()Ljava/lang/String;
    //   973: aload #10
    //   975: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   978: aload_0
    //   979: getfield b : Lcom/tencent/bugly/crashreport/crash/b;
    //   982: aload #10
    //   984: iload #11
    //   986: invokevirtual a : (Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;I)Z
    //   989: istore #22
    //   991: aconst_null
    //   992: astore #7
    //   994: invokestatic getInstance : ()Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   997: astore #8
    //   999: aload #8
    //   1001: ifnull -> 1011
    //   1004: aload #8
    //   1006: invokevirtual getDumpFilePath : ()Ljava/lang/String;
    //   1009: astore #7
    //   1011: iconst_1
    //   1012: aload #7
    //   1014: invokestatic a : (ZLjava/lang/String;)V
    //   1017: iload #22
    //   1019: iconst_1
    //   1020: ixor
    //   1021: ifeq -> 1037
    //   1024: aload_0
    //   1025: getfield b : Lcom/tencent/bugly/crashreport/crash/b;
    //   1028: aload #10
    //   1030: ldc2_w 3000
    //   1033: iconst_1
    //   1034: invokevirtual a : (Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;JZ)V
    //   1037: aload_0
    //   1038: getfield b : Lcom/tencent/bugly/crashreport/crash/b;
    //   1041: aload #10
    //   1043: invokevirtual b : (Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   1046: return
    //   1047: astore #7
    //   1049: goto -> 1059
    //   1052: astore #7
    //   1054: goto -> 1059
    //   1057: astore #7
    //   1059: aload #7
    //   1061: invokestatic a : (Ljava/lang/Throwable;)Z
    //   1064: ifne -> 1072
    //   1067: aload #7
    //   1069: invokevirtual printStackTrace : ()V
    //   1072: return
    // Exception table:
    //   from	to	target	type
    //   10	17	1057	java/lang/Throwable
    //   26	75	1057	java/lang/Throwable
    //   91	104	1057	java/lang/Throwable
    //   104	166	1057	java/lang/Throwable
    //   181	191	1057	java/lang/Throwable
    //   198	205	1057	java/lang/Throwable
    //   216	270	1057	java/lang/Throwable
    //   273	288	1057	java/lang/Throwable
    //   294	304	1057	java/lang/Throwable
    //   304	318	1057	java/lang/Throwable
    //   323	343	1057	java/lang/Throwable
    //   352	366	1057	java/lang/Throwable
    //   371	379	1057	java/lang/Throwable
    //   382	397	1057	java/lang/Throwable
    //   400	409	1057	java/lang/Throwable
    //   409	423	1057	java/lang/Throwable
    //   428	436	1057	java/lang/Throwable
    //   439	469	1057	java/lang/Throwable
    //   469	556	1057	java/lang/Throwable
    //   567	615	1057	java/lang/Throwable
    //   621	681	1057	java/lang/Throwable
    //   681	737	1057	java/lang/Throwable
    //   737	847	1057	java/lang/Throwable
    //   848	889	1052	java/lang/Throwable
    //   894	904	1052	java/lang/Throwable
    //   905	978	1052	java/lang/Throwable
    //   978	991	1047	java/lang/Throwable
    //   994	999	1047	java/lang/Throwable
    //   1004	1011	1047	java/lang/Throwable
    //   1011	1017	1047	java/lang/Throwable
    //   1024	1037	1047	java/lang/Throwable
    //   1037	1046	1047	java/lang/Throwable
  }
  
  public final CrashDetailBean packageCrashDatas(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, byte[] paramArrayOfbyte, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2) {
    paramBoolean2 = c.a().k();
    if (paramBoolean2)
      x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]); 
    CrashDetailBean crashDetailBean = new CrashDetailBean();
    crashDetailBean.b = 1;
    crashDetailBean.e = this.c.h();
    crashDetailBean.f = this.c.j;
    crashDetailBean.g = this.c.w();
    crashDetailBean.m = this.c.g();
    crashDetailBean.n = paramString3;
    if (paramBoolean2) {
      paramString3 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
    } else {
      paramString3 = "";
    } 
    crashDetailBean.o = paramString3;
    crashDetailBean.p = paramString4;
    if (paramString5 == null)
      paramString5 = ""; 
    crashDetailBean.q = paramString5;
    crashDetailBean.r = paramLong;
    crashDetailBean.u = z.b(crashDetailBean.q.getBytes());
    crashDetailBean.A = paramString1;
    crashDetailBean.B = paramString2;
    crashDetailBean.I = this.c.y();
    crashDetailBean.h = this.c.v();
    crashDetailBean.i = this.c.J();
    crashDetailBean.v = paramString8;
    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
    if (nativeCrashHandler != null) {
      String str = nativeCrashHandler.getDumpFilePath();
    } else {
      nativeCrashHandler = null;
    } 
    paramString3 = b.a((String)nativeCrashHandler, paramString8);
    if (!z.a(paramString3))
      crashDetailBean.U = paramString3; 
    crashDetailBean.V = b.b((String)nativeCrashHandler);
    crashDetailBean.w = b.a(paramString9, c.e, null, false);
    crashDetailBean.x = b.a(paramString10, c.e, null, true);
    crashDetailBean.J = paramString7;
    crashDetailBean.K = paramString6;
    crashDetailBean.L = paramString11;
    crashDetailBean.F = this.c.p();
    crashDetailBean.G = this.c.o();
    crashDetailBean.H = this.c.q();
    if (paramBoolean1) {
      crashDetailBean.C = b.k();
      crashDetailBean.D = b.i();
      crashDetailBean.E = b.m();
      if (crashDetailBean.w == null)
        crashDetailBean.w = z.a(this.a, c.e, null); 
      crashDetailBean.y = y.a();
      crashDetailBean.M = this.c.a;
      crashDetailBean.N = this.c.a();
      crashDetailBean.P = this.c.H();
      crashDetailBean.Q = this.c.I();
      crashDetailBean.R = this.c.B();
      crashDetailBean.S = this.c.G();
      crashDetailBean.z = z.a(c.f, false);
      int i = crashDetailBean.q.indexOf("java:\n");
      if (i > 0) {
        int j = i + "java:\n".length();
        if (j < crashDetailBean.q.length()) {
          String str = crashDetailBean.q.substring(j, crashDetailBean.q.length() - 1);
          if (str.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B)) {
            paramString3 = (String)crashDetailBean.z.get(crashDetailBean.B);
            i = paramString3.indexOf(str);
            if (i > 0) {
              paramString3 = paramString3.substring(i);
              crashDetailBean.z.put(crashDetailBean.B, paramString3);
              crashDetailBean.q = crashDetailBean.q.substring(0, j);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(crashDetailBean.q);
              stringBuilder.append(paramString3);
              crashDetailBean.q = stringBuilder.toString();
            } 
          } 
        } 
      } 
      if (paramString1 == null)
        crashDetailBean.A = this.c.d; 
      this.b.c(crashDetailBean);
    } else {
      crashDetailBean.C = -1L;
      crashDetailBean.D = -1L;
      crashDetailBean.E = -1L;
      if (crashDetailBean.w == null)
        crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc."; 
      crashDetailBean.M = -1L;
      crashDetailBean.P = -1;
      crashDetailBean.Q = -1;
      crashDetailBean.R = paramMap;
      crashDetailBean.S = this.c.G();
      crashDetailBean.z = null;
      if (paramString1 == null)
        crashDetailBean.A = "unknown(record)"; 
      if (paramArrayOfbyte != null)
        crashDetailBean.y = paramArrayOfbyte; 
    } 
    return crashDetailBean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */