package com.unionpay.sdk;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class s {
  private static volatile s a = null;
  
  private as b = bc.d();
  
  static {
    try {
      ah.a().register(a());
    } catch (Throwable throwable) {}
  }
  
  public static s a() {
    // Byte code:
    //   0: getstatic com/unionpay/sdk/s.a : Lcom/unionpay/sdk/s;
    //   3: ifnonnull -> 30
    //   6: ldc com/unionpay/sdk/s
    //   8: monitorenter
    //   9: getstatic com/unionpay/sdk/s.a : Lcom/unionpay/sdk/s;
    //   12: ifnonnull -> 27
    //   15: new com/unionpay/sdk/s
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/unionpay/sdk/s.a : Lcom/unionpay/sdk/s;
    //   27: ldc com/unionpay/sdk/s
    //   29: monitorexit
    //   30: getstatic com/unionpay/sdk/s.a : Lcom/unionpay/sdk/s;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/unionpay/sdk/s
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, Map paramMap) {
    if (az.b() != null && !az.b().isEmpty())
      this.b.a(az.b(), paramString1, paramString2, Long.valueOf(paramString3).longValue(), paramMap); 
  }
  
  public final void onTDEBEventAppEvent(w.a parama) {
    if (parama != null && parama.a != null && Integer.parseInt(String.valueOf(parama.a.get("apiType"))) == 4) {
      if (!w.a) {
        Object object = parama.a.get("context");
        if (object != null && object instanceof Context) {
          w.a((Context)object, (String)null, (String)null);
        } else {
          return;
        } 
      } 
      TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
      String str = String.valueOf(parama.a.get("eventId"));
      if (ab.a.size() > 0 && str != null && !str.startsWith("__"))
        treeMap.putAll(ab.a); 
      str = (String)parama.a.get("map");
      if (str != null && str instanceof HashMap)
        treeMap.putAll((Map<?, ?>)str); 
      parama.a.put("controller", a());
      parama.a.put("map", treeMap);
      HashMap hashMap = parama.a;
      if (hashMap.containsKey("map") && hashMap.get("map") instanceof Map) {
        a(String.valueOf(hashMap.get("eventId")), String.valueOf(hashMap.get("eventLabel")), String.valueOf(hashMap.get("occurTime")), (Map)hashMap.get("map"));
        return;
      } 
      a(String.valueOf(hashMap.get("eventId")), String.valueOf(hashMap.get("eventLabel")), String.valueOf(hashMap.get("occurTime")), null);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */