package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.data.c;
import com.alipay.sdk.protocol.b;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.l;
import com.alipay.sdk.widget.a;
import java.util.Map;

public class AuthTask {
  static final Object a = e.class;
  
  private static final int b = 73;
  
  private Activity c;
  
  private a d;
  
  public AuthTask(Activity paramActivity) {
    this.c = paramActivity;
    b b = b.a();
    Activity activity = this.c;
    c.a();
    b.a((Context)activity);
    a.a((Context)paramActivity);
    this.d = new a(paramActivity, "去支付宝授权");
  }
  
  private e.a a() {
    return new a(this);
  }
  
  private String a(Activity paramActivity, String paramString) {
    String str = (new a((Context)this.c)).a(paramString);
    if (a((Context)paramActivity)) {
      paramString = (new e(paramActivity, new a(this))).a(str);
      if (TextUtils.equals(paramString, "failed"))
        return b(paramActivity, str); 
      null = paramString;
      if (TextUtils.isEmpty(paramString))
        null = i.a(); 
      return null;
    } 
    return b((Activity)null, str);
  }
  
  private String a(b paramb) {
    String[] arrayOfString = paramb.b;
    null = new Bundle();
    null.putString("url", arrayOfString[0]);
    Intent intent = new Intent((Context)this.c, H5AuthActivity.class);
    intent.putExtras(null);
    this.c.startActivity(intent);
    synchronized (a) {
      a.wait();
      null = i.a;
      Object object = null;
      if (TextUtils.isEmpty((CharSequence)null))
        object = i.a(); 
      return (String)object;
    } 
  }
  
  private static boolean a(Context paramContext) {
    boolean bool = false;
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(l.a(), 128);
      if (packageInfo != null) {
        int i = packageInfo.versionCode;
        if (i >= 73)
          bool = true; 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {}
    return bool;
  }
  
  private String b(Activity paramActivity, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial b : ()V
    //   4: new com/alipay/sdk/packet/impl/a
    //   7: astore_3
    //   8: aload_3
    //   9: invokespecial <init> : ()V
    //   12: aload_3
    //   13: aload_1
    //   14: aload_2
    //   15: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Lcom/alipay/sdk/packet/b;
    //   18: invokevirtual a : ()Lorg/json/JSONObject;
    //   21: ldc 'form'
    //   23: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   26: ldc 'onload'
    //   28: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   31: invokestatic a : (Lorg/json/JSONObject;)Ljava/util/List;
    //   34: astore_1
    //   35: aload_0
    //   36: invokespecial c : ()V
    //   39: iconst_0
    //   40: istore #4
    //   42: iload #4
    //   44: aload_1
    //   45: invokeinterface size : ()I
    //   50: if_icmpge -> 101
    //   53: aload_1
    //   54: iload #4
    //   56: invokeinterface get : (I)Ljava/lang/Object;
    //   61: checkcast com/alipay/sdk/protocol/b
    //   64: getfield a : Lcom/alipay/sdk/protocol/a;
    //   67: getstatic com/alipay/sdk/protocol/a.b : Lcom/alipay/sdk/protocol/a;
    //   70: if_acmpne -> 95
    //   73: aload_0
    //   74: aload_1
    //   75: iload #4
    //   77: invokeinterface get : (I)Ljava/lang/Object;
    //   82: checkcast com/alipay/sdk/protocol/b
    //   85: invokespecial a : (Lcom/alipay/sdk/protocol/b;)Ljava/lang/String;
    //   88: astore_1
    //   89: aload_0
    //   90: invokespecial c : ()V
    //   93: aload_1
    //   94: areturn
    //   95: iinc #4, 1
    //   98: goto -> 42
    //   101: aload_0
    //   102: invokespecial c : ()V
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_2
    //   109: aload_1
    //   110: ifnonnull -> 123
    //   113: getstatic com/alipay/sdk/app/j.b : Lcom/alipay/sdk/app/j;
    //   116: getfield h : I
    //   119: invokestatic a : (I)Lcom/alipay/sdk/app/j;
    //   122: astore_2
    //   123: aload_2
    //   124: getfield h : I
    //   127: aload_2
    //   128: getfield i : Ljava/lang/String;
    //   131: ldc ''
    //   133: invokestatic a : (ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_1
    //   137: goto -> 93
    //   140: astore_2
    //   141: getstatic com/alipay/sdk/app/j.d : Lcom/alipay/sdk/app/j;
    //   144: getfield h : I
    //   147: invokestatic a : (I)Lcom/alipay/sdk/app/j;
    //   150: astore_1
    //   151: ldc 'net'
    //   153: aload_2
    //   154: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   157: aload_0
    //   158: invokespecial c : ()V
    //   161: goto -> 107
    //   164: astore_1
    //   165: ldc 'biz'
    //   167: ldc 'H5AuthDataAnalysisError'
    //   169: aload_1
    //   170: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload_0
    //   174: invokespecial c : ()V
    //   177: aconst_null
    //   178: astore_1
    //   179: goto -> 107
    //   182: astore_1
    //   183: aload_0
    //   184: invokespecial c : ()V
    //   187: aload_1
    //   188: athrow
    // Exception table:
    //   from	to	target	type
    //   4	39	140	java/io/IOException
    //   4	39	164	java/lang/Throwable
    //   4	39	182	finally
    //   42	89	140	java/io/IOException
    //   42	89	164	java/lang/Throwable
    //   42	89	182	finally
    //   141	157	182	finally
    //   165	173	182	finally
  }
  
  private void b() {
    if (this.d != null)
      this.d.a(); 
  }
  
  private void c() {
    if (this.d != null)
      this.d.b(); 
  }
  
  public String auth(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: ifeq -> 10
    //   6: aload_0
    //   7: invokespecial b : ()V
    //   10: invokestatic a : ()Lcom/alipay/sdk/sys/b;
    //   13: astore_3
    //   14: aload_0
    //   15: getfield c : Landroid/app/Activity;
    //   18: astore #4
    //   20: invokestatic a : ()Lcom/alipay/sdk/data/c;
    //   23: pop
    //   24: aload_3
    //   25: aload #4
    //   27: invokevirtual a : (Landroid/content/Context;)V
    //   30: invokestatic a : ()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_0
    //   35: getfield c : Landroid/app/Activity;
    //   38: astore #4
    //   40: new com/alipay/sdk/sys/a
    //   43: astore #5
    //   45: aload #5
    //   47: aload_0
    //   48: getfield c : Landroid/app/Activity;
    //   51: invokespecial <init> : (Landroid/content/Context;)V
    //   54: aload #5
    //   56: aload_1
    //   57: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   60: astore #6
    //   62: aload #4
    //   64: invokestatic a : (Landroid/content/Context;)Z
    //   67: ifeq -> 160
    //   70: new com/alipay/sdk/util/e
    //   73: astore #7
    //   75: new com/alipay/sdk/app/a
    //   78: astore #5
    //   80: aload #5
    //   82: aload_0
    //   83: invokespecial <init> : (Lcom/alipay/sdk/app/AuthTask;)V
    //   86: aload #7
    //   88: aload #4
    //   90: aload #5
    //   92: invokespecial <init> : (Landroid/app/Activity;Lcom/alipay/sdk/util/e$a;)V
    //   95: aload #7
    //   97: aload #6
    //   99: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   102: astore #5
    //   104: aload #5
    //   106: ldc 'failed'
    //   108: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   111: ifne -> 160
    //   114: aload #5
    //   116: astore #4
    //   118: aload #5
    //   120: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   123: ifeq -> 131
    //   126: invokestatic a : ()Ljava/lang/String;
    //   129: astore #4
    //   131: invokestatic b : ()Lcom/alipay/sdk/data/a;
    //   134: aload_0
    //   135: getfield c : Landroid/app/Activity;
    //   138: invokevirtual a : (Landroid/content/Context;)V
    //   141: aload_0
    //   142: invokespecial c : ()V
    //   145: aload_0
    //   146: getfield c : Landroid/app/Activity;
    //   149: aload_1
    //   150: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   153: aload #4
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: areturn
    //   160: aload_0
    //   161: aload #4
    //   163: aload #6
    //   165: invokespecial b : (Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;
    //   168: astore #4
    //   170: goto -> 131
    //   173: astore #4
    //   175: invokestatic b : ()Lcom/alipay/sdk/data/a;
    //   178: aload_0
    //   179: getfield c : Landroid/app/Activity;
    //   182: invokevirtual a : (Landroid/content/Context;)V
    //   185: aload_0
    //   186: invokespecial c : ()V
    //   189: aload_0
    //   190: getfield c : Landroid/app/Activity;
    //   193: aload_1
    //   194: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   197: aload_3
    //   198: astore_1
    //   199: goto -> 156
    //   202: astore #4
    //   204: invokestatic b : ()Lcom/alipay/sdk/data/a;
    //   207: aload_0
    //   208: getfield c : Landroid/app/Activity;
    //   211: invokevirtual a : (Landroid/content/Context;)V
    //   214: aload_0
    //   215: invokespecial c : ()V
    //   218: aload_0
    //   219: getfield c : Landroid/app/Activity;
    //   222: aload_1
    //   223: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   226: aload #4
    //   228: athrow
    //   229: astore_1
    //   230: aload_0
    //   231: monitorexit
    //   232: aload_1
    //   233: athrow
    // Exception table:
    //   from	to	target	type
    //   6	10	229	finally
    //   10	34	229	finally
    //   34	114	173	java/lang/Exception
    //   34	114	202	finally
    //   118	131	173	java/lang/Exception
    //   118	131	202	finally
    //   131	153	229	finally
    //   160	170	173	java/lang/Exception
    //   160	170	202	finally
    //   175	197	229	finally
    //   204	229	229	finally
  }
  
  public Map<String, String> authV2(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_2
    //   5: invokevirtual auth : (Ljava/lang/String;Z)Ljava/lang/String;
    //   8: invokestatic a : (Ljava/lang/String;)Ljava/util/Map;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\AuthTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */