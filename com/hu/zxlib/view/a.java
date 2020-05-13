package com.hu.zxlib.view;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

public final class a implements ResultPointCallback {
  private final ViewfinderView a;
  
  public a(ViewfinderView paramViewfinderView) {
    this.a = paramViewfinderView;
  }
  
  public void foundPossibleResultPoint(ResultPoint paramResultPoint) {
    this.a.a(paramResultPoint);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */