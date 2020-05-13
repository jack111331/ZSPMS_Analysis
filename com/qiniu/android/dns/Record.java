package com.qiniu.android.dns;

public final class Record {
  public static final int TTL_MIN_SECONDS = 600;
  
  public static final int TYPE_A = 1;
  
  public static final int TYPE_CNAME = 5;
  
  public final long timeStamp;
  
  public final int ttl;
  
  public final int type;
  
  public final String value;
  
  public Record(String paramString, int paramInt1, int paramInt2, long paramLong) {
    this.value = paramString;
    this.type = paramInt1;
    paramInt1 = 600;
    if (paramInt2 < 600)
      paramInt2 = paramInt1; 
    this.ttl = paramInt2;
    this.timeStamp = paramLong;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || !(paramObject instanceof Record))
      return false; 
    paramObject = paramObject;
    if (!this.value.equals(((Record)paramObject).value) || this.type != ((Record)paramObject).type || this.ttl != ((Record)paramObject).ttl || this.timeStamp != ((Record)paramObject).timeStamp)
      bool = false; 
    return bool;
  }
  
  public boolean isA() {
    int i = this.type;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return bool;
  }
  
  public boolean isCname() {
    boolean bool;
    if (this.type == 5) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isExpired() {
    return isExpired(System.currentTimeMillis() / 1000L);
  }
  
  public boolean isExpired(long paramLong) {
    boolean bool;
    if (this.timeStamp + this.ttl < paramLong) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dns\Record.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */