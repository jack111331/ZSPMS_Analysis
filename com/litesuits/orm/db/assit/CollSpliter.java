package com.litesuits.orm.db.assit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollSpliter {
  public static <T> int split(Collection<T> paramCollection, int paramInt, Spliter<T> paramSpliter) throws Exception {
    ArrayList<T> arrayList = new ArrayList();
    int i = paramCollection.size();
    byte b = 0;
    if (i <= paramInt) {
      arrayList.addAll(paramCollection);
      paramInt = paramSpliter.oneSplit(arrayList) + 0;
    } else {
      Iterator<T> iterator = paramCollection.iterator();
      byte b1 = 1;
      i = 0;
      while (iterator.hasNext()) {
        T t = iterator.next();
        if (b < b1 * paramInt) {
          arrayList.add(t);
        } else {
          i += paramSpliter.oneSplit(arrayList);
          b1++;
          arrayList.clear();
          arrayList.add(t);
        } 
        b++;
      } 
      if (arrayList.size() > 0) {
        paramInt = paramSpliter.oneSplit(arrayList) + i;
      } else {
        paramInt = i;
      } 
    } 
    return paramInt;
  }
  
  public static interface Spliter<T> {
    int oneSplit(ArrayList<T> param1ArrayList) throws Exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\litesuits\orm\db\assit\CollSpliter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */