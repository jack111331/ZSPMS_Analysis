package com.zz.lib.org.myapache.commons.codec.binary;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BaseNCodecOutputStream extends FilterOutputStream {
  private final BaseNCodec baseNCodec;
  
  private final boolean doEncode;
  
  private final byte[] singleByte = new byte[1];
  
  public BaseNCodecOutputStream(OutputStream paramOutputStream, BaseNCodec paramBaseNCodec, boolean paramBoolean) {
    super(paramOutputStream);
    this.baseNCodec = paramBaseNCodec;
    this.doEncode = paramBoolean;
  }
  
  private void flush(boolean paramBoolean) throws IOException {
    int i = this.baseNCodec.available();
    if (i > 0) {
      byte[] arrayOfByte = new byte[i];
      i = this.baseNCodec.readResults(arrayOfByte, 0, i);
      if (i > 0)
        this.out.write(arrayOfByte, 0, i); 
    } 
    if (paramBoolean)
      this.out.flush(); 
  }
  
  public void close() throws IOException {
    if (this.doEncode) {
      this.baseNCodec.encode(this.singleByte, 0, -1);
    } else {
      this.baseNCodec.decode(this.singleByte, 0, -1);
    } 
    flush();
    this.out.close();
  }
  
  public void flush() throws IOException {
    flush(true);
  }
  
  public void write(int paramInt) throws IOException {
    this.singleByte[0] = (byte)(byte)paramInt;
    write(this.singleByte, 0, 1);
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (paramArrayOfbyte == null)
      throw new NullPointerException(); 
    if (paramInt1 < 0 || paramInt2 < 0)
      throw new IndexOutOfBoundsException(); 
    if (paramInt1 > paramArrayOfbyte.length || paramInt1 + paramInt2 > paramArrayOfbyte.length)
      throw new IndexOutOfBoundsException(); 
    if (paramInt2 > 0) {
      if (this.doEncode) {
        this.baseNCodec.encode(paramArrayOfbyte, paramInt1, paramInt2);
      } else {
        this.baseNCodec.decode(paramArrayOfbyte, paramInt1, paramInt2);
      } 
      flush(false);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\binary\BaseNCodecOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */