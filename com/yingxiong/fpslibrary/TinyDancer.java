package com.yingxiong.fpslibrary;

import android.content.Context;

public class TinyDancer {
  public static TinyDancerBuilder create() {
    return new TinyDancerBuilder();
  }
  
  public static void hide(Context paramContext) {
    TinyDancerBuilder.hide(paramContext.getApplicationContext());
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\fpslibrary\TinyDancer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */