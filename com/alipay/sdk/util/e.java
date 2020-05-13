package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;

public class e {
  public static final String b = "failed";
  
  public Activity a;
  
  private IAlixPay c;
  
  private final Object d = IAlixPay.class;
  
  private boolean e;
  
  private a f;
  
  private ServiceConnection g = new f(this);
  
  private IRemoteServiceCallback h = (IRemoteServiceCallback)new g(this);
  
  public e(Activity paramActivity, a parama) {
    this.a = paramActivity;
    this.f = parama;
  }
  
  private void a() {
    this.a = null;
  }
  
  private void a(l.a parama) throws InterruptedException {
    if (parama != null && parama.b > 78) {
      String str = l.a();
      Intent intent = new Intent();
      intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
      this.a.startActivity(intent);
      Thread.sleep(200L);
    } 
  }
  
  private String b(String paramString) {
    // Byte code:
    //   0: new android/content/Intent
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: invokestatic a : ()Ljava/lang/String;
    //   11: astore_3
    //   12: aload_2
    //   13: aload_3
    //   14: invokevirtual setPackage : (Ljava/lang/String;)Landroid/content/Intent;
    //   17: pop
    //   18: aload_2
    //   19: new java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: aload_3
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc '.IAlixPay'
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: invokevirtual setAction : (Ljava/lang/String;)Landroid/content/Intent;
    //   41: pop
    //   42: aload_0
    //   43: getfield a : Landroid/app/Activity;
    //   46: invokestatic h : (Landroid/content/Context;)Ljava/lang/String;
    //   49: astore_3
    //   50: aload_0
    //   51: getfield a : Landroid/app/Activity;
    //   54: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   57: aload_2
    //   58: aload_0
    //   59: getfield g : Landroid/content/ServiceConnection;
    //   62: iconst_1
    //   63: invokevirtual bindService : (Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   66: ifne -> 95
    //   69: new java/lang/Throwable
    //   72: astore_1
    //   73: aload_1
    //   74: ldc 'bindService fail'
    //   76: invokespecial <init> : (Ljava/lang/String;)V
    //   79: aload_1
    //   80: athrow
    //   81: astore_1
    //   82: ldc 'biz'
    //   84: ldc 'ClientBindServiceFailed'
    //   86: aload_1
    //   87: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: ldc 'failed'
    //   92: astore_1
    //   93: aload_1
    //   94: areturn
    //   95: aload_0
    //   96: getfield d : Ljava/lang/Object;
    //   99: astore_2
    //   100: aload_2
    //   101: monitorenter
    //   102: aload_0
    //   103: getfield c : Lcom/alipay/android/app/IAlixPay;
    //   106: astore #4
    //   108: aload #4
    //   110: ifnonnull -> 127
    //   113: aload_0
    //   114: getfield d : Ljava/lang/Object;
    //   117: invokestatic b : ()Lcom/alipay/sdk/data/a;
    //   120: invokevirtual a : ()I
    //   123: i2l
    //   124: invokevirtual wait : (J)V
    //   127: aload_2
    //   128: monitorexit
    //   129: aload_0
    //   130: getfield c : Lcom/alipay/android/app/IAlixPay;
    //   133: ifnonnull -> 301
    //   136: aload_0
    //   137: getfield a : Landroid/app/Activity;
    //   140: invokestatic h : (Landroid/content/Context;)Ljava/lang/String;
    //   143: astore_1
    //   144: aload_0
    //   145: getfield a : Landroid/app/Activity;
    //   148: invokestatic i : (Landroid/content/Context;)Ljava/lang/String;
    //   151: astore_2
    //   152: new java/lang/StringBuilder
    //   155: astore #4
    //   157: aload #4
    //   159: invokespecial <init> : ()V
    //   162: ldc 'biz'
    //   164: ldc 'ClientBindFailed'
    //   166: aload #4
    //   168: aload_3
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc '|'
    //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc '|'
    //   183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_2
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual toString : ()Ljava/lang/String;
    //   193: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   196: ldc 'failed'
    //   198: astore_3
    //   199: aload_0
    //   200: getfield c : Lcom/alipay/android/app/IAlixPay;
    //   203: aload_0
    //   204: getfield h : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   207: invokeinterface unregisterCallback : (Lcom/alipay/android/app/IRemoteServiceCallback;)V
    //   212: aload_0
    //   213: getfield a : Landroid/app/Activity;
    //   216: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   219: aload_0
    //   220: getfield g : Landroid/content/ServiceConnection;
    //   223: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield f : Lcom/alipay/sdk/util/e$a;
    //   231: aload_0
    //   232: aconst_null
    //   233: putfield h : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   236: aload_0
    //   237: aconst_null
    //   238: putfield g : Landroid/content/ServiceConnection;
    //   241: aload_0
    //   242: aconst_null
    //   243: putfield c : Lcom/alipay/android/app/IAlixPay;
    //   246: aload_3
    //   247: astore_1
    //   248: aload_0
    //   249: getfield e : Z
    //   252: ifeq -> 93
    //   255: aload_3
    //   256: astore_1
    //   257: aload_0
    //   258: getfield a : Landroid/app/Activity;
    //   261: ifnull -> 93
    //   264: aload_0
    //   265: getfield a : Landroid/app/Activity;
    //   268: iconst_0
    //   269: invokevirtual setRequestedOrientation : (I)V
    //   272: aload_0
    //   273: iconst_0
    //   274: putfield e : Z
    //   277: aload_3
    //   278: astore_1
    //   279: goto -> 93
    //   282: astore #4
    //   284: ldc 'biz'
    //   286: ldc 'BindWaitTimeoutEx'
    //   288: aload #4
    //   290: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   293: goto -> 127
    //   296: astore_1
    //   297: aload_2
    //   298: monitorexit
    //   299: aload_1
    //   300: athrow
    //   301: aload_0
    //   302: getfield f : Lcom/alipay/sdk/util/e$a;
    //   305: ifnull -> 317
    //   308: aload_0
    //   309: getfield f : Lcom/alipay/sdk/util/e$a;
    //   312: invokeinterface a : ()V
    //   317: aload_0
    //   318: getfield a : Landroid/app/Activity;
    //   321: invokevirtual getRequestedOrientation : ()I
    //   324: ifne -> 340
    //   327: aload_0
    //   328: getfield a : Landroid/app/Activity;
    //   331: iconst_1
    //   332: invokevirtual setRequestedOrientation : (I)V
    //   335: aload_0
    //   336: iconst_1
    //   337: putfield e : Z
    //   340: aload_0
    //   341: getfield c : Lcom/alipay/android/app/IAlixPay;
    //   344: aload_0
    //   345: getfield h : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   348: invokeinterface registerCallback : (Lcom/alipay/android/app/IRemoteServiceCallback;)V
    //   353: aload_0
    //   354: getfield c : Lcom/alipay/android/app/IAlixPay;
    //   357: aload_1
    //   358: invokeinterface Pay : (Ljava/lang/String;)Ljava/lang/String;
    //   363: astore_3
    //   364: aload_0
    //   365: getfield c : Lcom/alipay/android/app/IAlixPay;
    //   368: aload_0
    //   369: getfield h : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   372: invokeinterface unregisterCallback : (Lcom/alipay/android/app/IRemoteServiceCallback;)V
    //   377: aload_0
    //   378: getfield a : Landroid/app/Activity;
    //   381: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   384: aload_0
    //   385: getfield g : Landroid/content/ServiceConnection;
    //   388: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   391: aload_0
    //   392: aconst_null
    //   393: putfield f : Lcom/alipay/sdk/util/e$a;
    //   396: aload_0
    //   397: aconst_null
    //   398: putfield h : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   401: aload_0
    //   402: aconst_null
    //   403: putfield g : Landroid/content/ServiceConnection;
    //   406: aload_0
    //   407: aconst_null
    //   408: putfield c : Lcom/alipay/android/app/IAlixPay;
    //   411: aload_3
    //   412: astore_1
    //   413: aload_0
    //   414: getfield e : Z
    //   417: ifeq -> 93
    //   420: aload_3
    //   421: astore_1
    //   422: aload_0
    //   423: getfield a : Landroid/app/Activity;
    //   426: ifnull -> 93
    //   429: aload_0
    //   430: getfield a : Landroid/app/Activity;
    //   433: iconst_0
    //   434: invokevirtual setRequestedOrientation : (I)V
    //   437: aload_0
    //   438: iconst_0
    //   439: putfield e : Z
    //   442: aload_3
    //   443: astore_1
    //   444: goto -> 93
    //   447: astore_1
    //   448: ldc 'biz'
    //   450: ldc 'ClientBindException'
    //   452: aload_1
    //   453: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   456: invokestatic a : ()Ljava/lang/String;
    //   459: astore_3
    //   460: aload_0
    //   461: getfield c : Lcom/alipay/android/app/IAlixPay;
    //   464: aload_0
    //   465: getfield h : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   468: invokeinterface unregisterCallback : (Lcom/alipay/android/app/IRemoteServiceCallback;)V
    //   473: aload_0
    //   474: getfield a : Landroid/app/Activity;
    //   477: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   480: aload_0
    //   481: getfield g : Landroid/content/ServiceConnection;
    //   484: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   487: aload_0
    //   488: aconst_null
    //   489: putfield f : Lcom/alipay/sdk/util/e$a;
    //   492: aload_0
    //   493: aconst_null
    //   494: putfield h : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   497: aload_0
    //   498: aconst_null
    //   499: putfield g : Landroid/content/ServiceConnection;
    //   502: aload_0
    //   503: aconst_null
    //   504: putfield c : Lcom/alipay/android/app/IAlixPay;
    //   507: aload_3
    //   508: astore_1
    //   509: aload_0
    //   510: getfield e : Z
    //   513: ifeq -> 93
    //   516: aload_3
    //   517: astore_1
    //   518: aload_0
    //   519: getfield a : Landroid/app/Activity;
    //   522: ifnull -> 93
    //   525: aload_0
    //   526: getfield a : Landroid/app/Activity;
    //   529: iconst_0
    //   530: invokevirtual setRequestedOrientation : (I)V
    //   533: aload_0
    //   534: iconst_0
    //   535: putfield e : Z
    //   538: aload_3
    //   539: astore_1
    //   540: goto -> 93
    //   543: astore_1
    //   544: aload_0
    //   545: getfield c : Lcom/alipay/android/app/IAlixPay;
    //   548: aload_0
    //   549: getfield h : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   552: invokeinterface unregisterCallback : (Lcom/alipay/android/app/IRemoteServiceCallback;)V
    //   557: aload_0
    //   558: getfield a : Landroid/app/Activity;
    //   561: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   564: aload_0
    //   565: getfield g : Landroid/content/ServiceConnection;
    //   568: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   571: aload_0
    //   572: aconst_null
    //   573: putfield f : Lcom/alipay/sdk/util/e$a;
    //   576: aload_0
    //   577: aconst_null
    //   578: putfield h : Lcom/alipay/android/app/IRemoteServiceCallback;
    //   581: aload_0
    //   582: aconst_null
    //   583: putfield g : Landroid/content/ServiceConnection;
    //   586: aload_0
    //   587: aconst_null
    //   588: putfield c : Lcom/alipay/android/app/IAlixPay;
    //   591: aload_0
    //   592: getfield e : Z
    //   595: ifeq -> 618
    //   598: aload_0
    //   599: getfield a : Landroid/app/Activity;
    //   602: ifnull -> 618
    //   605: aload_0
    //   606: getfield a : Landroid/app/Activity;
    //   609: iconst_0
    //   610: invokevirtual setRequestedOrientation : (I)V
    //   613: aload_0
    //   614: iconst_0
    //   615: putfield e : Z
    //   618: aload_1
    //   619: athrow
    //   620: astore_3
    //   621: goto -> 571
    //   624: astore_3
    //   625: goto -> 557
    //   628: astore_1
    //   629: goto -> 487
    //   632: astore_1
    //   633: goto -> 473
    //   636: astore_1
    //   637: goto -> 391
    //   640: astore_1
    //   641: goto -> 377
    //   644: astore_1
    //   645: goto -> 226
    //   648: astore_1
    //   649: goto -> 212
    // Exception table:
    //   from	to	target	type
    //   50	81	81	java/lang/Throwable
    //   102	108	296	finally
    //   113	127	282	java/lang/InterruptedException
    //   113	127	296	finally
    //   127	129	296	finally
    //   129	196	447	java/lang/Throwable
    //   129	196	543	finally
    //   199	212	648	java/lang/Throwable
    //   212	226	644	java/lang/Throwable
    //   284	293	296	finally
    //   297	299	296	finally
    //   301	317	447	java/lang/Throwable
    //   301	317	543	finally
    //   317	340	447	java/lang/Throwable
    //   317	340	543	finally
    //   340	364	447	java/lang/Throwable
    //   340	364	543	finally
    //   364	377	640	java/lang/Throwable
    //   377	391	636	java/lang/Throwable
    //   448	460	543	finally
    //   460	473	632	java/lang/Throwable
    //   473	487	628	java/lang/Throwable
    //   544	557	624	java/lang/Throwable
    //   557	571	620	java/lang/Throwable
  }
  
  public final String a(String paramString) {
    try {
      l.a a1 = l.a((Context)this.a);
      if (a1.a())
        return "failed"; 
      if (a1 != null) {
        int i = a1.b;
        if (i > 78) {
          String str = l.a();
          Intent intent = new Intent();
          this();
          intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
          this.a.startActivity(intent);
          Thread.sleep(200L);
        } 
      } 
    } catch (Throwable throwable) {
      com.alipay.sdk.app.statistic.a.a("biz", "CheckClientSignEx", throwable);
    } 
    return b(paramString);
  }
  
  public static interface a {
    void a();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */