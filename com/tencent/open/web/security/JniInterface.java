package com.tencent.open.web.security;

import android.content.Context;
import com.tencent.connect.auth.AuthAgent;
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import java.io.File;

public class JniInterface {
  public static boolean isJniOk = false;
  
  public static native boolean BackSpaceChar(boolean paramBoolean, int paramInt);
  
  public static native boolean clearAllPWD();
  
  public static native String getPWDKeyToMD5(String paramString);
  
  public static native boolean insetTextToArray(int paramInt1, String paramString, int paramInt2);
  
  public static void loadSo() {
    if (!isJniOk) {
      try {
        Context context = d.a();
        if (context != null) {
          File file = new File();
          StringBuilder stringBuilder2 = new StringBuilder();
          this();
          this(stringBuilder2.append(context.getFilesDir().toString()).append("/").append(AuthAgent.SECURE_LIB_NAME).toString());
          if (file.exists()) {
            stringBuilder2 = new StringBuilder();
            this();
            System.load(stringBuilder2.append(context.getFilesDir().toString()).append("/").append(AuthAgent.SECURE_LIB_NAME).toString());
            isJniOk = true;
            StringBuilder stringBuilder3 = new StringBuilder();
            this();
            f.c("openSDK_LOG.JniInterface", stringBuilder3.append("-->load lib success:").append(AuthAgent.SECURE_LIB_NAME).toString());
            return;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          this();
          f.c("openSDK_LOG.JniInterface", stringBuilder1.append("-->fail, because so is not exists:").append(AuthAgent.SECURE_LIB_NAME).toString());
          return;
        } 
      } catch (Throwable throwable) {
        f.b("openSDK_LOG.JniInterface", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, throwable);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      f.c("openSDK_LOG.JniInterface", stringBuilder.append("-->load lib fail, because context is null:").append(AuthAgent.SECURE_LIB_NAME).toString());
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\web\security\JniInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */