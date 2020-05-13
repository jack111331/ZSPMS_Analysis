package com.tencent.bugly.proguard;

import java.io.Serializable;

public abstract class k implements Serializable {
  public abstract void a(i parami);
  
  public abstract void a(j paramj);
  
  public abstract void a(StringBuilder paramStringBuilder, int paramInt);
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    a(stringBuilder, 0);
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */