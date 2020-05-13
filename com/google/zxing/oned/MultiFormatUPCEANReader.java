package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatUPCEANReader extends OneDReader {
  private final UPCEANReader[] readers;
  
  public MultiFormatUPCEANReader(Map<DecodeHintType, ?> paramMap) {
    Collection collection;
    if (paramMap == null) {
      paramMap = null;
    } else {
      collection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
    } 
    ArrayList<EAN13Reader> arrayList = new ArrayList();
    if (collection != null) {
      if (collection.contains(BarcodeFormat.EAN_13)) {
        arrayList.add(new EAN13Reader());
      } else if (collection.contains(BarcodeFormat.UPC_A)) {
        arrayList.add(new UPCAReader());
      } 
      if (collection.contains(BarcodeFormat.EAN_8))
        arrayList.add(new EAN8Reader()); 
      if (collection.contains(BarcodeFormat.UPC_E))
        arrayList.add(new UPCEReader()); 
    } 
    if (arrayList.isEmpty()) {
      arrayList.add(new EAN13Reader());
      arrayList.add(new EAN8Reader());
      arrayList.add(new UPCEReader());
    } 
    this.readers = arrayList.<UPCEANReader>toArray(new UPCEANReader[arrayList.size()]);
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    int[] arrayOfInt = UPCEANReader.findStartGuardPattern(paramBitArray);
    UPCEANReader[] arrayOfUPCEANReader = this.readers;
    int i = arrayOfUPCEANReader.length;
    byte b = 0;
    while (b < i) {
      UPCEANReader uPCEANReader = arrayOfUPCEANReader[b];
      try {
        Collection collection;
        boolean bool1;
        boolean bool2;
        Result result = uPCEANReader.decodeRow(paramInt, paramBitArray, arrayOfInt, paramMap);
        if (result.getBarcodeFormat() == BarcodeFormat.EAN_13 && result.getText().charAt(0) == '0') {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (paramMap == null) {
          uPCEANReader = null;
        } else {
          collection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
        } 
        if (collection == null || collection.contains(BarcodeFormat.UPC_A)) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if (bool1 && bool2) {
          Result result1 = new Result();
          this(result.getText().substring(1), result.getRawBytes(), result.getResultPoints(), BarcodeFormat.UPC_A);
          result1.putAllMetadata(result.getResultMetadata());
          return result1;
        } 
        return result;
      } catch (ReaderException readerException) {
        b++;
      } 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public void reset() {
    UPCEANReader[] arrayOfUPCEANReader = this.readers;
    int i = arrayOfUPCEANReader.length;
    for (byte b = 0; b < i; b++)
      arrayOfUPCEANReader[b].reset(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\MultiFormatUPCEANReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */