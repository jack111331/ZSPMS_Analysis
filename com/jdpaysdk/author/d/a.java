package com.jdpaysdk.author.d;

import android.app.Dialog;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.jdpaysdk.author.c.f;

public class a extends Dialog {
  private static Animation a;
  
  private static ImageView b = null;
  
  private static a d;
  
  private TextView c = null;
  
  private a(Context paramContext) {
    super(paramContext, f.d("CustomProgressDialog"));
    b(paramContext);
  }
  
  public static void a() {
    // Byte code:
    //   0: ldc com/jdpaysdk/author/d/a
    //   2: monitorenter
    //   3: getstatic com/jdpaysdk/author/d/a.d : Lcom/jdpaysdk/author/d/a;
    //   6: ifnull -> 24
    //   9: getstatic com/jdpaysdk/author/d/a.d : Lcom/jdpaysdk/author/d/a;
    //   12: invokevirtual isShowing : ()Z
    //   15: ifeq -> 24
    //   18: getstatic com/jdpaysdk/author/d/a.d : Lcom/jdpaysdk/author/d/a;
    //   21: invokevirtual dismiss : ()V
    //   24: getstatic com/jdpaysdk/author/d/a.b : Landroid/widget/ImageView;
    //   27: ifnull -> 36
    //   30: getstatic com/jdpaysdk/author/d/a.b : Landroid/widget/ImageView;
    //   33: invokevirtual clearAnimation : ()V
    //   36: aconst_null
    //   37: putstatic com/jdpaysdk/author/d/a.d : Lcom/jdpaysdk/author/d/a;
    //   40: ldc com/jdpaysdk/author/d/a
    //   42: monitorexit
    //   43: return
    //   44: astore_0
    //   45: aconst_null
    //   46: putstatic com/jdpaysdk/author/d/a.d : Lcom/jdpaysdk/author/d/a;
    //   49: goto -> 40
    //   52: astore_0
    //   53: ldc com/jdpaysdk/author/d/a
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: aconst_null
    //   60: putstatic com/jdpaysdk/author/d/a.d : Lcom/jdpaysdk/author/d/a;
    //   63: aload_0
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	44	java/lang/Exception
    //   3	24	58	finally
    //   24	36	44	java/lang/Exception
    //   24	36	58	finally
    //   36	40	52	finally
    //   45	49	52	finally
    //   59	65	52	finally
  }
  
  public static void a(Context paramContext) {
    // Byte code:
    //   0: ldc com/jdpaysdk/author/d/a
    //   2: monitorenter
    //   3: getstatic com/jdpaysdk/author/d/a.d : Lcom/jdpaysdk/author/d/a;
    //   6: ifnonnull -> 22
    //   9: new com/jdpaysdk/author/d/a
    //   12: astore_1
    //   13: aload_1
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/content/Context;)V
    //   18: aload_1
    //   19: putstatic com/jdpaysdk/author/d/a.d : Lcom/jdpaysdk/author/d/a;
    //   22: getstatic com/jdpaysdk/author/d/a.d : Lcom/jdpaysdk/author/d/a;
    //   25: invokevirtual show : ()V
    //   28: getstatic com/jdpaysdk/author/d/a.b : Landroid/widget/ImageView;
    //   31: invokevirtual clearAnimation : ()V
    //   34: getstatic com/jdpaysdk/author/d/a.b : Landroid/widget/ImageView;
    //   37: getstatic com/jdpaysdk/author/d/a.a : Landroid/view/animation/Animation;
    //   40: invokevirtual startAnimation : (Landroid/view/animation/Animation;)V
    //   43: ldc com/jdpaysdk/author/d/a
    //   45: monitorexit
    //   46: return
    //   47: astore_0
    //   48: ldc com/jdpaysdk/author/d/a
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	47	finally
    //   22	43	47	finally
  }
  
  private void b(Context paramContext) {
    setContentView(f.a("author_progressdialog"));
    (getWindow().getAttributes()).gravity = 17;
    b = (ImageView)findViewById(f.e("loadingImageView"));
    this.c = (TextView)findViewById(f.e("id_tv_loadingmsg"));
    b.setImageResource(f.c("author_loading"));
    a = AnimationUtils.loadAnimation(paramContext, f.f("jdpay_author_rotate"));
    LinearInterpolator linearInterpolator = new LinearInterpolator();
    a.setInterpolator((Interpolator)linearInterpolator);
    setCancelable(false);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */