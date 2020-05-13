package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

abstract class AI013x0xDecoder extends AI01weightDecoder {
  private static final int HEADER_SIZE = 5;
  
  private static final int WEIGHT_SIZE = 15;
  
  AI013x0xDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  public String parseInformation() throws NotFoundException {
    if (getInformation().getSize() == 60) {
      StringBuilder stringBuilder = new StringBuilder();
      encodeCompressedGtin(stringBuilder, 5);
      encodeCompressedWeight(stringBuilder, 45, 15);
      return stringBuilder.toString();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI013x0xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */