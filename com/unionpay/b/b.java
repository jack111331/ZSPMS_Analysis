package com.unionpay.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.unionpay.UPQuerySEPayInfoCallback;
import com.unionpay.UPSEInfoResp;
import com.unionpay.sdk.UPAgent;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.h;
import java.util.Arrays;
import java.util.HashMap;

public final class b {
  private Context a;
  
  private UPQuerySEPayInfoCallback b;
  
  private UPTsmAddon c;
  
  private String d = "";
  
  private String e = "";
  
  private boolean f = false;
  
  private QueryVendorPayStatusRequestParams g;
  
  private final Handler.Callback h = new c(this);
  
  private final Handler i = new Handler(this.h);
  
  private final UPTsmAddon.UPTsmConnectionListener j = new d(this);
  
  public b(Context paramContext, UPQuerySEPayInfoCallback paramUPQuerySEPayInfoCallback, boolean paramBoolean) {
    this.a = paramContext;
    this.b = paramUPQuerySEPayInfoCallback;
    this.f = paramBoolean;
    if (this.f) {
      System.loadLibrary("entryexpro");
      String str2 = UPUtils.a(this.a, "mode");
      String str1 = str2;
      if (str2 == null)
        str1 = ""; 
      if (!com.unionpay.utils.b.e(str1))
        str1 = "02"; 
      UPAgent.init(this.a, UPUtils.getTalkingDataIdForAssist(Integer.decode(str1).intValue()), "SE_000001");
    } 
  }
  
  private static void a(Context paramContext, String paramString, String[] paramArrayOfString, Object[] paramArrayOfObject) {
    h.a("uppay-TD", "event:" + paramString + ", keys:" + Arrays.toString((Object[])paramArrayOfString) + ", values:" + Arrays.toString(paramArrayOfObject));
    if (paramArrayOfString != null && paramArrayOfObject != null) {
      if (paramArrayOfString.length != paramArrayOfObject.length || paramArrayOfString.length > 10)
        throw new IllegalArgumentException(); 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      for (byte b1 = 0; b1 < paramArrayOfString.length; b1++)
        hashMap.put(paramArrayOfString[b1], paramArrayOfObject[b1]); 
      UPAgent.onEvent(paramContext, paramString, paramString, hashMap);
      return;
    } 
    UPAgent.onEvent(paramContext, paramString);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    c();
    if (this.f)
      a(this.a, "get_venderpay_status", new String[] { "name", "seType", "errorCode", "errorDesp" }, (Object[])new String[] { paramString1, paramString2, paramString3, paramString4 }); 
    this.b.onError(paramString1, paramString2, paramString3, paramString4);
  }
  
  private boolean a(String paramString) {
    PackageManager.NameNotFoundException nameNotFoundException1;
    PackageManager.NameNotFoundException nameNotFoundException2 = null;
    boolean bool1 = false;
    try {
      PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(paramString, 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException null) {
      nameNotFoundException1 = nameNotFoundException2;
    } catch (Exception exception) {
      nameNotFoundException1 = nameNotFoundException2;
    } 
    boolean bool2 = bool1;
    if (nameNotFoundException1 != null) {
      h.a("tsm-client", "tsm version code=" + ((PackageInfo)nameNotFoundException1).versionCode);
      bool2 = bool1;
      if (((PackageInfo)nameNotFoundException1).versionCode >= 18)
        bool2 = true; 
    } 
    return bool2;
  }
  
  private void c() {
    if (this.c != null) {
      this.c.removeConnectionListener(this.j);
      this.c.unbind();
    } 
  }
  
  public final int a() {
    if (this.a == null || this.b == null)
      return UPSEInfoResp.PARAM_ERROR; 
    if (a("com.unionpay.tsmservice")) {
      this.c = UPTsmAddon.getInstance(this.a);
      this.c.addConnectionListener(this.j);
      h.b("uppay-spay", "type se  bind service");
      if (this.c != null && !this.c.isConnected()) {
        h.b("uppay", "bind service");
        if (!this.c.bind())
          a(this.d, this.e, UPSEInfoResp.ERROR_NONE, "Tsm service bind fail"); 
      } else if (this.c != null && this.c.isConnected()) {
        h.b("uppay", "tsm service already connected");
        b();
      } 
    } else {
      a(this.d, this.e, UPSEInfoResp.ERROR_NOT_SUPPORT, "Tsm service is not installed or version down");
    } 
    return UPSEInfoResp.SUCCESS;
  }
  
  public final boolean b() {
    null = false;
    try {
      h.b("uppay", "getVendorPayStatus()");
      if (this.g == null) {
        QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams1 = new QueryVendorPayStatusRequestParams();
        this();
        this.g = queryVendorPayStatusRequestParams1;
      } 
      UPTsmAddon uPTsmAddon = this.c;
      QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams = this.g;
      a a = new a();
      this(this.i);
      if (uPTsmAddon.queryVendorPayStatus(queryVendorPayStatusRequestParams, (ITsmCallback)a) != 0) {
        h.b("uppay", "ret != 0");
        a(this.d, this.e, UPSEInfoResp.ERROR_NOT_SUPPORT, "Tsm service is not installed or version down");
        return null;
      } 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      return null;
    } 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */