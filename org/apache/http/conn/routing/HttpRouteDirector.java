package org.apache.http.conn.routing;

@Deprecated
public interface HttpRouteDirector {
  public static final int COMPLETE = 0;
  
  public static final int CONNECT_PROXY = 2;
  
  public static final int CONNECT_TARGET = 1;
  
  public static final int LAYER_PROTOCOL = 5;
  
  public static final int TUNNEL_PROXY = 4;
  
  public static final int TUNNEL_TARGET = 3;
  
  public static final int UNREACHABLE = -1;
  
  int nextStep(RouteInfo paramRouteInfo1, RouteInfo paramRouteInfo2);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\conn\routing\HttpRouteDirector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */