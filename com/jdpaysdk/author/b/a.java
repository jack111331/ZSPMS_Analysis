package com.jdpaysdk.author.b;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.jdpaysdk.author.d;

public class a extends Activity {
  private void a() {
    if (d.c == 0 || d.d == 0 || d.e == 0) {
      DisplayMetrics displayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
      int i = displayMetrics.widthPixels;
      int j = displayMetrics.heightPixels;
      int k = displayMetrics.densityDpi;
      d.c = j;
      d.d = i;
      d.e = k;
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */