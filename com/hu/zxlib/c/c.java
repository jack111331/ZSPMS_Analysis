package com.hu.zxlib.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.hu.zxlib.base.ScannerActivity;
import java.util.Map;

public final class c extends Handler {
  private static final String a = "c";
  
  private final ScannerActivity b;
  
  private final MultiFormatReader c = new MultiFormatReader();
  
  private boolean d = true;
  
  c(ScannerActivity paramScannerActivity, Map<DecodeHintType, Object> paramMap) {
    this.c.setHints(paramMap);
    this.b = paramScannerActivity;
  }
  
  private void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
    for (byte b = 0; b < paramInt2; b++) {
      for (byte b1 = 0; b1 < paramInt1; b1++)
        arrayOfByte[b1 * paramInt2 + paramInt2 - b - 1] = (byte)paramArrayOfbyte[b * paramInt1 + b1]; 
    } 
    PlanarYUVLuminanceSource planarYUVLuminanceSource = this.b.c().a(arrayOfByte, paramInt2, paramInt1);
    if (planarYUVLuminanceSource != null) {
      Message message;
      null = new BinaryBitmap((Binarizer)new HybridBinarizer((LuminanceSource)planarYUVLuminanceSource));
      try {
        Result result = this.c.decodeWithState(null);
      } catch (ReaderException readerException) {
        this.c.reset();
      } finally {
        this.c.reset();
      } 
      Handler handler = this.b.b();
      if (planarYUVLuminanceSource != null) {
        if (handler != null) {
          message = Message.obtain(handler, 3, planarYUVLuminanceSource);
        } else {
          return;
        } 
      } else if (handler != null) {
        message = Message.obtain(handler, 2);
      } else {
        return;
      } 
      message.sendToTarget();
      return;
    } 
    planarYUVLuminanceSource = null;
  }
  
  public void handleMessage(Message paramMessage) {
    if (!this.d)
      return; 
    int i = paramMessage.what;
    if (i != 1) {
      if (i == 5) {
        this.d = false;
        Looper.myLooper().quit();
      } 
    } else {
      a((byte[])paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */