package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UPRadiationView extends View {
  private List<a> a;
  
  private int b;
  
  private int c;
  
  private Context d;
  
  private Handler e;
  
  public UPRadiationView(Context paramContext) {
    this(paramContext, null);
  }
  
  public UPRadiationView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    this.a = Collections.synchronizedList(new ArrayList<a>());
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity)this.d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int i = displayMetrics.widthPixels;
    displayMetrics = new DisplayMetrics();
    ((Activity)this.d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int j = displayMetrics.heightPixels;
    if (i <= 0 || j <= 0)
      throw new RuntimeException("size illegal"); 
    this.b = i / 2;
    this.c = j / 2 - b.n;
    this.e = new t(this);
    this.e.sendEmptyMessage(0);
  }
  
  private static Paint a(int paramInt, float paramFloat) {
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setStrokeWidth(paramFloat);
    paint.setStyle(Paint.Style.FILL);
    paint.setAlpha(paramInt);
    paint.setColor(-1);
    return paint;
  }
  
  public final void a() {
    this.d = null;
    this.e.removeCallbacksAndMessages(null);
    this.e = null;
    if (this.a != null)
      this.a.clear(); 
    this.a = null;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    for (byte b = 0; b < this.a.size(); b++) {
      a a = this.a.get(b);
      paramCanvas.drawCircle(this.b, this.c, a.b, a.a);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  private final class a {
    Paint a;
    
    int b;
    
    float c;
    
    int d;
    
    private a(UPRadiationView this$0) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upwidget\UPRadiationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */