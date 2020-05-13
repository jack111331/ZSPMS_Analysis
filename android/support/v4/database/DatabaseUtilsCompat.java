package android.support.v4.database;

import android.text.TextUtils;

public final class DatabaseUtilsCompat {
  public static String[] appendSelectionArgs(String[] paramArrayOfString1, String[] paramArrayOfString2) {
    String[] arrayOfString = paramArrayOfString2;
    if (paramArrayOfString1 != null) {
      if (paramArrayOfString1.length == 0)
        return paramArrayOfString2; 
    } else {
      return arrayOfString;
    } 
    arrayOfString = new String[paramArrayOfString1.length + paramArrayOfString2.length];
    System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, paramArrayOfString1.length);
    System.arraycopy(paramArrayOfString2, 0, arrayOfString, paramArrayOfString1.length, paramArrayOfString2.length);
    return arrayOfString;
  }
  
  public static String concatenateWhere(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return paramString1; 
      paramString2 = "(" + paramString1 + ") AND (" + paramString2 + ")";
    } 
    return paramString2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\database\DatabaseUtilsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */