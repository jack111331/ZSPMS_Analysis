package com.alibaba.fastjson.util;

import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;

public class ThreadLocalCache {
  public static final int BYTES_CACH_INIT_SIZE = 1024;
  
  public static final int BYTES_CACH_INIT_SIZE_EXP = 10;
  
  public static final int BYTES_CACH_MAX_SIZE = 131072;
  
  public static final int BYTES_CACH_MAX_SIZE_EXP = 17;
  
  public static final int CHARS_CACH_INIT_SIZE = 1024;
  
  public static final int CHARS_CACH_INIT_SIZE_EXP = 10;
  
  public static final int CHARS_CACH_MAX_SIZE = 131072;
  
  public static final int CHARS_CACH_MAX_SIZE_EXP = 17;
  
  private static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal;
  
  private static final ThreadLocal<SoftReference<char[]>> charsBufLocal = new ThreadLocal<SoftReference<char[]>>();
  
  private static final ThreadLocal<CharsetDecoder> decoderLocal = new ThreadLocal<CharsetDecoder>();
  
  static {
    bytesBufLocal = new ThreadLocal<SoftReference<byte[]>>();
  }
  
  private static char[] allocate(int paramInt) {
    if (paramInt > 131072)
      return new char[paramInt]; 
    char[] arrayOfChar = new char[getAllocateLengthExp(10, 17, paramInt)];
    charsBufLocal.set((SoftReference)new SoftReference<char>(arrayOfChar));
    return arrayOfChar;
  }
  
  private static byte[] allocateBytes(int paramInt) {
    if (paramInt > 131072)
      return new byte[paramInt]; 
    byte[] arrayOfByte = new byte[getAllocateLengthExp(10, 17, paramInt)];
    bytesBufLocal.set((SoftReference)new SoftReference<byte>(arrayOfByte));
    return arrayOfByte;
  }
  
  public static void clearBytes() {
    bytesBufLocal.set(null);
  }
  
  public static void clearChars() {
    charsBufLocal.set(null);
  }
  
  private static int getAllocateLengthExp(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt3 >>> paramInt1 <= 0) ? (1 << paramInt1) : (1 << 32 - Integer.numberOfLeadingZeros(paramInt3 - 1));
  }
  
  public static byte[] getBytes(int paramInt) {
    SoftReference<byte[]> softReference = bytesBufLocal.get();
    if (softReference == null)
      return allocateBytes(paramInt); 
    byte[] arrayOfByte2 = softReference.get();
    if (arrayOfByte2 == null)
      return allocateBytes(paramInt); 
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2.length < paramInt)
      arrayOfByte1 = allocateBytes(paramInt); 
    return arrayOfByte1;
  }
  
  public static char[] getChars(int paramInt) {
    SoftReference<char[]> softReference = charsBufLocal.get();
    if (softReference == null)
      return allocate(paramInt); 
    char[] arrayOfChar2 = softReference.get();
    if (arrayOfChar2 == null)
      return allocate(paramInt); 
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2.length < paramInt)
      arrayOfChar1 = allocate(paramInt); 
    return arrayOfChar1;
  }
  
  public static CharsetDecoder getUTF8Decoder() {
    CharsetDecoder charsetDecoder1 = decoderLocal.get();
    CharsetDecoder charsetDecoder2 = charsetDecoder1;
    if (charsetDecoder1 == null) {
      charsetDecoder2 = new UTF8Decoder();
      decoderLocal.set(charsetDecoder2);
    } 
    return charsetDecoder2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjso\\util\ThreadLocalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */