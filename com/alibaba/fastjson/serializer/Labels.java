package com.alibaba.fastjson.serializer;

import java.util.Arrays;

public class Labels {
  public static LabelFilter excludes(String... paramVarArgs) {
    return new DefaultLabelFilter(null, paramVarArgs);
  }
  
  public static LabelFilter includes(String... paramVarArgs) {
    return new DefaultLabelFilter(paramVarArgs, null);
  }
  
  private static class DefaultLabelFilter implements LabelFilter {
    private String[] excludes;
    
    private String[] includes;
    
    public DefaultLabelFilter(String[] param1ArrayOfString1, String[] param1ArrayOfString2) {
      if (param1ArrayOfString1 != null) {
        this.includes = new String[param1ArrayOfString1.length];
        System.arraycopy(param1ArrayOfString1, 0, this.includes, 0, param1ArrayOfString1.length);
        Arrays.sort((Object[])this.includes);
      } 
      if (param1ArrayOfString2 != null) {
        this.excludes = new String[param1ArrayOfString2.length];
        System.arraycopy(param1ArrayOfString2, 0, this.excludes, 0, param1ArrayOfString2.length);
        Arrays.sort((Object[])this.excludes);
      } 
    }
    
    public boolean apply(String param1String) {
      String[] arrayOfString = this.excludes;
      boolean bool1 = false;
      boolean bool2 = false;
      if (arrayOfString != null) {
        if (Arrays.binarySearch((Object[])this.excludes, param1String) == -1)
          bool2 = true; 
        return bool2;
      } 
      bool2 = bool1;
      if (this.includes != null) {
        bool2 = bool1;
        if (Arrays.binarySearch((Object[])this.includes, param1String) >= 0)
          bool2 = true; 
      } 
      return bool2;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\Labels.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */