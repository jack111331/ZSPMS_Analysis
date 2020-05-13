package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;

@Deprecated
public interface RouteInfo {
  int getHopCount();
  
  HttpHost getHopTarget(int paramInt);
  
  LayerType getLayerType();
  
  InetAddress getLocalAddress();
  
  HttpHost getProxyHost();
  
  HttpHost getTargetHost();
  
  TunnelType getTunnelType();
  
  boolean isLayered();
  
  boolean isSecure();
  
  boolean isTunnelled();
  
  public enum LayerType {
    LAYERED, PLAIN;
    
    static {
    
    }
  }
  
  public enum TunnelType {
    PLAIN, TUNNELLED;
    
    static {
    
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\routing\RouteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */