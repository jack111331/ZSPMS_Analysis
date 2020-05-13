package com.zz.lib.org.myapache.commons.codec.net;

import com.zz.lib.org.myapache.commons.codec.DecoderException;
import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.binary.StringUtils;
import java.io.UnsupportedEncodingException;

abstract class RFC1522Codec {
  protected static final String POSTFIX = "?=";
  
  protected static final String PREFIX = "=?";
  
  protected static final char SEP = '?';
  
  protected String decodeText(String paramString) throws DecoderException, UnsupportedEncodingException {
    if (paramString == null)
      return null; 
    if (!paramString.startsWith("=?") || !paramString.endsWith("?="))
      throw new DecoderException("RFC 1522 violation: malformed encoded content"); 
    int i = paramString.length() - 2;
    int j = paramString.indexOf('?', 2);
    if (j == i)
      throw new DecoderException("RFC 1522 violation: charset token not found"); 
    String str1 = paramString.substring(2, j);
    if (str1.equals(""))
      throw new DecoderException("RFC 1522 violation: charset not specified"); 
    int k = paramString.indexOf('?', ++j);
    if (k == i)
      throw new DecoderException("RFC 1522 violation: encoding token not found"); 
    String str2 = paramString.substring(j, k);
    if (!getEncoding().equalsIgnoreCase(str2))
      throw new DecoderException("This codec cannot decode " + str2 + " encoded content"); 
    i = k + 1;
    return new String(doDecoding(StringUtils.getBytesUsAscii(paramString.substring(i, paramString.indexOf('?', i)))), str1);
  }
  
  protected abstract byte[] doDecoding(byte[] paramArrayOfbyte) throws DecoderException;
  
  protected abstract byte[] doEncoding(byte[] paramArrayOfbyte) throws EncoderException;
  
  protected String encodeText(String paramString1, String paramString2) throws EncoderException, UnsupportedEncodingException {
    if (paramString1 == null)
      return null; 
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("=?");
    stringBuffer.append(paramString2);
    stringBuffer.append('?');
    stringBuffer.append(getEncoding());
    stringBuffer.append('?');
    stringBuffer.append(StringUtils.newStringUsAscii(doEncoding(paramString1.getBytes(paramString2))));
    stringBuffer.append("?=");
    return stringBuffer.toString();
  }
  
  protected abstract String getEncoding();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\net\RFC1522Codec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */