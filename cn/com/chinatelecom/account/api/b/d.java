package cn.com.chinatelecom.account.api.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import cn.com.chinatelecom.account.api.CtAuth;
import java.net.InetAddress;

public class d extends a {
  private static final String b = d.class.getSimpleName();
  
  private boolean c = false;
  
  private ConnectivityManager d = null;
  
  private ConnectivityManager.NetworkCallback e = null;
  
  private a f;
  
  private long g = 0L;
  
  private long h = 0L;
  
  public static int a(String paramString) {
    byte b;
    try {
      InetAddress inetAddress = InetAddress.getByName(paramString);
      byte[] arrayOfByte = inetAddress.getAddress();
      byte b1 = arrayOfByte[3];
      byte b2 = arrayOfByte[2];
      byte b3 = arrayOfByte[1];
      b = arrayOfByte[0] & 0xFF | (b1 & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8;
    } catch (Throwable throwable) {
      CtAuth.warn(b, "When InetAddress.getByName(),throws exception", throwable);
      b = -1;
    } 
    return b;
  }
  
  @TargetApi(21)
  private void a(Context paramContext) {
    this.g = 0L;
    this.d = (ConnectivityManager)paramContext.getSystemService("connectivity");
    this.h = System.currentTimeMillis();
    NetworkRequest.Builder builder = new NetworkRequest.Builder();
    builder.addCapability(12);
    builder.addTransportType(0);
    NetworkRequest networkRequest = builder.build();
    this.e = new ConnectivityManager.NetworkCallback(this) {
        public void onAvailable(Network param1Network) {
          long l = System.currentTimeMillis();
          d.a(this.a, l - d.d(this.a));
          d.a(this.a, true);
          if (d.b(this.a) != null)
            d.b(this.a).a(param1Network, d.e(this.a)); 
          if (d.f(this.a) != null)
            try {
              d.f(this.a).unregisterNetworkCallback(this);
              d.a(this.a, (ConnectivityManager)null);
            } catch (Throwable throwable) {
              CtAuth.warn(d.a(), "switchToMobileForAboveL", throwable);
            }  
        }
      };
    this.d.requestNetwork(networkRequest, this.e);
  }
  
  public static String b(String paramString) {
    int i = paramString.indexOf("://");
    String str1 = paramString;
    if (i > 0)
      str1 = paramString.substring(i + 3); 
    i = str1.indexOf(':');
    String str2 = str1;
    if (i >= 0)
      str2 = str1.substring(0, i); 
    i = str2.indexOf('/');
    paramString = str2;
    if (i >= 0)
      paramString = str2.substring(0, i); 
    i = paramString.indexOf('?');
    str1 = paramString;
    if (i >= 0)
      str1 = paramString.substring(0, i); 
    return str1;
  }
  
  private void b() {
    if (Build.VERSION.SDK_INT >= 21 && this.d != null && this.e != null) {
      try {
        this.d.unregisterNetworkCallback(this.e);
      } catch (Throwable throwable) {
        CtAuth.warn(b, "unregisterNetworkCallback", throwable);
      } 
      this.d = null;
    } 
  }
  
  private boolean b(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc 'android.net.ConnectivityManager'
    //   2: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_3
    //   6: aload_0
    //   7: lconst_0
    //   8: putfield g : J
    //   11: aload_0
    //   12: invokestatic currentTimeMillis : ()J
    //   15: putfield h : J
    //   18: aload_0
    //   19: aload_1
    //   20: ldc 'connectivity'
    //   22: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   25: checkcast android/net/ConnectivityManager
    //   28: putfield d : Landroid/net/ConnectivityManager;
    //   31: aload_0
    //   32: getfield d : Landroid/net/ConnectivityManager;
    //   35: iconst_5
    //   36: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   39: invokevirtual getState : ()Landroid/net/NetworkInfo$State;
    //   42: getstatic android/net/NetworkInfo$State.CONNECTED : Landroid/net/NetworkInfo$State;
    //   45: invokevirtual compareTo : (Ljava/lang/Enum;)I
    //   48: ifeq -> 129
    //   51: aload_3
    //   52: ldc 'startUsingNetworkFeature'
    //   54: iconst_2
    //   55: anewarray java/lang/Class
    //   58: dup
    //   59: iconst_0
    //   60: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc java/lang/String
    //   68: aastore
    //   69: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   72: aload_0
    //   73: getfield d : Landroid/net/ConnectivityManager;
    //   76: iconst_2
    //   77: anewarray java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: iconst_0
    //   83: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: ldc 'enableHIPRI'
    //   91: aastore
    //   92: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: iconst_0
    //   97: istore #4
    //   99: iload #4
    //   101: iconst_5
    //   102: if_icmpge -> 129
    //   105: aload_0
    //   106: getfield d : Landroid/net/ConnectivityManager;
    //   109: iconst_5
    //   110: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   113: invokevirtual getState : ()Landroid/net/NetworkInfo$State;
    //   116: getstatic android/net/NetworkInfo$State.CONNECTED : Landroid/net/NetworkInfo$State;
    //   119: invokevirtual compareTo : (Ljava/lang/Enum;)I
    //   122: istore #5
    //   124: iload #5
    //   126: ifne -> 251
    //   129: aload_2
    //   130: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   133: invokestatic a : (Ljava/lang/String;)I
    //   136: istore #4
    //   138: aload_3
    //   139: ldc 'requestRouteToHost'
    //   141: iconst_2
    //   142: anewarray java/lang/Class
    //   145: dup
    //   146: iconst_0
    //   147: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   156: aastore
    //   157: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   160: aload_0
    //   161: getfield d : Landroid/net/ConnectivityManager;
    //   164: iconst_2
    //   165: anewarray java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: iconst_5
    //   171: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: iload #4
    //   179: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   182: aastore
    //   183: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   186: checkcast java/lang/Boolean
    //   189: invokevirtual booleanValue : ()Z
    //   192: istore #6
    //   194: aload_0
    //   195: invokestatic currentTimeMillis : ()J
    //   198: aload_0
    //   199: getfield h : J
    //   202: lsub
    //   203: putfield g : J
    //   206: getstatic cn/com/chinatelecom/account/api/b/d.b : Ljava/lang/String;
    //   209: astore_2
    //   210: new java/lang/StringBuilder
    //   213: astore_1
    //   214: aload_1
    //   215: invokespecial <init> : ()V
    //   218: aload_2
    //   219: aload_1
    //   220: ldc 'Switch network result ： '
    //   222: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: iload #6
    //   227: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   230: ldc ' (4.x) , expendTime ：'
    //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_0
    //   236: getfield g : J
    //   239: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   242: invokevirtual toString : ()Ljava/lang/String;
    //   245: invokestatic info : (Ljava/lang/String;Ljava/lang/String;)V
    //   248: iload #6
    //   250: ireturn
    //   251: ldc2_w 500
    //   254: invokestatic sleep : (J)V
    //   257: iinc #4, 1
    //   260: goto -> 99
    //   263: astore_1
    //   264: getstatic cn/com/chinatelecom/account/api/b/d.b : Ljava/lang/String;
    //   267: ldc 'switchToMobileForUnderL'
    //   269: aload_1
    //   270: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   273: goto -> 129
    //   276: astore_1
    //   277: iconst_0
    //   278: istore #6
    //   280: getstatic cn/com/chinatelecom/account/api/b/d.b : Ljava/lang/String;
    //   283: ldc '4.x网络切换异常'
    //   285: aload_1
    //   286: invokestatic warn : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   289: goto -> 248
    //   292: astore_1
    //   293: goto -> 280
    // Exception table:
    //   from	to	target	type
    //   0	96	276	java/lang/Throwable
    //   105	124	263	java/lang/Throwable
    //   129	194	276	java/lang/Throwable
    //   194	248	292	java/lang/Throwable
    //   251	257	263	java/lang/Throwable
    //   264	273	276	java/lang/Throwable
  }
  
  public void a(int paramInt) {
    f.a(new Runnable(this, paramInt) {
          public void run() {
            if (this.a > 2500)
              try {
                Thread.sleep(2500L);
                if (!d.a(this.b)) {
                  if (d.b(this.b) != null)
                    d.b(this.b).a(-720002, "切换移动网络超时", 2500L); 
                  CtAuth.info(d.a(), "切换网络超时(L)");
                  d.c(this.b);
                  return;
                } 
              } catch (Throwable throwable) {
                CtAuth.warn(d.a(), "timeoutCheckRunnable exception!", throwable);
                if (!d.a(this.b)) {
                  if (d.b(this.b) != null)
                    d.b(this.b).a(-720002, "切换移动网络超时", 2500L); 
                  CtAuth.info(d.a(), "切换网络超时(L)");
                  d.c(this.b);
                  return;
                } 
              }  
            try {
              int i;
              if (this.a <= 2500) {
                i = this.a;
              } else {
                i = this.a;
                i -= 2500;
              } 
              Thread.sleep(i);
            } catch (Throwable throwable) {
              CtAuth.warn(d.a(), "timeoutCheckRunnable exception!", throwable);
            } 
            if (d.b(this.b) != null)
              d.b(this.b).a(); 
          }
        });
  }
  
  public void a(Context paramContext, a parama) {
    this.f = parama;
    try {
      a(paramContext);
    } catch (Throwable throwable) {
      CtAuth.warn(b, "switchToMobileForAboveL", throwable);
    } 
  }
  
  public boolean a(Context paramContext, String paramString) {
    return b(paramContext, paramString);
  }
  
  public static interface a {
    void a();
    
    void a(int param1Int, String param1String, long param1Long);
    
    void a(Network param1Network, long param1Long);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */