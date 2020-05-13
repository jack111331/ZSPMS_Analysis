package android.support.v4.os;

import android.os.Build;

public final class TraceCompat {
  public static void beginSection(String paramString) {
    if (Build.VERSION.SDK_INT >= 18)
      TraceJellybeanMR2.beginSection(paramString); 
  }
  
  public static void endSection() {
    if (Build.VERSION.SDK_INT >= 18)
      TraceJellybeanMR2.endSection(); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\os\TraceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */