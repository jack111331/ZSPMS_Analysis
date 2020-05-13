package com.unionpay.tsmservice;

import android.os.Handler;
import android.os.Message;

final class UPTsmAddon$1 implements Handler.Callback {
  UPTsmAddon$1(UPTsmAddon paramUPTsmAddon) {}
  
  public final boolean handleMessage(Message paramMessage) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: getfield what : I
    //   8: istore_3
    //   9: iload_3
    //   10: tableswitch default -> 32, 0 -> 38, 1 -> 53
    //   32: iconst_0
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_2
    //   37: ireturn
    //   38: aload_0
    //   39: getfield a : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   42: invokestatic a : (Lcom/unionpay/tsmservice/UPTsmAddon;)V
    //   45: goto -> 34
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: aload_0
    //   54: getfield a : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   57: invokestatic b : (Lcom/unionpay/tsmservice/UPTsmAddon;)V
    //   60: goto -> 34
    // Exception table:
    //   from	to	target	type
    //   4	9	48	finally
    //   38	45	48	finally
    //   53	60	48	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\UPTsmAddon$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */