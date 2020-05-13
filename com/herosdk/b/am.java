package com.herosdk.b;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public final class am {
  HashMap<String, Object> a;
  
  am(an paraman) {
    this.a = paraman.a;
  }
  
  public HashMap<String, Object> a() {
    return this.a;
  }
  
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    ArrayList<String> arrayList = new ArrayList(this.a.keySet());
    byte b = 0;
    while (true) {
      if (b < arrayList.size()) {
        String str1 = arrayList.get(b);
        String str2 = (String)this.a.get(str1);
        if (b != 0)
          stringBuffer.append("&"); 
        try {
          stringBuffer.append(URLEncoder.encode(str1, "UTF-8")).append("=").append(URLEncoder.encode(str2, "UTF-8"));
        } catch (UnsupportedEncodingException unsupportedEncodingException) {}
        b++;
        continue;
      } 
      return stringBuffer.toString();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\b\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */