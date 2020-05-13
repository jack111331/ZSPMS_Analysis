package com.ta.utdid2.device;

import com.ta.utdid2.a.a.a;
import com.ta.utdid2.a.a.b;
import com.ta.utdid2.a.a.f;

public class e {
  public String d(String paramString) {
    return a.b(paramString);
  }
  
  public String e(String paramString) {
    paramString = a.b(paramString);
    if (!f.isEmpty(paramString)) {
      try {
        byte[] arrayOfByte = b.decode(paramString, 0);
        paramString = new String();
        this(arrayOfByte);
      } catch (IllegalArgumentException illegalArgumentException) {
        illegalArgumentException = null;
      } 
      return (String)illegalArgumentException;
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\device\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */