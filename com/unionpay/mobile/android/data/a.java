package com.unionpay.mobile.android.data;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.unionpay.mobile.android.utils.i;
import java.util.HashMap;

public final class a {
  public static final HashMap<String, Integer> a = new HashMap<String, Integer>();
  
  public static SpannableString a(String paramString1, String paramString2) {
    int i = -10066330;
    SpannableString spannableString = new SpannableString(paramString1);
    spannableString.setSpan(new ForegroundColorSpan(-10066330), 0, paramString1.length(), 33);
    if (paramString2 != null) {
      String[] arrayOfString = paramString2.split(";");
      int j = arrayOfString.length;
      byte b = 0;
      while (true) {
        if (b < j) {
          String str = arrayOfString[b];
          if (!a(str)) {
            try {
              StringBuilder stringBuilder = new StringBuilder();
              this("#");
              int k = Color.parseColor(stringBuilder.append(str).toString());
              i = k;
            } catch (Exception exception) {}
            b++;
            continue;
          } 
        } 
        spannableString.setSpan(new ForegroundColorSpan(i), 0, paramString1.length(), 33);
        return spannableString;
      } 
    } 
    return spannableString;
  }
  
  public static final boolean a(String paramString) {
    String[] arrayOfString;
    int i;
    byte b;
    boolean bool = true;
    if (!i.b(paramString)) {
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
      i = arrayOfString.length;
      b = 0;
      while (b < i) {
        if (!arrayOfString[b].equalsIgnoreCase(paramString)) {
          b++;
          continue;
        } 
        return bool;
      } 
    } 
    bool = false;
    while (b < i) {
      if (!arrayOfString[b].equalsIgnoreCase(paramString)) {
        b++;
        continue;
      } 
      return bool;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\data\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */