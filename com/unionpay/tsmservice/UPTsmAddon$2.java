package com.unionpay.tsmservice;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class UPTsmAddon$2 implements ServiceConnection {
  UPTsmAddon$2(UPTsmAddon paramUPTsmAddon) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   6: iconst_1
    //   7: invokestatic a : (Lcom/unionpay/tsmservice/UPTsmAddon;Z)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield a : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   15: aload_2
    //   16: invokestatic asInterface : (Landroid/os/IBinder;)Lcom/unionpay/tsmservice/ITsmService;
    //   19: invokestatic a : (Lcom/unionpay/tsmservice/UPTsmAddon;Lcom/unionpay/tsmservice/ITsmService;)Lcom/unionpay/tsmservice/ITsmService;
    //   22: pop
    //   23: aload_0
    //   24: getfield a : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   27: invokestatic c : (Lcom/unionpay/tsmservice/UPTsmAddon;)Landroid/os/Handler;
    //   30: iconst_0
    //   31: invokevirtual sendEmptyMessage : (I)Z
    //   34: pop
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	38	finally
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   6: iconst_0
    //   7: invokestatic a : (Lcom/unionpay/tsmservice/UPTsmAddon;Z)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield a : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   15: aconst_null
    //   16: invokestatic a : (Lcom/unionpay/tsmservice/UPTsmAddon;Lcom/unionpay/tsmservice/ITsmService;)Lcom/unionpay/tsmservice/ITsmService;
    //   19: pop
    //   20: aload_0
    //   21: getfield a : Lcom/unionpay/tsmservice/UPTsmAddon;
    //   24: invokestatic c : (Lcom/unionpay/tsmservice/UPTsmAddon;)Landroid/os/Handler;
    //   27: iconst_1
    //   28: invokevirtual sendEmptyMessage : (I)Z
    //   31: pop
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	35	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\tsmservice\UPTsmAddon$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */