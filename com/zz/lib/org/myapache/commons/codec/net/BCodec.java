package com.zz.lib.org.myapache.commons.codec.net;

import com.zz.lib.org.myapache.commons.codec.DecoderException;
import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringDecoder;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;
import com.zz.lib.org.myapache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;

public class BCodec extends RFC1522Codec implements StringDecoder, StringEncoder {
  private final String charset;
  
  public BCodec() {
    this("UTF-8");
  }
  
  public BCodec(String paramString) {
    this.charset = paramString;
  }
  
  public Object decode(Object paramObject) throws DecoderException {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof String)
      return decode((String)paramObject); 
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be decoded using BCodec");
  }
  
  public String decode(String paramString) throws DecoderException {
    if (paramString == null)
      return null; 
    try {
      return decodeText(paramString);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new DecoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
    } 
  }
  
  protected byte[] doDecoding(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? null : Base64.decodeBase64(paramArrayOfbyte);
  }
  
  protected byte[] doEncoding(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte == null) ? null : Base64.encodeBase64(paramArrayOfbyte);
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof String)
      return encode((String)paramObject); 
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be encoded using BCodec");
  }
  
  public String encode(String paramString) throws EncoderException {
    return (paramString == null) ? null : encode(paramString, getDefaultCharset());
  }
  
  public String encode(String paramString1, String paramString2) throws EncoderException {
    if (paramString1 == null)
      return null; 
    try {
      return encodeText(paramString1, paramString2);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new EncoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
    } 
  }
  
  public String getDefaultCharset() {
    return this.charset;
  }
  
  protected String getEncoding() {
    return "B";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\net\BCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */