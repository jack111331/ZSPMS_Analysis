package com.zz.lib.org.myapache.commons.codec.binary;

import java.io.OutputStream;

public class Base32OutputStream extends BaseNCodecOutputStream {
  public Base32OutputStream(OutputStream paramOutputStream) {
    this(paramOutputStream, true);
  }
  
  public Base32OutputStream(OutputStream paramOutputStream, boolean paramBoolean) {
    super(paramOutputStream, new Base32(false), paramBoolean);
  }
  
  public Base32OutputStream(OutputStream paramOutputStream, boolean paramBoolean, int paramInt, byte[] paramArrayOfbyte) {
    super(paramOutputStream, new Base32(paramInt, paramArrayOfbyte), paramBoolean);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\binary\Base32OutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */