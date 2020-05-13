package com.zz.lib.org.myapache.commons.codec.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BaseNCodecInputStream extends FilterInputStream {
  private final BaseNCodec baseNCodec;
  
  private final boolean doEncode;
  
  private final byte[] singleByte = new byte[1];
  
  protected BaseNCodecInputStream(InputStream paramInputStream, BaseNCodec paramBaseNCodec, boolean paramBoolean) {
    super(paramInputStream);
    this.doEncode = paramBoolean;
    this.baseNCodec = paramBaseNCodec;
  }
  
  public boolean markSupported() {
    return false;
  }
  
  public int read() throws IOException {
    int i = read(this.singleByte, 0, 1);
    while (true) {
      if (i != 0) {
        if (i > 0)
          return (this.singleByte[0] < 0) ? (this.singleByte[0] + 256) : this.singleByte[0]; 
      } else {
        i = read(this.singleByte, 0, 1);
        continue;
      } 
      return -1;
    } 
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (paramArrayOfbyte == null)
      throw new NullPointerException(); 
    if (paramInt1 < 0 || paramInt2 < 0)
      throw new IndexOutOfBoundsException(); 
    if (paramInt1 > paramArrayOfbyte.length || paramInt1 + paramInt2 > paramArrayOfbyte.length)
      throw new IndexOutOfBoundsException(); 
    if (paramInt2 == 0)
      return 0; 
    int i = 0;
    while (true) {
      int j = i;
      if (!i) {
        if (!this.baseNCodec.hasData()) {
          if (this.doEncode) {
            i = 4096;
          } else {
            i = 8192;
          } 
          byte[] arrayOfByte = new byte[i];
          i = this.in.read(arrayOfByte);
          if (this.doEncode) {
            this.baseNCodec.encode(arrayOfByte, 0, i);
          } else {
            this.baseNCodec.decode(arrayOfByte, 0, i);
          } 
        } 
        i = this.baseNCodec.readResults(paramArrayOfbyte, paramInt1, paramInt2);
        continue;
      } 
      return j;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\binary\BaseNCodecInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */