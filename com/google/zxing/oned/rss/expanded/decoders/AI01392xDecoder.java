package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01392xDecoder extends AI01decoder {
  private static final int HEADER_SIZE = 8;
  
  private static final int LAST_DIGIT_SIZE = 2;
  
  AI01392xDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  public String parseInformation() throws NotFoundException, FormatException {
    if (getInformation().getSize() >= 48) {
      StringBuilder stringBuilder = new StringBuilder();
      encodeCompressedGtin(stringBuilder, 8);
      int i = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
      stringBuilder.append("(392");
      stringBuilder.append(i);
      stringBuilder.append(')');
      stringBuilder.append(getGeneralDecoder().decodeGeneralPurposeField(50, null).getNewString());
      return stringBuilder.toString();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01392xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */