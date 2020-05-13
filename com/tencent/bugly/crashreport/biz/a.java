package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;

public final class a {
  private Context a;
  
  private long b;
  
  private int c;
  
  private boolean d = true;
  
  public a(Context paramContext, boolean paramBoolean) {
    this.a = paramContext;
    this.d = paramBoolean;
  }
  
  private static ContentValues a(UserInfoBean paramUserInfoBean) {
    if (paramUserInfoBean == null)
      return null; 
    try {
      ContentValues contentValues = new ContentValues();
      this();
      if (paramUserInfoBean.a > 0L)
        contentValues.put("_id", Long.valueOf(paramUserInfoBean.a)); 
      contentValues.put("_tm", Long.valueOf(paramUserInfoBean.e));
      contentValues.put("_ut", Long.valueOf(paramUserInfoBean.f));
      contentValues.put("_tp", Integer.valueOf(paramUserInfoBean.b));
      contentValues.put("_pc", paramUserInfoBean.c);
      contentValues.put("_dt", z.a(paramUserInfoBean));
      return contentValues;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  private static UserInfoBean a(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null)
        return null; 
      long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      UserInfoBean userInfoBean = (UserInfoBean)z.a(arrayOfByte, UserInfoBean.CREATOR);
      if (userInfoBean != null)
        userInfoBean.a = l; 
      return userInfoBean;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  private static void a(List<UserInfoBean> paramList) {
    if (paramList == null || paramList.size() == 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramList.size() && b < 50; b++) {
      UserInfoBean userInfoBean = paramList.get(b);
      stringBuilder.append(" or _id");
      stringBuilder.append(" = ");
      stringBuilder.append(userInfoBean.a);
    } 
    String str2 = stringBuilder.toString();
    String str1 = str2;
    if (str2.length() > 0)
      str1 = str2.substring(4); 
    stringBuilder.setLength(0);
    try {
      x.c("[Database] deleted %s data %d", new Object[] { "t_ui", Integer.valueOf(p.a().a("t_ui", str1, null, null, true)) });
      return;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return;
    } 
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic a : ()Lcom/tencent/bugly/proguard/u;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: invokestatic a : ()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnonnull -> 36
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: aload_3
    //   37: invokevirtual b : ()Z
    //   40: ifeq -> 58
    //   43: aload_2
    //   44: sipush #1001
    //   47: invokevirtual b : (I)Z
    //   50: istore_1
    //   51: iload_1
    //   52: ifne -> 58
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: aload_0
    //   59: getfield a : Landroid/content/Context;
    //   62: invokestatic a : (Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   65: getfield d : Ljava/lang/String;
    //   68: astore_3
    //   69: new java/util/ArrayList
    //   72: astore #4
    //   74: aload #4
    //   76: invokespecial <init> : ()V
    //   79: aload_0
    //   80: aload_3
    //   81: invokevirtual a : (Ljava/lang/String;)Ljava/util/List;
    //   84: astore #5
    //   86: aload #5
    //   88: ifnull -> 424
    //   91: aload #5
    //   93: invokeinterface size : ()I
    //   98: bipush #20
    //   100: isub
    //   101: istore #6
    //   103: iload #6
    //   105: ifle -> 270
    //   108: iconst_0
    //   109: istore #7
    //   111: iload #7
    //   113: aload #5
    //   115: invokeinterface size : ()I
    //   120: iconst_1
    //   121: isub
    //   122: if_icmpge -> 237
    //   125: iload #7
    //   127: iconst_1
    //   128: iadd
    //   129: istore #8
    //   131: iload #8
    //   133: istore #9
    //   135: iload #9
    //   137: aload #5
    //   139: invokeinterface size : ()I
    //   144: if_icmpge -> 230
    //   147: aload #5
    //   149: iload #7
    //   151: invokeinterface get : (I)Ljava/lang/Object;
    //   156: checkcast com/tencent/bugly/crashreport/biz/UserInfoBean
    //   159: getfield e : J
    //   162: aload #5
    //   164: iload #9
    //   166: invokeinterface get : (I)Ljava/lang/Object;
    //   171: checkcast com/tencent/bugly/crashreport/biz/UserInfoBean
    //   174: getfield e : J
    //   177: lcmp
    //   178: ifle -> 224
    //   181: aload #5
    //   183: iload #7
    //   185: invokeinterface get : (I)Ljava/lang/Object;
    //   190: checkcast com/tencent/bugly/crashreport/biz/UserInfoBean
    //   193: astore_3
    //   194: aload #5
    //   196: iload #7
    //   198: aload #5
    //   200: iload #9
    //   202: invokeinterface get : (I)Ljava/lang/Object;
    //   207: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload #5
    //   215: iload #9
    //   217: aload_3
    //   218: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   223: pop
    //   224: iinc #9, 1
    //   227: goto -> 135
    //   230: iload #8
    //   232: istore #7
    //   234: goto -> 111
    //   237: iconst_0
    //   238: istore #7
    //   240: iload #7
    //   242: iload #6
    //   244: if_icmpge -> 270
    //   247: aload #4
    //   249: aload #5
    //   251: iload #7
    //   253: invokeinterface get : (I)Ljava/lang/Object;
    //   258: invokeinterface add : (Ljava/lang/Object;)Z
    //   263: pop
    //   264: iinc #7, 1
    //   267: goto -> 240
    //   270: aload #5
    //   272: invokeinterface iterator : ()Ljava/util/Iterator;
    //   277: astore #10
    //   279: iconst_0
    //   280: istore #7
    //   282: aload #10
    //   284: invokeinterface hasNext : ()Z
    //   289: ifeq -> 386
    //   292: aload #10
    //   294: invokeinterface next : ()Ljava/lang/Object;
    //   299: checkcast com/tencent/bugly/crashreport/biz/UserInfoBean
    //   302: astore_3
    //   303: aload_3
    //   304: getfield f : J
    //   307: ldc2_w -1
    //   310: lcmp
    //   311: ifeq -> 341
    //   314: aload #10
    //   316: invokeinterface remove : ()V
    //   321: aload_3
    //   322: getfield e : J
    //   325: invokestatic b : ()J
    //   328: lcmp
    //   329: ifge -> 341
    //   332: aload #4
    //   334: aload_3
    //   335: invokeinterface add : (Ljava/lang/Object;)Z
    //   340: pop
    //   341: aload_3
    //   342: getfield e : J
    //   345: invokestatic currentTimeMillis : ()J
    //   348: ldc2_w 600000
    //   351: lsub
    //   352: lcmp
    //   353: ifle -> 282
    //   356: aload_3
    //   357: getfield b : I
    //   360: iconst_1
    //   361: if_icmpeq -> 380
    //   364: aload_3
    //   365: getfield b : I
    //   368: iconst_4
    //   369: if_icmpeq -> 380
    //   372: aload_3
    //   373: getfield b : I
    //   376: iconst_3
    //   377: if_icmpne -> 282
    //   380: iinc #7, 1
    //   383: goto -> 282
    //   386: aload #5
    //   388: astore_3
    //   389: iload #7
    //   391: bipush #15
    //   393: if_icmple -> 432
    //   396: ldc_w '[UserInfo] Upload user info too many times in 10 min: %d'
    //   399: iconst_1
    //   400: anewarray java/lang/Object
    //   403: dup
    //   404: iconst_0
    //   405: iload #7
    //   407: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   410: aastore
    //   411: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   414: pop
    //   415: iconst_0
    //   416: istore #7
    //   418: aload #5
    //   420: astore_3
    //   421: goto -> 435
    //   424: new java/util/ArrayList
    //   427: dup
    //   428: invokespecial <init> : ()V
    //   431: astore_3
    //   432: iconst_1
    //   433: istore #7
    //   435: aload #4
    //   437: invokeinterface size : ()I
    //   442: ifle -> 450
    //   445: aload #4
    //   447: invokestatic a : (Ljava/util/List;)V
    //   450: iload #7
    //   452: ifeq -> 708
    //   455: aload_3
    //   456: invokeinterface size : ()I
    //   461: ifne -> 467
    //   464: goto -> 708
    //   467: ldc_w '[UserInfo] Upload user info(size: %d)'
    //   470: iconst_1
    //   471: anewarray java/lang/Object
    //   474: dup
    //   475: iconst_0
    //   476: aload_3
    //   477: invokeinterface size : ()I
    //   482: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   485: aastore
    //   486: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   489: pop
    //   490: aload_0
    //   491: getfield c : I
    //   494: iconst_1
    //   495: if_icmpne -> 504
    //   498: iconst_1
    //   499: istore #7
    //   501: goto -> 507
    //   504: iconst_2
    //   505: istore #7
    //   507: aload_3
    //   508: iload #7
    //   510: invokestatic a : (Ljava/util/List;I)Lcom/tencent/bugly/proguard/au;
    //   513: astore #5
    //   515: aload #5
    //   517: ifnonnull -> 534
    //   520: ldc_w '[UserInfo] Failed to create UserInfoPackage.'
    //   523: iconst_0
    //   524: anewarray java/lang/Object
    //   527: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   530: pop
    //   531: aload_0
    //   532: monitorexit
    //   533: return
    //   534: aload #5
    //   536: invokestatic a : (Lcom/tencent/bugly/proguard/k;)[B
    //   539: astore #5
    //   541: aload #5
    //   543: ifnonnull -> 560
    //   546: ldc_w '[UserInfo] Failed to encode data.'
    //   549: iconst_0
    //   550: anewarray java/lang/Object
    //   553: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   556: pop
    //   557: aload_0
    //   558: monitorexit
    //   559: return
    //   560: aload_2
    //   561: getfield a : Z
    //   564: ifeq -> 575
    //   567: sipush #840
    //   570: istore #7
    //   572: goto -> 580
    //   575: sipush #640
    //   578: istore #7
    //   580: aload_0
    //   581: getfield a : Landroid/content/Context;
    //   584: iload #7
    //   586: aload #5
    //   588: invokestatic a : (Landroid/content/Context;I[B)Lcom/tencent/bugly/proguard/ap;
    //   591: astore #4
    //   593: aload #4
    //   595: ifnonnull -> 612
    //   598: ldc_w '[UserInfo] Request package is null.'
    //   601: iconst_0
    //   602: anewarray java/lang/Object
    //   605: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   608: pop
    //   609: aload_0
    //   610: monitorexit
    //   611: return
    //   612: new com/tencent/bugly/crashreport/biz/a$1
    //   615: astore #10
    //   617: aload #10
    //   619: aload_0
    //   620: aload_3
    //   621: invokespecial <init> : (Lcom/tencent/bugly/crashreport/biz/a;Ljava/util/List;)V
    //   624: invokestatic a : ()Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   627: invokevirtual c : ()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   630: astore_3
    //   631: aload_2
    //   632: getfield a : Z
    //   635: ifeq -> 646
    //   638: aload_3
    //   639: getfield r : Ljava/lang/String;
    //   642: astore_3
    //   643: goto -> 651
    //   646: aload_3
    //   647: getfield t : Ljava/lang/String;
    //   650: astore_3
    //   651: aload_2
    //   652: getfield a : Z
    //   655: ifeq -> 666
    //   658: getstatic com/tencent/bugly/crashreport/common/strategy/StrategyBean.b : Ljava/lang/String;
    //   661: astore #5
    //   663: goto -> 671
    //   666: getstatic com/tencent/bugly/crashreport/common/strategy/StrategyBean.a : Ljava/lang/String;
    //   669: astore #5
    //   671: invokestatic a : ()Lcom/tencent/bugly/proguard/u;
    //   674: astore_2
    //   675: aload_0
    //   676: getfield c : I
    //   679: iconst_1
    //   680: if_icmpne -> 688
    //   683: iconst_1
    //   684: istore_1
    //   685: goto -> 690
    //   688: iconst_0
    //   689: istore_1
    //   690: aload_2
    //   691: sipush #1001
    //   694: aload #4
    //   696: aload_3
    //   697: aload #5
    //   699: aload #10
    //   701: iload_1
    //   702: invokevirtual a : (ILcom/tencent/bugly/proguard/ap;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/proguard/t;Z)V
    //   705: aload_0
    //   706: monitorexit
    //   707: return
    //   708: ldc_w '[UserInfo] There is no user info in local database.'
    //   711: iconst_0
    //   712: anewarray java/lang/Object
    //   715: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   718: pop
    //   719: aload_0
    //   720: monitorexit
    //   721: return
    //   722: astore_3
    //   723: aload_0
    //   724: monitorexit
    //   725: aload_3
    //   726: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	722	finally
    //   14	18	722	finally
    //   25	29	722	finally
    //   36	51	722	finally
    //   58	86	722	finally
    //   91	103	722	finally
    //   111	125	722	finally
    //   135	224	722	finally
    //   247	264	722	finally
    //   270	279	722	finally
    //   282	341	722	finally
    //   341	380	722	finally
    //   396	415	722	finally
    //   424	432	722	finally
    //   435	450	722	finally
    //   455	464	722	finally
    //   467	498	722	finally
    //   507	515	722	finally
    //   520	531	722	finally
    //   534	541	722	finally
    //   546	557	722	finally
    //   560	567	722	finally
    //   580	593	722	finally
    //   598	609	722	finally
    //   612	643	722	finally
    //   646	651	722	finally
    //   651	663	722	finally
    //   666	671	722	finally
    //   671	683	722	finally
    //   690	705	722	finally
    //   708	719	722	finally
  }
  
  public final List<UserInfoBean> a(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic a : (Ljava/lang/String;)Z
    //   4: ifeq -> 12
    //   7: aconst_null
    //   8: astore_1
    //   9: goto -> 42
    //   12: new java/lang/StringBuilder
    //   15: astore_2
    //   16: aload_2
    //   17: ldc_w '_pc = ''
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: ldc_w '''
    //   33: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_2
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: astore_1
    //   42: invokestatic a : ()Lcom/tencent/bugly/proguard/p;
    //   45: ldc 't_ui'
    //   47: aconst_null
    //   48: aload_1
    //   49: aconst_null
    //   50: aconst_null
    //   51: iconst_1
    //   52: invokevirtual a : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)Landroid/database/Cursor;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnonnull -> 72
    //   60: aload_2
    //   61: ifnull -> 70
    //   64: aload_2
    //   65: invokeinterface close : ()V
    //   70: aconst_null
    //   71: areturn
    //   72: aload_2
    //   73: astore_1
    //   74: new java/lang/StringBuilder
    //   77: astore_3
    //   78: aload_2
    //   79: astore_1
    //   80: aload_3
    //   81: invokespecial <init> : ()V
    //   84: aload_2
    //   85: astore_1
    //   86: new java/util/ArrayList
    //   89: astore #4
    //   91: aload_2
    //   92: astore_1
    //   93: aload #4
    //   95: invokespecial <init> : ()V
    //   98: aload_2
    //   99: astore_1
    //   100: aload_2
    //   101: invokeinterface moveToNext : ()Z
    //   106: ifeq -> 202
    //   109: aload_2
    //   110: astore_1
    //   111: aload_2
    //   112: invokestatic a : (Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/biz/UserInfoBean;
    //   115: astore #5
    //   117: aload #5
    //   119: ifnull -> 137
    //   122: aload_2
    //   123: astore_1
    //   124: aload #4
    //   126: aload #5
    //   128: invokeinterface add : (Ljava/lang/Object;)Z
    //   133: pop
    //   134: goto -> 98
    //   137: aload_2
    //   138: astore_1
    //   139: aload_2
    //   140: aload_2
    //   141: ldc '_id'
    //   143: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   148: invokeinterface getLong : (I)J
    //   153: lstore #6
    //   155: aload_2
    //   156: astore_1
    //   157: aload_3
    //   158: ldc ' or _id'
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: astore_1
    //   166: aload_3
    //   167: ldc ' = '
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_2
    //   174: astore_1
    //   175: aload_3
    //   176: lload #6
    //   178: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: goto -> 98
    //   185: astore_1
    //   186: aload_2
    //   187: astore_1
    //   188: ldc_w '[Database] unknown id.'
    //   191: iconst_0
    //   192: anewarray java/lang/Object
    //   195: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   198: pop
    //   199: goto -> 98
    //   202: aload_2
    //   203: astore_1
    //   204: aload_3
    //   205: invokevirtual toString : ()Ljava/lang/String;
    //   208: astore_3
    //   209: aload_2
    //   210: astore_1
    //   211: aload_3
    //   212: invokevirtual length : ()I
    //   215: ifle -> 262
    //   218: aload_2
    //   219: astore_1
    //   220: aload_3
    //   221: iconst_4
    //   222: invokevirtual substring : (I)Ljava/lang/String;
    //   225: astore_3
    //   226: aload_2
    //   227: astore_1
    //   228: ldc_w '[Database] deleted %s error data %d'
    //   231: iconst_2
    //   232: anewarray java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: ldc 't_ui'
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: invokestatic a : ()Lcom/tencent/bugly/proguard/p;
    //   245: ldc 't_ui'
    //   247: aload_3
    //   248: aconst_null
    //   249: aconst_null
    //   250: iconst_1
    //   251: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   254: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   261: pop
    //   262: aload_2
    //   263: ifnull -> 272
    //   266: aload_2
    //   267: invokeinterface close : ()V
    //   272: aload #4
    //   274: areturn
    //   275: astore #4
    //   277: goto -> 290
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_1
    //   283: goto -> 320
    //   286: astore #4
    //   288: aconst_null
    //   289: astore_2
    //   290: aload_2
    //   291: astore_1
    //   292: aload #4
    //   294: invokestatic a : (Ljava/lang/Throwable;)Z
    //   297: ifne -> 307
    //   300: aload_2
    //   301: astore_1
    //   302: aload #4
    //   304: invokevirtual printStackTrace : ()V
    //   307: aload_2
    //   308: ifnull -> 317
    //   311: aload_2
    //   312: invokeinterface close : ()V
    //   317: aconst_null
    //   318: areturn
    //   319: astore_2
    //   320: aload_1
    //   321: ifnull -> 330
    //   324: aload_1
    //   325: invokeinterface close : ()V
    //   330: aload_2
    //   331: athrow
    // Exception table:
    //   from	to	target	type
    //   0	7	286	java/lang/Throwable
    //   0	7	280	finally
    //   12	42	286	java/lang/Throwable
    //   12	42	280	finally
    //   42	56	286	java/lang/Throwable
    //   42	56	280	finally
    //   74	78	275	java/lang/Throwable
    //   74	78	319	finally
    //   80	84	275	java/lang/Throwable
    //   80	84	319	finally
    //   86	91	275	java/lang/Throwable
    //   86	91	319	finally
    //   93	98	275	java/lang/Throwable
    //   93	98	319	finally
    //   100	109	275	java/lang/Throwable
    //   100	109	319	finally
    //   111	117	275	java/lang/Throwable
    //   111	117	319	finally
    //   124	134	275	java/lang/Throwable
    //   124	134	319	finally
    //   139	155	185	java/lang/Throwable
    //   139	155	319	finally
    //   157	164	185	java/lang/Throwable
    //   157	164	319	finally
    //   166	173	185	java/lang/Throwable
    //   166	173	319	finally
    //   175	182	185	java/lang/Throwable
    //   175	182	319	finally
    //   188	199	275	java/lang/Throwable
    //   188	199	319	finally
    //   204	209	275	java/lang/Throwable
    //   204	209	319	finally
    //   211	218	275	java/lang/Throwable
    //   211	218	319	finally
    //   220	226	275	java/lang/Throwable
    //   220	226	319	finally
    //   228	262	275	java/lang/Throwable
    //   228	262	319	finally
    //   292	300	319	finally
    //   302	307	319	finally
  }
  
  public final void a() {
    this.b = z.b() + 86400000L;
    w.a().a(new b(this), this.b - System.currentTimeMillis() + 5000L);
  }
  
  public final void a(int paramInt, boolean paramBoolean, long paramLong) {
    com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
    boolean bool = false;
    if (a2 != null && !(a2.c()).h && paramInt != 1 && paramInt != 3) {
      x.e("UserInfo is disable", new Object[0]);
      return;
    } 
    if (paramInt == 1 || paramInt == 3)
      this.c++; 
    com.tencent.bugly.crashreport.common.info.a a1 = com.tencent.bugly.crashreport.common.info.a.a(this.a);
    UserInfoBean userInfoBean = new UserInfoBean();
    userInfoBean.b = paramInt;
    userInfoBean.c = a1.d;
    userInfoBean.d = a1.g();
    userInfoBean.e = System.currentTimeMillis();
    userInfoBean.f = -1L;
    userInfoBean.n = a1.j;
    if (paramInt == 1)
      bool = true; 
    userInfoBean.o = bool;
    userInfoBean.l = a1.a();
    userInfoBean.m = a1.p;
    userInfoBean.g = a1.q;
    userInfoBean.h = a1.r;
    userInfoBean.i = a1.s;
    userInfoBean.k = a1.t;
    userInfoBean.r = a1.B();
    userInfoBean.s = a1.G();
    userInfoBean.p = a1.H();
    userInfoBean.q = a1.I();
    w.a().a(new a(this, userInfoBean, paramBoolean), 0L);
  }
  
  public final void b() {
    w w = w.a();
    if (w != null)
      w.a(new Runnable(this) {
            public final void run() {
              try {
                a.a(this.a);
                return;
              } catch (Throwable throwable) {
                x.a(throwable);
                return;
              } 
            }
          }); 
  }
  
  final class a implements Runnable {
    private boolean a;
    
    private UserInfoBean b;
    
    public a(a this$0, UserInfoBean param1UserInfoBean, boolean param1Boolean) {
      this.b = param1UserInfoBean;
      this.a = param1Boolean;
    }
    
    public final void run() {
      try {
        if (this.b != null) {
          UserInfoBean userInfoBean = this.b;
          if (userInfoBean != null) {
            com.tencent.bugly.crashreport.common.info.a a1 = com.tencent.bugly.crashreport.common.info.a.b();
            if (a1 != null)
              userInfoBean.j = a1.e(); 
          } 
          x.c("[UserInfo] Record user info.", new Object[0]);
          a.a(this.c, this.b, false);
        } 
        if (this.a) {
          a a1 = this.c;
          w w = w.a();
          if (w != null) {
            Runnable runnable = new Runnable() {
                public final void run() {
                  try {
                    a.a(this.a);
                    return;
                  } catch (Throwable throwable) {
                    x.a(throwable);
                    return;
                  } 
                }
              };
            super(a1);
            w.a(runnable);
          } 
        } 
        return;
      } catch (Throwable throwable) {
        if (!x.a(throwable))
          throwable.printStackTrace(); 
        return;
      } 
    }
  }
  
  final class b implements Runnable {
    b(a this$0) {}
    
    public final void run() {
      long l = System.currentTimeMillis();
      if (l < a.b(this.a)) {
        w.a().a(new b(this.a), a.b(this.a) - l + 5000L);
        return;
      } 
      this.a.a(3, false, 0L);
      this.a.a();
    }
  }
  
  final class c implements Runnable {
    private long a = 21600000L;
    
    public c(a this$0, long param1Long) {
      this.a = param1Long;
    }
    
    public final void run() {
      a a1 = this.b;
      w w = w.a();
      if (w != null)
        w.a(new Runnable(a1) {
              public final void run() {
                try {
                  a.a(this.a);
                  return;
                } catch (Throwable throwable) {
                  x.a(throwable);
                  return;
                } 
              }
            }); 
      a a2 = this.b;
      long l = this.a;
      w.a().a(new c(a2, l), l);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\biz\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */