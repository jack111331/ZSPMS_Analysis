package com.google.zxing;

import java.util.Map;

public interface Reader {
  Result decode(BinaryBitmap paramBinaryBitmap) throws NotFoundException, ChecksumException, FormatException;
  
  Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException;
  
  void reset();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */