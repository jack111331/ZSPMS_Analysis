package com.tencent.mm.opensdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.b.d;

public final class a {
  public static boolean a(Context paramContext, a parama) {
    String str1;
    String str2;
    if (paramContext == null) {
      str1 = "send fail, invalid argument";
      Log.e("MicroMsg.SDK.MMessage", str1);
      return false;
    } 
    if (d.a(parama.f)) {
      str1 = "send fail, action is null";
      Log.e("MicroMsg.SDK.MMessage", str1);
      return false;
    } 
    StringBuilder stringBuilder2 = null;
    if (!d.a(parama.e)) {
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(parama.e);
      stringBuilder2.append(".permission.MM_MESSAGE");
      str2 = stringBuilder2.toString();
    } 
    Intent intent = new Intent(parama.f);
    if (parama.d != null)
      intent.putExtras(parama.d); 
    String str3 = str1.getPackageName();
    intent.putExtra("_mmessage_sdkVersion", 603979778);
    intent.putExtra("_mmessage_appPackage", str3);
    intent.putExtra("_mmessage_content", parama.c);
    intent.putExtra("_mmessage_support_content_type", parama.g);
    intent.putExtra("_mmessage_checksum", b.a(parama.c, 603979778, str3));
    str1.sendBroadcast(intent, str2);
    StringBuilder stringBuilder1 = new StringBuilder("send mm message, intent=");
    stringBuilder1.append(intent);
    stringBuilder1.append(", perm=");
    stringBuilder1.append(str2);
    Log.d("MicroMsg.SDK.MMessage", stringBuilder1.toString());
    return true;
  }
  
  public static final class a {
    public String c;
    
    public Bundle d;
    
    public String e;
    
    public String f;
    
    public long g;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */