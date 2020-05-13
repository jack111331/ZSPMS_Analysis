package com.hu.scan.permission.a;

import android.os.Environment;
import java.io.File;

class y implements o {
  public boolean a() {
    File file = Environment.getExternalStorageDirectory();
    if (!file.exists() || !file.canWrite())
      return false; 
    file = new File(file, "ANDROID.PERMISSION.TEST");
    return file.exists() ? file.delete() : file.createNewFile();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\scan\permission\a\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */