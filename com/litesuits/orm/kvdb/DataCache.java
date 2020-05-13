package com.litesuits.orm.kvdb;

import java.util.List;

public interface DataCache<K, V> {
  Object delete(K paramK);
  
  List<V> query(String paramString);
  
  Object save(K paramK, V paramV);
  
  Object update(K paramK, V paramV);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\kvdb\DataCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */