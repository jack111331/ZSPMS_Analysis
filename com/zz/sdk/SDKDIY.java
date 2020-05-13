package com.zz.sdk;

public class SDKDIY {
  private static int a = -1;
  
  private static boolean b = false;
  
  public static boolean getPayAutoStart() {
    return b;
  }
  
  public static int getPaySequenceTop() {
    return a;
  }
  
  public static void setPayAutoStart(boolean paramBoolean) {
    b = paramBoolean;
  }
  
  public static void setPaySequence_CallCharge(boolean paramBoolean) {
    if (paramBoolean) {
      a = 5;
      return;
    } 
    a = -1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\SDKDIY.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */