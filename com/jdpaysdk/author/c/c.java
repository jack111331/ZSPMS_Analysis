package com.jdpaysdk.author.c;

import com.google.gson.Gson;

public class c {
  public static <T> String a(T paramT, Class<T> paramClass) {
    if (paramT != null)
      try {
        Gson gson = new Gson();
        this();
        return gson.toJson(paramT, paramClass);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return "";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */