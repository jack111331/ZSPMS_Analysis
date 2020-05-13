package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.net.c;
import com.unionpay.mobile.android.net.d;
import java.lang.ref.WeakReference;

public final class r implements Handler.Callback, Runnable {
  private d a = null;
  
  private Handler b = null;
  
  private WeakReference<a> c = null;
  
  private Context d;
  
  public r(Context paramContext, String paramString, a parama) {
    this.a = new d(0, paramString, null);
    this.b = new Handler(this);
    this.c = new WeakReference<a>(parama);
    this.d = paramContext;
  }
  
  public final void a() {
    (new Thread(this)).start();
  }
  
  public final boolean handleMessage(Message paramMessage) {
    switch (paramMessage.what) {
      default:
        return true;
      case 0:
        break;
    } 
    if (this.c != null && this.c.get() != null) {
      byte[] arrayOfByte;
      if (paramMessage.obj != null) {
        arrayOfByte = (byte[])paramMessage.obj;
      } else {
        arrayOfByte = null;
      } 
      ((a)this.c.get()).a(paramMessage.arg1, arrayOfByte);
    } 
  }
  
  public final void run() {
    c c = new c(this.a, this.d);
    int i = c.a();
    if (this.b != null) {
      Message message = this.b.obtainMessage();
      message.what = 0;
      message.arg1 = i;
      message.obj = c.b();
      this.b.sendMessage(message);
    } 
  }
  
  public static interface a {
    void a(int param1Int, byte[] param1ArrayOfbyte);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */