package org.jar.mvchelper.task.imp;

import org.jar.mvchelper.task.ICacheStore;
import org.jar.support.v4.util.LruCache;

public class MemoryCacheStore implements ICacheStore {
  private LruCache<String, ICacheStore.Cache> lruCache;
  
  public MemoryCacheStore(int paramInt) {
    this.lruCache = new LruCache<String, ICacheStore.Cache>(paramInt) {
        protected int sizeOf(String param1String, ICacheStore.Cache param1Cache) {
          return 1;
        }
      };
  }
  
  public ICacheStore.Cache getCache(String paramString) {
    return (ICacheStore.Cache)this.lruCache.get(paramString);
  }
  
  public void saveCache(String paramString, long paramLong1, long paramLong2, Object paramObject) {
    this.lruCache.put(paramString, new ICacheStore.Cache(paramLong1, paramLong2, paramObject));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\task\imp\MemoryCacheStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */