package android.support.v4.os;

import android.os.Build;

public class BuildCompat {
  public static boolean isAtLeastN() {
    return (Build.VERSION.SDK_INT >= 24);
  }
  
  public static boolean isAtLeastNMR1() {
    return (Build.VERSION.SDK_INT >= 25);
  }
  
  public static boolean isAtLeastO() {
    return (!"REL".equals(Build.VERSION.CODENAME) && ("O".equals(Build.VERSION.CODENAME) || Build.VERSION.CODENAME.startsWith("OMR")));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\os\BuildCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */