package com.zz.sdk.e;

import java.util.Date;

class ei {
  String a;
  
  String b;
  
  long c;
  
  public StringBuilder a(StringBuilder paramStringBuilder) {
    paramStringBuilder.append("From:");
    paramStringBuilder.append(this.a);
    paramStringBuilder.append("\nTime:");
    paramStringBuilder.append((new Date(this.c)).toLocaleString());
    paramStringBuilder.append("\nMessage:");
    paramStringBuilder.append(this.b);
    return paramStringBuilder;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\ei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */