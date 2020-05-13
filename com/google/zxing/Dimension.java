package com.google.zxing;

public final class Dimension {
  private final int height;
  
  private final int width;
  
  public Dimension(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0 && paramInt2 >= 0) {
      this.width = paramInt1;
      this.height = paramInt2;
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject instanceof Dimension) {
      paramObject = paramObject;
      return (this.width == ((Dimension)paramObject).width && this.height == ((Dimension)paramObject).height);
    } 
    return false;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public int hashCode() {
    return this.width * 32713 + this.height;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.width);
    stringBuilder.append("x");
    stringBuilder.append(this.height);
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\Dimension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */