package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.a;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class b {
  private static int a;
  
  private Context b;
  
  private u c;
  
  private p d;
  
  private a e;
  
  private o f;
  
  private BuglyStrategy.a g;
  
  public b(int paramInt, Context paramContext, u paramu, p paramp, a parama, BuglyStrategy.a parama1, o paramo) {
    a = paramInt;
    this.b = paramContext;
    this.c = paramu;
    this.d = paramp;
    this.e = parama;
    this.g = parama1;
    this.f = paramo;
  }
  
  private static CrashDetailBean a(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null)
        return null; 
      long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      CrashDetailBean crashDetailBean = (CrashDetailBean)z.a(arrayOfByte, CrashDetailBean.CREATOR);
      if (crashDetailBean != null)
        crashDetailBean.a = l; 
      return crashDetailBean;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  private CrashDetailBean a(List<a> paramList, CrashDetailBean paramCrashDetailBean) {
    CrashDetailBean crashDetailBean1;
    String str2;
    if (paramList == null || paramList.size() == 0)
      return paramCrashDetailBean; 
    CrashDetailBean crashDetailBean2 = null;
    ArrayList<a> arrayList = new ArrayList(10);
    for (a a1 : paramList) {
      if (a1.e)
        arrayList.add(a1); 
    } 
    CrashDetailBean crashDetailBean3 = crashDetailBean2;
    if (arrayList.size() > 0) {
      List<CrashDetailBean> list = b(arrayList);
      crashDetailBean3 = crashDetailBean2;
      if (list != null) {
        crashDetailBean3 = crashDetailBean2;
        if (list.size() > 0) {
          Collections.sort(list);
          crashDetailBean3 = null;
          byte b1 = 0;
          while (b1 < list.size()) {
            String str;
            CrashDetailBean crashDetailBean = list.get(b1);
            if (b1 == 0) {
              crashDetailBean2 = crashDetailBean;
            } else {
              crashDetailBean2 = crashDetailBean3;
              if (crashDetailBean.s != null) {
                String[] arrayOfString = crashDetailBean.s.split("\n");
                crashDetailBean2 = crashDetailBean3;
                if (arrayOfString != null) {
                  int i = arrayOfString.length;
                  byte b2 = 0;
                  while (true) {
                    crashDetailBean2 = crashDetailBean3;
                    if (b2 < i) {
                      str = arrayOfString[b2];
                      String str3 = crashDetailBean3.s;
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append(str);
                      if (!str3.contains(stringBuilder.toString())) {
                        crashDetailBean3.t++;
                        StringBuilder stringBuilder1 = new StringBuilder();
                        stringBuilder1.append(crashDetailBean3.s);
                        stringBuilder1.append(str);
                        stringBuilder1.append("\n");
                        crashDetailBean3.s = stringBuilder1.toString();
                      } 
                      b2++;
                      continue;
                    } 
                    break;
                  } 
                } 
              } 
            } 
            b1++;
            str2 = str;
          } 
        } 
      } 
    } 
    String str1 = str2;
    if (str2 == null) {
      paramCrashDetailBean.j = true;
      paramCrashDetailBean.t = 0;
      paramCrashDetailBean.s = "";
      crashDetailBean1 = paramCrashDetailBean;
    } 
    for (a a1 : paramList) {
      if (!a1.e && !a1.d) {
        String str = crashDetailBean1.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a1.b);
        if (!str.contains(stringBuilder.toString())) {
          crashDetailBean1.t++;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(crashDetailBean1.s);
          stringBuilder1.append(a1.b);
          stringBuilder1.append("\n");
          crashDetailBean1.s = stringBuilder1.toString();
        } 
      } 
    } 
    if (crashDetailBean1.r != paramCrashDetailBean.r) {
      String str = crashDetailBean1.s;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramCrashDetailBean.r);
      if (!str.contains(stringBuilder.toString())) {
        crashDetailBean1.t++;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(crashDetailBean1.s);
        stringBuilder1.append(paramCrashDetailBean.r);
        stringBuilder1.append("\n");
        crashDetailBean1.s = stringBuilder1.toString();
      } 
    } 
    return crashDetailBean1;
  }
  
  private static am a(String paramString1, Context paramContext, String paramString2) {
    // Byte code:
    //   0: aload_2
    //   1: ifnull -> 347
    //   4: aload_1
    //   5: ifnonnull -> 11
    //   8: goto -> 347
    //   11: ldc 'zip %s'
    //   13: iconst_1
    //   14: anewarray java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_2
    //   20: aastore
    //   21: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   24: pop
    //   25: new java/io/File
    //   28: dup
    //   29: aload_2
    //   30: invokespecial <init> : (Ljava/lang/String;)V
    //   33: astore_2
    //   34: new java/io/File
    //   37: dup
    //   38: aload_1
    //   39: invokevirtual getCacheDir : ()Ljava/io/File;
    //   42: aload_0
    //   43: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   46: astore_3
    //   47: aload_2
    //   48: aload_3
    //   49: sipush #5000
    //   52: invokestatic a : (Ljava/io/File;Ljava/io/File;I)Z
    //   55: ifne -> 70
    //   58: ldc 'zip fail!'
    //   60: iconst_0
    //   61: anewarray java/lang/Object
    //   64: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   67: pop
    //   68: aconst_null
    //   69: areturn
    //   70: new java/io/ByteArrayOutputStream
    //   73: dup
    //   74: invokespecial <init> : ()V
    //   77: astore_2
    //   78: new java/io/FileInputStream
    //   81: astore_1
    //   82: aload_1
    //   83: aload_3
    //   84: invokespecial <init> : (Ljava/io/File;)V
    //   87: aload_1
    //   88: astore_0
    //   89: sipush #4096
    //   92: newarray byte
    //   94: astore #4
    //   96: aload_1
    //   97: astore_0
    //   98: aload_1
    //   99: aload #4
    //   101: invokevirtual read : ([B)I
    //   104: istore #5
    //   106: iload #5
    //   108: ifle -> 131
    //   111: aload_1
    //   112: astore_0
    //   113: aload_2
    //   114: aload #4
    //   116: iconst_0
    //   117: iload #5
    //   119: invokevirtual write : ([BII)V
    //   122: aload_1
    //   123: astore_0
    //   124: aload_2
    //   125: invokevirtual flush : ()V
    //   128: goto -> 96
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: invokevirtual toByteArray : ()[B
    //   137: astore_2
    //   138: aload_1
    //   139: astore_0
    //   140: ldc 'read bytes :%d'
    //   142: iconst_1
    //   143: anewarray java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_2
    //   149: arraylength
    //   150: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   153: aastore
    //   154: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   157: pop
    //   158: aload_1
    //   159: astore_0
    //   160: new com/tencent/bugly/proguard/am
    //   163: dup
    //   164: iconst_2
    //   165: aload_3
    //   166: invokevirtual getName : ()Ljava/lang/String;
    //   169: aload_2
    //   170: invokespecial <init> : (BLjava/lang/String;[B)V
    //   173: astore_2
    //   174: aload_1
    //   175: invokevirtual close : ()V
    //   178: goto -> 193
    //   181: astore_0
    //   182: aload_0
    //   183: invokestatic a : (Ljava/lang/Throwable;)Z
    //   186: ifne -> 193
    //   189: aload_0
    //   190: invokevirtual printStackTrace : ()V
    //   193: aload_3
    //   194: invokevirtual exists : ()Z
    //   197: ifeq -> 216
    //   200: ldc_w 'del tmp'
    //   203: iconst_0
    //   204: anewarray java/lang/Object
    //   207: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   210: pop
    //   211: aload_3
    //   212: invokevirtual delete : ()Z
    //   215: pop
    //   216: aload_2
    //   217: areturn
    //   218: astore_2
    //   219: goto -> 231
    //   222: astore_0
    //   223: aconst_null
    //   224: astore_2
    //   225: goto -> 299
    //   228: astore_2
    //   229: aconst_null
    //   230: astore_1
    //   231: aload_1
    //   232: astore_0
    //   233: aload_2
    //   234: invokestatic a : (Ljava/lang/Throwable;)Z
    //   237: ifne -> 246
    //   240: aload_1
    //   241: astore_0
    //   242: aload_2
    //   243: invokevirtual printStackTrace : ()V
    //   246: aload_1
    //   247: ifnull -> 269
    //   250: aload_1
    //   251: invokevirtual close : ()V
    //   254: goto -> 269
    //   257: astore_0
    //   258: aload_0
    //   259: invokestatic a : (Ljava/lang/Throwable;)Z
    //   262: ifne -> 269
    //   265: aload_0
    //   266: invokevirtual printStackTrace : ()V
    //   269: aload_3
    //   270: invokevirtual exists : ()Z
    //   273: ifeq -> 292
    //   276: ldc_w 'del tmp'
    //   279: iconst_0
    //   280: anewarray java/lang/Object
    //   283: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   286: pop
    //   287: aload_3
    //   288: invokevirtual delete : ()Z
    //   291: pop
    //   292: aconst_null
    //   293: areturn
    //   294: astore_1
    //   295: aload_0
    //   296: astore_2
    //   297: aload_1
    //   298: astore_0
    //   299: aload_2
    //   300: ifnull -> 322
    //   303: aload_2
    //   304: invokevirtual close : ()V
    //   307: goto -> 322
    //   310: astore_1
    //   311: aload_1
    //   312: invokestatic a : (Ljava/lang/Throwable;)Z
    //   315: ifne -> 322
    //   318: aload_1
    //   319: invokevirtual printStackTrace : ()V
    //   322: aload_3
    //   323: invokevirtual exists : ()Z
    //   326: ifeq -> 345
    //   329: ldc_w 'del tmp'
    //   332: iconst_0
    //   333: anewarray java/lang/Object
    //   336: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   339: pop
    //   340: aload_3
    //   341: invokevirtual delete : ()Z
    //   344: pop
    //   345: aload_0
    //   346: athrow
    //   347: ldc_w 'rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}'
    //   350: iconst_0
    //   351: anewarray java/lang/Object
    //   354: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   357: pop
    //   358: aconst_null
    //   359: areturn
    // Exception table:
    //   from	to	target	type
    //   78	87	228	java/lang/Throwable
    //   78	87	222	finally
    //   89	96	218	java/lang/Throwable
    //   89	96	294	finally
    //   98	106	218	java/lang/Throwable
    //   98	106	294	finally
    //   113	122	218	java/lang/Throwable
    //   113	122	294	finally
    //   124	128	218	java/lang/Throwable
    //   124	128	294	finally
    //   133	138	218	java/lang/Throwable
    //   133	138	294	finally
    //   140	158	218	java/lang/Throwable
    //   140	158	294	finally
    //   160	174	218	java/lang/Throwable
    //   160	174	294	finally
    //   174	178	181	java/io/IOException
    //   233	240	294	finally
    //   242	246	294	finally
    //   250	254	257	java/io/IOException
    //   303	307	310	java/io/IOException
  }
  
  private static an a(Context paramContext, CrashDetailBean paramCrashDetailBean, a parama) {
    String str4;
    boolean bool = false;
    if (paramContext == null || paramCrashDetailBean == null || parama == null) {
      x.d("enExp args == null", new Object[0]);
      return null;
    } 
    an an = new an();
    switch (paramCrashDetailBean.b) {
      default:
        x.e("crash type error! %d", new Object[] { Integer.valueOf(paramCrashDetailBean.b) });
        break;
      case 7:
        if (paramCrashDetailBean.j) {
          str4 = "208";
        } else {
          str4 = "108";
        } 
        an.a = str4;
        break;
      case 6:
        if (paramCrashDetailBean.j) {
          str4 = "206";
        } else {
          str4 = "106";
        } 
        an.a = str4;
        break;
      case 5:
        if (paramCrashDetailBean.j) {
          str4 = "207";
        } else {
          str4 = "107";
        } 
        an.a = str4;
        break;
      case 4:
        if (paramCrashDetailBean.j) {
          str4 = "204";
        } else {
          str4 = "104";
        } 
        an.a = str4;
        break;
      case 3:
        if (paramCrashDetailBean.j) {
          str4 = "203";
        } else {
          str4 = "103";
        } 
        an.a = str4;
        break;
      case 2:
        if (paramCrashDetailBean.j) {
          str4 = "202";
        } else {
          str4 = "102";
        } 
        an.a = str4;
        break;
      case 1:
        if (paramCrashDetailBean.j) {
          str4 = "201";
        } else {
          str4 = "101";
        } 
        an.a = str4;
        break;
      case 0:
        if (paramCrashDetailBean.j) {
          str4 = "200";
        } else {
          str4 = "100";
        } 
        an.a = str4;
        break;
    } 
    an.b = paramCrashDetailBean.r;
    an.c = paramCrashDetailBean.n;
    an.d = paramCrashDetailBean.o;
    an.e = paramCrashDetailBean.p;
    an.g = paramCrashDetailBean.q;
    an.h = paramCrashDetailBean.z;
    an.i = paramCrashDetailBean.c;
    an.j = null;
    an.l = paramCrashDetailBean.m;
    an.m = paramCrashDetailBean.e;
    an.f = paramCrashDetailBean.B;
    an.t = a.b().i();
    an.n = null;
    if (paramCrashDetailBean.i != null && paramCrashDetailBean.i.size() > 0) {
      an.o = new ArrayList();
      for (Map.Entry<String, PlugInBean> entry : paramCrashDetailBean.i.entrySet()) {
        ak ak = new ak();
        ak.a = ((PlugInBean)entry.getValue()).a;
        ak.c = ((PlugInBean)entry.getValue()).c;
        ak.d = ((PlugInBean)entry.getValue()).b;
        ak.b = parama.r();
        an.o.add(ak);
      } 
    } 
    if (paramCrashDetailBean.h != null && paramCrashDetailBean.h.size() > 0) {
      an.p = new ArrayList();
      for (Map.Entry<String, PlugInBean> entry : paramCrashDetailBean.h.entrySet()) {
        ak ak = new ak();
        ak.a = ((PlugInBean)entry.getValue()).a;
        ak.c = ((PlugInBean)entry.getValue()).c;
        ak.d = ((PlugInBean)entry.getValue()).b;
        an.p.add(ak);
      } 
    } 
    if (paramCrashDetailBean.j) {
      boolean bool4;
      an.k = paramCrashDetailBean.t;
      if (paramCrashDetailBean.s != null && paramCrashDetailBean.s.length() > 0) {
        if (an.q == null)
          an.q = new ArrayList(); 
        try {
          ArrayList<am> arrayList = an.q;
          am am = new am();
          this((byte)1, "alltimes.txt", paramCrashDetailBean.s.getBytes("utf-8"));
          arrayList.add(am);
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
          an.q = null;
        } 
      } 
      int i = an.k;
      if (an.q != null) {
        bool4 = an.q.size();
      } else {
        bool4 = false;
      } 
      x.c("crashcount:%d sz:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(bool4) });
    } 
    if (paramCrashDetailBean.w != null) {
      if (an.q == null)
        an.q = new ArrayList(); 
      try {
        ArrayList<am> arrayList = an.q;
        am am = new am();
        this((byte)1, "log.txt", paramCrashDetailBean.w.getBytes("utf-8"));
        arrayList.add(am);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        an.q = null;
      } 
    } 
    if (paramCrashDetailBean.x != null) {
      if (an.q == null)
        an.q = new ArrayList(); 
      try {
        ArrayList<am> arrayList = an.q;
        am am = new am();
        this((byte)1, "jniLog.txt", paramCrashDetailBean.x.getBytes("utf-8"));
        arrayList.add(am);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        an.q = null;
      } 
    } 
    if (!z.a(paramCrashDetailBean.U)) {
      if (an.q == null)
        an.q = new ArrayList(); 
      try {
        am am = new am();
        this((byte)1, "crashInfos.txt", paramCrashDetailBean.U.getBytes("utf-8"));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        unsupportedEncodingException = null;
      } 
      if (unsupportedEncodingException != null) {
        x.c("attach crash infos", new Object[0]);
        an.q.add(unsupportedEncodingException);
      } 
    } 
    if (paramCrashDetailBean.V != null) {
      if (an.q == null)
        an.q = new ArrayList(); 
      am am = a("backupRecord.zip", paramContext, paramCrashDetailBean.V);
      if (am != null) {
        x.c("attach backup record", new Object[0]);
        an.q.add(am);
      } 
    } 
    if (paramCrashDetailBean.y != null && paramCrashDetailBean.y.length > 0) {
      am am = new am((byte)2, "buglylog.zip", paramCrashDetailBean.y);
      x.c("attach user log", new Object[0]);
      if (an.q == null)
        an.q = new ArrayList(); 
      an.q.add(am);
    } 
    if (paramCrashDetailBean.b == 3) {
      if (an.q == null)
        an.q = new ArrayList(); 
      x.c("crashBean.userDatas:%s", new Object[] { paramCrashDetailBean.O });
      if (paramCrashDetailBean.O != null && paramCrashDetailBean.O.containsKey("BUGLY_CR_01")) {
        try {
          if (!TextUtils.isEmpty(paramCrashDetailBean.O.get("BUGLY_CR_01"))) {
            ArrayList<am> arrayList = an.q;
            am am = new am();
            this((byte)1, "anrMessage.txt", ((String)paramCrashDetailBean.O.get("BUGLY_CR_01")).getBytes("utf-8"));
            arrayList.add(am);
            x.c("attach anr message", new Object[0]);
          } 
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
          an.q = null;
        } 
        paramCrashDetailBean.O.remove("BUGLY_CR_01");
      } 
      if (paramCrashDetailBean.v != null) {
        am am = a("trace.zip", paramContext, paramCrashDetailBean.v);
        if (am != null) {
          x.c("attach traces", new Object[0]);
          an.q.add(am);
        } 
      } 
    } 
    if (paramCrashDetailBean.b == 1) {
      if (an.q == null)
        an.q = new ArrayList(); 
      if (paramCrashDetailBean.v != null) {
        am am = a("tomb.zip", paramContext, paramCrashDetailBean.v);
        if (am != null) {
          x.c("attach tombs", new Object[0]);
          an.q.add(am);
        } 
      } 
    } 
    if (parama.C != null && !parama.C.isEmpty()) {
      if (an.q == null)
        an.q = new ArrayList(); 
      StringBuilder stringBuilder = new StringBuilder();
      Iterator<String> iterator = parama.C.iterator();
      while (iterator.hasNext())
        stringBuilder.append(iterator.next()); 
      try {
        ArrayList<am> arrayList = an.q;
        am am = new am();
        this((byte)1, "martianlog.txt", stringBuilder.toString().getBytes("utf-8"));
        arrayList.add(am);
        x.c("attach pageTracingList", new Object[0]);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      } 
    } 
    if (paramCrashDetailBean.T != null && paramCrashDetailBean.T.length > 0) {
      if (an.q == null)
        an.q = new ArrayList(); 
      an.q.add(new am((byte)1, "userExtraByteData", paramCrashDetailBean.T));
      x.c("attach extraData", new Object[0]);
    } 
    an.r = new HashMap<Object, Object>();
    Map<String, String> map14 = an.r;
    StringBuilder stringBuilder7 = new StringBuilder();
    stringBuilder7.append(paramCrashDetailBean.C);
    map14.put("A9", stringBuilder7.toString());
    map14 = an.r;
    stringBuilder7 = new StringBuilder();
    stringBuilder7.append(paramCrashDetailBean.D);
    map14.put("A11", stringBuilder7.toString());
    Map<String, String> map7 = an.r;
    StringBuilder stringBuilder14 = new StringBuilder();
    stringBuilder14.append(paramCrashDetailBean.E);
    map7.put("A10", stringBuilder14.toString());
    map7 = an.r;
    stringBuilder14 = new StringBuilder();
    stringBuilder14.append(paramCrashDetailBean.f);
    map7.put("A23", stringBuilder14.toString());
    Map<String, String> map13 = an.r;
    StringBuilder stringBuilder6 = new StringBuilder();
    stringBuilder6.append(parama.f);
    map13.put("A7", stringBuilder6.toString());
    map13 = an.r;
    stringBuilder6 = new StringBuilder();
    stringBuilder6.append(parama.s());
    map13.put("A6", stringBuilder6.toString());
    Map<String, String> map6 = an.r;
    StringBuilder stringBuilder13 = new StringBuilder();
    stringBuilder13.append(parama.r());
    map6.put("A5", stringBuilder13.toString());
    map6 = an.r;
    stringBuilder13 = new StringBuilder();
    stringBuilder13.append(parama.h());
    map6.put("A22", stringBuilder13.toString());
    map6 = an.r;
    stringBuilder13 = new StringBuilder();
    stringBuilder13.append(paramCrashDetailBean.G);
    map6.put("A2", stringBuilder13.toString());
    map6 = an.r;
    stringBuilder13 = new StringBuilder();
    stringBuilder13.append(paramCrashDetailBean.F);
    map6.put("A1", stringBuilder13.toString());
    Map<String, String> map12 = an.r;
    StringBuilder stringBuilder5 = new StringBuilder();
    stringBuilder5.append(parama.h);
    map12.put("A24", stringBuilder5.toString());
    Map<String, String> map5 = an.r;
    StringBuilder stringBuilder12 = new StringBuilder();
    stringBuilder12.append(paramCrashDetailBean.H);
    map5.put("A17", stringBuilder12.toString());
    map5 = an.r;
    stringBuilder12 = new StringBuilder();
    stringBuilder12.append(parama.k());
    map5.put("A3", stringBuilder12.toString());
    Map<String, String> map11 = an.r;
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(parama.m());
    map11.put("A16", stringBuilder4.toString());
    map11 = an.r;
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append(parama.n());
    map11.put("A25", stringBuilder4.toString());
    map11 = an.r;
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append(parama.l());
    map11.put("A14", stringBuilder4.toString());
    Map<String, String> map4 = an.r;
    StringBuilder stringBuilder11 = new StringBuilder();
    stringBuilder11.append(parama.w());
    map4.put("A15", stringBuilder11.toString());
    Map<String, String> map10 = an.r;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(parama.x());
    map10.put("A13", stringBuilder3.toString());
    map10 = an.r;
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramCrashDetailBean.A);
    map10.put("A34", stringBuilder3.toString());
    if (parama.x != null) {
      Map<String, String> map = an.r;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(parama.x);
      map.put("productIdentify", stringBuilder.toString());
    } 
    try {
      map10 = an.r;
      stringBuilder3 = new StringBuilder();
      this();
      stringBuilder3.append(URLEncoder.encode(paramCrashDetailBean.I, "utf-8"));
      map10.put("A26", stringBuilder3.toString());
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
    } 
    if (paramCrashDetailBean.b == 1) {
      Map<String, String> map16 = an.r;
      StringBuilder stringBuilder17 = new StringBuilder();
      stringBuilder17.append(paramCrashDetailBean.K);
      map16.put("A27", stringBuilder17.toString());
      Map<String, String> map17 = an.r;
      StringBuilder stringBuilder15 = new StringBuilder();
      stringBuilder15.append(paramCrashDetailBean.J);
      map17.put("A28", stringBuilder15.toString());
      Map<String, String> map15 = an.r;
      StringBuilder stringBuilder16 = new StringBuilder();
      stringBuilder16.append(paramCrashDetailBean.k);
      map15.put("A29", stringBuilder16.toString());
    } 
    map10 = an.r;
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramCrashDetailBean.L);
    map10.put("A30", stringBuilder3.toString());
    Map<String, String> map3 = an.r;
    StringBuilder stringBuilder10 = new StringBuilder();
    stringBuilder10.append(paramCrashDetailBean.M);
    map3.put("A18", stringBuilder10.toString());
    Map<String, String> map9 = an.r;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramCrashDetailBean.N ^ true);
    map9.put("A36", stringBuilder2.toString());
    map9 = an.r;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(parama.q);
    map9.put("F02", stringBuilder2.toString());
    map9 = an.r;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(parama.r);
    map9.put("F03", stringBuilder2.toString());
    Map<String, String> map2 = an.r;
    StringBuilder stringBuilder9 = new StringBuilder();
    stringBuilder9.append(parama.e());
    map2.put("F04", stringBuilder9.toString());
    map2 = an.r;
    stringBuilder9 = new StringBuilder();
    stringBuilder9.append(parama.s);
    map2.put("F05", stringBuilder9.toString());
    map2 = an.r;
    stringBuilder9 = new StringBuilder();
    stringBuilder9.append(parama.p);
    map2.put("F06", stringBuilder9.toString());
    map2 = an.r;
    stringBuilder9 = new StringBuilder();
    stringBuilder9.append(parama.v);
    map2.put("F08", stringBuilder9.toString());
    Map<String, String> map8 = an.r;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(parama.w);
    map8.put("F09", stringBuilder1.toString());
    Map<String, String> map1 = an.r;
    StringBuilder stringBuilder8 = new StringBuilder();
    stringBuilder8.append(parama.t);
    map1.put("F10", stringBuilder8.toString());
    if (paramCrashDetailBean.P >= 0) {
      Map<String, String> map = an.r;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramCrashDetailBean.P);
      map.put("C01", stringBuilder.toString());
    } 
    if (paramCrashDetailBean.Q >= 0) {
      Map<String, String> map = an.r;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramCrashDetailBean.Q);
      map.put("C02", stringBuilder.toString());
    } 
    if (paramCrashDetailBean.R != null && paramCrashDetailBean.R.size() > 0)
      for (Map.Entry<String, String> entry : paramCrashDetailBean.R.entrySet()) {
        Map map = an.r;
        StringBuilder stringBuilder = new StringBuilder("C03_");
        stringBuilder.append((String)entry.getKey());
        map.put(stringBuilder.toString(), entry.getValue());
      }  
    if (paramCrashDetailBean.S != null && paramCrashDetailBean.S.size() > 0)
      for (Map.Entry<String, String> entry : paramCrashDetailBean.S.entrySet()) {
        Map map = an.r;
        StringBuilder stringBuilder = new StringBuilder("C04_");
        stringBuilder.append((String)entry.getKey());
        map.put(stringBuilder.toString(), entry.getValue());
      }  
    an.s = null;
    if (paramCrashDetailBean.O != null && paramCrashDetailBean.O.size() > 0) {
      an.s = paramCrashDetailBean.O;
      x.a("setted message size %d", new Object[] { Integer.valueOf(an.s.size()) });
    } 
    String str1 = paramCrashDetailBean.n;
    String str3 = paramCrashDetailBean.c;
    String str2 = parama.e();
    long l = (paramCrashDetailBean.r - paramCrashDetailBean.M) / 1000L;
    boolean bool1 = paramCrashDetailBean.k;
    boolean bool2 = paramCrashDetailBean.N;
    boolean bool3 = paramCrashDetailBean.j;
    if (paramCrashDetailBean.b == 1)
      bool = true; 
    x.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", new Object[] { 
          str1, str3, str2, Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool), Integer.valueOf(paramCrashDetailBean.t), paramCrashDetailBean.s, 
          Boolean.valueOf(paramCrashDetailBean.d), Integer.valueOf(an.r.size()) });
    return an;
  }
  
  private static List<a> a(List<a> paramList) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    long l = System.currentTimeMillis();
    ArrayList<a> arrayList = new ArrayList();
    for (a a1 : paramList) {
      if (a1.d && a1.b <= l - 86400000L)
        arrayList.add(a1); 
    } 
    return arrayList;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, CrashDetailBean paramCrashDetailBean) {
    a a1 = a.b();
    if (a1 == null)
      return; 
    x.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
    x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
    x.e("# PKG NAME: %s", new Object[] { a1.c });
    x.e("# APP VER: %s", new Object[] { a1.j });
    x.e("# LAUNCH TIME: %s", new Object[] { z.a(new Date((a.b()).a)) });
    x.e("# CRASH TYPE: %s", new Object[] { paramString1 });
    x.e("# CRASH TIME: %s", new Object[] { paramString2 });
    x.e("# CRASH PROCESS: %s", new Object[] { paramString3 });
    x.e("# CRASH THREAD: %s", new Object[] { paramString4 });
    if (paramCrashDetailBean != null) {
      x.e("# REPORT ID: %s", new Object[] { paramCrashDetailBean.c });
      paramString2 = a1.g;
      if (a1.x().booleanValue()) {
        paramString1 = "ROOTED";
      } else {
        paramString1 = "UNROOT";
      } 
      x.e("# CRASH DEVICE: %s %s", new Object[] { paramString2, paramString1 });
      x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.C), Long.valueOf(paramCrashDetailBean.D), Long.valueOf(paramCrashDetailBean.E) });
      x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.F), Long.valueOf(paramCrashDetailBean.G), Long.valueOf(paramCrashDetailBean.H) });
      if (!z.a(paramCrashDetailBean.K)) {
        x.e("# EXCEPTION FIRED BY %s %s", new Object[] { paramCrashDetailBean.K, paramCrashDetailBean.J });
      } else if (paramCrashDetailBean.b == 3) {
        String str;
        if (paramCrashDetailBean.O == null) {
          paramString1 = "null";
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramCrashDetailBean.O.get("BUGLY_CR_01"));
          str = stringBuilder.toString();
        } 
        x.e("# EXCEPTION ANR MESSAGE:\n %s", new Object[] { str });
      } 
    } 
    if (!z.a(paramString5)) {
      x.e("# CRASH STACK: ", new Object[0]);
      x.e(paramString5, new Object[0]);
    } 
    x.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
  }
  
  public static void a(boolean paramBoolean, List<CrashDetailBean> paramList) {
    if (paramList != null && paramList.size() > 0) {
      x.c("up finish update state %b", new Object[] { Boolean.valueOf(paramBoolean) });
      for (CrashDetailBean crashDetailBean : paramList) {
        x.c("pre uid:%s uc:%d re:%b me:%b", new Object[] { crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j) });
        crashDetailBean.l++;
        crashDetailBean.d = paramBoolean;
        x.c("set uid:%s uc:%d re:%b me:%b", new Object[] { crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j) });
      } 
      for (CrashDetailBean crashDetailBean : paramList)
        c.a().a(crashDetailBean); 
      x.c("update state size %d", new Object[] { Integer.valueOf(paramList.size()) });
    } 
    if (!paramBoolean)
      x.b("[crash] upload fail.", new Object[0]); 
  }
  
  private static a b(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      a a1 = new a();
      this();
      a1.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      a1.b = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      a1.c = paramCursor.getString(paramCursor.getColumnIndex("_s1"));
      int i = paramCursor.getInt(paramCursor.getColumnIndex("_up"));
      boolean bool1 = false;
      if (i == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      a1.d = bool2;
      boolean bool2 = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("_me")) == 1)
        bool2 = true; 
      a1.e = bool2;
      a1.f = paramCursor.getInt(paramCursor.getColumnIndex("_uc"));
      return a1;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  private List<a> b() {
    a a2;
    a a3;
    ArrayList<a> arrayList = new ArrayList();
    Object object = null;
    a a1 = null;
    try {
    
    } catch (Throwable throwable) {
    
    } finally {
      Exception exception2 = null;
      a3 = a1;
      Exception exception1 = exception2;
    } 
    a1 = a2;
    if (!x.a((Throwable)a3)) {
      a1 = a2;
      a3.printStackTrace();
    } 
    if (a2 != null)
      a2.close(); 
    return arrayList;
  }
  
  private List<CrashDetailBean> b(List<a> paramList) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 479
    //   4: aload_1
    //   5: invokeinterface size : ()I
    //   10: ifne -> 16
    //   13: goto -> 479
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc_w '_id in '
    //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_2
    //   33: ldc_w '('
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: invokeinterface iterator : ()Ljava/util/Iterator;
    //   46: astore_1
    //   47: aload_1
    //   48: invokeinterface hasNext : ()Z
    //   53: ifeq -> 84
    //   56: aload_2
    //   57: aload_1
    //   58: invokeinterface next : ()Ljava/lang/Object;
    //   63: checkcast com/tencent/bugly/crashreport/crash/a
    //   66: getfield a : J
    //   69: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: ldc_w ','
    //   77: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: goto -> 47
    //   84: aload_2
    //   85: invokevirtual toString : ()Ljava/lang/String;
    //   88: ldc_w ','
    //   91: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   94: ifeq -> 120
    //   97: new java/lang/StringBuilder
    //   100: dup
    //   101: aload_2
    //   102: iconst_0
    //   103: aload_2
    //   104: ldc_w ','
    //   107: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   110: invokevirtual substring : (II)Ljava/lang/String;
    //   113: invokespecial <init> : (Ljava/lang/String;)V
    //   116: astore_2
    //   117: goto -> 120
    //   120: aload_2
    //   121: ldc_w ')'
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_2
    //   129: invokevirtual toString : ()Ljava/lang/String;
    //   132: astore_1
    //   133: aload_2
    //   134: iconst_0
    //   135: invokevirtual setLength : (I)V
    //   138: invokestatic a : ()Lcom/tencent/bugly/proguard/p;
    //   141: ldc_w 't_cr'
    //   144: aconst_null
    //   145: aload_1
    //   146: aconst_null
    //   147: aconst_null
    //   148: iconst_1
    //   149: invokevirtual a : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)Landroid/database/Cursor;
    //   152: astore_3
    //   153: aload_3
    //   154: ifnonnull -> 169
    //   157: aload_3
    //   158: ifnull -> 167
    //   161: aload_3
    //   162: invokeinterface close : ()V
    //   167: aconst_null
    //   168: areturn
    //   169: aload_3
    //   170: astore_1
    //   171: new java/util/ArrayList
    //   174: astore #4
    //   176: aload_3
    //   177: astore_1
    //   178: aload #4
    //   180: invokespecial <init> : ()V
    //   183: aload_3
    //   184: astore_1
    //   185: aload_2
    //   186: ldc_w '_id in '
    //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_3
    //   194: astore_1
    //   195: aload_2
    //   196: ldc_w '('
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: iconst_0
    //   204: istore #5
    //   206: aload_3
    //   207: astore_1
    //   208: aload_3
    //   209: invokeinterface moveToNext : ()Z
    //   214: ifeq -> 299
    //   217: aload_3
    //   218: astore_1
    //   219: aload_3
    //   220: invokestatic a : (Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   223: astore #6
    //   225: aload #6
    //   227: ifnull -> 245
    //   230: aload_3
    //   231: astore_1
    //   232: aload #4
    //   234: aload #6
    //   236: invokeinterface add : (Ljava/lang/Object;)Z
    //   241: pop
    //   242: goto -> 206
    //   245: aload_3
    //   246: astore_1
    //   247: aload_2
    //   248: aload_3
    //   249: aload_3
    //   250: ldc '_id'
    //   252: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   257: invokeinterface getLong : (I)J
    //   262: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_3
    //   267: astore_1
    //   268: aload_2
    //   269: ldc_w ','
    //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: iinc #5, 1
    //   279: goto -> 206
    //   282: astore_1
    //   283: aload_3
    //   284: astore_1
    //   285: ldc_w 'unknown id!'
    //   288: iconst_0
    //   289: anewarray java/lang/Object
    //   292: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   295: pop
    //   296: goto -> 206
    //   299: aload_2
    //   300: astore #6
    //   302: aload_3
    //   303: astore_1
    //   304: aload_2
    //   305: invokevirtual toString : ()Ljava/lang/String;
    //   308: ldc_w ','
    //   311: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   314: ifeq -> 343
    //   317: aload_3
    //   318: astore_1
    //   319: new java/lang/StringBuilder
    //   322: astore #6
    //   324: aload_3
    //   325: astore_1
    //   326: aload #6
    //   328: aload_2
    //   329: iconst_0
    //   330: aload_2
    //   331: ldc_w ','
    //   334: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   337: invokevirtual substring : (II)Ljava/lang/String;
    //   340: invokespecial <init> : (Ljava/lang/String;)V
    //   343: aload_3
    //   344: astore_1
    //   345: aload #6
    //   347: ldc_w ')'
    //   350: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload_3
    //   355: astore_1
    //   356: aload #6
    //   358: invokevirtual toString : ()Ljava/lang/String;
    //   361: astore_2
    //   362: iload #5
    //   364: ifle -> 405
    //   367: aload_3
    //   368: astore_1
    //   369: ldc_w 'deleted %s illegal data %d'
    //   372: iconst_2
    //   373: anewarray java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: ldc_w 't_cr'
    //   381: aastore
    //   382: dup
    //   383: iconst_1
    //   384: invokestatic a : ()Lcom/tencent/bugly/proguard/p;
    //   387: ldc_w 't_cr'
    //   390: aload_2
    //   391: aconst_null
    //   392: aconst_null
    //   393: iconst_1
    //   394: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   397: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   400: aastore
    //   401: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   404: pop
    //   405: aload_3
    //   406: ifnull -> 415
    //   409: aload_3
    //   410: invokeinterface close : ()V
    //   415: aload #4
    //   417: areturn
    //   418: astore_1
    //   419: aload_3
    //   420: astore_2
    //   421: aload_1
    //   422: astore_3
    //   423: goto -> 437
    //   426: astore_1
    //   427: aconst_null
    //   428: astore_3
    //   429: aload_1
    //   430: astore_2
    //   431: goto -> 467
    //   434: astore_3
    //   435: aconst_null
    //   436: astore_2
    //   437: aload_2
    //   438: astore_1
    //   439: aload_3
    //   440: invokestatic a : (Ljava/lang/Throwable;)Z
    //   443: ifne -> 452
    //   446: aload_2
    //   447: astore_1
    //   448: aload_3
    //   449: invokevirtual printStackTrace : ()V
    //   452: aload_2
    //   453: ifnull -> 462
    //   456: aload_2
    //   457: invokeinterface close : ()V
    //   462: aconst_null
    //   463: areturn
    //   464: astore_2
    //   465: aload_1
    //   466: astore_3
    //   467: aload_3
    //   468: ifnull -> 477
    //   471: aload_3
    //   472: invokeinterface close : ()V
    //   477: aload_2
    //   478: athrow
    //   479: aconst_null
    //   480: areturn
    // Exception table:
    //   from	to	target	type
    //   138	153	434	java/lang/Throwable
    //   138	153	426	finally
    //   171	176	418	java/lang/Throwable
    //   171	176	464	finally
    //   178	183	418	java/lang/Throwable
    //   178	183	464	finally
    //   185	193	418	java/lang/Throwable
    //   185	193	464	finally
    //   195	203	418	java/lang/Throwable
    //   195	203	464	finally
    //   208	217	418	java/lang/Throwable
    //   208	217	464	finally
    //   219	225	418	java/lang/Throwable
    //   219	225	464	finally
    //   232	242	418	java/lang/Throwable
    //   232	242	464	finally
    //   247	266	282	java/lang/Throwable
    //   247	266	464	finally
    //   268	276	282	java/lang/Throwable
    //   268	276	464	finally
    //   285	296	418	java/lang/Throwable
    //   285	296	464	finally
    //   304	317	418	java/lang/Throwable
    //   304	317	464	finally
    //   319	324	418	java/lang/Throwable
    //   319	324	464	finally
    //   326	343	418	java/lang/Throwable
    //   326	343	464	finally
    //   345	354	418	java/lang/Throwable
    //   345	354	464	finally
    //   356	362	418	java/lang/Throwable
    //   356	362	464	finally
    //   369	405	418	java/lang/Throwable
    //   369	405	464	finally
    //   439	446	464	finally
    //   448	452	464	finally
  }
  
  private static void c(List<a> paramList) {
    if (paramList == null || paramList.size() == 0)
      return; 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("_id in ");
    stringBuilder2.append("(");
    Iterator<a> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      stringBuilder2.append(((a)iterator.next()).a);
      stringBuilder2.append(",");
    } 
    StringBuilder stringBuilder1 = new StringBuilder(stringBuilder2.substring(0, stringBuilder2.lastIndexOf(",")));
    stringBuilder1.append(")");
    String str = stringBuilder1.toString();
    stringBuilder1.setLength(0);
    try {
      x.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(p.a().a("t_cr", str, null, null, true)) });
      return;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return;
    } 
  }
  
  private static void d(List<CrashDetailBean> paramList) {
    if (paramList != null)
      try {
        if (paramList.size() != 0) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          for (CrashDetailBean crashDetailBean : paramList) {
            stringBuilder.append(" or _id");
            stringBuilder.append(" = ");
            stringBuilder.append(crashDetailBean.a);
          } 
          String str2 = stringBuilder.toString();
          String str1 = str2;
          if (str2.length() > 0)
            str1 = str2.substring(4); 
          stringBuilder.setLength(0);
          x.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(p.a().a("t_cr", str1, null, null, true)) });
          return;
        } 
      } catch (Throwable throwable) {
        if (!x.a(throwable))
          throwable.printStackTrace(); 
        return;
      }  
  }
  
  private static ContentValues e(CrashDetailBean paramCrashDetailBean) {
    if (paramCrashDetailBean == null)
      return null; 
    try {
      ContentValues contentValues = new ContentValues();
      this();
      if (paramCrashDetailBean.a > 0L)
        contentValues.put("_id", Long.valueOf(paramCrashDetailBean.a)); 
      contentValues.put("_tm", Long.valueOf(paramCrashDetailBean.r));
      contentValues.put("_s1", paramCrashDetailBean.u);
      contentValues.put("_up", Integer.valueOf(paramCrashDetailBean.d));
      contentValues.put("_me", Integer.valueOf(paramCrashDetailBean.j));
      contentValues.put("_uc", Integer.valueOf(paramCrashDetailBean.l));
      contentValues.put("_dt", z.a(paramCrashDetailBean));
      return contentValues;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public final List<CrashDetailBean> a() {
    StrategyBean strategyBean = a.a().c();
    if (strategyBean == null) {
      x.d("have not synced remote!", new Object[0]);
      return null;
    } 
    if (!strategyBean.g) {
      x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
      x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
      return null;
    } 
    long l1 = System.currentTimeMillis();
    long l2 = z.b();
    List<a> list = b();
    x.c("Size of crash list loaded from DB: %s", new Object[] { Integer.valueOf(list.size()) });
    if (list == null || list.size() <= 0)
      return null; 
    ArrayList<a> arrayList = new ArrayList();
    arrayList.addAll(a(list));
    list.removeAll(arrayList);
    Iterator<a> iterator = list.iterator();
    while (iterator.hasNext()) {
      a a1 = iterator.next();
      if (a1.b < l2 - c.g) {
        iterator.remove();
        arrayList.add(a1);
        continue;
      } 
      if (a1.d) {
        if (a1.b >= l1 - 86400000L) {
          iterator.remove();
          continue;
        } 
        if (!a1.e) {
          iterator.remove();
          arrayList.add(a1);
        } 
        continue;
      } 
      if (a1.f >= 3L && a1.b < l1 - 86400000L) {
        iterator.remove();
        arrayList.add(a1);
      } 
    } 
    if (arrayList.size() > 0)
      c(arrayList); 
    arrayList = new ArrayList<a>();
    List<CrashDetailBean> list1 = b(list);
    if (list1 != null && list1.size() > 0) {
      String str = (a.b()).j;
      Iterator<CrashDetailBean> iterator1 = list1.iterator();
      while (iterator1.hasNext()) {
        CrashDetailBean crashDetailBean = iterator1.next();
        if (!str.equals(crashDetailBean.f)) {
          iterator1.remove();
          arrayList.add(crashDetailBean);
        } 
      } 
    } 
    if (arrayList.size() > 0)
      d((List)arrayList); 
    return list1;
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean, long paramLong, boolean paramBoolean) {
    if (c.l) {
      boolean bool;
      x.a("try to upload right now", new Object[0]);
      ArrayList<CrashDetailBean> arrayList = new ArrayList();
      arrayList.add(paramCrashDetailBean);
      if (paramCrashDetailBean.b == 7) {
        bool = true;
      } else {
        bool = false;
      } 
      a(arrayList, 3000L, paramBoolean, bool, paramBoolean);
    } 
  }
  
  public final void a(List<CrashDetailBean> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (!(a.a(this.b)).e)
      return; 
    if (this.c == null)
      return; 
    if (!paramBoolean3 && !this.c.b(c.a))
      return; 
    StrategyBean strategyBean = this.e.c();
    if (!strategyBean.g) {
      x.d("remote report is disable!", new Object[0]);
      x.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
      return;
    } 
    if (paramList == null || paramList.size() == 0)
      return; 
    try {
      String str1;
      String str2;
      char c;
      CrashDetailBean crashDetailBean;
      if (this.c.a) {
        str1 = strategyBean.s;
      } else {
        str1 = ((StrategyBean)str1).t;
      } 
      if (this.c.a) {
        str2 = StrategyBean.c;
      } else {
        str2 = StrategyBean.a;
      } 
      if (this.c.a) {
        c = '̾';
      } else {
        c = 'ɶ';
      } 
      Context context = this.b;
      a a1 = a.b();
      if (context == null || paramList == null || paramList.size() == 0 || a1 == null) {
        x.d("enEXPPkg args == null!", new Object[0]);
        crashDetailBean = null;
      } else {
        ao ao = new ao();
        this();
        ArrayList arrayList = new ArrayList();
        this();
        ao.a = arrayList;
        Iterator<CrashDetailBean> iterator = paramList.iterator();
        while (true) {
          ao ao1 = ao;
          if (iterator.hasNext()) {
            crashDetailBean = iterator.next();
            ao.a.add(a(context, crashDetailBean, a1));
            continue;
          } 
          break;
        } 
      } 
      if (crashDetailBean == null) {
        x.d("create eupPkg fail!", new Object[0]);
        return;
      } 
      byte[] arrayOfByte = a.a((k)crashDetailBean);
      if (arrayOfByte == null) {
        x.d("send encode fail!", new Object[0]);
        return;
      } 
      ap ap = a.a(this.b, c, arrayOfByte);
      if (ap == null) {
        x.d("request package is null.", new Object[0]);
        return;
      } 
      t t = new t() {
          public final void a(boolean param1Boolean) {
            b b1 = this.b;
            b.a(param1Boolean, this.a);
          }
        };
      super(this, paramList);
      if (paramBoolean1) {
        this.c.a(a, ap, str1, str2, t, paramLong, paramBoolean2);
      } else {
        this.c.a(a, ap, str1, str2, t, false);
        return;
      } 
    } catch (Throwable throwable) {
      x.e("req cr error %s", new Object[] { throwable.toString() });
      if (!x.b(throwable))
        throwable.printStackTrace(); 
    } 
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean) {
    return a(paramCrashDetailBean, -123456789);
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 6
    //   4: iconst_1
    //   5: ireturn
    //   6: getstatic com/tencent/bugly/crashreport/crash/c.n : Ljava/lang/String;
    //   9: ifnull -> 64
    //   12: getstatic com/tencent/bugly/crashreport/crash/c.n : Ljava/lang/String;
    //   15: invokevirtual isEmpty : ()Z
    //   18: ifne -> 64
    //   21: ldc_w 'Crash filter for crash stack is: %s'
    //   24: iconst_1
    //   25: anewarray java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: getstatic com/tencent/bugly/crashreport/crash/c.n : Ljava/lang/String;
    //   33: aastore
    //   34: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload_1
    //   39: getfield q : Ljava/lang/String;
    //   42: getstatic com/tencent/bugly/crashreport/crash/c.n : Ljava/lang/String;
    //   45: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   48: ifeq -> 64
    //   51: ldc_w 'This crash contains the filter string set. It will not be record and upload.'
    //   54: iconst_0
    //   55: anewarray java/lang/Object
    //   58: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   61: pop
    //   62: iconst_1
    //   63: ireturn
    //   64: getstatic com/tencent/bugly/crashreport/crash/c.o : Ljava/lang/String;
    //   67: ifnull -> 128
    //   70: getstatic com/tencent/bugly/crashreport/crash/c.o : Ljava/lang/String;
    //   73: invokevirtual isEmpty : ()Z
    //   76: ifne -> 128
    //   79: ldc_w 'Crash regular filter for crash stack is: %s'
    //   82: iconst_1
    //   83: anewarray java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: getstatic com/tencent/bugly/crashreport/crash/c.o : Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   95: pop
    //   96: getstatic com/tencent/bugly/crashreport/crash/c.o : Ljava/lang/String;
    //   99: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   102: aload_1
    //   103: getfield q : Ljava/lang/String;
    //   106: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   109: invokevirtual find : ()Z
    //   112: ifeq -> 128
    //   115: ldc_w 'This crash matches the regular filter string set. It will not be record and upload.'
    //   118: iconst_0
    //   119: anewarray java/lang/Object
    //   122: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   125: pop
    //   126: iconst_1
    //   127: ireturn
    //   128: aload_1
    //   129: getfield b : I
    //   132: istore_2
    //   133: aload_1
    //   134: getfield n : Ljava/lang/String;
    //   137: astore_3
    //   138: aload_1
    //   139: getfield o : Ljava/lang/String;
    //   142: astore_3
    //   143: aload_1
    //   144: getfield p : Ljava/lang/String;
    //   147: astore_3
    //   148: aload_1
    //   149: getfield q : Ljava/lang/String;
    //   152: astore_3
    //   153: aload_1
    //   154: getfield r : J
    //   157: lstore #4
    //   159: aload_1
    //   160: getfield m : Ljava/lang/String;
    //   163: astore_3
    //   164: aload_1
    //   165: getfield e : Ljava/lang/String;
    //   168: astore_3
    //   169: aload_1
    //   170: getfield c : Ljava/lang/String;
    //   173: astore_3
    //   174: aload_1
    //   175: getfield A : Ljava/lang/String;
    //   178: astore_3
    //   179: aload_1
    //   180: getfield B : Ljava/lang/String;
    //   183: astore_3
    //   184: aload_0
    //   185: getfield f : Lcom/tencent/bugly/proguard/o;
    //   188: ifnull -> 227
    //   191: ldc_w 'Calling 'onCrashSaving' of RQD crash listener.'
    //   194: iconst_0
    //   195: anewarray java/lang/Object
    //   198: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   201: pop
    //   202: aload_0
    //   203: getfield f : Lcom/tencent/bugly/proguard/o;
    //   206: invokeinterface c : ()Z
    //   211: ifne -> 227
    //   214: ldc_w 'Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.'
    //   217: iconst_0
    //   218: anewarray java/lang/Object
    //   221: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   224: pop
    //   225: iconst_1
    //   226: ireturn
    //   227: aload_1
    //   228: getfield b : I
    //   231: iconst_2
    //   232: if_icmpeq -> 303
    //   235: new com/tencent/bugly/proguard/r
    //   238: dup
    //   239: invokespecial <init> : ()V
    //   242: astore_3
    //   243: aload_3
    //   244: iconst_1
    //   245: putfield b : I
    //   248: aload_3
    //   249: aload_1
    //   250: getfield A : Ljava/lang/String;
    //   253: putfield c : Ljava/lang/String;
    //   256: aload_3
    //   257: aload_1
    //   258: getfield B : Ljava/lang/String;
    //   261: putfield d : Ljava/lang/String;
    //   264: aload_3
    //   265: aload_1
    //   266: getfield r : J
    //   269: putfield e : J
    //   272: aload_0
    //   273: getfield d : Lcom/tencent/bugly/proguard/p;
    //   276: iconst_1
    //   277: invokevirtual b : (I)V
    //   280: aload_0
    //   281: getfield d : Lcom/tencent/bugly/proguard/p;
    //   284: aload_3
    //   285: invokevirtual a : (Lcom/tencent/bugly/proguard/r;)Z
    //   288: pop
    //   289: ldc_w '[crash] a crash occur, handling...'
    //   292: iconst_0
    //   293: anewarray java/lang/Object
    //   296: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   299: pop
    //   300: goto -> 314
    //   303: ldc_w '[crash] a caught exception occur, handling...'
    //   306: iconst_0
    //   307: anewarray java/lang/Object
    //   310: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   313: pop
    //   314: aload_0
    //   315: invokespecial b : ()Ljava/util/List;
    //   318: astore #6
    //   320: aconst_null
    //   321: astore #7
    //   323: aload #7
    //   325: astore_3
    //   326: aload #6
    //   328: ifnull -> 741
    //   331: aload #7
    //   333: astore_3
    //   334: aload #6
    //   336: invokeinterface size : ()I
    //   341: ifle -> 741
    //   344: new java/util/ArrayList
    //   347: dup
    //   348: bipush #10
    //   350: invokespecial <init> : (I)V
    //   353: astore #7
    //   355: new java/util/ArrayList
    //   358: dup
    //   359: bipush #10
    //   361: invokespecial <init> : (I)V
    //   364: astore #8
    //   366: aload #7
    //   368: aload #6
    //   370: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   373: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   378: pop
    //   379: aload #6
    //   381: aload #7
    //   383: invokeinterface removeAll : (Ljava/util/Collection;)Z
    //   388: pop
    //   389: aload #6
    //   391: invokeinterface size : ()I
    //   396: i2l
    //   397: ldc2_w 20
    //   400: lcmp
    //   401: ifle -> 539
    //   404: new java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial <init> : ()V
    //   411: astore #9
    //   413: aload #9
    //   415: ldc_w '_id in '
    //   418: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload #9
    //   424: ldc_w '('
    //   427: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload #9
    //   433: ldc_w 'SELECT _id'
    //   436: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload #9
    //   442: ldc_w ' FROM t_cr'
    //   445: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload #9
    //   451: ldc_w ' order by _id'
    //   454: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload #9
    //   460: ldc_w ' limit 5'
    //   463: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload #9
    //   469: ldc_w ')'
    //   472: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload #9
    //   478: invokevirtual toString : ()Ljava/lang/String;
    //   481: astore_3
    //   482: aload #9
    //   484: iconst_0
    //   485: invokevirtual setLength : (I)V
    //   488: ldc_w 'deleted first record %s data %d'
    //   491: iconst_2
    //   492: anewarray java/lang/Object
    //   495: dup
    //   496: iconst_0
    //   497: ldc_w 't_cr'
    //   500: aastore
    //   501: dup
    //   502: iconst_1
    //   503: invokestatic a : ()Lcom/tencent/bugly/proguard/p;
    //   506: ldc_w 't_cr'
    //   509: aload_3
    //   510: aconst_null
    //   511: aconst_null
    //   512: iconst_1
    //   513: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   516: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   519: aastore
    //   520: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   523: pop
    //   524: goto -> 539
    //   527: astore_3
    //   528: aload_3
    //   529: invokestatic a : (Ljava/lang/Throwable;)Z
    //   532: ifne -> 539
    //   535: aload_3
    //   536: invokevirtual printStackTrace : ()V
    //   539: aload #7
    //   541: astore_3
    //   542: getstatic com/tencent/bugly/b.c : Z
    //   545: ifne -> 741
    //   548: aload #7
    //   550: astore_3
    //   551: getstatic com/tencent/bugly/crashreport/crash/c.d : Z
    //   554: ifeq -> 741
    //   557: aload #6
    //   559: invokeinterface iterator : ()Ljava/util/Iterator;
    //   564: astore_3
    //   565: iconst_0
    //   566: istore_2
    //   567: aload_3
    //   568: invokeinterface hasNext : ()Z
    //   573: ifeq -> 625
    //   576: aload_3
    //   577: invokeinterface next : ()Ljava/lang/Object;
    //   582: checkcast com/tencent/bugly/crashreport/crash/a
    //   585: astore #6
    //   587: aload_1
    //   588: getfield u : Ljava/lang/String;
    //   591: aload #6
    //   593: getfield c : Ljava/lang/String;
    //   596: invokevirtual equals : (Ljava/lang/Object;)Z
    //   599: ifeq -> 567
    //   602: aload #6
    //   604: getfield e : Z
    //   607: ifeq -> 612
    //   610: iconst_1
    //   611: istore_2
    //   612: aload #8
    //   614: aload #6
    //   616: invokeinterface add : (Ljava/lang/Object;)Z
    //   621: pop
    //   622: goto -> 567
    //   625: iload_2
    //   626: ifne -> 645
    //   629: aload #7
    //   631: astore_3
    //   632: aload #8
    //   634: invokeinterface size : ()I
    //   639: getstatic com/tencent/bugly/crashreport/crash/c.c : I
    //   642: if_icmplt -> 741
    //   645: ldc_w 'same crash occur too much do merged!'
    //   648: iconst_0
    //   649: anewarray java/lang/Object
    //   652: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   655: pop
    //   656: aload_0
    //   657: aload #8
    //   659: aload_1
    //   660: invokespecial a : (Ljava/util/List;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   663: astore_1
    //   664: aload #8
    //   666: invokeinterface iterator : ()Ljava/util/Iterator;
    //   671: astore #8
    //   673: aload #8
    //   675: invokeinterface hasNext : ()Z
    //   680: ifeq -> 718
    //   683: aload #8
    //   685: invokeinterface next : ()Ljava/lang/Object;
    //   690: checkcast com/tencent/bugly/crashreport/crash/a
    //   693: astore_3
    //   694: aload_3
    //   695: getfield a : J
    //   698: aload_1
    //   699: getfield a : J
    //   702: lcmp
    //   703: ifeq -> 673
    //   706: aload #7
    //   708: aload_3
    //   709: invokeinterface add : (Ljava/lang/Object;)Z
    //   714: pop
    //   715: goto -> 673
    //   718: aload_0
    //   719: aload_1
    //   720: invokevirtual d : (Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   723: aload #7
    //   725: invokestatic c : (Ljava/util/List;)V
    //   728: ldc_w '[crash] save crash success. For this device crash many times, it will not upload crashes immediately'
    //   731: iconst_0
    //   732: anewarray java/lang/Object
    //   735: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   738: pop
    //   739: iconst_1
    //   740: ireturn
    //   741: aload_0
    //   742: aload_1
    //   743: invokevirtual d : (Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   746: aload_3
    //   747: ifnull -> 763
    //   750: aload_3
    //   751: invokeinterface isEmpty : ()Z
    //   756: ifne -> 763
    //   759: aload_3
    //   760: invokestatic c : (Ljava/util/List;)V
    //   763: ldc_w '[crash] save crash success'
    //   766: iconst_0
    //   767: anewarray java/lang/Object
    //   770: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   773: pop
    //   774: iconst_0
    //   775: ireturn
    // Exception table:
    //   from	to	target	type
    //   488	524	527	java/lang/Throwable
  }
  
  public final void b(CrashDetailBean paramCrashDetailBean) {
    if (this.f != null) {
      x.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
      o o1 = this.f;
      int i = paramCrashDetailBean.b;
    } 
  }
  
  public final void c(CrashDetailBean paramCrashDetailBean) {
    if (paramCrashDetailBean == null)
      return; 
    if (this.g == null && this.f == null)
      return; 
    try {
      byte b1;
      byte[] arrayOfByte;
      x.a("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
      switch (paramCrashDetailBean.b) {
        default:
          return;
        case 7:
          b1 = 7;
          break;
        case 6:
          b1 = 6;
          break;
        case 5:
          b1 = 5;
          break;
        case 4:
          b1 = 3;
          break;
        case 3:
          b1 = 4;
          break;
        case 2:
          b1 = 1;
          break;
        case 1:
          b1 = 2;
          break;
        case 0:
          b1 = 0;
          break;
      } 
      int i = paramCrashDetailBean.b;
      String str = paramCrashDetailBean.n;
      str = paramCrashDetailBean.p;
      str = paramCrashDetailBean.q;
      long l = paramCrashDetailBean.r;
      o o1 = this.f;
      o o2 = null;
      if (o1 != null) {
        x.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
        o1 = this.f;
        x.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
        String str1 = this.f.b();
        if (str1 != null) {
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          this(1);
          hashMap.put("userData", str1);
        } else {
          o1 = null;
        } 
      } else if (this.g != null) {
        x.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
        Map map = this.g.onCrashHandleStart(b1, paramCrashDetailBean.n, paramCrashDetailBean.o, paramCrashDetailBean.q);
      } else {
        o1 = null;
      } 
      if (o1 != null && o1.size() > 0) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        this(o1.size());
        paramCrashDetailBean.O = (Map)linkedHashMap;
        for (Map.Entry entry : o1.entrySet()) {
          if (!z.a((String)entry.getKey())) {
            String str2 = (String)entry.getKey();
            String str1 = str2;
            if (str2.length() > 100) {
              str1 = str2.substring(0, 100);
              x.d("setted key length is over limit %d substring to %s", new Object[] { Integer.valueOf(100), str1 });
            } 
            if (!z.a((String)entry.getValue()) && ((String)entry.getValue()).length() > 30000) {
              str2 = ((String)entry.getValue()).substring(((String)entry.getValue()).length() - 30000);
              x.d("setted %s value length is over limit %d substring", new Object[] { str1, Integer.valueOf(30000) });
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              this();
              stringBuilder.append((String)entry.getValue());
              str2 = stringBuilder.toString();
            } 
            paramCrashDetailBean.O.put(str1, str2);
            x.a("add setted key %s value size:%d", new Object[] { str1, Integer.valueOf(str2.length()) });
          } 
        } 
      } 
      x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
      if (this.f != null) {
        x.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
        arrayOfByte = this.f.a();
      } else {
        o1 = o2;
        if (this.g != null) {
          x.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
          arrayOfByte = this.g.onCrashHandleStart2GetExtraDatas(b1, paramCrashDetailBean.n, paramCrashDetailBean.o, paramCrashDetailBean.q);
        } 
      } 
      paramCrashDetailBean.T = arrayOfByte;
      if (arrayOfByte != null) {
        if (arrayOfByte.length > 30000) {
          x.d("extra bytes size %d is over limit %d will drop over part", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(30000) });
          paramCrashDetailBean.T = Arrays.copyOf(arrayOfByte, 30000);
        } 
        x.a("add extra bytes %d ", new Object[] { Integer.valueOf(arrayOfByte.length) });
      } 
      return;
    } catch (Throwable throwable) {
      x.d("crash handle callback something wrong! %s", new Object[] { throwable.getClass().getName() });
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return;
    } 
  }
  
  public final void d(CrashDetailBean paramCrashDetailBean) {
    if (paramCrashDetailBean == null)
      return; 
    ContentValues contentValues = e(paramCrashDetailBean);
    if (contentValues != null) {
      long l = p.a().a("t_cr", contentValues, null, true);
      if (l >= 0L) {
        x.c("insert %s success!", new Object[] { "t_cr" });
        paramCrashDetailBean.a = l;
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\crash\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */