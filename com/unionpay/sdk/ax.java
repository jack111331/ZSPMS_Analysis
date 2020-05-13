package com.unionpay.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ax extends Handler {
  ax(Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield what : I
    //   4: tableswitch default -> 28, 102 -> 29, 103 -> 76
    //   28: return
    //   29: aload_1
    //   30: getfield obj : Ljava/lang/Object;
    //   33: ifnull -> 28
    //   36: aload_1
    //   37: getfield obj : Ljava/lang/Object;
    //   40: instanceof com/unionpay/sdk/w$a
    //   43: ifeq -> 28
    //   46: aload_1
    //   47: getfield obj : Ljava/lang/Object;
    //   50: checkcast com/unionpay/sdk/w$a
    //   53: astore_1
    //   54: invokestatic d : ()Lcom/unionpay/sdk/bc;
    //   57: invokevirtual a : ()V
    //   60: invokestatic a : ()Lcom/unionpay/sdk/ah;
    //   63: aload_1
    //   64: invokevirtual post : (Ljava/lang/Object;)V
    //   67: invokestatic d : ()Lcom/unionpay/sdk/bc;
    //   70: invokevirtual b : ()V
    //   73: goto -> 28
    //   76: aload_1
    //   77: getfield obj : Ljava/lang/Object;
    //   80: ifnull -> 28
    //   83: aload_1
    //   84: getfield obj : Ljava/lang/Object;
    //   87: instanceof com/unionpay/sdk/ba
    //   90: ifeq -> 28
    //   93: aload_1
    //   94: getfield obj : Ljava/lang/Object;
    //   97: checkcast com/unionpay/sdk/ba
    //   100: astore_1
    //   101: invokestatic a : ()Lcom/unionpay/sdk/ah;
    //   104: aload_1
    //   105: invokevirtual post : (Ljava/lang/Object;)V
    //   108: goto -> 28
    //   111: astore_1
    //   112: goto -> 28
    //   115: astore_1
    //   116: goto -> 67
    // Exception table:
    //   from	to	target	type
    //   60	67	115	java/lang/Throwable
    //   101	108	111	java/lang/Throwable
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */