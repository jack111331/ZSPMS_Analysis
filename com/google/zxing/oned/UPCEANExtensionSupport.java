package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;

final class UPCEANExtensionSupport {
  private static final int[] EXTENSION_START_PATTERN = new int[] { 1, 1, 2 };
  
  private final UPCEANExtension5Support fiveSupport = new UPCEANExtension5Support();
  
  private final UPCEANExtension2Support twoSupport = new UPCEANExtension2Support();
  
  Result decodeRow(int paramInt1, BitArray paramBitArray, int paramInt2) throws NotFoundException {
    int[] arrayOfInt = UPCEANReader.findGuardPattern(paramBitArray, paramInt2, false, EXTENSION_START_PATTERN);
    try {
      return this.fiveSupport.decodeRow(paramInt1, paramBitArray, arrayOfInt);
    } catch (ReaderException readerException) {
      return this.twoSupport.decodeRow(paramInt1, paramBitArray, arrayOfInt);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\UPCEANExtensionSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */