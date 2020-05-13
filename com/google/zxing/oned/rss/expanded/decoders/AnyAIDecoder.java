package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AnyAIDecoder extends AbstractExpandedDecoder {
  private static final int HEADER_SIZE = 5;
  
  AnyAIDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  public String parseInformation() throws NotFoundException, FormatException {
    StringBuilder stringBuilder = new StringBuilder();
    return getGeneralDecoder().decodeAllCodes(stringBuilder, 5);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AnyAIDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */