package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.e;

public final class a {
  public static boolean a(Context paramContext, a parama) {
    null = false;
    if (paramContext == null || parama == null) {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, invalid argument");
      return null;
    } 
    if (e.j(parama.p)) {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", "send fail, action is null");
      return null;
    } 
    String str1 = null;
    if (!e.j(parama.o))
      str1 = parama.o + ".permission.MM_MESSAGE"; 
    Intent intent = new Intent(parama.p);
    if (parama.n != null)
      intent.putExtras(parama.n); 
    String str2 = paramContext.getPackageName();
    intent.putExtra("_mmessage_sdkVersion", 570490883);
    intent.putExtra("_mmessage_appPackage", str2);
    intent.putExtra("_mmessage_content", parama.m);
    intent.putExtra("_mmessage_checksum", b.a(parama.m, 570490883, str2));
    paramContext.sendBroadcast(intent, str1);
    com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str1);
    return true;
  }
  
  public static final class a {
    public String m;
    
    public Bundle n;
    
    public String o;
    
    public String p;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */