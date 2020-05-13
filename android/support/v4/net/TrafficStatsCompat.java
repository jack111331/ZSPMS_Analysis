package android.support.v4.net;

import android.os.Build;
import java.net.DatagramSocket;
import java.net.Socket;

public final class TrafficStatsCompat {
  private static final TrafficStatsCompatImpl IMPL = new BaseTrafficStatsCompatImpl();
  
  public static void clearThreadStatsTag() {
    IMPL.clearThreadStatsTag();
  }
  
  public static int getThreadStatsTag() {
    return IMPL.getThreadStatsTag();
  }
  
  public static void incrementOperationCount(int paramInt) {
    IMPL.incrementOperationCount(paramInt);
  }
  
  public static void incrementOperationCount(int paramInt1, int paramInt2) {
    IMPL.incrementOperationCount(paramInt1, paramInt2);
  }
  
  public static void setThreadStatsTag(int paramInt) {
    IMPL.setThreadStatsTag(paramInt);
  }
  
  public static void tagDatagramSocket(DatagramSocket paramDatagramSocket) {
    IMPL.tagDatagramSocket(paramDatagramSocket);
  }
  
  public static void tagSocket(Socket paramSocket) {
    IMPL.tagSocket(paramSocket);
  }
  
  public static void untagDatagramSocket(DatagramSocket paramDatagramSocket) {
    IMPL.untagDatagramSocket(paramDatagramSocket);
  }
  
  public static void untagSocket(Socket paramSocket) {
    IMPL.untagSocket(paramSocket);
  }
  
  static {
    if ("N".equals(Build.VERSION.CODENAME)) {
      IMPL = new Api24TrafficStatsCompatImpl();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new IcsTrafficStatsCompatImpl();
      return;
    } 
  }
  
  static class Api24TrafficStatsCompatImpl extends IcsTrafficStatsCompatImpl {
    public void tagDatagramSocket(DatagramSocket param1DatagramSocket) {
      TrafficStatsCompatApi24.tagDatagramSocket(param1DatagramSocket);
    }
    
    public void untagDatagramSocket(DatagramSocket param1DatagramSocket) {
      TrafficStatsCompatApi24.untagDatagramSocket(param1DatagramSocket);
    }
  }
  
  static class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
    private ThreadLocal<TrafficStatsCompat.BaseTrafficStatsCompatImpl$SocketTags> mThreadSocketTags = new ThreadLocal<TrafficStatsCompat.BaseTrafficStatsCompatImpl$SocketTags>() {
        protected TrafficStatsCompat.BaseTrafficStatsCompatImpl$SocketTags initialValue() {
          return new TrafficStatsCompat.BaseTrafficStatsCompatImpl$SocketTags();
        }
      };
    
    public void clearThreadStatsTag() {
      ((TrafficStatsCompat.BaseTrafficStatsCompatImpl$SocketTags)this.mThreadSocketTags.get()).statsTag = -1;
    }
    
    public int getThreadStatsTag() {
      return ((TrafficStatsCompat.BaseTrafficStatsCompatImpl$SocketTags)this.mThreadSocketTags.get()).statsTag;
    }
    
    public void incrementOperationCount(int param1Int) {}
    
    public void incrementOperationCount(int param1Int1, int param1Int2) {}
    
    public void setThreadStatsTag(int param1Int) {
      ((TrafficStatsCompat.BaseTrafficStatsCompatImpl$SocketTags)this.mThreadSocketTags.get()).statsTag = param1Int;
    }
    
    public void tagDatagramSocket(DatagramSocket param1DatagramSocket) {}
    
    public void tagSocket(Socket param1Socket) {}
    
    public void untagDatagramSocket(DatagramSocket param1DatagramSocket) {}
    
    public void untagSocket(Socket param1Socket) {}
    
    private static class BaseTrafficStatsCompatImpl$SocketTags {
      public int statsTag = -1;
    }
  }
  
  class null extends ThreadLocal<BaseTrafficStatsCompatImpl$SocketTags> {
    protected TrafficStatsCompat.BaseTrafficStatsCompatImpl$SocketTags initialValue() {
      return new TrafficStatsCompat.BaseTrafficStatsCompatImpl$SocketTags();
    }
  }
  
  private static class BaseTrafficStatsCompatImpl$SocketTags {
    public int statsTag = -1;
  }
  
  static class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
    public void clearThreadStatsTag() {
      TrafficStatsCompatIcs.clearThreadStatsTag();
    }
    
    public int getThreadStatsTag() {
      return TrafficStatsCompatIcs.getThreadStatsTag();
    }
    
    public void incrementOperationCount(int param1Int) {
      TrafficStatsCompatIcs.incrementOperationCount(param1Int);
    }
    
    public void incrementOperationCount(int param1Int1, int param1Int2) {
      TrafficStatsCompatIcs.incrementOperationCount(param1Int1, param1Int2);
    }
    
    public void setThreadStatsTag(int param1Int) {
      TrafficStatsCompatIcs.setThreadStatsTag(param1Int);
    }
    
    public void tagDatagramSocket(DatagramSocket param1DatagramSocket) {
      TrafficStatsCompatIcs.tagDatagramSocket(param1DatagramSocket);
    }
    
    public void tagSocket(Socket param1Socket) {
      TrafficStatsCompatIcs.tagSocket(param1Socket);
    }
    
    public void untagDatagramSocket(DatagramSocket param1DatagramSocket) {
      TrafficStatsCompatIcs.untagDatagramSocket(param1DatagramSocket);
    }
    
    public void untagSocket(Socket param1Socket) {
      TrafficStatsCompatIcs.untagSocket(param1Socket);
    }
  }
  
  static interface TrafficStatsCompatImpl {
    void clearThreadStatsTag();
    
    int getThreadStatsTag();
    
    void incrementOperationCount(int param1Int);
    
    void incrementOperationCount(int param1Int1, int param1Int2);
    
    void setThreadStatsTag(int param1Int);
    
    void tagDatagramSocket(DatagramSocket param1DatagramSocket);
    
    void tagSocket(Socket param1Socket);
    
    void untagDatagramSocket(DatagramSocket param1DatagramSocket);
    
    void untagSocket(Socket param1Socket);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\net\TrafficStatsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */