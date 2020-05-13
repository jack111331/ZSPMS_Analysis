package com.alipay.sdk.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;

public final class d {
  private static boolean a;
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
  
  private static AlertDialog.Builder a(Context paramContext, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, String paramString2, DialogInterface.OnClickListener paramOnClickListener2) {
    AlertDialog.Builder builder = new AlertDialog.Builder(paramContext);
    if (a) {
      if (!TextUtils.isEmpty(paramString2) && paramOnClickListener2 != null)
        builder.setPositiveButton(paramString2, paramOnClickListener2); 
      if (!TextUtils.isEmpty(paramString1) && paramOnClickListener1 != null)
        builder.setNegativeButton(paramString1, paramOnClickListener1); 
      return builder;
    } 
    if (!TextUtils.isEmpty(paramString1) && paramOnClickListener1 != null)
      builder.setPositiveButton(paramString1, paramOnClickListener1); 
    if (!TextUtils.isEmpty(paramString2) && paramOnClickListener2 != null)
      builder.setNegativeButton(paramString2, paramOnClickListener2); 
    return builder;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2) {
    AlertDialog.Builder builder = new AlertDialog.Builder(paramContext);
    if (a) {
      if (!TextUtils.isEmpty(paramString4))
        builder.setPositiveButton(paramString4, paramOnClickListener2); 
      if (!TextUtils.isEmpty(paramString3))
        builder.setNegativeButton(paramString3, paramOnClickListener1); 
    } else {
      if (!TextUtils.isEmpty(paramString3))
        builder.setPositiveButton(paramString3, paramOnClickListener1); 
      if (!TextUtils.isEmpty(paramString4))
        builder.setNegativeButton(paramString4, paramOnClickListener2); 
    } 
    builder.setTitle(paramString1);
    builder.setMessage(paramString2);
    AlertDialog alertDialog = builder.create();
    alertDialog.setCanceledOnTouchOutside(false);
    alertDialog.setOnKeyListener(new e());
    try {
      alertDialog.show();
    } catch (Throwable throwable) {}
    return (Dialog)alertDialog;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\widget\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */