package com.qiniu.android.dns;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class Network {
  private static String previousIp = "";
  
  public static String getIp() {
    try {
      DatagramSocket datagramSocket = new DatagramSocket();
      this();
      datagramSocket.connect(InetAddress.getByName("114.114.114.114"), 53);
      InetAddress inetAddress = datagramSocket.getLocalAddress();
      datagramSocket.close();
      return inetAddress.getHostAddress();
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return "";
    } 
  }
  
  public static boolean isNetworkChanged() {
    // Byte code:
    //   0: ldc com/qiniu/android/dns/Network
    //   2: monitorenter
    //   3: invokestatic getIp : ()Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: getstatic com/qiniu/android/dns/Network.previousIp : Ljava/lang/String;
    //   11: invokevirtual equals : (Ljava/lang/Object;)Z
    //   14: istore_1
    //   15: iload_1
    //   16: ifeq -> 24
    //   19: ldc com/qiniu/android/dns/Network
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: putstatic com/qiniu/android/dns/Network.previousIp : Ljava/lang/String;
    //   28: ldc com/qiniu/android/dns/Network
    //   30: monitorexit
    //   31: iconst_1
    //   32: ireturn
    //   33: astore_0
    //   34: ldc com/qiniu/android/dns/Network
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	33	finally
    //   24	28	33	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\Network.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */