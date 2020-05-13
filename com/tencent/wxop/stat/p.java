package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;

final class p {
  private static volatile long bU = 0L;
  
  private d bP;
  
  private d bQ = null;
  
  private boolean bR = false;
  
  private Context bS = null;
  
  private long bT = System.currentTimeMillis();
  
  public p(d paramd) {
    this.bP = paramd;
    this.bQ = c.j();
    this.bR = paramd.X();
    this.bS = paramd.J();
  }
  
  private void H() {
    if ((t.ai()).aI > 0 && c.ax) {
      t.ai().b(this.bP, null, this.bR, true);
      t.ai().b(-1);
      return;
    } 
    a(new s(this));
  }
  
  private void a(aj paramaj) {
    ak.Z(e.J()).a(this.bP, paramaj);
  }
  
  public final void ah() {
    // Byte code:
    //   0: getstatic com/tencent/wxop/stat/c.ae : I
    //   3: ifle -> 218
    //   6: aload_0
    //   7: getfield bT : J
    //   10: invokestatic P : ()J
    //   13: lcmp
    //   14: ifle -> 67
    //   17: invokestatic Q : ()Ljava/util/Map;
    //   20: invokeinterface clear : ()V
    //   25: aload_0
    //   26: getfield bT : J
    //   29: getstatic com/tencent/wxop/stat/c.af : J
    //   32: ladd
    //   33: invokestatic c : (J)J
    //   36: pop2
    //   37: invokestatic k : ()Z
    //   40: ifeq -> 67
    //   43: invokestatic K : ()Lcom/tencent/wxop/stat/b/b;
    //   46: new java/lang/StringBuilder
    //   49: dup
    //   50: ldc 'clear methodsCalledLimitMap, nextLimitCallClearTime='
    //   52: invokespecial <init> : (Ljava/lang/String;)V
    //   55: invokestatic P : ()J
    //   58: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   61: invokevirtual toString : ()Ljava/lang/String;
    //   64: invokevirtual b : (Ljava/lang/Object;)V
    //   67: aload_0
    //   68: getfield bP : Lcom/tencent/wxop/stat/a/d;
    //   71: invokevirtual ac : ()Lcom/tencent/wxop/stat/a/e;
    //   74: invokevirtual r : ()I
    //   77: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   80: astore_1
    //   81: invokestatic Q : ()Ljava/util/Map;
    //   84: aload_1
    //   85: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast java/lang/Integer
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull -> 204
    //   98: invokestatic Q : ()Ljava/util/Map;
    //   101: aload_1
    //   102: aload_2
    //   103: invokevirtual intValue : ()I
    //   106: iconst_1
    //   107: iadd
    //   108: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   111: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload_2
    //   118: invokevirtual intValue : ()I
    //   121: getstatic com/tencent/wxop/stat/c.ae : I
    //   124: if_icmple -> 218
    //   127: invokestatic k : ()Z
    //   130: ifeq -> 197
    //   133: invokestatic K : ()Lcom/tencent/wxop/stat/b/b;
    //   136: new java/lang/StringBuilder
    //   139: dup
    //   140: ldc 'event '
    //   142: invokespecial <init> : (Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield bP : Lcom/tencent/wxop/stat/a/d;
    //   149: invokevirtual af : ()Ljava/lang/String;
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc ' was discard, cause of called limit, current:'
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_2
    //   161: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: ldc ', limit:'
    //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: getstatic com/tencent/wxop/stat/c.ae : I
    //   172: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   175: ldc ', period:'
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: getstatic com/tencent/wxop/stat/c.af : J
    //   183: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   186: ldc ' ms'
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual toString : ()Ljava/lang/String;
    //   194: invokevirtual d : (Ljava/lang/Object;)V
    //   197: iconst_1
    //   198: istore_3
    //   199: iload_3
    //   200: ifeq -> 223
    //   203: return
    //   204: invokestatic Q : ()Ljava/util/Map;
    //   207: aload_1
    //   208: iconst_1
    //   209: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   212: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: iconst_0
    //   219: istore_3
    //   220: goto -> 199
    //   223: getstatic com/tencent/wxop/stat/c.ay : I
    //   226: ifle -> 288
    //   229: aload_0
    //   230: getfield bT : J
    //   233: getstatic com/tencent/wxop/stat/p.bU : J
    //   236: lcmp
    //   237: iflt -> 288
    //   240: aload_0
    //   241: getfield bS : Landroid/content/Context;
    //   244: invokestatic p : (Landroid/content/Context;)V
    //   247: aload_0
    //   248: getfield bT : J
    //   251: getstatic com/tencent/wxop/stat/c.az : J
    //   254: ladd
    //   255: putstatic com/tencent/wxop/stat/p.bU : J
    //   258: invokestatic k : ()Z
    //   261: ifeq -> 288
    //   264: invokestatic K : ()Lcom/tencent/wxop/stat/b/b;
    //   267: new java/lang/StringBuilder
    //   270: dup
    //   271: ldc 'nextFlushTime='
    //   273: invokespecial <init> : (Ljava/lang/String;)V
    //   276: getstatic com/tencent/wxop/stat/p.bU : J
    //   279: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   282: invokevirtual toString : ()Ljava/lang/String;
    //   285: invokevirtual b : (Ljava/lang/Object;)V
    //   288: aload_0
    //   289: getfield bS : Landroid/content/Context;
    //   292: invokestatic r : (Landroid/content/Context;)Lcom/tencent/wxop/stat/g;
    //   295: invokevirtual X : ()Z
    //   298: ifeq -> 925
    //   301: invokestatic k : ()Z
    //   304: ifeq -> 331
    //   307: invokestatic K : ()Lcom/tencent/wxop/stat/b/b;
    //   310: new java/lang/StringBuilder
    //   313: dup
    //   314: ldc 'sendFailedCount='
    //   316: invokespecial <init> : (Ljava/lang/String;)V
    //   319: getstatic com/tencent/wxop/stat/e.aI : I
    //   322: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   325: invokevirtual toString : ()Ljava/lang/String;
    //   328: invokevirtual b : (Ljava/lang/Object;)V
    //   331: invokestatic a : ()Z
    //   334: ifne -> 880
    //   337: aload_0
    //   338: getfield bP : Lcom/tencent/wxop/stat/a/d;
    //   341: invokevirtual ae : ()Lcom/tencent/wxop/stat/f;
    //   344: ifnull -> 367
    //   347: aload_0
    //   348: getfield bP : Lcom/tencent/wxop/stat/a/d;
    //   351: invokevirtual ae : ()Lcom/tencent/wxop/stat/f;
    //   354: invokevirtual R : ()Z
    //   357: ifeq -> 367
    //   360: aload_0
    //   361: getstatic com/tencent/wxop/stat/d.aB : Lcom/tencent/wxop/stat/d;
    //   364: putfield bQ : Lcom/tencent/wxop/stat/d;
    //   367: getstatic com/tencent/wxop/stat/c.ah : Z
    //   370: ifeq -> 392
    //   373: invokestatic J : ()Landroid/content/Context;
    //   376: invokestatic r : (Landroid/content/Context;)Lcom/tencent/wxop/stat/g;
    //   379: invokevirtual W : ()Z
    //   382: ifeq -> 392
    //   385: aload_0
    //   386: getstatic com/tencent/wxop/stat/d.aB : Lcom/tencent/wxop/stat/d;
    //   389: putfield bQ : Lcom/tencent/wxop/stat/d;
    //   392: invokestatic k : ()Z
    //   395: ifeq -> 426
    //   398: invokestatic K : ()Lcom/tencent/wxop/stat/b/b;
    //   401: new java/lang/StringBuilder
    //   404: dup
    //   405: ldc 'strategy='
    //   407: invokespecial <init> : (Ljava/lang/String;)V
    //   410: aload_0
    //   411: getfield bQ : Lcom/tencent/wxop/stat/d;
    //   414: invokevirtual name : ()Ljava/lang/String;
    //   417: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual toString : ()Ljava/lang/String;
    //   423: invokevirtual b : (Ljava/lang/Object;)V
    //   426: getstatic com/tencent/wxop/stat/j.bL : [I
    //   429: aload_0
    //   430: getfield bQ : Lcom/tencent/wxop/stat/d;
    //   433: invokevirtual ordinal : ()I
    //   436: iaload
    //   437: tableswitch default -> 480, 1 -> 508, 2 -> 515, 3 -> 759, 4 -> 759, 5 -> 782, 6 -> 812, 7 -> 855
    //   480: invokestatic K : ()Lcom/tencent/wxop/stat/b/b;
    //   483: new java/lang/StringBuilder
    //   486: dup
    //   487: ldc_w 'Invalid stat strategy:'
    //   490: invokespecial <init> : (Ljava/lang/String;)V
    //   493: invokestatic j : ()Lcom/tencent/wxop/stat/d;
    //   496: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   499: invokevirtual toString : ()Ljava/lang/String;
    //   502: invokevirtual error : (Ljava/lang/Object;)V
    //   505: goto -> 203
    //   508: aload_0
    //   509: invokespecial H : ()V
    //   512: goto -> 203
    //   515: aload_0
    //   516: getfield bS : Landroid/content/Context;
    //   519: invokestatic s : (Landroid/content/Context;)Lcom/tencent/wxop/stat/t;
    //   522: aload_0
    //   523: getfield bP : Lcom/tencent/wxop/stat/a/d;
    //   526: aconst_null
    //   527: aload_0
    //   528: getfield bR : Z
    //   531: iconst_0
    //   532: invokevirtual b : (Lcom/tencent/wxop/stat/a/d;Lcom/tencent/wxop/stat/aj;ZZ)V
    //   535: invokestatic k : ()Z
    //   538: ifeq -> 596
    //   541: invokestatic K : ()Lcom/tencent/wxop/stat/b/b;
    //   544: new java/lang/StringBuilder
    //   547: dup
    //   548: ldc_w 'PERIOD currTime='
    //   551: invokespecial <init> : (Ljava/lang/String;)V
    //   554: aload_0
    //   555: getfield bT : J
    //   558: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   561: ldc_w ',nextPeriodSendTs='
    //   564: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: getstatic com/tencent/wxop/stat/e.aZ : J
    //   570: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   573: ldc_w ',difftime='
    //   576: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: getstatic com/tencent/wxop/stat/e.aZ : J
    //   582: aload_0
    //   583: getfield bT : J
    //   586: lsub
    //   587: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   590: invokevirtual toString : ()Ljava/lang/String;
    //   593: invokevirtual b : (Ljava/lang/Object;)V
    //   596: getstatic com/tencent/wxop/stat/e.aZ : J
    //   599: lconst_0
    //   600: lcmp
    //   601: ifne -> 677
    //   604: aload_0
    //   605: getfield bS : Landroid/content/Context;
    //   608: ldc_w 'last_period_ts'
    //   611: invokestatic f : (Landroid/content/Context;Ljava/lang/String;)J
    //   614: putstatic com/tencent/wxop/stat/e.aZ : J
    //   617: aload_0
    //   618: getfield bT : J
    //   621: getstatic com/tencent/wxop/stat/e.aZ : J
    //   624: lcmp
    //   625: ifle -> 635
    //   628: aload_0
    //   629: getfield bS : Landroid/content/Context;
    //   632: invokestatic q : (Landroid/content/Context;)V
    //   635: aload_0
    //   636: getfield bT : J
    //   639: invokestatic u : ()I
    //   642: bipush #60
    //   644: imul
    //   645: sipush #1000
    //   648: imul
    //   649: i2l
    //   650: ladd
    //   651: lstore #4
    //   653: getstatic com/tencent/wxop/stat/e.aZ : J
    //   656: lload #4
    //   658: lcmp
    //   659: ifle -> 667
    //   662: lload #4
    //   664: putstatic com/tencent/wxop/stat/e.aZ : J
    //   667: aload_0
    //   668: getfield bS : Landroid/content/Context;
    //   671: invokestatic Y : (Landroid/content/Context;)Lcom/tencent/wxop/stat/af;
    //   674: invokevirtual ah : ()V
    //   677: invokestatic k : ()Z
    //   680: ifeq -> 738
    //   683: invokestatic K : ()Lcom/tencent/wxop/stat/b/b;
    //   686: new java/lang/StringBuilder
    //   689: dup
    //   690: ldc_w 'PERIOD currTime='
    //   693: invokespecial <init> : (Ljava/lang/String;)V
    //   696: aload_0
    //   697: getfield bT : J
    //   700: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   703: ldc_w ',nextPeriodSendTs='
    //   706: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: getstatic com/tencent/wxop/stat/e.aZ : J
    //   712: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   715: ldc_w ',difftime='
    //   718: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: getstatic com/tencent/wxop/stat/e.aZ : J
    //   724: aload_0
    //   725: getfield bT : J
    //   728: lsub
    //   729: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   732: invokevirtual toString : ()Ljava/lang/String;
    //   735: invokevirtual b : (Ljava/lang/Object;)V
    //   738: aload_0
    //   739: getfield bT : J
    //   742: getstatic com/tencent/wxop/stat/e.aZ : J
    //   745: lcmp
    //   746: ifle -> 203
    //   749: aload_0
    //   750: getfield bS : Landroid/content/Context;
    //   753: invokestatic q : (Landroid/content/Context;)V
    //   756: goto -> 203
    //   759: aload_0
    //   760: getfield bS : Landroid/content/Context;
    //   763: invokestatic s : (Landroid/content/Context;)Lcom/tencent/wxop/stat/t;
    //   766: aload_0
    //   767: getfield bP : Lcom/tencent/wxop/stat/a/d;
    //   770: aconst_null
    //   771: aload_0
    //   772: getfield bR : Z
    //   775: iconst_0
    //   776: invokevirtual b : (Lcom/tencent/wxop/stat/a/d;Lcom/tencent/wxop/stat/aj;ZZ)V
    //   779: goto -> 203
    //   782: aload_0
    //   783: getfield bS : Landroid/content/Context;
    //   786: invokestatic s : (Landroid/content/Context;)Lcom/tencent/wxop/stat/t;
    //   789: aload_0
    //   790: getfield bP : Lcom/tencent/wxop/stat/a/d;
    //   793: new com/tencent/wxop/stat/q
    //   796: dup
    //   797: aload_0
    //   798: invokespecial <init> : (Lcom/tencent/wxop/stat/p;)V
    //   801: aload_0
    //   802: getfield bR : Z
    //   805: iconst_1
    //   806: invokevirtual b : (Lcom/tencent/wxop/stat/a/d;Lcom/tencent/wxop/stat/aj;ZZ)V
    //   809: goto -> 203
    //   812: invokestatic J : ()Landroid/content/Context;
    //   815: invokestatic r : (Landroid/content/Context;)Lcom/tencent/wxop/stat/g;
    //   818: invokevirtual D : ()I
    //   821: iconst_1
    //   822: if_icmpne -> 832
    //   825: aload_0
    //   826: invokespecial H : ()V
    //   829: goto -> 203
    //   832: aload_0
    //   833: getfield bS : Landroid/content/Context;
    //   836: invokestatic s : (Landroid/content/Context;)Lcom/tencent/wxop/stat/t;
    //   839: aload_0
    //   840: getfield bP : Lcom/tencent/wxop/stat/a/d;
    //   843: aconst_null
    //   844: aload_0
    //   845: getfield bR : Z
    //   848: iconst_0
    //   849: invokevirtual b : (Lcom/tencent/wxop/stat/a/d;Lcom/tencent/wxop/stat/aj;ZZ)V
    //   852: goto -> 203
    //   855: aload_0
    //   856: getfield bS : Landroid/content/Context;
    //   859: invokestatic y : (Landroid/content/Context;)Z
    //   862: ifeq -> 203
    //   865: aload_0
    //   866: new com/tencent/wxop/stat/r
    //   869: dup
    //   870: aload_0
    //   871: invokespecial <init> : (Lcom/tencent/wxop/stat/p;)V
    //   874: invokespecial a : (Lcom/tencent/wxop/stat/aj;)V
    //   877: goto -> 203
    //   880: aload_0
    //   881: getfield bS : Landroid/content/Context;
    //   884: invokestatic s : (Landroid/content/Context;)Lcom/tencent/wxop/stat/t;
    //   887: aload_0
    //   888: getfield bP : Lcom/tencent/wxop/stat/a/d;
    //   891: aconst_null
    //   892: aload_0
    //   893: getfield bR : Z
    //   896: iconst_0
    //   897: invokevirtual b : (Lcom/tencent/wxop/stat/a/d;Lcom/tencent/wxop/stat/aj;ZZ)V
    //   900: aload_0
    //   901: getfield bT : J
    //   904: getstatic com/tencent/wxop/stat/e.aX : J
    //   907: lsub
    //   908: ldc2_w 1800000
    //   911: lcmp
    //   912: ifle -> 203
    //   915: aload_0
    //   916: getfield bS : Landroid/content/Context;
    //   919: invokestatic n : (Landroid/content/Context;)V
    //   922: goto -> 203
    //   925: aload_0
    //   926: getfield bS : Landroid/content/Context;
    //   929: invokestatic s : (Landroid/content/Context;)Lcom/tencent/wxop/stat/t;
    //   932: aload_0
    //   933: getfield bP : Lcom/tencent/wxop/stat/a/d;
    //   936: aconst_null
    //   937: aload_0
    //   938: getfield bR : Z
    //   941: iconst_0
    //   942: invokevirtual b : (Lcom/tencent/wxop/stat/a/d;Lcom/tencent/wxop/stat/aj;ZZ)V
    //   945: goto -> 203
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */