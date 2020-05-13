package com.herosdk.bean;

import java.io.Serializable;

public class e implements Serializable {
  private static final long a = -9141055309447435215L;
  
  private Boolean b;
  
  private String c;
  
  private Boolean d = Boolean.valueOf(false);
  
  public e(Boolean paramBoolean, String paramString) {
    this.b = paramBoolean;
    this.c = paramString;
  }
  
  public e(Boolean paramBoolean1, String paramString, Boolean paramBoolean2) {
    this.b = paramBoolean1;
    this.c = paramString;
    this.d = paramBoolean2;
  }
  
  public Boolean a() {
    return this.b;
  }
  
  public void a(Boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public void a(String paramString) {
    this.c = paramString;
  }
  
  public String b() {
    return this.c;
  }
  
  public void b(Boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public Boolean c() {
    return this.d;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\bean\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */