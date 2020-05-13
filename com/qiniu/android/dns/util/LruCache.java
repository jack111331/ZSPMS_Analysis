package com.qiniu.android.dns.util;

import java.util.LinkedHashMap;
import java.util.Map;

public final class LruCache<K, V> extends LinkedHashMap<K, V> {
  private int size;
  
  public LruCache() {
    this(256);
  }
  
  public LruCache(int paramInt) {
    super(paramInt, 1.0F, true);
    this.size = paramInt;
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry) {
    boolean bool;
    if (size() > this.size) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\qiniu\android\dn\\util\LruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */