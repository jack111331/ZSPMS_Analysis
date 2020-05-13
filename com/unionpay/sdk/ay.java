package com.unionpay.sdk;

import android.util.Log;

final class ay {
  static void a(String paramString) {
    if (UPAgent.LOG_ON)
      Log.i("UPLog", paramString); 
  }
  
  static void a(String paramString, Throwable paramThrowable) {
    if (UPAgent.LOG_ON)
      Log.e("UPLog", paramString, paramThrowable); 
  }
  
  static void b(String paramString) {
    if (UPAgent.LOG_ON)
      Log.e("UPLog", paramString); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */