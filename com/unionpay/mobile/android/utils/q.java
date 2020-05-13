package com.unionpay.mobile.android.utils;

import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public final class q {
  public static boolean a(byte[] paramArrayOfbyte) {
    boolean bool = false;
    File file = new File(Environment.getExternalStorageDirectory(), "UPPay");
    file.mkdir();
    file = new File(file, "UPPayPluginEx.apk");
    try {
      file.createNewFile();
      FileOutputStream fileOutputStream = new FileOutputStream();
      this(file);
      fileOutputStream.write(paramArrayOfbyte);
      fileOutputStream.close();
      bool = true;
    } catch (IOException iOException) {
      k.a("uppay", "write2file error!!!!");
      iOException.printStackTrace();
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */