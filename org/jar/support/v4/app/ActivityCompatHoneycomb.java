package org.jar.support.v4.app;

import android.app.Activity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class ActivityCompatHoneycomb {
  static void dump(Activity paramActivity, String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    paramActivity.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  static void invalidateOptionsMenu(Activity paramActivity) {
    paramActivity.invalidateOptionsMenu();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\app\ActivityCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */