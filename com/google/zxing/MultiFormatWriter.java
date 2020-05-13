package com.google.zxing;

import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

public final class MultiFormatWriter implements Writer {
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2) throws WriterException {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) throws WriterException {
    AztecWriter aztecWriter;
    DataMatrixWriter dataMatrixWriter;
    CodaBarWriter codaBarWriter;
    PDF417Writer pDF417Writer;
    ITFWriter iTFWriter;
    Code128Writer code128Writer;
    Code93Writer code93Writer;
    Code39Writer code39Writer;
    QRCodeWriter qRCodeWriter;
    UPCAWriter uPCAWriter;
    EAN13Writer eAN13Writer;
    UPCEWriter uPCEWriter;
    switch (paramBarcodeFormat) {
      default:
        throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(paramBarcodeFormat)));
      case AZTEC:
        aztecWriter = new AztecWriter();
        return aztecWriter.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case DATA_MATRIX:
        dataMatrixWriter = new DataMatrixWriter();
        return dataMatrixWriter.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case CODABAR:
        codaBarWriter = new CodaBarWriter();
        return codaBarWriter.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case PDF_417:
        pDF417Writer = new PDF417Writer();
        return pDF417Writer.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case ITF:
        iTFWriter = new ITFWriter();
        return iTFWriter.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case CODE_128:
        code128Writer = new Code128Writer();
        return code128Writer.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case CODE_93:
        code93Writer = new Code93Writer();
        return code93Writer.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case CODE_39:
        code39Writer = new Code39Writer();
        return code39Writer.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case QR_CODE:
        qRCodeWriter = new QRCodeWriter();
        return qRCodeWriter.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case UPC_A:
        uPCAWriter = new UPCAWriter();
        return uPCAWriter.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case EAN_13:
        eAN13Writer = new EAN13Writer();
        return eAN13Writer.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case UPC_E:
        uPCEWriter = new UPCEWriter();
        return uPCEWriter.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
      case EAN_8:
        break;
    } 
    EAN8Writer eAN8Writer = new EAN8Writer();
    return eAN8Writer.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\MultiFormatWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */