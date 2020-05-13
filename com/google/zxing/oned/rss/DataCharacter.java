package com.google.zxing.oned.rss;

public class DataCharacter {
  private final int checksumPortion;
  
  private final int value;
  
  public DataCharacter(int paramInt1, int paramInt2) {
    this.value = paramInt1;
    this.checksumPortion = paramInt2;
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof DataCharacter))
      return false; 
    paramObject = paramObject;
    return (this.value == ((DataCharacter)paramObject).value && this.checksumPortion == ((DataCharacter)paramObject).checksumPortion);
  }
  
  public final int getChecksumPortion() {
    return this.checksumPortion;
  }
  
  public final int getValue() {
    return this.value;
  }
  
  public final int hashCode() {
    return this.value ^ this.checksumPortion;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.value);
    stringBuilder.append("(");
    stringBuilder.append(this.checksumPortion);
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\DataCharacter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */