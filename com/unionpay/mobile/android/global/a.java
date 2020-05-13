package com.unionpay.mobile.android.global;

import android.content.Context;
import com.unionpay.mobile.android.utils.g;

public final class a {
  public static int A;
  
  public static int B;
  
  public static int C;
  
  public static int D;
  
  public static int E;
  
  public static int F;
  
  public static int G;
  
  public static int H;
  
  public static int I;
  
  public static int J;
  
  public static int K;
  
  public static boolean L;
  
  public static int M;
  
  public static int N;
  
  private static boolean O;
  
  public static int a = 48;
  
  public static int b = 8;
  
  public static int c = 4;
  
  public static int d = 12;
  
  public static int e = 8;
  
  public static int f = 8;
  
  public static int g = 4;
  
  public static int h = 8;
  
  public static int i = 2;
  
  public static int j = 16;
  
  public static int k = 52;
  
  public static int l = 320;
  
  public static int m = 32;
  
  public static int n = 54;
  
  public static int o = 45;
  
  public static int p = 35;
  
  public static int q = 40;
  
  public static int r = 54;
  
  public static int s = 10;
  
  public static int t = 0;
  
  public static int u = 28;
  
  public static int v = 30;
  
  public static int w = 22;
  
  public static int x = 40;
  
  public static int y = n;
  
  public static int z = 46;
  
  static {
    A = 45;
    B = 32;
    C = 6;
    D = 25;
    E = 95;
    F = 25;
    G = 25;
    H = 1;
    I = 0;
    J = 5;
    K = 1;
    O = false;
    L = true;
    M = 0;
    N = 0;
  }
  
  public static void a(Context paramContext) {
    b.a(paramContext);
    if (!O) {
      a = g.a(paramContext, a);
      b = g.a(paramContext, b);
      c = g.a(paramContext, c);
      d = g.a(paramContext, d);
      e = g.a(paramContext, e);
      f = g.a(paramContext, f);
      g = g.a(paramContext, g);
      h = g.a(paramContext, h);
      i = g.a(paramContext, i);
      j = g.a(paramContext, j);
      k = g.a(paramContext, k);
      m = g.a(paramContext, m);
      n = g.a(paramContext, n);
      o = g.a(paramContext, o);
      p = g.a(paramContext, p);
      q = g.a(paramContext, q);
      r = g.a(paramContext, r);
      s = g.a(paramContext, s);
      u = g.a(paramContext, u);
      v = g.a(paramContext, v);
      w = g.a(paramContext, w);
      z = g.a(paramContext, z);
      x = g.a(paramContext, x);
      A = g.a(paramContext, A);
      B = g.a(paramContext, B);
      C = g.a(paramContext, C);
      y = g.a(paramContext, y);
      D = g.a(paramContext, D);
      E = g.a(paramContext, E);
      F = g.a(paramContext, F);
      G = g.a(paramContext, G);
      H = g.a(paramContext, H);
      K = (int)((paramContext.getResources().getDisplayMetrics()).density + 0.5D);
      I = (paramContext.getResources().getDisplayMetrics()).widthPixels;
      t = (paramContext.getResources().getDisplayMetrics()).heightPixels;
      if (I > t) {
        int i = I + t;
        I = i;
        t = i - t;
        I -= t;
      } 
      J = g.a(paramContext, J);
      O = true;
    } 
  }
  
  public static int b(Context paramContext) {
    boolean bool;
    try {
      Class<?> clazz = Class.forName("com.android.internal.R$dimen");
      Object object = clazz.newInstance();
      bool = Integer.parseInt(clazz.getField("mz_action_button_min_height").get(object).toString());
      bool = paramContext.getResources().getDimensionPixelSize(bool);
    } catch (Exception exception) {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\global\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */