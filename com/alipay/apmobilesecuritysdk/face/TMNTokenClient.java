package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;

public class TMNTokenClient {
  private static TMNTokenClient a = null;
  
  private Context b = null;
  
  private TMNTokenClient(Context paramContext) {
    if (paramContext == null)
      throw new IllegalArgumentException("TMNTokenClient initialization error: context is null."); 
    this.b = paramContext;
  }
  
  public static TMNTokenClient getInstance(Context paramContext) {
    // Byte code:
    //   0: getstatic com/alipay/apmobilesecuritysdk/face/TMNTokenClient.a : Lcom/alipay/apmobilesecuritysdk/face/TMNTokenClient;
    //   3: ifnonnull -> 31
    //   6: ldc com/alipay/apmobilesecuritysdk/face/TMNTokenClient
    //   8: monitorenter
    //   9: getstatic com/alipay/apmobilesecuritysdk/face/TMNTokenClient.a : Lcom/alipay/apmobilesecuritysdk/face/TMNTokenClient;
    //   12: ifnonnull -> 28
    //   15: new com/alipay/apmobilesecuritysdk/face/TMNTokenClient
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/alipay/apmobilesecuritysdk/face/TMNTokenClient.a : Lcom/alipay/apmobilesecuritysdk/face/TMNTokenClient;
    //   28: ldc com/alipay/apmobilesecuritysdk/face/TMNTokenClient
    //   30: monitorexit
    //   31: getstatic com/alipay/apmobilesecuritysdk/face/TMNTokenClient.a : Lcom/alipay/apmobilesecuritysdk/face/TMNTokenClient;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/alipay/apmobilesecuritysdk/face/TMNTokenClient
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
  }
  
  public void intiToken(String paramString1, String paramString2, String paramString3, InitResultListener paramInitResultListener) {
    if (a.a(paramString1) && paramInitResultListener != null)
      paramInitResultListener.onResult("", 2); 
    if (a.a(paramString2) && paramInitResultListener != null)
      paramInitResultListener.onResult("", 3); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("utdid", UtdidWrapper.getUtdid(this.b));
    hashMap.put("tid", "");
    hashMap.put("userId", "");
    hashMap.put("appName", paramString1);
    hashMap.put("appKeyClient", paramString2);
    hashMap.put("appchannel", "openapi");
    hashMap.put("sessionId", paramString3);
    hashMap.put("rpcVersion", "8");
    b.a().a(new TMNTokenClient$1(this, hashMap, paramInitResultListener, paramString1));
  }
  
  public static interface InitResultListener {
    void onResult(String param1String, int param1Int);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\apmobilesecuritysdk\face\TMNTokenClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */