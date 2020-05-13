package com.qiniu.android.dns;

public final class Domain {
  public final String domain;
  
  public final boolean hasCname;
  
  public final boolean hostsFirst;
  
  public final int maxTtl;
  
  public Domain(String paramString) {
    this(paramString, false, false, 0);
  }
  
  public Domain(String paramString, boolean paramBoolean) {
    this(paramString, paramBoolean, false, 0);
  }
  
  public Domain(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    this(paramString, paramBoolean1, paramBoolean2, 0);
  }
  
  public Domain(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
    this.domain = paramString;
    this.hasCname = paramBoolean1;
    this.hostsFirst = paramBoolean2;
    this.maxTtl = paramInt;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\Domain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */