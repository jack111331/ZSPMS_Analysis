package com.zz.a.c;

public class c {
  private static int[] a = new int[] { 
      16, 40, 41, 55, 35, 68, 63, 44, 78, 32, 
      83, 25, 18, 74, 83, 62, 40, 9, 1, 59, 
      56, 95, 55, 0, 70, 84, 15, 60, 55, 49, 
      60, 15, 68, 18, 82, 26, 43, 31, 9, 12, 
      93, 72, 74, 12, 20, 92, 33, 8, 17, 30, 
      77, 40, 68, 18, 79, 11, 34, 31, 23, 77, 
      78, 24, 94, 24, 13, 0, 45, 88, 59, 62, 
      4, 61, 92, 29, 57, 9, 99, 64, 46, 85, 
      17, 28, 78, 27, 20, 85, 71, 41, 4, 5, 
      64, 83, 55, 35, 27, 11, 31, 16, 73, 96, 
      22, 92, 85, 67, 65, 75, 23, 82, 61, 1, 
      83, 7, 24, 84, 79, 10, 71, 71, 65, 11, 
      54, 95, 37, 77, 14, 81, 10, 60, 58, 95, 
      61, 88, 92, 71, 78, 35, 33, 64, 12, 78, 
      47, 7, 21, 36, 38, 20, 82, 16, 7, 47, 
      7, 44, 58, 91, 9, 52, 45, 59, 41, 19, 
      66, 35, 0, 78, 68, 68, 6, 21, 97, 33, 
      71, 9, 89, 48, 99, 99, 9, 63, 64, 39, 
      89, 26, 42, 43, 70, 29, 65, 74, 29, 39, 
      41, 46, 70, 9, 37, 82, 78, 40, 43, 55, 
      40, 43, 55, 22, 47, 24, 27, 40, 43, 55, 
      26, 43, 31, 9, 12, 93, 26, 43, 31, 9, 
      12, 93 };
  
  public static String a(String paramString) {
    if (paramString == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("s");
    char[] arrayOfChar = paramString.toCharArray();
    byte b = 0;
    try {
      while (b < arrayOfChar.length) {
        stringBuilder.append((char)(arrayOfChar[b] + a[b % a.length]));
        b++;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    stringBuilder.append("e");
    return stringBuilder.toString();
  }
  
  public static String b(String paramString) {
    byte b = 0;
    if (paramString == null)
      return ""; 
    if (paramString.startsWith("s") && paramString.endsWith("e")) {
      StringBuilder stringBuilder = new StringBuilder(paramString);
      stringBuilder.deleteCharAt(0);
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      char[] arrayOfChar = stringBuilder.toString().toCharArray();
      stringBuilder = new StringBuilder();
      try {
        while (b < arrayOfChar.length) {
          stringBuilder.append((char)(arrayOfChar[b] - a[b % a.length]));
          b++;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return stringBuilder.toString();
    } 
    return "";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */