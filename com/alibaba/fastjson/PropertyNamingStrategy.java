package com.alibaba.fastjson;

public enum PropertyNamingStrategy {
  CamelCase, KebabCase, PascalCase, SnakeCase;
  
  static {
    KebabCase = new PropertyNamingStrategy("KebabCase", 3);
    $VALUES = new PropertyNamingStrategy[] { CamelCase, PascalCase, SnakeCase, KebabCase };
  }
  
  public String translate(String paramString) {
    char[] arrayOfChar;
    int i = null.$SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[ordinal()];
    boolean bool = false;
    char c = Character.MIN_VALUE;
    switch (i) {
      default:
        return paramString;
      case 4:
        c = paramString.charAt(0);
        if (c >= 'A' && c <= 'Z') {
          arrayOfChar = paramString.toCharArray();
          arrayOfChar[0] = (char)(char)(arrayOfChar[0] + 32);
          return new String(arrayOfChar);
        } 
        return (String)arrayOfChar;
      case 3:
        c = arrayOfChar.charAt(0);
        if (c >= 'a' && c <= 'z') {
          arrayOfChar = arrayOfChar.toCharArray();
          arrayOfChar[0] = (char)(char)(arrayOfChar[0] - 32);
          return new String(arrayOfChar);
        } 
        return (String)arrayOfChar;
      case 2:
        stringBuilder = new StringBuilder();
        while (c < arrayOfChar.length()) {
          char c1 = arrayOfChar.charAt(c);
          if (c1 >= 'A' && c1 <= 'Z') {
            c1 = (char)(c1 + 32);
            if (c > '\000')
              stringBuilder.append('-'); 
            stringBuilder.append(c1);
          } else {
            stringBuilder.append(c1);
          } 
          c++;
        } 
        return stringBuilder.toString();
      case 1:
        break;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    for (c = bool; c < arrayOfChar.length(); c++) {
      char c1 = arrayOfChar.charAt(c);
      if (c1 >= 'A' && c1 <= 'Z') {
        c1 = (char)(c1 + 32);
        if (c > '\000')
          stringBuilder.append('_'); 
        stringBuilder.append(c1);
      } else {
        stringBuilder.append(c1);
      } 
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\PropertyNamingStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */