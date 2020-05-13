package com.zz.a.a.c;

import java.io.Closeable;
import java.io.InputStream;

public final class q implements Closeable {
  private final String b;
  
  private final long c;
  
  private final InputStream[] d;
  
  private q(l paraml, String paramString, long paramLong, InputStream[] paramArrayOfInputStream) {
    this.b = paramString;
    this.c = paramLong;
    this.d = paramArrayOfInputStream;
  }
  
  public n a() {
    return l.a(this.a, this.b, this.c);
  }
  
  public InputStream a(int paramInt) {
    return this.d[paramInt];
  }
  
  public String b(int paramInt) {
    return l.b(a(paramInt));
  }
  
  public void close() {
    InputStream[] arrayOfInputStream = this.d;
    int i = arrayOfInputStream.length;
    for (byte b = 0; b < i; b++)
      l.a(arrayOfInputStream[b]); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */