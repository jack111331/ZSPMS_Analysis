package org.jar.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;

@TargetApi(19)
class ContextCompatKitKat {
  public static File[] getExternalCacheDirs(Context paramContext) {
    return paramContext.getExternalCacheDirs();
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString) {
    return paramContext.getExternalFilesDirs(paramString);
  }
  
  public static File[] getObbDirs(Context paramContext) {
    return paramContext.getObbDirs();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\content\ContextCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */