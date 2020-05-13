package com.alipay.apmobilesecuritysdk.common;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import java.util.ArrayList;
import java.util.List;

public final class a {
  public static boolean a(Context paramContext) {
    boolean bool = true;
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(h.e(paramContext));
    if (!a(arrayList) && !a(new RushTimeUtil$1()))
      bool = false; 
    return bool;
  }
  
  private static boolean a(List<String> paramList) {
    // Byte code:
    //   0: new java/text/SimpleDateFormat
    //   3: dup
    //   4: ldc 'yyyy-MM-dd HH:mm:ss'
    //   6: invokespecial <init> : (Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: iconst_0
    //   12: invokevirtual setLenient : (Z)V
    //   15: invokestatic random : ()D
    //   18: ldc2_w 24.0
    //   21: dmul
    //   22: ldc2_w 60.0
    //   25: dmul
    //   26: ldc2_w 60.0
    //   29: dmul
    //   30: d2i
    //   31: istore_2
    //   32: aload_0
    //   33: invokeinterface iterator : ()Ljava/util/Iterator;
    //   38: astore_3
    //   39: aload_3
    //   40: invokeinterface hasNext : ()Z
    //   45: ifeq -> 208
    //   48: aload_3
    //   49: invokeinterface next : ()Ljava/lang/Object;
    //   54: checkcast java/lang/String
    //   57: ldc '&'
    //   59: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore #4
    //   64: aload #4
    //   66: ifnull -> 39
    //   69: aload #4
    //   71: arraylength
    //   72: iconst_2
    //   73: if_icmpne -> 39
    //   76: new java/util/Date
    //   79: astore_0
    //   80: aload_0
    //   81: invokespecial <init> : ()V
    //   84: new java/lang/StringBuilder
    //   87: astore #5
    //   89: aload #5
    //   91: invokespecial <init> : ()V
    //   94: aload_1
    //   95: aload #5
    //   97: aload #4
    //   99: iconst_0
    //   100: aaload
    //   101: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc ' 00:00:00'
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual toString : ()Ljava/lang/String;
    //   112: invokevirtual parse : (Ljava/lang/String;)Ljava/util/Date;
    //   115: astore #5
    //   117: new java/lang/StringBuilder
    //   120: astore #6
    //   122: aload #6
    //   124: invokespecial <init> : ()V
    //   127: aload_1
    //   128: aload #6
    //   130: aload #4
    //   132: iconst_1
    //   133: aaload
    //   134: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc ' 23:59:59'
    //   139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual toString : ()Ljava/lang/String;
    //   145: invokevirtual parse : (Ljava/lang/String;)Ljava/util/Date;
    //   148: astore #6
    //   150: invokestatic getInstance : ()Ljava/util/Calendar;
    //   153: astore #4
    //   155: aload #4
    //   157: aload #6
    //   159: invokevirtual setTime : (Ljava/util/Date;)V
    //   162: aload #4
    //   164: bipush #13
    //   166: iload_2
    //   167: iconst_1
    //   168: imul
    //   169: invokevirtual add : (II)V
    //   172: aload #4
    //   174: invokevirtual getTime : ()Ljava/util/Date;
    //   177: astore #4
    //   179: aload_0
    //   180: aload #5
    //   182: invokevirtual after : (Ljava/util/Date;)Z
    //   185: ifeq -> 39
    //   188: aload_0
    //   189: aload #4
    //   191: invokevirtual before : (Ljava/util/Date;)Z
    //   194: istore #7
    //   196: iload #7
    //   198: ifeq -> 39
    //   201: iconst_1
    //   202: istore #7
    //   204: iload #7
    //   206: ireturn
    //   207: astore_0
    //   208: iconst_0
    //   209: istore #7
    //   211: goto -> 204
    // Exception table:
    //   from	to	target	type
    //   32	39	207	java/lang/Exception
    //   39	64	207	java/lang/Exception
    //   69	196	207	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */