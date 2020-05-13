package com.zz.lib.org.myapache.commons.codec.language;

import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;

public abstract class AbstractCaverphone implements StringEncoder {
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof String))
      throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String"); 
    return encode((String)paramObject);
  }
  
  public boolean isEncodeEqual(String paramString1, String paramString2) throws EncoderException {
    return encode(paramString1).equals(encode(paramString2));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\AbstractCaverphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */