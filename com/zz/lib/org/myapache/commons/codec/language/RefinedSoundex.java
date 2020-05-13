package com.zz.lib.org.myapache.commons.codec.language;

import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;

public class RefinedSoundex implements StringEncoder {
  public static final RefinedSoundex US_ENGLISH;
  
  private static final char[] US_ENGLISH_MAPPING = "01360240043788015936020505".toCharArray();
  
  public static final String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
  
  private final char[] soundexMapping = US_ENGLISH_MAPPING;
  
  static {
    US_ENGLISH = new RefinedSoundex();
  }
  
  public RefinedSoundex() {}
  
  public RefinedSoundex(String paramString) {}
  
  public RefinedSoundex(char[] paramArrayOfchar) {
    System.arraycopy(paramArrayOfchar, 0, this.soundexMapping, 0, paramArrayOfchar.length);
  }
  
  public int difference(String paramString1, String paramString2) throws EncoderException {
    return SoundexUtils.difference(this, paramString1, paramString2);
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof String))
      throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String"); 
    return soundex((String)paramObject);
  }
  
  public String encode(String paramString) {
    return soundex(paramString);
  }
  
  char getMappingCode(char paramChar) {
    if (!Character.isLetter(paramChar))
      return Character.MIN_VALUE; 
    return this.soundexMapping[Character.toUpperCase(paramChar) - 65];
  }
  
  public String soundex(String paramString) {
    if (paramString == null)
      return null; 
    paramString = SoundexUtils.clean(paramString);
    if (paramString.length() != 0) {
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append(paramString.charAt(0));
      char c = '*';
      for (byte b = 0;; b++) {
        if (b >= paramString.length())
          return stringBuffer.toString(); 
        char c1 = getMappingCode(paramString.charAt(b));
        if (c1 != c) {
          if (c1 != '\000')
            stringBuffer.append(c1); 
          c = c1;
        } 
      } 
    } 
    return paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\RefinedSoundex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */