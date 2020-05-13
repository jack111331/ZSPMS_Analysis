package com.zz.lib.org.myapache.commons.codec.binary;

import com.zz.lib.org.myapache.commons.codec.BinaryDecoder;
import com.zz.lib.org.myapache.commons.codec.BinaryEncoder;
import com.zz.lib.org.myapache.commons.codec.DecoderException;
import com.zz.lib.org.myapache.commons.codec.EncoderException;

public class BinaryCodec implements BinaryDecoder, BinaryEncoder {
  private static final int[] BITS;
  
  private static final int BIT_0 = 1;
  
  private static final int BIT_1 = 2;
  
  private static final int BIT_2 = 4;
  
  private static final int BIT_3 = 8;
  
  private static final int BIT_4 = 16;
  
  private static final int BIT_5 = 32;
  
  private static final int BIT_6 = 64;
  
  private static final int BIT_7 = 128;
  
  private static final byte[] EMPTY_BYTE_ARRAY;
  
  private static final char[] EMPTY_CHAR_ARRAY = new char[0];
  
  static {
    EMPTY_BYTE_ARRAY = new byte[0];
    BITS = new int[] { 1, 2, 4, 8, 16, 32, 64, 128 };
  }
  
  public static byte[] fromAscii(byte[] paramArrayOfbyte) {
    if (isEmpty(paramArrayOfbyte))
      return EMPTY_BYTE_ARRAY; 
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length >> 3];
    byte b = 0;
    int i = paramArrayOfbyte.length - 1;
    label17: while (true) {
      byte[] arrayOfByte1 = arrayOfByte;
      if (b < arrayOfByte.length) {
        for (byte b1 = 0;; b1++) {
          if (b1 >= BITS.length) {
            b++;
            i -= 8;
            continue label17;
          } 
          if (paramArrayOfbyte[i - b1] == 49)
            arrayOfByte[b] = (byte)(byte)(arrayOfByte[b] | BITS[b1]); 
        } 
        break;
      } 
      return arrayOfByte1;
    } 
  }
  
  public static byte[] fromAscii(char[] paramArrayOfchar) {
    if (paramArrayOfchar == null || paramArrayOfchar.length == 0)
      return EMPTY_BYTE_ARRAY; 
    byte[] arrayOfByte = new byte[paramArrayOfchar.length >> 3];
    byte b = 0;
    int i = paramArrayOfchar.length - 1;
    label18: while (true) {
      byte[] arrayOfByte1 = arrayOfByte;
      if (b < arrayOfByte.length) {
        for (byte b1 = 0;; b1++) {
          if (b1 >= BITS.length) {
            b++;
            i -= 8;
            continue label18;
          } 
          if (paramArrayOfchar[i - b1] == '1')
            arrayOfByte[b] = (byte)(byte)(arrayOfByte[b] | BITS[b1]); 
        } 
        break;
      } 
      return arrayOfByte1;
    } 
  }
  
  private static boolean isEmpty(byte[] paramArrayOfbyte) {
    return !(paramArrayOfbyte != null && paramArrayOfbyte.length != 0);
  }
  
  public static byte[] toAsciiBytes(byte[] paramArrayOfbyte) {
    if (isEmpty(paramArrayOfbyte))
      return EMPTY_BYTE_ARRAY; 
    byte[] arrayOfByte = new byte[paramArrayOfbyte.length << 3];
    byte b = 0;
    int i = arrayOfByte.length - 1;
    label19: while (true) {
      byte[] arrayOfByte1 = arrayOfByte;
      if (b < paramArrayOfbyte.length) {
        for (byte b1 = 0;; b1++) {
          if (b1 >= BITS.length) {
            b++;
            i -= 8;
            continue label19;
          } 
          if ((paramArrayOfbyte[b] & BITS[b1]) == 0) {
            arrayOfByte[i - b1] = (byte)48;
          } else {
            arrayOfByte[i - b1] = (byte)49;
          } 
        } 
        break;
      } 
      return arrayOfByte1;
    } 
  }
  
  public static char[] toAsciiChars(byte[] paramArrayOfbyte) {
    if (isEmpty(paramArrayOfbyte))
      return EMPTY_CHAR_ARRAY; 
    char[] arrayOfChar = new char[paramArrayOfbyte.length << 3];
    byte b = 0;
    int i = arrayOfChar.length - 1;
    label19: while (true) {
      char[] arrayOfChar1 = arrayOfChar;
      if (b < paramArrayOfbyte.length) {
        for (byte b1 = 0;; b1++) {
          if (b1 >= BITS.length) {
            b++;
            i -= 8;
            continue label19;
          } 
          if ((paramArrayOfbyte[b] & BITS[b1]) == 0) {
            arrayOfChar[i - b1] = (char)'0';
          } else {
            arrayOfChar[i - b1] = (char)'1';
          } 
        } 
        break;
      } 
      return arrayOfChar1;
    } 
  }
  
  public static String toAsciiString(byte[] paramArrayOfbyte) {
    return new String(toAsciiChars(paramArrayOfbyte));
  }
  
  public Object decode(Object paramObject) throws DecoderException {
    if (paramObject == null)
      return EMPTY_BYTE_ARRAY; 
    if (paramObject instanceof byte[])
      return fromAscii((byte[])paramObject); 
    if (paramObject instanceof char[])
      return fromAscii((char[])paramObject); 
    if (paramObject instanceof String)
      return fromAscii(((String)paramObject).toCharArray()); 
    throw new DecoderException("argument not a byte array");
  }
  
  public byte[] decode(byte[] paramArrayOfbyte) {
    return fromAscii(paramArrayOfbyte);
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof byte[]))
      throw new EncoderException("argument not a byte array"); 
    return toAsciiChars((byte[])paramObject);
  }
  
  public byte[] encode(byte[] paramArrayOfbyte) {
    return toAsciiBytes(paramArrayOfbyte);
  }
  
  public byte[] toByteArray(String paramString) {
    return (paramString == null) ? EMPTY_BYTE_ARRAY : fromAscii(paramString.toCharArray());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\binary\BinaryCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */