package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

public final class Result {
  private final BarcodeFormat format;
  
  private final int numBits;
  
  private final byte[] rawBytes;
  
  private Map<ResultMetadataType, Object> resultMetadata;
  
  private ResultPoint[] resultPoints;
  
  private final String text;
  
  private final long timestamp;
  
  public Result(String paramString, byte[] paramArrayOfbyte, int paramInt, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat, long paramLong) {
    this.text = paramString;
    this.rawBytes = paramArrayOfbyte;
    this.numBits = paramInt;
    this.resultPoints = paramArrayOfResultPoint;
    this.format = paramBarcodeFormat;
    this.resultMetadata = null;
    this.timestamp = paramLong;
  }
  
  public Result(String paramString, byte[] paramArrayOfbyte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat) {
    this(paramString, paramArrayOfbyte, paramArrayOfResultPoint, paramBarcodeFormat, System.currentTimeMillis());
  }
  
  public Result(String paramString, byte[] paramArrayOfbyte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat, long paramLong) {
    this(paramString, paramArrayOfbyte, i, paramArrayOfResultPoint, paramBarcodeFormat, paramLong);
  }
  
  public void addResultPoints(ResultPoint[] paramArrayOfResultPoint) {
    ResultPoint[] arrayOfResultPoint = this.resultPoints;
    if (arrayOfResultPoint == null) {
      this.resultPoints = paramArrayOfResultPoint;
      return;
    } 
    if (paramArrayOfResultPoint != null && paramArrayOfResultPoint.length > 0) {
      ResultPoint[] arrayOfResultPoint1 = new ResultPoint[arrayOfResultPoint.length + paramArrayOfResultPoint.length];
      System.arraycopy(arrayOfResultPoint, 0, arrayOfResultPoint1, 0, arrayOfResultPoint.length);
      System.arraycopy(paramArrayOfResultPoint, 0, arrayOfResultPoint1, arrayOfResultPoint.length, paramArrayOfResultPoint.length);
      this.resultPoints = arrayOfResultPoint1;
    } 
  }
  
  public BarcodeFormat getBarcodeFormat() {
    return this.format;
  }
  
  public int getNumBits() {
    return this.numBits;
  }
  
  public byte[] getRawBytes() {
    return this.rawBytes;
  }
  
  public Map<ResultMetadataType, Object> getResultMetadata() {
    return this.resultMetadata;
  }
  
  public ResultPoint[] getResultPoints() {
    return this.resultPoints;
  }
  
  public String getText() {
    return this.text;
  }
  
  public long getTimestamp() {
    return this.timestamp;
  }
  
  public void putAllMetadata(Map<ResultMetadataType, Object> paramMap) {
    if (paramMap != null) {
      if (this.resultMetadata == null) {
        this.resultMetadata = paramMap;
        return;
      } 
      this.resultMetadata.putAll(paramMap);
    } 
  }
  
  public void putMetadata(ResultMetadataType paramResultMetadataType, Object paramObject) {
    if (this.resultMetadata == null)
      this.resultMetadata = new EnumMap<ResultMetadataType, Object>(ResultMetadataType.class); 
    this.resultMetadata.put(paramResultMetadataType, paramObject);
  }
  
  public String toString() {
    return this.text;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */