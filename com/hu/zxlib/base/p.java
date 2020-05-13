package com.hu.zxlib.base;

import android.content.Context;
import android.widget.Toast;
import com.google.zxing.Result;
import com.hu.zxlib.c.d;

class p implements d {
  p(ScannerActivity paramScannerActivity) {}
  
  public void a() {
    Toast.makeText((Context)this.a, "抱歉，解析失败,换个图片试试.", 0).show();
  }
  
  public void a(Result paramResult) {
    this.a.a(paramResult);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\base\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */