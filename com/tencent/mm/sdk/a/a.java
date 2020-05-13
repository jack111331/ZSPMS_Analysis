package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.e;

public final class a {
  public static boolean a(Context paramContext, a parama) {
    boolean bool = false;
    if (paramContext == null || parama == null) {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
      return bool;
    } 
    if (e.j(parama.k)) {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + parama.k);
      return bool;
    } 
    if (e.j(parama.l))
      parama.l = parama.k + ".wxapi.WXEntryActivity"; 
    com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + parama.k + ", targetClassName = " + parama.l);
    Intent intent = new Intent();
    intent.setClassName(parama.k, parama.l);
    if (parama.n != null)
      intent.putExtras(parama.n); 
    String str = paramContext.getPackageName();
    intent.putExtra("_mmessage_sdkVersion", 570490883);
    intent.putExtra("_mmessage_appPackage", str);
    intent.putExtra("_mmessage_content", parama.m);
    intent.putExtra("_mmessage_checksum", b.a(parama.m, 570490883, str));
    if (parama.flags == -1) {
      intent.addFlags(268435456).addFlags(134217728);
    } else {
      intent.setFlags(parama.flags);
    } 
    try {
      paramContext.startActivity(intent);
      com.tencent.mm.sdk.b.a.d("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
      bool = true;
    } catch (Exception exception) {
      com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", new Object[] { exception.getMessage() });
    } 
    return bool;
  }
  
  public static final class a {
    public int flags = -1;
    
    public String k;
    
    public String l;
    
    public String m;
    
    public Bundle n;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */