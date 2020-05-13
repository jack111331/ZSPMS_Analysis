package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.RSS14Reader;
import com.google.zxing.oned.rss.expanded.RSSExpandedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatOneDReader extends OneDReader {
  private final OneDReader[] readers;
  
  public MultiFormatOneDReader(Map<DecodeHintType, ?> paramMap) {
    Collection collection;
    boolean bool;
    if (paramMap == null) {
      collection = null;
    } else {
      collection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
    } 
    if (paramMap != null && paramMap.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    ArrayList<MultiFormatUPCEANReader> arrayList = new ArrayList();
    if (collection != null) {
      if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E))
        arrayList.add(new MultiFormatUPCEANReader(paramMap)); 
      if (collection.contains(BarcodeFormat.CODE_39))
        arrayList.add(new Code39Reader(bool)); 
      if (collection.contains(BarcodeFormat.CODE_93))
        arrayList.add(new Code93Reader()); 
      if (collection.contains(BarcodeFormat.CODE_128))
        arrayList.add(new Code128Reader()); 
      if (collection.contains(BarcodeFormat.ITF))
        arrayList.add(new ITFReader()); 
      if (collection.contains(BarcodeFormat.CODABAR))
        arrayList.add(new CodaBarReader()); 
      if (collection.contains(BarcodeFormat.RSS_14))
        arrayList.add(new RSS14Reader()); 
      if (collection.contains(BarcodeFormat.RSS_EXPANDED))
        arrayList.add(new RSSExpandedReader()); 
    } 
    if (arrayList.isEmpty()) {
      arrayList.add(new MultiFormatUPCEANReader(paramMap));
      arrayList.add(new Code39Reader());
      arrayList.add(new CodaBarReader());
      arrayList.add(new Code93Reader());
      arrayList.add(new Code128Reader());
      arrayList.add(new ITFReader());
      arrayList.add(new RSS14Reader());
      arrayList.add(new RSSExpandedReader());
    } 
    this.readers = arrayList.<OneDReader>toArray(new OneDReader[arrayList.size()]);
  }
  
  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    OneDReader[] arrayOfOneDReader = this.readers;
    int i = arrayOfOneDReader.length;
    byte b = 0;
    while (b < i) {
      OneDReader oneDReader = arrayOfOneDReader[b];
      try {
        return oneDReader.decodeRow(paramInt, paramBitArray, paramMap);
      } catch (ReaderException readerException) {
        b++;
      } 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public void reset() {
    OneDReader[] arrayOfOneDReader = this.readers;
    int i = arrayOfOneDReader.length;
    for (byte b = 0; b < i; b++)
      arrayOfOneDReader[b].reset(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\MultiFormatOneDReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */