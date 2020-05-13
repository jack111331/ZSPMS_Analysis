package com.zz.sdk.lib.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class VerificationCodeView extends View {
  private static final int a = 4;
  
  private static final int b = 3;
  
  private String A;
  
  private boolean B = false;
  
  private int c = 20;
  
  private float[] d = new float[this.c * 2];
  
  private float[] e = new float[this.c * 2];
  
  private int f = 16777215;
  
  private int g = -2302216;
  
  private RectF h;
  
  private Rect i;
  
  private Paint j;
  
  private Paint k;
  
  private Paint l;
  
  private Paint m;
  
  private String n;
  
  private int o = 4;
  
  private Random p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private int u = 0;
  
  private boolean v = false;
  
  private Bitmap w;
  
  private Bitmap x;
  
  private ArrayList y = new ArrayList();
  
  private float z = 5.0F;
  
  public VerificationCodeView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public VerificationCodeView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerificationCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  public static float a(Context paramContext, float paramFloat) {
    return a(paramContext, paramFloat, 2);
  }
  
  private static float a(Context paramContext, float paramFloat, int paramInt) {
    return TypedValue.applyDimension(paramInt, paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  private void b() {
    this.p = new Random();
    this.j = new Paint();
    this.j.setAntiAlias(true);
    this.j.setColor(this.f);
    this.m = new Paint();
    this.m.setAntiAlias(true);
    this.m.setStyle(Paint.Style.STROKE);
    this.m.setColor(-16777216);
    this.m.setStrokeWidth(5.0F);
    this.m.setStrokeCap(Paint.Cap.ROUND);
    this.k = new Paint();
    this.k.setAntiAlias(true);
    this.k.setStyle(Paint.Style.STROKE);
    this.k.setColor(Color.parseColor("#a1a1a1"));
    this.k.setStrokeWidth(5.0F);
    this.l = new Paint();
    this.l.setAntiAlias(true);
    this.l.setTextSize(a(getContext(), 25.0F));
    this.l.setShadowLayer(5.0F, 3.0F, 3.0F, -6710887);
    this.l.setTypeface(Typeface.DEFAULT_BOLD);
    this.l.setTextScaleX(0.8F);
    this.l.setColor(-16711936);
    this.i = new Rect();
  }
  
  private void c() {
    if (this.v && this.p != null) {
      this.y.clear();
      byte b1;
      for (b1 = 0; b1 < 2; b1++) {
        Path path = new Path();
        int i = this.p.nextInt(this.q / 3) + 10;
        int j = this.p.nextInt(this.s / 3) + 10;
        int k = this.p.nextInt(this.q / 2) + this.q / 2 - 10;
        int m = this.p.nextInt(this.s / 2) + this.s / 2 - 10;
        path.moveTo(i, j);
        path.quadTo((Math.abs(k - i) / 2), (Math.abs(m - j) / 2), k, m);
        this.y.add(path);
      } 
      this.w = Bitmap.createBitmap(this.q, this.s, Bitmap.Config.ARGB_8888);
      this.x = Bitmap.createBitmap(this.q, this.s, Bitmap.Config.ARGB_8888);
      Canvas canvas2 = new Canvas(this.w);
      Canvas canvas1 = new Canvas(this.x);
      this.n = getCharAndNumr();
      canvas2.drawColor(this.f);
      canvas2.drawRect(0.0F, 0.0F, this.q, this.s, this.k);
      if (this.n != null && this.n.length() > 0) {
        this.l.setTextSize(this.r * 0.3F);
        this.l.getTextBounds(this.n, 0, this.o, this.i);
        float f = (this.i.width() / this.o);
        for (b1 = 0; b1 < this.o; b1++) {
          int i = this.p.nextInt(15);
          if (this.p.nextInt(2) != 1)
            i = -i; 
          canvas2.save();
          canvas2.rotate(i, (this.q / 2), (this.s / 2));
          this.l.setARGB(255, this.p.nextInt(200) + 20, this.p.nextInt(200) + 20, this.p.nextInt(200) + 20);
          canvas2.drawText(String.valueOf(this.n.charAt(b1)), b1 * f * 1.6F + 20.0F + this.u, (this.s * 2) / 3.0F, this.l);
          canvas2.restore();
        } 
      } 
      float f1 = this.w.getWidth();
      float f2 = this.w.getHeight();
      byte b2 = 0;
      b1 = 0;
      while (b2 < 4) {
        float f = f2 / 3.0F;
        f = b2 * f;
        for (byte b = 0; b < 5; b++) {
          float f3 = f1 / 4.0F * b;
          float[] arrayOfFloat = this.e;
          this.d[b1 * 2 + 0] = f3;
          arrayOfFloat[b1 * 2 + 0] = f3;
          arrayOfFloat = this.e;
          this.d[b1 * 2 + 1] = f;
          arrayOfFloat[b1 * 2 + 1] = f;
          b1++;
        } 
        b2++;
      } 
      this.z = f2 / 3.0F / 3.0F;
      this.d[12] = this.d[12] - this.z;
      this.d[13] = this.d[13] + this.z;
      this.d[16] = this.d[16] + this.z;
      this.d[17] = this.d[17] - this.z;
      this.d[24] = this.d[24] + this.z;
      this.d[25] = this.d[25] + this.z;
      canvas1.drawBitmapMesh(this.w, 4, 3, this.d, 0, null, 0, null);
      Iterator<Path> iterator = this.y.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Path path = iterator.next();
          this.m.setARGB(255, this.p.nextInt(200) + 20, this.p.nextInt(200) + 20, this.p.nextInt(200) + 20);
          canvas1.drawPath(path, this.m);
          continue;
        } 
        return;
      } 
    } 
  }
  
  public void a() {
    c();
    invalidate();
  }
  
  public String getCharAndNumr() {
    if (this.B)
      return this.A; 
    Random random = new Random();
    String str = "";
    byte b = 0;
    while (b < this.o) {
      String str1;
      String str2;
      if (random.nextInt(2) % 2 == 0) {
        str1 = "char";
      } else {
        str1 = "num";
      } 
      if ("char".equalsIgnoreCase(str1)) {
        byte b1;
        if (random.nextInt(2) % 2 == 0) {
          b1 = 65;
        } else {
          b1 = 97;
        } 
        str2 = str + (char)(b1 + random.nextInt(26));
      } else {
        str2 = str;
        if ("num".equalsIgnoreCase(str1))
          str2 = str + String.valueOf(random.nextInt(10)); 
      } 
      b++;
      str = str2;
    } 
    this.A = str;
    return str;
  }
  
  public String getvCode() {
    return this.A;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    paramCanvas.drawBitmap(this.x, 0.0F, 0.0F, null);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i == Integer.MIN_VALUE && paramInt1 == Integer.MIN_VALUE) {
      setMeasuredDimension(this.q, this.q);
      return;
    } 
    if (i == Integer.MIN_VALUE) {
      setMeasuredDimension(this.q, paramInt2);
      return;
    } 
    if (paramInt1 == Integer.MIN_VALUE)
      setMeasuredDimension(j, this.q); 
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = new RectF(getLeft(), getTop(), getRight(), getBottom());
    paramInt1 = (int)(this.h.right - this.h.left);
    this.r = paramInt1;
    this.q = paramInt1;
    paramInt1 = (int)(this.h.bottom - this.h.top);
    this.t = paramInt1;
    this.s = paramInt1;
    if (this.q * 1.0D / this.s > 2.5D) {
      this.r = (int)(this.s * 5.0D / 2.0D);
    } else if (this.q * 1.0D / this.s < 2.5D) {
      this.t = (int)(this.q / 5.0D * 2.0D);
    } 
    this.u = (this.q - this.r) / 2;
    this.v = true;
    c();
  }
  
  public void setNetCode(boolean paramBoolean) {
    this.B = paramBoolean;
  }
  
  public void setvCode(String paramString) {
    this.A = paramString;
    a();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\lib\widget\VerificationCodeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */