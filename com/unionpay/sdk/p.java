package com.unionpay.sdk;

import java.io.OutputStream;

final class p {
  protected byte[] a = new byte[9];
  
  protected OutputStream b;
  
  p(OutputStream paramOutputStream) {
    this.b = paramOutputStream;
  }
  
  static int b(long paramLong) {
    byte b = 9;
    if (paramLong < -32L) {
      if (paramLong < -32768L) {
        if (paramLong >= -2147483648L)
          b = 5; 
        return b;
      } 
      return (paramLong < -128L) ? 3 : 2;
    } 
    if (paramLong < 128L)
      return 1; 
    if (paramLong < 65536L)
      return (paramLong < 256L) ? 2 : 3; 
    if (paramLong < 4294967296L)
      b = 5; 
    return b;
  }
  
  static int b(String paramString) {
    boolean bool;
    try {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      int i = c(arrayOfByte.length);
      bool = arrayOfByte.length;
      bool += i;
    } catch (Exception exception) {
      bool = false;
    } 
    return bool;
  }
  
  static int c(int paramInt) {
    return (paramInt < 16) ? 1 : ((paramInt < 65536) ? 3 : 5);
  }
  
  private p c(String paramString) {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    e(arrayOfByte.length);
    return a(arrayOfByte);
  }
  
  final p a() {
    this.b.write(-64);
    return this;
  }
  
  final p a(double paramDouble) {
    this.a[0] = (byte)-53;
    long l = Double.doubleToRawLongBits(paramDouble);
    this.a[1] = (byte)(byte)(int)(l >> 56L);
    this.a[2] = (byte)(byte)(int)(l >> 48L);
    this.a[3] = (byte)(byte)(int)(l >> 40L);
    this.a[4] = (byte)(byte)(int)(l >> 32L);
    this.a[5] = (byte)(byte)(int)(l >> 24L);
    this.a[6] = (byte)(byte)(int)(l >> 16L);
    this.a[7] = (byte)(byte)(int)(l >> 8L);
    this.a[8] = (byte)(byte)(int)(l >> 0L);
    this.b.write(this.a, 0, 9);
    return this;
  }
  
  final p a(float paramFloat) {
    this.a[0] = (byte)-54;
    int i = Float.floatToRawIntBits(paramFloat);
    this.a[1] = (byte)(byte)(i >> 24);
    this.a[2] = (byte)(byte)(i >> 16);
    this.a[3] = (byte)(byte)(i >> 8);
    this.a[4] = (byte)(byte)(i >> 0);
    this.b.write(this.a, 0, 5);
    return this;
  }
  
  final p a(int paramInt) {
    if (paramInt < -32) {
      if (paramInt < -32768) {
        this.a[0] = (byte)-46;
        this.a[1] = (byte)(byte)(paramInt >> 24);
        this.a[2] = (byte)(byte)(paramInt >> 16);
        this.a[3] = (byte)(byte)(paramInt >> 8);
        this.a[4] = (byte)(byte)(paramInt >> 0);
        this.b.write(this.a, 0, 5);
        return this;
      } 
      if (paramInt < -128) {
        this.a[0] = (byte)-47;
        this.a[1] = (byte)(byte)(paramInt >> 8);
        this.a[2] = (byte)(byte)(paramInt >> 0);
        this.b.write(this.a, 0, 3);
        return this;
      } 
      this.a[0] = (byte)-48;
      this.a[1] = (byte)(byte)paramInt;
      this.b.write(this.a, 0, 2);
      return this;
    } 
    if (paramInt < 128) {
      this.b.write((byte)paramInt);
      return this;
    } 
    if (paramInt < 256) {
      this.a[0] = (byte)-52;
      this.a[1] = (byte)(byte)paramInt;
      this.b.write(this.a, 0, 2);
      return this;
    } 
    if (paramInt < 65536) {
      this.a[0] = (byte)-51;
      this.a[1] = (byte)(byte)(paramInt >> 8);
      this.a[2] = (byte)(byte)(paramInt >> 0);
      this.b.write(this.a, 0, 3);
      return this;
    } 
    this.a[0] = (byte)-50;
    this.a[1] = (byte)(byte)(paramInt >> 24);
    this.a[2] = (byte)(byte)(paramInt >> 16);
    this.a[3] = (byte)(byte)(paramInt >> 8);
    this.a[4] = (byte)(byte)(paramInt >> 0);
    this.b.write(this.a, 0, 5);
    return this;
  }
  
  final p a(long paramLong) {
    if (paramLong < -32L) {
      if (paramLong < -32768L) {
        if (paramLong < -2147483648L) {
          this.a[0] = (byte)-45;
          this.a[1] = (byte)(byte)(int)(paramLong >> 56L);
          this.a[2] = (byte)(byte)(int)(paramLong >> 48L);
          this.a[3] = (byte)(byte)(int)(paramLong >> 40L);
          this.a[4] = (byte)(byte)(int)(paramLong >> 32L);
          this.a[5] = (byte)(byte)(int)(paramLong >> 24L);
          this.a[6] = (byte)(byte)(int)(paramLong >> 16L);
          this.a[7] = (byte)(byte)(int)(paramLong >> 8L);
          this.a[8] = (byte)(byte)(int)(paramLong >> 0L);
          this.b.write(this.a, 0, 9);
          return this;
        } 
        this.a[0] = (byte)-46;
        this.a[1] = (byte)(byte)(int)(paramLong >> 24L);
        this.a[2] = (byte)(byte)(int)(paramLong >> 16L);
        this.a[3] = (byte)(byte)(int)(paramLong >> 8L);
        this.a[4] = (byte)(byte)(int)(paramLong >> 0L);
        this.b.write(this.a, 0, 5);
        return this;
      } 
      if (paramLong < -128L) {
        this.a[0] = (byte)-47;
        this.a[1] = (byte)(byte)(int)(paramLong >> 8L);
        this.a[2] = (byte)(byte)(int)(paramLong >> 0L);
        this.b.write(this.a, 0, 3);
        return this;
      } 
      this.a[0] = (byte)-48;
      this.a[1] = (byte)(byte)(int)paramLong;
      this.b.write(this.a, 0, 2);
      return this;
    } 
    if (paramLong < 128L) {
      this.b.write((byte)(int)paramLong);
      return this;
    } 
    if (paramLong < 65536L) {
      if (paramLong < 256L) {
        this.a[0] = (byte)-52;
        this.a[1] = (byte)(byte)(int)paramLong;
        this.b.write(this.a, 0, 2);
        return this;
      } 
      this.a[0] = (byte)-51;
      this.a[1] = (byte)(byte)(int)((0xFF00L & paramLong) >> 8L);
      this.a[2] = (byte)(byte)(int)((0xFFL & paramLong) >> 0L);
      this.b.write(this.a, 0, 3);
      return this;
    } 
    if (paramLong < 4294967296L) {
      this.a[0] = (byte)-50;
      this.a[1] = (byte)(byte)(int)((0xFFFFFFFFFF000000L & paramLong) >> 24L);
      this.a[2] = (byte)(byte)(int)((0xFF0000L & paramLong) >> 16L);
      this.a[3] = (byte)(byte)(int)((0xFF00L & paramLong) >> 8L);
      this.a[4] = (byte)(byte)(int)((0xFFL & paramLong) >> 0L);
      this.b.write(this.a, 0, 5);
      return this;
    } 
    this.a[0] = (byte)-49;
    this.a[1] = (byte)(byte)(int)(paramLong >> 56L);
    this.a[2] = (byte)(byte)(int)(paramLong >> 48L);
    this.a[3] = (byte)(byte)(int)(paramLong >> 40L);
    this.a[4] = (byte)(byte)(int)(paramLong >> 32L);
    this.a[5] = (byte)(byte)(int)(paramLong >> 24L);
    this.a[6] = (byte)(byte)(int)(paramLong >> 16L);
    this.a[7] = (byte)(byte)(int)(paramLong >> 8L);
    this.a[8] = (byte)(byte)(int)(paramLong >> 0L);
    this.b.write(this.a, 0, 9);
    return this;
  }
  
  final p a(o paramo) {
    if (paramo == null)
      return a(); 
    paramo.messagePack(this);
    return this;
  }
  
  final p a(String paramString) {
    return (paramString == null) ? c("") : c(paramString);
  }
  
  final p a(boolean paramBoolean) {
    if (paramBoolean) {
      this.b.write(-61);
      return this;
    } 
    this.b.write(-62);
    return this;
  }
  
  final p a(byte[] paramArrayOfbyte) {
    this.b.write(paramArrayOfbyte);
    return this;
  }
  
  final p b(int paramInt) {
    if (paramInt < 16) {
      this.b.write((byte)(paramInt | 0x90));
      return this;
    } 
    if (paramInt < 65536) {
      this.a[0] = (byte)-36;
      this.a[1] = (byte)(byte)(paramInt >> 8);
      this.a[2] = (byte)(byte)(paramInt >> 0);
      this.b.write(this.a, 0, 3);
      return this;
    } 
    this.a[0] = (byte)-35;
    this.a[1] = (byte)(byte)(paramInt >> 24);
    this.a[2] = (byte)(byte)(paramInt >> 16);
    this.a[3] = (byte)(byte)(paramInt >> 8);
    this.a[4] = (byte)(byte)(paramInt >> 0);
    this.b.write(this.a, 0, 5);
    return this;
  }
  
  final p d(int paramInt) {
    if (paramInt < 16) {
      this.b.write((byte)(paramInt | 0x80));
      return this;
    } 
    if (paramInt < 65536) {
      this.a[0] = (byte)-34;
      this.a[1] = (byte)(byte)(paramInt >> 8);
      this.a[2] = (byte)(byte)(paramInt >> 0);
      this.b.write(this.a, 0, 3);
      return this;
    } 
    this.a[0] = (byte)-33;
    this.a[1] = (byte)(byte)(paramInt >> 24);
    this.a[2] = (byte)(byte)(paramInt >> 16);
    this.a[3] = (byte)(byte)(paramInt >> 8);
    this.a[4] = (byte)(byte)(paramInt >> 0);
    this.b.write(this.a, 0, 5);
    return this;
  }
  
  final p e(int paramInt) {
    if (paramInt < 32) {
      this.b.write((byte)(paramInt | 0xA0));
      return this;
    } 
    if (paramInt < 65536) {
      this.a[0] = (byte)-38;
      this.a[1] = (byte)(byte)(paramInt >> 8);
      this.a[2] = (byte)(byte)(paramInt >> 0);
      this.b.write(this.a, 0, 3);
      return this;
    } 
    this.a[0] = (byte)-37;
    this.a[1] = (byte)(byte)(paramInt >> 24);
    this.a[2] = (byte)(byte)(paramInt >> 16);
    this.a[3] = (byte)(byte)(paramInt >> 8);
    this.a[4] = (byte)(byte)(paramInt >> 0);
    this.b.write(this.a, 0, 5);
    return this;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */