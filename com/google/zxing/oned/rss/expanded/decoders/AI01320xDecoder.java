package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI01320xDecoder extends AI013x0xDecoder {
  AI01320xDecoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  protected void addWeightCode(StringBuilder paramStringBuilder, int paramInt) {
    if (paramInt < 10000) {
      paramStringBuilder.append("(3202)");
      return;
    } 
    paramStringBuilder.append("(3203)");
  }
  
  protected int checkWeight(int paramInt) {
    return (paramInt < 10000) ? paramInt : (paramInt - 10000);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01320xDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */