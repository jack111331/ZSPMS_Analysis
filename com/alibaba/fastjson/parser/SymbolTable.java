package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

public class SymbolTable {
  private final int indexMask;
  
  private final String[] symbols;
  
  public SymbolTable(int paramInt) {
    this.indexMask = paramInt - 1;
    this.symbols = new String[paramInt];
    addSymbol("$ref", 0, 4, "$ref".hashCode());
    addSymbol(JSON.DEFAULT_TYPE_KEY, 0, JSON.DEFAULT_TYPE_KEY.length(), JSON.DEFAULT_TYPE_KEY.hashCode());
  }
  
  public static int hash(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    byte b = 0;
    int i = 0;
    while (b < paramInt2) {
      i = i * 31 + paramArrayOfchar[paramInt1];
      b++;
      paramInt1++;
    } 
    return i;
  }
  
  private static String subString(String paramString, int paramInt1, int paramInt2) {
    char[] arrayOfChar = new char[paramInt2];
    paramString.getChars(paramInt1, paramInt2 + paramInt1, arrayOfChar, 0);
    return new String(arrayOfChar);
  }
  
  public String addSymbol(String paramString, int paramInt1, int paramInt2, int paramInt3) {
    return addSymbol(paramString, paramInt1, paramInt2, paramInt3, false);
  }
  
  public String addSymbol(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    int i = this.indexMask & paramInt3;
    String str = this.symbols[i];
    if (str != null) {
      if (paramInt3 == str.hashCode() && paramInt2 == str.length() && paramString.startsWith(str, paramInt1))
        return str; 
      paramString = subString(paramString, paramInt1, paramInt2);
      if (paramBoolean)
        this.symbols[i] = paramString; 
      return paramString;
    } 
    if (paramInt2 != paramString.length())
      paramString = subString(paramString, paramInt1, paramInt2); 
    paramString = paramString.intern();
    this.symbols[i] = paramString;
    return paramString;
  }
  
  public String addSymbol(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    return addSymbol(paramArrayOfchar, paramInt1, paramInt2, hash(paramArrayOfchar, paramInt1, paramInt2));
  }
  
  public String addSymbol(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
    int i = this.indexMask & paramInt3;
    String str2 = this.symbols[i];
    if (str2 != null) {
      int j = str2.hashCode();
      boolean bool = false;
      i = bool;
      if (paramInt3 == j) {
        i = bool;
        if (paramInt2 == str2.length()) {
          paramInt3 = 0;
          while (true) {
            if (paramInt3 < paramInt2) {
              if (paramArrayOfchar[paramInt1 + paramInt3] != str2.charAt(paramInt3)) {
                i = bool;
                break;
              } 
              paramInt3++;
              continue;
            } 
            i = 1;
            break;
          } 
        } 
      } 
      return (i != 0) ? str2 : new String(paramArrayOfchar, paramInt1, paramInt2);
    } 
    String str1 = (new String(paramArrayOfchar, paramInt1, paramInt2)).intern();
    this.symbols[i] = str1;
    return str1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\parser\SymbolTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */