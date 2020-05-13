package com.sdk.base.framework.utils.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.a;
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.base.framework.utils.f.b;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class a extends a {
  private static final boolean a = c.h;
  
  private static final String b = a.class.getSimpleName();
  
  public static ArrayList<KInfo> a(Context paramContext) {
    ArrayList<KInfo> arrayList1;
    ArrayList<KInfo> arrayList2 = new ArrayList();
    try {
      if (AppUtils.getAndroidSDKVersion(paramContext) >= 21)
        return b(paramContext); 
      arrayList1 = c(paramContext);
    } catch (Exception exception) {
      b.c(b, exception.getMessage(), Boolean.valueOf(a));
      arrayList1 = arrayList2;
    } 
    return arrayList1;
  }
  
  @TargetApi(22)
  public static ArrayList<KInfo> b(Context paramContext) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: pop2
    //   4: new java/util/ArrayList
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: astore_1
    //   12: ldc 'android.telephony.SubscriptionInfo'
    //   14: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   17: astore_2
    //   18: aload_2
    //   19: ldc 'getIccId'
    //   21: iconst_0
    //   22: anewarray java/lang/Class
    //   25: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   28: astore_3
    //   29: aload_3
    //   30: iconst_1
    //   31: invokevirtual setAccessible : (Z)V
    //   34: aload_2
    //   35: ldc 'getSubscriptionId'
    //   37: iconst_0
    //   38: anewarray java/lang/Class
    //   41: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   44: astore #4
    //   46: aload #4
    //   48: iconst_1
    //   49: invokevirtual setAccessible : (Z)V
    //   52: aload_2
    //   53: ldc 'getNumber'
    //   55: iconst_0
    //   56: anewarray java/lang/Class
    //   59: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   62: astore #5
    //   64: aload #5
    //   66: iconst_1
    //   67: invokevirtual setAccessible : (Z)V
    //   70: aload_2
    //   71: ldc 'getSimSlotIndex'
    //   73: iconst_0
    //   74: anewarray java/lang/Class
    //   77: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   80: astore #6
    //   82: aload #6
    //   84: iconst_1
    //   85: invokevirtual setAccessible : (Z)V
    //   88: aload_2
    //   89: ldc 'getCarrierName'
    //   91: iconst_0
    //   92: anewarray java/lang/Class
    //   95: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   98: astore #7
    //   100: aload #7
    //   102: iconst_1
    //   103: invokevirtual setAccessible : (Z)V
    //   106: aload_0
    //   107: ldc 'getActiveSubscriptionInfoList'
    //   109: iconst_0
    //   110: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   113: aconst_null
    //   114: aconst_null
    //   115: invokestatic invokeOnSubscriptionManager : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast java/util/List
    //   121: astore #8
    //   123: aload #8
    //   125: ifnull -> 589
    //   128: iconst_0
    //   129: istore #9
    //   131: iload #9
    //   133: aload #8
    //   135: invokeinterface size : ()I
    //   140: if_icmpge -> 589
    //   143: aload #8
    //   145: iload #9
    //   147: invokeinterface get : (I)Ljava/lang/Object;
    //   152: astore #10
    //   154: new com/sdk/base/framework/bean/KInfo
    //   157: astore #11
    //   159: aload #11
    //   161: invokespecial <init> : ()V
    //   164: aload #4
    //   166: aload #10
    //   168: iconst_0
    //   169: anewarray java/lang/Object
    //   172: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   175: checkcast java/lang/Integer
    //   178: invokevirtual intValue : ()I
    //   181: istore #12
    //   183: aload #6
    //   185: aload #10
    //   187: iconst_0
    //   188: anewarray java/lang/Object
    //   191: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   194: checkcast java/lang/Integer
    //   197: invokevirtual intValue : ()I
    //   200: istore #13
    //   202: aload_0
    //   203: ldc 'getSubscriberId'
    //   205: iconst_0
    //   206: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   209: iconst_1
    //   210: anewarray java/lang/Class
    //   213: dup
    //   214: iconst_0
    //   215: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   218: aastore
    //   219: iconst_1
    //   220: anewarray java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: iload #12
    //   227: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   230: aastore
    //   231: invokestatic invokeOnTelephonyManager : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   234: checkcast java/lang/String
    //   237: astore #14
    //   239: aload #14
    //   241: astore_2
    //   242: aload #14
    //   244: invokestatic a : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   247: invokevirtual booleanValue : ()Z
    //   250: ifeq -> 269
    //   253: aload_0
    //   254: ldc 'getSubscriberId'
    //   256: iconst_0
    //   257: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   260: aconst_null
    //   261: aconst_null
    //   262: invokestatic invokeOnTelephonyManager : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   265: checkcast java/lang/String
    //   268: astore_2
    //   269: aload_2
    //   270: invokestatic b : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   273: invokevirtual booleanValue : ()Z
    //   276: ifeq -> 285
    //   279: aload #11
    //   281: aload_2
    //   282: invokevirtual setIs : (Ljava/lang/String;)V
    //   285: aload_0
    //   286: ldc 'getDeviceId'
    //   288: iconst_0
    //   289: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   292: iconst_1
    //   293: anewarray java/lang/Class
    //   296: dup
    //   297: iconst_0
    //   298: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   301: aastore
    //   302: iconst_1
    //   303: anewarray java/lang/Object
    //   306: dup
    //   307: iconst_0
    //   308: iload #13
    //   310: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   313: aastore
    //   314: invokestatic invokeOnTelephonyManager : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   317: checkcast java/lang/String
    //   320: astore #14
    //   322: aload #14
    //   324: astore_2
    //   325: aload #14
    //   327: invokestatic a : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   330: invokevirtual booleanValue : ()Z
    //   333: ifeq -> 352
    //   336: aload_0
    //   337: ldc 'getDeviceId'
    //   339: iconst_0
    //   340: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   343: aconst_null
    //   344: aconst_null
    //   345: invokestatic invokeOnTelephonyManager : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   348: checkcast java/lang/String
    //   351: astore_2
    //   352: aload_2
    //   353: invokestatic b : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   356: invokevirtual booleanValue : ()Z
    //   359: ifeq -> 368
    //   362: aload #11
    //   364: aload_2
    //   365: invokevirtual setIe : (Ljava/lang/String;)V
    //   368: aload_3
    //   369: aload #10
    //   371: iconst_0
    //   372: anewarray java/lang/Object
    //   375: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   378: checkcast java/lang/String
    //   381: astore_2
    //   382: aload_2
    //   383: invokestatic b : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   386: invokevirtual booleanValue : ()Z
    //   389: ifeq -> 398
    //   392: aload #11
    //   394: aload_2
    //   395: invokevirtual setIc : (Ljava/lang/String;)V
    //   398: aload #5
    //   400: aload #10
    //   402: iconst_0
    //   403: anewarray java/lang/Object
    //   406: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   409: checkcast java/lang/String
    //   412: astore_2
    //   413: aload_2
    //   414: invokestatic b : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   417: invokevirtual booleanValue : ()Z
    //   420: ifeq -> 429
    //   423: aload #11
    //   425: aload_2
    //   426: invokevirtual setM : (Ljava/lang/String;)V
    //   429: aload #7
    //   431: aload #10
    //   433: iconst_0
    //   434: anewarray java/lang/Object
    //   437: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   440: checkcast java/lang/String
    //   443: astore_2
    //   444: aload_2
    //   445: invokestatic b : (Ljava/lang/String;)Ljava/lang/Boolean;
    //   448: invokevirtual booleanValue : ()Z
    //   451: ifeq -> 460
    //   454: aload #11
    //   456: aload_2
    //   457: invokevirtual setCn : (Ljava/lang/String;)V
    //   460: iload #12
    //   462: aload_0
    //   463: ldc 'getDefaultDataSubId'
    //   465: iconst_1
    //   466: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   469: aconst_null
    //   470: aconst_null
    //   471: invokestatic invokeOnSubscriptionManager : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   474: checkcast java/lang/Integer
    //   477: invokevirtual intValue : ()I
    //   480: if_icmpne -> 489
    //   483: aload #11
    //   485: iconst_1
    //   486: invokevirtual setIdfd : (Z)V
    //   489: aload #11
    //   491: iload #13
    //   493: invokevirtual setSid : (I)V
    //   496: iload #12
    //   498: aload_0
    //   499: ldc 'getDefaultSmsSubId'
    //   501: iconst_1
    //   502: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   505: aconst_null
    //   506: aconst_null
    //   507: invokestatic invokeOnSubscriptionManager : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   510: checkcast java/lang/Integer
    //   513: invokevirtual intValue : ()I
    //   516: if_icmpne -> 525
    //   519: aload #11
    //   521: iconst_1
    //   522: invokevirtual setIdfs : (Z)V
    //   525: aload_1
    //   526: aload #11
    //   528: invokevirtual add : (Ljava/lang/Object;)Z
    //   531: pop
    //   532: iinc #9, 1
    //   535: goto -> 131
    //   538: astore_2
    //   539: iload #12
    //   541: aload_0
    //   542: ldc 'getDefaultDataSubscriptionId'
    //   544: iconst_1
    //   545: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   548: aconst_null
    //   549: aconst_null
    //   550: invokestatic invokeOnSubscriptionManager : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   553: checkcast java/lang/Integer
    //   556: invokevirtual intValue : ()I
    //   559: if_icmpne -> 489
    //   562: aload #11
    //   564: iconst_1
    //   565: invokevirtual setIdfd : (Z)V
    //   568: goto -> 489
    //   571: astore_0
    //   572: getstatic com/sdk/base/framework/utils/b/a.b : Ljava/lang/String;
    //   575: aload_0
    //   576: invokevirtual getMessage : ()Ljava/lang/String;
    //   579: getstatic com/sdk/base/framework/utils/b/a.a : Z
    //   582: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   585: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)I
    //   588: pop
    //   589: getstatic com/sdk/base/framework/utils/b/a.a : Z
    //   592: ifeq -> 595
    //   595: aload_1
    //   596: areturn
    //   597: astore_2
    //   598: iload #12
    //   600: aload_0
    //   601: ldc 'getDefaultSmsSubscriptionId'
    //   603: iconst_1
    //   604: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   607: aconst_null
    //   608: aconst_null
    //   609: invokestatic invokeOnSubscriptionManager : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   612: checkcast java/lang/Integer
    //   615: invokevirtual intValue : ()I
    //   618: if_icmpne -> 525
    //   621: aload #11
    //   623: iconst_1
    //   624: invokevirtual setIdfs : (Z)V
    //   627: goto -> 525
    // Exception table:
    //   from	to	target	type
    //   12	123	571	java/lang/Throwable
    //   131	239	571	java/lang/Throwable
    //   242	269	571	java/lang/Throwable
    //   269	285	571	java/lang/Throwable
    //   285	322	571	java/lang/Throwable
    //   325	352	571	java/lang/Throwable
    //   352	368	571	java/lang/Throwable
    //   368	398	571	java/lang/Throwable
    //   398	429	571	java/lang/Throwable
    //   429	460	571	java/lang/Throwable
    //   460	489	538	java/lang/Exception
    //   460	489	571	java/lang/Throwable
    //   489	496	571	java/lang/Throwable
    //   496	525	597	java/lang/Throwable
    //   525	532	571	java/lang/Throwable
    //   539	568	571	java/lang/Throwable
    //   598	627	571	java/lang/Throwable
  }
  
  private static ArrayList<KInfo> c(Context paramContext) {
    long l = System.currentTimeMillis();
    ArrayList<Object> arrayList = new ArrayList();
    try {
      Method method1;
      String str1;
      String str2;
      boolean bool;
      TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      Class<?> clazz = Class.forName(telephonyManager.getClass().getName());
      Method method2 = null;
      Context context = null;
      paramContext = context;
      Object object2 = method2;
      try {
        Method method4 = clazz.getDeclaredMethod("getSubscriberInfo", new Class[0]);
        paramContext = context;
        object2 = method2;
        method4.setAccessible(true);
        paramContext = context;
        object2 = method2;
        object3 = method4.invoke(telephonyManager, new Object[0]);
        paramContext = context;
        object2 = object3;
        Class<?> clazz1 = Class.forName("com.android.internal.telephony.IPhoneSubInfo");
        paramContext = context;
        object2 = object3;
        Method method3 = clazz1.getDeclaredMethod("getDeviceId", new Class[0]);
        method1 = method3;
        object2 = object3;
        method3.setAccessible(true);
        method1 = method3;
        object2 = object3;
        method2 = clazz1.getDeclaredMethod("getSubscriberId", new Class[0]);
        method1 = method3;
        object2 = object3;
        method2.setAccessible(true);
        method1 = method3;
        object2 = object3;
        Method method6 = clazz1.getDeclaredMethod("getLine1Number", new Class[0]);
        method1 = method3;
        object2 = object3;
        method6.setAccessible(true);
        method1 = method3;
        object2 = object3;
        Method method5 = clazz1.getDeclaredMethod("getIccSerialNumber", new Class[0]);
        method1 = method3;
        object2 = object3;
        method5.setAccessible(true);
        object2 = object3;
        object3 = method5;
        method1 = method6;
        method6 = method3;
        bool = true;
        object1 = object2;
        object2 = method6;
      } catch (Exception object1) {}
      if (bool) {
        object3 = object3.invoke(object1, new Object[0]);
        String str = (String)method2.invoke(object1, new Object[0]);
        str2 = (String)object2.invoke(object1, new Object[0]);
        str1 = (String)method1.invoke(object1, new Object[0]);
        object1 = str;
        object2 = object3;
      } else {
        object1 = object3.invoke(telephonyManager, new Object[0]);
        object3 = str2.invoke(telephonyManager, new Object[0]);
        str2 = (String)object2.invoke(telephonyManager, new Object[0]);
        str1 = (String)str1.invoke(telephonyManager, new Object[0]);
        object2 = object1;
        object1 = object3;
      } 
      Object object3 = new KInfo();
      super();
      object3.setIs((String)object1);
      object3.setIc((String)object2);
      object3.setIe(str2);
      object3.setM(str1);
      object3.setSid(0);
      arrayList.add(object3);
    } catch (Exception exception) {
      b.c(b, exception.getMessage(), Boolean.valueOf(a));
    } 
    if (a)
      b.a(b, "应用层获取sim卡信息耗时：" + (System.currentTimeMillis() - l), Boolean.valueOf(a)); 
    return (ArrayList)arrayList;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */