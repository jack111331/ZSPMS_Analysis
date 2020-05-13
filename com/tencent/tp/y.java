package com.tencent.tp;

import android.util.Log;

public class y {
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramInt1 & 0xFF) << 16 | (paramInt4 & 0xFF) << 24 | (paramInt2 & 0xFF) << 8 | paramInt3 & 0xFF;
  }
  
  public static void a(String paramString) {
    Log.d("tss", paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */