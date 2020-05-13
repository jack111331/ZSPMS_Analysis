package com.zz.sdk.lib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import java.lang.reflect.Field;

public class LinesGridView extends CustomGridView {
  private boolean a;
  
  public LinesGridView(Context paramContext) {
    super(paramContext);
  }
  
  public LinesGridView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public LinesGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Path a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    if (paramPath != null) {
      paramPath.reset();
      paramPath.moveTo(paramFloat1, paramFloat2);
      paramPath.lineTo(paramFloat3, paramFloat4);
    } 
    return paramPath;
  }
  
  private int getColumn() {
    boolean bool2;
    boolean bool1 = true;
    try {
      Field field = GridView.class.getDeclaredField("mNumColumns");
      field.setAccessible(true);
      bool2 = field.getInt(this);
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
      bool2 = bool1;
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      bool2 = bool1;
    } 
    return bool2;
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    int i = getChildCount();
    Paint paint = new Paint();
    paint.setStyle(Paint.Style.STROKE);
    paint.setColor(Color.parseColor("#dedede"));
    paint.setAntiAlias(true);
    paint.setStrokeWidth(2.0F);
    paint.setPathEffect((PathEffect)new DashPathEffect(new float[] { 4.0F, 4.0F }, 0.0F));
    Path path = new Path();
    int j = getColumn();
    for (byte b = 0; b < i; b++) {
      View view = getChildAt(b);
      path = a(path, view.getLeft(), (view.getTop() + 1), view.getRight(), (view.getTop() + 1));
      paramCanvas.drawPath(path, paint);
      Path path1 = path;
      if (b % j != 0) {
        path1 = a(path, (view.getLeft() + 1), view.getTop(), (view.getLeft() + 1), view.getBottom());
        paramCanvas.drawPath(path1, paint);
      } 
      path = path1;
      if (b + j >= i) {
        path = a(path1, view.getLeft(), (view.getBottom() + 1), view.getRight(), (view.getBottom() + 1));
        paramCanvas.drawPath(path, paint);
      } 
      path1 = path;
      if (i % j != 0) {
        path1 = path;
        if (b == i - 1) {
          path1 = a(path, (view.getRight() + 1), (view.getTop() + 1), (view.getRight() + 1), (view.getBottom() + 1));
          paramCanvas.drawPath(path1, paint);
        } 
      } 
      path = path1;
      if (this.a) {
        Path path2 = path1;
        if (b % j == 0) {
          path2 = a(path1, (view.getLeft() + 1), view.getTop(), (view.getLeft() + 1), view.getBottom());
          paramCanvas.drawPath(path2, paint);
        } 
        path = path2;
        if (b % j == j - 1) {
          path = a(path2, (view.getRight() + 1), view.getTop(), (view.getRight() + 1), view.getBottom());
          paramCanvas.drawPath(path, paint);
        } 
      } 
    } 
  }
  
  public void setSideLine(boolean paramBoolean) {
    this.a = paramBoolean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\LinesGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */