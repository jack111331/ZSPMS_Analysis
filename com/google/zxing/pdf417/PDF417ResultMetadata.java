package com.google.zxing.pdf417;

public final class PDF417ResultMetadata {
  private String addressee;
  
  private int checksum = -1;
  
  private String fileId;
  
  private String fileName;
  
  private long fileSize = -1L;
  
  private boolean lastSegment;
  
  private int[] optionalData;
  
  private int segmentCount = -1;
  
  private int segmentIndex;
  
  private String sender;
  
  private long timestamp = -1L;
  
  public String getAddressee() {
    return this.addressee;
  }
  
  public int getChecksum() {
    return this.checksum;
  }
  
  public String getFileId() {
    return this.fileId;
  }
  
  public String getFileName() {
    return this.fileName;
  }
  
  public long getFileSize() {
    return this.fileSize;
  }
  
  @Deprecated
  public int[] getOptionalData() {
    return this.optionalData;
  }
  
  public int getSegmentCount() {
    return this.segmentCount;
  }
  
  public int getSegmentIndex() {
    return this.segmentIndex;
  }
  
  public String getSender() {
    return this.sender;
  }
  
  public long getTimestamp() {
    return this.timestamp;
  }
  
  public boolean isLastSegment() {
    return this.lastSegment;
  }
  
  public void setAddressee(String paramString) {
    this.addressee = paramString;
  }
  
  public void setChecksum(int paramInt) {
    this.checksum = paramInt;
  }
  
  public void setFileId(String paramString) {
    this.fileId = paramString;
  }
  
  public void setFileName(String paramString) {
    this.fileName = paramString;
  }
  
  public void setFileSize(long paramLong) {
    this.fileSize = paramLong;
  }
  
  public void setLastSegment(boolean paramBoolean) {
    this.lastSegment = paramBoolean;
  }
  
  @Deprecated
  public void setOptionalData(int[] paramArrayOfint) {
    this.optionalData = paramArrayOfint;
  }
  
  public void setSegmentCount(int paramInt) {
    this.segmentCount = paramInt;
  }
  
  public void setSegmentIndex(int paramInt) {
    this.segmentIndex = paramInt;
  }
  
  public void setSender(String paramString) {
    this.sender = paramString;
  }
  
  public void setTimestamp(long paramLong) {
    this.timestamp = paramLong;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\PDF417ResultMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */