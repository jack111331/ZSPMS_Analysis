package com.zz.lib.org.myapache.commons.codec.net;

import com.zz.lib.org.myapache.commons.codec.BinaryDecoder;
import com.zz.lib.org.myapache.commons.codec.BinaryEncoder;
import com.zz.lib.org.myapache.commons.codec.DecoderException;
import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringDecoder;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;
import com.zz.lib.org.myapache.commons.codec.binary.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

public class URLCodec implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder {
  protected static final byte ESCAPE_CHAR = 37;
  
  static final int RADIX = 16;
  
  protected static final BitSet WWW_FORM_URL = new BitSet(256);
  
  protected String charset;
  
  static {
    for (byte b = 97;; b++) {
      if (b > 122) {
        for (b = 65;; b++) {
          if (b > 90) {
            for (b = 48;; b++) {
              if (b > 57) {
                WWW_FORM_URL.set(45);
                WWW_FORM_URL.set(95);
                WWW_FORM_URL.set(46);
                WWW_FORM_URL.set(42);
                WWW_FORM_URL.set(32);
                return;
              } 
              WWW_FORM_URL.set(b);
            } 
            break;
          } 
          WWW_FORM_URL.set(b);
        } 
        break;
      } 
      WWW_FORM_URL.set(b);
    } 
  }
  
  public URLCodec() {
    this("UTF-8");
  }
  
  public URLCodec(String paramString) {
    this.charset = paramString;
  }
  
  public static final byte[] decodeUrl(byte[] paramArrayOfbyte) throws DecoderException {
    if (paramArrayOfbyte == null)
      return null; 
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    for (byte b = 0;; b++) {
      if (b >= paramArrayOfbyte.length)
        return byteArrayOutputStream.toByteArray(); 
      byte b1 = paramArrayOfbyte[b];
      if (b1 == 43) {
        byteArrayOutputStream.write(32);
      } else {
        int i;
        if (b1 == 37) {
          b++;
          try {
            i = Utils.digit16(paramArrayOfbyte[b]);
            byteArrayOutputStream.write((char)((i << 4) + Utils.digit16(paramArrayOfbyte[++b])));
            b++;
          } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new DecoderException("Invalid URL encoding: ", arrayIndexOutOfBoundsException);
          } 
          continue;
        } 
        byteArrayOutputStream.write(i);
      } 
    } 
  }
  
  public static final byte[] encodeUrl(BitSet paramBitSet, byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    BitSet bitSet = paramBitSet;
    if (paramBitSet == null)
      bitSet = WWW_FORM_URL; 
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i = paramArrayOfbyte.length;
    for (byte b = 0;; b++) {
      if (b >= i)
        return byteArrayOutputStream.toByteArray(); 
      byte b1 = paramArrayOfbyte[b];
      int j = b1;
      if (b1 < 0)
        j = b1 + 256; 
      if (bitSet.get(j)) {
        int k = j;
        if (j == 32)
          k = 43; 
        byteArrayOutputStream.write(k);
      } else {
        byteArrayOutputStream.write(37);
        char c = Character.toUpperCase(Character.forDigit(j >> 4 & 0xF, 16));
        j = Character.toUpperCase(Character.forDigit(j & 0xF, 16));
        byteArrayOutputStream.write(c);
        byteArrayOutputStream.write(j);
      } 
    } 
  }
  
  public Object decode(Object paramObject) throws DecoderException {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof byte[])
      return decode((byte[])paramObject); 
    if (paramObject instanceof String)
      return decode((String)paramObject); 
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be URL decoded");
  }
  
  public String decode(String paramString) throws DecoderException {
    if (paramString == null)
      return null; 
    try {
      return decode(paramString, getDefaultCharset());
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new DecoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
    } 
  }
  
  public String decode(String paramString1, String paramString2) throws DecoderException, UnsupportedEncodingException {
    return (paramString1 == null) ? null : new String(decode(StringUtils.getBytesUsAscii(paramString1)), paramString2);
  }
  
  public byte[] decode(byte[] paramArrayOfbyte) throws DecoderException {
    return decodeUrl(paramArrayOfbyte);
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof byte[])
      return encode((byte[])paramObject); 
    if (paramObject instanceof String)
      return encode((String)paramObject); 
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be URL encoded");
  }
  
  public String encode(String paramString) throws EncoderException {
    if (paramString == null)
      return null; 
    try {
      return encode(paramString, getDefaultCharset());
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new EncoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
    } 
  }
  
  public String encode(String paramString1, String paramString2) throws UnsupportedEncodingException {
    return (paramString1 == null) ? null : StringUtils.newStringUsAscii(encode(paramString1.getBytes(paramString2)));
  }
  
  public byte[] encode(byte[] paramArrayOfbyte) {
    return encodeUrl(WWW_FORM_URL, paramArrayOfbyte);
  }
  
  public String getDefaultCharset() {
    return this.charset;
  }
  
  public String getEncoding() {
    return this.charset;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\net\URLCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */