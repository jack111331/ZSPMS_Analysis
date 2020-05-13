package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {
  private static void delete(File paramFile) {
    if (paramFile == null || !paramFile.exists() || paramFile.delete())
      return; 
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramFile.getAbsolutePath()));
    stringBuilder.append(" doesn't be deleted!");
    throw new RuntimeException(stringBuilder.toString());
  }
  
  private static boolean deleteDependon(String paramString) {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1)
      return false; 
    File file = new File(paramString);
    byte b = 1;
    while (!bool2 && b <= 5 && file.isFile() && file.exists()) {
      bool1 = file.delete();
      bool2 = bool1;
      if (!bool1) {
        b++;
        bool2 = bool1;
      } 
    } 
    return bool2;
  }
  
  private static boolean isFileExisted(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : ((new File(paramString)).exists());
  }
  
  private static boolean isParentExist(File paramFile) {
    if (paramFile == null)
      return false; 
    File file = paramFile.getParentFile();
    return (file != null && !file.exists()) ? (!(!paramFile.exists() && !paramFile.mkdirs())) : false;
  }
  
  public static boolean isWifi(Context paramContext) {
    NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (networkInfo != null && networkInfo.getType() == 1);
  }
  
  private static void makesureFileExist(String paramString) {
    if (paramString == null)
      return; 
    File file = new File(paramString);
    if (!file.exists() && isParentExist(file)) {
      if (file.exists())
        delete(file); 
      try {
        file.createNewFile();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
    } 
  }
  
  private static void revitionImageSize(String paramString, int paramInt1, int paramInt2) throws IOException {
    if (paramInt1 > 0) {
      if (!isFileExisted(paramString)) {
        String str = paramString;
        if (paramString == null)
          str = "null"; 
        throw new FileNotFoundException(str);
      } 
      if (BitmapHelper.verifyBitmap(paramString)) {
        FileInputStream fileInputStream = new FileInputStream(paramString);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(fileInputStream, null, options);
        try {
          fileInputStream.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        for (byte b = 0;; b++) {
          if (options.outWidth >> b <= paramInt1 && options.outHeight >> b <= paramInt1) {
            options.inSampleSize = (int)Math.pow(2.0D, b);
            options.inJustDecodeBounds = false;
            Bitmap bitmap = safeDecodeBimtapFile(paramString, options);
            if (bitmap != null) {
              deleteDependon(paramString);
              makesureFileExist(paramString);
              FileOutputStream fileOutputStream = new FileOutputStream(paramString);
              if (options.outMimeType != null && options.outMimeType.contains("png")) {
                bitmap.compress(Bitmap.CompressFormat.PNG, paramInt2, fileOutputStream);
              } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, paramInt2, fileOutputStream);
              } 
              try {
                fileOutputStream.close();
              } catch (Exception exception) {
                exception.printStackTrace();
              } 
              bitmap.recycle();
              return;
            } 
            throw new IOException("Bitmap decode error!");
          } 
        } 
      } 
      throw new IOException("");
    } 
    throw new IllegalArgumentException("size must be greater than 0!");
  }
  
  private static void revitionImageSizeHD(String paramString, int paramInt1, int paramInt2) throws IOException {
    if (paramInt1 > 0) {
      if (!isFileExisted(paramString)) {
        String str = paramString;
        if (paramString == null)
          str = "null"; 
        throw new FileNotFoundException(str);
      } 
      if (BitmapHelper.verifyBitmap(paramString)) {
        int i = paramInt1 * 2;
        FileInputStream fileInputStream = new FileInputStream(paramString);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(fileInputStream, null, options);
        try {
          fileInputStream.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        for (int j = 0;; j++) {
          if (options.outWidth >> j <= i && options.outHeight >> j <= i) {
            options.inSampleSize = (int)Math.pow(2.0D, j);
            options.inJustDecodeBounds = false;
            Bitmap bitmap = safeDecodeBimtapFile(paramString, options);
            if (bitmap != null) {
              deleteDependon(paramString);
              makesureFileExist(paramString);
              if (bitmap.getWidth() > bitmap.getHeight()) {
                j = bitmap.getWidth();
              } else {
                j = bitmap.getHeight();
              } 
              float f = paramInt1 / j;
              Bitmap bitmap1 = bitmap;
              if (f < 1.0F)
                while (true) {
                  try {
                    bitmap1 = Bitmap.createBitmap((int)(bitmap.getWidth() * f), (int)(bitmap.getHeight() * f), Bitmap.Config.ARGB_8888);
                    if (bitmap1 == null)
                      bitmap.recycle(); 
                    Canvas canvas = new Canvas(bitmap1);
                    Matrix matrix = new Matrix();
                    matrix.setScale(f, f);
                    canvas.drawBitmap(bitmap, matrix, new Paint());
                    bitmap.recycle();
                    break;
                  } catch (OutOfMemoryError outOfMemoryError) {
                    System.gc();
                    double d = f;
                    Double.isNaN(d);
                    f = (float)(d * 0.8D);
                  } 
                }  
              FileOutputStream fileOutputStream = new FileOutputStream(paramString);
              if (options.outMimeType != null && options.outMimeType.contains("png")) {
                outOfMemoryError.compress(Bitmap.CompressFormat.PNG, paramInt2, fileOutputStream);
              } else {
                outOfMemoryError.compress(Bitmap.CompressFormat.JPEG, paramInt2, fileOutputStream);
              } 
              try {
                fileOutputStream.close();
              } catch (Exception exception) {
                exception.printStackTrace();
              } 
              outOfMemoryError.recycle();
              return;
            } 
            throw new IOException("Bitmap decode error!");
          } 
        } 
      } 
      throw new IOException("");
    } 
    throw new IllegalArgumentException("size must be greater than 0!");
  }
  
  public static boolean revitionPostImageSize(Context paramContext, String paramString) {
    try {
      if (NetworkHelper.isWifiValid(paramContext)) {
        revitionImageSizeHD(paramString, 1600, 75);
      } else {
        revitionImageSize(paramString, 1024, 75);
      } 
      return true;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return false;
    } 
  }
  
  private static Bitmap safeDecodeBimtapFile(String paramString, BitmapFactory.Options paramOptions) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 20
    //   4: new android/graphics/BitmapFactory$Options
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: astore_2
    //   12: aload_2
    //   13: iconst_1
    //   14: putfield inSampleSize : I
    //   17: goto -> 22
    //   20: aload_1
    //   21: astore_2
    //   22: iconst_0
    //   23: istore_3
    //   24: aconst_null
    //   25: astore #4
    //   27: aload #4
    //   29: astore #5
    //   31: iload_3
    //   32: iconst_5
    //   33: if_icmplt -> 39
    //   36: goto -> 99
    //   39: new java/io/FileInputStream
    //   42: astore #6
    //   44: aload #6
    //   46: aload_0
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: aload #6
    //   52: aconst_null
    //   53: aload_1
    //   54: invokestatic decodeStream : (Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   57: astore #7
    //   59: aload #6
    //   61: invokevirtual close : ()V
    //   64: goto -> 87
    //   67: astore #4
    //   69: aload #7
    //   71: astore #5
    //   73: aload #4
    //   75: astore #7
    //   77: goto -> 108
    //   80: astore #5
    //   82: aload #5
    //   84: invokevirtual printStackTrace : ()V
    //   87: aload #7
    //   89: astore #5
    //   91: goto -> 99
    //   94: astore #7
    //   96: goto -> 108
    //   99: aload #5
    //   101: areturn
    //   102: astore #7
    //   104: aload #4
    //   106: astore #6
    //   108: aload #7
    //   110: invokevirtual printStackTrace : ()V
    //   113: aload_2
    //   114: aload_2
    //   115: getfield inSampleSize : I
    //   118: iconst_2
    //   119: imul
    //   120: putfield inSampleSize : I
    //   123: aload #6
    //   125: invokevirtual close : ()V
    //   128: goto -> 138
    //   131: astore #7
    //   133: aload #7
    //   135: invokevirtual printStackTrace : ()V
    //   138: iinc #3, 1
    //   141: aload #6
    //   143: astore #4
    //   145: goto -> 31
    //   148: astore_0
    //   149: goto -> 99
    //   152: astore_0
    //   153: goto -> 87
    // Exception table:
    //   from	to	target	type
    //   39	50	102	java/lang/OutOfMemoryError
    //   39	50	148	java/io/FileNotFoundException
    //   50	59	94	java/lang/OutOfMemoryError
    //   50	59	148	java/io/FileNotFoundException
    //   59	64	80	java/io/IOException
    //   59	64	67	java/lang/OutOfMemoryError
    //   59	64	152	java/io/FileNotFoundException
    //   82	87	67	java/lang/OutOfMemoryError
    //   82	87	152	java/io/FileNotFoundException
    //   123	128	131	java/io/IOException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sd\\utils\ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */