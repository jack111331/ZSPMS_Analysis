package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k {
  private static final Pattern a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
  
  private static final Pattern b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
  
  public static long a(String paramString) {
    a a;
    boolean bool2;
    boolean bool3;
    int i;
    boolean bool1 = true;
    Matcher matcher = a.matcher(paramString);
    if (matcher.find()) {
      bool2 = b(matcher.group(1));
      bool3 = c(matcher.group(2));
      i = d(matcher.group(3));
      a = e(matcher.group(4));
    } else {
      matcher = b.matcher((CharSequence)a);
      if (matcher.find()) {
        bool3 = c(matcher.group(1));
        bool2 = b(matcher.group(2));
        a = e(matcher.group(3));
        i = d(matcher.group(4));
      } else {
        throw new IllegalArgumentException();
      } 
    } 
    if (i >= 2038) {
      i = 2038;
      bool3 = false;
      bool2 = bool1;
    } 
    Time time = new Time("UTC");
    time.set(a.c, a.b, a.a, bool2, bool3, i);
    return time.toMillis(false);
  }
  
  private static int b(String paramString) {
    return (paramString.length() == 2) ? ((paramString.charAt(0) - 48) * 10 + paramString.charAt(1) - 48) : (paramString.charAt(0) - 48);
  }
  
  private static int c(String paramString) {
    byte b = 0;
    switch (Character.toLowerCase(paramString.charAt(0)) + Character.toLowerCase(paramString.charAt(1)) + Character.toLowerCase(paramString.charAt(2)) - 291) {
      default:
        throw new IllegalArgumentException();
      case 10:
        b = 1;
      case 22:
        return b;
      case 29:
        b = 2;
      case 32:
        b = 3;
      case 36:
        b = 4;
      case 42:
        b = 5;
      case 40:
        b = 6;
      case 26:
        b = 7;
      case 37:
        b = 8;
      case 35:
        b = 9;
      case 48:
        b = 10;
      case 9:
        break;
    } 
    b = 11;
  }
  
  private static int d(String paramString) {
    if (paramString.length() == 2) {
      int i = (paramString.charAt(0) - 48) * 10 + paramString.charAt(1) - 48;
      if (i >= 70) {
        i += 1900;
        return i;
      } 
      i += 2000;
      return i;
    } 
    return (paramString.length() == 3) ? ((paramString.charAt(0) - 48) * 100 + (paramString.charAt(1) - 48) * 10 + paramString.charAt(2) - 48 + 1900) : ((paramString.length() == 4) ? ((paramString.charAt(0) - 48) * 1000 + (paramString.charAt(1) - 48) * 100 + (paramString.charAt(2) - 48) * 10 + paramString.charAt(3) - 48) : 1970);
  }
  
  private static a e(String paramString) {
    int i = paramString.charAt(0) - 48;
    if (paramString.charAt(1) != ':') {
      int n = 2;
      i = i * 10 + paramString.charAt(1) - 48;
      int i1 = n + 1;
      n = i1 + 1;
      char c1 = paramString.charAt(i1);
      i1 = paramString.charAt(n);
      n = n + 1 + 1;
      return new a(i, (c1 - 48) * 10 + i1 - 48, (paramString.charAt(n) - 48) * 10 + paramString.charAt(n + 1) - 48);
    } 
    int j = 1;
    int m = j + 1;
    j = m + 1;
    char c = paramString.charAt(m);
    m = paramString.charAt(j);
    j = j + 1 + 1;
    return new a(i, (c - 48) * 10 + m - 48, (paramString.charAt(j) - 48) * 10 + paramString.charAt(j + 1) - 48);
  }
  
  private static final class a {
    int a;
    
    int b;
    
    int c;
    
    a(int param1Int1, int param1Int2, int param1Int3) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1Int3;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */