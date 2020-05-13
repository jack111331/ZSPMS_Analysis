package org.jar.mvchelper.task;

public interface ICacheStore {
  Cache getCache(String paramString);
  
  void saveCache(String paramString, long paramLong1, long paramLong2, Object paramObject);
  
  public static class Cache {
    public Object data;
    
    public long requestTime;
    
    public long saveTime;
    
    public Cache() {}
    
    public Cache(long param1Long1, long param1Long2, Object param1Object) {
      this.requestTime = param1Long1;
      this.saveTime = param1Long2;
      this.data = param1Object;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\task\ICacheStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */