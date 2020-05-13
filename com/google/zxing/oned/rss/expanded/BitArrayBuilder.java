package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.List;

final class BitArrayBuilder {
  static BitArray buildBitArray(List<ExpandedPair> paramList) {
    int i = (paramList.size() << 1) - 1;
    int j = i;
    if (((ExpandedPair)paramList.get(paramList.size() - 1)).getRightChar() == null)
      j = i - 1; 
    BitArray bitArray = new BitArray(j * 12);
    int k = ((ExpandedPair)paramList.get(0)).getRightChar().getValue();
    i = 11;
    j = 0;
    while (i >= 0) {
      if ((1 << i & k) != 0)
        bitArray.set(j); 
      j++;
      i--;
    } 
    for (k = 1; k < paramList.size(); k++) {
      ExpandedPair expandedPair = paramList.get(k);
      int m = expandedPair.getLeftChar().getValue();
      for (i = 11; i >= 0; i--) {
        if ((1 << i & m) != 0)
          bitArray.set(j); 
        j++;
      } 
      i = j;
      if (expandedPair.getRightChar() != null) {
        int n = expandedPair.getRightChar().getValue();
        m = 11;
        while (true) {
          i = j;
          if (m >= 0) {
            if ((1 << m & n) != 0)
              bitArray.set(j); 
            j++;
            m--;
            continue;
          } 
          break;
        } 
      } 
      j = i;
    } 
    return bitArray;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\BitArrayBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */