package com.herosdk.channel.hero;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.herosdk.HeroSdk;
import com.herosdk.base.IPayBase;
import com.herosdk.bean.OrderInfo;
import com.herosdk.bean.RoleInfo;
import com.herosdk.error.ErrorUtils;
import com.zz.sdk.SDKManager;

public class Pay implements IPayBase {
  public static String a = Sdk.c + "pay";
  
  private static volatile Pay b;
  
  private static String c;
  
  private static OrderInfo d;
  
  private void a(RoleInfo paramRoleInfo) {
    try {
      RoleInfo roleInfo = RoleInfoUtil.getRoleInfo();
      if (roleInfo != null) {
        roleInfo.setServerId(paramRoleInfo.getServerId());
        roleInfo.setServerName(paramRoleInfo.getServerName());
        roleInfo.setRoleId(paramRoleInfo.getRoleId());
        roleInfo.setRoleName(paramRoleInfo.getRoleName());
        roleInfo.setRoleLevel(paramRoleInfo.getRoleLevel());
        roleInfo.setVipLevel(paramRoleInfo.getVipLevel());
        RoleInfoUtil.setRoleInfo(roleInfo);
      } 
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static Pay getInstance() {
    // Byte code:
    //   0: getstatic com/herosdk/channel/hero/Pay.b : Lcom/herosdk/channel/hero/Pay;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/channel/hero/Pay
    //   8: monitorenter
    //   9: getstatic com/herosdk/channel/hero/Pay.b : Lcom/herosdk/channel/hero/Pay;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/channel/hero/Pay
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/channel/hero/Pay.b : Lcom/herosdk/channel/hero/Pay;
    //   27: ldc com/herosdk/channel/hero/Pay
    //   29: monitorexit
    //   30: getstatic com/herosdk/channel/hero/Pay.b : Lcom/herosdk/channel/hero/Pay;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/channel/hero/Pay
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public String getChannelPayParams() {
    return null;
  }
  
  public String getOrderId() {
    return TextUtils.isEmpty(c) ? d.getCpOrderId() : c;
  }
  
  public void pay(Activity paramActivity, OrderInfo paramOrderInfo, RoleInfo paramRoleInfo) {
    Log.d(a, "pay");
    if (paramOrderInfo == null) {
      payFailed("没有订单信息");
      return;
    } 
    c = paramOrderInfo.getSdkOrderId();
    d = paramOrderInfo;
    a(paramRoleInfo);
    try {
      SDKManager.getInstance((Context)paramActivity).showPaymentView(Sdk.getInstance().getHandler(), 2015, getOrderId(), (int)paramOrderInfo.getAmount(), paramOrderInfo.getGoodsName(), getOrderId());
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public void payCancel() {
    Log.d(a, "payCancel");
    if (HeroSdk.getInstance().getPayListener() != null)
      HeroSdk.getInstance().getPayListener().onCancel(d.getCpOrderId()); 
  }
  
  public void payFailed(String paramString) {
    Log.e(a, "payFailed msg:" + paramString);
    if (HeroSdk.getInstance().getPayListener() != null)
      HeroSdk.getInstance().getPayListener().onFailed(d.getCpOrderId(), paramString); 
  }
  
  public void paySuccess() {
    Log.d(a, "paySuccess");
    if (HeroSdk.getInstance().getPayListener() != null)
      HeroSdk.getInstance().getPayListener().onSuccess(c, d.getCpOrderId(), d.getExtraParams()); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\channel\hero\Pay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */