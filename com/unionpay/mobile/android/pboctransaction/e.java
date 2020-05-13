package com.unionpay.mobile.android.pboctransaction;

import java.util.ArrayList;
import java.util.HashMap;

public final class e {
  static HashMap<String, String> a = new f();
  
  private static String a(String paramString1, String paramString2) {
    String str = paramString1;
    if (paramString1 != null) {
      str = paramString1;
      if (paramString2 != null) {
        str = paramString1;
        if (paramString1.length() > paramString2.length())
          while (true) {
            str = paramString1;
            if (paramString1.substring(paramString1.length() - paramString2.length(), paramString1.length()).equalsIgnoreCase(paramString2)) {
              paramString1 = paramString1.substring(0, paramString1.length() - paramString2.length());
              continue;
            } 
            break;
          }  
      } 
    } 
    return str;
  }
  
  public static final String a(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, paramArrayOfbyte.length);
  }
  
  public static final String a(byte[] paramArrayOfbyte, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder("");
    if (paramArrayOfbyte == null || paramInt <= 0)
      return null; 
    for (byte b = 0; b < paramInt; b++) {
      String str = Integer.toHexString(paramArrayOfbyte[b] & 0xFF);
      if (str.length() < 2)
        stringBuilder.append(0); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString().toUpperCase();
  }
  
  private static boolean a(ArrayList<AppIdentification> paramArrayList, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 8
    //   4: aload_1
    //   5: ifnonnull -> 12
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: ireturn
    //   12: aload_0
    //   13: invokevirtual iterator : ()Ljava/util/Iterator;
    //   16: astore_0
    //   17: aload_0
    //   18: invokeinterface hasNext : ()Z
    //   23: ifeq -> 50
    //   26: aload_0
    //   27: invokeinterface next : ()Ljava/lang/Object;
    //   32: checkcast com/unionpay/mobile/android/pboctransaction/AppIdentification
    //   35: invokevirtual a : ()Ljava/lang/String;
    //   38: aload_1
    //   39: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   42: ifeq -> 17
    //   45: iconst_0
    //   46: istore_2
    //   47: goto -> 10
    //   50: iconst_1
    //   51: istore_2
    //   52: goto -> 10
  }
  
  public static final byte[] a(String paramString) {
    if (paramString == null || paramString.equals(""))
      return null; 
    paramString = paramString.toUpperCase();
    int i = paramString.length() / 2;
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[i];
    byte b = 0;
    while (true) {
      byte[] arrayOfByte1 = arrayOfByte;
      if (b < i) {
        int j = b * 2;
        byte b1 = (byte)"0123456789ABCDEF".indexOf(arrayOfChar[j]);
        arrayOfByte[b] = (byte)(byte)((byte)"0123456789ABCDEF".indexOf(arrayOfChar[j + 1]) | b1 << 4);
        b++;
        continue;
      } 
      return arrayOfByte1;
    } 
  }
  
  public static final ArrayList<AppIdentification> b(String paramString) {
    int i = 0;
    if (paramString != null && paramString.length() > 4) {
      ArrayList<AppIdentification> arrayList = new ArrayList();
      String str = paramString.substring(paramString.length() - 4);
      if (str != null && str.equalsIgnoreCase("9000")) {
        str = paramString.substring(0, paramString.length() - 4);
        while (str != null && str.length() > 0 && i != -1) {
          paramString = "";
          i = str.indexOf("61", i);
          if (i != -1) {
            String str1 = str.substring(i + 2, i + 4);
            String str2 = str.substring(i + 4, i + 6);
            if (i + 6 + Integer.parseInt(str2, 16) * 2 < str.length())
              paramString = str.substring(i + 6, Integer.parseInt(str2, 16) * 2 + i + 6); 
            int j = Integer.parseInt(str1, 16) * 2 + i + 2;
            if (j > str.length())
              j = i + 2; 
            paramString = paramString.trim();
            i = j;
            if (paramString.length() > 8) {
              i = j;
              if (!paramString.equalsIgnoreCase("A0000003334355502D4D4F42494C45")) {
                i = j;
                if (a(arrayList, paramString)) {
                  arrayList.add(new AppIdentification(paramString, null));
                  i = j;
                } 
              } 
            } 
          } 
        } 
      } 
      return arrayList;
    } 
    return null;
  }
  
  public static String c(String paramString) {
    return a(paramString, "F");
  }
  
  public static String d(String paramString) {
    return a(paramString, "00");
  }
  
  public static String e(String paramString) {
    return a.containsKey(paramString) ? a.get(paramString) : "";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */