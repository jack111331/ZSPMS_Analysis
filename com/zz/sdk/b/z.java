package com.zz.sdk.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import com.unionpay.UPPayAssistEx;

public class z {
  static final String a = "00";
  
  private Activity b;
  
  private String c;
  
  public z(Activity paramActivity, s params) {
    this.b = paramActivity;
    this.c = params.i;
  }
  
  private boolean b() {
    return !(this.c == null);
  }
  
  public void a() {
    if (b() && UPPayAssistEx.startPay((Context)this.b, null, null, this.c, "00") == -1) {
      AlertDialog.Builder builder = new AlertDialog.Builder((Context)this.b);
      builder.setTitle("提示");
      builder.setMessage("完成购买需要安装银联支付控件，是否安装？");
      builder.setNegativeButton("确定", new aa(this));
      builder.setPositiveButton("取消", new ab(this));
      builder.create().show();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\b\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */