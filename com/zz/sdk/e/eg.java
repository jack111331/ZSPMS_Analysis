package com.zz.sdk.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

class eg extends BroadcastReceiver {
  static final String a = "android.provider.Telephony.SMS_RECEIVED";
  
  HashMap b = new HashMap<Object, Object>();
  
  private eg() {}
  
  static StringBuilder a(StringBuilder paramStringBuilder, Intent paramIntent) {
    ei[] arrayOfEi = a(paramIntent);
    StringBuilder stringBuilder = paramStringBuilder;
    if (arrayOfEi != null) {
      int i = arrayOfEi.length;
      byte b = 0;
      while (true) {
        stringBuilder = paramStringBuilder;
        if (b < i) {
          paramStringBuilder = arrayOfEi[b].a(paramStringBuilder);
          b++;
          continue;
        } 
        break;
      } 
    } 
    return stringBuilder;
  }
  
  private void a(Context paramContext, Intent paramIntent) {
    for (Map.Entry entry : this.b.entrySet())
      ((eh)entry.getKey()).a(paramContext, entry.getValue(), paramIntent); 
  }
  
  static ei[] a(Intent paramIntent) {
    null = paramIntent.getExtras();
    if (null != null) {
      Object[] arrayOfObject = (Object[])null.get("pdus");
      ei[] arrayOfEi = new ei[arrayOfObject.length];
      for (byte b = 0; b < arrayOfObject.length; b++) {
        SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])arrayOfObject[b]);
        ei ei = new ei();
        ei.a = smsMessage.getDisplayOriginatingAddress();
        ei.b = smsMessage.getDisplayMessageBody();
        ei.c = smsMessage.getTimestampMillis();
        arrayOfEi[b] = ei;
      } 
      return arrayOfEi;
    } 
    return null;
  }
  
  public void a(eh parameh) {
    this.b.remove(parameh);
  }
  
  public void a(Object paramObject, eh parameh) {
    this.b.put(parameh, paramObject);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if ("android.provider.Telephony.SMS_RECEIVED".equals(paramIntent.getAction())) {
      if (this.b.size() > 0) {
        a(paramContext, paramIntent);
        return;
      } 
    } else {
      return;
    } 
    Toast.makeText(paramContext, a(new StringBuilder(), paramIntent).toString(), 1).show();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */