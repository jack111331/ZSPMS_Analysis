package com.zz.lib.org.myapache.commons.codec;

import java.util.Comparator;

public class StringEncoderComparator implements Comparator {
  private final StringEncoder stringEncoder = null;
  
  public StringEncoderComparator() {}
  
  public StringEncoderComparator(StringEncoder paramStringEncoder) {}
  
  public int compare(Object paramObject1, Object paramObject2) {
    boolean bool;
    try {
      bool = ((Comparable<Comparable>)this.stringEncoder.encode(paramObject1)).compareTo((Comparable)this.stringEncoder.encode(paramObject2));
    } catch (EncoderException encoderException) {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\StringEncoderComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */