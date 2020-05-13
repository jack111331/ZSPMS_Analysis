package com.unionpay;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.b;
import com.unionpay.utils.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

final class a extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    DownloadManager downloadManager = (DownloadManager)paramContext.getSystemService("download");
    long l1 = paramIntent.getLongExtra("extra_download_id", -1L);
    long l2 = UPUtils.c(paramContext, "id");
    if (l2 == l1) {
      Intent intent = new Intent("android.intent.action.VIEW");
      Uri uri = downloadManager.getUriForDownloadedFile(l2);
      String str = "";
      if (uri != null) {
        String str1;
        try {
          File file = new File();
          this(uri.getPath());
          FileInputStream fileInputStream = new FileInputStream();
          this(file);
          String str2 = paramContext.getFilesDir().getAbsolutePath();
          if (str2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            this();
            str1 = stringBuilder.append(str2).append(File.separator).append(UPPayAssistEx.a()).toString();
            FileOutputStream fileOutputStream = paramContext.openFileOutput(UPPayAssistEx.a(), 1);
            byte[] arrayOfByte = new byte[1024];
            while (true) {
              int i = fileInputStream.read(arrayOfByte);
              if (i > 0) {
                fileOutputStream.write(arrayOfByte, 0, i);
                continue;
              } 
              fileOutputStream.close();
              fileInputStream.close();
              break;
            } 
          } 
        } catch (Exception exception) {
          exception.printStackTrace();
          str1 = uri.getPath();
        } 
        try {
          String str2 = b.b(str1);
          if (UPPayAssistEx.b().equalsIgnoreCase(str2)) {
            if (!UPPayAssistEx.checkInstalled(UPPayAssistEx.c())) {
              StringBuilder stringBuilder = new StringBuilder();
              this("file:");
              intent.setDataAndType(Uri.parse(stringBuilder.append(str1).toString()), UPPayAssistEx.d());
              intent.addFlags(268435456);
              paramContext.startActivity(intent);
            } 
          } else {
            b.c(uri.getPath());
          } 
        } catch (FileNotFoundException fileNotFoundException) {}
        h.b("uppay", "downloadFileUri" + uri);
      } 
      paramContext.unregisterReceiver(UPPayAssistEx.e());
      UPPayAssistEx.f();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */