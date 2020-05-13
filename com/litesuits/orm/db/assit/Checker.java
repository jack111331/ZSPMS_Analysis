package com.litesuits.orm.db.assit;

import java.util.Collection;
import java.util.Map;

public class Checker {
  public static boolean isEmpty(CharSequence paramCharSequence) {
    return (isNull(paramCharSequence) || paramCharSequence.length() == 0);
  }
  
  public static boolean isEmpty(Collection<?> paramCollection) {
    return (isNull(paramCollection) || paramCollection.isEmpty());
  }
  
  public static boolean isEmpty(Map<?, ?> paramMap) {
    return (isNull(paramMap) || paramMap.isEmpty());
  }
  
  public static boolean isEmpty(Object[] paramArrayOfObject) {
    return (isNull(paramArrayOfObject) || paramArrayOfObject.length == 0);
  }
  
  public static boolean isNull(Object paramObject) {
    boolean bool;
    if (paramObject == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\assit\Checker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */