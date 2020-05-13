package com.hu.zxlib.common;

import android.content.Context;
import android.content.Intent;
import com.hu.scan.permission.a;
import com.hu.zxlib.base.ScannerActivity;
import java.util.List;

class e implements a {
  e(c paramc) {}
  
  public void a(List<String> paramList) {
    try {
      Intent intent = new Intent();
      this((Context)this.a.a, ScannerActivity.class);
      intent.putExtra("zxingExtra", this.a.b);
      this.a.a.startActivityForResult(intent, 48056932);
    } catch (Exception exception) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\common\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */