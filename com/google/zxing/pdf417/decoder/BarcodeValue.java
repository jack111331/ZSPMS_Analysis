package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class BarcodeValue {
  private final Map<Integer, Integer> values = new HashMap<Integer, Integer>();
  
  Integer getConfidence(int paramInt) {
    return this.values.get(Integer.valueOf(paramInt));
  }
  
  int[] getValue() {
    ArrayList arrayList = new ArrayList();
    Iterator<Map.Entry> iterator = this.values.entrySet().iterator();
    int i = -1;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      if (((Integer)entry.getValue()).intValue() > i) {
        i = ((Integer)entry.getValue()).intValue();
        arrayList.clear();
        arrayList.add(entry.getKey());
        continue;
      } 
      if (((Integer)entry.getValue()).intValue() == i)
        arrayList.add(entry.getKey()); 
    } 
    return PDF417Common.toIntArray(arrayList);
  }
  
  void setValue(int paramInt) {
    Integer integer1 = this.values.get(Integer.valueOf(paramInt));
    Integer integer2 = integer1;
    if (integer1 == null)
      integer2 = Integer.valueOf(0); 
    int i = integer2.intValue();
    this.values.put(Integer.valueOf(paramInt), Integer.valueOf(i + 1));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\BarcodeValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */