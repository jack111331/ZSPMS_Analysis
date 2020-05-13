package com.sdk.base.framework.a.b;

import com.sdk.base.framework.c.c;
import com.sdk.base.framework.utils.k.a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class d {
  private static final Boolean a = Boolean.valueOf(c.h);
  
  public String a(HttpURLConnection paramHttpURLConnection, c paramc, String paramString) {
    InputStreamReader inputStreamReader = null;
    if (paramHttpURLConnection != null) {
      String str1;
      long l = 0L;
      try {
        long l1 = paramHttpURLConnection.getContentLength();
        if (paramc != null && !paramc.a(l1, 0L, true))
          return null; 
        StringBuilder stringBuilder = new StringBuilder();
        this();
        try {
          long l2;
          InputStream inputStream = paramHttpURLConnection.getInputStream();
          BufferedReader bufferedReader = new BufferedReader();
          inputStreamReader = new InputStreamReader();
          this(inputStream, paramString);
          this(inputStreamReader);
          while (true) {
            str1 = bufferedReader.readLine();
            l2 = l;
            if (str1 != null) {
              stringBuilder.append(str1).append('\n');
              l2 = l + a.a(str1, paramString);
              l = l2;
              if (paramc != null) {
                l = l2;
                if (!paramc.a(l1, l2, false))
                  break; 
              } 
              continue;
            } 
            break;
          } 
          StringBuilder stringBuilder1 = stringBuilder;
          if (paramc != null) {
            paramc.a(l1, l2, true);
            stringBuilder1 = stringBuilder;
          } 
          if (stringBuilder1 == null)
            return null; 
          String str2 = stringBuilder1.toString().trim();
        } catch (Exception exception) {
          StringBuilder stringBuilder1 = stringBuilder;
        } 
      } catch (Exception exception) {
        String str2 = str1;
      } 
    } else {
      paramHttpURLConnection = null;
    } 
    if (paramHttpURLConnection == null)
      return null; 
    String str = paramHttpURLConnection.toString().trim();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sdk\base\framework\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */