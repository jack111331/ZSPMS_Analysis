package com.unionpay.mobile.android.pboctransaction.sdapdu;

import android.content.Context;
import android.util.Log;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.c;
import com.unionpay.mobile.android.utils.k;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public final class a implements c {
  NativeSDWriter a = null;
  
  private Context b = null;
  
  private boolean c = false;
  
  private static ArrayList<c> b(d paramd) {
    if (paramd.a() == null) {
      Log.e("uppay", " select UPCard failed!!!!");
      return null;
    } 
    String str = paramd.c();
    if (str == null) {
      Log.e("uppay", " getBankCardFileEntry failed!!!!");
      return null;
    } 
    byte[] arrayOfByte = e.a(str);
    int i = (arrayOfByte[0] & 0xFF) << 24 | (arrayOfByte[1] & 0xFF) << 16;
    int j = Integer.MIN_VALUE;
    byte b1 = 0;
    byte b2;
    for (b2 = 0; b2 < 10; b2++) {
      if ((j & i) == 0)
        b1++; 
      j >>>= 1;
    } 
    if (b1 <= 0)
      return null; 
    ArrayList<com.unionpay.mobile.android.model.a> arrayList = new ArrayList(b1);
    j = Integer.MIN_VALUE;
    for (b2 = 1; b2 <= b1 && b2 < 11; b2++) {
      if ((i & j) == 0) {
        String str1 = paramd.a(b2, c.a());
        if (str1 != null && str1.length() > 0) {
          String str2 = e.d(str1.substring(0, 40));
          try {
            String str4 = new String();
            this(e.a(str2), "gbk");
            str2 = str4;
          } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
          } 
          String str3 = str1.substring(40, 60);
          arrayList.add(new com.unionpay.mobile.android.model.a(8, Integer.toString(b2), str2, e.c(str3), 2));
          k.c("uppay", b2 + "----" + str3);
        } 
      } 
      j >>>= 1;
    } 
    return (ArrayList)arrayList;
  }
  
  public final String a(String paramString) {
    return "";
  }
  
  public final ArrayList<c> a(d paramd) {
    ArrayList<com.unionpay.mobile.android.model.a> arrayList1;
    d d1 = null;
    d d2 = null;
    k.c("uppay", "SDEngine.readList() +++");
    if (!this.c)
      return (ArrayList<c>)d2; 
    ArrayList<com.unionpay.mobile.android.model.a> arrayList2 = new ArrayList();
    String str = paramd.a(new AppIdentification("A0000003330101", "1.0"));
    d2 = d1;
    if (str != null) {
      d2 = d1;
      if (str.length() > 0) {
        arrayList1 = new ArrayList(1);
        arrayList1.add(new com.unionpay.mobile.android.model.a(8, "A0000003330101", "", e.c(str), 1));
        k.c("uppay", "A0000003330101" + "----" + str);
      } 
    } 
    if (arrayList1 != null && arrayList1.size() > 0)
      arrayList2.addAll(arrayList1); 
    ArrayList<c> arrayList = b(paramd);
    if (arrayList != null && arrayList.size() > 0)
      arrayList2.addAll(arrayList); 
    k.c("uppay", "SDEngine.readList() ---");
    return (ArrayList)arrayList2;
  }
  
  public final void a() {}
  
  public final void a(b paramb, Context paramContext) {
    this.b = paramContext;
    if (paramb != null)
      paramb.a(); 
  }
  
  public final byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    String str = "";
    if (this.a != null)
      str = this.a.a(e.a(paramArrayOfbyte)); 
    return e.a(str);
  }
  
  public final void b() {
    Context context = this.b;
    this.a = new NativeSDWriter();
    context = this.b;
    b.a();
    ArrayList<String> arrayList = new ArrayList();
    String[] arrayOfString = b.a;
    int i = arrayOfString.length;
    for (byte b = 0; b < i; b++)
      arrayList.add(arrayOfString[b]); 
    this.c = this.a.a(arrayList);
  }
  
  public final void c() {
    if (this.a != null)
      this.a.a(); 
  }
  
  public final void d() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\sdapdu\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */