package com.unionpay.mobile.android.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import java.util.regex.Pattern;

public final class i {
  public static SpannableString a(String paramString1, String paramString2, String paramString3, String paramString4) {
    int j;
    int k;
    String str1 = "";
    if (!b(paramString1))
      str1 = "" + paramString1; 
    String str2 = str1;
    if (!b(paramString3))
      str2 = str1 + paramString3; 
    str1 = str2;
    if (!b(paramString4))
      str1 = str2 + paramString4; 
    SpannableString spannableString = new SpannableString(str1);
    if (b(paramString1)) {
      j = 0;
    } else {
      j = paramString1.length();
    } 
    if (b(paramString3)) {
      k = 0;
    } else {
      k = paramString3.length();
    } 
    spannableString.setSpan(new ForegroundColorSpan(-16777216), 0, str1.length(), 33);
    if (!b(paramString2)) {
      if (paramString2.length() == 6 || !d(paramString2))
        paramString2 = "#" + paramString2; 
      spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(paramString2)), j, k + j, 33);
    } 
    return spannableString;
  }
  
  public static final String a(String paramString) {
    String str1 = "";
    String str2 = str1;
    if (paramString != null) {
      str2 = str1;
      if (paramString.length() > 2)
        str2 = paramString.substring(1, paramString.length() - 1); 
    } 
    return str2;
  }
  
  public static final boolean b(String paramString) {
    return (paramString == null || paramString.length() == 0);
  }
  
  public static final boolean c(String paramString) {
    return !!Pattern.compile("[^0-9]+").matcher(paramString).matches();
  }
  
  private static final boolean d(String paramString) {
    String[] arrayOfString;
    int j;
    byte b;
    boolean bool = true;
    if (!b(paramString)) {
      arrayOfString = new String[11];
      arrayOfString[0] = "black";
      arrayOfString[1] = "darkgray";
      arrayOfString[2] = "gray";
      arrayOfString[3] = "lightgray";
      arrayOfString[4] = "white";
      arrayOfString[5] = "red";
      arrayOfString[6] = "green";
      arrayOfString[7] = "blue";
      arrayOfString[8] = "yellow";
      arrayOfString[9] = "cyan";
      arrayOfString[10] = "magenta";
      j = arrayOfString.length;
      b = 0;
      while (b < j) {
        if (!arrayOfString[b].equalsIgnoreCase(paramString)) {
          b++;
          continue;
        } 
        return bool;
      } 
    } 
    bool = false;
    while (b < j) {
      if (!arrayOfString[b].equalsIgnoreCase(paramString)) {
        b++;
        continue;
      } 
      return bool;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */