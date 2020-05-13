package com.alibaba.fastjson.serializer;

public class PascalNameFilter implements NameFilter {
  public String process(Object paramObject1, String paramString, Object paramObject2) {
    if (paramString == null || paramString.length() == 0)
      return paramString; 
    paramObject1 = paramString.toCharArray();
    paramObject1[0] = Character.toUpperCase(paramObject1[0]);
    return new String((char[])paramObject1);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\PascalNameFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */