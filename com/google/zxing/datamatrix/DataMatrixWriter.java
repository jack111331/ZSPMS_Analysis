package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

public final class DataMatrixWriter implements Writer {
  private static BitMatrix convertByteMatrixToBitMatrix(ByteMatrix paramByteMatrix, int paramInt1, int paramInt2) {
    BitMatrix bitMatrix;
    int i = paramByteMatrix.getWidth();
    int j = paramByteMatrix.getHeight();
    int k = Math.max(paramInt1, i);
    int m = Math.max(paramInt2, j);
    int n = Math.min(k / i, m / j);
    k = (k - i * n) / 2;
    m = (m - j * n) / 2;
    if (paramInt2 < j || paramInt1 < i) {
      bitMatrix = new BitMatrix(i, j);
      paramInt1 = 0;
      paramInt2 = 0;
    } else {
      bitMatrix = new BitMatrix(paramInt1, paramInt2);
      paramInt1 = k;
      paramInt2 = m;
    } 
    bitMatrix.clear();
    k = 0;
    while (k < j) {
      int i1 = paramInt1;
      m = 0;
      while (m < i) {
        if (paramByteMatrix.get(m, k) == 1)
          bitMatrix.setRegion(i1, paramInt2, n, n); 
        m++;
        i1 += n;
      } 
      k++;
      paramInt2 += n;
    } 
    return bitMatrix;
  }
  
  private static BitMatrix encodeLowLevel(DefaultPlacement paramDefaultPlacement, SymbolInfo paramSymbolInfo, int paramInt1, int paramInt2) {
    int i = paramSymbolInfo.getSymbolDataWidth();
    int j = paramSymbolInfo.getSymbolDataHeight();
    ByteMatrix byteMatrix = new ByteMatrix(paramSymbolInfo.getSymbolWidth(), paramSymbolInfo.getSymbolHeight());
    byte b = 0;
    int k = 0;
    while (b < j) {
      int m = k;
      if (b % paramSymbolInfo.matrixHeight == 0) {
        byte b1 = 0;
        m = 0;
        while (b1 < paramSymbolInfo.getSymbolWidth()) {
          boolean bool;
          if (b1 % 2 == 0) {
            bool = true;
          } else {
            bool = false;
          } 
          byteMatrix.set(m, k, bool);
          m++;
          b1++;
        } 
        m = k + 1;
      } 
      int n = 0;
      k = 0;
      while (n < i) {
        int i1 = k;
        if (n % paramSymbolInfo.matrixWidth == 0) {
          byteMatrix.set(k, m, true);
          i1 = k + 1;
        } 
        byteMatrix.set(i1, m, paramDefaultPlacement.getBit(n, b));
        k = ++i1;
        if (n % paramSymbolInfo.matrixWidth == paramSymbolInfo.matrixWidth - 1) {
          boolean bool;
          if (b % 2 == 0) {
            bool = true;
          } else {
            bool = false;
          } 
          byteMatrix.set(i1, m, bool);
          k = i1 + 1;
        } 
        n++;
      } 
      n = m + 1;
      k = n;
      if (b % paramSymbolInfo.matrixHeight == paramSymbolInfo.matrixHeight - 1) {
        m = 0;
        k = 0;
        while (m < paramSymbolInfo.getSymbolWidth()) {
          byteMatrix.set(k, n, true);
          k++;
          m++;
        } 
        k = n + 1;
      } 
      b++;
    } 
    return convertByteMatrixToBitMatrix(byteMatrix, paramInt1, paramInt2);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2) {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }
  
  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap) {
    if (!paramString.isEmpty()) {
      SymbolInfo symbolInfo;
      if (paramBarcodeFormat == BarcodeFormat.DATA_MATRIX) {
        if (paramInt1 >= 0 && paramInt2 >= 0) {
          SymbolShapeHint symbolShapeHint2;
          Dimension dimension2;
          SymbolShapeHint symbolShapeHint1 = SymbolShapeHint.FORCE_NONE;
          Dimension dimension1 = null;
          if (paramMap != null) {
            SymbolShapeHint symbolShapeHint = (SymbolShapeHint)paramMap.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint != null)
              symbolShapeHint1 = symbolShapeHint; 
            Dimension dimension3 = (Dimension)paramMap.get(EncodeHintType.MIN_SIZE);
            if (dimension3 == null)
              dimension3 = null; 
            Dimension dimension4 = (Dimension)paramMap.get(EncodeHintType.MAX_SIZE);
            dimension2 = dimension3;
            symbolShapeHint2 = symbolShapeHint1;
            if (dimension4 != null) {
              dimension1 = dimension4;
              dimension2 = dimension3;
              symbolShapeHint2 = symbolShapeHint1;
            } 
          } else {
            dimension2 = null;
            symbolShapeHint2 = symbolShapeHint1;
          } 
          paramString = HighLevelEncoder.encodeHighLevel(paramString, symbolShapeHint2, dimension2, dimension1);
          symbolInfo = SymbolInfo.lookup(paramString.length(), symbolShapeHint2, dimension2, dimension1, true);
          DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(paramString, symbolInfo), symbolInfo.getSymbolDataWidth(), symbolInfo.getSymbolDataHeight());
          defaultPlacement.place();
          return encodeLowLevel(defaultPlacement, symbolInfo, paramInt1, paramInt2);
        } 
        StringBuilder stringBuilder = new StringBuilder("Requested dimensions can't be negative: ");
        stringBuilder.append(paramInt1);
        stringBuilder.append('x');
        stringBuilder.append(paramInt2);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(symbolInfo)));
    } 
    throw new IllegalArgumentException("Found empty contents");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\DataMatrixWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */