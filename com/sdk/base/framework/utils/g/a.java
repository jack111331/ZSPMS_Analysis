package com.sdk.base.framework.utils.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.f.b;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class a {
  private static final String a = a.class.getName();
  
  private static final Boolean b = Boolean.valueOf(c.h);
  
  public static b.a a(Context paramContext, ArrayList<String> paramArrayList, boolean paramBoolean) {
    b.a a1 = b.a.c;
    if (paramContext == null)
      return a1; 
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramBoolean)
        try {
          if (a(paramContext, paramArrayList)) {
            NetworkInfo.State state2 = connectivityManager.getNetworkInfo(2).getState();
            NetworkInfo.State state1 = connectivityManager.getNetworkInfo(0).getState();
            if (state2.compareTo((Enum)NetworkInfo.State.CONNECTED) == 0 || state1.compareTo((Enum)NetworkInfo.State.CONNECTED) == 0)
              return b.a.b; 
          } 
        } catch (Throwable throwable) {
          b.c(a, throwable.getMessage(), b);
        }  
      NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo != null && networkInfo.isConnected()) {
        String str = networkInfo.getTypeName();
        if ("MOBILE".equalsIgnoreCase(str))
          return b.a.b; 
        if ("WIFI".equalsIgnoreCase(str))
          return b.a.a; 
      } 
    } catch (Throwable throwable) {
      b.c(a, throwable.getMessage(), b);
    } 
    return a1;
  }
  
  private static ArrayList<Integer> a(ArrayList<String> paramArrayList) {
    byte[] arrayOfByte;
    byte b = 0;
    ArrayList<Integer> arrayList1 = null;
    URL uRL = null;
    ArrayList<Integer> arrayList2 = arrayList1;
    if (paramArrayList != null) {
      byte[] arrayOfByte1;
      arrayList2 = arrayList1;
      try {
        if (paramArrayList.size() > 0) {
          arrayList2 = new ArrayList();
          this();
          try {
            while (b < paramArrayList.size()) {
              uRL = new URL();
              this(paramArrayList.get(b));
              arrayOfByte1 = InetAddress.getByName(uRL.getHost()).getAddress();
              byte b1 = arrayOfByte1[3];
              byte b2 = arrayOfByte1[2];
              byte b3 = arrayOfByte1[1];
              arrayList2.add(Integer.valueOf(arrayOfByte1[0] & 0xFF | (b1 & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8));
              b++;
            } 
            return arrayList2;
          } catch (Throwable null) {}
        } else {
          return arrayList2;
        } 
      } catch (Throwable throwable) {
        arrayOfByte = arrayOfByte1;
      } 
      b.c(a, throwable.getMessage(), b);
    } 
    return (ArrayList<Integer>)arrayOfByte;
  }
  
  public static void a(Context paramContext) {
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (Build.VERSION.SDK_INT < 21) {
        NetworkInfo.State state = connectivityManager.getNetworkInfo(2).getState();
        if (state.compareTo((Enum)NetworkInfo.State.CONNECTED) == 0 || state.compareTo((Enum)NetworkInfo.State.CONNECTING) == 0)
          connectivityManager.stopUsingNetworkFeature(0, "enableMMS"); 
      } 
    } catch (Throwable throwable) {}
  }
  
  private static boolean a(Context paramContext, ArrayList<String> paramArrayList) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: istore_3
    //   4: aload_1
    //   5: ifnull -> 18
    //   8: aload_1
    //   9: invokevirtual size : ()I
    //   12: iconst_1
    //   13: if_icmpge -> 20
    //   16: iload_2
    //   17: istore_3
    //   18: iload_3
    //   19: ireturn
    //   20: aload_0
    //   21: ldc 'connectivity'
    //   23: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   26: checkcast android/net/ConnectivityManager
    //   29: astore #4
    //   31: aload #4
    //   33: ifnonnull -> 106
    //   36: getstatic com/sdk/base/framework/utils/g/a.a : Ljava/lang/String;
    //   39: ldc 'ConnectivityManager 为null'
    //   41: getstatic com/sdk/base/framework/utils/g/a.b : Ljava/lang/Boolean;
    //   44: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)I
    //   47: pop
    //   48: iload_2
    //   49: istore_3
    //   50: goto -> 18
    //   53: astore #4
    //   55: iconst_0
    //   56: istore_3
    //   57: getstatic com/sdk/base/framework/utils/g/a.a : Ljava/lang/String;
    //   60: aload #4
    //   62: invokevirtual getMessage : ()Ljava/lang/String;
    //   65: getstatic com/sdk/base/framework/utils/g/a.b : Ljava/lang/Boolean;
    //   68: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)I
    //   71: pop
    //   72: getstatic com/sdk/base/framework/c/c.l : Z
    //   75: ifeq -> 303
    //   78: aload_1
    //   79: ifnull -> 319
    //   82: aload_1
    //   83: invokevirtual size : ()I
    //   86: ifne -> 287
    //   89: iconst_0
    //   90: istore #5
    //   92: iload #5
    //   94: ifne -> 303
    //   97: aload_0
    //   98: invokestatic a : (Landroid/content/Context;)V
    //   101: iload_2
    //   102: istore_3
    //   103: goto -> 18
    //   106: aload #4
    //   108: iconst_0
    //   109: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   112: invokevirtual getState : ()Landroid/net/NetworkInfo$State;
    //   115: astore #6
    //   117: aload #6
    //   119: getstatic android/net/NetworkInfo$State.CONNECTED : Landroid/net/NetworkInfo$State;
    //   122: invokevirtual compareTo : (Ljava/lang/Enum;)I
    //   125: ifeq -> 139
    //   128: aload #6
    //   130: getstatic android/net/NetworkInfo$State.CONNECTING : Landroid/net/NetworkInfo$State;
    //   133: invokevirtual compareTo : (Ljava/lang/Enum;)I
    //   136: ifne -> 144
    //   139: iconst_1
    //   140: istore_3
    //   141: goto -> 18
    //   144: aload #4
    //   146: iconst_0
    //   147: ldc 'enableMMS'
    //   149: invokevirtual startUsingNetworkFeature : (ILjava/lang/String;)I
    //   152: pop
    //   153: aload_1
    //   154: invokestatic a : (Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   157: astore #7
    //   159: iconst_0
    //   160: istore #8
    //   162: iload #8
    //   164: iconst_5
    //   165: if_icmpge -> 190
    //   168: aload #4
    //   170: iconst_2
    //   171: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   174: invokevirtual getState : ()Landroid/net/NetworkInfo$State;
    //   177: getstatic android/net/NetworkInfo$State.CONNECTED : Landroid/net/NetworkInfo$State;
    //   180: invokevirtual compareTo : (Ljava/lang/Enum;)I
    //   183: istore #9
    //   185: iload #9
    //   187: ifne -> 252
    //   190: aload #7
    //   192: ifnull -> 325
    //   195: aload #7
    //   197: invokevirtual size : ()I
    //   200: istore #8
    //   202: iload #8
    //   204: ifle -> 325
    //   207: iconst_0
    //   208: istore #8
    //   210: iconst_0
    //   211: istore_3
    //   212: iload #8
    //   214: aload #7
    //   216: invokevirtual size : ()I
    //   219: if_icmpge -> 284
    //   222: aload #4
    //   224: iconst_2
    //   225: aload #7
    //   227: iload #8
    //   229: invokevirtual get : (I)Ljava/lang/Object;
    //   232: checkcast java/lang/Integer
    //   235: invokevirtual intValue : ()I
    //   238: invokevirtual requestRouteToHost : (II)Z
    //   241: istore #5
    //   243: iload #5
    //   245: istore_3
    //   246: iinc #8, 1
    //   249: goto -> 212
    //   252: ldc2_w 500
    //   255: invokestatic sleep : (J)V
    //   258: iinc #8, 1
    //   261: goto -> 162
    //   264: astore #6
    //   266: getstatic com/sdk/base/framework/utils/g/a.a : Ljava/lang/String;
    //   269: aload #6
    //   271: invokevirtual getMessage : ()Ljava/lang/String;
    //   274: getstatic com/sdk/base/framework/utils/g/a.b : Ljava/lang/Boolean;
    //   277: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)I
    //   280: pop
    //   281: goto -> 190
    //   284: goto -> 72
    //   287: aload_1
    //   288: iconst_0
    //   289: invokevirtual get : (I)Ljava/lang/Object;
    //   292: checkcast java/lang/String
    //   295: invokestatic a : (Ljava/lang/String;)Z
    //   298: istore #5
    //   300: goto -> 92
    //   303: iload_3
    //   304: ifne -> 311
    //   307: aload_0
    //   308: invokestatic a : (Landroid/content/Context;)V
    //   311: goto -> 18
    //   314: astore #4
    //   316: goto -> 57
    //   319: iconst_0
    //   320: istore #5
    //   322: goto -> 92
    //   325: iconst_0
    //   326: istore_3
    //   327: goto -> 284
    // Exception table:
    //   from	to	target	type
    //   20	31	53	java/lang/Throwable
    //   36	48	53	java/lang/Throwable
    //   106	139	53	java/lang/Throwable
    //   144	159	53	java/lang/Throwable
    //   168	185	264	java/lang/Throwable
    //   195	202	53	java/lang/Throwable
    //   212	243	314	java/lang/Throwable
    //   252	258	264	java/lang/Throwable
    //   266	281	53	java/lang/Throwable
  }
  
  private static boolean a(String paramString) {
    boolean bool = false;
    try {
      String str = b(paramString);
      paramString = str;
    } catch (MalformedURLException malformedURLException) {}
    long l = System.currentTimeMillis();
    try {
      Runtime runtime = Runtime.getRuntime();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      int i = runtime.exec(stringBuilder.append("ping -c 3 -w 100 ").append(paramString).toString()).waitFor();
      long l1 = System.currentTimeMillis();
      if (b.booleanValue()) {
        String str = a;
        stringBuilder = new StringBuilder();
        this();
        b.a(str, stringBuilder.append("ping的时间间隔：").append(l1 - l).append(";地址=").append(paramString).append(";status=").append(i).toString(), b);
      } 
      if (i == 0)
        bool = true; 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } 
    return bool;
  }
  
  private static String b(String paramString) {
    return (new URL(paramString)).getHost();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framewor\\utils\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */