package com.zz.lib.org.myapache.commons.codec.net;

import com.zz.lib.org.myapache.commons.codec.DecoderException;
import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringDecoder;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

public class QCodec extends RFC1522Codec implements StringDecoder, StringEncoder {
  private static final byte BLANK = 32;
  
  private static final BitSet PRINTABLE_CHARS = new BitSet(256);
  
  private static final byte UNDERSCORE = 95;
  
  private final String charset;
  
  private boolean encodeBlanks = false;
  
  static {
    PRINTABLE_CHARS.set(32);
    PRINTABLE_CHARS.set(33);
    PRINTABLE_CHARS.set(34);
    PRINTABLE_CHARS.set(35);
    PRINTABLE_CHARS.set(36);
    PRINTABLE_CHARS.set(37);
    PRINTABLE_CHARS.set(38);
    PRINTABLE_CHARS.set(39);
    PRINTABLE_CHARS.set(40);
    PRINTABLE_CHARS.set(41);
    PRINTABLE_CHARS.set(42);
    PRINTABLE_CHARS.set(43);
    PRINTABLE_CHARS.set(44);
    PRINTABLE_CHARS.set(45);
    PRINTABLE_CHARS.set(46);
    PRINTABLE_CHARS.set(47);
    for (byte b = 48;; b++) {
      if (b > 57) {
        PRINTABLE_CHARS.set(58);
        PRINTABLE_CHARS.set(59);
        PRINTABLE_CHARS.set(60);
        PRINTABLE_CHARS.set(62);
        PRINTABLE_CHARS.set(64);
        for (b = 65;; b++) {
          if (b > 90) {
            PRINTABLE_CHARS.set(91);
            PRINTABLE_CHARS.set(92);
            PRINTABLE_CHARS.set(93);
            PRINTABLE_CHARS.set(94);
            PRINTABLE_CHARS.set(96);
            for (b = 97;; b++) {
              if (b > 122) {
                PRINTABLE_CHARS.set(123);
                PRINTABLE_CHARS.set(124);
                PRINTABLE_CHARS.set(125);
                PRINTABLE_CHARS.set(126);
                return;
              } 
              PRINTABLE_CHARS.set(b);
            } 
            break;
          } 
          PRINTABLE_CHARS.set(b);
        } 
        break;
      } 
      PRINTABLE_CHARS.set(b);
    } 
  }
  
  public QCodec() {
    this("UTF-8");
  }
  
  public QCodec(String paramString) {
    this.charset = paramString;
  }
  
  public Object decode(Object paramObject) throws DecoderException {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof String)
      return decode((String)paramObject); 
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be decoded using Q codec");
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
  
  protected byte[] doDecoding(byte[] paramArrayOfbyte) throws DecoderException {
    if (paramArrayOfbyte == null)
      return null; 
    byte b1 = 0;
    int i = paramArrayOfbyte.length;
    byte b2 = 0;
    while (true) {
      if (b2 >= i) {
        b2 = b1;
      } else if (paramArrayOfbyte[b2] == 95) {
        b2 = 1;
      } else {
        b2++;
        continue;
      } 
      if (b2 != 0) {
        byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
        for (b2 = 0;; b2++) {
          if (b2 >= paramArrayOfbyte.length)
            return QuotedPrintableCodec.decodeQuotedPrintable(arrayOfByte); 
          b1 = paramArrayOfbyte[b2];
          if (b1 != 95) {
            arrayOfByte[b2] = (byte)b1;
          } else {
            arrayOfByte[b2] = (byte)32;
          } 
        } 
        break;
      } 
      paramArrayOfbyte = QuotedPrintableCodec.decodeQuotedPrintable(paramArrayOfbyte);
      // Byte code: goto -> 6
    } 
  }
  
  protected byte[] doEncoding(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    byte[] arrayOfByte = QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfbyte);
    paramArrayOfbyte = arrayOfByte;
    if (this.encodeBlanks) {
      byte b = 0;
      while (true) {
        paramArrayOfbyte = arrayOfByte;
        if (b < arrayOfByte.length) {
          if (arrayOfByte[b] == 32)
            arrayOfByte[b] = (byte)95; 
          b++;
          continue;
        } 
        return paramArrayOfbyte;
      } 
    } 
    return paramArrayOfbyte;
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof String)
      return encode((String)paramObject); 
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be encoded using Q codec");
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
    return "Q";
  }
  
  public boolean isEncodeBlanks() {
    return this.encodeBlanks;
  }
  
  public void setEncodeBlanks(boolean paramBoolean) {
    this.encodeBlanks = paramBoolean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\net\QCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */