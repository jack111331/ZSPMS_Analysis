package com.herosdk.listener;

public class a implements ICommonListener {
  private static String a = "frameLib.CL";
  
  private ICommonListener b = null;
  
  public a(ICommonListener paramICommonListener) {
    this.b = paramICommonListener;
  }
  
  public void onFailed(int paramInt, String paramString) {
    if (this.b != null)
      this.b.onFailed(paramInt, paramString); 
  }
  
  public void onSuccess(int paramInt, String paramString) {
    if (this.b != null)
      this.b.onSuccess(paramInt, paramString); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */