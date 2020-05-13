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

public class QuotedPrintableCodec implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder {
  private static final byte ESCAPE_CHAR = 61;
  
  private static final BitSet PRINTABLE_CHARS = new BitSet(256);
  
  private static final byte SPACE = 32;
  
  private static final byte TAB = 9;
  
  private final String charset;
  
  static {
    for (byte b = 33;; b++) {
      if (b > 60) {
        for (b = 62;; b++) {
          if (b > 126) {
            PRINTABLE_CHARS.set(9);
            PRINTABLE_CHARS.set(32);
            return;
          } 
          PRINTABLE_CHARS.set(b);
        } 
        break;
      } 
      PRINTABLE_CHARS.set(b);
    } 
  }
  
  public QuotedPrintableCodec() {
    this("UTF-8");
  }
  
  public QuotedPrintableCodec(String paramString) {
    this.charset = paramString;
  }
  
  public static final byte[] decodeQuotedPrintable(byte[] paramArrayOfbyte) throws DecoderException {
    if (paramArrayOfbyte == null)
      return null; 
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    for (byte b = 0;; b++) {
      if (b >= paramArrayOfbyte.length)
        return byteArrayOutputStream.toByteArray(); 
      int i = paramArrayOfbyte[b];
      if (i == 61) {
        b++;
        try {
          i = Utils.digit16(paramArrayOfbyte[b]);
          byteArrayOutputStream.write((char)((i << 4) + Utils.digit16(paramArrayOfbyte[++b])));
          b++;
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
          throw new DecoderException("Invalid quoted-printable encoding", arrayIndexOutOfBoundsException);
        } 
        continue;
      } 
      byteArrayOutputStream.write(i);
    } 
  }
  
  private static final void encodeQuotedPrintable(int paramInt, ByteArrayOutputStream paramByteArrayOutputStream) {
    paramByteArrayOutputStream.write(61);
    char c = Character.toUpperCase(Character.forDigit(paramInt >> 4 & 0xF, 16));
    paramInt = Character.toUpperCase(Character.forDigit(paramInt & 0xF, 16));
    paramByteArrayOutputStream.write(c);
    paramByteArrayOutputStream.write(paramInt);
  }
  
  public static final byte[] encodeQuotedPrintable(BitSet paramBitSet, byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return null; 
    BitSet bitSet = paramBitSet;
    if (paramBitSet == null)
      bitSet = PRINTABLE_CHARS; 
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
        byteArrayOutputStream.write(j);
      } else {
        encodeQuotedPrintable(j, byteArrayOutputStream);
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
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be quoted-printable decoded");
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
    return decodeQuotedPrintable(paramArrayOfbyte);
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof byte[])
      return encode((byte[])paramObject); 
    if (paramObject instanceof String)
      return encode((String)paramObject); 
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be quoted-printable encoded");
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
    return encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfbyte);
  }
  
  public String getDefaultCharset() {
    return this.charset;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\net\QuotedPrintableCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */