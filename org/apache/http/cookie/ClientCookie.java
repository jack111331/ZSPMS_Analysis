package org.apache.http.cookie;

@Deprecated
public interface ClientCookie extends Cookie {
  public static final String COMMENTURL_ATTR = "commenturl";
  
  public static final String COMMENT_ATTR = "comment";
  
  public static final String DISCARD_ATTR = "discard";
  
  public static final String DOMAIN_ATTR = "domain";
  
  public static final String EXPIRES_ATTR = "expires";
  
  public static final String MAX_AGE_ATTR = "max-age";
  
  public static final String PATH_ATTR = "path";
  
  public static final String PORT_ATTR = "port";
  
  public static final String SECURE_ATTR = "secure";
  
  public static final String VERSION_ATTR = "version";
  
  boolean containsAttribute(String paramString);
  
  String getAttribute(String paramString);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\cookie\ClientCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */