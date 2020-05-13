package org.jar.mvchelper.task;

public interface ICacheConfig<DATA> {
  String getTaskKey(Object paramObject);
  
  boolean isNeedSave(Object paramObject, long paramLong1, long paramLong2, DATA paramDATA);
  
  boolean isUsefulCacheData(Object paramObject, long paramLong1, long paramLong2, DATA paramDATA);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\task\ICacheConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */