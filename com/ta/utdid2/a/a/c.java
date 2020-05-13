package com.ta.utdid2.a.a;

public class c {
  public static byte[] getBytes(int paramInt) {
    byte b1 = (byte)(paramInt % 256);
    paramInt >>= 8;
    byte b2 = (byte)(paramInt % 256);
    paramInt >>= 8;
    byte b3 = (byte)(paramInt % 256);
    return new byte[] { (byte)((paramInt >> 8) % 256), b3, b2, b1 };
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */