package org.jar.support.v4.content;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

@TargetApi(21)
class ContextCompatApi21 {
  public static File getCodeCacheDir(Context paramContext) {
    return paramContext.getCodeCacheDir();
  }
  
  public static Drawable getDrawable(Context paramContext, int paramInt) {
    return paramContext.getDrawable(paramInt);
  }
  
  public static File getNoBackupFilesDir(Context paramContext) {
    return paramContext.getNoBackupFilesDir();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\content\ContextCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */