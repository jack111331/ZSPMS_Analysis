package com.alipay.sdk.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.cons.a;

public final class k {
  private static final String a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";
  
  public static String a(Context paramContext) {
    if (EnvUtils.isSandBox())
      return "https://mobilegw.alipaydev.com/mgw.htm"; 
    if (paramContext == null)
      return a.a; 
    String str2 = a.a;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = a.a; 
    return str1;
  }
  
  private static String b(Context paramContext) {
    String str;
    Context context1 = null;
    Context context2 = null;
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.alipay.android.app.settings.data.ServerProvider/current_server"), null, null, null, null);
    paramContext = context1;
    if (cursor != null) {
      paramContext = context1;
      if (cursor.getCount() > 0) {
        paramContext = context2;
        if (cursor.moveToFirst())
          str = cursor.getString(cursor.getColumnIndex("url")); 
        cursor.close();
      } 
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sd\\util\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */