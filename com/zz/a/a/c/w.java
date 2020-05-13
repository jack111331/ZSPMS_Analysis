package com.zz.a.a.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileDescriptor;

public class w extends x {
  private static final String e = "ImageResizer";
  
  protected int a;
  
  protected int b;
  
  public w(Context paramContext, int paramInt) {
    super(paramContext);
    a(paramInt);
  }
  
  public w(Context paramContext, int paramInt1, int paramInt2) {
    super(paramContext);
    a(paramInt1, paramInt2);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2) {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int k = 1;
    if (i > paramInt2 || j > paramInt1) {
      int m = Math.round(i / paramInt2);
      k = Math.round(j / paramInt1);
      if (m >= k)
        m = k; 
      float f1 = (j * i);
      float f2 = (paramInt1 * paramInt2 * 2);
      while (true) {
        k = m;
        if (f1 / (m * m) > f2) {
          m++;
          continue;
        } 
        break;
      } 
    } 
    return k;
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3, r paramr) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, options);
    options.inSampleSize = a(options, paramInt2, paramInt3);
    if (ac.c())
      a(options, paramr); 
    options.inJustDecodeBounds = false;
    return BitmapFactory.decodeResource(paramResources, paramInt1, options);
  }
  
  public static Bitmap a(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2, r paramr) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, options);
    options.inSampleSize = a(options, paramInt1, paramInt2);
    options.inJustDecodeBounds = false;
    if (ac.c())
      a(options, paramr); 
    return BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, options);
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, r paramr) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    options.inSampleSize = a(options, paramInt1, paramInt2);
    if (ac.c())
      a(options, paramr); 
    options.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, options);
  }
  
  @TargetApi(11)
  private static void a(BitmapFactory.Options paramOptions, r paramr) {
    paramOptions.inMutable = true;
    if (paramr != null) {
      Bitmap bitmap = paramr.a(paramOptions);
      if (bitmap != null)
        paramOptions.inBitmap = bitmap; 
    } 
  }
  
  private Bitmap c(int paramInt) {
    return a(this.d, paramInt, this.a, this.b, f());
  }
  
  protected Bitmap a(Object paramObject) {
    return c(Integer.parseInt(String.valueOf(paramObject)));
  }
  
  public void a(int paramInt) {
    a(paramInt, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\a\c\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */