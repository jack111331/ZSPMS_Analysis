package com.sdk.mobile.manager.login;

import com.sdk.base.api.OnCustomViewListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class a {
  private static volatile a b;
  
  private HashMap<String, OnCustomViewListener> a = new HashMap<String, OnCustomViewListener>();
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/sdk/mobile/manager/login/a.b : Lcom/sdk/mobile/manager/login/a;
    //   3: ifnonnull -> 30
    //   6: ldc com/sdk/mobile/manager/login/a
    //   8: monitorenter
    //   9: getstatic com/sdk/mobile/manager/login/a.b : Lcom/sdk/mobile/manager/login/a;
    //   12: ifnonnull -> 27
    //   15: new com/sdk/mobile/manager/login/a
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/sdk/mobile/manager/login/a.b : Lcom/sdk/mobile/manager/login/a;
    //   27: ldc com/sdk/mobile/manager/login/a
    //   29: monitorexit
    //   30: getstatic com/sdk/mobile/manager/login/a.b : Lcom/sdk/mobile/manager/login/a;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/sdk/mobile/manager/login/a
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void a(String paramString, OnCustomViewListener paramOnCustomViewListener) {
    if (!com.sdk.base.framework.utils.k.a.a(paramString).booleanValue())
      this.a.put(paramString, paramOnCustomViewListener); 
  }
  
  public void a(List<String> paramList, OnCustomViewListener paramOnCustomViewListener) {
    if (paramList != null) {
      Iterator<String> iterator = paramList.iterator();
      while (true) {
        if (iterator.hasNext()) {
          String str = iterator.next();
          this.a.put(str, paramOnCustomViewListener);
          continue;
        } 
        return;
      } 
    } 
  }
  
  public void a(String... paramVarArgs) {
    if (!com.sdk.base.framework.utils.k.a.a(paramVarArgs)) {
      int i = paramVarArgs.length;
      byte b = 0;
      while (true) {
        if (b < i) {
          String str = paramVarArgs[b];
          this.a.remove(str);
          b++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public HashMap<String, OnCustomViewListener> b() {
    return this.a;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\mobile\manager\login\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */