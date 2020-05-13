package com.zz.sdk.i;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class f {
  public static void a(Context paramContext, String paramString) {
    Intent intent = new Intent();
    intent.setAction("android.intent.action.CALL");
    intent.setData(Uri.parse("tel:" + paramString));
    paramContext.startActivity(intent);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */