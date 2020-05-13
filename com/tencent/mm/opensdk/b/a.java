package com.tencent.mm.opensdk.b;

import android.os.Bundle;
import android.util.Log;

public final class a {
  public static int a(Bundle paramBundle, String paramString) {
    byte b;
    if (paramBundle == null)
      return -1; 
    try {
      b = paramBundle.getInt(paramString, -1);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("getIntExtra exception:");
      stringBuilder.append(exception.getMessage());
      Log.e("MicroMsg.IntentUtil", stringBuilder.toString());
      b = -1;
    } 
    return b;
  }
  
  public static String b(Bundle paramBundle, String paramString) {
    if (paramBundle == null)
      return null; 
    try {
      String str = paramBundle.getString(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("getStringExtra exception:");
      stringBuilder.append(exception.getMessage());
      Log.e("MicroMsg.IntentUtil", stringBuilder.toString());
      exception = null;
    } 
    return (String)exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */