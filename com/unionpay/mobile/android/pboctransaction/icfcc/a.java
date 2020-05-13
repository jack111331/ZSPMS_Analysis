package com.unionpay.mobile.android.pboctransaction.icfcc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;

public final class a implements c {
  private String a = null;
  
  private String b = "A0000003334355502D4D4F42494C45";
  
  private cn.gov.pbc.tsm.client.mobile.android.bank.service.a c;
  
  private b d;
  
  private Context e;
  
  private ServiceConnection f = new b(this);
  
  private byte[] a(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte1;
    byte[] arrayOfByte2 = null;
    try {
      String str = e.a(paramArrayOfbyte);
      paramArrayOfbyte = arrayOfByte2;
      if (b(str)) {
        if (str.contains(this.a)) {
          StringBuilder stringBuilder = new StringBuilder();
          this("pbocAID = ");
          k.c("icfcc", stringBuilder.append(this.a).toString());
          arrayOfByte1 = this.c.a(e.a(this.a), "00");
          k.c("icfcc", " openSEChannel result=" + e.a(arrayOfByte1));
          return arrayOfByte1;
        } 
      } else {
        k.c("icfcc", " openSEChannel result=" + e.a(arrayOfByte1));
        return arrayOfByte1;
      } 
      arrayOfByte1 = arrayOfByte2;
      if (str.contains(this.b)) {
        StringBuilder stringBuilder = new StringBuilder();
        this("upcardAID = ");
        k.c("icfcc", stringBuilder.append(this.b).toString());
        byte[] arrayOfByte = this.c.a(e.a(this.b), "01");
      } 
    } catch (Exception exception) {
      arrayOfByte1 = arrayOfByte2;
    } 
    k.c("icfcc", " openSEChannel result=" + e.a(arrayOfByte1));
    return arrayOfByte1;
  }
  
  private static boolean b(String paramString) {
    return (paramString.startsWith("00A40400") || paramString.startsWith("01A40400") || paramString.startsWith("02A40400"));
  }
  
  public final String a(String paramString) {
    return "";
  }
  
  public final ArrayList<c> a(d paramd) {
    if (this.c == null)
      return null; 
    ArrayList<com.unionpay.mobile.android.model.a> arrayList = new ArrayList();
    try {
      String str = c.a(e.a(this.c.a(e.a("325041592e5359532e4444463031"), "00")), "4F");
      StringBuilder stringBuilder = new StringBuilder();
      this("aid =");
      k.c("icfcc", stringBuilder.append(str).toString());
      if (str != null) {
        this.a = str;
        AppIdentification appIdentification = new AppIdentification();
        this(str, "");
        String str1 = e.c(paramd.a(appIdentification));
        if (str1 != null && str1.length() > 0) {
          StringBuilder stringBuilder1 = new StringBuilder();
          this("  ");
          k.c("icfcc", stringBuilder1.append(str1).toString());
          com.unionpay.mobile.android.model.a a1 = new com.unionpay.mobile.android.model.a();
          this(8, appIdentification.a(), "", str1, 1);
          arrayList.add(a1);
        } 
      } 
      try {
        this.c.b("00");
        ArrayList<com.unionpay.mobile.android.model.a> arrayList1 = arrayList;
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      } 
    } catch (Exception exception) {
      try {
        this.c.b("00");
        exception = null;
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      } 
    } finally {}
    return (ArrayList<c>)paramd;
  }
  
  public final void a() {
    d();
    if (this.c != null)
      try {
        this.c.a();
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      } catch (Exception exception) {} 
    if (this.e != null) {
      new Intent("com.unionpay.mobile.tsm.PBOCService");
      this.e.unbindService(this.f);
    } 
  }
  
  public final void a(b paramb, Context paramContext) {
    this.d = paramb;
    this.e = paramContext;
    try {
      Intent intent = new Intent();
      this("cn.gov.pbc.tsm.client.mobile.android.bank.service");
      intent.setPackage("cn.gov.pbc.tsm.client.mobile.andorid");
      paramContext.startService(intent);
      if (!paramContext.bindService(intent, this.f, 1) && paramb != null) {
        k.a("icfcc", "startTSMService.initFailed()");
        paramb.b();
      } 
    } catch (Exception exception) {}
  }
  
  public final byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    RemoteException remoteException1;
    RemoteException remoteException2 = null;
    byte[] arrayOfByte = null;
    String str = e.a(paramArrayOfbyte);
    k.c("icfcc", "====>" + str);
    if (this.c == null)
      return arrayOfByte; 
    if (b(str))
      return a(paramArrayOfbyte); 
    try {
      paramArrayOfbyte = this.c.b(paramArrayOfbyte);
      k.c("icfcc", "<====" + e.a(paramArrayOfbyte));
    } catch (RemoteException null) {
      remoteException1 = remoteException2;
    } catch (Exception exception) {
      remoteException1 = remoteException2;
      k.c("icfcc", "<====" + e.a((byte[])remoteException1));
    } 
    return (byte[])remoteException1;
  }
  
  public final void b() {}
  
  public final void c() {}
  
  public final void d() {
    if (this.c != null)
      try {
        this.c.b("00");
        this.c.b("01");
      } catch (RemoteException remoteException) {
        remoteException.printStackTrace();
      } catch (Exception exception) {} 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\icfcc\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */