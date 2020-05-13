package com.cmic.sso.sdk.utils.a;

import java.io.OutputStream;
import java.io.PushbackInputStream;

public class a extends d {
  private static final char[] b = new char[] { 
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
      'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
      'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
      'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
      'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
      '8', '9', '+', '/' };
  
  private static final byte[] c = new byte[256];
  
  byte[] a = new byte[4];
  
  static {
    byte b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < 'ÿ') {
        c[b2] = (byte)-1;
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < b.length) {
      c[b[b3]] = (byte)(byte)b3;
      b3++;
    } 
  }
  
  protected int a() {
    return 4;
  }
  
  protected void a(PushbackInputStream paramPushbackInputStream, OutputStream paramOutputStream, int paramInt) {
    byte b2;
    int i;
    byte b3;
    byte b1 = -1;
    if (paramInt < 2)
      throw new b("BASE64Decoder: Not enough bytes for an atom."); 
    while (true) {
      int j = paramPushbackInputStream.read();
      if (j == -1)
        throw new c(); 
      if (j != 10 && j != 13) {
        this.a[0] = (byte)(byte)j;
        if (a(paramPushbackInputStream, this.a, 1, paramInt - 1) == -1)
          throw new c(); 
        if (paramInt > 3 && this.a[3] == 61)
          paramInt = 3; 
        if (paramInt > 2 && this.a[2] == 61) {
          byte b = 2;
          break;
        } 
        i = paramInt;
        break;
      } 
    } 
    switch (i) {
      default:
        paramInt = -1;
        b2 = -1;
        b3 = -1;
        switch (i) {
          default:
            return;
          case 2:
            paramOutputStream.write((byte)(b3 << 2 & 0xFC | b2 >>> 4 & 0x3));
          case 3:
            paramOutputStream.write((byte)(b3 << 2 & 0xFC | b2 >>> 4 & 0x3));
            paramOutputStream.write((byte)(b2 << 4 & 0xF0 | paramInt >>> 2 & 0xF));
          case 4:
            break;
        } 
        break;
      case 4:
        b1 = c[this.a[3] & 0xFF];
        paramInt = c[this.a[2] & 0xFF];
        b2 = c[this.a[1] & 0xFF];
        b3 = c[this.a[0] & 0xFF];
        switch (i) {
          default:
            return;
          case 2:
            paramOutputStream.write((byte)(b3 << 2 & 0xFC | b2 >>> 4 & 0x3));
          case 3:
            paramOutputStream.write((byte)(b3 << 2 & 0xFC | b2 >>> 4 & 0x3));
            paramOutputStream.write((byte)(b2 << 4 & 0xF0 | paramInt >>> 2 & 0xF));
          case 4:
            break;
        } 
        break;
      case 3:
        paramInt = c[this.a[2] & 0xFF];
        b2 = c[this.a[1] & 0xFF];
        b3 = c[this.a[0] & 0xFF];
        switch (i) {
          default:
            return;
          case 2:
            paramOutputStream.write((byte)(b3 << 2 & 0xFC | b2 >>> 4 & 0x3));
          case 3:
            paramOutputStream.write((byte)(b3 << 2 & 0xFC | b2 >>> 4 & 0x3));
            paramOutputStream.write((byte)(b2 << 4 & 0xF0 | paramInt >>> 2 & 0xF));
          case 4:
            break;
        } 
        break;
      case 2:
        b2 = c[this.a[1] & 0xFF];
        b3 = c[this.a[0] & 0xFF];
        paramInt = -1;
        switch (i) {
          default:
            return;
          case 2:
            paramOutputStream.write((byte)(b3 << 2 & 0xFC | b2 >>> 4 & 0x3));
          case 3:
            paramOutputStream.write((byte)(b3 << 2 & 0xFC | b2 >>> 4 & 0x3));
            paramOutputStream.write((byte)(b2 << 4 & 0xF0 | paramInt >>> 2 & 0xF));
          case 4:
            break;
        } 
        break;
    } 
    paramOutputStream.write((byte)(b3 << 2 & 0xFC | b2 >>> 4 & 0x3));
    paramOutputStream.write((byte)(b2 << 4 & 0xF0 | paramInt >>> 2 & 0xF));
    paramOutputStream.write((byte)(b1 & 0x3F | paramInt << 6 & 0xC0));
  }
  
  protected int b() {
    return 72;
  }
  
  static {
    byte b3;
    byte b1 = 0;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */