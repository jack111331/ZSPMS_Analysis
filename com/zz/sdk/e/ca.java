package com.zz.sdk.e;

import android.os.Handler;
import android.os.Looper;
import com.zz.sdk.b.a.ae;
import com.zz.sdk.b.n;
import com.zz.sdk.i.aq;
import java.text.SimpleDateFormat;
import java.util.Date;

class ca implements Runnable {
  ca(bx parambx, String paramString1, String paramString2) {}
  
  public void run() {
    Date date = null;
    ae ae = bx.c(this.c).j(this.a, this.b);
    if (ae != null && ae.c()) {
      String str;
      aq aq = ae.i();
      if (aq == null) {
        str = null;
      } else {
        str = aq.a();
      } 
      Date date1 = date;
      try {
        if (ae.k() != null) {
          long l = Long.parseLong(ae.k());
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
          this("yyyy-MM-dd HH:mm:ss");
          date1 = new Date();
          this(l);
          String str1 = simpleDateFormat.format(date1);
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
        date1 = date;
      } 
      if (str != null && str.length() > 0 && !str.equals(aq)) {
        n n = new n(bx.d(this.c));
        n.a(this.a, str, (String)date1);
        bx.a(this.c, n.a(this.b));
        (new Handler(Looper.getMainLooper())).post(new cb(this));
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */