package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public abstract class AbstractExpandedDecoder {
  private final GeneralAppIdDecoder generalDecoder;
  
  private final BitArray information;
  
  AbstractExpandedDecoder(BitArray paramBitArray) {
    this.information = paramBitArray;
    this.generalDecoder = new GeneralAppIdDecoder(paramBitArray);
  }
  
  public static AbstractExpandedDecoder createDecoder(BitArray paramBitArray) {
    if (paramBitArray.get(1))
      return new AI01AndOtherAIs(paramBitArray); 
    if (!paramBitArray.get(2))
      return new AnyAIDecoder(paramBitArray); 
    switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(paramBitArray, 1, 4)) {
      default:
        switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(paramBitArray, 1, 5)) {
          default:
            switch (GeneralAppIdDecoder.extractNumericValueFromBitArray(paramBitArray, 1, 7)) {
              default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(paramBitArray)));
              case 63:
                return new AI013x0x1xDecoder(paramBitArray, "320", "17");
              case 62:
                return new AI013x0x1xDecoder(paramBitArray, "310", "17");
              case 61:
                return new AI013x0x1xDecoder(paramBitArray, "320", "15");
              case 60:
                return new AI013x0x1xDecoder(paramBitArray, "310", "15");
              case 59:
                return new AI013x0x1xDecoder(paramBitArray, "320", "13");
              case 58:
                return new AI013x0x1xDecoder(paramBitArray, "310", "13");
              case 57:
                return new AI013x0x1xDecoder(paramBitArray, "320", "11");
              case 56:
                break;
            } 
            return new AI013x0x1xDecoder(paramBitArray, "310", "11");
          case 13:
            return new AI01393xDecoder(paramBitArray);
          case 12:
            break;
        } 
        return new AI01392xDecoder(paramBitArray);
      case 5:
        return new AI01320xDecoder(paramBitArray);
      case 4:
        break;
    } 
    return new AI013103decoder(paramBitArray);
  }
  
  protected final GeneralAppIdDecoder getGeneralDecoder() {
    return this.generalDecoder;
  }
  
  protected final BitArray getInformation() {
    return this.information;
  }
  
  public abstract String parseInformation() throws NotFoundException, FormatException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AbstractExpandedDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */