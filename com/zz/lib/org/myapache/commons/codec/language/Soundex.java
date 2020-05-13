package com.zz.lib.org.myapache.commons.codec.language;

import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;

public class Soundex implements StringEncoder {
  public static final Soundex US_ENGLISH;
  
  private static final char[] US_ENGLISH_MAPPING = "01230120022455012623010202".toCharArray();
  
  public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
  
  private int maxLength = 4;
  
  private final char[] soundexMapping = US_ENGLISH_MAPPING;
  
  static {
    US_ENGLISH = new Soundex();
  }
  
  public Soundex() {}
  
  public Soundex(String paramString) {}
  
  public Soundex(char[] paramArrayOfchar) {
    System.arraycopy(paramArrayOfchar, 0, this.soundexMapping, 0, paramArrayOfchar.length);
  }
  
  private char getMappingCode(String paramString, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: invokevirtual charAt : (I)C
    //   6: invokespecial map : (C)C
    //   9: istore_3
    //   10: iload_3
    //   11: istore #4
    //   13: iload_2
    //   14: iconst_1
    //   15: if_icmple -> 94
    //   18: iload_3
    //   19: istore #4
    //   21: iload_3
    //   22: bipush #48
    //   24: if_icmpeq -> 94
    //   27: aload_1
    //   28: iload_2
    //   29: iconst_1
    //   30: isub
    //   31: invokevirtual charAt : (I)C
    //   34: istore #5
    //   36: bipush #72
    //   38: iload #5
    //   40: if_icmpeq -> 53
    //   43: iload_3
    //   44: istore #4
    //   46: bipush #87
    //   48: iload #5
    //   50: if_icmpne -> 94
    //   53: aload_1
    //   54: iload_2
    //   55: iconst_2
    //   56: isub
    //   57: invokevirtual charAt : (I)C
    //   60: istore #6
    //   62: aload_0
    //   63: iload #6
    //   65: invokespecial map : (C)C
    //   68: iload_3
    //   69: if_icmpeq -> 89
    //   72: bipush #72
    //   74: iload #6
    //   76: if_icmpeq -> 89
    //   79: iload_3
    //   80: istore #4
    //   82: bipush #87
    //   84: iload #6
    //   86: if_icmpne -> 94
    //   89: iconst_0
    //   90: istore_2
    //   91: iload_2
    //   92: istore #4
    //   94: iload #4
    //   96: ireturn
  }
  
  private char[] getSoundexMapping() {
    return this.soundexMapping;
  }
  
  private char map(char paramChar) {
    int i = paramChar - 65;
    if (i < 0 || i >= (getSoundexMapping()).length)
      throw new IllegalArgumentException("The character is not mapped: " + paramChar); 
    return getSoundexMapping()[i];
  }
  
  public int difference(String paramString1, String paramString2) throws EncoderException {
    return SoundexUtils.difference(this, paramString1, paramString2);
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof String))
      throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String"); 
    return soundex((String)paramObject);
  }
  
  public String encode(String paramString) {
    return soundex(paramString);
  }
  
  public int getMaxLength() {
    return this.maxLength;
  }
  
  public void setMaxLength(int paramInt) {
    this.maxLength = paramInt;
  }
  
  public String soundex(String paramString) {
    if (paramString == null)
      return null; 
    paramString = SoundexUtils.clean(paramString);
    if (paramString.length() != 0) {
      char[] arrayOfChar = new char[4];
      arrayOfChar[0] = '0';
      arrayOfChar[1] = '0';
      arrayOfChar[2] = '0';
      arrayOfChar[3] = '0';
      int i = 1;
      int j = 1;
      arrayOfChar[0] = paramString.charAt(0);
      char c = getMappingCode(paramString, 0);
      while (true) {
        if (i >= paramString.length() || j >= arrayOfChar.length)
          return new String(arrayOfChar); 
        int k = i + 1;
        char c1 = getMappingCode(paramString, i);
        if (c1 != '\000') {
          i = j;
          if (c1 != '0') {
            i = j;
            if (c1 != c) {
              arrayOfChar[j] = (char)c1;
              i = j + 1;
            } 
          } 
          c = c1;
          j = i;
          i = k;
          continue;
        } 
        i = k;
      } 
    } 
    return paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\Soundex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */