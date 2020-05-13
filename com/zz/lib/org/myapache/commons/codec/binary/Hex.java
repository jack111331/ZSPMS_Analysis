package com.zz.lib.org.myapache.commons.codec.binary;

import com.zz.lib.org.myapache.commons.codec.BinaryDecoder;
import com.zz.lib.org.myapache.commons.codec.BinaryEncoder;
import com.zz.lib.org.myapache.commons.codec.DecoderException;
import com.zz.lib.org.myapache.commons.codec.EncoderException;
import java.io.UnsupportedEncodingException;

public class Hex implements BinaryDecoder, BinaryEncoder {
  public static final String DEFAULT_CHARSET_NAME = "UTF-8";
  
  private static final char[] DIGITS_LOWER = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'a', 'b', 'c', 'd', 'e', 'f' };
  
  private static final char[] DIGITS_UPPER = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  private final String charsetName = "UTF-8";
  
  public Hex() {}
  
  public Hex(String paramString) {}
  
  public static byte[] decodeHex(char[] paramArrayOfchar) throws DecoderException {
    int i = paramArrayOfchar.length;
    if ((i & 0x1) != 0)
      throw new DecoderException("Odd number of characters."); 
    byte[] arrayOfByte = new byte[i >> 1];
    byte b1 = 0;
    byte b2 = 0;
    while (true) {
      if (b2 >= i)
        return arrayOfByte; 
      int j = toDigit(paramArrayOfchar[b2], b2);
      int k = toDigit(paramArrayOfchar[++b2], b2);
      b2++;
      arrayOfByte[b1] = (byte)(byte)((j << 4 | k) & 0xFF);
      b1++;
    } 
  }
  
  public static char[] encodeHex(byte[] paramArrayOfbyte) {
    return encodeHex(paramArrayOfbyte, true);
  }
  
  public static char[] encodeHex(byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (paramBoolean) {
      char[] arrayOfChar1 = DIGITS_LOWER;
      return encodeHex(paramArrayOfbyte, arrayOfChar1);
    } 
    char[] arrayOfChar = DIGITS_UPPER;
    return encodeHex(paramArrayOfbyte, arrayOfChar);
  }
  
  protected static char[] encodeHex(byte[] paramArrayOfbyte, char[] paramArrayOfchar) {
    int i = paramArrayOfbyte.length;
    char[] arrayOfChar = new char[i << 1];
    byte b = 0;
    int j = 0;
    while (true) {
      if (b >= i)
        return arrayOfChar; 
      int k = j + 1;
      arrayOfChar[j] = (char)paramArrayOfchar[(paramArrayOfbyte[b] & 0xF0) >>> 4];
      j = k + 1;
      arrayOfChar[k] = (char)paramArrayOfchar[paramArrayOfbyte[b] & 0xF];
      b++;
    } 
  }
  
  public static String encodeHexString(byte[] paramArrayOfbyte) {
    return new String(encodeHex(paramArrayOfbyte));
  }
  
  protected static int toDigit(char paramChar, int paramInt) throws DecoderException {
    int i = Character.digit(paramChar, 16);
    if (i == -1)
      throw new DecoderException("Illegal hexadecimal character " + paramChar + " at index " + paramInt); 
    return i;
  }
  
  public Object decode(Object paramObject) throws DecoderException {
    try {
      if (paramObject instanceof String) {
        paramObject = ((String)paramObject).toCharArray();
        return decodeHex((char[])paramObject);
      } 
      paramObject = paramObject;
      return decodeHex((char[])paramObject);
    } catch (ClassCastException classCastException) {
      throw new DecoderException(classCastException.getMessage(), classCastException);
    } 
  }
  
  public byte[] decode(byte[] paramArrayOfbyte) throws DecoderException {
    try {
      String str = new String();
      this(paramArrayOfbyte, getCharsetName());
      return decodeHex(str.toCharArray());
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new DecoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
    } 
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    try {
      if (paramObject instanceof String) {
        paramObject = ((String)paramObject).getBytes(getCharsetName());
        return encodeHex((byte[])paramObject);
      } 
      paramObject = paramObject;
      return encodeHex((byte[])paramObject);
    } catch (ClassCastException classCastException) {
      throw new EncoderException(classCastException.getMessage(), classCastException);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new EncoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
    } 
  }
  
  public byte[] encode(byte[] paramArrayOfbyte) {
    return StringUtils.getBytesUnchecked(encodeHexString(paramArrayOfbyte), getCharsetName());
  }
  
  public String getCharsetName() {
    return this.charsetName;
  }
  
  public String toString() {
    return String.valueOf(super.toString()) + "[charsetName=" + this.charsetName + "]";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\binary\Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */