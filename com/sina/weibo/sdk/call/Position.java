package com.sina.weibo.sdk.call;

public class Position {
  private float mLatitude;
  
  private float mLongitude;
  
  private boolean mOffset;
  
  public Position(float paramFloat1, float paramFloat2) {
    this.mLongitude = paramFloat1;
    this.mLatitude = paramFloat2;
    this.mOffset = true;
  }
  
  public Position(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    this.mLongitude = paramFloat1;
    this.mLatitude = paramFloat2;
    this.mOffset = paramBoolean;
  }
  
  boolean checkValid() {
    return (Float.isNaN(this.mLongitude) || this.mLongitude < -180.0F || this.mLongitude > 180.0F) ? false : (!(Float.isNaN(this.mLatitude) || this.mLatitude < -180.0F || this.mLatitude > 180.0F));
  }
  
  public float getLatitude() {
    return this.mLatitude;
  }
  
  public float getLongitude() {
    return this.mLongitude;
  }
  
  public String getStrLatitude() {
    return String.valueOf(this.mLatitude);
  }
  
  public String getStrLongitude() {
    return String.valueOf(this.mLongitude);
  }
  
  public String getStrOffset() {
    String str;
    if (this.mOffset) {
      str = "1";
    } else {
      str = "0";
    } 
    return str;
  }
  
  public boolean isOffset() {
    return this.mOffset;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\call\Position.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */