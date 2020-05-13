package org.apache.http.client.entity;

import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;

@Deprecated
public class UrlEncodedFormEntity extends StringEntity {
  public UrlEncodedFormEntity(List<? extends NameValuePair> paramList) throws UnsupportedEncodingException {
    super((String)null);
    throw new RuntimeException("Stub!");
  }
  
  public UrlEncodedFormEntity(List<? extends NameValuePair> paramList, String paramString) throws UnsupportedEncodingException {
    super((String)null);
    throw new RuntimeException("Stub!");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\client\entity\UrlEncodedFormEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */