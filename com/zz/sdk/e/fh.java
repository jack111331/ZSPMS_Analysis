package com.zz.sdk.e;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.u;
import com.zz.sdk.i.bp;
import java.util.ArrayList;

class fh extends AsyncTask {
  g a;
  
  Object b;
  
  static fh a(Context paramContext, g paramg, Object paramObject, String paramString, u paramu) {
    fh fh1 = new fh();
    fh1.execute(new Object[] { paramContext, paramg, paramObject, paramString, paramu });
    return fh1;
  }
  
  protected a a(Object... paramVarArgs) {
    Context context = (Context)paramVarArgs[0];
    g g1 = (g)paramVarArgs[1];
    Object object = paramVarArgs[2];
    String str = (String)paramVarArgs[3];
    u u = (u)paramVarArgs[4];
    bp.a("sms body length -> " + u.c.length());
    bp.a("sms body -> " + u.c);
    SmsManager smsManager = SmsManager.getDefault();
    Intent intent = new Intent();
    intent.setAction(str);
    Bundle bundle = new Bundle();
    bundle.putString("service_type", u.a);
    bundle.putString("price", "" + u.d);
    ArrayList arrayList1 = smsManager.divideMessage(u.c);
    bp.a("divide size -> " + arrayList1.size());
    intent.putExtras(bundle);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, intent, 134217728);
    ArrayList<PendingIntent> arrayList = new ArrayList();
    arrayList.add(pendingIntent);
    try {
      smsManager.sendMultipartTextMessage(u.b, null, arrayList1, arrayList, null);
      a a = new a();
      this();
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    if (!isCancelled()) {
      this.a = g1;
      this.b = object;
    } 
    return (a)exception;
  }
  
  protected void a(a parama) {
    if (this.a != null)
      this.a.a(this, this.b, parama); 
    this.a = null;
    this.b = null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */