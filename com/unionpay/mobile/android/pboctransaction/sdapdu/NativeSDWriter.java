package com.unionpay.mobile.android.pboctransaction.sdapdu;

import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;

public class NativeSDWriter {
  public NativeSDWriter() {
    b.a();
  }
  
  private native boolean closeSD();
  
  private native boolean openSD(ArrayList<String> paramArrayList);
  
  private native String writeApdu(String paramString);
  
  public final String a(String paramString) {
    k.c("uppay", "[====>]" + paramString);
    paramString = writeApdu(paramString);
    k.c("uppay", "[<====]" + paramString);
    return paramString;
  }
  
  public final boolean a() {
    k.c("uppay", "close()");
    return closeSD();
  }
  
  public final boolean a(ArrayList<String> paramArrayList) {
    boolean bool = openSD(paramArrayList);
    k.c("uppay", "open(), ret=" + bool);
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\sdapdu\NativeSDWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */