package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.b.a;
import com.alipay.apmobilesecuritysdk.e.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;
import java.util.Map;

public class APSecuritySdk {
  private static APSecuritySdk a;
  
  private static Object c = new Object();
  
  private Context b;
  
  private APSecuritySdk(Context paramContext) {
    this.b = paramContext;
  }
  
  public static APSecuritySdk getInstance(Context paramContext) {
    if (a == null)
      synchronized (c) {
        if (a == null) {
          APSecuritySdk aPSecuritySdk = new APSecuritySdk();
          this(paramContext);
          a = aPSecuritySdk;
        } 
        return a;
      }  
    return a;
  }
  
  public static String getUtdid(Context paramContext) {
    return UtdidWrapper.getUtdid(paramContext);
  }
  
  public String getApdidToken() {
    String str = a.a(this.b, "");
    if (a.a(str))
      initToken(0, new HashMap<String, String>(), null); 
    return str;
  }
  
  public String getSdkName() {
    return "APPSecuritySDK-ALIPAYSDK";
  }
  
  public String getSdkVersion() {
    return "3.2.2-20180307";
  }
  
  public TokenResult getTokenResult() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: new com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokespecial <init> : (Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)V
    //   13: aload_2
    //   14: aload_0
    //   15: getfield b : Landroid/content/Context;
    //   18: ldc ''
    //   20: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   23: putfield apdidToken : Ljava/lang/String;
    //   26: aload_2
    //   27: aload_0
    //   28: getfield b : Landroid/content/Context;
    //   31: invokestatic f : (Landroid/content/Context;)Ljava/lang/String;
    //   34: putfield clientKey : Ljava/lang/String;
    //   37: aload_2
    //   38: aload_0
    //   39: getfield b : Landroid/content/Context;
    //   42: invokestatic a : (Landroid/content/Context;)Ljava/lang/String;
    //   45: putfield apdid : Ljava/lang/String;
    //   48: aload_2
    //   49: aload_0
    //   50: getfield b : Landroid/content/Context;
    //   53: invokestatic getSecurityToken : (Landroid/content/Context;)Ljava/lang/String;
    //   56: putfield umidToken : Ljava/lang/String;
    //   59: aload_2
    //   60: getfield apdid : Ljava/lang/String;
    //   63: invokestatic a : (Ljava/lang/String;)Z
    //   66: ifeq -> 71
    //   69: iconst_1
    //   70: istore_1
    //   71: iload_1
    //   72: ifne -> 95
    //   75: aload_2
    //   76: getfield apdidToken : Ljava/lang/String;
    //   79: invokestatic a : (Ljava/lang/String;)Z
    //   82: ifne -> 95
    //   85: aload_2
    //   86: getfield clientKey : Ljava/lang/String;
    //   89: invokestatic a : (Ljava/lang/String;)Z
    //   92: ifeq -> 110
    //   95: new java/util/HashMap
    //   98: astore_3
    //   99: aload_3
    //   100: invokespecial <init> : ()V
    //   103: aload_0
    //   104: iconst_0
    //   105: aload_3
    //   106: aconst_null
    //   107: invokevirtual initToken : (ILjava/util/Map;Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;)V
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_2
    //   113: areturn
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: astore_3
    //   120: goto -> 110
    // Exception table:
    //   from	to	target	type
    //   4	13	114	finally
    //   13	59	119	java/lang/Throwable
    //   13	59	114	finally
    //   59	69	119	java/lang/Throwable
    //   59	69	114	finally
    //   75	95	119	java/lang/Throwable
    //   75	95	114	finally
    //   95	110	119	java/lang/Throwable
    //   95	110	114	finally
  }
  
  public void initToken(int paramInt, Map<String, String> paramMap, InitResultListener paramInitResultListener) {
    a.a().a(paramInt);
    String str2 = h.b(this.b);
    String str3 = a.a().c();
    if (a.b(str2) && !a.a(str2, str3)) {
      a.a(this.b);
      d.a(this.b);
      g.a(this.b);
      i.h();
    } 
    if (!a.a(str2, str3))
      h.c(this.b, str3); 
    str2 = a.a(paramMap, "utdid", "");
    str3 = a.a(paramMap, "tid", "");
    String str4 = a.a(paramMap, "userId", "");
    String str1 = str2;
    if (a.a(str2))
      str1 = UtdidWrapper.getUtdid(this.b); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("utdid", str1);
    hashMap.put("tid", str3);
    hashMap.put("userId", str4);
    hashMap.put("appName", "");
    hashMap.put("appKeyClient", "");
    hashMap.put("appchannel", "");
    hashMap.put("rpcVersion", "8");
    b.a().a(new APSecuritySdk$1(this, hashMap, paramInitResultListener));
  }
  
  public static interface InitResultListener {
    void onResult(APSecuritySdk.TokenResult param1TokenResult);
  }
  
  public class TokenResult {
    public String apdid;
    
    public String apdidToken;
    
    public String clientKey;
    
    public String umidToken;
    
    public TokenResult(APSecuritySdk this$0) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\face\APSecuritySdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */