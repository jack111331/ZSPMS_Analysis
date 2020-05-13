package com.google.zxing.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

final class ExpandedRow {
  private final List<ExpandedPair> pairs;
  
  private final int rowNumber;
  
  private final boolean wasReversed;
  
  ExpandedRow(List<ExpandedPair> paramList, int paramInt, boolean paramBoolean) {
    this.pairs = new ArrayList<ExpandedPair>(paramList);
    this.rowNumber = paramInt;
    this.wasReversed = paramBoolean;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof ExpandedRow))
      return false; 
    paramObject = paramObject;
    return (this.pairs.equals(paramObject.getPairs()) && this.wasReversed == ((ExpandedRow)paramObject).wasReversed);
  }
  
  List<ExpandedPair> getPairs() {
    return this.pairs;
  }
  
  int getRowNumber() {
    return this.rowNumber;
  }
  
  public int hashCode() {
    return this.pairs.hashCode() ^ Boolean.valueOf(this.wasReversed).hashCode();
  }
  
  boolean isEquivalent(List<ExpandedPair> paramList) {
    return this.pairs.equals(paramList);
  }
  
  boolean isReversed() {
    return this.wasReversed;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("{ ");
    stringBuilder.append(this.pairs);
    stringBuilder.append(" }");
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\ExpandedRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */