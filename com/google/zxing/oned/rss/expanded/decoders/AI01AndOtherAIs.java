package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01AndOtherAIs extends AI01decoder {
  private static final int HEADER_SIZE = 4;
  
  AI01AndOtherAIs(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  public String parseInformation() throws NotFoundException, FormatException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(01)");
    int i = stringBuilder.length();
    stringBuilder.append(getGeneralDecoder().extractNumericValueFromBitArray(4, 4));
    encodeCompressedGtinWithoutAI(stringBuilder, 8, i);
    return getGeneralDecoder().decodeAllCodes(stringBuilder, 48);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01AndOtherAIs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */