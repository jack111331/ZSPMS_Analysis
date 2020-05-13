package com.sina.weibo.sdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class BitmapHelper {
  public static int getSampleSizeAutoFitToScreen(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramInt2 == 0 || paramInt1 == 0) ? 1 : Math.min(Math.max(paramInt3 / paramInt1, paramInt4 / paramInt2), Math.max(paramInt4 / paramInt1, paramInt3 / paramInt2));
  }
  
  public static int getSampleSizeOfNotTooLarge(Rect paramRect) {
    boolean bool;
    double d1 = paramRect.width();
    double d2 = paramRect.height();
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = d1 * d2 * 2.0D / 5242880.0D;
    if (d1 >= 1.0D) {
      bool = (int)d1;
    } else {
      bool = true;
    } 
    return bool;
  }
  
  public static boolean makesureSizeNotTooLarge(Rect paramRect) {
    return !(paramRect.width() * paramRect.height() * 2 > 5242880);
  }
  
  public static boolean verifyBitmap(InputStream paramInputStream) {
    if (paramInputStream == null)
      return false; 
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    if (!(paramInputStream instanceof BufferedInputStream))
      paramInputStream = new BufferedInputStream(paramInputStream); 
    BitmapFactory.decodeStream(paramInputStream, null, options);
    try {
      paramInputStream.close();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    return (options.outHeight > 0 && options.outWidth > 0);
  }
  
  public static boolean verifyBitmap(String paramString) {
    try {
      FileInputStream fileInputStream = new FileInputStream();
      this(paramString);
      return verifyBitmap(fileInputStream);
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      return false;
    } 
  }
  
  public static boolean verifyBitmap(byte[] paramArrayOfbyte) {
    return verifyBitmap(new ByteArrayInputStream(paramArrayOfbyte));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sd\\utils\BitmapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */