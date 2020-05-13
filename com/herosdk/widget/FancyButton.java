package com.herosdk.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.herosdk.d.au;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FancyButton extends LinearLayout {
  public static final int a = 1;
  
  public static final int b = 2;
  
  public static final int c = 3;
  
  public static final int d = 4;
  
  private int A = 0;
  
  private boolean B = false;
  
  private ImageView C;
  
  private TextView D;
  
  private TextView E;
  
  private boolean F = false;
  
  private boolean G = false;
  
  private boolean H = true;
  
  private Context e;
  
  private int f = -16777216;
  
  private int g = 0;
  
  private int h = Color.parseColor("#f6f7f9");
  
  private int i = Color.parseColor("#bec2c9");
  
  private int j = Color.parseColor("#dddfe2");
  
  private int k = -1;
  
  private int l = -1;
  
  private int m = 1;
  
  private int n = b(getContext(), 15.0F);
  
  private int o = 17;
  
  private CharSequence p = null;
  
  private Drawable q = null;
  
  private int r = b(getContext(), 15.0F);
  
  private String s = null;
  
  private int t = 1;
  
  private int u = 10;
  
  private int v = 10;
  
  private int w = 0;
  
  private int x = 0;
  
  private int y = 0;
  
  private int z = 0;
  
  public FancyButton(Context paramContext) {
    super(paramContext);
    this.e = paramContext;
    a();
  }
  
  public FancyButton(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
    int[] arrayOfInt = new int[27];
    arrayOfInt[0] = au.b(this.e, "hu_fb_defaultColor");
    arrayOfInt[1] = au.b(this.e, "hu_fb_text");
    arrayOfInt[2] = au.b(this.e, "hu_fb_textColor");
    arrayOfInt[3] = au.b(this.e, "hu_fb_iconColor");
    arrayOfInt[4] = au.b(this.e, "hu_fb_textFont");
    arrayOfInt[5] = au.b(this.e, "hu_fb_iconFont");
    arrayOfInt[6] = au.b(this.e, "hu_fb_textSize");
    arrayOfInt[7] = au.b(this.e, "hu_fb_iconResource");
    arrayOfInt[8] = au.b(this.e, "hu_fb_fontIconResource");
    arrayOfInt[9] = au.b(this.e, "hu_fb_fontIconSize");
    arrayOfInt[10] = au.b(this.e, "hu_fb_iconPosition");
    arrayOfInt[11] = au.b(this.e, "hu_fb_textPosition");
    arrayOfInt[12] = au.b(this.e, "hu_fb_textGravity");
    arrayOfInt[13] = au.b(this.e, "hu_fb_iconPaddingLeft");
    arrayOfInt[14] = au.b(this.e, "hu_fb_iconPaddingRight");
    arrayOfInt[15] = au.b(this.e, "hu_fb_iconPaddingTop");
    arrayOfInt[16] = au.b(this.e, "hu_fb_iconPaddingBottom");
    arrayOfInt[17] = au.b(this.e, "hu_fb_borderColor");
    arrayOfInt[18] = au.b(this.e, "hu_fb_borderWidth");
    arrayOfInt[19] = au.b(this.e, "hu_fb_focusColor");
    arrayOfInt[20] = au.b(this.e, "hu_fb_disabledColor");
    arrayOfInt[21] = au.b(this.e, "hu_fb_disabledTextColor");
    arrayOfInt[22] = au.b(this.e, "hu_fb_disabledBorderColor");
    arrayOfInt[23] = au.b(this.e, "hu_fb_radius");
    arrayOfInt[24] = au.b(this.e, "hu_fb_textAllCaps");
    arrayOfInt[25] = au.b(this.e, "hu_fb_ghost");
    arrayOfInt[26] = au.b(this.e, "hu_fb_useSystemFont");
    Arrays.sort(arrayOfInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, 0, 0);
    a(paramAttributeSet, typedArray, arrayOfInt);
    typedArray.recycle();
    a();
  }
  
  public static int a(Context paramContext, float paramFloat) {
    return Math.round(paramFloat / (paramContext.getResources().getDisplayMetrics()).scaledDensity);
  }
  
  @TargetApi(21)
  private Drawable a(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3) {
    RippleDrawable rippleDrawable;
    if (isEnabled())
      rippleDrawable = new RippleDrawable(ColorStateList.valueOf(this.g), paramDrawable1, paramDrawable2); 
    return (Drawable)rippleDrawable;
  }
  
  private void a() {
    f();
    this.E = b();
    this.C = d();
    this.D = c();
    if (this.C == null && this.D == null && this.E == null) {
      Button button = new Button(this.e);
      button.setText("Fancy Button");
      addView((View)button);
      return;
    } 
    removeAllViews();
    e();
    ArrayList<ImageView> arrayList = new ArrayList();
    if (this.t == 1 || this.t == 3) {
      if (this.C != null)
        arrayList.add(this.C); 
      if (this.D != null)
        arrayList.add(this.D); 
      if (this.E != null)
        arrayList.add(this.E); 
    } else {
      if (this.E != null)
        arrayList.add(this.E); 
      if (this.C != null)
        arrayList.add(this.C); 
      if (this.D != null)
        arrayList.add(this.D); 
    } 
    Iterator<ImageView> iterator = arrayList.iterator();
    while (true) {
      if (iterator.hasNext()) {
        addView((View)iterator.next());
        continue;
      } 
      return;
    } 
  }
  
  private void a(AttributeSet paramAttributeSet, TypedArray paramTypedArray, int[] paramArrayOfint) {
    this.f = paramTypedArray.getColor(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_defaultColor")), this.f);
    this.g = paramTypedArray.getColor(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_focusColor")), this.g);
    this.h = paramTypedArray.getColor(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_disabledColor")), this.h);
    setEnabled(paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "enabled", true));
    this.i = paramTypedArray.getColor(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_disabledTextColor")), this.i);
    this.j = paramTypedArray.getColor(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_disabledBorderColor")), this.j);
    this.k = paramTypedArray.getColor(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_textColor")), this.k);
    this.l = paramTypedArray.getColor(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_iconColor")), this.k);
    this.n = (int)paramTypedArray.getDimension(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_textSize")), this.n);
    this.o = paramTypedArray.getInt(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_textGravity")), this.o);
    this.y = paramTypedArray.getColor(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_borderColor")), this.y);
    this.z = (int)paramTypedArray.getDimension(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_borderWidth")), this.z);
    this.A = (int)paramTypedArray.getDimension(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_radius")), this.A);
    this.r = (int)paramTypedArray.getDimension(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_fontIconSize")), this.r);
    this.u = (int)paramTypedArray.getDimension(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_iconPaddingLeft")), this.u);
    this.v = (int)paramTypedArray.getDimension(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_iconPaddingRight")), this.v);
    this.w = (int)paramTypedArray.getDimension(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_iconPaddingTop")), this.w);
    this.x = (int)paramTypedArray.getDimension(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_iconPaddingBottom")), this.x);
    this.B = paramTypedArray.getBoolean(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_textAllCaps")), false);
    this.F = paramTypedArray.getBoolean(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_ghost")), this.F);
    this.G = paramTypedArray.getBoolean(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_useSystemFont")), this.G);
    String str2 = paramTypedArray.getString(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_text")));
    this.t = paramTypedArray.getInt(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_iconPosition")), this.t);
    String str1 = paramTypedArray.getString(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_fontIconResource")));
    paramTypedArray.getString(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_iconFont")));
    paramTypedArray.getString(Arrays.binarySearch(paramArrayOfint, au.b(this.e, "hu_fb_textFont")));
    try {
      this.q = paramTypedArray.getDrawable(au.b(this.e, "hu_fb_iconResource"));
    } catch (Exception exception) {
      this.q = null;
    } 
    if (str1 != null)
      this.s = str1; 
    if (str2 != null) {
      str1 = str2;
      if (this.B)
        str1 = str2.toUpperCase(); 
      this.p = str1;
    } 
  }
  
  public static int b(Context paramContext, float paramFloat) {
    return Math.round((paramContext.getResources().getDisplayMetrics()).scaledDensity * paramFloat);
  }
  
  private TextView b() {
    if (this.p != null) {
      int i;
      TextView textView = new TextView(this.e);
      textView.setText(this.p);
      textView.setGravity(this.o);
      if (isEnabled()) {
        i = this.k;
      } else {
        i = this.i;
      } 
      textView.setTextColor(i);
      textView.setTextSize(a(getContext(), this.n));
      textView.setSingleLine();
      textView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
      return textView;
    } 
    return null;
  }
  
  private TextView c() {
    if (this.s != null) {
      int i;
      TextView textView = new TextView(this.e);
      if (isEnabled()) {
        i = this.l;
      } else {
        i = this.i;
      } 
      textView.setTextColor(i);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      layoutParams.rightMargin = this.v;
      layoutParams.leftMargin = this.u;
      layoutParams.topMargin = this.w;
      layoutParams.bottomMargin = this.x;
      if (this.E != null) {
        if (this.t == 3 || this.t == 4) {
          layoutParams.gravity = 17;
          textView.setGravity(17);
        } else {
          textView.setGravity(16);
          layoutParams.gravity = 16;
        } 
      } else {
        layoutParams.gravity = 17;
        textView.setGravity(16);
      } 
      textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      if (!isInEditMode()) {
        textView.setTextSize(a(getContext(), this.r));
        textView.setText(this.s);
        return textView;
      } 
      textView.setTextSize(a(getContext(), this.r));
      textView.setText("O");
      return textView;
    } 
    return null;
  }
  
  private ImageView d() {
    if (this.q != null) {
      ImageView imageView = new ImageView(this.e);
      imageView.setImageDrawable(this.q);
      imageView.setPadding(this.u, this.w, this.v, this.x);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      if (this.E != null) {
        if (this.t == 3 || this.t == 4) {
          layoutParams.gravity = 17;
        } else {
          layoutParams.gravity = 8388611;
        } 
        layoutParams.rightMargin = 10;
        layoutParams.leftMargin = 10;
      } else {
        layoutParams.gravity = 16;
      } 
      imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      return imageView;
    } 
    return null;
  }
  
  @SuppressLint({"NewApi"})
  private void e() {
    GradientDrawable gradientDrawable1 = new GradientDrawable();
    gradientDrawable1.setCornerRadius(this.A);
    if (this.F) {
      gradientDrawable1.setColor(getResources().getColor(17170445));
    } else {
      gradientDrawable1.setColor(this.f);
    } 
    GradientDrawable gradientDrawable2 = new GradientDrawable();
    gradientDrawable2.setCornerRadius(this.A);
    gradientDrawable2.setColor(this.g);
    GradientDrawable gradientDrawable3 = new GradientDrawable();
    gradientDrawable3.setCornerRadius(this.A);
    gradientDrawable3.setColor(this.h);
    gradientDrawable3.setStroke(this.z, this.j);
    if (this.y != 0)
      gradientDrawable1.setStroke(this.z, this.y); 
    if (!isEnabled()) {
      gradientDrawable1.setStroke(this.z, this.j);
      if (this.F)
        gradientDrawable3.setColor(getResources().getColor(17170445)); 
    } 
    if (this.H && Build.VERSION.SDK_INT >= 21) {
      setBackground(a((Drawable)gradientDrawable1, (Drawable)gradientDrawable2, (Drawable)gradientDrawable3));
      return;
    } 
    StateListDrawable stateListDrawable = new StateListDrawable();
    GradientDrawable gradientDrawable4 = new GradientDrawable();
    gradientDrawable4.setCornerRadius(this.A);
    if (this.F) {
      gradientDrawable4.setColor(getResources().getColor(17170445));
    } else {
      gradientDrawable4.setColor(this.g);
    } 
    if (this.y != 0)
      if (this.F) {
        gradientDrawable4.setStroke(this.z, this.g);
      } else {
        gradientDrawable4.setStroke(this.z, this.y);
      }  
    if (!isEnabled())
      if (this.F) {
        gradientDrawable4.setStroke(this.z, this.j);
      } else {
        gradientDrawable4.setStroke(this.z, this.j);
      }  
    if (this.g != 0) {
      stateListDrawable.addState(new int[] { 16842919 }, (Drawable)gradientDrawable4);
      stateListDrawable.addState(new int[] { 16842908 }, (Drawable)gradientDrawable4);
      stateListDrawable.addState(new int[] { -16842910 }, (Drawable)gradientDrawable3);
    } 
    stateListDrawable.addState(new int[0], (Drawable)gradientDrawable1);
    if (Build.VERSION.SDK_INT < 16) {
      setBackgroundDrawable((Drawable)stateListDrawable);
      return;
    } 
    setBackground((Drawable)stateListDrawable);
  }
  
  private void f() {
    if (this.t == 3 || this.t == 4) {
      setOrientation(1);
    } else {
      setOrientation(0);
    } 
    setGravity(17);
    setClickable(true);
    setFocusable(true);
    if (this.q == null && this.s == null && getPaddingLeft() == 0 && getPaddingRight() == 0 && getPaddingTop() == 0 && getPaddingBottom() == 0)
      setPadding(20, 20, 20, 20); 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.u = paramInt1;
    this.w = paramInt2;
    this.v = paramInt3;
    this.x = paramInt4;
    if (this.C != null)
      this.C.setPadding(this.u, this.w, this.v, this.x); 
    if (this.D != null)
      this.D.setPadding(this.u, this.w, this.v, this.x); 
  }
  
  public TextView getIconFontObject() {
    return this.D;
  }
  
  public ImageView getIconImageObject() {
    return this.C;
  }
  
  public CharSequence getText() {
    return (this.E != null) ? this.E.getText() : "";
  }
  
  public TextView getTextViewObject() {
    return this.E;
  }
  
  public void setBackgroundColor(int paramInt) {
    this.f = paramInt;
    if (this.C != null || this.D != null || this.E != null)
      e(); 
  }
  
  public void setBorderColor(int paramInt) {
    this.y = paramInt;
    if (this.C != null || this.D != null || this.E != null)
      e(); 
  }
  
  public void setBorderWidth(int paramInt) {
    this.z = paramInt;
    if (this.C != null || this.D != null || this.E != null)
      e(); 
  }
  
  public void setDisableBackgroundColor(int paramInt) {
    this.h = paramInt;
    if (this.C != null || this.D != null || this.E != null)
      e(); 
  }
  
  public void setDisableBorderColor(int paramInt) {
    this.j = paramInt;
    if (this.C != null || this.D != null || this.E != null)
      e(); 
  }
  
  public void setDisableTextColor(int paramInt) {
    this.i = paramInt;
    if (this.E == null) {
      a();
      return;
    } 
    if (!isEnabled())
      this.E.setTextColor(paramInt); 
  }
  
  public void setFocusBackgroundColor(int paramInt) {
    this.g = paramInt;
    if (this.C != null || this.D != null || this.E != null)
      e(); 
  }
  
  public void setFontIconSize(int paramInt) {
    this.r = b(getContext(), paramInt);
    if (this.D != null)
      this.D.setTextSize(paramInt); 
  }
  
  public void setGhost(boolean paramBoolean) {
    this.F = paramBoolean;
    if (this.C != null || this.D != null || this.E != null)
      e(); 
  }
  
  public void setIconColor(int paramInt) {
    if (this.D != null)
      this.D.setTextColor(paramInt); 
  }
  
  public void setIconPosition(int paramInt) {
    if (paramInt > 0 && paramInt < 5) {
      this.t = paramInt;
    } else {
      this.t = 1;
    } 
    a();
  }
  
  public void setIconResource(int paramInt) {
    this.q = this.e.getResources().getDrawable(paramInt);
    if (this.C == null || this.D != null) {
      this.D = null;
      a();
      return;
    } 
    this.C.setImageDrawable(this.q);
  }
  
  public void setIconResource(Drawable paramDrawable) {
    this.q = paramDrawable;
    if (this.C == null || this.D != null) {
      this.D = null;
      a();
      return;
    } 
    this.C.setImageDrawable(this.q);
  }
  
  public void setIconResource(String paramString) {
    this.s = paramString;
    if (this.D == null) {
      this.C = null;
      a();
      return;
    } 
    this.D.setText(paramString);
  }
  
  public void setRadius(int paramInt) {
    this.A = paramInt;
    if (this.C != null || this.D != null || this.E != null)
      e(); 
  }
  
  public void setText(CharSequence paramCharSequence) {
    this.p = paramCharSequence;
    if (this.E == null) {
      a();
      return;
    } 
    this.E.setText(paramCharSequence);
  }
  
  public void setText(String paramString) {
    String str = paramString;
    if (this.B)
      str = paramString.toUpperCase(); 
    this.p = str;
    if (this.E == null) {
      a();
      return;
    } 
    this.E.setText(str);
  }
  
  public void setTextAllCaps(boolean paramBoolean) {
    this.B = paramBoolean;
    setText(this.p);
  }
  
  public void setTextColor(int paramInt) {
    this.k = paramInt;
    if (this.E == null) {
      a();
      return;
    } 
    this.E.setTextColor(paramInt);
  }
  
  public void setTextGravity(int paramInt) {
    this.o = paramInt;
    if (this.E != null)
      this.E.setGravity(paramInt); 
  }
  
  public void setTextSize(int paramInt) {
    this.n = b(getContext(), paramInt);
    if (this.E != null)
      this.E.setTextSize(paramInt); 
  }
  
  public void setUsingSystemFont(boolean paramBoolean) {
    this.G = paramBoolean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\widget\FancyButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */