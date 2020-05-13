package com.zz.lib.org.myapache.commons.codec.language.bm;

public enum NameType {
  ASHKENAZI("ash"),
  GENERIC("gen"),
  SEPHARDIC("sep");
  
  private final String name;
  
  static {
    ENUM$VALUES = new NameType[] { ASHKENAZI, GENERIC, SEPHARDIC };
  }
  
  NameType(String paramString1) {
    this.name = paramString1;
  }
  
  public String getName() {
    return this.name;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\bm\NameType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */