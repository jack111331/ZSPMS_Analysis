package com.hu.scan.permission.a;

import android.os.Environment;
import java.io.File;

class x implements o {
  public boolean a() {
    File file = Environment.getExternalStorageDirectory();
    boolean bool = file.exists();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (bool) {
      bool2 = bool1;
      if (file.canRead()) {
        long l = file.lastModified();
        String[] arrayOfString = file.list();
        bool2 = bool1;
        if (l > 0L) {
          bool2 = bool1;
          if (arrayOfString != null)
            bool2 = true; 
        } 
      } 
    } 
    return bool2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */