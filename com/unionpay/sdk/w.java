package com.unionpay.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class w {
  static volatile boolean a = false;
  
  static volatile boolean b = false;
  
  static boolean c;
  
  static at d;
  
  private static boolean e = false;
  
  private static final HandlerThread f;
  
  private static Handler g;
  
  static {
    c = false;
    f = new HandlerThread("PauseEventThread");
    g = null;
    f.start();
    g = new x(f.getLooper());
  }
  
  static String a(Context paramContext) {
    if (paramContext != null && !a)
      a(paramContext, ab.a(paramContext), ab.getPartnerId(paramContext)); 
    return d.a(paramContext);
  }
  
  private static String a(Bundle paramBundle, String paramString) {
    Iterator<String> iterator;
    if (paramBundle != null) {
      iterator = paramBundle.keySet().iterator();
      while (iterator.hasNext()) {
        if (((String)iterator.next()).equalsIgnoreCase(paramString))
          return String.valueOf(paramBundle.get(paramString)); 
      } 
    } 
    paramBundle = null;
    while (iterator.hasNext()) {
      if (((String)iterator.next()).equalsIgnoreCase(paramString))
        return String.valueOf(paramBundle.get(paramString)); 
    } 
  }
  
  static void a(Activity paramActivity) {
    a(paramActivity, paramActivity.getLocalClassName(), true);
  }
  
  static void a(Activity paramActivity, String paramString1, String paramString2) {
    if (!a)
      a((Context)paramActivity, paramString1, paramString2); 
    a(paramActivity, paramActivity.getLocalClassName(), false);
  }
  
  static void a(Activity paramActivity, String paramString, boolean paramBoolean) {
    if (!a)
      a((Context)paramActivity, (String)null, (String)null); 
    if (az.g() != null && az.g().equals("2"))
      e(); 
    az.b("0");
    g.removeMessages(0);
    if (paramActivity != null && (paramActivity.getChangingConfigurations() & 0x80) == 128) {
      ay.a("Ignore page changing during screen switch");
      e = true;
      return;
    } 
    k.execute(new aa(paramString, paramBoolean, paramActivity));
  }
  
  static void a(Context paramContext, String paramString) {
    if (e) {
      e = false;
      return;
    } 
    ay.a("onPageStart being called! pageName: " + paramString);
    String str = paramString;
    if (k.b(paramString)) {
      str = paramString;
      if (paramContext instanceof Activity)
        str = ((Activity)paramContext).getLocalClassName(); 
    } 
    a(paramContext, str, 6);
  }
  
  private static void a(Context paramContext, String paramString, int paramInt) {
    if (paramContext != null && !a)
      a(paramContext, (String)null, (String)null); 
    k.execute(new ad(paramInt, paramString));
  }
  
  static void a(Context paramContext, String paramString1, String paramString2) {
    if (paramContext == null) {
      ay.a("Init failed Context is null");
      return;
    } 
    System.currentTimeMillis();
    ab.mContext = paramContext.getApplicationContext();
    k.c = "UPLog";
    if (!a) {
      String str;
      try {
        Bundle bundle = (paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128)).metaData;
        String str1 = a(bundle, "UP_APP_ID");
        String str2 = a(bundle, "UP_CHANNEL_ID");
        str = paramString1;
        if (!k.b(str1))
          str = str1; 
        if (!k.b(str2)) {
          paramString1 = str2;
        } else {
          paramString1 = paramString2;
        } 
        paramString2 = k.a(paramContext, "ChannelConfig.json");
        if (!k.b(paramString2))
          paramString1 = paramString2; 
        if (k.b(paramString1))
          paramString1 = "Default"; 
        if (k.b(str)) {
          ay.b("[SDKInit] TD AppId is null");
          return;
        } 
      } catch (Throwable throwable) {
        ay.a("[SDKInit] Failed to initialize!", throwable);
        return;
      } 
      if (!k.b((Context)throwable, "android.permission.INTERNET")) {
        ay.b("[SDKInit] Permission \"android.permission.INTERNET\" is needed.");
        return;
      } 
      ab.a(str, paramString1);
      try {
        boolean bool = k.a(14);
        if (bool) {
          throwable = null;
          try {
            Application application;
            if (ab.mContext instanceof Activity) {
              application = ((Activity)ab.mContext).getApplication();
            } else if (ab.mContext instanceof Application) {
              application = (Application)ab.mContext;
            } 
            if (application != null && !c) {
              Class<?> clazz = Class.forName("android.app.Application$ActivityLifecycleCallbacks");
              Method method = application.getClass().getMethod("registerActivityLifecycleCallbacks", new Class[] { clazz });
              at at1 = new at();
              this();
              d = at1;
              method.invoke(application, new Object[] { d });
              c = true;
            } 
          } catch (Throwable throwable1) {}
        } else {
          af af = new af();
          this((Context)throwable1);
          try {
            k.a(Class.forName("android.app.ActivityManagerNative"), af, "gDefault", "android.app.IActivityManager");
            c = true;
          } catch (Throwable throwable2) {}
        } 
        y y = new y();
        this();
        k.execute(y);
        a = true;
        StringBuilder stringBuilder = new StringBuilder();
        this("Analytics SDK Initializing...\n\tSDK_VERSION is: Android+UP+V2.2.33 gp\n\tApp ID is: ");
        ay.a(stringBuilder.append(ab.i).append("\n\tApp Channel is: ").append(ab.j).append("\n\tSDK_OVC is: TDOVC+002f025db9206d4e7824a3846d0b93cc+UnionPayChaJian").toString());
      } catch (Throwable throwable1) {
        ay.a("[SDKInit] Failed to initialize!", throwable1);
      } 
      return;
    } 
    u.a();
    s.a();
    e();
  }
  
  static void a(Context paramContext, String paramString1, String paramString2, Map paramMap) {
    k.execute(new z(paramString1, paramString2, paramMap, paramContext));
  }
  
  static void a(Context paramContext, Throwable paramThrowable) {
    k.execute(new ae(paramThrowable, paramContext));
  }
  
  static void a(String paramString, long paramLong) {
    if (ab.mContext != null)
      h.a(ab.mContext, "UPpref_longtime", "UPadditionalVersionName", paramString); 
    if (ab.mContext != null)
      h.a(ab.mContext, "UPpref_longtime", "UPadditionalVersionCode", paramLong); 
  }
  
  static void a(String paramString, boolean paramBoolean) {
    az.b("1");
    g.removeMessages(0);
    g.sendEmptyMessageDelayed(0, ab.l);
    k.execute(new ac(paramString, paramBoolean));
  }
  
  static void b(Activity paramActivity) {
    a(paramActivity.getLocalClassName(), true);
  }
  
  static void b(Context paramContext, String paramString) {
    ay.a("onPageEnd being called! pageName: " + paramString);
    String str = paramString;
    if (paramContext instanceof Activity) {
      Activity activity = (Activity)paramContext;
      str = paramString;
      if (k.b(paramString))
        str = activity.getLocalClassName(); 
      if ((activity.getChangingConfigurations() & 0x80) == 128) {
        e = true;
        return;
      } 
    } 
    a(paramContext, str, 7);
  }
  
  private static void e() {
    a a = new a();
    a.a.put("apiType", Integer.valueOf(1));
    a.a.put("controller", u.a());
    Message message = Message.obtain();
    message.what = 102;
    message.obj = a;
    aw.a().sendMessageDelayed(message, 100L);
  }
  
  private static FileChannel f() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: new java/io/File
    //   5: astore_1
    //   6: aload_1
    //   7: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   10: invokevirtual getFilesDir : ()Ljava/io/File;
    //   13: ldc_w 'td.lock'
    //   16: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   19: aload_1
    //   20: invokevirtual exists : ()Z
    //   23: ifne -> 37
    //   26: aload_1
    //   27: invokevirtual createNewFile : ()Z
    //   30: ifne -> 37
    //   33: aload_0
    //   34: astore_2
    //   35: aload_2
    //   36: areturn
    //   37: new java/io/RandomAccessFile
    //   40: astore_2
    //   41: aload_2
    //   42: aload_1
    //   43: ldc_w 'rw'
    //   46: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   49: aload_2
    //   50: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
    //   53: astore_1
    //   54: aload_1
    //   55: astore_2
    //   56: goto -> 35
    //   59: astore_1
    //   60: aconst_null
    //   61: astore_2
    //   62: aload_2
    //   63: ifnull -> 70
    //   66: aload_2
    //   67: invokevirtual close : ()V
    //   70: aload_0
    //   71: astore_2
    //   72: getstatic com/unionpay/sdk/UPAgent.LOG_ON : Z
    //   75: ifeq -> 35
    //   78: aload_1
    //   79: invokevirtual printStackTrace : ()V
    //   82: aload_0
    //   83: astore_2
    //   84: goto -> 35
    //   87: astore_2
    //   88: getstatic com/unionpay/sdk/UPAgent.LOG_ON : Z
    //   91: ifeq -> 70
    //   94: aload_2
    //   95: invokevirtual printStackTrace : ()V
    //   98: goto -> 70
    //   101: astore_1
    //   102: goto -> 62
    // Exception table:
    //   from	to	target	type
    //   2	33	59	java/lang/Throwable
    //   37	49	59	java/lang/Throwable
    //   49	54	101	java/lang/Throwable
    //   66	70	87	java/lang/Exception
  }
  
  static final class a {
    HashMap a = new HashMap<Object, Object>();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */