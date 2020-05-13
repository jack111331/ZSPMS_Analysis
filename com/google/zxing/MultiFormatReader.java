package com.google.zxing;

import com.google.zxing.aztec.AztecReader;
import com.google.zxing.datamatrix.DataMatrixReader;
import com.google.zxing.maxicode.MaxiCodeReader;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.google.zxing.pdf417.PDF417Reader;
import com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatReader implements Reader {
  private Map<DecodeHintType, ?> hints;
  
  private Reader[] readers;
  
  private Result decodeInternal(BinaryBitmap paramBinaryBitmap) throws NotFoundException {
    if (this.readers != null) {
      Reader[] arrayOfReader = this.readers;
      int i = arrayOfReader.length;
      byte b = 0;
      while (b < i) {
        Reader reader = arrayOfReader[b];
        try {
          return reader.decode(paramBinaryBitmap, this.hints);
        } catch (ReaderException readerException) {
          b++;
        } 
      } 
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap) throws NotFoundException {
    setHints(null);
    return decodeInternal(paramBinaryBitmap);
  }
  
  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    setHints(paramMap);
    return decodeInternal(paramBinaryBitmap);
  }
  
  public Result decodeWithState(BinaryBitmap paramBinaryBitmap) throws NotFoundException {
    if (this.readers == null)
      setHints(null); 
    return decodeInternal(paramBinaryBitmap);
  }
  
  public void reset() {
    if (this.readers != null) {
      Reader[] arrayOfReader = this.readers;
      int i = arrayOfReader.length;
      for (byte b = 0; b < i; b++)
        arrayOfReader[b].reset(); 
    } 
  }
  
  public void setHints(Map<DecodeHintType, ?> paramMap) {
    boolean bool2;
    Collection collection;
    this.hints = paramMap;
    boolean bool1 = true;
    if (paramMap != null && paramMap.containsKey(DecodeHintType.TRY_HARDER)) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramMap == null) {
      collection = null;
    } else {
      collection = (Collection)paramMap.get(DecodeHintType.POSSIBLE_FORMATS);
    } 
    ArrayList<MultiFormatOneDReader> arrayList = new ArrayList();
    if (collection != null) {
      boolean bool = bool1;
      if (!collection.contains(BarcodeFormat.UPC_A)) {
        bool = bool1;
        if (!collection.contains(BarcodeFormat.UPC_E)) {
          bool = bool1;
          if (!collection.contains(BarcodeFormat.EAN_13)) {
            bool = bool1;
            if (!collection.contains(BarcodeFormat.EAN_8)) {
              bool = bool1;
              if (!collection.contains(BarcodeFormat.CODABAR)) {
                bool = bool1;
                if (!collection.contains(BarcodeFormat.CODE_39)) {
                  bool = bool1;
                  if (!collection.contains(BarcodeFormat.CODE_93)) {
                    bool = bool1;
                    if (!collection.contains(BarcodeFormat.CODE_128)) {
                      bool = bool1;
                      if (!collection.contains(BarcodeFormat.ITF)) {
                        bool = bool1;
                        if (!collection.contains(BarcodeFormat.RSS_14))
                          if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                            bool = bool1;
                          } else {
                            bool = false;
                          }  
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
      if (bool && !bool2)
        arrayList.add(new MultiFormatOneDReader(paramMap)); 
      if (collection.contains(BarcodeFormat.QR_CODE))
        arrayList.add(new QRCodeReader()); 
      if (collection.contains(BarcodeFormat.DATA_MATRIX))
        arrayList.add(new DataMatrixReader()); 
      if (collection.contains(BarcodeFormat.AZTEC))
        arrayList.add(new AztecReader()); 
      if (collection.contains(BarcodeFormat.PDF_417))
        arrayList.add(new PDF417Reader()); 
      if (collection.contains(BarcodeFormat.MAXICODE))
        arrayList.add(new MaxiCodeReader()); 
      if (bool && bool2)
        arrayList.add(new MultiFormatOneDReader(paramMap)); 
    } 
    if (arrayList.isEmpty()) {
      if (!bool2)
        arrayList.add(new MultiFormatOneDReader(paramMap)); 
      arrayList.add(new QRCodeReader());
      arrayList.add(new DataMatrixReader());
      arrayList.add(new AztecReader());
      arrayList.add(new PDF417Reader());
      arrayList.add(new MaxiCodeReader());
      if (bool2)
        arrayList.add(new MultiFormatOneDReader(paramMap)); 
    } 
    this.readers = arrayList.<Reader>toArray(new Reader[arrayList.size()]);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\MultiFormatReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */