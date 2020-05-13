package com.google.gson.internal;

import java.math.BigInteger;

public final class LazilyParsedNumber extends Number {
  private final String value;
  
  public LazilyParsedNumber(String paramString) {
    this.value = paramString;
  }
  
  public double doubleValue() {
    return Double.parseDouble(this.value);
  }
  
  public float floatValue() {
    return Float.parseFloat(this.value);
  }
  
  public int intValue() {
    int i;
    try {
      i = Integer.parseInt(this.value);
    } catch (NumberFormatException numberFormatException) {}
    return i;
  }
  
  public long longValue() {
    long l;
    try {
      l = Long.parseLong(this.value);
    } catch (NumberFormatException numberFormatException) {
      l = (new BigInteger(this.value)).longValue();
    } 
    return l;
  }
  
  public String toString() {
    return this.value;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\internal\LazilyParsedNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */