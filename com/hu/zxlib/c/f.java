package com.hu.zxlib.c;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.hu.zxlib.base.ScannerActivity;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public final class f extends Thread {
  private final ScannerActivity a;
  
  private final Hashtable<DecodeHintType, Object> b;
  
  private final Vector<BarcodeFormat> c;
  
  private Handler d;
  
  private final CountDownLatch e;
  
  public f(ScannerActivity paramScannerActivity, ResultPointCallback paramResultPointCallback) {
    this.a = paramScannerActivity;
    this.e = new CountDownLatch(1);
    this.b = new Hashtable<DecodeHintType, Object>();
    this.c = new Vector<BarcodeFormat>();
    if (paramScannerActivity.a.c())
      this.c.addAll(b.c); 
    this.c.addAll(b.d);
    this.c.addAll(b.e);
    this.b.put(DecodeHintType.POSSIBLE_FORMATS, this.c);
    this.b.put(DecodeHintType.CHARACTER_SET, "UTF-8");
    this.b.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, paramResultPointCallback);
  }
  
  public Handler a() {
    try {
      this.e.await();
    } catch (InterruptedException interruptedException) {}
    return this.d;
  }
  
  public void run() {
    Looper.prepare();
    this.d = new c(this.a, this.b);
    this.e.countDown();
    Looper.loop();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */