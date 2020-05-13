package com.hu.zxlib.c;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;

public class g {
  @TargetApi(19)
  public static String a(Context paramContext, Uri paramUri) {
    String str = null;
    if (paramContext != null && paramUri != null) {
      StringBuilder stringBuilder;
      Uri uri;
      if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(paramContext, paramUri)) {
        String[] arrayOfString;
        if (a(paramUri)) {
          arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
          if ("primary".equalsIgnoreCase(arrayOfString[0])) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory());
            stringBuilder.append("/");
            stringBuilder.append(arrayOfString[1]);
            return stringBuilder.toString();
          } 
        } else {
          String str1;
          if (b((Uri)arrayOfString)) {
            str1 = DocumentsContract.getDocumentId((Uri)arrayOfString);
            return a((Context)stringBuilder, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(str1).longValue()), null, null);
          } 
          if (c((Uri)str1)) {
            String[] arrayOfString1 = DocumentsContract.getDocumentId((Uri)str1).split(":");
            String str2 = arrayOfString1[0];
            if ("image".equals(str2)) {
              uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str2)) {
              uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
              str1 = str;
              if ("audio".equals(str2))
                uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI; 
            } 
            return a((Context)stringBuilder, uri, "_id=?", new String[] { arrayOfString1[1] });
          } 
        } 
      } else {
        if ("content".equalsIgnoreCase(uri.getScheme()))
          return d(uri) ? uri.getLastPathSegment() : a((Context)stringBuilder, uri, null, null); 
        if ("file".equalsIgnoreCase(uri.getScheme()))
          return uri.getPath(); 
      } 
    } 
    return null;
  }
  
  public static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString) {
    try {
      Cursor cursor = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, paramString, paramArrayOfString, null);
      return null;
    } finally {
      paramUri = null;
      if (paramUri != null)
        paramUri.close(); 
    } 
  }
  
  public static boolean a(Uri paramUri) {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean b(Uri paramUri) {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean c(Uri paramUri) {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean d(Uri paramUri) {
    return "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */