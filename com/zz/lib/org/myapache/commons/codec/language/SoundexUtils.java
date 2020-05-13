package com.zz.lib.org.myapache.commons.codec.language;

import com.zz.lib.org.myapache.commons.codec.EncoderException;
import com.zz.lib.org.myapache.commons.codec.StringEncoder;
import java.util.Locale;

final class SoundexUtils {
  static String clean(String paramString) {
    String str = paramString;
    if (paramString != null) {
      if (paramString.length() == 0)
        return paramString; 
    } else {
      return str;
    } 
    int i = paramString.length();
    char[] arrayOfChar = new char[i];
    byte b = 0;
    int j = 0;
    while (true) {
      if (b >= i) {
        if (j == i)
          return paramString.toUpperCase(Locale.ENGLISH); 
      } else {
        if (Character.isLetter(paramString.charAt(b))) {
          int k = j + 1;
          arrayOfChar[j] = paramString.charAt(b);
          j = k;
        } 
        b++;
        continue;
      } 
      return (new String(arrayOfChar, 0, j)).toUpperCase(Locale.ENGLISH);
    } 
  }
  
  static int difference(StringEncoder paramStringEncoder, String paramString1, String paramString2) throws EncoderException {
    return differenceEncoded(paramStringEncoder.encode(paramString1), paramStringEncoder.encode(paramString2));
  }
  
  static int differenceEncoded(String paramString1, String paramString2) {
    if (paramString1 == null || paramString2 == null)
      return 0; 
    int i = Math.min(paramString1.length(), paramString2.length());
    int j = 0;
    byte b = 0;
    while (true) {
      int k = j;
      if (b < i) {
        k = j;
        if (paramString1.charAt(b) == paramString2.charAt(b))
          k = j + 1; 
        b++;
        j = k;
        continue;
      } 
      return k;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\language\SoundexUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */