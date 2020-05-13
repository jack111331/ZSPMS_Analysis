package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01393xDecoder extends AI01decoder {
  private static final int FIRST_THREE_DIGITS_SIZE = 10;
  
  private static final int HEADER_SIZE = 8;
  
  private static final int LAST_DIGIT_SIZE = 2;
  
  AI01393xDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  public String parseInformation() throws NotFoundException, FormatException {
    if (getInformation().getSize() >= 48) {
      StringBuilder stringBuilder = new StringBuilder();
      encodeCompressedGtin(stringBuilder, 8);
      int i = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
      stringBuilder.append("(393");
      stringBuilder.append(i);
      stringBuilder.append(')');
      i = getGeneralDecoder().extractNumericValueFromBitArray(50, 10);
      if (i / 100 == 0)
        stringBuilder.append('0'); 
      if (i / 10 == 0)
        stringBuilder.append('0'); 
      stringBuilder.append(i);
      stringBuilder.append(getGeneralDecoder().decodeGeneralPurposeField(60, null).getNewString());
      return stringBuilder.toString();
    } 
    throw NotFoundException.getNotFoundInstance();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01393xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */