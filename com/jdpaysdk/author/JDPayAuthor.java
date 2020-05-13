package com.jdpaysdk.author;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class JDPayAuthor {
  public static final String JDPAY_RESULT = "jdpay_Result";
  
  public static String PACKAGE_NAME;
  
  public void author(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4) {
    PACKAGE_NAME = paramActivity.getPackageName();
    d.a(paramActivity.getApplication());
    Intent intent = new Intent();
    intent.putExtra("orderId", paramString1);
    intent.putExtra("merchant", paramString2);
    intent.putExtra("appkey", paramString3);
    intent.putExtra("signData", paramString4);
    intent.setClass((Context)paramActivity, AuthorActivity.class);
    paramActivity.startActivityForResult(intent, 100);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\jdpaysdk\author\JDPayAuthor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */