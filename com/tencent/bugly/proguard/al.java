package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class al extends k implements Cloneable {
  private static ArrayList<String> c;
  
  private String a = "";
  
  private ArrayList<String> b = null;
  
  public final void a(i parami) {
    this.a = parami.b(0, true);
    if (c == null) {
      c = new ArrayList<String>();
      c.add("");
    } 
    this.b = (ArrayList<String>)parami.<ArrayList<String>>a(c, 1, false);
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 0);
    if (this.b != null)
      paramj.a(this.b, 1); 
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */