package com.alipay.android.phone.mrpc.core;

import java.io.Closeable;
import java.io.IOException;

public final class r {
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
      } catch (IOException iOException) {} 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */