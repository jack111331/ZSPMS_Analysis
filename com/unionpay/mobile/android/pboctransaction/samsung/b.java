package com.unionpay.mobile.android.pboctransaction.samsung;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.unionpay.client3.tsm.ITsmConnection;
import com.unionpay.client3.tsm.SeAppInfo;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;

public final class b implements c {
  private Context a;
  
  private com.unionpay.mobile.android.pboctransaction.b b;
  
  private ITsmConnection c;
  
  private int d = 0;
  
  private Handler.Callback e = new c(this);
  
  private Handler f = new Handler(this.e);
  
  private void a(boolean paramBoolean) {
    if (this.b != null) {
      if (paramBoolean) {
        this.b.a();
        return;
      } 
    } else {
      return;
    } 
    this.b.b();
  }
  
  public final String a(String paramString) {
    return "";
  }
  
  public final ArrayList<c> a(d paramd) {
    d d1 = null;
    d d2 = null;
    d d3 = null;
    paramd = d1;
    if (this.c != null) {
      try {
        ArrayList<a> arrayList;
        SeAppInfo[] arrayOfSeAppInfo = this.c.getSeApps(this.d);
        paramd = d1;
        if (arrayOfSeAppInfo != null) {
          paramd = d1;
          if (arrayOfSeAppInfo.length > 0) {
            arrayList = new ArrayList();
            this();
            byte b1 = 0;
            while (true) {
              try {
                if (b1 < arrayOfSeAppInfo.length) {
                  String str = arrayOfSeAppInfo[b1].getAppAid();
                  if (str != null && str.startsWith("A000000333")) {
                    boolean bool;
                    str = arrayOfSeAppInfo[b1].getAppAid();
                    if (str != null && str.length() > 16 && !"06".equalsIgnoreCase(str.substring(14, 16))) {
                      bool = false;
                    } else {
                      bool = true;
                    } 
                    if (!bool) {
                      a a = new a();
                      this(1, arrayOfSeAppInfo[b1].getAppAid(), "", arrayOfSeAppInfo[b1].getPan(), 1);
                      arrayList.add(a);
                    } 
                  } 
                  b1++;
                  continue;
                } 
                return (ArrayList)arrayList;
              } catch (RemoteException remoteException) {
              
              } catch (Exception null) {
                exception.printStackTrace();
                return (ArrayList)arrayList;
              } 
              exception.printStackTrace();
              return (ArrayList)arrayList;
            } 
          } 
        } 
        return (ArrayList)arrayList;
      } catch (RemoteException remoteException) {
        paramd = d3;
        remoteException.printStackTrace();
        return (ArrayList<c>)paramd;
      } catch (Exception exception) {
        paramd = d2;
      } 
    } else {
      return (ArrayList<c>)paramd;
    } 
    exception.printStackTrace();
    return (ArrayList<c>)paramd;
  }
  
  public final void a() {}
  
  public final void a(com.unionpay.mobile.android.pboctransaction.b paramb, Context paramContext) {
    this.b = paramb;
    this.a = paramContext;
    try {
      Intent intent = new Intent();
      this();
      intent.setAction("com.unionpay.client3.action.TSM_MODEL");
      intent.setPackage("com.unionpay");
      paramContext.startService(intent);
      d d = new d();
      this(this);
      if (!paramContext.bindService(intent, d, 1)) {
        k.a("plugin-clientV3", "startSamsungService() failed!!!");
        a(false);
        return;
      } 
      Message message = this.f.obtainMessage(1);
      this.f.sendMessageDelayed(message, 3000L);
    } catch (Exception exception) {
      a(false);
    } 
  }
  
  public final byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    StringBuilder stringBuilder1 = null;
    StringBuilder stringBuilder2 = stringBuilder1;
    if (this.c != null)
      try {
        stringBuilder2 = new StringBuilder();
        this("--->");
        k.a("plugin-clientV3", stringBuilder2.append(e.a(paramArrayOfbyte)).toString());
        String str = this.c.sendApdu(this.d, e.a(paramArrayOfbyte), paramInt);
        stringBuilder2 = new StringBuilder();
        this("<---");
        k.a("plugin-clientV3", stringBuilder2.append(str).toString());
        byte[] arrayOfByte = e.a(str);
      } catch (Exception exception) {
        exception.printStackTrace();
        stringBuilder2 = stringBuilder1;
      }  
    return (byte[])stringBuilder2;
  }
  
  public final void b() {}
  
  public final void c() {}
  
  public final void d() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\samsung\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */