package com.herosdk.d;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.webkit.WebView;
import com.herosdk.error.ErrorUtils;
import java.io.File;
import java.io.FileOutputStream;

public class av {
  public static void a(WebView paramWebView) {
    try {
      Bitmap bitmap = b(paramWebView);
      if (bitmap != null)
        a(x.a().x(), bitmap); 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static boolean a(Activity paramActivity, Bitmap paramBitmap) {
    boolean bool2;
    boolean bool1 = false;
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      String str1 = stringBuilder1.append(Environment.getExternalStorageDirectory().getAbsolutePath()).append(File.separator).append("sysHuGallery").toString();
      File file1 = new File();
      this(str1);
      if (!file1.exists())
        file1.mkdir(); 
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      String str2 = stringBuilder2.append(System.currentTimeMillis()).append(".png").toString();
      File file2 = new File();
      this(file1, str2);
      FileOutputStream fileOutputStream = new FileOutputStream();
      this(file2);
      boolean bool = paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
      fileOutputStream.flush();
      fileOutputStream.close();
      Uri uri = Uri.fromFile(file2);
      Intent intent = new Intent();
      this("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri);
      paramActivity.sendBroadcast(intent);
      bool2 = bool1;
      if (bool) {
        aw aw = new aw();
        this(paramActivity);
        bb.a(aw);
        bool2 = true;
      } 
    } catch (Exception exception) {
      bool2 = bool1;
    } 
    return bool2;
  }
  
  private static Bitmap b(WebView paramWebView) {
    try {
      Bitmap bitmap = paramWebView.getDrawingCache();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      exception = null;
    } 
    return (Bitmap)exception;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */