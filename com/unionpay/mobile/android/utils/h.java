package com.unionpay.mobile.android.utils;

import android.content.res.ColorStateList;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import java.util.Arrays;

public final class h {
  private static final int[] a = new int[] { 16842910 };
  
  private static final int[] b = new int[] { 16842908 };
  
  private static final int[] c = new int[] { -16842910 };
  
  private static final int[] d = new int[] { 16842910, 16842919 };
  
  private static final int[] e = new int[] { 16842910, 16842908 };
  
  private static final int[] f = new int[] { 16842910, 16842912 };
  
  public static ColorStateList a(int paramInt1, int paramInt2) {
    return a(paramInt1, paramInt2, paramInt2, paramInt1);
  }
  
  public static ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return new ColorStateList(new int[][] { { 16842919, 16842910 }, , { 16842910, 16842908 }, , { 16842910 }, , { 16842908 }, , { 16842909 }, , {} }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt4 });
  }
  
  public static Drawable a(int paramInt, int[] paramArrayOfint, float[] paramArrayOffloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RoundRectShape(a(paramInt, 18.0F), null, null));
    LinearGradient linearGradient = new LinearGradient(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramArrayOfint, paramArrayOffloat, Shader.TileMode.CLAMP);
    shapeDrawable.getPaint().setShader((Shader)linearGradient);
    return (Drawable)shapeDrawable;
  }
  
  public static Drawable a(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4) {
    StateListDrawable stateListDrawable = new StateListDrawable();
    stateListDrawable.addState(d, paramDrawable2);
    stateListDrawable.addState(e, paramDrawable2);
    if (paramDrawable4 != null)
      stateListDrawable.addState(f, paramDrawable4); 
    stateListDrawable.addState(a, paramDrawable1);
    stateListDrawable.addState(b, paramDrawable2);
    if (paramDrawable3 != null)
      stateListDrawable.addState(c, paramDrawable3); 
    return (Drawable)stateListDrawable;
  }
  
  public static ShapeDrawable a(int paramInt1, int paramInt2, float paramFloat) {
    ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RoundRectShape(a(paramInt2, paramFloat), null, null));
    shapeDrawable.getPaint().setStrokeWidth(1.0F);
    shapeDrawable.getPaint().setColor(paramInt1);
    shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    return shapeDrawable;
  }
  
  private static float[] a(int paramInt, float paramFloat) {
    float[] arrayOfFloat = new float[8];
    Arrays.fill(arrayOfFloat, 0.0F);
    if (paramInt != 0) {
      if ((paramInt & 0x1) != 0) {
        arrayOfFloat[1] = paramFloat;
        arrayOfFloat[0] = paramFloat;
      } 
      if ((paramInt & 0x2) != 0) {
        arrayOfFloat[3] = paramFloat;
        arrayOfFloat[2] = paramFloat;
      } 
      if ((paramInt & 0x4) != 0) {
        arrayOfFloat[5] = paramFloat;
        arrayOfFloat[4] = paramFloat;
      } 
      if ((paramInt & 0x8) != 0) {
        arrayOfFloat[7] = paramFloat;
        arrayOfFloat[6] = paramFloat;
      } 
    } 
    return arrayOfFloat;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */