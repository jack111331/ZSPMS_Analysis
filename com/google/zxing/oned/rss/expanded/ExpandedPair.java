package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

final class ExpandedPair {
  private final FinderPattern finderPattern;
  
  private final DataCharacter leftChar;
  
  private final boolean mayBeLast;
  
  private final DataCharacter rightChar;
  
  ExpandedPair(DataCharacter paramDataCharacter1, DataCharacter paramDataCharacter2, FinderPattern paramFinderPattern, boolean paramBoolean) {
    this.leftChar = paramDataCharacter1;
    this.rightChar = paramDataCharacter2;
    this.finderPattern = paramFinderPattern;
    this.mayBeLast = paramBoolean;
  }
  
  private static boolean equalsOrNull(Object paramObject1, Object paramObject2) {
    return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2);
  }
  
  private static int hashNotNull(Object paramObject) {
    return (paramObject == null) ? 0 : paramObject.hashCode();
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof ExpandedPair))
      return false; 
    paramObject = paramObject;
    return (equalsOrNull(this.leftChar, ((ExpandedPair)paramObject).leftChar) && equalsOrNull(this.rightChar, ((ExpandedPair)paramObject).rightChar) && equalsOrNull(this.finderPattern, ((ExpandedPair)paramObject).finderPattern));
  }
  
  FinderPattern getFinderPattern() {
    return this.finderPattern;
  }
  
  DataCharacter getLeftChar() {
    return this.leftChar;
  }
  
  DataCharacter getRightChar() {
    return this.rightChar;
  }
  
  public int hashCode() {
    return hashNotNull(this.leftChar) ^ hashNotNull(this.rightChar) ^ hashNotNull(this.finderPattern);
  }
  
  boolean mayBeLast() {
    return this.mayBeLast;
  }
  
  public boolean mustBeLast() {
    return (this.rightChar == null);
  }
  
  public String toString() {
    Integer integer;
    StringBuilder stringBuilder = new StringBuilder("[ ");
    stringBuilder.append(this.leftChar);
    stringBuilder.append(" , ");
    stringBuilder.append(this.rightChar);
    stringBuilder.append(" : ");
    if (this.finderPattern == null) {
      String str = "null";
    } else {
      integer = Integer.valueOf(this.finderPattern.getValue());
    } 
    stringBuilder.append(integer);
    stringBuilder.append(" ]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\ExpandedPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */