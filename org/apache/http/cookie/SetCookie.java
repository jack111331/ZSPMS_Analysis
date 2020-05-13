package org.apache.http.cookie;

import java.util.Date;

@Deprecated
public interface SetCookie extends Cookie {
  void setComment(String paramString);
  
  void setDomain(String paramString);
  
  void setExpiryDate(Date paramDate);
  
  void setPath(String paramString);
  
  void setSecure(boolean paramBoolean);
  
  void setValue(String paramString);
  
  void setVersion(int paramInt);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\cookie\SetCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */