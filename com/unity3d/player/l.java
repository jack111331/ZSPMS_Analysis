package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

public final class l extends View {
  final int a;
  
  final int b;
  
  Bitmap c;
  
  Bitmap d;
  
  public l(Context paramContext, int paramInt) {
    super(paramContext);
    this.a = paramInt;
    this.b = getResources().getIdentifier("unity_static_splash", "drawable", getContext().getPackageName());
    if (this.b != 0)
      forceLayout(); 
  }
  
  public final void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.c != null) {
      this.c.recycle();
      this.c = null;
    } 
    if (this.d != null) {
      this.d.recycle();
      this.d = null;
    } 
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : I
    //   4: ifne -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield c : Landroid/graphics/Bitmap;
    //   12: ifnonnull -> 47
    //   15: new android/graphics/BitmapFactory$Options
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: astore #6
    //   24: aload #6
    //   26: iconst_0
    //   27: putfield inScaled : Z
    //   30: aload_0
    //   31: aload_0
    //   32: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   35: aload_0
    //   36: getfield b : I
    //   39: aload #6
    //   41: invokestatic decodeResource : (Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   44: putfield c : Landroid/graphics/Bitmap;
    //   47: aload_0
    //   48: getfield c : Landroid/graphics/Bitmap;
    //   51: invokevirtual getWidth : ()I
    //   54: istore #5
    //   56: aload_0
    //   57: getfield c : Landroid/graphics/Bitmap;
    //   60: invokevirtual getHeight : ()I
    //   63: istore #4
    //   65: aload_0
    //   66: invokevirtual getWidth : ()I
    //   69: istore_3
    //   70: aload_0
    //   71: invokevirtual getHeight : ()I
    //   74: istore #7
    //   76: iload_3
    //   77: ifeq -> 394
    //   80: iload #7
    //   82: ifne -> 88
    //   85: goto -> 394
    //   88: iload #5
    //   90: i2f
    //   91: iload #4
    //   93: i2f
    //   94: fdiv
    //   95: fstore #8
    //   97: iload_3
    //   98: i2f
    //   99: fstore #9
    //   101: iload #7
    //   103: i2f
    //   104: fstore #10
    //   106: fload #9
    //   108: fload #10
    //   110: fdiv
    //   111: fload #8
    //   113: fcmpg
    //   114: ifgt -> 122
    //   117: iconst_1
    //   118: istore_2
    //   119: goto -> 124
    //   122: iconst_0
    //   123: istore_2
    //   124: getstatic com/unity3d/player/l$1.a : [I
    //   127: aload_0
    //   128: getfield a : I
    //   131: iconst_1
    //   132: isub
    //   133: iaload
    //   134: tableswitch default -> 160, 1 -> 211, 2 -> 169, 3 -> 169
    //   160: iload #5
    //   162: istore_2
    //   163: iload #4
    //   165: istore_3
    //   166: goto -> 250
    //   169: aload_0
    //   170: getfield a : I
    //   173: getstatic com/unity3d/player/l$a.c : I
    //   176: if_icmpne -> 185
    //   179: iconst_1
    //   180: istore #4
    //   182: goto -> 188
    //   185: iconst_0
    //   186: istore #4
    //   188: iload #4
    //   190: iload_2
    //   191: ixor
    //   192: ifeq -> 240
    //   195: fload #9
    //   197: fload #8
    //   199: fdiv
    //   200: f2i
    //   201: istore #4
    //   203: iload_3
    //   204: istore_2
    //   205: iload #4
    //   207: istore_3
    //   208: goto -> 250
    //   211: iload #5
    //   213: istore_2
    //   214: iload_3
    //   215: iload #5
    //   217: if_icmpge -> 230
    //   220: fload #9
    //   222: fload #8
    //   224: fdiv
    //   225: f2i
    //   226: istore #4
    //   228: iload_3
    //   229: istore_2
    //   230: iload #4
    //   232: istore_3
    //   233: iload #7
    //   235: iload #4
    //   237: if_icmpge -> 250
    //   240: fload #10
    //   242: fload #8
    //   244: fmul
    //   245: f2i
    //   246: istore_2
    //   247: iload #7
    //   249: istore_3
    //   250: aload_0
    //   251: getfield d : Landroid/graphics/Bitmap;
    //   254: ifnull -> 303
    //   257: aload_0
    //   258: getfield d : Landroid/graphics/Bitmap;
    //   261: invokevirtual getWidth : ()I
    //   264: iload_2
    //   265: if_icmpne -> 280
    //   268: aload_0
    //   269: getfield d : Landroid/graphics/Bitmap;
    //   272: invokevirtual getHeight : ()I
    //   275: iload_3
    //   276: if_icmpne -> 280
    //   279: return
    //   280: aload_0
    //   281: getfield d : Landroid/graphics/Bitmap;
    //   284: aload_0
    //   285: getfield c : Landroid/graphics/Bitmap;
    //   288: if_acmpeq -> 303
    //   291: aload_0
    //   292: getfield d : Landroid/graphics/Bitmap;
    //   295: invokevirtual recycle : ()V
    //   298: aload_0
    //   299: aconst_null
    //   300: putfield d : Landroid/graphics/Bitmap;
    //   303: aload_0
    //   304: aload_0
    //   305: getfield c : Landroid/graphics/Bitmap;
    //   308: iload_2
    //   309: iload_3
    //   310: iconst_1
    //   311: invokestatic createScaledBitmap : (Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   314: putfield d : Landroid/graphics/Bitmap;
    //   317: aload_0
    //   318: getfield d : Landroid/graphics/Bitmap;
    //   321: aload_0
    //   322: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   325: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   328: getfield densityDpi : I
    //   331: invokevirtual setDensity : (I)V
    //   334: new android/graphics/drawable/ColorDrawable
    //   337: dup
    //   338: ldc -16777216
    //   340: invokespecial <init> : (I)V
    //   343: astore #6
    //   345: new android/graphics/drawable/BitmapDrawable
    //   348: dup
    //   349: aload_0
    //   350: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   353: aload_0
    //   354: getfield d : Landroid/graphics/Bitmap;
    //   357: invokespecial <init> : (Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   360: astore #11
    //   362: aload #11
    //   364: bipush #17
    //   366: invokevirtual setGravity : (I)V
    //   369: aload_0
    //   370: new android/graphics/drawable/LayerDrawable
    //   373: dup
    //   374: iconst_2
    //   375: anewarray android/graphics/drawable/Drawable
    //   378: dup
    //   379: iconst_0
    //   380: aload #6
    //   382: aastore
    //   383: dup
    //   384: iconst_1
    //   385: aload #11
    //   387: aastore
    //   388: invokespecial <init> : ([Landroid/graphics/drawable/Drawable;)V
    //   391: invokevirtual setBackground : (Landroid/graphics/drawable/Drawable;)V
    //   394: return
  }
  
  enum a {
    a, b, c;
    
    public static int[] a() {
      return (int[])d.clone();
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unity3d\player\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */