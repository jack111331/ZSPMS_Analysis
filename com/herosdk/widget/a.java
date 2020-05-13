package com.herosdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class a {
  private static Map<String, Bitmap> a = new HashMap<String, Bitmap>();
  
  private static int b;
  
  public static Bitmap a(Context paramContext, String paramString) {
    if (a.containsKey(paramString))
      return a.get(paramString); 
    try {
      InputStream inputStream = paramContext.getAssets().open(paramString);
    } catch (IOException iOException) {
      iOException = null;
      if (iOException != null)
        return (Bitmap)paramString; 
    } finally {
      paramString = null;
    } 
    if (paramContext != null)
      try {
        paramContext.close();
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    throw paramString;
  }
  
  public static Drawable a(Context paramContext, Bitmap paramBitmap) {
    if (paramBitmap == null)
      return null; 
    if (b == 0) {
      DisplayMetrics displayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
      b = displayMetrics.densityDpi;
    } 
    BitmapDrawable bitmapDrawable = new BitmapDrawable(paramBitmap);
    bitmapDrawable.setTargetDensity((int)(b * b * 1.0F / 240.0F));
    return (Drawable)bitmapDrawable;
  }
  
  public static StateListDrawable a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2) {
    StateListDrawable stateListDrawable = new StateListDrawable();
    stateListDrawable.addState(new int[] { 16842912 }, paramDrawable1);
    stateListDrawable.addState(new int[] { 16842910 }, paramDrawable2);
    return stateListDrawable;
  }
  
  public static StateListDrawable a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3) {
    StateListDrawable stateListDrawable = new StateListDrawable();
    stateListDrawable.addState(new int[] { 16842919 }, paramDrawable1);
    if (paramDrawable3 != null) {
      stateListDrawable.addState(new int[] { 16842908 }, paramDrawable3);
      stateListDrawable.addState(new int[] { 16842913 }, paramDrawable1);
      stateListDrawable.addState(new int[] { 16842910 }, paramDrawable2);
      stateListDrawable.addState(new int[0], paramDrawable2);
      return stateListDrawable;
    } 
    stateListDrawable.addState(new int[] { 16842908 }, paramDrawable1);
    stateListDrawable.addState(new int[] { 16842913 }, paramDrawable1);
    stateListDrawable.addState(new int[] { 16842910 }, paramDrawable2);
    stateListDrawable.addState(new int[0], paramDrawable2);
    return stateListDrawable;
  }
  
  public static StateListDrawable a(Context paramContext, String paramString1, String paramString2) {
    NinePatchDrawable ninePatchDrawable1;
    Drawable drawable1;
    NinePatchDrawable ninePatchDrawable2;
    if (paramString1 != null && paramString1.endsWith(".9.png")) {
      ninePatchDrawable1 = c(paramContext, paramString1);
    } else {
      drawable1 = b(paramContext, (String)ninePatchDrawable1);
    } 
    if (paramString2 != null && paramString2.endsWith(".9.png")) {
      ninePatchDrawable2 = c(paramContext, paramString2);
      return a(paramContext, drawable1, (Drawable)ninePatchDrawable2, (Drawable)null);
    } 
    Drawable drawable2 = b(paramContext, (String)ninePatchDrawable2);
    return a(paramContext, drawable1, drawable2, (Drawable)null);
  }
  
  public static StateListDrawable a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    NinePatchDrawable ninePatchDrawable1;
    Drawable drawable1;
    NinePatchDrawable ninePatchDrawable2;
    Drawable drawable2;
    NinePatchDrawable ninePatchDrawable3;
    if (paramString1 != null && paramString1.endsWith(".9.png")) {
      ninePatchDrawable1 = c(paramContext, paramString1);
    } else {
      drawable1 = b(paramContext, (String)ninePatchDrawable1);
    } 
    if (paramString2 != null && paramString2.endsWith(".9.png")) {
      ninePatchDrawable2 = c(paramContext, paramString2);
    } else {
      drawable2 = b(paramContext, (String)ninePatchDrawable2);
    } 
    if (paramString3 != null && paramString3.endsWith(".9.png")) {
      ninePatchDrawable3 = c(paramContext, paramString3);
      return a(paramContext, drawable1, drawable2, (Drawable)ninePatchDrawable3);
    } 
    Drawable drawable3 = b(paramContext, (String)ninePatchDrawable3);
    return a(paramContext, drawable1, drawable2, drawable3);
  }
  
  public static void a() {
    a.clear();
    System.gc();
  }
  
  public static void a(Bitmap paramBitmap) {
    for (String str : a.keySet()) {
      if ((Bitmap)a.get(str) == paramBitmap) {
        a.remove(str);
        break;
      } 
    } 
  }
  
  public static Drawable b(Context paramContext, String paramString) {
    return a(paramContext, a(paramContext, paramString));
  }
  
  public static NinePatchDrawable c(Context paramContext, String paramString) {
    Context context1;
    Context context2 = null;
    try {
      Bitmap bitmap = BitmapFactory.decodeStream(paramContext.getAssets().open(paramString));
      byte[] arrayOfByte = bitmap.getNinePatchChunk();
      if (!NinePatch.isNinePatchChunk(arrayOfByte))
        return (NinePatchDrawable)context2; 
      Rect rect = new Rect();
      this();
      b b = b.a(arrayOfByte);
      NinePatchDrawable ninePatchDrawable = new NinePatchDrawable();
      this(bitmap, arrayOfByte, b.c, null);
      ninePatchDrawable.getPadding(rect);
    } catch (Exception exception) {
      exception.printStackTrace();
      context1 = context2;
    } 
    return (NinePatchDrawable)context1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */