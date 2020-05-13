package com.hu.zxlib.base;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.Result;
import com.google.zxing.ResultPointCallback;
import com.hu.zxlib.b.e;
import com.hu.zxlib.c.f;
import com.hu.zxlib.view.a;

public final class b extends Handler {
  private static final String a = "b";
  
  private final ScannerActivity b;
  
  private final f c;
  
  private c d;
  
  private final e e;
  
  public b(ScannerActivity paramScannerActivity, e parame) {
    this.b = paramScannerActivity;
    this.c = new f(paramScannerActivity, (ResultPointCallback)new a(paramScannerActivity.a()));
    this.c.start();
    this.d = c.b;
    this.e = parame;
    parame.c();
    b();
  }
  
  public void a() {
    this.d = c.c;
    this.e.d();
    Message.obtain(this.c.a(), 5).sendToTarget();
    try {
      this.c.join(500L);
    } catch (InterruptedException interruptedException) {}
    removeMessages(3);
    removeMessages(2);
  }
  
  public void b() {
    if (this.d == c.b) {
      this.d = c.a;
      this.e.a(this.c.a(), 1);
      this.b.d();
    } 
  }
  
  public void handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return;
      case 7:
        this.b.setResult(-1, (Intent)paramMessage.obj);
        this.b.finish();
      case 6:
        b();
      case 3:
        this.d = c.b;
        this.b.a((Result)paramMessage.obj);
      case 2:
        break;
    } 
    this.d = c.a;
    this.e.a(this.c.a(), 1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\base\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */