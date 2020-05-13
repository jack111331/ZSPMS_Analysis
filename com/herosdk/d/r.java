package com.herosdk.d;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class r {
  private static volatile r a;
  
  private static Context b = null;
  
  private ImageView c = null;
  
  private Animation d = null;
  
  private Dialog e = null;
  
  private Boolean f = Boolean.valueOf(true);
  
  public static r a() {
    // Byte code:
    //   0: getstatic com/herosdk/d/r.a : Lcom/herosdk/d/r;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/d/r
    //   8: monitorenter
    //   9: getstatic com/herosdk/d/r.a : Lcom/herosdk/d/r;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/d/r
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/d/r.a : Lcom/herosdk/d/r;
    //   27: ldc com/herosdk/d/r
    //   29: monitorexit
    //   30: getstatic com/herosdk/d/r.a : Lcom/herosdk/d/r;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/d/r
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  private void c(Context paramContext) {
    try {
      b = paramContext;
      LayoutInflater layoutInflater = LayoutInflater.from(b);
      int i = au.h(b, "hu_rotate_dialog");
      if (i == 0) {
        this.f = Boolean.valueOf(false);
        return;
      } 
      this.f = Boolean.valueOf(true);
      View view = layoutInflater.inflate(i, null);
      LinearLayout linearLayout = (LinearLayout)view.findViewById(au.g(b, "view_dialog_hu"));
      this.c = (ImageView)view.findViewById(au.g(b, "iv_loading_hu"));
      this.d = AnimationUtils.loadAnimation(b, au.a(b, "hu_rotate_anim"));
      Dialog dialog1 = new Dialog();
      this(b, au.j(b, "loading_dialog_hu"));
      this.e = dialog1;
      this.e.setCancelable(true);
      Dialog dialog2 = this.e;
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams();
      this(-1, -1);
      dialog2.setContentView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    } catch (android.content.res.Resources.NotFoundException notFoundException) {}
  }
  
  public void a(Context paramContext) {
    if (this.f.booleanValue())
      bb.a(new s(this, paramContext)); 
  }
  
  public void b() {
    if (this.f.booleanValue())
      bb.a(new t(this)); 
  }
  
  public void c() {
    bb.a(new u(this));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */