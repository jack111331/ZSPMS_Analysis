package com.zz.lib.org.myapache.commons.codec.language;

import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;

public class Caverphone implements StringEncoder {
  private final Caverphone2 encoder = new Caverphone2();
  
  public String caverphone(String paramString) {
    return this.encoder.encode(paramString);
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof String))
      throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String"); 
    return caverphone((String)paramObject);
  }
  
  public String encode(String paramString) {
    return caverphone(paramString);
  }
  
  public boolean isCaverphoneEqual(String paramString1, String paramString2) {
    return caverphone(paramString1).equals(caverphone(paramString2));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\Caverphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */