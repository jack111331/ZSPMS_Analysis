package com.zz.a.a.c;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class o extends FilterOutputStream {
  private o(n paramn, OutputStream paramOutputStream) {
    super(paramOutputStream);
  }
  
  public void close() {
    try {
      this.out.close();
    } catch (IOException iOException) {
      n.a(this.a, true);
    } 
  }
  
  public void flush() {
    try {
      this.out.flush();
    } catch (IOException iOException) {
      n.a(this.a, true);
    } 
  }
  
  public void write(int paramInt) {
    try {
      this.out.write(paramInt);
    } catch (IOException iOException) {
      n.a(this.a, true);
    } 
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
    } catch (IOException iOException) {
      n.a(this.a, true);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */