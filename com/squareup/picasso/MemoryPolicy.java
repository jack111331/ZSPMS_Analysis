package com.squareup.picasso;

public enum MemoryPolicy {
  NO_CACHE(1),
  NO_STORE(2);
  
  final int index;
  
  static {
    $VALUES = new MemoryPolicy[] { NO_CACHE, NO_STORE };
  }
  
  MemoryPolicy(int paramInt1) {
    this.index = paramInt1;
  }
  
  static boolean shouldReadFromMemoryCache(int paramInt) {
    return ((NO_CACHE.index & paramInt) == 0);
  }
  
  static boolean shouldWriteToMemoryCache(int paramInt) {
    return ((NO_STORE.index & paramInt) == 0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\squareup\picasso\MemoryPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */