package com.google.zxing.common;

import java.util.List;

public final class DecoderResult {
  private final List<byte[]> byteSegments;
  
  private final String ecLevel;
  
  private Integer erasures;
  
  private Integer errorsCorrected;
  
  private int numBits;
  
  private Object other;
  
  private final byte[] rawBytes;
  
  private final int structuredAppendParity;
  
  private final int structuredAppendSequenceNumber;
  
  private final String text;
  
  public DecoderResult(byte[] paramArrayOfbyte, String paramString1, List<byte[]> paramList, String paramString2) {
    this(paramArrayOfbyte, paramString1, paramList, paramString2, -1, -1);
  }
  
  public DecoderResult(byte[] paramArrayOfbyte, String paramString1, List<byte[]> paramList, String paramString2, int paramInt1, int paramInt2) {
    int i;
    this.rawBytes = paramArrayOfbyte;
    if (paramArrayOfbyte == null) {
      i = 0;
    } else {
      i = paramArrayOfbyte.length * 8;
    } 
    this.numBits = i;
    this.text = paramString1;
    this.byteSegments = paramList;
    this.ecLevel = paramString2;
    this.structuredAppendParity = paramInt2;
    this.structuredAppendSequenceNumber = paramInt1;
  }
  
  public List<byte[]> getByteSegments() {
    return this.byteSegments;
  }
  
  public String getECLevel() {
    return this.ecLevel;
  }
  
  public Integer getErasures() {
    return this.erasures;
  }
  
  public Integer getErrorsCorrected() {
    return this.errorsCorrected;
  }
  
  public int getNumBits() {
    return this.numBits;
  }
  
  public Object getOther() {
    return this.other;
  }
  
  public byte[] getRawBytes() {
    return this.rawBytes;
  }
  
  public int getStructuredAppendParity() {
    return this.structuredAppendParity;
  }
  
  public int getStructuredAppendSequenceNumber() {
    return this.structuredAppendSequenceNumber;
  }
  
  public String getText() {
    return this.text;
  }
  
  public boolean hasStructuredAppend() {
    return (this.structuredAppendParity >= 0 && this.structuredAppendSequenceNumber >= 0);
  }
  
  public void setErasures(Integer paramInteger) {
    this.erasures = paramInteger;
  }
  
  public void setErrorsCorrected(Integer paramInteger) {
    this.errorsCorrected = paramInteger;
  }
  
  public void setNumBits(int paramInt) {
    this.numBits = paramInt;
  }
  
  public void setOther(Object paramObject) {
    this.other = paramObject;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\DecoderResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */