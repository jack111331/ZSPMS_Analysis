package org.jar.support.v4.content;

import android.content.Context;
import java.io.File;

class ContextCompatFroyo {
  public static File getExternalCacheDir(Context paramContext) {
    return paramContext.getExternalCacheDir();
  }
  
  public static File getExternalFilesDir(Context paramContext, String paramString) {
    return paramContext.getExternalFilesDir(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\content\ContextCompatFroyo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */