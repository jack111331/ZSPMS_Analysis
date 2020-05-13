package org.apache.http.cookie;

import java.util.Date;

@Deprecated
public interface Cookie {
  String getComment();
  
  String getCommentURL();
  
  String getDomain();
  
  Date getExpiryDate();
  
  String getName();
  
  String getPath();
  
  int[] getPorts();
  
  String getValue();
  
  int getVersion();
  
  boolean isExpired(Date paramDate);
  
  boolean isPersistent();
  
  boolean isSecure();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\cookie\Cookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */