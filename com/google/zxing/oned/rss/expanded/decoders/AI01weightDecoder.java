package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01weightDecoder extends AI01decoder {
  AI01weightDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  protected abstract void addWeightCode(StringBuilder paramStringBuilder, int paramInt);
  
  protected abstract int checkWeight(int paramInt);
  
  final void encodeCompressedWeight(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
    paramInt1 = getGeneralDecoder().extractNumericValueFromBitArray(paramInt1, paramInt2);
    addWeightCode(paramStringBuilder, paramInt1);
    int i = checkWeight(paramInt1);
    paramInt1 = 100000;
    for (paramInt2 = 0; paramInt2 < 5; paramInt2++) {
      if (i / paramInt1 == 0)
        paramStringBuilder.append('0'); 
      paramInt1 /= 10;
    } 
    paramStringBuilder.append(i);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01weightDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */