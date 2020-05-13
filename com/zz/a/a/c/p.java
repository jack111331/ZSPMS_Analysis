package com.zz.a.a.c;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class p {
  private final String b;
  
  private final long[] c;
  
  private boolean d;
  
  private n e;
  
  private long f;
  
  private p(l paraml, String paramString) {
    this.b = paramString;
    this.c = new long[l.e(paraml)];
  }
  
  private void a(String[] paramArrayOfString) {
    if (paramArrayOfString.length != l.e(this.a))
      throw b(paramArrayOfString); 
    byte b = 0;
    try {
      while (b < paramArrayOfString.length) {
        this.c[b] = Long.parseLong(paramArrayOfString[b]);
        b++;
      } 
    } catch (NumberFormatException numberFormatException) {
      throw b(paramArrayOfString);
    } 
  }
  
  private IOException b(String[] paramArrayOfString) {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }
  
  public File a(int paramInt) {
    return new File(l.f(this.a), this.b + "." + paramInt);
  }
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder();
    for (long l1 : this.c)
      stringBuilder.append(' ').append(l1); 
    return stringBuilder.toString();
  }
  
  public File b(int paramInt) {
    return new File(l.f(this.a), this.b + "." + paramInt + ".tmp");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */