package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class UTF8Decoder extends CharsetDecoder {
  private static final Charset charset = Charset.forName("UTF-8");
  
  public UTF8Decoder() {
    super(charset, 1.0F, 1.0F);
  }
  
  private CoderResult decodeArrayLoop(ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer) {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.arrayOffset() + paramByteBuffer.position();
    int j = paramByteBuffer.arrayOffset() + paramByteBuffer.limit();
    char[] arrayOfChar = paramCharBuffer.array();
    int k = paramCharBuffer.arrayOffset() + paramCharBuffer.position();
    int m = paramCharBuffer.arrayOffset() + paramCharBuffer.limit();
    int n = Math.min(j - i, m - k);
    int i1 = k;
    while (i1 < n + k && arrayOfByte[i] >= 0) {
      arrayOfChar[i1] = (char)(char)arrayOfByte[i];
      i1++;
      i++;
    } 
    while (i < j) {
      n = arrayOfByte[i];
      if (n >= 0) {
        if (i1 >= m)
          return xflow(paramByteBuffer, i, j, paramCharBuffer, i1, 1); 
        k = i1 + 1;
        arrayOfChar[i1] = (char)(char)n;
        i++;
        i1 = k;
        continue;
      } 
      if (n >> 5 == -2) {
        if (j - i < 2 || i1 >= m)
          return xflow(paramByteBuffer, i, j, paramCharBuffer, i1, 2); 
        byte b = arrayOfByte[i + 1];
        if (isMalformed2(n, b))
          return malformed(paramByteBuffer, i, paramCharBuffer, i1, 2); 
        k = i1 + 1;
        arrayOfChar[i1] = (char)(char)(n << 6 ^ b ^ 0xF80);
        i += 2;
        i1 = k;
        continue;
      } 
      if (n >> 4 == -2) {
        if (j - i < 3 || i1 >= m)
          return xflow(paramByteBuffer, i, j, paramCharBuffer, i1, 3); 
        byte b2 = arrayOfByte[i + 1];
        byte b1 = arrayOfByte[i + 2];
        if (isMalformed3(n, b2, b1))
          return malformed(paramByteBuffer, i, paramCharBuffer, i1, 3); 
        k = i1 + 1;
        arrayOfChar[i1] = (char)(char)(n << 12 ^ b2 << 6 ^ b1 ^ 0x1F80);
        i += 3;
        i1 = k;
        continue;
      } 
      if (n >> 3 == -2) {
        if (j - i < 4 || m - i1 < 2)
          return xflow(paramByteBuffer, i, j, paramCharBuffer, i1, 4); 
        byte b2 = arrayOfByte[i + 1];
        byte b1 = arrayOfByte[i + 2];
        byte b3 = arrayOfByte[i + 3];
        k = (n & 0x7) << 18 | (b2 & 0x3F) << 12 | (b1 & 0x3F) << 6 | b3 & 0x3F;
        if (isMalformed4(b2, b1, b3) || !Surrogate.neededFor(k))
          return malformed(paramByteBuffer, i, paramCharBuffer, i1, 4); 
        n = i1 + 1;
        arrayOfChar[i1] = Surrogate.high(k);
        i1 = n + 1;
        arrayOfChar[n] = Surrogate.low(k);
        i += 4;
        continue;
      } 
      return malformed(paramByteBuffer, i, paramCharBuffer, i1, 1);
    } 
    return xflow(paramByteBuffer, i, j, paramCharBuffer, i1, 0);
  }
  
  private static boolean isMalformed2(int paramInt1, int paramInt2) {
    return ((paramInt1 & 0x1E) == 0 || (paramInt2 & 0xC0) != 128);
  }
  
  private static boolean isMalformed3(int paramInt1, int paramInt2, int paramInt3) {
    return ((paramInt1 == -32 && (paramInt2 & 0xE0) == 128) || (paramInt2 & 0xC0) != 128 || (paramInt3 & 0xC0) != 128);
  }
  
  private static boolean isMalformed4(int paramInt1, int paramInt2, int paramInt3) {
    return ((paramInt1 & 0xC0) != 128 || (paramInt2 & 0xC0) != 128 || (paramInt3 & 0xC0) != 128);
  }
  
  private static boolean isNotContinuation(int paramInt) {
    boolean bool;
    if ((paramInt & 0xC0) != 128) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private static CoderResult lookupN(ByteBuffer paramByteBuffer, int paramInt) {
    for (byte b = 1; b < paramInt; b++) {
      if (isNotContinuation(paramByteBuffer.get()))
        return CoderResult.malformedForLength(b); 
    } 
    return CoderResult.malformedForLength(paramInt);
  }
  
  private static CoderResult malformed(ByteBuffer paramByteBuffer, int paramInt1, CharBuffer paramCharBuffer, int paramInt2, int paramInt3) {
    paramByteBuffer.position(paramInt1 - paramByteBuffer.arrayOffset());
    CoderResult coderResult = malformedN(paramByteBuffer, paramInt3);
    updatePositions(paramByteBuffer, paramInt1, paramCharBuffer, paramInt2);
    return coderResult;
  }
  
  public static CoderResult malformedN(ByteBuffer paramByteBuffer, int paramInt) {
    byte b;
    int i = 2;
    switch (paramInt) {
      default:
        throw new IllegalStateException();
      case 4:
        i = paramByteBuffer.get() & 0xFF;
        paramInt = paramByteBuffer.get() & 0xFF;
        return (i > 244 || (i == 240 && (paramInt < 144 || paramInt > 191)) || (i == 244 && (paramInt & 0xF0) != 128) || isNotContinuation(paramInt)) ? CoderResult.malformedForLength(1) : (isNotContinuation(paramByteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3));
      case 3:
        paramInt = paramByteBuffer.get();
        b = paramByteBuffer.get();
        if (paramInt != -32 || (b & 0xE0) != 128) {
          paramInt = i;
          if (isNotContinuation(b)) {
            paramInt = 1;
            return CoderResult.malformedForLength(paramInt);
          } 
          return CoderResult.malformedForLength(paramInt);
        } 
        paramInt = 1;
        return CoderResult.malformedForLength(paramInt);
      case 2:
        return CoderResult.malformedForLength(1);
      case 1:
        break;
    } 
    paramInt = paramByteBuffer.get();
    return (paramInt >> 2 == -2) ? ((paramByteBuffer.remaining() < 4) ? CoderResult.UNDERFLOW : lookupN(paramByteBuffer, 5)) : ((paramInt >> 1 == -2) ? ((paramByteBuffer.remaining() < 5) ? CoderResult.UNDERFLOW : lookupN(paramByteBuffer, 6)) : CoderResult.malformedForLength(1));
  }
  
  static void updatePositions(Buffer paramBuffer1, int paramInt1, Buffer paramBuffer2, int paramInt2) {
    paramBuffer1.position(paramInt1);
    paramBuffer2.position(paramInt2);
  }
  
  private static CoderResult xflow(Buffer paramBuffer1, int paramInt1, int paramInt2, Buffer paramBuffer2, int paramInt3, int paramInt4) {
    updatePositions(paramBuffer1, paramInt1, paramBuffer2, paramInt3);
    return (paramInt4 == 0 || paramInt2 - paramInt1 < paramInt4) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
  }
  
  protected CoderResult decodeLoop(ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer) {
    return decodeArrayLoop(paramByteBuffer, paramCharBuffer);
  }
  
  private static class Surrogate {
    public static final int UCS4_MAX = 1114111;
    
    public static final int UCS4_MIN = 65536;
    
    public static char high(int param1Int) {
      return (char)(param1Int - 65536 >> 10 & 0x3FF | 0xD800);
    }
    
    public static char low(int param1Int) {
      return (char)(param1Int - 65536 & 0x3FF | 0xDC00);
    }
    
    public static boolean neededFor(int param1Int) {
      boolean bool;
      if (param1Int >= 65536 && param1Int <= 1114111) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjso\\util\UTF8Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */